-- administrative SQL script

DROP SCHEMA IF EXISTS retail;
CREATE SCHEMA retail;

USE retail;

-- REVOKE ALL ON *.* FROM 'netbeans'@'localhost'; 
-- DROP USER 'netbeans'@'localhost';
-- CREATE USER 'netbeans'@'localhost' IDENTIFIED BY 'netbeans';
GRANT ALL PRIVILEGES ON retail.* TO 'netbeans'@'localhost';
