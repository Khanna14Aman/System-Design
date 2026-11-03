# Rate Limiting — Quick Notes

## What is it?
A technique that **controls how many requests a client or system can make within a given time window** — rejecting or queuing excess requests to protect backend services from overload and abuse.

## Why it matters
- Prevents **DoS/DDoS attacks** and brute-force attempts from overwhelming services.
- Ensures **fair resource distribution** — no single client can monopolise capacity.
- Almost every large-scale system design question involves an API layer — expect "how do you prevent abuse?" to come up.

## Key Concepts
| Concept | One-liner |
|---|---|
| Token Bucket | Tokens refill at fixed rate; each request consumes one — allows controlled bursts |
| Leaky Bucket | Requests queue and drain at constant rate — smooths traffic, no bursts |
| Fixed Window | Count requests per fixed interval (e.g. 100/min); resets at window boundary |
| Sliding Window Log | Stores per-request timestamps; counts only those within the rolling window |
| Sliding Window Counter | Hybrid: weighted blend of current + previous window counts — accurate, low memory |
| HTTP 429 | Standard response code for "Too Many Requests" |
| Retry-After | Header returned with 429 telling the client when to retry |
| DLQ / Queue | Buffer excess requests instead of dropping — trades latency for throughput |

## How it works (flow)
```
Incoming Request
      │
      ▼
Rate Limiter (check counter / tokens)
      ├── WITHIN limit  → Forward to backend ✓
      └── OVER limit    → Return HTTP 429 (Too Many Requests)
                            (optionally queue or shed load)

Token Bucket internals:
  tokens += refill_rate × elapsed_time   (capped at bucket_max)
  if tokens >= 1: consume 1 token, allow request
  else: reject
```

## Trade-offs
| Pro | Con |
|---|---|
| Protects backend from overload | Overly strict limits cause false positives |
| Prevents abuse and DoS | Rate limiter itself can become a bottleneck |
| Fair usage across clients | Distributed rate limiting needs shared state (Redis) |
| Easy to return meaningful error (429) | Configuration tuning is complex under variable traffic |
| Token bucket allows natural bursts | Sliding window log is memory-heavy at high request rates |

## When to use / avoid
- **Use when:** Public APIs, login endpoints, payment flows, any endpoint exposed to untrusted clients.
- **Avoid (or tune carefully) when:** Internal service-to-service calls where you control both sides — overly aggressive limits cause unnecessary retries and latency.

## Common interview questions
- What are the differences between Token Bucket and Leaky Bucket? When would you choose each?
- How do you implement rate limiting in a distributed system with multiple API Gateway instances?
- How does a sliding window differ from a fixed window, and why is it more accurate?
- How would you rate-limit a login endpoint to prevent brute-force attacks?
- Where does rate limiting live in a microservices architecture — client, gateway, or service?

## Golden rules (memorise these)
- **Token Bucket = default** — allows controlled bursts (real traffic is bursty); Leaky Bucket for strict smoothing.
- **Fixed window has boundary spike problem** — a user can double their limit by hitting at t=59s and t=61s; sliding window fixes this.
- **Distributed = shared store** — rate limiter state must live in Redis (or similar) when you have multiple gateway instances.
- **Scope limits correctly** — per-user, per-IP, and per-endpoint limits serve different purposes; combine them.
- **Always return 429 + Retry-After** — gives clients the signal to back off gracefully instead of hammering.
