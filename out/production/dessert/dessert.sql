/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : dessert

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2013-03-08 09:54:27
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('15', 'qqq', 'e10adc3949ba59abbe56e057f20f883e', '23', '0', '河南', '0');
INSERT INTO `customer` VALUES ('18', 'www', '4eae35f1b35977a00ebd8086c259d4c9', '23', '0', 'sfggf', '0');

-- ----------------------------
-- Table structure for `dessert`
-- ----------------------------
DROP TABLE IF EXISTS `dessert`;
CREATE TABLE `dessert` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dessert
-- ----------------------------

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `position` int(11) NOT NULL,
  `shopid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shopid` (`shopid`),
  CONSTRAINT `shopid` FOREIGN KEY (`shopid`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop
-- ----------------------------

-- ----------------------------
-- Table structure for `strategy`
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) NOT NULL,
  `discount` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of strategy
-- ----------------------------

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weeknum
-- ----------------------------
