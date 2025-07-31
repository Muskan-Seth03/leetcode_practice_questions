# Write your MySQL query statement below
select w2.id from Weather as w1
join Weather as w2
on w2.recordDate= date_add(w1.recordDate, interval 1 day)
where w1.temperature < w2.temperature;