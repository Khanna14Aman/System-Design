# Cold and Warm Cache — Quick Notes

## What is it?
A **cold cache** is empty or sparsely populated — most requests miss and hit the backend. A **warm cache** is pre-populated with frequently accessed data — most requests are served directly from cache with low latency.

## Why it matters
- Every cache starts cold — understanding this prevents surprise latency spikes at startup/deployment.
- Cache warming is a deliberate design decision in high-traffic systems (e.g., Black Friday prep, game launches).
- Interviewers probe this when asking about reliability, deployment strategies, and latency consistency.

## Key Concepts
| Concept | One-liner |
|---|---|
| Cold Cache | Cache with little/no useful data; high miss rate |
| Warm Cache | Cache populated with hot data; high hit rate |
| Cache Warming | Proactively preloading data before traffic hits |
| Cache Hit Rate | % of requests served from cache — higher = warmer |
| Cold Start | System initialisation state where cache is empty |
| Prefetching | Loading data into cache before it is requested |
| Working Set | The subset of data that is actively accessed |

## How it works (flow)
```
System starts → Cache is COLD (empty)
      │
      ↓
Requests arrive → mostly MISS → backend fetched → stored in cache
      │
      ↓
Over time → Cache warms up → hit rate rises
      │
      ↓
Cache is WARM → most requests served directly ✓

---- OR with intentional warming ----
Deploy → run warm-up job (prefetch top-N items) → cache ready before traffic hits
```

## Trade-offs
| Pro (Warm) | Con / Challenge |
|---|---|
| Low latency for users | Cold start unavoidable after restart/flush |
| Reduces backend/DB load | Warming takes time and resources |
| Consistent performance | Stale data risk if invalidation lags |
| Absorbs traffic spikes | Eviction can push out useful entries |
| Better user experience | Pre-warming cost (CPU, memory, time) |

## When to use / avoid
- **Warm up deliberately when:** High-traffic event expected (sale, launch), deploying new cache nodes, restoring after outage, rolling deployments where new instances start cold.
- **Prefetch selectively:** Only top-N hot items — warming everything wastes memory and time.
- **Avoid blind full-preload:** Prefetching rarely accessed data wastes cache space and slows warm-up.
- **Monitor hit rate** after deployment — a sudden drop signals a cold cache problem.

## Common interview questions
- How would you handle the cold start problem for a newly deployed cache node?
- How do you warm a cache before a major traffic event like a flash sale?
- What happens to cache hit rate during a rolling deployment and how do you mitigate it?
- How do you decide *what* to prefetch when warming a cache?
- How does Blue/Green deployment interact with cache warming?

## Golden rules (memorise these)
- **Every cache starts cold** — design for it, don't be surprised by it.
- **Warm proactively** before predictable traffic spikes; reactive warming causes user-visible latency.
- **Hit rate is your health metric** — a drop after deploy = cold cache, investigate immediately.
- **Prefetch the working set, not everything** — top 20% of data handles 80% of traffic (Pareto).
- **Canary/rolling deploys need warming strategy** — each new node starts cold and dilutes overall hit rate.
