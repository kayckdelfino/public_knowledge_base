-- Challenge statement: https://www.hackerrank.com/challenges/weather-observation-station-16/problem
-- 
-- Query the smallest Northern Latitude (LAT_N) from STATION that is greater than 38.7780. Round your answer to 4 decimal places.
-- 
-- Input Format
-- The STATION table is described as follows:
-- <image>(https://s3.amazonaws.com/hr-challenge-images/9336/1449345840-5f0a551030-Station.jpg)
-- 
-- where LAT_N is the northern latitude and LONG_W is the western longitude.


SELECT round(min(lat_n), 4)
FROM station
WHERE lat_n > 38.778;