# Event-Driven Architecture — Deep Dive — Quick Notes

> See also: [6_Event_Driven_Architecture](../6_Event_Driven_Architecture/README.md) for the core definition, basic benefits, and event properties. This note goes deeper on components, messaging patterns, and failure modes.
> Related: [9_PubSub_Architecture](../9_PubSub_Architecture/README.md), [45_Message_Queue](../45_Message_Queue/README.md).

## What is it?
Event-Driven Architecture (EDA) is a design approach where components communicate by **producing and reacting to events** (records of a significant action or state change) rather than calling each other directly. This note focuses on the internal building blocks, delivery patterns, and operational pitfalls.

## Why it matters
- Interviewers probe past the definition: they want the components, how events are delivered, and how you handle ordering/duplicates/failures.
- The failure modes (eventual consistency, duplicates, ordering) are where most real EDA designs break — knowing them signals maturity.
- Choosing the right messaging pattern (pub-sub vs queue vs stream) is a frequent design decision.

## Core Components
| Component | Role |
|---|---|
| **Event Source** | Where the event originates — user action, system change, sensor |
| **Producer / Publisher** | Creates and publishes events to a broker/queue/topic |
| **Event Broker / Bus** | Routes and delivers events to subscribers |
| **Consumer / Subscriber** | Receives and processes events |
| **Event Handler** | Executes the business logic triggered by an event |
| **Dispatcher** | Routes events to the correct handler based on type |
| **Event Processor** | Transforms, filters, aggregates, or enriches event data |

## Messaging Patterns
| Pattern | How it works | Best for |
|---|---|---|
| **Publish-Subscribe** | Every subscriber gets a copy of the same event | Fan-out notifications, multiple independent reactions |
| **Queue-Based (competing consumers)** | Each message processed by exactly one of many workers | Load distribution, work queues |
| **Event Streaming** | Persistent, replayable log; consumers read independently at their own offset | Replay, audit, analytics (e.g. Kafka) |

## Key Concepts
| Concept | One-liner |
|---|---|
| Event immutability | Events are permanent records — never mutated after emission |
| Idempotency | Consumers must tolerate duplicate delivery without double effects |
| Dead-letter queue (DLQ) | Holds events that repeatedly fail processing for later inspection |
| Event replay | Re-reading a stream from an offset to rebuild state or recover |
| Chain reactions | A consumer may emit new events, cascading through the system |

## How it works (flow)
```
1. Event occurs (state change / action)
2. Producer wraps it with metadata (type, payload, timestamp, id)
3. Published to a topic / queue / stream
4. Broker routes to subscribed consumers
5. Consumers process independently (pub-sub copy, or competing-consumer single delivery)
6. Consumers may emit new events → chain reactions
```

## Trade-offs
| Pro | Con |
|---|---|
| Loose coupling + independent scaling | Increased operational complexity (many producers/consumers/topics) |
| Failure isolation prevents cascading outages | Event ordering hard under parallel processing |
| Queues/streams buffer workload spikes | Eventual consistency — temporary data divergence |
| Extensible without touching producers | Duplicate/failed events need idempotency + DLQ |
| Replayable streams aid recovery/audit | Debugging distributed flows needs strong observability |

## When to use / avoid
- **Use when:** you need loose coupling, independent scaling, async workflows, or integration across many microservices.
- **Use streaming when:** you need replay, audit trails, or multiple independent readers of the same event log.
- **Avoid when:** the workflow is simple request-response, strong immediate consistency is required, or the team lacks monitoring to debug distributed flows.

## Real-world examples
- **Financial services:** Payments, fraud detection, market-data feeds.
- **E-commerce:** Order processing, inventory updates, notifications (OrderPlaced → payment, inventory, email).
- **IoT:** Sensor data ingestion and alerting.
- **Online gaming:** Player actions, matchmaking.
- **Monitoring/alerting:** Logs, metrics, infrastructure events.

## Common interview questions
- What are the core components of an event-driven system?
- Pub-sub vs queue-based delivery vs event streaming — when do you use each?
- How do you handle duplicate or out-of-order events?
- What is a dead-letter queue and why do you need one?
- How does eventual consistency manifest in EDA, and how do you mitigate it?
- How do you debug/trace an event as it flows through the system?

## Golden rules (memorise these)
- **Events are immutable facts** — "this happened", never "do this".
- **Assume at-least-once delivery → design consumers to be idempotent.**
- **Pub-sub = everyone gets a copy; queue = one worker wins; stream = replayable log.**
- **Ordering and exactly-once are hard** — partition keys and idempotency are your tools.
- **No DLQ = silent data loss** — always route repeatedly-failing events somewhere.
