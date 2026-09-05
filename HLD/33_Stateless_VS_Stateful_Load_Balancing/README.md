# Stateless vs Stateful Load Balancing

## Definitions

- **Stateless Load Balancing** — distributes requests without tracking previous interactions. Each request is handled independently, making it simpler to implement.
- **Stateful Load Balancing** — routes requests based on session context, sending the same user's requests to the same server to maintain continuity.

---

## Key Differences

| Aspect | Stateless | Stateful |
|---|---|---|
| Session Tracking | None | Client session data maintained |
| Routing Logic | Load-based distribution | Same-server routing per session |
| Scalability | Highly scalable | Limited by tracking overhead |
| Failure Impact | No session loss | Risk of session loss on failure |
| Implementation | Simple | Complex (needs persistence/replication) |

---

## Strengths & Weaknesses

**Stateless**
- Pros: High scalability, fault-tolerant, simpler design, faster
- Cons: Can't maintain sessions; unsuitable for session-dependent apps

**Stateful**
- Pros: Session consistency, better UX for interactive apps
- Cons: Complex management, scalability challenges, performance overhead

---

## Use Cases

| Stateless | Stateful |
|---|---|
| RESTful APIs | E-commerce platforms |
| Microservices | Online banking |
| CDNs | Multiplayer gaming |
| Search engines | Real-time collaboration tools |
