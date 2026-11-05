# DNS Caching — Quick Notes

## What is it?
**DNS caching** temporarily stores previously resolved DNS records at multiple layers (browser, OS, resolver) so that future lookups for the same domain skip the full resolution chain and return instantly from the nearest cache.

## Why it matters
- DNS resolution happens on every new connection — caching is what makes the internet feel fast at scale.
- TTL strategy is a direct lever on **deployment speed, failover time, and consistency** — interviewers expect you to know the trade-off.
- Cache poisoning is a real attack vector — knowing DNSSEC and validation matters for security discussions.

## Key Concepts
| Concept | One-liner |
|---|---|
| TTL (Time-To-Live) | Seconds a cached record remains valid before a fresh lookup is required |
| Browser Cache | First cache checked — lives in the browser process itself |
| OS / Stub Resolver Cache | System-level cache shared across all apps on the machine |
| Recursive Resolver Cache | ISP or public resolver (8.8.8.8) caches responses for all its clients |
| Negative Caching | Caches NXDOMAIN (domain not found) responses to avoid repeated failed lookups |
| Cache Poisoning | Attack that injects forged records into a resolver's cache |
| DNSSEC | Cryptographic signatures on DNS records to verify authenticity |

## How it works (flow)
```
Request for example.com
  │
  ├─ 1. Browser cache?          → HIT → return IP ✓
  ├─ 2. OS / stub resolver?     → HIT → return IP ✓
  ├─ 3. Recursive resolver?     → HIT → return IP ✓
  └─ 4. Full resolution chain   → Root → TLD → Authoritative
              │
              ▼
         Response cached at each layer with its TTL
         Future requests served from cache until TTL expires
```

## Trade-offs
| Pro | Con |
|---|---|
| Drastically reduces resolution latency | Stale records persist until TTL expires |
| Offloads load from authoritative servers | Short TTL increases resolver load and latency |
| Improves scalability for repeated lookups | Cache poisoning risk if resolver is misconfigured |
| Negative caching prevents repeated failed queries | Propagation delay when changing DNS records |

## When to use / avoid
- **Long TTL (3600s+):** Stable records (main A/CNAME) that rarely change — reduces resolver load.
- **Short TTL (60–300s):** Before migrations, blue/green deployments, or failover scenarios — enables fast cutover.
- **Lower TTL 24–48 hrs before any DNS change** — gives caches time to drain so the switch is near-instant.
- **Avoid flushing caches routinely** — do it only during debugging; it spikes upstream resolver load.
- **Never rely on DNS caching alone for sub-second failover** — health checks + load balancers handle that layer.

## Common interview questions
- How does DNS caching work across browser, OS, and resolver layers?
- What is TTL and how does it affect DNS record propagation time?
- What TTL would you set before a planned DNS failover, and when would you set it?
- What is DNS cache poisoning and how is it prevented?
- How does negative caching help performance and what are its risks?

## Golden rules (memorise these)
- **Lower TTL before migrations** — change TTL 24–48 hrs ahead so existing caches expire fast at cutover.
- **Caching ≠ immediate consistency** — DNS changes propagate at TTL pace, not instantly.
- **Resolver cache is shared** — one resolver serves millions of clients; its cache hit saves them all a round trip.
- **DNSSEC prevents poisoning** — digital signatures ensure clients reject forged records.
- **Negative cache (NXDOMAIN) also has a TTL** — failed lookups are cached too; don't forget this when debugging.
