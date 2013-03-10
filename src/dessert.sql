/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : dessert

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2013-03-10 16:32:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `card`
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardId` varchar(255) NOT NULL,
  `customerId` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `lastTme` date NOT NULL,
  `money` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `customerId` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('15', 'qqq', 'e10adc3949ba59abbe56e057f20f883e', '23', '0', '河南', '0');
INSERT INTO `customer` VALUES ('18', 'www', '4eae35f1b35977a00ebd8086c259d4c9', '23', '0', 'sfggf', '0');
INSERT INTO `customer` VALUES ('19', 'aaa', '21232f297a57a5a743894a0e4a801fc3', '23', '0', '河南，淮阳', '0');
INSERT INTO `customer` VALUES ('20', 'hqtc', '21232f297a57a5a743894a0e4a801fc3', '34', '0', 'erer', '0');
INSERT INTO `customer` VALUES ('21', 'her', '76d80224611fc919a5d54f0ff9fba446', '19', '1', 'her home', '0');

-- ----------------------------
-- Table structure for `dessert`
-- ----------------------------
DROP TABLE IF EXISTS `dessert`;
CREATE TABLE `dessert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dessert
-- ----------------------------
INSERT INTO `dessert` VALUES ('5', '牛奶', '3');
INSERT INTO `dessert` VALUES ('6', '麦圈', '8');
INSERT INTO `dessert` VALUES ('7', '营养素', '3.6');
INSERT INTO `dessert` VALUES ('8', '大果冻', '2');
INSERT INTO `dessert` VALUES ('9', '冰淇淋', '3.2');
INSERT INTO `dessert` VALUES ('10', '老酸奶', '10');
INSERT INTO `dessert` VALUES ('11', '妙脆角', '8');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `position` varchar(11) NOT NULL,
  `shopid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`),
  KEY `shopid` (`shopid`),
  CONSTRAINT `shopid` FOREIGN KEY (`shopid`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('9', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', '1');
INSERT INTO `member` VALUES ('10', 'meng', '70110c42465beafda6c139ba93fe1eca', 'manager', '2');
INSERT INTO `member` VALUES ('16', 'aaa', '47bce5c74f589f4867dbd57e9ca9f808', 'saler', '1');
INSERT INTO `member` VALUES ('17', 'qqq', 'b2ca678b4c936f905fb82f2733f5297f', 'saler', '2');
INSERT INTO `member` VALUES ('18', 'yanxin', 'dcfb7b61fc0da2ef7deb549fde4467cd', 'saler', '3');

-- ----------------------------
-- Table structure for `orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` int(11) NOT NULL,
  `dessertid` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order` (`orderid`),
  CONSTRAINT `order` FOREIGN KEY (`orderid`) REFERENCES `torder` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for `recharge`
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `money` int(11) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recharge
-- ----------------------------

-- ----------------------------
-- Table structure for `shop`
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES ('1');
INSERT INTO `shop` VALUES ('2');
INSERT INTO `shop` VALUES ('3');

-- ----------------------------
-- Table structure for `strategy`
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) NOT NULL,
  `discount` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of strategy
-- ----------------------------
INSERT INTO `strategy` VALUES ('1', '1000', '0.9');
INSERT INTO `strategy` VALUES ('2', '2000', '0.85');
INSERT INTO `strategy` VALUES ('3', '3000', '0.8');
INSERT INTO `strategy` VALUES ('4', '3500', '0.7');

-- ----------------------------
-- Table structure for `torder`
-- ----------------------------
DROP TABLE IF EXISTS `torder`;
CREATE TABLE `torder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopid` int(11) NOT NULL,
  `salerid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `money` float NOT NULL,
  `date` date NOT NULL,
  `realmoney` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shoid` (`shopid`),
  KEY `saleid` (`salerid`),
  KEY `customeid` (`customerid`),
  CONSTRAINT `customeid` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  CONSTRAINT `saleid` FOREIGN KEY (`salerid`) REFERENCES `member` (`id`),
  CONSTRAINT `shoid` FOREIGN KEY (`shopid`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of torder
-- ----------------------------

-- ----------------------------
-- Table structure for `weeknum`
-- ----------------------------
DROP TABLE IF EXISTS `weeknum`;
CREATE TABLE `weeknum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopid` int(11) NOT NULL,
  `dessertid` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  `weekday` int(11) NOT NULL,
  `dessertname` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shop` (`shopid`),
  KEY `dessert` (`dessertid`),
  CONSTRAINT `dessert` FOREIGN KEY (`dessertid`) REFERENCES `dessert` (`id`),
  CONSTRAINT `shop` FOREIGN KEY (`shopid`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weeknum
-- ----------------------------
INSERT INTO `weeknum` VALUES ('29', '1', '11', '25', '1', '妙脆角');
INSERT INTO `weeknum` VALUES ('30', '1', '7', '34', '1', '营养素');
INSERT INTO `weeknum` VALUES ('31', '1', '8', '36', '1', '大果冻');
INSERT INTO `weeknum` VALUES ('32', '1', '6', '80', '1', '麦圈');
INSERT INTO `weeknum` VALUES ('33', '1', '6', '66', '2', '麦圈');
INSERT INTO `weeknum` VALUES ('34', '1', '8', '88', '2', '大果冻');
INSERT INTO `weeknum` VALUES ('35', '1', '9', '99', '3', '冰淇淋');
