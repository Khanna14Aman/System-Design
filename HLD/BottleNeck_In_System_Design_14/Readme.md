1: Throughput is the rate at which a system successfully processes work over time.
Formally:
Throughput = completed units of work ÷ time
The “unit of work” depends on the system domain.


Latency is the time taken for a single operation to complete — from the moment a request is sent until the response is received.
Formally:
Latency = response_time − request_start_time


2: | System     | Throughput Unit           |
| ------------- | ------------------------- |
| Web server    | requests per second (RPS) |
| Database      | queries per second (QPS)  |
| Message queue | messages/sec              |
| Network       | Mbps / packets per second |
| CPU           | instructions per second   |


3: A bottleneck is a component that limits system throughput and slows down overall performance when load increases.

    System performance is limited by its slowest part.
    Bottlenecks reduce scalability and throughput.
    Can exist at any system layer.
    High traffic exposes bottlenecks quickly.
    Fixing one bottleneck may create another.


4: Types of BottleNeck:

a: Database Bottlenecks
    Many programs rely heavily on databases, which are also frequently the main cause of scalability issues. Performance restrictions in a database system that can limit its capacity to process requests and transactions effectively are known as database bottlenecks.

    An application's or system's overall performance, scalability, and responsiveness can all be seriously affected by these obstacles.
    Database bottlenecks happen when problems like slow queries, ineffective indexing, insufficient hardware resources, or inadequate indexing cause the database to become a performance bottleneck.

    For example:

    If an e-commerce website experiences a surge in traffic during a holiday sale, slow database queries can lead to delayed order processing, frustrating users, and potentially resulting in abandoned carts.


b: Network Bottlenecks
    Network bottlenecks can significantly hinder scalability in a distributed system. It happen when a certain resource or component restricts a computer network's capacity or performance, which slows down or degrades the system's overall performance.

    They can occur at various points in a network topology and can severely impact the efficiency and responsiveness of an application or system.
    These bottlenecks occur when network bandwidth or latency becomes a limiting factor.
   
    For example:

    A video streaming service may encounter network bottlenecks if it doesn't have adequate content delivery infrastructure. Users may experience buffering or low-quality video streams when too many requests strain the network.


c: Server Bottlenecks
    When the application server is unable to manage more requests or concurrent connections, a server bottleneck occurs. Limitations in server resources, including CPU, RAM, or disk I/O, may be the cause of this.

    Consider a social media site where an unexpectedly popular post causes a huge surge in users attempting to access it at once.
    If the server lacks the necessary resources to handle this surge, it may become unresponsive, degrading the user experience.
   
    For example:

    You have a web application that allows users to upload and process images. As the user base grows, the server begins to experience performance issues. The server's CPU becomes a bottleneck because the image processing algorithm used by the application is computationally intensive, causing delays in image processing and overall sluggishness of the application.


d: Authentication Bottlenecks
    Many programs depend on authentication to provide safe access to user accounts. When the process of confirming user identities and allowing access to resources becomes a limiting element in a system's overall performance and usability, this is referred to as an authentication bottleneck in system design. A number of things, such as ineffective authentication procedures, a high volume of user authentication requests, or insufficient infrastructure for authentication, might cause these bottlenecks.

    For example:

    An e-banking application may experience authentication bottlenecks during peak usage times, causing login delays if the authentication system cannot keep up with the volume of incoming requests.


e: Third-party Services Bottlenecks
    For many features, such as cloud storage, geolocation, and payment processing, modern apps frequently rely on third-party services, which limits a system's overall performance, dependability, and scalability.

    A number of things, such as the third-party service's availability, response latency, rate limitations, or API modifications, might cause these bottlenecks.
    Identifying and addressing third-party services bottlenecks is crucial for designing systems that can provide consistent and responsive user experiences.
    
    For example:

    If a ride-sharing app depends on an external mapping service and that service experiences downtime or slow response times, it can affect the app's performance and scalability.


f: Code Execution Bottlenecks
    In system design, code execution bottlenecks are circumstances in which the design, writing, or execution of software code affects a computer system's performance and efficiency. These bottlenecks can be caused by a variety of factors, including poor use of system resources, high CPU utilization, and slow reaction times.

    For example:

    Inefficient algorithms for rendering complex data in a web application's front-end code can lead to slow page loads and lower user satisfaction. Detecting and optimizing these code bottlenecks is crucial for achieving scalability.


g: Data Storage Bottlenecks
    When a system's storage mechanisms and infrastructure start to limit its performance, capacity, or dependability, it is said to have a data storage bottleneck. These bottlenecks can impact the overall functionality and efficiency of the system.

    This might include slow access to file storage systems or inefficient utilization of disk space, leading to issues such as slow data access, data loss, or scalability problems.
    Identifying and addressing data storage bottlenecks is critical for designing systems that can handle data effectively.
    For example:

    Consider a cloud-based file-sharing platform; if the underlying file storage system struggles to handle an increasing number of files or doesn't provide efficient data retrieval, it can impede the platform's ability to scale gracefully.