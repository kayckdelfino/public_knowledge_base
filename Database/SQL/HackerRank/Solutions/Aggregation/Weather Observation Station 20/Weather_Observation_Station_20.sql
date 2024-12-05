-- Challenge statement: https://www.hackerrank.com/challenges/weather-observation-station-20/problem
-- 
-- A [median](https://en.wikipedia.org/wiki/Median) is defined as a number separating the higher half of a data set from the lower half. Query the median of the Northern Latitudes (LAT_N) from STATION and round your answer to 4 decimal places.
-- 
-- Input Format
-- The STATION table is described as follows:
-- [Station.jpg](https://s3.amazonaws.com/hr-challenge-images/9336/1449345840-5f0a551030-Station.jpg)
-- 
-- where LAT_N is the northern latitude and LONG_W is the western longitude. 


WITH RankedRows AS (
    SELECT LAT_N, ROW_NUMBER() OVER (ORDER BY LAT_N) AS RowNum
    FROM STATION
),
TotalCount AS (
    SELECT COUNT(*) AS TotalRows
    FROM STATION
),
MedianRow AS (
    SELECT ROUND(AVG(LAT_N), 4) AS Median
    FROM RankedRows, TotalCount
    WHERE RowNum IN (
        CEIL(TotalRows / 2),
        (TotalRows + 1) / 2
    )
)
SELECT Median FROM MedianRow;