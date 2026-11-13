# WebSocket vs HTTP — Quick Notes

> See also: [Communication_Protocols](../48_Communication_Protocols/README.md) for the full protocol landscape (gRPC, SSE, etc.) and [Long_Polling_vs_Short_Polling](../57_Long_Polling_vs_Short_Polling/README.md) for the HTTP-based real-time workarounds.

## What is it?
**HTTP** is a stateless request-response protocol: the client asks, the server answers, connection done. **WebSocket** is a protocol that upgrades an HTTP connection into a persistent, full-duplex channel where client and server can send messages at any time.

## Why it matters
- Core "how do you do real-time?" interview question — WebSocket is the answer when polling isn't good enough.
- Tests whether you understand the cost of statefulness: persistent connections complicate horizontal scaling.
- Clarifies when NOT to reach for WebSockets (most request-response traffic should stay HTTP).

## Side-by-Side Comparison
| Aspect | HTTP | WebSocket |
|---|---|---|
| **Model** | Request-response only | Bidirectional messaging |
| **Who initiates** | Client only | Both client and server |
| **Connection** | New/reused per request, then closed | Persistent until explicitly closed |
| **Server push** | Not possible (needs polling) | Native |
| **State** | Stateless | Stateful |
| **Overhead per message** | Full headers each request | Minimal after handshake |
| **Encryption** | HTTPS | WSS |
| **Scaling** | Easy (stateless) | Harder (sticky/persistent connections) |

## Key Concepts
| Concept | One-liner |
|---|---|
| Handshake / Upgrade | WebSocket starts as an HTTP request with `Upgrade: websocket`, then switches protocols |
| Full-duplex | Both sides can send simultaneously over one connection |
| Persistent connection | Stays open, avoiding repeated handshakes/headers |
| Stateful scaling | Each live connection pins a client to a server — needs sticky routing or a pub/sub backplane |
| WS / WSS | Unencrypted vs TLS-encrypted WebSocket schemes |

## How it works (flow)
```
HTTP
  Client → request ──► Server → response (connection closes/reuses)
  Server cannot initiate; to get updates the client must poll

WebSocket
  Client → HTTP GET with "Upgrade: websocket" ──► Server → 101 Switching Protocols
  Persistent full-duplex channel established
  Either side pushes messages any time until closed
```

## When to use / avoid
- **Use HTTP when:** request-response fits — web pages, REST APIs, file transfers, intermittent/one-off requests, cacheable content.
- **Use WebSocket when:** you need low-latency bidirectional or server-push traffic — chat, multiplayer games, live notifications, streaming updates, collaborative editing.
- **Avoid WebSocket when:** traffic is occasional (polling/HTTP is simpler) or you need HTTP caching, since WebSocket bypasses it.
- **Avoid HTTP polling when:** updates are frequent and latency-sensitive — the overhead and lag make WebSocket the better fit.

## Real-world examples
- **HTTP:** Virtually all REST APIs and static web page delivery.
- **WebSocket:** Slack/WhatsApp web chat, multiplayer game state sync, live trading dashboards, Google Docs-style collaboration.
- **Scaling pattern:** WebSocket servers fronted by a load balancer with sticky sessions and a Redis/pub-sub backplane to fan out messages across nodes.

## Common interview questions
- How does WebSocket differ from HTTP?
- How does the WebSocket handshake work (why does it start as HTTP)?
- Why are WebSockets harder to scale horizontally than HTTP?
- When would you choose WebSocket over long polling or SSE?
- How do you broadcast a message to clients connected to different WebSocket servers?

## Golden rules (memorise these)
- **HTTP = client asks, server answers. WebSocket = both talk freely over one open pipe.**
- **WebSocket starts life as an HTTP Upgrade handshake**, then switches protocols (101 Switching Protocols).
- **Stateless scales easily; persistent WebSocket connections need sticky routing + a pub/sub backplane.**
- **Default to HTTP; reach for WebSocket only when you genuinely need server push or low-latency two-way traffic.**
- **WSS is to WebSocket what HTTPS is to HTTP** — always encrypt in production.
