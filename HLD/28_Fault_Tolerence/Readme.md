# Fault Tolerance

## What is Fault Tolerance?

Fault tolerance refers to a **system's capacity to keep working even in the face of hardware or software issues**. It requires using redundancy, error detection, and error recovery techniques to avoid a costly failure.

---

## Systems That Require Fault Tolerance

| System | Description |
|---|---|
| **RAID** | Redundant Array of Independent Disks — distributes data across multiple disks with redundancy; the system continues functioning even if one disk fails |
| **Load Balancing** | Distributes network traffic across multiple servers; if one server fails, others still handle the load |
| **Clustering** | Clusters of servers ensure that if one fails, another takes over the workload seamlessly |
| **Virtualization** | Virtual machines on a server allow easy migration of workloads to another server on hardware failure |
| **Microservices Architecture** | Independent services allow fault isolation, preventing the entire system from failing if one service encounters issues |
| **Distributed Cloud Architecture** | Distributing across multiple cloud regions or providers reduces the impact of a failure in a specific region |

---

## Replication Strategies for Enhancing Fault Tolerance

### 1. Full Replication
Creates a **complete copy** of the system or dataset across multiple nodes. Each node stores the same data — if one fails, another immediately takes over.

### 2. Partial Replication
Only duplicates **important or frequently used components** instead of the entire system.

### 3. Shadowing (Passive Replication)
Maintains **backup replicas that remain inactive** during normal operation and become active only when the primary system fails.

### 4. Active Replication
**Multiple replicas process the same requests simultaneously** to ensure continuous system operation.

---

## Challenges in Implementing Fault Tolerance

| Challenge | Description |
|---|---|
| **Scalability Issues** | Fault-tolerant mechanisms must scale alongside the system's growth without sacrificing performance |
| **Performance Impacts** | Redundancy and error correction can impact system performance — minimize degradation while maintaining fault tolerance |
| **Cost Considerations** | Implementing robust fault tolerance often incurs additional costs for redundant hardware, licenses, maintenance, and monitoring |
