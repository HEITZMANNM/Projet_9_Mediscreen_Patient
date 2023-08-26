DROP DATABASE Mediscreen;
CREATE DATABASE Mediscreen;
USE Mediscreen;

DROP TABLE IF EXISTS `patient`;

CREATE TABLE `patient` (
  `id` int NOT NULL AUTO_INCREMENT,
  `gender` varchar(100) NOT NULL,
  `address` varchar(250) NOT NULL,
  `birth_date` datetime DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone_Number` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
)