# Load Balancer

## What is a Load Balancer?

A load balancer is a **networking device or software application that distributes and balances incoming traffic among servers** to provide high availability, efficient server utilization, and high performance.

- Ensures that no single server bears too many requests — improves performance, reliability, and availability.
- Highly used in cloud computing, data centers, and large-scale web applications.

---

## Problems Without a Load Balancer

| Problem | Description |
|---|---|
| **Single Point of Failure** | If the server goes down, the whole application becomes unavailable to users |
| **Overloaded Servers** | A server has a limit on the number of requests it can handle; growing traffic will overload it |
| **Limited Scalability** | Without a load balancer, adding more servers won't automatically solve the load issue — all requests remain with one server |

---

## How a Load Balancer Works

| Step | Description |
|---|---|
| **1. Receives Incoming Requests** | User requests go to the load balancer instead of directly to a server |
| **2. Checks Server Health** | Continuously monitors all servers to determine which are healthy and ready to handle requests |
| **3. Distributes Traffic** | Forwards each request to the most appropriate server based on load, response time, or proximity |
| **4. Handles Server Failures** | If a server goes down, automatically stops sending traffic to it and redirects to functioning servers |
| **5. Optimizes Performance** | Spreads traffic efficiently using healthy servers to improve overall performance and reduce delays |

---

## Characteristics of Load Balancers

| Characteristic | Description |
|---|---|
| **Traffic Distribution** | Divides incoming requests evenly among servers to prevent any one from being overburdened |
| **High Availability** | Reroutes traffic to healthy servers if one fails — improves reliability and availability |
| **Scalability** | Makes it simple to add servers or resources to meet growing traffic demands |
| **Optimization** | Ensures efficient use of server capacity and prevents bottlenecks |
| **Health Monitoring** | Monitors server health and directs traffic away from servers experiencing issues |

---

## Challenges and Risks of Load Balancers

| Challenge | Description |
|---|---|
| **Single Point of Failure** | If the load balancer itself fails, it can stop traffic from reaching servers — mitigated with backup load balancers |
| **Performance Bottleneck** | If the load balancer cannot handle very high traffic, it may slow down request processing |
| **Configuration Complexity** | Setting up load balancing correctly for large applications can be complex |
| **Security Risks** | Load balancers sit between users and servers — they can become targets for cyber attacks |
| **Cost** | Hardware load balancers and high-availability configurations can increase infrastructure costs |
