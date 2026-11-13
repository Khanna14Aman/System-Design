# Forward Proxy vs Reverse Proxy — Quick Notes

> See also: [Proxies](../54_Proxies/README.md) for types, key concepts, how each proxy works, benefits, trade-offs, when to use, and real-world examples.

## What is it?
Both are intermediary servers that sit between two parties in a network, but they serve opposite directions: a **forward proxy** acts on behalf of **clients** (outbound), while a **reverse proxy** acts on behalf of **servers** (inbound).

## Why it matters
- This is one of the most common system design interview mix-ups — interviewers explicitly test whether you can tell them apart clearly.
- Reverse proxy is the building block of load balancers, API gateways, CDNs, and TLS termination — getting this wrong undermines your whole architecture answer.
- Forward proxy is how enterprises control and monitor outbound internet access — relevant for security and compliance design questions.

## Side-by-Side Comparison
| Aspect | Forward Proxy | Reverse Proxy |
|---|---|---|
| **Acts for** | Client | Backend servers |
| **Traffic direction** | Outbound (client → internet) | Inbound (internet → servers) |
| **Hides** | Client IP from servers | Server IPs / topology from clients |
| **Load balancing** | Not its purpose | Core function |
| **TLS handling** | Tunnels encrypted traffic | Terminates TLS connections |
| **Common tools** | Squid, corporate firewalls, Zscaler | NGINX, HAProxy, Cloudflare, AWS ALB |
| **Configured by** | Client / IT admin | Server / infrastructure team |
| **Use case** | Access control, content filtering | Load balancing, security, caching |

## Common interview questions
- What is the difference between a forward proxy and a reverse proxy?
- Can a server tell whether a request came through a forward proxy?
- How does TLS behave differently in a forward proxy vs a reverse proxy?
- In a microservices architecture, which type of proxy do you use and why?
- What is the difference between a transparent proxy and an explicit forward proxy?

## Golden rules (memorise these)
- **Forward proxy = hides the client. Reverse proxy = hides the server.**
- **Load balancing lives only in the reverse proxy** — forward proxies do not distribute server-side traffic.
- **TLS termination = reverse proxy only** — a forward proxy tunnels HTTPS without decrypting (unless doing SSL inspection).
- **Both can cache, but for different audiences** — forward proxy caches external content for internal users; reverse proxy caches backend responses for external users.
- **If you're designing an API gateway, CDN, or load balancer — you're describing a reverse proxy.**
