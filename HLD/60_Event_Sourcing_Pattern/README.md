# Event Sourcing Pattern — Quick Notes

> See also: [6_Event_Driven_Architecture](../6_Event_Driven_Architecture/README.md) and [59_Event_Driven_Architecture_Deep_Dive](../59_Event_Driven_Architecture_Deep_Dive/README.md) for how events are *delivered/reacted to*. This note is about how events are *stored as the source of truth* — a persistence pattern, not a messaging style.

## What is it?
Event Sourcing is a persistence approach where you store every **state change as an immutable event** (an append-only log) instead of storing only the current state. Current state is **reconstructed by replaying** the events in order.

## Why it matters
- Classic answer to "how do you keep a complete audit trail / time-travel to any past state?"
- Tests whether you understand append-only immutability, replay, and its cost (storage, snapshots, eventual consistency).
- Pairs naturally with CQRS and event-driven systems — a frequent follow-up design decision.

## Traditional state vs Event Sourcing
| Aspect | Traditional (CRUD) | Event Sourcing |
|---|---|---|
| **What's stored** | Current state only (rows overwritten) | Full ordered sequence of events |
| **History** | Lost on update (needs audit tables) | Inherent — nothing is ever deleted |
| **Current state** | Read directly | Rebuilt by replaying events |
| **Mutation** | `UPDATE` in place | `APPEND` a new event |

## Core Components
| Component | Role |
|---|---|
| **Event** | Immutable record of one accepted state change (e.g. `OrderCreated`) |
| **Event Store** | Durable, append-only, chronological log — the single source of truth |
| **Aggregate** | Groups related entities; validates commands and emits events; has its own event stream |
| **Command** | A request to *do* something; validated by the aggregate before any event is emitted |
| **Projection** | A read model derived by replaying events, optimised for queries |
| **Event Bus** | Distributes emitted events to subscribers (async pub-sub) |

## Key Concepts
| Concept | One-liner |
|---|---|
| Append-only | Events are never mutated or deleted — only new ones are added |
| Replay | Re-read events from the start to rebuild state or build a new projection |
| Snapshot | Periodically save rebuilt state so replay starts midway, not from event 0 |
| Temporal query | Reconstruct state "as of" any past point in time |
| Side-effect safety | Replay must NOT re-fire external actions (payments, emails) |
| Event versioning | Old event schemas must stay readable as the schema evolves |

## How it works (flow)
```
1. Command arrives (e.g. "cancel order")
2. Aggregate validates it against current (replayed) state
3. If valid → emit an immutable event (OrderCancelled) and APPEND to event store
4. Event published on the bus → projections / subscribers update
5. Reads hit projections; state can be rebuilt any time by replaying events
   (snapshot + events-since-snapshot for long streams)
```

## Relationship to CQRS
Event Sourcing is the **write side**; CQRS splits reads from writes. Commands append events (write model), and **projections** serve queries (read model). They're independent but very commonly used together — ES gives CQRS its event stream, CQRS gives ES fast reads.

## Trade-offs
| Pro | Con |
|---|---|
| Complete, tamper-evident audit trail | Event history grows unbounded → storage + replay cost |
| Reconstruct any past or current state | Needs snapshots to keep replay fast |
| Build new read models anytime by replaying | Read models are eventually consistent (stale window) |
| Great for debugging (replay the exact sequence) | Concurrency needs optimistic control (version checks) |
| Domain events drive analytics/integration | Schema evolution + side-effect-safe replay add complexity |

## When to use / avoid
- **Use when:** a full audit trail is mandatory, the *path* of state changes has business value, you need temporal queries, or you expect to build new projections later (finance, healthcare, supply chain, order lifecycles).
- **Avoid when:** it's simple CRUD where only the latest value matters, storage/complexity cost isn't justified, or the domain has no historical/audit requirement.

## Real-world examples
- **Finance:** Account ledgers — every transaction is an immutable event; balance = replay.
- **E-commerce:** Order lifecycle (Created → Paid → Shipped → Refunded) as an event stream.
- **Healthcare:** Patient record change history and treatment workflows.
- **Supply chain:** Inventory movements, shipments, warehouse activity.
- **Gaming:** Replayable match state and player action history.

## Common interview questions
- What is event sourcing and how does it differ from storing current state?
- How do you reconstruct current state, and why are snapshots needed?
- How does event sourcing relate to CQRS?
- How do you prevent replaying events from re-triggering side effects (e.g. charging a card twice)?
- How do you handle schema/event versioning as the system evolves?
- How do you deal with eventual consistency in the read models?

## Golden rules (memorise these)
- **Store the change, not the state** — append immutable events, never update in place.
- **Current state = replay(events)**; snapshots just make replay cheaper.
- **Event Sourcing ≠ Event-Driven** — one is how you *persist*, the other is how you *communicate*.
- **Replay must be side-effect-free** — rebuilding state must never re-send emails or re-charge payments.
- **Pairs with CQRS:** events are the write model, projections are the read model.
