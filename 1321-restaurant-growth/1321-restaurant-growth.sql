# Write your MySQL query statement below
WITH DailySales AS (
    SELECT 
        visited_on,
        SUM(amount) AS daily_amount
    FROM Customer
    GROUP BY visited_on
),
MovingWindow AS (
    SELECT 
        visited_on,
        SUM(daily_amount) OVER (
            ORDER BY visited_on 
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS amount,
        ROUND(
            AVG(daily_amount) OVER (
                ORDER BY visited_on 
                ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
            ), 
            2
        ) AS average_amount,
        COUNT(*) OVER (
            ORDER BY visited_on 
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS day_count
    FROM DailySales
)
SELECT 
    visited_on,
    amount,
    average_amount
FROM MovingWindow
WHERE day_count = 7
ORDER BY visited_on ASC;
