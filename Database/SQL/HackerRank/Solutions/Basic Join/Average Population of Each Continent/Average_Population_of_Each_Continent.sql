-- Challenge statement: https://www.hackerrank.com/challenges/average-population-of-each-continent/problem
-- 
-- Given the CITY and COUNTRY tables, query the names of all the continents (COUNTRY.Continent) and their respective average city populations (CITY.Population) rounded down to the nearest integer.
-- 
-- Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
-- 
-- Input Format
-- The CITY and COUNTRY tables are described as follows:
-- 
-- <image>(https://s3.amazonaws.com/hr-challenge-images/8137/1449729804-f21d187d0f-CITY.jpg)
-- 
-- <image>(https://s3.amazonaws.com/hr-challenge-images/8342/1449769013-e54ce90480-Country.jpg)


SELECT country.continent, floor(avg(city.population))
FROM city
JOIN country ON city.countrycode = country.code
GROUP BY continent;