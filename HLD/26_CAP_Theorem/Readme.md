According to the CAP theorem, only two of the three desirable characteristics consistency, availability, and partition tolerance can be shared or present in a networked shared-data system or distributed system.

1. Consistency
Consistency defines that all clients see the same data simultaneously, no matter which node they connect to in a distributed system. For eventual consistency, the guarantees are a bit loose. Eventual consistency guarantee means client will eventually see the same data on all the nodes at some point of time in the future.


2. Availability
Availability defines that all non-failing nodes in a distributed system return a response for all read and write requests in a bounded amount of time, even if one or more other nodes are down.

3. Partition Tolerance
Partition Tolerance defines that the system continues to operate despite arbitrary message loss or failure in parts of the system. Distributed systems guaranteeing partition tolerance can gracefully recover from partitions once the partition heals.


1. CA System
A CA system provides Consistency and Availability but does not tolerate network partitions. This means that all nodes always return the same data and the system remains accessible, but if a network partition occurs, the system cannot continue operating correctly.

Example: Traditional relational databases in a single data center are often designed as CA systems.


2. CP System
A CP system provides Consistency and Partition Tolerance but sacrifices availability during network failures. When a partition occurs between nodes, the system may temporarily block requests to ensure that all nodes maintain consistent data.

Systems that prefer consistency over availability during partitions.
Examples: MongoDB (default replica set behavior), HBase


3. AP System
An AP system provides Availability and Partition Tolerance but does not guarantee immediate consistency. During a network partition, the system continues to serve requests, but some nodes may return stale or outdated data until the system eventually synchronizes.

Systems that prefer availability and may return eventually consistent data.
Examples: Apache Cassandra, DynamoDB


1. Banking Transactions (CP System)

2. Social Media Newsfeed (AP System)

3. Online Shopping Cart (Hybrid System CAP System):
Problem Statement

Imagine an online shopping cart, adding items, and checking out. This system might employ a hybrid approach balancing CAP trade-offs.

We use AP and CP System

Adding items to the cart could be available and partition-tolerant (AP), allowing uninterrupted browsing even if temporary network glitches occur.
But when confirming the order and processing payment, the system might switch to a CP mode, ensuring consistency across all servers before finalizing the transaction.
The system requires careful design to switch seamlessly between availability and consistency modes at the right points to handle different stages of the user journey effectively.