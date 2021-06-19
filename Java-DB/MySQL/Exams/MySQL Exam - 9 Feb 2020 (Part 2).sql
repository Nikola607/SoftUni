USE `fsd`;

#02. Insert
INSERT INTO `coaches`(`first_name`, `last_name`, `salary`, `coach_level`)
SELECT `first_name`, `last_name`, 2 * `salary`, CHAR_LENGTH(`first_name`) AS `coach_level`
FROM `players`
WHERE `age` >= 45;

#03. Ubdate
UPDATE `coaches`
SET `coach_level` = `coach_level` + 1
WHERE (SELECT COUNT(coach_id) FROM `players_coaches`
WHERE `id` = `coach_id`) > 0 AND `first_name` LIKE 'A%';

#04. Delete
DELETE FROM `players`
WHERE `age` >= 45;

#05. Players
SELECT `first_name`, `age`, `salary`
FROM `players`
ORDER BY `salary` DESC;

#06. Young offense players without contract
SELECT p.`id`, CONCAT_WS(' ', p.`first_name`, p.`last_name`) AS `full_name`, p.`age`, p.`position`, p.`hire_date`
FROM `players` AS p
JOIN `skills_data` AS sk
ON p.`skills_data_id` = sk.`id`
WHERE p.`age` < 23 AND p.`position` = 'A'
AND p.`hire_date` IS NULL AND sk.`strength` > 50
ORDER BY p.`salary`, p.`age`;

#07. Detail info for all teams
SELECT t.`name`, t.`established`, t.`fan_base`, COUNT(p.`id`) AS `players_count`
FROM `teams` AS t
LEFT JOIN `players` as p
ON t.`id` = p.`team_id`
GROUP BY t.`id`
ORDER BY `players_count` DESC, t.`fan_base` DESC;

#08. The fastest player by towns
SELECT MAX(sk.`speed`) AS `max_speed`, t.`name` 
FROM `skills_data` AS sk
LEFT JOIN `players` AS p
ON sk.`id` = p.`skills_data_id`
LEFT JOIN `teams` AS tm
ON p.`team_id` = tm.`id`
LEFT JOIN `stadiums` AS s
ON tm.`stadium_id` = s.`id`
LEFT JOIN `towns` AS t
ON s.`town_id`= t.`id`
WHERE tm.`name` != "Devify"
GROUP BY t.`name`
ORDER BY `max_speed` DESC, t.`name`;

#09. Total salaries and players by country
SELECT c.`name`, COUNT(p.`id`) AS `total_count_of_players`, SUM(p.`salary`) AS `total_sum_of_salaries`
FROM `countries` AS c
JOIN `towns` AS t ON c.`id` = t.`country_id`
JOIN `stadiums` AS s ON t.`id` = s.`town_id`
JOIN `teams` AS tm ON s.`id` = tm.`stadium_id`
JOIN `players` AS p ON tm.`id` = p.`team_id`
GROUP BY c.`name`
ORDER BY `total_count_of_players` DESC, c.`name`;


