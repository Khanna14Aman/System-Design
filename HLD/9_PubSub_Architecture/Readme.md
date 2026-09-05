# Pub/Sub Architecture

## What is Pub/Sub Architecture?

| Component | Description |
|---|---|
| **Publisher** | Creates and sends messages to topics without knowing subscribers |
| **Subscriber** | Receives messages from subscribed topics without knowing publishers |
| **Topic** | A named channel that categorizes messages; publishers send to topics, subscribers receive from them |
| **Message Broker** | Routes messages from publishers to subscribers based on subscriptions, ensuring delivery, persistence, and scalability |
| **Message** | The data unit exchanged — can be text, JSON, or binary |
| **Subscription** | Links subscribers to topics, defining which messages are received and delivery guarantees (e.g., at-most-once, at-least-once) |

---

## Use Cases

- Real-time Data Processing
- Event-Driven Architecture
- Message Queues
- Notification Alerts

---

## Types of Pub/Sub Services

### 1. Pub/Sub Service
The main messaging service — provides:
- **High Reliability:** Ensures messages are delivered consistently
- **Integrations:** Supports a wide range of integrations with other services
- **Automatic Capacity Management:** Handles scaling automatically based on demand
- **Data Replication:** Synchronously replicates all data to at least two zones; offers best-effort replication to a third zone

### 2. Pub/Sub Lite Service
A cost-effective alternative with trade-offs:
- **Lower Reliability:** Less reliable than the standard Pub/Sub service
- **Zonal or Regional Storage:** Zonal Lite topics are stored in one zone; Regional Lite topics replicate asynchronously to a second zone
- **Pre-provisioning Required:** You manage and provision your own storage and throughput capacity
- **Cost-Effective:** Good option if keeping costs low is essential and you can accept lower reliability

---

## Comparing Pub/Sub to Other Messaging Technologies

| Comparison | Description |
|---|---|
| **Pub/Sub vs. Message Queues** | Message Queues deliver to one consumer at a time (point-to-point); Pub/Sub broadcasts to multiple subscribers simultaneously |
| **Pub/Sub vs. Streaming Platforms** | Streaming platforms (e.g., Kafka) handle continuous data streams with long-term retention; Pub/Sub focuses on simpler real-time delivery |
| **Pub/Sub vs. WebSockets** | WebSockets enable real-time, bidirectional client-server communication; Pub/Sub decouples publishers and subscribers |
| **Pub/Sub vs. HTTP APIs** | HTTP APIs use synchronous request-response; Pub/Sub supports asynchronous messaging |

---

## When to Use Pub/Sub Architecture

**Use Pub/Sub when:**
- Subscribers don't need to know about each other — making the system more flexible and easier to scale
- You need systems that can grow easily by adding publishers or subscribers without disrupting the existing setup
- You want parts of your system to communicate without waiting for each other (asynchronous)
- You need an event-driven system where publishers send events and subscribers respond independently
- Subscribers need to change their interests at runtime by subscribing to different topics

**Do NOT use Pub/Sub when:**
- You need very quick direct communication — message routing and subscription management can add latency
- The added complexity of routing and subscription management is not justified
- Your application requires messages to arrive in a specific order — Pub/Sub doesn't guarantee delivery order
- For smaller applications where a few components communicate directly — Pub/Sub adds unnecessary complexity

---

## Benefits and Challenges

### Benefits

| Benefit | Description |
|---|---|
| **Scalability** | Easily scales with many publishers, subscribers, and messages via decoupled components |
| **Decoupling** | Publishers and subscribers operate independently, simplifying system design |
| **Asynchronous Communication** | Enables non-blocking message exchange, improving responsiveness and efficiency |
| **Reliability** | Ensures message delivery with acknowledgments, retries, and fault-handling mechanisms |

### Challenges

| Challenge | Description |
|---|---|
| **Message Ordering** | Messages may arrive out of order, causing issues for apps requiring strict sequencing |
| **Exactly-once Delivery** | Ensuring no duplicates despite failures is difficult and complex |
| **Latency** | Message routing can introduce delays, making low latency hard to balance with scalability |
| **Complexity** | Managing subscriptions, routing, and consistency in large-scale setups requires careful planning |
