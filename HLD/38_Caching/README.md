# Caching in System Design

## What is Caching?

Caching is the process of **storing frequently accessed data in a fast, temporary storage location** so it can be retrieved quickly without hitting the original source (database, API, etc.).

> Caching acts as a local store for data — retrieving data from this temporary storage is faster than fetching it from the database every time.

```
Without Cache: Client → App Server → Database (slow)
With Cache:    Client → App Server → Cache (fast) ✓
               Client → App Server → Cache (miss) → Database → Cache (store) → Client
```

---

## How Caching Works

| Step | Description |
|---|---|
| **1. Request arrives** | Application checks the cache first |
| **2. Cache Hit** | Data found in cache → returned immediately (fast path) |
| **3. Cache Miss** | Data not in cache → fetched from the database |
| **4. Cache Store** | Fetched data is stored in cache for future requests |
| **5. Subsequent requests** | Same data served from cache — dramatically reduced response time |

---

## Types of Cache

### 1. Application Server Cache
Local storage within each application server.

- Fastest — data is stored directly in the server's memory.
- **Problem:** With multiple servers, each maintains a separate cache → frequent cache misses as requests can land on different servers.

### 2. Distributed Cache
Each node holds a portion of the total cache space.

- Uses a **consistent hashing function** to route each request to the correct node where the cached data lives.
- Scales horizontally — adding nodes increases total cache capacity.
- **Examples:** Redis Cluster, Memcached.

### 3. Global Cache
A **single centralized cache** shared and accessed by all nodes.

- When data is not found, either the cache itself or the requesting node retrieves it from underlying storage.
- Simpler to reason about but can become a bottleneck at high scale.

### 4. CDN / Edge Cache
Geographically distributed servers storing **static content** close to users.

- Directs users to the nearest server to improve delivery speed.
- Best suited for: HTML, CSS, JavaScript, images, and videos.
- **Examples:** Cloudflare, Akamai, AWS CloudFront.

---

## Cache Eviction Policies

When the cache reaches its capacity, older or less-used data must be removed. Eviction policies define what gets removed:

| Policy | Full Name | How It Works | Best For |
|---|---|---|---|
| **LRU** | Least Recently Used | Removes the item that was accessed least recently | General-purpose caching |
| **LFU** | Least Frequently Used | Removes the item that has been accessed the fewest times | Workloads with skewed popularity |
| **FIFO** | First-In-First-Out | Removes the oldest cached item regardless of usage | Simple, time-ordered caches |
| **MRU** | Most Recently Used | Removes the most recently accessed item | Workloads where recent = less likely to be reused |
| **TTL** | Time-To-Live | Items expire after a set duration | Time-sensitive data (sessions, tokens) |

---

## Cache Invalidation

Cache invalidation ensures **outdated cached data is updated or removed** to prevent stale reads. It is one of the hardest problems in system design.

### Strategies

| Strategy | Description | Trade-off |
|---|---|---|
| **Write-Through** | Data written to cache and database simultaneously | Consistent but slower writes |
| **Write-Behind (Write-Back)** | Data written to cache first; DB updated asynchronously | Faster writes but risk of data loss |
| **Cache-Aside (Lazy Loading)** | App checks cache first; on miss, loads from DB and populates cache | Most common; cache only what's needed |
| **Time-Based Expiration (TTL)** | Cache entries automatically expire after a fixed time | Simple but may serve stale data briefly |
| **Event-Driven Invalidation** | Cache entry is invalidated when the underlying data changes | Most accurate; requires change detection |

---

## Cache Hit Rate

Cache Hit Rate measures how effectively the cache is working:

```
Cache Hit Rate = (Cache Hits / Total Requests) × 100
```

- A **high hit rate** (e.g., 90%+) means the cache is very effective.
- A **low hit rate** means most requests are missing the cache and hitting the database — the cache may be too small or poorly keyed.

---

## Advantages of Caching

| Advantage | Description |
|---|---|
| **Faster Response Time** | Data served from memory is significantly faster than from disk/DB |
| **Reduced Database Load** | Fewer queries reach the database, reducing load and preventing bottlenecks |
| **Better Scalability** | Systems handle more traffic without proportionally scaling the database |
| **Cost Savings** | Reduces compute and database I/O costs |
| **Improved Availability** | Cache can serve data even if the database is temporarily slow or unavailable |

---

## Disadvantages of Caching

| Disadvantage | Description |
|---|---|
| **Data Inconsistency** | Stale data in the cache can cause users to see outdated information |
| **Cache Eviction Issues** | Poorly tuned eviction policies can cause frequent misses and performance drops |
| **Increased Complexity** | Adds another layer to manage, monitor, and debug |
| **Memory Cost** | Cache lives in RAM, which is more expensive than disk |
| **Cold Start Problem** | On system restart, cache is empty — all requests miss until the cache warms up |

---

## Use Cases

| Use Case | Description |
|---|---|
| **Web Page Caching** | Browsers cache HTML, CSS, JS so pages load faster on return visits |
| **Database Query Caching** | Store results of expensive queries (e.g., reports, dashboards) |
| **Session Storage** | Store user session data for fast authentication (e.g., Redis) |
| **API Response Caching** | Cache responses of frequently called, rarely changing API endpoints |
| **CDN Content Delivery** | Static assets delivered from edge servers near users |
| **Search Autocomplete** | Cache popular search suggestions for instant results |
| **Product Catalog** | Cache product listings in e-commerce to handle high-traffic sales events |

---

## Quick Recap

| Concept | One-liner |
|---|---|
| Cache Hit | Data found in cache — fast path |
| Cache Miss | Data not in cache — goes to DB |
| LRU | Evicts least recently used entry |
| Write-Through | Writes to cache and DB simultaneously |
| Cache-Aside | App manages cache manually on reads |
| TTL | Entries expire automatically after a set duration |
| CDN | Edge caching for static content near users |
| Hit Rate | % of requests served by cache — higher is better |
