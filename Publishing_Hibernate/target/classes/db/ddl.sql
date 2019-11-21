CREATE USER IF NOT EXISTS 'mharrop'@'localhost' IDENTIFIED BY 'mharrop';

DROP DATABASE IF EXISTS PUBLISHINGDB;
CREATE DATABASE PUBLISHINGDB;
USE PUBLISHINGDB;
GRANT ALL PRIVILEGES ON PUBLISHINGDB.* TO 'mharrop'@'localhost';
FLUSH PRIVILEGES;

/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+5:00';