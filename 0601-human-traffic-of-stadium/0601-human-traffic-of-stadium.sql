# Write your MySQL query statement below
WITH FilteredStadium AS (
    SELECT 
        id,
        visit_date,
        people,
        id - ROW_NUMBER() OVER (ORDER BY id) AS grp
    FROM Stadium
    WHERE people >= 100
),
GroupedCounts AS (
    SELECT 
        id,
        visit_date,
        people,
        COUNT(*) OVER (PARTITION BY grp) AS streak_length
    FROM FilteredStadium
)
SELECT 
    id,
    visit_date,
    people
FROM GroupedCounts
WHERE streak_length >= 3
ORDER BY visit_date ASC;
