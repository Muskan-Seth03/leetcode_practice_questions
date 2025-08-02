# Write your MySQL query statement below
select p.product_id , 
round(
    ifnull(sum(p.price * ut.units)/ sum(ut.units), 0),
    2
) as average_price
from Prices p
left join UnitsSold ut
on p.product_id = ut.product_id 
and ut.purchase_date >= p.start_date and ut.purchase_date <= p.end_date
group by p.product_id;

