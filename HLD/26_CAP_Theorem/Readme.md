# CAP Theorem

## What is the CAP Theorem?

According to the CAP theorem, a distributed system can only guarantee **two of the three** desirable characteristics at the same time:

---

## The Three Properties

### 1. Consistency (C)
All clients see the **same data simultaneously**, no matter which node they connect to.
- For eventual consistency, the guarantee is a bit loose — the client will *eventually* see the same data on all nodes at some point in the future.

### 2. Availability (A)
All non-failing nodes return a **response for all read and write requests** in a bounded amount of time, even if some nodes are down.

### 3. Partition Tolerance (P)
The system **continues to operate despite arbitrary message loss or failure** in parts of the system. Distributed systems guaranteeing partition tolerance can gracefully recover once the partition heals.

---

## CAP System Types

| System Type | Guarantees | Trade-off | Examples |
|---|---|---|---|
| **CA System** | Consistency + Availability | Does not tolerate network partitions | Traditional relational databases in a single data center |
| **CP System** | Consistency + Partition Tolerance | Sacrifices availability during network failures — may temporarily block requests | MongoDB (default), HBase |
| **AP System** | Availability + Partition Tolerance | Does not guarantee immediate consistency — may return stale data during a partition | Apache Cassandra, DynamoDB |

---

## Real-World Examples

### 1. Banking Transactions → CP System
Strong consistency is required — transactions and balances must always be accurate.

### 2. Social Media Newsfeed → AP System
High availability is preferred — posts can propagate to all users over time without immediate sync.

### 3. Online Shopping Cart → Hybrid (CA + CP)
A balanced approach:
- **Adding items to cart** → AP mode: allows uninterrupted browsing even during network glitches.
- **Confirming order and processing payment** → CP mode: ensures consistency across all servers before finalizing the transaction.

The system requires careful design to switch seamlessly between availability and consistency modes at the right points of the user journey.
