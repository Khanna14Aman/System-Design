# Event-Driven Architecture (EDA)

## What is Event-Driven Architecture?

Event-Driven Architecture (EDA) is a software design pattern where **systems communicate by producing and reacting to events**, instead of calling each other directly.

- Components don't ask each other to do things — they **announce that something happened**, and interested components react to it.
- This architecture improves scalability, flexibility, and responsiveness.

**Example:** In an e-commerce system, when a customer places an order, an `Order Placed` event is generated. Services like payment processing, inventory management, and email notifications don't constantly check the order system — they independently respond when the event occurs.

---

## Benefits

- Enables real-time event processing and quick system responses
- Promotes loose coupling between components
- Improves scalability and system flexibility

---

## Key Properties

| Property | Description |
|---|---|
| **Flexibility & Responsiveness** | Systems dynamically adapt by initiating actions based on events |
| **Scalability** | Components can be added or removed without affecting the existing configuration |
| **Real-time Processing** | Events are handled as they happen, enabling time-sensitive task management |

---

## Types of Events

| Type | Description |
|---|---|
| **Triggering** | Various sources such as user actions or data changes can trigger events |
| **Asynchronicity** | EDA often uses asynchronous communication, allowing components to work independently and in parallel |
| **Publish-Subscribe Model** | Producers publish events; interested parties subscribe to them |
| **Event Types** | Grouped by purpose, e.g., `UserLoggedIn` or `OrderPlaced` |
| **Payload** | Events include extra context, e.g., a `PaymentReceived` event may detail the amount |
| **Event Handling** | Components have specific handlers that dictate their response to events |

---

## Challenges

- Increased complexity
- Difficult debugging and tracing
- Event latency

---

## Use Cases

- **Financial Services**
- **E-Commerce**
- **Online Gaming**
