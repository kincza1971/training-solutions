CREATE SCHEMA IF NOT EXISTS covid default character set utf8 collate utf8_hungarian_ci;

CREATE TABLE `zipcodes` (
	`zipcode` INT(4) UNSIGNED NOT NULL,
	`city` VARCHAR(50) NOT NULL DEFAULT '',
	`district` VARCHAR(50) NOT NULL DEFAULT '',
	PRIMARY KEY (`zipcode`, `city`, `district`)
)
COMMENT='zip codes, and city name that assigned to'
COLLATE='utf8mb4_hungarian_ci'
;
