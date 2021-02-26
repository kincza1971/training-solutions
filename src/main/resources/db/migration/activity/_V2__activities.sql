CREATE TABLE `activity_type` (
	`type_id` INT(4) UNSIGNED NOT NULL AUTO_INCREMENT,
	`type_name` VARCHAR(255) NOT NULL COLLATE 'utf8_hungarian_ci',
	PRIMARY KEY (`type_id`) USING BTREE
)
COLLATE='utf8_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1
;
