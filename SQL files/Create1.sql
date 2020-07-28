USE `etsy`;

CREATE TABLE `users` (
	`userID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `username` varCHAR(30) NOT NULL,
    `email` varCHAR(50) NOT NULL,
    `password` varchar(50) NOT NULL
);

CREATE TABLE `shops` (
	`shopID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50),
    `owner` INT NOT NULL,
    `desc` LONGTEXT,
    `hidden` BOOL NOT NULL DEFAULT TRUE
);

CREATE TABLE `items` (
	`itemID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `shopID` INT NOT NULL,
    `desc` LONGTEXT,
    `price` FLOAT,
    `hidden` BOOL NOT NULL DEFAULT TRUE
);

