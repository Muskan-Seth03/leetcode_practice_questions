# Write your MySQL query statement below
select unique_id, name from Employees as e
left outer join EmployeeUNI as eUNI
on e.id = eUNI.id;
