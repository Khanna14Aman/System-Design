# Message Queue — Quick Notes

## What is it?
A **message queue** temporarily stores messages sent by producers so consumers can retrieve and process them independently and asynchronously — decoupling the two sides so neither needs to be available at the same time.

## Why it matters
- Enables **async communication** — producers don't block waiting for consumers to finish.
- Acts as a **buffer** during traffic spikes, protecting downstream services from being overwhelmed.
- Essential pattern in distributed/microservices systems — interviewers expect you to reach for it when services need to communicate without tight coupling.

## Key Concepts
| Concept | One-liner |
|---|---|
| Producer | Service that creates and sends messages to the queue |
| Consumer | Service that reads and processes messages from the queue |
| Message Broker | Intermediary managing routing, storage, and delivery (e.g. Kafka, RabbitMQ) |
| Point-to-Point | One message, one consumer — competing consumers model |
| Pub/Sub | One message, many subscribers — each gets its own copy |
| Acknowledgment (ACK) | Consumer confirms successful processing; broker removes message |
| Dead Letter Queue (DLQ) | Holds messages that failed after max retries |
| At-least-once delivery | Message delivered one or more times — consumer must be idempotent |
| Exactly-once delivery | Message delivered exactly once — harder, requires coordination |

## How it works (flow)
```
Producer
  │
  ▼
Message Queue (Broker)
  │  stores message, assigns ID, applies routing
  ▼
Consumer(s)
  ├── Pull/Push message
  ├── Process it
  └── Send ACK → broker removes message
              (no ACK → broker retries → DLQ after max retries)
```

## Trade-offs
| Pro | Con |
|---|---|
| Decouples producer and consumer | Adds operational complexity (broker to manage) |
| Absorbs traffic spikes (backpressure) | Message ordering not guaranteed by default |
| Enables horizontal consumer scaling | At-least-once delivery requires idempotent consumers |
| Built-in retry and DLQ for reliability | Debugging async flows is harder than synchronous |
| Supports multiple messaging models (P2P, Pub/Sub) | Latency overhead vs. direct synchronous call |

## When to use / avoid
- **Use when:** Background job processing, event-driven microservices, handling traffic bursts, email/notification dispatch, order processing pipelines, audit logging.
- **Avoid when:** You need a synchronous request-response (use REST/gRPC instead), strict ordering with very low tolerance for duplication (exactly-once is expensive), or the system is a simple monolith (overhead not worth it).

## Common interview questions
- What is the difference between a message queue and a message broker?
- How does a message queue handle failures? (ACK, retry, DLQ)
- What is the difference between Point-to-Point and Pub/Sub messaging?
- How do you ensure exactly-once processing with a message queue?
- How would you use a message queue to handle a sudden traffic spike in an e-commerce checkout flow?
- When would you choose Kafka over RabbitMQ?

## Golden rules (memorise these)
- **Async = decoupling** — queues break the temporal coupling between producer and consumer.
- **Design for at-least-once** — assume duplicates will arrive; make consumers idempotent.
- **DLQ is mandatory** — always configure one so poison messages don't silently disappear.
- **Kafka for streaming/event log; RabbitMQ for task queues** — know when to use each.
- **Ordering is partition-local in Kafka** — global ordering kills throughput; scope ordering to what you actually need.
- Popular tools: **Apache Kafka**, **RabbitMQ**, **AWS SQS/SNS**, **Google Pub/Sub**, **Azure Service Bus**.
