-- Challenge statement: https://www.hackerrank.com/challenges/placements/problem
-- 
-- You are given three tables: Students, Friends and Packages. Students contains two columns: ID and Name. Friends contains two columns: ID and Friend_ID (ID of the ONLY best friend). Packages contains two columns: ID and Salary (offered salary in $ thousands per month).
-- 
-- [image](https://s3.amazonaws.com/hr-challenge-images/12895/1443820186-2a9b4939a8-1.png)
-- 
-- Write a query to output the names of those students whose best friends got offered a higher salary than them. Names must be ordered by the salary amount offered to the best friends. It is guaranteed that no two students got same salary offer.
-- 
-- Sample Input
-- [image](https://s3.amazonaws.com/hr-challenge-images/12895/1443820079-9bd1e231b1-2_1.png)
-- [image](https://s3.amazonaws.com/hr-challenge-images/12895/1443820100-adb691b2f5-2_2.png)
-- 
-- Sample Output
-- Samantha
-- Julia
-- Scarlet
-- 
-- Explanation
-- See the following table:
-- [image](https://s3.amazonaws.com/hr-challenge-images/12895/1443819966-c37c146d27-3.png)
-- 
-- Now,
-- * Samantha's best friend got offered a higher salary than her at 11.55
-- * Julia's best friend got offered a higher salary than her at 12.12
-- * Scarlet's best friend got offered a higher salary than her at 15.2
-- * Ashley's best friend did NOT get offered a higher salary than her
-- 
-- The name output, when ordered by the salary offered to their friends, will be:
-- * Samantha
-- * Julia
-- * Scarlet


SELECT students.name
FROM students
JOIN friends ON friends.id = students.id
JOIN packages spkg ON spkg.id = students.id 
JOIN packages fpkg ON fpkg.id = friends.friend_id
WHERE fpkg.salary > spkg.salary
ORDER BY fpkg.salary;