# Proxies — Quick Notes

## What is it?
A **proxy server** is an intermediary that sits between clients and servers, forwarding requests and responses on their behalf. It can mask identities, enforce policies, cache content, and distribute load depending on its position in the network.

## Why it matters
- Proxies are how large-scale systems control traffic flow in both directions — outbound (forward proxy) and inbound (reverse proxy); interviewers expect you to distinguish them clearly.
- Reverse proxies are the backbone of load balancing, TLS termination, and API gateway patterns — core building blocks in every distributed system design.
- Understanding proxies is prerequisite to understanding CDNs, API gateways, service meshes, and microservice communication.

## Types of Proxies
| Type | Position | Controls | Best for |
|---|---|---|---|
| **Forward Proxy** | Between clients and external internet | Outbound traffic | Enterprise access control, IP masking, content filtering |
| **Reverse Proxy** | In front of backend servers | Inbound traffic | Load balancing, TLS termination, caching, backend abstraction |
| **Transparent Proxy** | Intercepts without client configuration | Outbound traffic silently | ISP-level filtering, corporate monitoring |
| **Anonymous Proxy** | Hides client IP but identifies as proxy | Outbound traffic | Privacy-conscious browsing |
| **High-Anonymity Proxy** | Hides client IP and identity entirely | Outbound traffic | Full anonymity (TOR-style) |
| **Caching Proxy** | Stores responses locally | Inbound or outbound | Reducing origin load, speeding up repeated requests |
| **SSL/TLS Termination Proxy** | Decrypts HTTPS at edge | Inbound traffic | Offloading crypto from backend servers |

## Key Concepts
| Concept | One-liner |
|---|---|
| Forward Proxy | Client-side proxy; manages outbound requests; hides client identity |
| Reverse Proxy | Server-side proxy; manages inbound requests; hides backend topology |
| TLS Termination | Proxy decrypts HTTPS, forwards plain HTTP internally — offloads crypto from origin |
| Load Balancing | Reverse proxy distributes requests across backend pool using round-robin, least-conn, etc. |
| Caching | Proxy stores responses; cache hits skip the origin entirely |
| IP Masking | Forward proxy replaces client IP with its own in the request |
| Backend Abstraction | Reverse proxy hides internal server count, IPs, and topology from clients |
| Rate Limiting | Proxy enforces request quotas per client/IP before requests reach the backend |
| WAF (Web Application Firewall) | Reverse proxy inspects and filters malicious HTTP traffic (SQLi, XSS) |

## How it works (flow)

**Forward Proxy (client → proxy → internet)**
```
Client sends request to proxy
  Proxy applies access control / content filtering
  Proxy forwards request to target server (using proxy's IP, not client's)
  Response returned to proxy → forwarded to client
```

**Reverse Proxy (client → proxy → backend)**
```
Client sends request (sees only proxy's IP/domain)
  Reverse proxy terminates TLS
  Applies WAF, rate limiting, auth checks
  Selects backend server (load balancing algorithm)
  Forwards request → backend responds
  Proxy caches response (if cacheable), returns to client
```

## Benefits
| Benefit | Detail |
|---|---|
| **Security** | Centralised traffic inspection, WAF, DDoS absorption before reaching backends |
| **TLS offload** | Crypto handled at proxy; backends run plain HTTP internally |
| **Load balancing** | Single entry point distributes traffic across N servers |
| **Caching** | Repeated requests served from proxy cache; origin load drops |
| **Anonymity / IP masking** | Client IP hidden from destination (forward proxy) |
| **Backend abstraction** | Clients never see real server IPs; topology changes are invisible |
| **Access control** | Block URLs, enforce authentication, apply rate limits centrally |
| **Observability** | Centralised logging and metrics for all traffic |

## Trade-offs
| Pro | Con |
|---|---|
| Single choke-point for security and policy enforcement | Single point of failure if not made HA |
| Caching reduces origin load and latency | Adds a network hop — slight latency increase per request |
| Hides backend topology | Configuration complexity grows with scale |
| Enables zero-downtime deploys via traffic shifting | Proxy becomes bottleneck at very high throughput without horizontal scaling |
| TLS termination centralises cert management | Proxy-to-backend traffic may be unencrypted (internal trust assumption) |

## When to use / avoid
- **Use reverse proxy when:** you need load balancing, TLS termination, rate limiting, or caching in front of your services — nearly always in production.
- **Use forward proxy when:** you need to control/monitor outbound internet access in an enterprise or data centre.
- **Avoid a single proxy instance:** always run proxies in HA pairs or clusters; a single proxy is the SPOF it was meant to eliminate.
- **Avoid transparent forward proxies for sensitive traffic:** they intercept without consent and create legal/compliance risks.

## Real-world examples
- **NGINX:** Most common reverse proxy; used for load balancing, static file serving, and TLS termination at scale.
- **HAProxy:** High-performance TCP/HTTP load balancer used by GitHub, Reddit for millions of connections.
- **Cloudflare:** Global reverse proxy / CDN that terminates TLS, filters DDoS, and caches at the edge for millions of sites.
- **Squid:** Forward proxy widely used in enterprise networks for URL filtering and caching outbound HTTP.
- **Envoy / Istio:** Sidecar reverse proxy in service meshes; handles mTLS, retries, circuit breaking between microservices.
- **AWS API Gateway:** Managed reverse proxy for serverless and microservice APIs — routing, auth, rate limiting as a service.

## Common interview questions
- What is the difference between a forward proxy and a reverse proxy?
- How does a reverse proxy enable zero-downtime deployments?
- Where does TLS terminate in a system that uses a reverse proxy, and what are the security implications?
- How would you make a reverse proxy highly available?
- What is the difference between a reverse proxy and a load balancer?
- How does a service mesh (Envoy/Istio) differ from a traditional reverse proxy?

## Golden rules (memorise these)
- **Forward proxy = hides the client; reverse proxy = hides the server.**
- **Reverse proxy is not the same as a load balancer** — all load balancers are reverse proxies, but not all reverse proxies do load balancing.
- **TLS terminates at the proxy** — backend traffic is usually plain HTTP; trust the internal network or add mTLS for defense-in-depth.
- **Proxy = SPOF unless clustered** — always deploy in HA mode; the proxy protecting your servers can't be the weakest link.
- **Caching at the proxy is free latency** — any idempotent response with a TTL should be cached as close to the client as possible.
