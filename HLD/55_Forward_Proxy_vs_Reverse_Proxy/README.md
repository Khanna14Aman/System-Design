# Forward Proxy vs Reverse Proxy — Quick Notes

## What is it?
Both are intermediary servers that sit between two parties in a network, but they serve opposite directions: a **forward proxy** acts on behalf of **clients** (outbound), while a **reverse proxy** acts on behalf of **servers** (inbound).

## Why it matters
- This is one of the most common system design interview mix-ups — interviewers explicitly test whether you can tell them apart clearly.
- Reverse proxy is the building block of load balancers, API gateways, CDNs, and TLS termination — getting this wrong undermines your whole architecture answer.
- Forward proxy is how enterprises control and monitor outbound internet access — relevant for security and compliance design questions.

## Key Concepts
| Concept | One-liner |
|---|---|
| Forward Proxy | Sits between clients and the internet; acts for the client; controls outbound traffic |
| Reverse Proxy | Sits in front of backend servers; acts for the server; controls inbound traffic |
| TLS Termination | Reverse proxy decrypts HTTPS at the edge; forward proxy tunnels encrypted traffic through |
| IP Masking | Forward proxy hides client IP from destination; reverse proxy hides server IPs from clients |
| Load Balancing | Exclusive to reverse proxy — distributes inbound requests across a backend pool |
| Content Filtering | Forward proxy blocks URLs/categories based on org policy |
| Backend Abstraction | Reverse proxy ensures clients never see real server topology |

## How it works (flow)

**Forward Proxy (outbound)**
```
Client → [Forward Proxy] → Internet / External Server
  - Client is configured to route via proxy (explicit) or proxy intercepts silently (transparent)
  - Proxy applies access control / URL filtering
  - Proxy replaces client IP with its own in outbound request
  - Response routed back through proxy to client
```

**Reverse Proxy (inbound)**
```
Internet / Client → [Reverse Proxy] → Backend Servers
  - Client only ever sees proxy's IP/domain (server topology hidden)
  - Proxy terminates TLS, applies WAF + rate limiting
  - Selects backend via load-balancing algorithm
  - Returns response (optionally cached) to client
```

## Side-by-Side Comparison
| Aspect | Forward Proxy | Reverse Proxy |
|---|---|---|
| **Acts for** | Client | Backend servers |
| **Traffic direction** | Outbound (client → internet) | Inbound (internet → servers) |
| **Hides** | Client IP from servers | Server IPs / topology from clients |
| **Load balancing** | Not its purpose | Core function |
| **TLS handling** | Tunnels encrypted traffic | Terminates TLS connections |
| **Common tools** | Squid, corporate firewalls | NGINX, HAProxy, Cloudflare, AWS ALB |
| **Configured by** | Client / IT admin | Server / infrastructure team |
| **Use case** | Access control, content filtering | Load balancing, security, caching |

## Benefits
| Benefit | Forward Proxy | Reverse Proxy |
|---|---|---|
| **Security** | Blocks malicious outbound destinations | WAF, DDoS absorption at edge |
| **Privacy** | Masks client IP from external sites | Hides backend architecture |
| **Performance** | Caches popular external content | Caches backend responses closer to users |
| **Control** | Centrally enforces outbound policy | Centrally manages inbound routing |

## Trade-offs
| Pro | Con |
|---|---|
| Single control point for all traffic in that direction | Single point of failure if not made HA |
| Transparent to the other side (server or client) | Adds a network hop — marginal latency increase |
| Enables caching in both directions | Configuration complexity grows at scale |
| Decouples clients from servers (reverse proxy) | Proxy-to-backend may be unencrypted (trust the internal network or use mTLS) |

## When to use / avoid
- **Use forward proxy when:** enforcing corporate internet access policy, monitoring/logging outbound traffic, or hiding internal client IPs from external services.
- **Use reverse proxy when:** load balancing, TLS termination, rate limiting, WAF, caching, or hiding backend topology — nearly always in production.
- **Avoid single-instance proxies:** both types must be deployed in HA clusters — a single proxy is a SPOF.
- **Avoid using a forward proxy for inbound traffic:** it is not designed for load balancing or backend routing.

## Real-world examples
- **Squid (Forward):** Enterprise networks use it to filter and cache outbound HTTP/HTTPS traffic.
- **NGINX (Reverse):** Default reverse proxy for web apps; handles TLS, static files, and upstream routing.
- **HAProxy (Reverse):** High-performance TCP/HTTP load balancer used by GitHub, Airbnb.
- **Cloudflare (Reverse):** Global reverse proxy network — DDoS mitigation, WAF, CDN, and TLS at scale.
- **Zscaler (Forward):** Cloud-based forward proxy for enterprise zero-trust internet access.
- **AWS ALB (Reverse):** Managed reverse proxy/load balancer; routes HTTP/HTTPS to ECS, EC2, Lambda.

## Common interview questions
- What is the difference between a forward proxy and a reverse proxy?
- Can a server tell whether a request came through a forward proxy?
- How does TLS behave differently in a forward proxy vs a reverse proxy?
- In a microservices architecture, which type of proxy do you use and why?
- What is a transparent proxy and how does it differ from an explicit forward proxy?

## Golden rules (memorise these)
- **Forward proxy = hides the client. Reverse proxy = hides the server.**
- **Load balancing lives only in the reverse proxy** — forward proxies do not distribute server-side traffic.
- **TLS termination = reverse proxy only** — a forward proxy tunnels HTTPS without decrypting (unless doing SSL inspection).
- **Both can cache, but for different audiences** — forward proxy caches external content for internal users; reverse proxy caches backend responses for external users.
- **If you're designing an API gateway, CDN, or load balancer — you're describing a reverse proxy.**
