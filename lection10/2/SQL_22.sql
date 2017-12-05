Use shop;
select pc.speed as speed, avg(pc.price) from pc 
where speed > 600
group by speed