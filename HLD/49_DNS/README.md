# DNS — Quick Notes

## What is it?
The **Domain Name System (DNS)** is a hierarchical, distributed system that translates human-readable domain names (e.g. `www.example.com`) into IP addresses that machines use to communicate. It is the internet's "phone book."

## Why it matters
- DNS is the entry point of every web request — understanding its resolution chain is foundational for system design.
- TTL and caching decisions directly affect **deployment speed, failover time, and traffic routing** (GeoDNS, blue/green, CDN).
- Interviewers expect you to explain DNS when discussing global traffic routing, CDN setup, or disaster recovery.

## Key Concepts
| Concept | One-liner |
|---|---|
| DNS Resolver | Client-side intermediary that orchestrates the full lookup |
| Root Name Server | Top of the hierarchy; directs resolver to the correct TLD server |
| TLD Server | Handles `.com`, `.org`, etc.; points to authoritative server |
| Authoritative Server | Owns the zone; returns the actual IP for the domain |
| TTL (Time-To-Live) | How long a resolved record is cached (seconds) |
| A Record | Maps domain → IPv4 address |
| CNAME Record | Alias — maps one domain name to another |
| MX Record | Specifies mail server for the domain |
| PTR Record | Reverse lookup — IP → domain name |
| GeoDNS | Returns different IPs based on requester's location |

## How it works (flow)
```
Browser checks local cache → HIT → done ✓
                           → MISS ↓
DNS Resolver (ISP)
  │
  ├── 1. Query Root Server  → "try .com TLD server at X"
  ├── 2. Query TLD Server   → "try authoritative server at Y"
  └── 3. Query Authoritative Server → returns IP address
         │
         ▼
  Resolver caches result (per TTL) → returns IP to browser
  Browser connects to IP ✓
```

## Trade-offs
| Pro | Con |
|---|---|
| Distributed — no single point of failure | Propagation delay when records change (TTL lag) |
| Caching reduces latency for repeat lookups | Stale cache during failover if TTL too high |
| GeoDNS enables global traffic routing | DNS hijacking / poisoning is a security risk |
| Scales to billions of queries globally | Recursive resolution adds multiple round trips on cold start |
| Short TTL allows fast failover | Short TTL increases resolver load and latency |

## When to use / avoid
- **GeoDNS:** Route users to the nearest data centre or CDN PoP — essential for global systems.
- **Low TTL (60–300s):** Use during deployments or failovers when you need fast switchover.
- **High TTL (3600s+):** Use for stable, rarely-changing records — reduces resolver load.
- **CNAME for flexibility:** Point to a load balancer or CDN hostname rather than a hard-coded IP.
- **Avoid relying on DNS alone for sub-second failover** — TTL lag means DNS is not suitable as your only HA mechanism.

## Common interview questions
- Walk me through what happens when you type `google.com` in a browser.
- What is the difference between a recursive and an iterative DNS query?
- How does GeoDNS work and how would you use it to route traffic across regions?
- What TTL would you set for a record during a blue/green deployment, and why?
- How does a CDN use DNS to direct users to the nearest edge server?

## Golden rules (memorise these)
- **DNS is eventually consistent** — TTL determines how stale a cached record can be.
- **Lower TTL before a migration** — reduce it 24 hrs ahead so caches expire fast when you switch.
- **CNAME chains add latency** — keep them short; A records are faster for leaf hostnames.
- **GeoDNS ≠ load balancing** — it routes by location, not by server health; combine with health checks.
- **Root servers are anycast** — there are only 13 root server IP addresses but hundreds of physical nodes worldwide.
