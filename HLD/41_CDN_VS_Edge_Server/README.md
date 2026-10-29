# CDN vs Edge Server — Quick Notes

## What is it?
A **CDN** is a *network* of geographically distributed servers that cache and deliver content close to users. An **Edge Server** is a *single* server/resource placed near users that can cache, route, filter, or process — it may or may not be part of a CDN.

## Why it matters
- Interviewers often use CDN and edge server interchangeably — knowing the difference shows depth.
- CDN = infrastructure strategy; Edge Server = individual compute unit — different layers of abstraction.
- Edge computing is expanding beyond CDN (IoT, real-time ML inference) — knowing edge servers independently matters.

## Key Concepts
| Concept | One-liner |
|---|---|
| CDN | Network of PoPs (Points of Presence) delivering cached content globally |
| Edge Server | Single server at a PoP — the actual machine serving the request |
| PoP | Physical data centre location within a CDN |
| Cache Hit | Content found at edge — no origin call needed |
| Cache Miss | Edge fetches from origin server and caches for future requests |
| Origin Server | Central server that holds the source-of-truth data |
| TTL | How long cached content stays valid before re-fetching from origin |
| Reverse Proxy | Edge server role — sits in front of origin, intercepts requests |

## How it works (flow)
```
CDN Flow:
User → DNS (GeoDNS resolves to nearest PoP)
     → CDN Edge Server
          ├── HIT  → serve from cache ✓
          └── MISS → fetch from Origin → cache it → serve

Edge Server (standalone):
User / IoT Device → Edge Server → process / filter / route locally
                                → forward to cloud only if needed
```

## Trade-offs
| Aspect | CDN | Edge Server (standalone) |
|---|---|---|
| **Scope** | Global network of locations | Single location |
| **Best for** | Static/cacheable content at scale | Dynamic processing, IoT, low-latency compute |
| **Complexity** | Managed by provider (Cloudflare, Akamai) | Operator manages each node |
| **Cost** | Traffic-based pricing, can be high | Hardware + ops cost per location |
| **Dynamic content** | Limited (complex to configure) | Native — runs code locally |
| **Cache invalidation** | Harder across many nodes | Easier, localised |

## When to use / avoid
- **Use CDN when:** Serving static assets (images, video, JS/CSS) globally; high-traffic websites; software downloads; API acceleration.
- **Use Edge Server when:** IoT data processing close to sensors; real-time personalisation; security filtering before hitting origin; low-latency gaming.
- **Avoid CDN when:** Content is highly dynamic and personalised per user (every request is unique — no caching benefit).
- **Avoid standalone Edge when:** You need global reach — one edge location won't cut it; use a CDN instead.

## Common interview questions
- What is the difference between a CDN and an edge server?
- When would you use an edge server over a CDN for an IoT system?
- How does a CDN handle cache invalidation across hundreds of PoPs?
- Design a video streaming platform — where does CDN fit and where do edge servers fit?
- How does GeoDNS help CDNs route users to the nearest PoP?

## Golden rules (memorise these)
- **CDN ⊇ Edge Server** — every CDN uses edge servers, but not every edge server is part of a CDN.
- CDN optimises **delivery**; Edge computing optimises **processing**.
- Cache only **reads** — writes always bypass the CDN and go straight to origin.
- A high **cache hit rate (> 90%)** is the goal — low hit rate means wasted CDN spend.
- Dynamic content needs **edge logic** (Cloudflare Workers, Lambda@Edge), not just static caching.
