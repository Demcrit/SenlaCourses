Use shop;
select p.maker, count(*) from product as p, pc
where p.model = pc.model group by p.maker having count(*) > 3;