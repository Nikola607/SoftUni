CREATE DATABASE `Table_Relations_Excercise`;

USE `Table_Relations_Excercise`;

#01. One-To-One Relationship
CREATE TABLE `passports`(
`passport_id` INT PRIMARY KEY AUTO_INCREMENT,
`passport_number` VARCHAR(45) UNIQUE
);

ALTER TABLE `passports` AUTO_INCREMENT = 101;
INSERT INTO `passports`(`passport_number`)
VALUES ("N34FG21B"),
("K65LO4R7"),
("ZE657QP2");

CREATE TABLE `people`(
`person_id` INT PRIMARY KEY AUTO_INCREMENT, 
`first_name` VARCHAR(45),
`salary` DECIMAL(10, 2), 
`passport_id` INT UNIQUE, 
CONSTRAINT fk_people_passports
FOREIGN KEY (`passport_id`)
REFERENCES`passports`(`passport_id`)
);

INSERT INTO `people`
VALUES
(1, "Roberto", 43300.00, 102),
(2, "Tom", 56100.00, 103),
(3, "Yana", 60200.00, 101);

#02. One-To-Many Relationship
CREATE TABLE `manufacturers`(
`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
`established_on` DATE
);

INSERT INTO `manufacturers`(`name`, `established_on`)
VALUES
("BMW", '1916-03-01'),
("Tesla", '2003-01-01'),
("Lada", '1966-05-01');

CREATE TABLE `models` (
`model_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45),
`manufacturer_id` INT,
CONSTRAINT fk_manufacturers
FOREIGN KEY(`manufacturer_id`)
REFERENCES `manufacturers`(`manufacturer_id`)
);
ALTER TABLE `models` AUTO_INCREMENT = 101;

INSERT INTO `models`(`name`, `manufacturer_id`)
VALUES
("X1", 1),
("i6", 1),
("Model S", 2),
("Model X", 2),
("Model 3", 2),
("Nova", 3);

#03. Many-To-Many Relationship
CREATE TABLE  `exams`(
`exam_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);

ALTER TABLE `exams` AUTO_INCREMENT = 101;
INSERT INTO `exams`(`name`)
VALUES
("Spring MVC"),
("Neo4j"),
("Oracle 11g");

CREATE TABLE `students` (
`student_id` INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(45)
);

INSERT INTO `students`(`name`)
VALUES
("Mila"),
("Toni"),
("Ron");

CREATE TABLE `students_exams` (
`student_id` INT,
`exam_id` INT,
CONSTRAINT pk_students_exams
PRIMARY KEY (`student_id`, `exam_id`),
CONSTRAINT fk_students_exams
FOREIGN KEY (`student_id`)
REFERENCES `students`(`student_id`),
CONSTRAINT fk_exams
FOREIGN KEY (`exam_id`)
REFERENCES `exams`(`exam_id`)
);

INSERT INTO `students_exams`
VALUES
(1, 101),
(1, 102),
(2, 101),
(3, 103),
(2, 102),
(2, 103);

#04. Self-Referencing




