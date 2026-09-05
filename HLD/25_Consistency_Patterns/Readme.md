# Consistency Patterns

## What are Consistency Patterns?

Consistency patterns in system design are approaches used to **manage data consistency across distributed systems** where multiple users read and write data simultaneously. They ensure data remains accurate and coherent across different nodes.

---

## Types of Consistency

| Type | Description |
|---|---|
| **Strong Consistency** | All nodes always see the latest data — no mismatch between replicas |
| **Eventual Consistency** | Allows temporary differences but guarantees all replicas will eventually become consistent |
| **Causal Consistency** | Maintains the order of related operations so dependent events are seen in the same sequence |

---

## Use Cases and Applications

| Domain | Consistency Pattern | Reason |
|---|---|---|
| **Financial Transactions** | Strong Consistency | Ensures accurate and up-to-date data so transactions and balances are always correct |
| **E-commerce Platforms** | Strong Consistency | Maintains correct inventory levels and prevents overselling of products |
| **Social Media Platforms** | Eventual Consistency | Allows posts and interactions to spread to all users over time without immediate synchronization |
| **Collaborative Editing Tools** | Weak Consistency | Enables multiple users to edit simultaneously with eventual synchronization |
| **Content Delivery Networks (CDNs)** | Weak Consistency | Improves performance and scalability by allowing content to sync gradually across edge servers |
| **Real-Time Analytics** | Strong Consistency | Ensures accurate and consistent results across distributed data sources |
