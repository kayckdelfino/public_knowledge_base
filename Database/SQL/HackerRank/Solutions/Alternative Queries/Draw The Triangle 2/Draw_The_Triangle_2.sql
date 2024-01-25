-- Challenge statement: https://www.hackerrank.com/challenges/draw-the-triangle-2/problem
-- 
-- P(R) represents a pattern drawn by Julia in R rows. The following pattern represents P(5):
-- 
-- * 
-- * * 
-- * * * 
-- * * * * 
-- * * * * *
-- 
-- Write a query to print the pattern P(20).


SET @row = 0;

SELECT repeat("* ", @row := @row + 1)
FROM information_schema.tables
LIMIT 20;