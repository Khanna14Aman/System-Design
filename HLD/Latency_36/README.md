# Latency in System Design

## What is Latency?

Latency is the **total time taken for a request to travel from the client to the server and back with a response**. It measures the delay in a system and directly impacts user experience.

> Low latency = fast system. High latency = sluggish, poor user experience.

---

## Components of Latency

Every request goes through multiple delay stages:

| Component | Description |
|---|---|
| **Transmission Delay** | Time to push data into the network |
| **Processing Delay** | Time the server spends computing the response |
| **Queuing Delay** | Time the request waits before being processed |
| **Response Delay** | Time to send the response back to the client |
| **Round Trip Time (RTT)** | Full cycle — from request sent to response received |

```
Client --> [Transmission] --> Network --> [Queuing] --> Server [Processing]
       <-- [Response Delay] <-- Network <----------------------------------
```

---

## Types of Latency

### 1. Network Latency
Delay for data traveling between two points. Affected by:
- Physical distance between client and server
- Available bandwidth
- Network congestion

### 2. System Latency
The **overall delay** experienced by the user — includes network latency + server processing + client rendering. This is what end users actually feel.

---

## What Causes High Latency?

| Cause | Explanation |
|---|---|
| Network congestion | Too many requests competing for bandwidth |
| Bandwidth limitations | Bottleneck in data transmission speed |
| Geographical distance | Data has to travel farther between distributed nodes |
| Overloaded servers | Slow processing due to resource exhaustion |
| Inefficient DB queries | Slow or unindexed queries increase processing time |

---

## How to Measure Latency

| Tool | What it does |
|---|---|
| **Ping** | Measures Round Trip Time (RTT) |
| **Traceroute** | Maps data path and shows delay at each hop |
| **MTR** | Combines ping + traceroute for continuous monitoring |
| **Performance Profiling** | Tracks execution time within the application code |
| **APM Tools** | Monitor end-to-end latency and response times in production |

---

## Tail Latency (P95 / P99)

> "Tail latency refers to the worst-case response times, usually measured at the 95th or 99th percentile."

- **Average latency** can be misleading — a system might have good average but terrible worst-case.
- **P99 latency** = 99% of requests are faster than this value; the slowest 1% are outliers.
- Tail latency reveals hidden bottlenecks that average metrics hide.

```
P50 (median):  50ms   ← most users experience this
P95:          200ms   ← 5% of users experience this
P99:          800ms   ← 1% of users experience this (the "tail")
```

---

## How to Reduce Latency

| Strategy | How it helps |
|---|---|
| **CDN (Content Delivery Network)** | Serves data from edge nodes closer to the user |
| **Caching** | Avoids repeated processing for frequent requests |
| **Database query optimization** | Indexing, query rewriting to reduce DB processing time |
| **Data compression** | Smaller payloads = faster transmission |
| **Minimize network hops** | Route requests through fewer intermediate nodes |
| **Use nearest server** | Geographic routing reduces physical distance |
| **Async processing** | Offload non-critical work to background jobs |

---

## Latency vs Throughput

| | Latency | Throughput |
|---|---|---|
| Measures | Delay per request | Requests handled per second |
| Goal | Minimize | Maximize |
| Trade-off | Optimizing one can hurt the other |

> Example: Batching requests improves throughput but increases latency for individual requests.

---

## Use Cases by Domain

| Domain | Why Latency Matters |
|---|---|
| **E-commerce / Banking** | Slow pages = lost conversions and trust |
| **Gaming / VR** | Real-time responsiveness; even 100ms feels laggy |
| **Financial Trading** | Ultra-low latency (microseconds) for trade execution |
| **IoT / Smart Devices** | Timely sensor response is critical |
| **Healthcare** | Real-time feedback for telemedicine and robotic surgery |
| **Video Streaming** | Buffering and sync issues from high latency |

---

## Quick Recap

| Concept | One-liner |
|---|---|
| Latency | Total round-trip delay for a request |
| RTT | Time from request sent to response received |
| Tail latency | Worst-case latency at P95/P99 percentile |
| CDN | Reduces latency by serving from edge locations |
| Caching | Eliminates repeated computation/DB calls |
| Latency vs Throughput | Often a trade-off — optimizing one can hurt the other |
