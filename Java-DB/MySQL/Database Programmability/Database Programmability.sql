USE `soft_uni`;

#01. Employees with Salary Above 35000
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000()
BEGIN
	SELECT `first_name`, `last_name` 
    FROM `employees`
    WHERE `salary` > 35000
    ORDER BY `first_name`, `employee_id`;
END
call usp_get_employees_salary_above_35000();

#02. Employees with Salary Above Number
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(salary_level DECIMAL(10, 4))
BEGIN
	SELECT `first_name`, `last_name` 
    FROM `employees`
    WHERE `salary` >= salary_level
    ORDER BY `first_name`, `last_name`, `employee_id`;
END $$
call usp_get_employees_salary_above(45000);

#03. Town Names Starting With
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(start_string VARCHAR(50))
BEGIN
	SELECT `name`
    FROM `towns`
    WHERE substring(`name`, 1, char_length(start_string)) = start_string
    ORDER BY `name`;
END $$
call usp_get_towns_starting_with('b');

#04. Employees from Town
DELIMITER $$ 
CREATE PROCEDURE usp_get_employees_from_town(town_name VARCHAR(50))
BEGIN
	SELECT e.`first_name`, e.`last_name`
    FROM `employees` AS e
    JOIN `addresses` AS a
    ON e.`address_id` = a.`address_id`
    JOIN `towns` AS t
    ON a.`town_id` = t.`town_id`
    WHERE t.`name` = town_name
    ORDER BY e.`first_name`, e.`last_name`, e.`employee_id`;
END $$
call usp_get_employees_from_town('Sofia');

#05. Salary Level Function
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(10, 4))
RETURNS VARCHAR(50)
DETERMINISTIC
BEGIN
	DECLARE salary_level VARCHAR(50);
    SET salary_level = case
			WHEN `salary` < 30000 THEN 'Low'
            WHEN `salary` BETWEEN 30000 AND 50000 THEN 'Average'
			ELSE 'High'
	END;
    RETURN salary_level;
END;

#06. Employees by Salary Level
CREATE PROCEDURE usp_get_employees_by_salary_level(salary_level VARCHAR(10))
BEGIN
	SELECT `first_name`, `last_name` 
    FROM `employees`
    WHERE salary_level = (SELECT ufn_get_salary_level(`salary`))
    ORDER BY `first_name` DESC, `last_name` DESC;
END;
call usp_get_employees_by_salary_level('High');



