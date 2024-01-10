-- Challenge statement: https://www.hackerrank.com/challenges/revising-aggregations-sum/problem
-- 
-- Query the total population of all cities in CITY where District is California.
-- 
-- Input Format
-- The CITY table is described as follows: <image>(https://s3.amazonaws.com/hr-challenge-images/8137/1449729804-f21d187d0f-CITY.jpg)


SELECT sum(population)
FROM city
WHERE district = "California";