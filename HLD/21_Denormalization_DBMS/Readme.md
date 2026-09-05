# Denormalization in DBMS

## Denormalization vs Normalization

Normalization and Denormalization are methods used in database design that work opposite to each other:

- **Normalization** — reduces or removes redundancy; no duplicate data or entries in the same table. Optimizes for **data integrity and efficient storage**.
- **Denormalization** — adds redundancy into normalized tables to enhance functionality and minimize query execution time (e.g., join operations). Optimizes for **performance and query simplicity**.

> In a system that demands scalability (like any major tech company), we almost always use elements of **both** normalized and denormalized databases.

---

## Advantages of Denormalization

| Advantage | Description |
|---|---|
| **Improved Query Performance** | Reduces the number of joins required to retrieve data |
| **Reduced Complexity** | Combining related data into fewer tables simplifies the database schema |
| **Easier Maintenance and Updates** | Fewer tables makes updating and maintaining the database easier |
| **Improved Read Performance** | Makes it easier to access data — fewer lookups needed |
| **Better Scalability** | Reduces the number of tables and improves overall performance |

---

## Disadvantages of Denormalization

| Disadvantage | Description |
|---|---|
| **Reduced Data Integrity** | Adding redundant data increases the risk of inconsistencies |
| **Increased Complexity** | Redundant data can make the schema more complex in some cases |
| **Increased Storage Requirements** | Redundant data increases storage needs and maintenance cost |
