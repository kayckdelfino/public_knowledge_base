-- Challenge statement: https://www.hackerrank.com/challenges/symmetric-pairs/problem
-- 
-- You are given a table, Functions, containing two columns: X and Y.
-- [image](https://s3.amazonaws.com/hr-challenge-images/12892/1443818798-51909e977d-1.png)
-- 
-- Two pairs (X1, Y1) and (X2, Y2) are said to be symmetric pairs if X1 = Y2 and X2 = Y1.
-- 
-- Write a query to output all such symmetric pairs in ascending order by the value of X. List the rows such that X1 ≤ Y1.
-- 
-- Sample Input
-- [image](https://s3.amazonaws.com/hr-challenge-images/12892/1443818693-b384c24e35-2.png)
-- 
-- Sample Output
-- 20 20
-- 20 21
-- 22 23


SELECT f1.x, f1.y
FROM functions AS f1
JOIN functions AS f2
ON f1.x = f2.y AND f1.y = f2.x
WHERE f1.x <= f1.y
GROUP BY f1.x, f1.y
HAVING count(*) > 1 OR (count(*) = 1 AND f1.x != f1.y)
ORDER BY f1.x;