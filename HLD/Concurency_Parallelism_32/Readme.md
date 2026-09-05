# Concurrency vs Parallelism

## Analogy

- **Concurrency** — a single cashier serving multiple customers by switching between them very quickly (switching between tasks).
- **Parallelism** — multiple cashiers serving multiple customers at the same time (tasks running truly simultaneously).

---

## Definitions

### Concurrency
Refers to handling multiple tasks by sharing a single processing resource, without executing them truly simultaneously. It improves system responsiveness by creating an illusion of parallelism.

- Tasks execute in overlapping time periods, making progress without waiting for others to complete.
- A processor switches between tasks (context switching).
- Commonly used in systems requiring high responsiveness like handling multiple user requests.

### Parallelism
Refers to executing multiple tasks simultaneously using multiple processing units. It improves system throughput and computational speed by dividing work across processors.

- Tasks are split into smaller subtasks that run in parallel on separate cores or processors.
- Focuses on true simultaneous execution.
- Commonly used in data processing and high-performance applications.

---

## Key Differences

| Aspect | Concurrency | Parallelism |
|---|---|---|
| Execution | Interleaved (context switching) | Truly simultaneous |
| Processing Units | Single core | Multiple cores/processors |
| Goal | Responsiveness | Throughput / speed |
| Example | Handling multiple HTTP requests | Video rendering, matrix computation |
