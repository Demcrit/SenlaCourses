Use shop;
select p.maker, max(pc.price) from product as p, pc
where p.model = pc.model group by p.maker