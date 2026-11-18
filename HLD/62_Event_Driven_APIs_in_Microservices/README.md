# Event-Driven APIs in Microservices — Quick Notes

> Core EDA concepts already covered — see [6_Event_Driven_Architecture](../6_Event_Driven_Architecture/README.md) and [59_Event_Driven_Architecture_Deep_Dive](../59_Event_Driven_Architecture_Deep_Dive/README.md). Pub-Sub → [9_PubSub_Architecture](../9_PubSub_Architecture/README.md). Message queues → [45_Message_Queue](../45_Message_Queue/README.md). Event Sourcing → [60_Event_Sourcing_Pattern](../60_Event_Sourcing_Pattern/README.md). This note focuses on what's unique to the microservices context: **Saga Pattern, Choreography vs Orchestration, schema contracts, and implementation checklist**.

## What is it?
Event-Driven APIs let microservices communicate by publishing and consuming events instead of making direct synchronous calls. Services are fully decoupled — producers have no knowledge of consumers.

## Why it matters
- Tests whether you know when to choose async over sync communication in a microservices design.
- Saga Pattern and Choreography vs Orchestration are frequent follow-up questions once you mention EDA.
- Schema evolution and idempotency are the "hard parts" interviewers probe.

## Design Patterns (the four key ones)

| Pattern | How it works | Use for |
|---|---|---|
| **Publish-Subscribe** | Producers publish to topics; all subscribers get a copy | Fan-out — notify multiple services of the same event |
| **Saga Pattern** | Breaks a distributed transaction into local transactions; failure triggers compensating events | Multi-service transactions without a distributed lock |
| **Event-Driven Choreography** | Each service reacts to events and emits its own — no central controller | Fully decentralised, autonomous services |
| **CQRS** | Commands write via events; queries use separate read models | Systems needing independent scaling of reads and writes |

## Choreography vs Orchestration
| | Choreography | Orchestration |
|---|---|---|
| **Control** | Decentralised — each service reacts independently | Centralised — a coordinator (saga orchestrator) drives the flow |
| **Coupling** | Services know only about events, not each other | Services are told what to do by the coordinator |
| **Tracing** | Hard — flow is implicit across services | Easier — coordinator holds the full flow state |
| **Resilience** | No single point of failure | Coordinator can become a bottleneck |
| **Best for** | Simple, well-defined event flows | Complex, multi-step business workflows |

## Saga Pattern — deep cut
A Saga replaces a distributed ACID transaction with a sequence of local transactions, each publishing an event that triggers the next step.

```
Order Service          Payment Service        Inventory Service
     │                       │                       │
 OrderCreated ──────────►    │                       │
                       PaymentProcessed ─────────►   │
                                              StockReserved
                                              (saga complete)

On failure → compensating events flow backwards:
  StockReservationFailed → PaymentRefunded → OrderCancelled
```
- **Choreography-based Saga:** each service emits the next event on success/failure.
- **Orchestrator-based Saga:** a central saga orchestrator commands each service and handles rollback.

## Event Schema and Contracts
| Concern | Rule |
|---|---|
| **Schema definition** | Use Avro, Protobuf, or JSON Schema — agree on structure before building |
| **Schema registry** | Central store (e.g. Confluent Schema Registry) validates producer/consumer compatibility |
| **Backward compatibility** | New fields must be optional — consumers on old schema must not break |
| **Versioning** | Include a version field in the event; route old and new schemas to different handlers |

## Failure Handling
| Mechanism | Purpose |
|---|---|
| **Retry with backoff** | Transient failures — retry before declaring failure |
| **Dead Letter Queue (DLQ)** | Permanently failed events parked for manual inspection |
| **Idempotency** | Consumers must handle duplicate delivery safely (at-least-once is the norm) |
| **Circuit breaker** | Stop sending to a failing downstream; fail fast |
| **Compensating events** | Undo a completed local step when a downstream step fails (Saga rollback) |

## Implementation checklist (11 steps condensed)
1. Identify domain events (what happened, not what to do).
2. Define schemas and register them.
3. Choose infrastructure: Kafka / Pulsar / RabbitMQ / SNS+SQS.
4. Implement producers (publish on state change).
5. Implement consumers (idempotent handlers).
6. Add failure handling: retries, DLQ, circuit breakers.
7. Set up distributed tracing (correlation IDs across services).
8. Plan schema evolution strategy before v1 ships.
9. Secure topics: auth, encryption, access control per topic.
10. Scale: partition by key, consumer groups, back-pressure handling.
11. Test: unit (handler logic), integration (broker round-trip), chaos (consumer failure scenarios).

## Trade-offs
| Pro | Con |
|---|---|
| Loose coupling — add consumers without changing producers | Eventual consistency — no immediate read-your-write |
| Independent scaling per service | Duplicate events — consumers must be idempotent |
| Resilient to single service downtime | Ordering not guaranteed across partitions |
| Easy to add new subscribers later | Distributed tracing and debugging is harder |
| Async processing reduces latency spikes | Schema evolution requires careful coordination |

## When to use / avoid
- **Use when:** multiple services must react to the same event, operations are long-running or cross service boundaries, loose coupling and independent deployability are required.
- **Avoid when:** you need synchronous response (user-facing API calls), the workflow is simple enough for a single service, or the team can't yet handle the operational complexity.

## Real-world examples
- **E-commerce (Amazon):** Order placed → inventory, payment, shipping, notifications all consume independently via Kafka.
- **Banking:** Transaction events trigger fraud detection, ledger update, and statement generation in parallel.
- **Ride-sharing (Uber):** Ride lifecycle events drive driver matching, billing, and analytics simultaneously.
- **IoT:** Sensor events stream into processing pipelines for alerting, dashboards, and ML models.

## Common interview questions
- What is the Saga Pattern and how does it handle distributed transaction failures?
- What is the difference between choreography and orchestration in a Saga?
- How do you handle duplicate event delivery in a microservices system?
- How do you evolve an event schema without breaking existing consumers?
- When would you use synchronous REST over event-driven communication?
- How do you trace a request that spans multiple event-driven services?

## Golden rules (memorise these)
- **Events describe what happened** ("OrderPlaced"), not what to do ("ProcessOrder") — consumers decide their own reaction.
- **Sagas replace distributed transactions** — local commit + compensating event, not two-phase commit.
- **Choreography = implicit flow; Orchestration = explicit flow** — choreography is simpler until it isn't.
- **Design for at-least-once delivery** — idempotent consumers are non-negotiable.
- **Schema contracts are APIs** — breaking them is as bad as breaking a REST contract.
