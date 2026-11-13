# Web Server vs Application Server — Quick Notes

> See also: [Load_Balancer](../30_Load_Balancer/README.md), [Caching](../38_Caching/README.md), [Proxies](../54_Proxies/README.md), and [Communication_Protocols](../48_Communication_Protocols/README.md) for load balancing, caching, TLS termination, and HTTP/HTTPS/HTTP2/3 details.

## What is it?
A **web server** accepts HTTP/HTTPS requests and serves content (especially static files), while an **application server** executes business logic and generates dynamic responses by interacting with databases, APIs, and caches.

## Why it matters
- Interviewers use this to check whether you understand the split between the serving tier and the logic tier — a core layering decision in every web architecture.
- Knowing which tier does what drives scaling: the serving tier scales on traffic, the logic tier scales on compute/business load.
- Real stacks often run both (NGINX fronting an app server), so you must articulate the conceptual separation cleanly.

## Side-by-Side Comparison
| Aspect | Web Server | Application Server |
|---|---|---|
| **Primary function** | HTTP/HTTPS communication, serving content | Business logic execution |
| **Content type** | Static-focused (HTML, CSS, JS, images) | Dynamic response generation |
| **Logic complexity** | Limited | Primary responsibility |
| **Backend integration** | Routes requests onward | Direct DB / API / cache interaction |
| **Examples** | NGINX, Apache, IIS | WildFly, WebLogic, WebSphere |

## Key Concepts
| Concept | One-liner |
|---|---|
| Static content | Pre-stored files served as-is; cacheable, fast to deliver |
| Dynamic content | Generated per-request from user input or DB state |
| Request routing | Web server forwards dynamic requests to the application tier |
| Security | App server handles authentication, authorization, access control |
| Transaction management | App server coordinates DB operations for consistency |
| Integration | App server talks to external APIs and messaging systems |

## How it works (flow)
```
Client → Web Server
  - Serves static content directly (HTML/CSS/JS/images)
  - For dynamic requests, forwards to Application Server
      Application Server
        - Executes business logic / calculations
        - Reads/writes database, calls external APIs
        - Enforces auth, manages transactions
        - Generates response
  - Web Server relays response back to client (optionally cached)
```

## When to use / avoid
- **Use a web server in front when:** serving static assets, terminating TLS, load balancing, or caching at the edge of your app tier.
- **Use a dedicated application server when:** business logic is heavy, you need transaction/session management, or you integrate with many backends.
- **Combine both in production:** web server (NGINX) handles static + TLS + routing; app server handles dynamic logic.
- **Avoid pushing business logic into the web server:** it breaks the serving/logic separation and hurts scalability.

## Real-world examples
- **NGINX + app backend:** NGINX serves static files and reverse-proxies dynamic requests to an upstream app process.
- **Apache + WildFly (Java EE):** Apache fronts static content; WildFly runs the servlet/EJB business logic.
- **IIS + .NET:** IIS serves content and hosts the .NET application runtime for dynamic pages.

## Common interview questions
- What is the difference between a web server and an application server?
- Can a single server act as both? When would you split them?
- Where is static vs dynamic content handled in your architecture?
- Why put NGINX in front of an application server?
- How do the web and application tiers scale differently?

## Golden rules (memorise these)
- **Web server = serves content; application server = runs logic.**
- **Static → web server; dynamic → application server.**
- **Production almost always runs both** — a web/reverse-proxy tier in front of an app tier.
- **Separation of concerns enables independent scaling** — serving tier on traffic, logic tier on compute.
- **The web-server front for an app server is a reverse proxy** — see [Proxies](../54_Proxies/README.md).
