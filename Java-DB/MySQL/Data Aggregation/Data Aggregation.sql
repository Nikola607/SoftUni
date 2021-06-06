USE gringotts;

#01. Records’ Count
SELECT COUNT(*) FROM `wizzard_deposits`;

#02. Longest Magic Wand
SELECT MAX(`magic_wand_size`)  AS `longest_magic_wand` FROM `wizzard_deposits`;

#03. Longest Magic Wand per Deposit Groups
SELECT `deposit_group`, MAX(`magic_wand_size`) AS `longest_magic_wand`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `magic_wand_size` DESC, `deposit_group`;

#04. Smallest Deposit Group per Magic Wand Size
SELECT `deposit_group` FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY AVG(`magic_wand_size`)
LIMIT 1;

#05. Deposits Sum
SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum`;

#06. Deposits Sum for Ollivander Family
SELECT `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM `wizzard_deposits`
WHERE `magic_wand_creator` = "Ollivander family"
GROUP BY `deposit_group`
ORDER BY `deposit_group`;
