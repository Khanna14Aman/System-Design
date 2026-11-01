# API Gateway — Quick Notes

## What is it?
A **single entry point** that sits between clients and backend services — routing requests, enforcing security, rate limiting, and aggregating responses so clients don't talk directly to individual microservices.

## Why it matters
- Essential pattern in microservices architecture — without it, clients must know every service's address.
- Centralises cross-cutting concerns (auth, rate limiting, logging) so services stay lean.
- One of the most common system design building blocks — expect it in almost every distributed system question.

## Key Concepts
| Concept | One-liner |
|---|---|
| Routing | Directs request to correct backend service based on URL/method/header |
| Auth (AuthN/AuthZ) | Validates API keys, JWT, or OAuth 2.0 before forwarding |
| Rate Limiting | Caps requests per client/IP to protect backends from abuse |
| Request Aggregation | Fan-out to multiple services, merge responses into one reply |
| Protocol Translation | Converts HTTP/JSON → gRPC or other backend protocols |
| Caching | Stores repeated responses at gateway layer to reduce backend calls |
| Load Balancing | Distributes traffic across backend service instances |
| Circuit Breaker | Stops forwarding to a failing service to prevent cascade failures |

## How it works (flow)
```
Client
  │
  ▼
API Gateway
  ├── 1. Authenticate / Authorise request
  ├── 2. Apply rate limit check
  ├── 3. Route to target service (or fan-out to multiple)
  ├── 4. (Optional) Aggregate responses
  ├── 5. Return unified response to client
  │
  ▼
Backend Services (Service A, B, C...)
```

## Trade-offs
| Pro | Con |
|---|---|
| Single entry point — simplifies clients | Single point of failure if not made HA |
| Centralised auth, logging, rate limiting | Adds network hop → slight latency overhead |
| Hides backend topology from clients | Can become a bottleneck under heavy load |
| Enables protocol translation | Complex config management at scale |
| Easy A/B testing and canary routing | Business logic leak into gateway is an anti-pattern |

## When to use / avoid
- **Use when:** Microservices architecture, need centralised auth/rate limiting, multiple client types (mobile, web, IoT), API versioning required.
- **Avoid when:** Simple monolith with a single client — adds unnecessary complexity. Don't put business logic in the gateway.

## Common interview questions
- What is the difference between an API Gateway and a Load Balancer?
- How does an API Gateway handle authentication in a microservices system?
- What happens if the API Gateway goes down? How do you prevent it becoming a SPOF?
- How would you implement rate limiting at the API Gateway level?
- When would you use a Service Mesh instead of (or alongside) an API Gateway?

## Golden rules (memorise these)
- **Gateway = policy enforcement, not business logic** — keep routing/auth/rate-limit here; logic belongs in services.
- **Always deploy multiple instances** — a single gateway is a SPOF; put it behind a load balancer.
- **Gateway vs Load Balancer:** LB distributes traffic blindly; Gateway understands the request and applies rules.
- **Gateway vs Service Mesh:** Gateway handles North-South traffic (client ↔ services); Service Mesh handles East-West (service ↔ service).
- Popular tools: **Kong**, **AWS API Gateway**, **Apigee**, **Azure APIM**, **Apache APISIX**.
