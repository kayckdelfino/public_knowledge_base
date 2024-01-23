-- Challenge statement: https://www.hackerrank.com/challenges/weather-observation-station-19/problem
-- 
-- Consider P1(a, c) and P2(b, d) to be two points on a 2D plane where (a, b) are the respective minimum and maximum values of Northern Latitude (LAT_N) and (c, d) are the respective minimum and maximum values of Western Longitude (LONG_W) in STATION.
-- 
-- Query the Euclidean Distance between points P1 and P2 and format your answer to display 4 decimal digits.
-- 
-- Input Format
-- The STATION table is described as follows:
-- 
-- <image>(https://s3.amazonaws.com/hr-challenge-images/9336/1449345840-5f0a551030-Station.jpg)
-- 
-- where LAT_N is the northern latitude and LONG_W is the western longitude.


SELECT round(sqrt(power(max(lat_n) - min(lat_n), 2) + power(max(long_w) - min(long_w), 2)), 4)
FROM station;