-- Query the sum of Northern Latitudes (LAT_N) from STATION having values greater than 38.7880 and less than 137.2345. Truncate your answer to 4 decimal places.
-- 
-- Input Format
-- The STATION table is described as follows:
-- <image>(https://s3.amazonaws.com/hr-challenge-images/9336/1449345840-5f0a551030-Station.jpg)
-- 
-- where LAT_N is the northern latitude and LONG_W is the western longitude.


SELECT truncate(sum(lat_n), 4)
FROM station
WHERE lat_n between 38.788 and 137.2345;