Use shop;
select distinct p1.model, p2.model, p1.speed, p1.ram 
from shop.pc p1, shop.pc p2 
where p1.speed = p2.speed and p1.ram = p2.ram and p1.model > p2.model