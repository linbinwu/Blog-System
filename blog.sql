CREATE TABLE IF NOT EXISTS `user_auth` (
	`id`	INT NOT NULL AUTO_INCREMENT COMMENT 'user_auth_id',
	`user_info_id` INT COMMENT '用户信息ID',
	`username` VARCHAR(30) NOT NULL COMMENT '用户账号',
	`password` VARCHAR(30) NOT NULL COMMENT '用户密码',
	`ip` VARCHAR(30) COMMENT '用户IP地址',
	`create_time` TIMESTAMP NULL DEFAULT NULL COMMENT '账号创建时间',
	`last_login_time` TIMESTAMP NULL DEFAULT NULL COMMENT '上次登录时间',
	PRIMARY KEY (`id`),
    UNIQUE KEY `username` (`username`)
) ENGINE = INNODB DEFAULT CHARSET = utf8; 

CREATE TABLE IF NOT EXISTS `user_info` (
	`id`	INT NOT NULL AUTO_INCREMENT COMMENT 'user_info_id',
	`nickname` VARCHAR(30) NOT NULL COMMENT '昵称',
	`gender` VARCHAR(10) NOT NULL DEFAULT '男' COMMENT '性别',
	`email` VARCHAR(30) NOT NULL COMMENT '邮箱',
	`phone` VARCHAR(30) DEFAULT NULL COMMENT '手机号码',
	`avatar` VARCHAR(500) NOT NULL DEFAULT 'https://avatars.githubusercontent.com/u/48707273?s=400&v=4' COMMENT '头像地址',
	`intro` VARCHAR(500) DEFAULT NULL COMMENT '简介',
	`create_time` TIMESTAMP NULL DEFAULT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8; 