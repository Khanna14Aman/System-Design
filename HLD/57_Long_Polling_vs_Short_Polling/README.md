# Long Polling vs Short Polling — Quick Notes

> See also: [Communication_Protocols](../48_Communication_Protocols/README.md) for WebSockets, SSE, and how they compare to polling.

## What is it?
Both are client-driven techniques to get updates from a server over standard HTTP. **Short polling** sends requests at fixed intervals and gets an immediate response (even if empty). **Long polling** sends a request that the server holds open until new data is available or a timeout occurs.

## Why it matters
- Classic interview question for "how do you get near-real-time updates without WebSockets?"
- Tests whether you understand the trade-off between simplicity and wasted requests vs latency and connection management.
- Polling is the fallback when WebSockets/SSE aren't available (restrictive proxies, legacy clients).

## Side-by-Side Comparison
| Aspect | Short Polling | Long Polling |
|---|---|---|
| **Request pattern** | Fixed intervals | New request after previous response |
| **Server response** | Immediate (may be empty) | Waits for data or timeout |
| **Empty responses** | Frequent | Rare |
| **Latency** | Higher (interval-bound) | Lower (data-driven) |
| **Complexity** | Simple | Moderate-to-complex |
| **Resource usage** | Many repeated requests | Many held-open connections |

## Key Concepts
| Concept | One-liner |
|---|---|
| Polling interval | Short polling's fixed gap between requests — the main latency/load lever |
| Held connection | Long polling keeps the request open server-side until data or timeout |
| Timeout + retry | Long polling must handle timeouts and reconnect to keep the loop going |
| Empty response | Short polling returns "nothing new" often — wasted round trips |
| Near real-time | Long polling approximates push without a persistent protocol |

## How it works (flow)
```
Short Polling
  Client → request ──► Server → immediate response (data or empty)
  wait fixed interval, repeat

Long Polling
  Client → request ──► Server holds connection open
     - responds the moment new data arrives (or on timeout)
  Client immediately sends the next request, repeat
```

## When to use / avoid
- **Use short polling when:** updates are periodic and small delays are acceptable, and simplicity matters (news feeds, weather, non-critical dashboards).
- **Use long polling when:** you need near-real-time updates but can't use WebSockets (chat, notifications, job-status monitoring).
- **Avoid short polling when:** low latency is required — it either wastes requests or lags.
- **Avoid long polling when:** you have true bidirectional, high-frequency traffic — prefer WebSockets; or when holding many connections overwhelms the server.

## Real-world examples
- **Short polling:** Stock tickers / weather widgets refreshing every few seconds.
- **Long polling:** Early Facebook Chat and many notification systems before WebSockets were widespread.
- **Fallback:** Libraries like Socket.IO degrade to long polling when WebSockets are blocked.

## Common interview questions
- What is the difference between long polling and short polling?
- How does long polling achieve near-real-time updates over HTTP?
- When would you choose polling over WebSockets?
- What are the scaling challenges of long polling (held connections)?
- How do you handle timeouts and reconnection in long polling?

## Golden rules (memorise these)
- **Short polling = ask repeatedly on a timer; long polling = ask once and wait.**
- **Short polling trades wasted requests for simplicity; long polling trades connection overhead for lower latency.**
- **Neither is a true push** — for real bidirectional real-time, reach for WebSockets (see [Communication_Protocols](../48_Communication_Protocols/README.md)).
- **Long polling is the common WebSocket fallback** when the network blocks persistent connections.
