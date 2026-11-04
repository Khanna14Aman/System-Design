# Communication Protocols — Quick Notes

## What is it?
The agreed-upon rules that define **how services exchange data** in a distributed system. The two fundamental styles are **synchronous** (caller blocks and waits for a response) and **asynchronous** (caller sends and moves on, response comes later or not at all).

## Why it matters
- Every distributed system design question involves service-to-service communication — knowing when to pick sync vs. async separates good answers from great ones.
- Wrong choice causes cascading failures (sync coupling) or stale data surprises (async eventual consistency).
- Interviewers probe trade-offs: latency, coupling, ordering, and failure modes.

## Key Concepts
| Protocol / Style | Type | One-liner |
|---|---|---|
| HTTP/REST | Sync | Standard request-response over HTTP; stateless; widely supported |
| gRPC | Sync | Binary RPC over HTTP/2; high performance; contract-first (Protobuf) |
| GraphQL | Sync | Client specifies exact data shape; reduces over/under-fetching |
| WebSocket | Async (persistent) | Full-duplex; server can push; used for chat, live feeds |
| Message Queue (Kafka, RabbitMQ, SQS) | Async | Producer sends to queue; consumer pulls independently |
| Server-Sent Events (SSE) | Async (one-way push) | Server streams updates to browser; simpler than WebSocket |
| Webhook | Async (callback) | Server POSTs to a caller-registered URL when event occurs |

## How it works (flow)

**Synchronous (REST/gRPC)**
```
Client ──── request ───► Service
Client ◄─── response ─── Service
(Client blocks until response or timeout)
```

**Asynchronous (Message Queue)**
```
Producer ──► Queue (broker stores message)
                  │
             Consumer polls/receives
                  │
             Consumer processes (ACKs)
(Producer is free immediately after enqueue)
```

**WebSocket (bidirectional push)**
```
Client ──── HTTP Upgrade ───► Server
Client ◄════ persistent TCP ════► Server
(both sides can send at any time)
```

## Trade-offs
| Factor | Synchronous | Asynchronous |
|---|---|---|
| Latency | Immediate response | Delayed; processing happens later |
| Coupling | Tight — both must be up | Loose — sender/receiver independent |
| Scalability | Blocked threads under load | Queue buffers spikes naturally |
| Consistency | Strong — result known immediately | Eventual — state may lag |
| Debugging | Easier — single request trace | Harder — distributed trace across queue |
| Failure handling | Timeout + retry needed | DLQ + retry built into broker |

## When to use / avoid
- **Sync (REST/gRPC):** User-facing requests needing immediate results (auth, search, payments, CRUD reads).
- **Async (Queue/Events):** Background jobs, notifications, order processing, log ingestion, anything where the caller doesn't need to wait.
- **WebSocket/SSE:** Real-time UIs — chat, live dashboards, collaborative editing, gaming.
- **Webhook:** Notifying external systems of events (payment gateway callbacks, CI/CD triggers).
- **Avoid sync** across long chains of microservices — one slow service blocks the entire chain.
- **Avoid async** when the caller genuinely needs the result before proceeding (e.g., payment confirmation).

## Common interview questions
- When would you choose gRPC over REST?
- How do you handle a failure in a synchronous microservice chain?
- What is the difference between a message queue and a webhook?
- How does WebSocket differ from Server-Sent Events (SSE)?
- How would you design a notification system — sync or async, and why?

## Golden rules (memorise these)
- **Sync = tight coupling + immediate consistency; Async = loose coupling + eventual consistency** — match to requirements.
- **Async is not "better"** — it trades simplicity and consistency for scalability and resilience.
- **gRPC > REST for internal service-to-service** — faster, typed contracts, streaming support.
- **REST > gRPC for public APIs** — broader client support, human-readable.
- **Every async system needs a DLQ** — failed messages must not silently disappear.
- **WebSocket for bidirectional push; SSE for server-only push** — don't over-engineer.
