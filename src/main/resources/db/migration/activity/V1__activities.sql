
create schema if not exists activitytracker default character set utf8 collate utf8_hungarian_ci;

CREATE TABLE `activity_type` (
	`type_id` INT(4) UNSIGNED NOT NULL AUTO_INCREMENT,
	`type_name` VARCHAR(255) NOT NULL COLLATE 'utf8_hungarian_ci',
	PRIMARY KEY (`type_id`) USING BTREE
)
COLLATE='utf8_hungarian_ci'
ENGINE=InnoDB
;


CREATE TABLE `activities` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`start_time` TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	`activity_desc` VARCHAR(255) NOT NULL COLLATE 'utf8_hungarian_ci',
	`activity_type` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_hungarian_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1
;

CREATE TABLE `trackpoints` (
	`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`time` DATETIME NOT NULL,
	`lat` FLOAT(12) NOT NULL DEFAULT '0',
	`long` FLOAT(12) NOT NULL DEFAULT '0',
	`activity_id` BIGINT(20) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`) USING BTREE,
	INDEX `FK_TRACkPOINTS_TO_ACTIVITY` (`activity_id`) USING BTREE,
	CONSTRAINT `FK_TRACkPOINTS_TO_ACTIVITY` FOREIGN KEY (`activity_id`) REFERENCES `activitytracker`.`activities` (`id`)
	 ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;



INSERT INTO `activities` (start_time, activity_desc, activity_type) VALUES ('2020-02-12 15:45:02',"Bringázás a Mátrában", "BIKING");
INSERT INTO `activities` (start_time, activity_desc, activity_type) VALUES ('2020-02-13 15:45:02',"Bringázás a Bükkben",
"BIKING");
INSERT INTO `activities` (start_time, activity_desc, activity_type) VALUES ('2020-02-14 15:45:02',"Mászás a Mátrában",
"HIKING");
INSERT INTO `activities` (start_time, activity_desc, activity_type) VALUES ('2020-02-15 15:45:02',"Kosarazás a Mátrában",
"BASKETBALL");
