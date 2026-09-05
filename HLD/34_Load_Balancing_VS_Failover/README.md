# Load Balancing vs Failover

## Definitions

- **Load Balancing** — distributes incoming traffic across multiple servers to prevent any single server from becoming overwhelmed, enhancing performance and reliability.
- **Failover** — an automated mechanism that redirects operations to a backup system when the primary system malfunctions, maintaining service continuity.

---

## Primary Purpose

| | Load Balancing | Failover |
|---|---|---|
| Focus | Optimizing performance via even traffic distribution | Maintaining availability during system failures |
| Action | Spreads traffic across multiple servers to avoid overload | Switches to a backup server to maintain continuous service |

---

## Advantages

**Load Balancing**
- Reduces server stress through even distribution
- Enables scalability by supporting additional servers
- Enhances security by filtering harmful traffic

**Failover**
- Minimizes downtime during failures
- Activates backup resources quickly
- Simpler implementation than load balancing systems

---

## Disadvantages

**Load Balancing**
- Requires extensive configuration
- Introduces a potential single point of failure at the load balancer itself

**Failover**
- May experience brief switching delays during transition
- Costly unused backup infrastructure

---

## Key Differences

| Aspect | Load Balancing | Failover |
|---|---|---|
| Goal | Performance & scalability | Availability & continuity |
| Trigger | Always active | Activates on failure |
| Infrastructure | Multiple active servers | Primary + standby backup |
| Complexity | Higher configuration effort | Simpler to implement |
| Cost | Efficient use of resources | Backup resources sit idle |

---

## Use Cases

| Load Balancing | Failover |
|---|---|
| High-traffic e-commerce sales | Online banking |
| Web APIs under heavy load | Mission-critical databases |
| Content delivery networks | Healthcare systems |
| Microservices architectures | Financial transaction systems |
