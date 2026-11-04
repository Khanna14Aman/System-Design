# Rate Limiting Algorithms — Quick Notes

## What is it?
Algorithms that **control how many requests a client can make within a time window** — each uses a different mechanism to track, allow, or reject excess requests. Choosing the right one involves trading off accuracy, memory, burst tolerance, and implementation complexity.

## Why it matters
- Every rate-limiting system is built on one of these four algorithms — interviewers expect you to compare them.
- The choice directly affects **burst behaviour**, **memory usage**, and **boundary-spike vulnerabilities**.
- Distributed deployments add an extra dimension: all instances must share state.

## Key Concepts
| Algorithm | Core Mechanism | Burst? | Memory |
|---|---|---|---|
| **Token Bucket** | Tokens refill at fixed rate; each request consumes one | Yes (accumulated tokens) | Low (counter per client) |
| **Leaky Bucket** | Requests drain from queue at constant rate | No (smoothed) | Medium (queue per client) |
| **Fixed Window** | Count resets at fixed interval boundary | Boundary spike risk | Very low |
| **Sliding Window Log** | Stores timestamp of every request; counts within rolling window | No | High (one entry per request) |
| **Sliding Window Counter** | Weighted blend of current + previous window counts | No | Low (two counters per client) |

## How it works (flow)

**Token Bucket**
```
Tokens += refill_rate × elapsed_time  (capped at bucket_max)
if tokens >= 1 → consume 1, allow request
else           → reject (HTTP 429)
```

**Leaky Bucket**
```
Request arrives → add to queue (if space)
Queue drains at constant rate → process one per tick
Queue full → reject request
```

**Fixed Window**
```
[window start]──────────────[window end] → counter resets
counter < limit → allow; counter >= limit → reject
⚠️ Boundary spike: 5 req at t=0:59 + 5 req at t=1:01 = 10 req in 2s on a 5/min limit
```

**Sliding Window Log**
```
On each request:
  1. Remove timestamps older than (now - window)
  2. Count remaining timestamps
  3. count < limit → add timestamp, allow
  4. count >= limit → reject
```

## Trade-offs
| Algorithm | Pro | Con |
|---|---|---|
| Token Bucket | Allows natural bursts; low memory | Config complexity; large bucket can spike backend |
| Leaky Bucket | Smooth consistent throughput | No burst tolerance; added latency queuing |
| Fixed Window | Simplest to implement; minimal memory | Boundary burst vulnerability |
| Sliding Window Log | Most accurate; no boundary spikes | High memory at scale (timestamp per request) |
| Sliding Window Counter | Accurate + memory-efficient | Slightly approximate (weighted average) |

## When to use / avoid
- **Token Bucket** → APIs with bursty traffic (default choice for most systems).
- **Leaky Bucket** → Downstream services needing constant input rate (payment processors, queues).
- **Fixed Window** → Simple internal tools where boundary spikes are acceptable.
- **Sliding Window Log** → High-precision enforcement where memory cost is tolerable.
- **Sliding Window Counter** → Distributed systems needing accuracy without high memory (Redis-friendly).
- **Avoid Fixed Window** in public-facing APIs — boundary spike is a real exploit vector.

## Common interview questions
- What is the boundary burst problem in Fixed Window and how does Sliding Window solve it?
- Compare Token Bucket vs Leaky Bucket — when would you use each?
- How do you implement a distributed rate limiter across multiple API Gateway instances?
- How does the Sliding Window Counter algorithm work and why is it memory-efficient?
- How would you rate-limit per-user AND per-IP simultaneously?

## Golden rules (memorise these)
- **Token Bucket = default** — handles real-world bursty traffic gracefully.
- **Fixed Window has the boundary-spike bug** — never use it for security-sensitive endpoints.
- **Sliding Window Counter = best balance** of accuracy and memory in distributed systems.
- **Distributed = shared state** — store counters/tokens in Redis with atomic operations (INCR + EXPIRE).
- **Scope matters** — combine per-user, per-IP, and per-endpoint limits for layered protection.
- **Always return HTTP 429 + Retry-After header** so clients back off correctly.
