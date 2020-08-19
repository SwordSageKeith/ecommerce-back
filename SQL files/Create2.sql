ALTER TABLE `etsy`.`items` 
ADD INDEX `shop_idx` (`shopID` ASC) VISIBLE;
;
ALTER TABLE `etsy`.`items` 
ADD CONSTRAINT `shop`
  FOREIGN KEY (`shopID`)
  REFERENCES `etsy`.`shops` (`shopID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  ALTER TABLE `etsy`.`shops` 
ADD INDEX `user_idx` (`owner` ASC) VISIBLE;
;
ALTER TABLE `etsy`.`shops` 
ADD CONSTRAINT `user`
  FOREIGN KEY (`owner`)
  REFERENCES `etsy`.`users` (`userID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;