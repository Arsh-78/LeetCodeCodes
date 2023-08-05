# Write your MySQL query statement below
SELECT e2.name from Employee e1 INNER JOIN Employee e2 ON e1.managerId = e2.id GROUP BY e2.id HAVING COUNT(e2.id)>=5;