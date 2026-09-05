# Consistent Hashing

## What is it?

A distributed systems technique that distributes data or requests across multiple servers efficiently, while **minimizing rehashing** when servers are added or removed.

> Think of it as a clock ring — servers sit at positions on the ring, and each request travels clockwise to land on the nearest server.

---

## How It Works

1. Both **servers** and **requests** are mapped onto a virtual hash ring using a hash function.
2. An incoming request is hashed → it travels **clockwise** on the ring → lands on the first server it encounters.
3. When a server is added/removed, only the keys on that segment are redistributed — not all keys.

```
Ring: [Server A] ---> [Server B] ---> [Server C] ---> (back to A)
Request R hashes to a position between A and B → goes to Server B
```

---

## Virtual Nodes

- Each physical server is represented by **multiple virtual nodes** on the ring.
- Prevents uneven load distribution (hot spots).
- More virtual nodes = better balance, but more memory overhead.

---

## Advantages

| Benefit | Why it matters |
|---|---|
| Minimal rehashing | Only affected keys move when nodes change |
| Even load distribution | Virtual nodes prevent hot spots |
| Scalability | Add/remove nodes with low disruption |
| Fault tolerance | Node failure only impacts a small key range |

---

## Disadvantages

- Choosing the right hash function is critical — bad choice = uneven distribution
- Computational overhead from mapping and replication
- Resource spikes during node transitions
- Complex to debug in dynamic network environments

---

## Use Cases

| Use Case | Example |
|---|---|
| Distributed caching | Redis clusters |
| Load balancing | Routing requests across servers |
| Database sharding | Partitioning data across DB nodes |
| CDNs | Routing users to nearest edge server |

---

## Quick Recap

| Concept | One-liner |
|---|---|
| Hash ring | Circular space where servers & keys are mapped |
| Clockwise routing | Request finds the next server clockwise |
| Virtual nodes | Multiple ring positions per physical server |
| Key rehashing on change | Only ~1/N keys move when 1 of N servers changes |
