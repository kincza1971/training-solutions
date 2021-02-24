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

INSERT INTO `activities` (start_time, activity_desc, activity_type) VALUES ('2020-02-12 15:45:02',"Bringázás a Mátrában", "BIKING");
INSERT INTO `activities` (start_time, activity_desc, activity_type) VALUES ('2020-02-13 15:45:02',"Bringázás a Bükkben",
"BIKING");
INSERT INTO `activities` (start_time, activity_desc, activity_type) VALUES ('2020-02-14 15:45:02',"Mászás a Mátrában",
"HIKING");
INSERT INTO `activities` (start_time, activity_desc, activity_type) VALUES ('2020-02-15 15:45:02',"Kosarazás a Mátrában",
"BASKETBALL");
