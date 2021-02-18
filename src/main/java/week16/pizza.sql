
CREATE TABLE `pizza` (
	`pizza_id` INT(11) NOT NULL,
	`pizza_name` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`pizza_price` FLOAT(12) NOT NULL,
	PRIMARY KEY (`pizza_id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `customers` (
	`customer_id` INT(11) NOT NULL,
	`customer_name` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`customer_id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;


CREATE TABLE `order` (
	`order_id` INT(11) NOT NULL,
	`customer_id` INT(11) NULL DEFAULT NULL,
	`pizza_id` INT(11) NULL DEFAULT NULL,
	`order_date` DATE NULL DEFAULT NULL,
	PRIMARY KEY (`order_id`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

-- 1
SELECT * FROM customers
ORDER BY 2 DESC;

-- 2

SELECT customer_name FROM customers;

-- 3
SELECT * FROM pizza
ORDER BY pizza_price;

-- 4
SELECT * FROM pizza WHERE pizza_price = (SELECT MAX(pizza_price) FROM pizza);

-- 5
SELECT AVG(pizza_price)
FROM `order` o, pizza p
WHERE o.pizza_id = p.pizza_id;

-- 6
SELECT COUNT(*) FROM customers
WHERE customer_name LIKE "%a%";

-- 7
SELECT * FROM pizza
WHERE pizza_price<1000 OR pizza_name LIKE "%a%";

-- 8
SELECT customer_name, order_date
FROM `order` o, customers c
WHERE o.customer_id = c.customer_id;

-- 9
SELECT order_date, pizza_name
FROM `order` o, pizza p
WHERE o.pizza_id = p.pizza_id;