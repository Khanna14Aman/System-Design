# Bottlenecks in System Design

## Throughput and Latency

**Throughput** is the rate at which a system successfully processes work over time.
```
Throughput = completed units of work ÷ time
```

**Latency** is the time taken for a single operation to complete — from the moment a request is sent until the response is received.
```
Latency = response_time − request_start_time
```

### Throughput Units by System Domain

| System | Throughput Unit |
|---|---|
| Web server | Requests per second (RPS) |
| Database | Queries per second (QPS) |
| Message queue | Messages/sec |
| Network | Mbps / packets per second |
| CPU | Instructions per second |

---

## What is a Bottleneck?

A bottleneck is a **component that limits system throughput** and slows down overall performance when load increases.

- System performance is limited by its slowest part.
- Bottlenecks reduce scalability and throughput.
- Can exist at any system layer.
- High traffic exposes bottlenecks quickly.
- Fixing one bottleneck may create another.

---

## Types of Bottlenecks

### a. Database Bottlenecks
Performance restrictions in a database system that limit its capacity to process requests and transactions effectively.

- Caused by slow queries, ineffective indexing, or insufficient hardware resources.
- Seriously affects overall performance, scalability, and responsiveness.

**Example:** An e-commerce website experiencing a surge in traffic during a holiday sale — slow database queries lead to delayed order processing, frustrating users, and potentially resulting in abandoned carts.

---

### b. Network Bottlenecks
Occur when network bandwidth or latency becomes a limiting factor in a distributed system.

- Can occur at various points in a network topology.
- Severely impact the efficiency and responsiveness of an application.

**Example:** A video streaming service without adequate content delivery infrastructure — users experience buffering or low-quality video streams when too many requests strain the network.

---

### c. Server Bottlenecks
Occur when the application server is unable to manage more requests or concurrent connections — due to limitations in CPU, RAM, or disk I/O.

**Example:** A web application that allows users to upload and process images. As the user base grows, the server's CPU becomes a bottleneck because the image processing algorithm is computationally intensive, causing delays and sluggishness.

---

### d. Authentication Bottlenecks
When the process of verifying user identities becomes a limiting element in overall system performance — caused by ineffective authentication procedures, high volume of requests, or insufficient infrastructure.

**Example:** An e-banking application may experience authentication bottlenecks during peak usage times, causing login delays if the authentication system cannot keep up with incoming requests.

---

### e. Third-party Services Bottlenecks
When reliance on external services (cloud storage, geolocation, payment processing) limits overall performance, reliability, and scalability.

- Caused by the third-party service's availability, response latency, rate limitations, or API changes.

**Example:** If a ride-sharing app depends on an external mapping service and that service experiences downtime or slow response times, it affects the app's performance and scalability.

---

### f. Code Execution Bottlenecks
Circumstances where the design, writing, or execution of software code affects system performance — caused by poor use of system resources, high CPU utilization, and slow reaction times.

**Example:** Inefficient algorithms for rendering complex data in a web app's front-end can lead to slow page loads and lower user satisfaction.

---

### g. Data Storage Bottlenecks
When storage mechanisms and infrastructure start to limit system performance, capacity, or reliability — including slow file storage access or inefficient disk space utilization.

**Example:** A cloud-based file-sharing platform where the underlying file storage system struggles to handle an increasing number of files or doesn't provide efficient data retrieval, impeding graceful scaling.
