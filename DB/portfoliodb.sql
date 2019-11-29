-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema portfoliodb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `portfoliodb` ;

-- -----------------------------------------------------
-- Schema portfoliodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `portfoliodb` DEFAULT CHARACTER SET utf8 ;
USE `portfoliodb` ;

-- -----------------------------------------------------
-- Table `user_profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_profile` ;

CREATE TABLE IF NOT EXISTS `user_profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NULL,
  `last_name` VARCHAR(100) NULL,
  `city` VARCHAR(100) NULL,
  `state` VARCHAR(100) NULL,
  `profile_picture_url` TEXT NULL,
  `bio` TEXT NULL,
  `images` BLOB NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_account` ;

CREATE TABLE IF NOT EXISTS `user_account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_profile_id` INT NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  `email` VARCHAR(254) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `password_salt` VARCHAR(64) NULL,
  `password_hash_algorithm` VARCHAR(64) NULL,
  `password_reminder_token` VARCHAR(100) NULL,
  `password_reminder_expire` TIMESTAMP NULL,
  `email_confirmation_token` VARCHAR(100) NULL,
  `registration_time` TIMESTAMP NULL,
  `active` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`, `user_profile_id`),
  INDEX `fk_user_account_user_profile_idx` (`user_profile_id` ASC),
  CONSTRAINT `fk_user_account_user_profile`
    FOREIGN KEY (`user_profile_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `portfolio` ;

CREATE TABLE IF NOT EXISTS `portfolio` (
  `id` INT NOT NULL,
  `user_profile_id` INT NOT NULL,
  PRIMARY KEY (`id`, `user_profile_id`),
  INDEX `fk_portfolio_user_profile1_idx` (`user_profile_id` ASC),
  CONSTRAINT `fk_portfolio_user_profile1`
    FOREIGN KEY (`user_profile_id`)
    REFERENCES `user_profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `coin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coin` ;

CREATE TABLE IF NOT EXISTS `coin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `logo` TEXT NULL,
  `exchange` VARCHAR(100) NULL,
  `trading_pair` VARCHAR(45) NULL,
  `purchase_date` DATE NULL,
  `purchase_time` TIME NULL,
  `buy_price` DOUBLE NULL,
  `amount_purchased` DOUBLE NULL,
  `exchange_fee` DOUBLE NULL,
  `notes` TEXT NULL,
  `portfolio_id` INT NOT NULL,
  PRIMARY KEY (`id`, `portfolio_id`),
  INDEX `fk_coin_portfolio1_idx` (`portfolio_id` ASC),
  CONSTRAINT `fk_coin_portfolio1`
    FOREIGN KEY (`portfolio_id`)
    REFERENCES `portfolio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS portfolioUser@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'portfolioUser'@'localhost' IDENTIFIED BY 'portUser';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'portfolioUser'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user_profile`
-- -----------------------------------------------------
START TRANSACTION;
USE `portfoliodb`;
INSERT INTO `user_profile` (`id`, `first_name`, `last_name`, `city`, `state`, `profile_picture_url`, `bio`, `images`) VALUES (1, 'Richard', 'Newman', 'Denver', 'Colorado', NULL, 'Life, liberty, crypto!', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_account`
-- -----------------------------------------------------
START TRANSACTION;
USE `portfoliodb`;
INSERT INTO `user_account` (`id`, `user_profile_id`, `username`, `email`, `password`, `password_salt`, `password_hash_algorithm`, `password_reminder_token`, `password_reminder_expire`, `email_confirmation_token`, `registration_time`, `active`) VALUES (1, 1, 'rick', 'rick@richardnewman.dev', '123', NULL, NULL, NULL, NULL, NULL, '2019-11-29 14:49:00', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `portfolio`
-- -----------------------------------------------------
START TRANSACTION;
USE `portfoliodb`;
INSERT INTO `portfolio` (`id`, `user_profile_id`) VALUES (1, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `coin`
-- -----------------------------------------------------
START TRANSACTION;
USE `portfoliodb`;
INSERT INTO `coin` (`id`, `logo`, `exchange`, `trading_pair`, `purchase_date`, `purchase_time`, `buy_price`, `amount_purchased`, `exchange_fee`, `notes`, `portfolio_id`) VALUES (1, NULL, 'Kraken', 'XBT/USD', '2019-11-29', '14:54:00', 7722.40, 1, 0.0012, NULL, 1);

COMMIT;

