CREATE DATABASE tasksdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE USER 'tasksuser'@'localhost' IDENTIFIED BY 'Taskspass@123';

SELECT user, host FROM mysql.user;

GRANT ALL PRIVILEGES ON tasksdb.* TO 'tasksuser'@'localhost';

FLUSH PRIVILEGES;

# IF THE PASSWORD NOT PASS THE VALIDATION POLICY 

SHOW VARIABLES LIKE 'validate_password%';

SELECT VALIDATE_PASSWORD_STRENGTH('Taskspass@123');