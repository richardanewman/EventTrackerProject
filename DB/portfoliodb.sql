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
  `id` INT NOT NULL AUTO_INCREMENT,
  `portfolio_name` VARCHAR(45) NULL,
  `user_profile_id` INT NULL,
  PRIMARY KEY (`id`),
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
  `portfolio_id` INT NULL,
  `logo` TEXT NULL,
  `name` VARCHAR(100) NULL,
  `trading_pair` VARCHAR(45) NULL,
  `exchange` VARCHAR(100) NULL,
  `purchase_date` DATE NULL,
  `purchase_time` TIME NULL,
  `buy_price` DOUBLE NULL,
  `amount_purchased` DOUBLE NULL,
  `exchange_fee` DOUBLE NULL DEFAULT 0.00,
  `notes` TEXT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_coin_portfolio1_idx` (`portfolio_id` ASC),
  CONSTRAINT `fk_coin_portfolio1`
    FOREIGN KEY (`portfolio_id`)
    REFERENCES `portfolio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `coin_watch_list`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `coin_watch_list` ;

CREATE TABLE IF NOT EXISTS `coin_watch_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `watch_list_name` VARCHAR(45) NULL,
  `user_profile_id` INT NULL,
  `logo_url` TEXT NULL,
  `coin_name` VARCHAR(45) NULL,
  `trading_pair` VARCHAR(45) NULL,
  `exchange` VARCHAR(45) NULL,
  `alert_low` DOUBLE NULL,
  `alert_high` DOUBLE NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_watch_list_user_profile1_idx` (`user_profile_id` ASC),
  CONSTRAINT `fk_watch_list_user_profile1`
    FOREIGN KEY (`user_profile_id`)
    REFERENCES `user_profile` (`id`)
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
INSERT INTO `user_profile` (`id`, `first_name`, `last_name`, `city`, `state`, `profile_picture_url`, `bio`, `images`) VALUES (2, 'Lauren', 'Newman', 'Denver', 'Colorado', NULL, 'Bitcoin maximalist.', NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `user_account`
-- -----------------------------------------------------
START TRANSACTION;
USE `portfoliodb`;
INSERT INTO `user_account` (`id`, `user_profile_id`, `username`, `email`, `password`, `password_salt`, `password_hash_algorithm`, `password_reminder_token`, `password_reminder_expire`, `email_confirmation_token`, `registration_time`, `active`) VALUES (1, 1, 'rick', 'rick@richardnewman.dev', '123', NULL, NULL, NULL, NULL, NULL, '2019-11-29 14:49:00', 1);
INSERT INTO `user_account` (`id`, `user_profile_id`, `username`, `email`, `password`, `password_salt`, `password_hash_algorithm`, `password_reminder_token`, `password_reminder_expire`, `email_confirmation_token`, `registration_time`, `active`) VALUES (2, 2, 'lauren', 'lauren@gmail.com', '123', NULL, NULL, NULL, NULL, NULL, '2019-11-29 16:21:00', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `portfolio`
-- -----------------------------------------------------
START TRANSACTION;
USE `portfoliodb`;
INSERT INTO `portfolio` (`id`, `portfolio_name`, `user_profile_id`) VALUES (1, 'primary', 1);
INSERT INTO `portfolio` (`id`, `portfolio_name`, `user_profile_id`) VALUES (2, 'Golden Egg', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `coin`
-- -----------------------------------------------------
START TRANSACTION;
USE `portfoliodb`;
INSERT INTO `coin` (`id`, `portfolio_id`, `logo`, `name`, `trading_pair`, `exchange`, `purchase_date`, `purchase_time`, `buy_price`, `amount_purchased`, `exchange_fee`, `notes`) VALUES (1, 1, NULL, 'Bitcoin', 'XBT/USD', 'Kraken', '2019-11-29', '14:54:00', 7722.40, 1, 0.0012, 'Bull run!');
INSERT INTO `coin` (`id`, `portfolio_id`, `logo`, `name`, `trading_pair`, `exchange`, `purchase_date`, `purchase_time`, `buy_price`, `amount_purchased`, `exchange_fee`, `notes`) VALUES (2, 2, NULL, 'Bitcoin', 'XBT/USD', 'Kraken', '2012-06-12', '13:00:00', 10.54, 200, 0.00, 'In before the masses.');
INSERT INTO `coin` (`id`, `portfolio_id`, `logo`, `name`, `trading_pair`, `exchange`, `purchase_date`, `purchase_time`, `buy_price`, `amount_purchased`, `exchange_fee`, `notes`) VALUES (3, 2, NULL, 'Ethereum', 'ETH/USD', 'Coinbase', '2019-11-30', '16:00:00', 152.04, 5, 0.00, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `coin_watch_list`
-- -----------------------------------------------------
START TRANSACTION;
USE `portfoliodb`;
INSERT INTO `coin_watch_list` (`id`, `watch_list_name`, `user_profile_id`, `logo_url`, `coin_name`, `trading_pair`, `exchange`, `alert_low`, `alert_high`) VALUES (1, 'Wish List', 1, NULL, 'ETH', 'ETH/USD', 'Coinbase', 125.00, 200.00);
INSERT INTO `coin_watch_list` (`id`, `watch_list_name`, `user_profile_id`, `logo_url`, `coin_name`, `trading_pair`, `exchange`, `alert_low`, `alert_high`) VALUES (2, 'Chopping Block', 2, NULL, 'Cardano', 'ADA/BTC', 'Kraken', 0.02, 0.077);

COMMIT;

