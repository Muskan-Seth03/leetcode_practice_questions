# Write your MySQL query statement below
select r.contest_id , round(
    (count(*) / (select count(*) from Users)) * 100 ,
2) as percentage
from Register r
natural join Users u
group by r.contest_id 
order by percentage desc, r.contest_id asc;