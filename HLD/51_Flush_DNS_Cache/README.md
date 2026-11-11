# Flush DNS Cache — Quick Notes

## What is it?
**Flushing the DNS cache** clears locally stored DNS records, forcing the OS or resolver to perform a fresh lookup the next time a domain is requested. It is a manual override of the TTL-based expiry mechanism.

## Why it matters
- DNS changes (migrations, failovers) propagate at TTL pace — flushing forces immediate adoption of new records without waiting for TTL to expire.
- Stale or corrupted cache entries are a common source of "site unreachable" bugs that developers overlook.
- Interviewers ask about DNS propagation delays and how to accelerate cutover — knowing when to flush (and when not to) is part of that answer.

## Key Concepts
| Concept | One-liner |
|---|---|
| DNS Cache | Local store of recently resolved domain → IP mappings |
| TTL (Time-To-Live) | Seconds a cached record stays valid before a fresh lookup is required |
| Stale Record | Cached entry whose IP no longer matches the current authoritative answer |
| OS Cache | System-level DNS cache shared across all applications on the machine |
| Browser Cache | Browser-internal DNS cache; separate from the OS cache — must be cleared independently |
| Upstream Resolver Cache | ISP / public resolver cache (8.8.8.8); **flush does not affect this** |
| Negative Cache | Cached NXDOMAIN (domain not found) response — flushing removes these too |

## How it works (flow)
```
1. DNS change applied at authoritative server (new A record, new IP)
2. Old record still cached at OS / browser / resolver layers (per TTL)
3. User or admin runs flush command on local machine:
   │
   ├── Windows: ipconfig /flushdns
   ├── macOS:   sudo dscacheutil -flushcache; sudo killall -HUP mDNSResponder
   └── Linux:   sudo resolvectl flush-caches   (systemd-resolved)
4. OS cache cleared — next request triggers fresh resolution chain
5. New IP returned from authoritative server, re-cached at new TTL
```

> **Note:** Flushing the local cache does NOT clear upstream resolver caches or the browser's internal DNS cache.

## Trade-offs
| Pro | Con |
|---|---|
| Immediately removes stale records on local machine | Causes temporary latency spike (fresh lookup needed) |
| Useful debugging step for DNS-related failures | Does not affect upstream resolver or CDN caches |
| Removes corrupted negative cache entries | Browser DNS cache requires a separate flush or browser restart |
| Faster cutover during planned DNS migrations | Has no effect if the issue is server-side or ISP-level |

## When to use / avoid
- **Use when:** DNS record changed and local machine still resolves to old IP; debugging name-resolution failures; post-migration validation on a specific machine.
- **Avoid as routine practice:** TTL expiry handles cleanup automatically — flushing spikes upstream resolver load if done at scale.
- **Never treat as a fix for:** Server downtime, authoritative DNS misconfigurations, ISP/connectivity issues, or security problems.

## Common interview questions
- Why does a DNS change not take effect immediately, and what can you do to accelerate it?
- What is the difference between flushing the OS DNS cache and the browser DNS cache?
- If you flush your local DNS cache after updating an A record, will all users see the new IP immediately? Why or why not?
- How does TTL interact with DNS cache flushing in a blue/green deployment?
- A user says "I updated the DNS record but my site still shows the old IP." What steps do you take?

## Golden rules (memorise these)
- **Flush = local fix only** — upstream resolvers (ISP, 8.8.8.8) hold their own caches and ignore your flush.
- **Lower TTL before migrations** — reduce TTL 24–48 hrs before a DNS change so caches drain fast at cutover; flushing individual machines is a last resort.
- **Browser DNS cache is separate** — `ipconfig /flushdns` does not clear Chrome or Firefox's internal cache.
- **Flush for debugging, not routine ops** — stale records are the exception; TTL handles the normal case.
- **Negative cache (NXDOMAIN) is also flushed** — useful when a domain was recently registered and the NXDOMAIN response was cached before DNS propagated.
