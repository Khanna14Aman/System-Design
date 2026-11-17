# Event Sourcing vs Event Streaming — Quick Notes

> See also: [60_Event_Sourcing_Pattern](../60_Event_Sourcing_Pattern/README.md) for a deep-dive on Event Sourcing, and [59_Event_Driven_Architecture_Deep_Dive](../59_Event_Driven_Architecture_Deep_Dive/README.md) for the broader event-driven landscape.

## What is each?

| | Event Sourcing | Event Streaming |
|---|---|---|
| **Definition** | Persistence pattern — store every state change as an immutable event; current state = replay | Transport/processing pattern — events are continuously published to a stream and consumed in real time |
| **Core question it answers** | "What happened to this record over time?" | "What is happening right now, and who needs to react?" |
| **Source of truth?** | Yes — the event log IS the database | No — it's a pipe; consumers maintain their own state |

## Why it matters (interview angle)
- Tests whether you know the difference between *storing* events and *moving* events.
- Common trap: candidates conflate Kafka (streaming) with Event Sourcing — they are different layers.
- Both can be used together, but each solves a different problem.

## Head-to-head comparison
| Aspect | Event Sourcing | Event Streaming |
|---|---|---|
| **Purpose** | Durably persist state history | Transport and process events across services |
| **Retention** | Permanent — full history kept forever | Configurable window (hours → days → indefinite) |
| **Replay** | Core feature — rebuild state at any point in time | Supported via offsets, but not the primary purpose |
| **Latency** | Variable; depends on replay optimisation | Near real-time |
| **Consumers** | Typically one system rebuilding its own state | Many independent consumers reading the same stream |
| **Recovery** | Replay from event 0 (or from a snapshot) | Seek to last committed offset/checkpoint |
| **Technology** | EventStoreDB, custom event store on Postgres/DynamoDB | Apache Kafka, Apache Pulsar, Amazon Kinesis |

## Key Concepts
| Concept | One-liner |
|---|---|
| **Append-only log** | Shared mechanism — both patterns write immutably |
| **Offset / checkpoint** | Streaming consumer's bookmark in the stream |
| **Snapshot** | Event Sourcing optimisation: periodic saved state so replay doesn't start at event 0 |
| **Consumer group** | Streaming: multiple instances share load; each event processed once per group |
| **Projection** | Event Sourcing: read model built by replaying events |

## When to use which

**Event Sourcing** — use when:
- A full, tamper-evident audit trail is required (finance, healthcare, legal).
- You need to reconstruct past state ("what was the account balance on Nov 1st?").
- Domain events have intrinsic business value beyond just communication.

**Event Streaming** — use when:
- Multiple services need real-time notification of the same events.
- You need loose coupling between producers and consumers.
- Analytics, monitoring, or ML pipelines consume the same event flow.

## When to use both together
The two are complementary, not competing:
```
Command → Aggregate (Event Sourcing write side)
        ↓ emit event
    Event Store  ──publish──→  Kafka/Kinesis  ──→  Downstream services
    (source of truth)          (transport)          (react in real time)
```
- Event Sourcing owns durability and state reconstruction.
- Event Streaming distributes events to external consumers without coupling them to the event store.

## Real-world examples
- **Banking:** Account balance stored via Event Sourcing (ledger of transactions); Kafka streams fraud-detection and analytics events in real time.
- **Ride-sharing:** Ride lifecycle (Requested → Assigned → Completed) sourced as events; Kafka broadcasts to driver-app, billing, and analytics simultaneously.
- **E-commerce:** Order state managed by Event Sourcing; Kafka notifies warehouse, shipping, and email services.

## Common interview questions
- What is the difference between Event Sourcing and Event Streaming?
- Can Kafka be used as an event store? What are the trade-offs?
- How do you use Event Sourcing and Event Streaming together in the same system?
- What happens when a streaming consumer falls behind? How does it recover vs an Event Sourcing replay?
- Why is Event Sourcing not just "Kafka with infinite retention"?

## Golden rules (memorise these)
- **Event Sourcing = persistence layer** ("the log IS the database").
- **Event Streaming = transport layer** ("the log is a pipe").
- **Kafka ≠ Event Sourcing** — Kafka is a streaming platform; you CAN build an event store on top of it, but they are not the same thing.
- **They combine well:** Event Sourcing handles the write side; streaming distributes events to the outside world.
- **Different recovery models:** Sourcing replays all events to rebuild state; Streaming seeks to the last committed offset.
