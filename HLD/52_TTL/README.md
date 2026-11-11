# TTL — Quick Notes

## What is it?
**Time-To-Live (TTL)** defines how long data remains usable — in networking it limits the number of router hops a packet may traverse; in caching (DNS, HTTP, Redis) it specifies how long a stored entry is considered fresh before expiry or re-fetch.

## Why it matters
- TTL is the knob that controls **staleness vs. load** across DNS, HTTP caches, CDNs, and distributed stores — interviewers probe this trade-off constantly.
- Getting TTL wrong causes either stale data bugs (TTL too high) or thundering-herd / excessive resolver load (TTL too low).
- DNS migration, blue/green deployments, and cache invalidation strategies all hinge on TTL choices.

## Key Concepts
| Concept | One-liner |
|---|---|
| Network TTL | 8-bit IP header field; decremented by each router; packet dropped at 0 to prevent routing loops |
| DNS TTL | Seconds a DNS record is cached at resolvers before a fresh lookup is required |
| HTTP TTL | `Cache-Control: max-age=N` — seconds a browser/CDN may serve a cached response |
| Cache TTL | Expiry on distributed cache entries (Redis `EXPIRE`, Memcached) |
| ICMP Time Exceeded | Error sent back to sender when a packet's network TTL hits 0 |
| Traceroute | Tool that exploits incrementing TTL values to map each hop in a network path |
| Negative TTL | How long a failed lookup (NXDOMAIN) is cached before retrying |

## How it works (flow)

**Networking (packet hop limit)**
```
Packet sent with TTL = 64
  Router 1: TTL → 63, forwards
  Router 2: TTL → 62, forwards
  ...
  Router N: TTL → 0, discards packet, sends ICMP Time Exceeded to source
```

**DNS / Cache (freshness timer)**
```
1. Client queries resolver → resolver fetches record, caches it with TTL = 3600s
2. Subsequent queries served from cache (no upstream round trip)
3. At t = 3600s, TTL expires → cache entry evicted
4. Next query triggers fresh resolution → new TTL clock starts
```

## Trade-offs
| Long TTL | Short TTL |
|---|---|
| Fewer DNS / cache queries, lower load | More queries, higher resolver / origin load |
| Better cache hit rate, lower latency | Lower cache hit rate, higher latency on misses |
| Stale data persists longer after changes | Changes visible quickly |
| Cheap to operate at scale | Required for fast failover / migration |

## When to use / avoid
- **Long TTL (3600s+):** Stable records (main A/CNAME, static assets) — maximise cache efficiency.
- **Short TTL (60–300s):** Before DNS migrations, blue/green cutover, or any planned IP change — caches drain fast so the switch is near-instant.
- **Lower TTL 24–48 hrs before a DNS change** — give upstream caches time to adopt the new TTL before you flip the record.
- **Redis/Memcached TTL:** Set on session tokens, rate-limit counters, and feature-flag overrides to auto-expire without a manual delete.
- **Avoid TTL = 0:** Forces every request to origin — kills caching benefits; use `no-store` semantics only for genuinely uncacheable data.

## Common interview questions
- What is TTL in DNS and how does it affect record propagation time?
- What TTL would you set before a planned failover, and when would you change it back?
- How does network TTL prevent routing loops, and what tool exploits it to trace paths?
- What is the trade-off between a very short and a very long cache TTL?
- How does TTL interact with CDN caching and cache invalidation?

## Golden rules (memorise these)
- **Lower DNS TTL before migrations** — do it 24–48 hrs ahead; caches hold the old TTL until it expires, not until you change it.
- **TTL ≠ cache duration** — it's the *maximum* freshness window; caches may evict earlier due to memory pressure.
- **Network TTL prevents loops; cache TTL controls freshness** — two different uses of the same word.
- **Traceroute works by TTL exploitation** — sends packets with TTL=1, 2, 3… each dying one hop further, surfacing that router's IP via ICMP.
- **Short TTL = fast convergence, high load** — balance based on change frequency and origin capacity.
