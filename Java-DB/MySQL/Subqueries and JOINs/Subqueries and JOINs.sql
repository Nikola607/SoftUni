USE `soft_uni`;

#01. Employee Address
SELECT e.`employee_id`, e.`job_title`, a.`address_id`, a.`address_text` 
FROM `employees` AS e
JOIN `addresses` AS a
USING(`address_id`)
ORDER BY a.`address_id`
LIMIT 5;

#02. Addresses with Towns
SELECT e.`first_name`, e.`last_name`, t.`name` AS `town`, a.`address_text`
FROM `employees` AS e
JOIN `addresses` AS a
ON e.`address_id` = a.`address_id`
JOIN `towns` AS t
ON t.`town_id` = a.`town_id`
ORDER BY e.`first_name`, e.`last_name`
LIMIT 5;

#03. Sales Employee
SELECT e.`employee_id`, e.`first_name`, e.`last_name`, d.`name` AS `department_name`
FROM `employees` AS e
JOIN `departments` AS d
ON d.`department_id` = e.`department_id`
WHERE d.`name` = "Sales"
ORDER BY e.`employee_id` DESC;



