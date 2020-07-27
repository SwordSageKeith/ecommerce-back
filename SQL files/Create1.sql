USE `etsy`;

CREATE TABLE `users` (
	`userID` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `username` varCHAR(30) NOT NULL,
    `email` varCHAR(50) NOT NULL,
    `password` varchar(50) NOT NULL
);

