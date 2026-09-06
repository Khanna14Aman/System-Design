# Throughput in System Design

## What is Throughput?

Throughput is the **rate at which a system successfully processes work over a given period of time**.

```
Throughput = Completed Units of Work ÷ Time
```

> Think of it as how much a highway can move — not how fast one car travels (that's latency), but how many cars pass a point per hour.

---

## Throughput Units by System Domain

| System | Unit |
|---|---|
| Web Server | Requests per second (RPS) |
| Database | Queries per second (QPS) |
| Message Queue | Messages per second |
| Network | Mbps / Gbps |
| CPU | Instructions per second (IPS) |
| Storage | Read/Write MB per second |

---

## Factors That Affect Throughput

| Factor | Impact |
|---|---|
| **Bandwidth** | Higher bandwidth allows more data to flow per second |
| **Processing Power** | More CPU/cores = more work processed per unit time |
| **Concurrency** | Handling multiple requests in parallel increases throughput |
| **I/O Speed** | Slow disk or network I/O creates a bottleneck that limits throughput |
| **Queue Depth** | A well-sized queue smooths bursts and keeps throughput steady |
| **Bottlenecks** | Any slow component in the pipeline caps the overall throughput |

---

## How to Measure Throughput

| Method | Description |
|---|---|
| **Load Testing Tools** | Tools like JMeter, k6, or Locust simulate traffic and measure RPS/QPS |
| **APM Tools** | Application Performance Monitoring tools (Datadog, New Relic) track throughput in real-time |
| **Database Query Logs** | Measure queries per second handled by the database |
| **Network Monitoring** | Tools like Wireshark or Prometheus measure bits/bytes per second |
| **Benchmarking** | Run controlled tests against the system to measure peak throughput |

---

## How to Improve Throughput

| Strategy | How it Helps |
|---|---|
| **Horizontal Scaling** | Add more servers to process requests in parallel |
| **Load Balancing** | Distribute requests evenly so no single server becomes a bottleneck |
| **Caching** | Serve repeated requests from cache instead of recomputing or querying the DB |
| **Asynchronous Processing** | Offload non-urgent work to background queues (e.g., Kafka, RabbitMQ) |
| **Database Optimization** | Indexing, query optimization, and connection pooling reduce DB processing time |
| **Batching** | Group multiple small operations into one larger operation to reduce overhead |
| **CDN** | Offload static content delivery to edge servers, freeing origin servers |
| **Compression** | Reduce payload size so more data can be transferred per second |

---

## Throughput vs Latency

| | Throughput | Latency |
|---|---|---|
| **Measures** | Work completed per unit time | Time for one request to complete |
| **Goal** | Maximize | Minimize |
| **Unit** | RPS, QPS, Mbps | Milliseconds (ms), seconds |
| **Analogy** | Cars per hour on a highway | Time one car takes to travel the road |

### The Trade-off
Throughput and latency are often **in tension** — optimizing one can hurt the other:

- **Batching** increases throughput by grouping work together, but individual requests wait longer → higher latency.
- **Low-latency routing** processes each request immediately, but limits how many can be handled concurrently → lower throughput.
- **Caching** improves both — but only for repeated, cacheable requests.

> Rule of thumb: **High-traffic systems** (analytics pipelines, data ingestion) optimize for throughput. **Interactive systems** (APIs, UI backends) optimize for latency.

---

## Real-World Examples

| System | Throughput Focus |
|---|---|
| **Netflix video streaming** | High throughput to deliver content to millions concurrently |
| **Payment gateway** | Balanced — low latency per transaction + high throughput during peak hours |
| **Log ingestion pipeline** | Maximize throughput — process millions of log events per second |
| **Search engine indexing** | High throughput — index billions of documents as fast as possible |
| **Chat application** | Low latency prioritized over throughput for real-time feel |

---

## Quick Recap

| Concept | One-liner |
|---|---|
| Throughput | Amount of work completed per unit time |
| RPS / QPS | Common units for web/database throughput |
| Bottleneck | Any slow component that caps overall throughput |
| Batching | Groups work together — boosts throughput, increases latency |
| Throughput vs Latency | Fundamental trade-off in system design |
