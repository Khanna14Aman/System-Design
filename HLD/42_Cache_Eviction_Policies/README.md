# Cache Eviction Policies — Quick Notes

## What is it?
Rules that determine **which item to remove** from a cache when it's full and a new item needs to be stored. Choosing the right policy directly impacts cache hit rate and system performance.

## Why it matters
- Every cache has a size limit — eviction is inevitable, so the policy determines how effective your cache is.
- Wrong policy = low hit rate = frequent origin/DB calls = latency spikes.
- A common follow-up in any caching system design question: *"What eviction policy would you use and why?"*

## Key Concepts
| Policy | Full Name | Evicts | Tracks |
|---|---|---|---|
| **LRU** | Least Recently Used | Item unused the longest | Access order (recency) |
| **LFU** | Least Frequently Used | Item accessed fewest times | Access count (frequency) |
| **FIFO** | First-In-First-Out | Oldest inserted item | Insertion order |
| **Random** | Random Replacement | Any random item | Nothing |

## How it works (flow)

```
New item arrives → Cache FULL?
                       │
                   YES → Apply eviction policy → remove chosen item
                       │
                   NO  → Insert directly
                       │
                   Item stored → serve request
```

**LRU internals:** HashMap + Doubly Linked List → O(1) get & put  
**LFU internals:** HashMap + min-heap or frequency buckets → O(log n) or O(1)

## Trade-offs
| Policy | Pro | Con |
|---|---|---|
| **LRU** | Great for temporal locality; simple to implement | Struggles with infrequent but important data (e.g., monthly reports) |
| **LFU** | Best for skewed popularity (viral content) | Slow to adapt when access patterns shift; cold-start penalty |
| **FIFO** | Minimal overhead; predictable | Ignores usage — may evict hot data |
| **Random** | Zero overhead; no bias | Unpredictable hit rate; not suitable for production |

## When to use / avoid
- **LRU** → Web caches, DB query caches, session stores. Default choice for most systems.
- **LFU** → CDN/video streaming (popular content stays long-term), recommendation engines.
- **FIFO** → Message queues, frame buffers, task scheduling where order matters.
- **Random** → Testing/simulation, extremely resource-constrained embedded systems.
- **Avoid Random** in production where hit rate matters.
- **Avoid LFU** when access patterns change frequently (counters become stale).

## Common interview questions
- How would you implement an LRU cache? (Classic: HashMap + Doubly Linked List)
- What's the difference between LRU and LFU? When would you pick one over the other?
- How does YouTube/Netflix decide which videos to keep in cache?
- What eviction policy would you use for a social media feed cache?
- How do you handle a cache stampede when many items expire simultaneously?

## Golden rules (memorise these)
- **LRU = default** — use it unless you have strong evidence of frequency-skewed access.
- **LRU implementation = HashMap + Doubly Linked List** — O(1) for both get and put.
- **LFU beats LRU** only when popularity is stable and skewed (80/20 rule holds long-term).
- **Hit rate is the metric** — a good eviction policy keeps it above 90%.
- **TTL ≠ eviction policy** — TTL expires stale data; eviction handles capacity pressure. Both are needed.
