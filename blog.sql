DROP TABLE IF EXISTS `user_auth`;
CREATE TABLE `user_auth` (
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


DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
	`id`	INT NOT NULL AUTO_INCREMENT COMMENT 'user_info_id',
	`role`  VARCHAR(30) NOT NULL DEFAULT 'user' COMMENT '用户角色',
	`nickname` VARCHAR(30) NOT NULL COMMENT '昵称',
	`gender` VARCHAR(10) NOT NULL DEFAULT '男' COMMENT '性别',
	`email` VARCHAR(30) NOT NULL COMMENT '邮箱',
	`phone` VARCHAR(30) DEFAULT NULL COMMENT '手机号码',
	`avatar` VARCHAR(500) NOT NULL DEFAULT 'https://avatars.githubusercontent.com/u/48707273?s=400&v=4' COMMENT '头像地址',
	`intro` VARCHAR(500) DEFAULT NULL COMMENT '简介',
	`create_time` TIMESTAMP NULL DEFAULT NULL COMMENT '创建时间',
	PRIMARY KEY (`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `user_id` INT(11) NOT NULL COMMENT '作者',
    `category_id` INT(11) NULL DEFAULT NULL COMMENT '文章分类',
    `article_cover` VARCHAR(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文章缩略图',
    `article_title` VARCHAR(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
    `article_content` LONGTEXT CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
    `create_time` DATETIME DEFAULT NULL COMMENT '发表时间',
    `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
    `is_top` TINYINT(1) NULL DEFAULT NULL COMMENT '是否置顶',
    `is_draft` TINYINT(1) NULL DEFAULT 0 COMMENT '是否为草稿',
    `is_delete` TINYINT(1) NULL DEFAULT 0 COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `fk_article_user`(`user_id`) USING BTREE,
    INDEX `fk_article_category`(`category_id`) USING BTREE,
    FULLTEXT INDEX `fk_title_content`(`article_title`, `article_content`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `article_id` INT(11) NOT NULL COMMENT '文章id',
    `tag_id` INT(11) NOT NULL COMMENT '标签id',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `fk_article_tag_1`(`article_id`) USING BTREE,
    INDEX `fk_article_tag_2`(`tag_id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`  (
     `id` INT(11) NOT NULL AUTO_INCREMENT,
     `article_id` INT(11) NOT NULL COMMENT '文章id',
     `tag_id` INT(11) NOT NULL COMMENT '标签id',
     PRIMARY KEY (`id`) USING BTREE,
     INDEX `fk_article_tag_1`(`article_id`) USING BTREE,
     INDEX `fk_article_tag_2`(`tag_id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
     `id` INT(11) NOT NULL AUTO_INCREMENT,
     `category_name` VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名',
     `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
     PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8;
