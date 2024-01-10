-- Challenge statement: https://www.hackerrank.com/challenges/average-population/problem
-- 
-- Query the average population for all cities in CITY, rounded down to the nearest integer.
-- 
-- Input Format
-- The CITY table is described as follows: <image>(https://s3.amazonaws.com/hr-challenge-images/8137/1449729804-f21d187d0f-CITY.jpg)


SELECT floor(avg(population))
FROM city;