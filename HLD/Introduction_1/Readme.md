1: System design is the process of planning, structuring and defining the architecture of Software System.
The goal is to create a well-organized and efficient structure that meets the intended purpose while considering factors like scalability, maintainability, and performance.


![alt text](image-1.png)

2: High Level Design (HLD)
High Level Design focuses on the overall architecture of the system.
It explains what components exist, how they interact, and how the system meets non-functional requirements like scalability, performance, and reliability.

Key points:
Communication between components
Addresses scalability, availability, fault tolerance
Target audience: Architects, senior engineers, stakeholders

Examples in HLD:
Monolith vs Microservices
Load balancer + API gateway
Database sharding & replication
Cache (Redis), message queues (Kafka)

🔹 Low Level Design (LLD)
Low Level Design focuses on implementation details of individual components.
It explains how each module is built internally.

Key points:
Class diagrams and object interactions
Method-level logic
Data structures and algorithms
Target audience: Developers and engineers

Examples in LLD:
Class design for UserService
Database schema & indexes
Exception handling & validations

Important points to consider when designing a software system:
1:  Scalability: The system should be designed to handle increased loads and be able to scale horizontally or vertically as needed.
2:  Performance: The system should be designed to perform efficiently and effectively, with minimal latency and response time.
3:  Reliability: The system should be reliable and available, with minimal downtime or system failures.
4:  Security: The system should be designed with security in mind, including measures to prevent unauthorized access and protect        sensitive data.
5:  Maintainability: The system should be designed to be easy to maintain and update, with clear documentation and well-organized code.
6:  Interoperability: The system should be designed to work seamlessly with other systems and components, with clear and well-defined interfaces.
7:  Usability: The system should be designed to be user-friendly and intuitive, with a clear and consistent user interface.
8:  Cost-effectiveness: The system should be designed to be cost-effective, with a focus on minimizing development and operational costs while still meeting the requirements.