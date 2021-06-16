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

#04. Employee Departments
SELECT e.`employee_id`, e.`first_name`, e.`salary`, d.`name`
FROM `employees` AS e
JOIN `departments` AS d
ON d.`department_id` = e.`department_id`
WHERE e.`salary` > 15000
ORDER BY d.`department_id` DESC LIMIT 5;

#05. Employees Without Project
SELECT e.`employee_id`, e.`first_name`
FROM `employees` AS e
LEFT JOIN `employees_projects` AS p
ON p.`employee_id` = e.`employee_id`
WHERE p.`project_id` IS NULL
ORDER BY  `employee_id` DESC LIMIT 3;

#06. Employees Hired After
SELECT e.`first_name`, e.`last_name`, e.`hire_date`, d.`name` FROM
`employees` AS e
JOIN `departments` AS d
ON d.`department_id` = e.`department_id`
WHERE e.`hire_date` > '1999-01-01'
AND d.`name` = 'Sales' 
OR d.`name` = 'Finance'
ORDER BY `hire_date`;

#07. Employees with Project
SELECT e.`employee_id`, e.`first_name`, p.`name` 
FROM `employees` AS e
JOIN `employees_projects` AS ep
USING(`employee_id`)
LEFT JOIN `projects` AS p
USING(`project_id`)
WHERE p.`start_date` > '2002-08-13'
AND p.`end_date` IS NULL
ORDER BY e.`first_name`, p.`name`
LIMIT 5;

