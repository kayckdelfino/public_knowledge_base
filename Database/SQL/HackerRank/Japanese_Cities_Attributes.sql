-- Query all attributes of every Japanese city in the CITY table. The COUNTRYCODE for Japan is JPN.
-- 
-- The CITY table is described as follows:
-- 
-- <image>(https://s3.amazonaws.com/hr-challenge-images/8137/1449729804-f21d187d0f-CITY.jpg


SELECT *
FROM city
WHERE countrycode = "JPN";