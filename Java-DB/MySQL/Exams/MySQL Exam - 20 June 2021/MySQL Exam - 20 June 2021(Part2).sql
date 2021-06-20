USE `stc`;

#02. Insert
INSERT INTO `clients`(`full_name`, `phone_number`)
SELECT CONCAT_WS(' ', `first_name`, `last_name`) AS `full_name`, CONCAT('(088) 9999', `id` * 2) AS phonn_number
FROM `drivers`
WHERE `id` BETWEEN 10 AND 20;

#03. Update
UPDATE cars
SET `condition` = 'C'
WHERE mileage>= 800000 
OR mileage IS NULL 
AND year<= 2010 
AND make NOT IN('Mercedes-Benz');

#04. Delete
DELETE FROM `clients` 
WHERE `id` NOT IN (SELECT `client_id` FROM `courses`)
AND LENGTH(`full_name`) > 3;

#05. Cars
SELECT `make`, `model`, `condition` 
FROM `cars`
ORDER BY `id`;

#06. Drivers and Cars
SELECT d.`first_name`, d.`last_name`, c.`make`, c.`model`, c.`mileage`
FROM `cars` AS c
JOIN `cars_drivers` AS cd
ON c.`id` = cd.`car_id`
JOIN `drivers` AS d
ON cd.`driver_id` = d.`id`
WHERE `mileage` IS NOT NULL
ORDER BY `mileage` DESC, `first_name`;

#07. Number of courses
SELECT c.`id`, c.`make`, c.`mileage`, COUNT(cou.`car_id`) AS `count_of_courses`,ROUND(AVG(cou.`bill`),2) AS `average_bill`
FROM `cars` AS c
LEFT JOIN `courses` AS cou
ON c.`id` = cou.`car_id`
GROUP BY c.`id`
HAVING `count_of_courses` <> 2
ORDER BY `count_of_courses` DESC, c.`id`;

#08. Regular clients
SELECT cl.full_name, COUNT(c.id) AS count_cars,
SUM(co.bill) AS total_sum
FROM clients cl
JOIN courses co ON cl.id = co.client_id
JOIN cars c ON co.car_id = c.id
GROUP BY cl.id
HAVING cl.full_name LIKE '_a%' AND count_cars > 1
ORDER BY cl.full_name;

#09. Full info for courses
SELECT a.`name`, CASE
	WHEN HOUR(co.`start`) BETWEEN 6 AND 20 THEN 'Day'
    ELSE 'Night'
END AS `day_time`, co.`bill`, cl.`full_name`, c.`make`, c.`model`, cat.`name`
FROM `cars` AS c
JOIN `categories` AS cat
ON c.`category_id` = cat.`id`
JOIN `courses` AS co
ON c.`id` = co.`car_id`
JOIN `addresses` AS a
ON co.`from_address_id` = a.`id`
JOIN `clients` AS cl
ON co.`client_id` = cl.`id`
ORDER BY co.`id`;

#10. Find all courses by client’s phone number
DELIMITER $$
CREATE FUNCTION udf_courses_by_client(`phone_num` VARCHAR(20))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE e_count INT;
    SET e_count = (SELECT COUNT(co.`id`) FROM `clients` AS cl
    JOIN `courses` AS co
    ON cl.`id` = co.`client_id`
    WHERE cl.`phone_number` = `phone_num`
    );
RETURN e_count;
END $$

SELECT udf_courses_by_client ('(803) 6386812') as `count`; 

#11. Full info for address
DELIMITER $$ 
CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))
BEGIN
SELECT a.`name`, cl.`full_name`, (
    CASE 
        WHEN co.`bill`<=20 THEN 'Low'
        WHEN co.`bill`<=30 THEN 'Medium'
                ELSE 'High'
    END)  AS 'level_of_bill', c.`make`, c.`condition`, ca.`name` AS 'cat_name' FROM addresses AS a
JOIN courses AS co ON co.`from_address_id` = a.`id`
JOIN cars AS c ON co.`car_id` = c.`id`
JOIN clients AS cl ON co.`client_id`= cl.`id`
JOIN categories AS ca ON c.`category_id` = ca.`id`
WHERE a.`name` =  address_name
ORDER BY c.`make`, cl.`full_name`;
END $$

CALL udp_courses_by_address('700 Monterey Avenue');
