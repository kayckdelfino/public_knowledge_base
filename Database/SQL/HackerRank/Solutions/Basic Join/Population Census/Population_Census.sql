-- Challenge statement: https://www.hackerrank.com/challenges/asian-population/problem
-- 
-- Given the CITY and COUNTRY tables, query the sum of the populations of all cities where the CONTINENT is 'Asia'.
-- 
-- Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
-- 
-- Input Format
-- The CITY and COUNTRY tables are described as follows: CITY.jpg
-- 
-- <image>(https://s3.amazonaws.com/hr-challenge-images/8137/1449729804-f21d187d0f-CITY.jpg)
-- 
-- <image>(https://s3.amazonaws.com/hr-challenge-images/8342/1449769013-e54ce90480-Country.jpg)


SELECT sum(city.population)
FROM city
JOIN country ON city.countrycode = country.code
WHERE country.continent = "Asia";