# Distributed Cache

## What is a Distributed Cache?

A distributed cache is a **caching system that stores data across multiple servers** rather than a single machine, enhancing application performance by minimizing repeated database queries.

- Data is distributed across multiple nodes, each using its own memory for fast access.
- Improves response times from hundreds of milliseconds to just a few milliseconds.

> Unlike a local/application cache (which lives on a single server), a distributed cache is shared across all servers in a system — any server can read from or write to it.

---

## How It Works

| Mechanism | Description |
|---|---|
| **Data Storage** | Cache nodes use RAM for rapid read/write operations |
| **Data Replication** | Entries are duplicated across nodes for fault tolerance — if one node fails, data is still available |
| **Cache Eviction** | Removes low-value entries when memory is exhausted using policies like LRU, LFU, TTL, or FIFO |
| **Cache Invalidation** | Removes or updates stale entries when the underlying data changes |
| **Cache Coherency** | Synchronizes updates across all node copies to ensure consistency |
| **Cache Access** | Applications interact via simple `GET` / `SET` / `DELETE` APIs |

---

## Key Components

| Component | Role |
|---|---|
| **Cache Nodes/Servers** | Individual machines that store a portion of the cached data in RAM |
| **Cache Data** | The actual key-value pairs stored across nodes |
| **Cache Clients** | Application-side libraries that communicate with cache nodes |
| **Cache API** | Interface exposing `GET`, `SET`, `DELETE`, `EXPIRE` operations |
| **Cache Manager** | Coordinates node discovery, routing, replication, and eviction |

---

## Distributed Cache vs Local Cache

| Aspect | Local Cache | Distributed Cache |
|---|---|---|
| **Scope** | Single server only | Shared across all servers |
| **Consistency** | No cross-server sync needed | Requires coherency mechanisms |
| **Scalability** | Limited by one machine's RAM | Scales horizontally by adding nodes |
| **Fault Tolerance** | Cache lost if server restarts | Replication keeps data available |
| **Use Case** | Low-traffic, single-server apps | Multi-server, high-traffic systems |

---

## Benefits

| Benefit | Description |
|---|---|
| **Faster Response Times** | Reduces response time from hundreds of ms to just a few ms |
| **Horizontal Scalability** | Add more cache nodes to increase capacity without performance degradation |
| **High Availability** | Data replication across nodes ensures availability even if one node fails |
| **Reduced Database Load** | Fewer queries reach the DB — protects it during traffic spikes |
| **Cost-Effective** | Cheaper to add RAM-based cache nodes than to scale up the database |
| **Session Sharing** | Session data accessible across multiple servers — no sticky sessions needed |

---

## Challenges

| Challenge | Description |
|---|---|
| **Data Consistency** | Keeping all nodes in sync is complex — updates on one node may lag on others |
| **Cache Invalidation** | Determining when and how to expire stale data across distributed nodes is difficult |
| **Network Latency** | In geographically dispersed systems, network round-trips add latency |
| **Fault Tolerance Overhead** | Replication for fault tolerance adds memory and coordination cost |
| **Cache Stampede** | When many requests miss the cache simultaneously and all hit the DB at once |
| **Complexity** | Managing cluster topology, node failures, and rebalancing adds operational complexity |

---

## Popular Distributed Cache Solutions

| Tool | Key Traits |
|---|---|
| **Redis** | In-memory, supports rich data structures, persistence, pub/sub, clustering |
| **Memcached** | Simple key-value store, high performance, multi-threaded |
| **Amazon ElastiCache** | Managed Redis/Memcached on AWS — no infrastructure management |
| **Apache Ignite** | In-memory computing platform — supports SQL queries on cached data |
| **Hazelcast** | Embeddable distributed cache with built-in compute capabilities |

---

## Use Cases

| Use Case | Example |
|---|---|
| **Session Management** | Store user sessions across multiple app servers (e.g., login state) |
| **Database Query Caching** | Cache results of expensive or frequent DB queries |
| **Rate Limiting** | Track request counts per user per time window across all servers |
| **Leaderboards** | Real-time sorted sets for gaming or ranking systems (Redis Sorted Sets) |
| **Product Catalog** | Cache product data during high-traffic events like sales |
| **API Response Caching** | Store external API responses to avoid repeated calls |
| **Real-Time Analytics** | Aggregate metrics in memory before persisting to DB |

---

## Quick Recap

| Concept | One-liner |
|---|---|
| Distributed Cache | Cache spread across multiple nodes — shared by all servers |
| Cache Node | Individual server storing a shard of the cache in RAM |
| Replication | Data copied across nodes for fault tolerance |
| Cache Coherency | Keeping all node copies in sync after an update |
| Cache Stampede | Many simultaneous misses all hitting the DB at once |
| Redis | Most popular distributed cache — supports rich data structures |
