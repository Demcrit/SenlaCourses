Use shop;
select distinct product.maker 
from product join pc on product.model=pc.model 
where speed>=750 and maker in 
( select product.maker 
from product join laptop on product.model=laptop.model 
where speed>=750 )