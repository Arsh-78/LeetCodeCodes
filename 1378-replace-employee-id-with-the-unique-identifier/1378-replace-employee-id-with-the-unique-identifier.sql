# Write your MySQL query statement below
SELECT eu.unique_id,e.name  from Employees as e LEFT JOIN EmployeeUNI as eu ON eu.id=e.id;