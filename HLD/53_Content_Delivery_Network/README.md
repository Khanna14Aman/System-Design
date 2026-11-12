# Content_Delivery_Network — Quick Notes

## What is it?
A **Content Delivery Network (CDN)** is a globally distributed network of edge servers (PoPs) that cache and serve content close to end users, eliminating the need to fetch every request from a distant origin server.

## Why it matters
- Latency and availability are top-tier system design concerns — CDN is the standard answer for both when serving global traffic.
- Cache invalidation across distributed nodes is one of the hardest problems in distributed systems — interviewers test whether you understand the trade-off.
- CDNs double as a security layer (DDoS mitigation, WAF, TLS termination) — knowing this separates strong answers from surface-level ones.

## Key Concepts
| Concept | One-liner |
|---|---|
| Edge Server / PoP | Geographically distributed cache node that serves users from the nearest location |
| Origin Server | Primary source of truth — only hit on a cache miss |
| Cache Hit | Edge serves content directly without contacting origin |
| Cache Miss | Edge fetches from origin, stores response, serves user |
| Pull CDN | Edge fetches content on-demand on first miss, caches it for future requests |
| Push CDN | Content pre-loaded to edges proactively before users request it |
| Cache Invalidation | Process of clearing or updating stale cached content across all edges |
| TTL | How long an edge caches a response before checking origin for freshness |
| WAF / DDoS | Security services co-located at edge — absorb attacks before they reach origin |

## How it works (flow)
```
User requests resource (e.g. image, JS bundle, video)
        │
        ▼
CDN routing (DNS-based or anycast) → nearest edge PoP
        │
        ├── Cache HIT  → serve directly from edge  ✓  (fast)
        │
        └── Cache MISS → fetch from origin
                │
                ▼
           Cache response at edge (per TTL / Cache-Control)
           Serve to user ✓
           Future requests → HIT
```

## Trade-offs
| Pro | Con |
|---|---|
| Dramatically reduces latency for global users | Cache invalidation is complex and slow to propagate |
| Offloads origin — handles traffic spikes at edge | Cost scales with traffic and feature usage |
| Improves availability (edge serves even if origin is down) | Stale content risk if TTL or invalidation is misconfigured |
| Built-in DDoS, WAF, TLS termination at edge | Dynamic / personalised content is hard to cache safely |
| Pull CDN requires no pre-warming | Push CDN requires pre-distribution logic and storage |

## When to use / avoid
- **Use for:** Static assets (images, CSS, JS), video streaming, software downloads, public API responses, anything cacheable and globally consumed.
- **Pull CDN:** Best for most web apps — simple setup, caches on first request, no pre-warming needed.
- **Push CDN:** Best for large files known in advance (video, software releases) — avoids cold-start misses at launch.
- **Avoid caching:** User-specific data (authenticated responses, shopping carts), real-time feeds, or anything that must be instantly consistent after updates.
- **Avoid relying on CDN alone for HA** — if origin is down and TTL has expired, edge cannot serve stale content; combine with origin redundancy.

## Common interview questions
- How does a CDN reduce latency, and how does request routing work?
- What is the difference between a Pull CDN and a Push CDN? When would you use each?
- How do you handle cache invalidation in a CDN after a deployment?
- How would you serve dynamic, personalised content via a CDN safely?
- How does a CDN help with DDoS protection?

## Golden rules (memorise these)
- **CDN = cache at the edge** — put content physically close to users; every cache hit avoids an origin round trip.
- **Pull CDN is the default** — simple, self-warming, works for virtually all web static content.
- **Cache invalidation is the hard part** — use versioned URLs (content-hash filenames) for static assets so old and new versions coexist without stale bugs.
- **Never cache authenticated or user-specific responses** — vary by `Authorization` header or bypass CDN entirely for those routes.
- **CDN ≠ availability guarantee** — edge can serve stale content while origin is down only if TTL hasn't expired; pair with resilient origin infrastructure.
- **TLS termination at edge** — CDN decrypts, inspects, then forwards to origin over internal network; reduces TLS overhead on origin.
