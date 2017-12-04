Use shop;
SELECT product.maker from product, pc
WHERE product.model = pc.model AND pc.model IN 
		(
			SELECT model FROM pc
			WHERE speed = 
            (
				SELECT MAX(speed) FROM 
                (
					SELECT model, speed FROM pc
					WHERE (ram = (SELECT MIN(ram) FROM pc))
				) 
                AS min_ram_model
			)
		)
        AND product.maker IN 
        (
			SELECT maker from product
            WHERE (type = 'Printer')
		);
