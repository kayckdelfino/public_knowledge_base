# Database Studies

## Overview

This repository serves as a comprehensive summary of my extensive studies in databases, encompassing courses from the **university**, **Alura**, and **Udemy**. The focus lies on `SQL` and `NoSQL` databases, Database Management Systems (`DBMS`), and various `query languages`.

---

## Summary

- [Database Studies](#database-studies)
  - [Overview](#overview)
  - [Summary](#summary)
  - [DBMS (Database Management System)](#dbms-database-management-system)
  - [SQL vs. NoSQL](#sql-vs-nosql)
    - [SQL (Structured Query Language)](#sql-structured-query-language)
    - [NoSQL (Not Only SQL)](#nosql-not-only-sql)
  - [Fundamental Query Languages](#fundamental-query-languages)
    - [Data Query Language (DQL)](#data-query-language-dql)
      - [SELECT](#select)
    - [Data Manipulation Language (DML)](#data-manipulation-language-dml)
      - [UPDATE](#update)
      - [INSERT](#insert)
      - [DELETE](#delete)
    - [Data Definition Language (DDL)](#data-definition-language-ddl)
      - [CREATE](#create)
      - [ALTER](#alter)
      - [DROP](#drop)
    - [Data Control Language (DCL)](#data-control-language-dcl)
      - [GRANT](#grant)
      - [REVOKE](#revoke)
    - [Data Transaction Language (DTL)](#data-transaction-language-dtl)
      - [BEGIN, COMMIT, ROLLBACK](#begin-commit-rollback)
  - [Advanced Query Concepts](#advanced-query-concepts)
    - [WHERE Clause](#where-clause)
    - [Multiple Table Queries and Table Joins](#multiple-table-queries-and-table-joins)
    - [Aggregation Functions, Grouping, and Ordering](#aggregation-functions-grouping-and-ordering)
    - [Date and Time Functions](#date-and-time-functions)
    - [Subqueries](#subqueries)
  - [Conclusion](#conclusion)

---

## DBMS (Database Management System)

A Database Management System (`DBMS`) is software used to manage databases. It includes tools for `storing`, `retrieving`, and `managing` data efficiently.

Examples are: **MySQL**, **Oracle**, and **MongoDB**.

---

## SQL vs. NoSQL

### SQL (Structured Query Language)

SQL is a language used to manage relational databases. It's primarily designed for structured data and follows a fixed schema. Some examples of SQL databases are `MySQL`, `PostgreSQL`, and `SQLite`.

Example of usage:
```sql
SELECT * FROM employees
WHERE department = 'IT';
```

### NoSQL (Not Only SQL)

NoSQL encompasses a variety of database technologies designed to handle unstructured or semi-structured data. It provides more flexibility and scalability compared to SQL databases. Examples include `MongoDB`, `Cassandra`, and `Redis`.

Example of usage (MongoDB):
```js
db.users.find({ age: { $gt: 18 } });
```

---

## Fundamental Query Languages

In database systems, various query languages serve distinct purposes, categorized into different groups:

<br>

### Data Query Language (DQL)

Data Query Language (DQL) deals with retrieving data from the database.

#### SELECT

The `SELECT` statement in SQL is used to retrieve data from one or more tables in a database. It is one of the most commonly used statements and allows you to specify the columns you want to retrieve along with various clauses for filtering, sorting, and aggregating data.

<details><summary><b>Parameters</b></summary>
<br>

- **Columns:** You can specify the columns to retrieve data from by listing them after the `SELECT` keyword. Use `*` to select all columns or provide specific column names.
- **Table:** Specify the table name from which you want to retrieve data after the `FROM` keyword.
- **Conditions (optional):** Use the `WHERE` clause to filter records based on specific conditions.
- **Ordering (optional):** The `ORDER BY` clause allows you to sort the retrieved data based on specified columns and in ascending or descending order.
- **Aggregation (optional):** Functions like `SUM`, `AVG`, `COUNT`, etc., can be used in combination with `SELECT` for aggregating data.
- **Joins (optional):** Multiple tables can be used in the `FROM` clause, and joins (`INNER JOIN`, `LEFT JOIN`, `RIGHT JOIN`, etc.) can be applied to retrieve data from related tables.

<br>
</details>

<details><summary><b>Example in SQL</b></summary>
<br>

The following example retrieves all columns (`*`) from the `products` table:

```sql
SELECT * FROM products;
```

This SQL query retrieves all columns of data from the `products` table. Adjust the `SELECT` statement by specifying column names or adding conditions, ordering, or aggregation to tailor the retrieved data according to specific requirements.

</details>

<br>

### Data Manipulation Language (DML)

Data Manipulation Language (DML) allows manipulation and modification of data in the database.

#### UPDATE

The `UPDATE` statement in SQL is used to modify existing records in a table by changing the values of specific columns.

<details><summary><b>Parameters</b></summary>
<br>

- **Table:** Specify the table name after the `UPDATE` keyword where you want to modify records.
- **Set:** Use the `SET` keyword followed by column names and their new values to update the records.
- **Conditions (optional):** Use the `WHERE` clause to specify conditions based on which records should be updated. Without a `WHERE` clause, all records in the table will be affected.

<br>
</details>

<details><summary><b>Example in SQL</b></summary>
<br>

The following example increases the `salary` of employees in the 'Sales' department by 10%:

```sql
UPDATE employees
SET salary = salary * 1.1
WHERE department = 'Sales';
```

This SQL query updates the `salary` column in the `employees` table, multiplying the existing salary by 1.1 (increasing it by 10%) only for employees working in the 'Sales' department. Adjust the `UPDATE` statement by changing column names, adjusting values, or adding conditions as necessary to update specific records based on various criteria.

<br>
</details>

#### INSERT

The `INSERT` statement in SQL is used to add new records or rows into a table.

<details><summary><b>Parameters</b></summary>
<br>

- **Table:** Specify the table name after the `INTO` keyword where you want to add new records.
- **Columns (optional):** If you want to specify the columns into which data will be inserted, list them after the table name within parentheses.
- **Values:** Use the `VALUES` keyword followed by the actual values or data you want to insert into the specified columns.

<br>
</details>

<details><summary><b>Example in SQL</b></summary>
<br>

The following example adds a new customer record into the `customers` table with a name and email:

```sql
INSERT INTO customers (name, email)
VALUES ('John Doe', 'john@example.com');
```

This SQL query inserts a new record into the `customers` table with the provided `name` and `email`. Adjust the `INSERT` statement by specifying additional columns and their corresponding values or omit the column names to insert data into all columns based on the table's structure.

<br>
</details>

#### DELETE

The `DELETE` statement in SQL is used to remove records or rows from a table based on specified conditions.

<details><summary><b>Parameters</b></summary>
<br>

- **Table:** Specify the table name after the `FROM` keyword from which you want to delete records.
- **Conditions (optional):** Use the `WHERE` clause to specify conditions based on which records should be deleted. Without a `WHERE` clause, all records in the table will be deleted.

<br>
</details>

<details><summary><b>Example in SQL</b></summary>
<br>

The following example removes records from the `orders` table where the `status` is 'cancelled':

```sql
DELETE FROM orders
WHERE status = 'cancelled';
```

This SQL query deletes records from the `orders` table where the `status` column matches 'cancelled'. Adjust the `DELETE` statement by modifying the conditions or omitting the `WHERE` clause to delete all records in the specified table.

</details>

<br>

### Data Definition Language (DDL)

Data Definition Language (DDL) deals with defining structures and schema in the database.

#### CREATE

The `CREATE` statement in SQL is used to create new database objects, such as tables, views, indexes, or other schema-related elements.

<details><summary><b>Parameters</b></summary>
<br>

- **Object Type:** Specify the type of object you want to create, such as `TABLE`, `VIEW`, `INDEX`, etc.
- **Object Name:** Provide a name for the object you're creating, e.g., `customers` in the case of creating a table.
- **Column Definitions:** Define the columns for the table along with their data types and any constraints like `PRIMARY KEY`, `NOT NULL`, etc.

<br>
</details>

<details><summary><b>Example in SQL</b></summary>
<br>

The following example creates a new table named `customers` with columns for `id`, `name`, and `email`:

```sql
CREATE TABLE customers (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(100)
);
```

This SQL query creates a new table named `customers` with columns `id`, `name`, and `email`. Adjust the `CREATE` statement by modifying column names, data types, constraints, or adding additional columns as needed to define the structure of the table.

</details>

#### ALTER

The `ALTER` statement in SQL is used to modify existing database objects, such as tables, by adding, modifying, or dropping columns, constraints, or other structural elements.

<details><summary><b>Parameters</b></summary>
<br>

- **Object Type:** Specify the type of object you want to alter (`TABLE` in this case).
- **Object Name:** Provide the name of the object you want to modify (`customers` in this example).
- **Action:** Specify the action you want to perform, such as adding a column, modifying a column, dropping a constraint, etc.
- **Column Definition (if adding a column):** Provide the details of the new column being added, such as column name, data type, constraints, etc.

<br>
</details>

<details><summary><b>Example in SQL</b></summary>
<br>

The following example adds a new column `phone` to the existing `customers` table:

```sql
ALTER TABLE customers
ADD COLUMN phone VARCHAR(15);
```

This SQL query modifies the `customers` table by adding a new column named `phone` of type `VARCHAR(15)`. Adjust the `ALTER` statement by modifying columns, dropping columns, or adding other modifications to the table structure as needed.

</details>

#### DROP

The `DROP` statement in SQL is used to remove existing database objects, such as tables, views, indexes, etc.

<details><summary><b>Parameters</b></summary>
<br>

- **Object Type:** Specify the type of object you want to drop (`TABLE` in this example).
- **Object Name:** Provide the name of the object you want to remove (`customers` in this case).

<br>
</details>

<details><summary><b>Example in SQL</b></summary>
<br>

The following example removes the `customers` table from the database:

```sql
DROP TABLE customers;
```

This SQL query deletes the `customers` table from the database. Be cautious when using `DROP` as it permanently deletes the specified object and its data. Ensure that you intend to remove the object before executing the `DROP` statement, as this action cannot be undone.

</details>

<br>

### Data Control Language (DCL)

Data Control Language (DCL) deals with access control and permissions.

#### GRANT

The `GRANT` statement in SQL is used to give specific privileges or permissions to users or roles on database objects.

<details><summary><b>Parameters</b></summary>
<br>

- **Privileges:** Specify the specific privileges or permissions you want to grant (e.g., `SELECT`, `INSERT`, `UPDATE`, `DELETE`, etc.).
- **Object:** Define the object (table, view, etc.) on which the privileges will be granted (`employees` in this example).
- **User or Role:** Specify the user or role to whom you want to grant the privileges (`marketing_team` in this case).

<br>
</details>

<details><summary><b>Example in SQL</b></summary>
<br>

The following example grants the `SELECT` privilege on the `employees` table to the `marketing_team`:

```sql
GRANT SELECT ON employees TO marketing_team;
```

This SQL query grants the `SELECT` privilege on the `employees` table to the `marketing_team` role or user. Adjust the `GRANT` statement by specifying different privileges or changing the object and the user or role to grant the privileges accordingly.

</details>

#### REVOKE

The `REVOKE` statement in SQL is used to remove previously granted privileges or permissions from users or roles on database objects, which were granted using the `GRANT` statement.

<details><summary><b>Parameters</b></summary>
<br>

- **Privileges:** Specify the specific privileges or permissions you want to revoke (e.g., `SELECT`, `INSERT`, `UPDATE`, `DELETE`, etc.).
- **Object:** Define the object (table, view, etc.) from which the privileges will be revoked (`employees` in this example).
- **User or Role:** Specify the user or role from whom you want to revoke the privileges (`marketing_team` in this case).

<br>
</details>

<details><summary><b>Example in SQL</b></summary>
<br>

The following example revokes the `SELECT` privilege on the `employees` table from the `marketing_team`:

```sql
REVOKE SELECT ON employees FROM marketing_team;
```

This SQL query removes the previously granted `SELECT` privilege on the `employees` table from the `marketing_team`. Adjust the `REVOKE` statement by specifying different privileges or changing the object and the user or role from which you want to revoke the privileges.

</details>

<br>

### Data Transaction Language (DTL)

Data Transaction Language (DTL) manages transactions ensuring data integrity.

#### BEGIN, COMMIT, ROLLBACK

In SQL, database transactions help maintain data integrity by ensuring that all operations are performed atomically (as a single unit of work). The `BEGIN`, `COMMIT`, and `ROLLBACK` statements are used to manage these transactions.

<details><summary><b>Parameters</b></summary>
<br>

- **BEGIN:** Initiates a new transaction. All subsequent database operations are treated as part of this transaction until it's committed or rolled back.
- **COMMIT:** Saves the changes made within the transaction to the database. Once committed, the changes become permanent.
- **ROLLBACK:** Reverts the changes made within the transaction, discarding any modifications made and returning the data to its state before the transaction began.

<br>
</details>

<details><summary><b>Example in SQL</b></summary>
<br>

```sql
BEGIN TRANSACTION;
-- Perform database operations
COMMIT;
```

This SQL example starts a transaction with `BEGIN TRANSACTION`, executes a set of database operations (which can include `INSERT`, `UPDATE`, `DELETE`, etc.), and then saves these changes to the database using `COMMIT`. If any issues arise during the transaction or if you need to discard the changes, you can use `ROLLBACK` to revert the modifications made during the transaction.

</details>
<br>

Transactions help ensure that a series of database operations either succeed entirely or fail entirely, maintaining data consistency and integrity.

**Note:** Transaction handling might differ slightly among different database management systems (DBMS), but the fundamental concepts of `BEGIN`, `COMMIT`, and `ROLLBACK` remain consistent across most SQL-based databases.

---

## Advanced Query Concepts

In addition to the fundamental query languages and data manipulation statements covered earlier, understanding advanced query concepts is crucial for performing complex operations and extracting specific information from databases efficiently.

### WHERE Clause

The `WHERE` clause in SQL is used to filter records based on specified conditions. It allows for the extraction of data that meets specific criteria.

<details><summary><b>Example in SQL</b></summary>
<br>

```sql
SELECT * FROM employees
WHERE department = 'IT';
```

This SQL query retrieves all columns from the `employees` table where the `department` is 'IT'. Adjust the `WHERE` clause by adding different conditions to filter data according to your requirements.

</details>
<br>

### Multiple Table Queries and Table Joins

Queries involving multiple tables often require table joins to combine data from different sources using common fields.

<details><summary><b>Example of a Join in SQL</b></summary>
<br>

```sql
SELECT customers.name, orders.order_id
FROM customers
INNER JOIN orders ON customers.customer_id = orders.customer_id;
```

This SQL query executes an `INNER JOIN` operation between the `customers` and `orders` tables, linking records based on the `customer_id` column. It retrieves the `name` from the `customers` table and the `order_id` from the `orders` table. Exploring different types of joins (`INNER`, `LEFT`, `RIGHT`, `FULL`) can be beneficial to tailor your data retrieval according to specific requirements.

</details>
<br>

For further documentation, supplementary information can be found on [GeeksforGeeks](https://www.geeksforgeeks.org/sql-join-set-1-inner-left-right-and-full-joins/) or [W3Schools](https://www.w3schools.com/sql/sql_join.asp).

### Aggregation Functions, Grouping, and Ordering

Aggregation functions (e.g., `SUM`, `AVG`, `COUNT`) allow summarizing data. Grouping and ordering help arrange and organize data output.

<details><summary><b>Example of Aggregation and Grouping in SQL</b></summary>
<br>

```sql
SELECT department, AVG(salary) AS avg_salary
FROM employees
GROUP BY department
ORDER BY avg_salary DESC;
```

This SQL query calculates the average salary for each `department` from the `employees` table, then groups the results by `department` and orders them in descending order based on average salary (`avg_salary`).

</details>
<br>

### Date and Time Functions

SQL offers various functions to manipulate and extract information from date and time data types.

<details><summary><b>Example of Date and Time Functions in SQL</b></summary>
<br>

```sql
SELECT DATE_FORMAT(order_date, '%Y-%m-%d') AS formatted_date
FROM orders;
```

This SQL query retrieves the `order_date` from the `orders` table and formats it using the `DATE_FORMAT` function to display the date in the specified format (`%Y-%m-%d`). Explore different date functions available in your database system for diverse operations.

</details>
<br>

### Subqueries

Subqueries are queries nested within other queries, allowing for complex data retrieval and manipulation.

<details><summary><b>Example of a Subquery in SQL</b></summary>
<br>

```sql
SELECT name, salary
FROM employees
WHERE department_id IN (
    SELECT department_id
    FROM departments
    WHERE location = 'New York'
);
```

This SQL query retrieves `name` and `salary` from the `employees` table for employees working in departments located in 'New York'. The inner query (`SELECT department_id FROM departments WHERE location = 'New York'`) retrieves department IDs in New York, which are then used as criteria for the outer query.

</details>

---

## Conclusion

This repository delineates the `core principles` underpinning `SQL` and `NoSQL` databases, Database Management Systems (`DBMS`), and a diverse array of `query languages` pivotal for data manipulation and management.