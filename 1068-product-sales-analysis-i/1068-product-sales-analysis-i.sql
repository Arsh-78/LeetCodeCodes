/* Write your PL/SQL query statement below */

SELECT product_name,year,price from Sales s LEFT OUTER JOIN Product p on s.product_id = p.product_id;  

-- select product_name,year,price from Sales s inner join Product p on s.product_id = p.product_id;
