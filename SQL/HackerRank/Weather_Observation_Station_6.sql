-- Query the list of CITY names starting with vowels (i.e., a, e, i, o, or u) from STATION. Your result cannot contain duplicates.
-- 
-- Input Format
-- 
-- The STATION table is described as follows:
-- 
-- <image>(https://s3.amazonaws.com/hr-challenge-images/9336/1449345840-5f0a551030-Station.jpg)
-- 
-- where LAT_N is the northern latitude and LONG_W is the western longitude.


SELECT DISTINCT city
FROM station
WHERE LEFT(city, 1) in ("A", "E", "I", "O", "U");