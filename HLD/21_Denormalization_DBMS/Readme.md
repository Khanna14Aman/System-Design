Denormalization v/s Normalization
Normalization and Denormalization both are the method which use in database but it works opposite to each other. One side normalization is used for reduce or removing the redundancy which means there will be no duplicate data or entries in the same table and also optimizes for data integrity and efficient storage

Denormalization is used for add the redundancy into normalized table so that enhance the functionality and minimize the running time of database queries (like joins operation ) and optimizes for performance and query simplicity. In a system that demands scalability, like that of any major tech company, we almost always use elements of both normalized and denormalized databases.


Advantages:
1: Improved Query Performance: Denormalization can improve query performance by reducing the number of joins required to retrieve data.

2: Reduced Complexity: By combining related data into fewer tables, denormalization can simplify the database schema and make it easier to manage.

3: Easier Maintenance and Updates: Denormalization can make it easier to update and maintain the database by reducing the number of tables.

4: Improved Read Performance: Denormalization can improve read performance by making it easier to access data.

5: Better Scalability: Denormalization can improve the scalability of a database system by reducing the number of tables and improving the overall performance.

Disadvantages:
1: Reduced Data Integrity: By adding redundant data, denormalization can reduce data integrity and increase the risk of inconsistencies.

2: Increased Complexity: While denormalization can simplify the database schema in some cases, it can also increase complexity by introducing redundant data.

3: Increased Storage Requirements: By adding redundant data, denormalization can increase storage requirements and increase the cost of maintaining the database.