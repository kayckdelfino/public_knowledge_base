-- Challenge statement: https://www.hackerrank.com/challenges/weather-observation-station-12/problem
-- 
-- Query the list of CITY names from STATION that do not start with vowels and do not end with vowels. Your result cannot contain duplicates.
-- 
-- Input Format
-- The STATION table is described as follows:
-- 
-- <image>(https://www.hackerrank.com/challenges/weather-observation-station-12/problem?isFullScreen=true)
-- 
-- where LAT_N is the northern latitude and LONG_W is the western longitude.


SELECT DISTINCT city
FROM station
WHERE LEFT(city, 1) not in ("A", "E", "I", "O", "U") and RIGHT(city, 1) not in ("A", "E", "I", "O", "U");