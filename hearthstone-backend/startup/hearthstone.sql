DROP DATABASE IF EXISTS `hearthstone`;
CREATE DATABASE `hearthstone` CHARACTER SET utf8;
USE `hearthstone`;
SET default_storage_engine=InnoDB;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT                                            COMMENT '用户id',
  `username` VARCHAR(16) NOT NULL                                                           COMMENT '用户名',
  `password` VARCHAR(128) NOT NULL                                                          COMMENT '登录密码',
  `reg_date` DATETIME NOT NULL                                                              COMMENT '注册时间',
  PRIMARY KEY (`user_id`)
)                                                                                           COMMENT = '用户表';

-- TODO 增加 技能、故事、卡牌包、稀有度、标准、狂野等属性\法术or随从
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `card_id` INT UNSIGNED NOT NULL AUTO_INCREMENT                                            COMMENT '卡牌id',
  `name` VARCHAR(16) NOT NULL                                                               COMMENT '名称',
  `expense` TINYINT(2) NOT NULL                                                             COMMENT '消耗水晶',
  `attack` TINYINT(2) NOT NULL                                                              COMMENT '攻击力',
  `health_point` TINYINT(2) NOT NULL                                                        COMMENT '生命值',
  `img_path`  VARCHAR(256) NOT NULL                                                          COMMENT '图片路径',
  PRIMARY KEY (`card_id`)
)                                                                                           COMMENT = '卡牌表';