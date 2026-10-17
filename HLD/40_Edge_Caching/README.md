# Edge Caching — Quick Notes

## What is it?
Storing frequently accessed data on **edge servers** geographically close to users (e.g., CDN nodes) so requests never travel all the way to the origin server.

## Why it matters
- Directly cuts **latency** — data travels milliseconds, not hundreds of ms across continents.
- Shields the **origin/backend** from traffic spikes — edge absorbs the majority of reads.
- Critical for **global-scale systems** (streaming, gaming, e-commerce) where regional speed matters.

## Key Concepts
| Concept | One-liner |
|---|---|
| Edge Node | Distributed server geographically close to users |
| CDN | Network of edge nodes delivering content worldwide |
| Cache Hit | Request served from edge — no backend call |
| Cache Miss | Edge fetches from origin, stores locally, then serves |
| TTL | Time-To-Live — how long an entry stays valid |
| LRU / LFU | Eviction policies — remove least-recently or least-frequently used items |
| Cache Invalidation | Mechanism to purge stale data from edge nodes |

## How it works (flow)
```
Client → Edge Node
           ├── HIT  → serve immediately ✓
           └── MISS → fetch from Origin Server
                         → store on Edge Node
                         → serve to Client
```
1. Client sends request; nearest edge node is selected (GeoDNS / Anycast).
2. Edge checks its local cache (key = URL / resource ID).
3. **Hit** → respond directly. **Miss** → forward to origin.
4. Origin response is cached at edge with a TTL.
5. Subsequent requests served from edge until TTL expires or cache is invalidated.

## Trade-offs
| Pro | Con |
|---|---|
| Drastically lower latency | Cache consistency is hard across nodes |
| Reduces origin server load | Stale data risk if TTL is too long |
| Scales horizontally with more edge nodes | Management complexity grows with node count |
| Higher availability / redundancy | Edge nodes have limited storage |
| Saves bandwidth costs | Invalidation propagation can lag |

## When to use / avoid
- **Use when:** Static/semi-static content (images, videos, JS/CSS), globally distributed users, high read:write ratio, real-time streaming, gaming assets.
- **Avoid when:** Highly personalised/dynamic content, data that changes every request, strict consistency requirements (financial transactions).

## Common interview questions
- How does edge caching differ from a regular CDN?
- How do you handle cache invalidation across distributed edge nodes?
- What eviction policy would you choose for a video streaming platform and why?
- How would you design edge caching for a social media feed with mixed static/dynamic content?
- What happens during a cache stampede and how do you prevent it?

## Golden rules (memorise these)
- Edge caching trades **consistency** for **latency** — always discuss your TTL strategy.
- **Cache only reads** — writes always go to origin.
- **LRU** for general use; **LFU** when popularity is skewed (viral content).
- Invalidation strategy (push vs. poll) is a key design decision — push is faster but complex.
- Hit rate is your north-star metric: target **> 90%** for a well-tuned edge cache.
