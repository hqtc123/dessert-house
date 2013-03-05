/*
Navicat MySQL Data Transfer

Source Server         : hqtcblog
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : dessert

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2013-03-04 23:49:47
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('2', 'q', 'q', '23', '1', '湖南', '0');
INSERT INTO `customer` VALUES ('4', 'w', 'er', '20', '1', '周口', '0');
INSERT INTO `customer` VALUES ('5', 'wewe', 'wewe', '23', '2', 'eeee', '0');
INSERT INTO `customer` VALUES ('6', 'we', 'eee', '23', '1', 'af', '0');
INSERT INTO `customer` VALUES ('7', 'rt', 'rt', '23', '1', 'jh', '0');
INSERT INTO `customer` VALUES ('8', 'rtt', 'rt', '23', '1', 'jh', '0');
INSERT INTO `customer` VALUES ('9', 'kb', 'kb', '67', '2', '上海', '0');
INSERT INTO `customer` VALUES ('10', 'r', 'r', '43', '1', '北京', '0');

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
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopid` int(11) NOT NULL,
  `salerid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `money` float NOT NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `shoid` (`shopid`),
  KEY `saleid` (`salerid`),
  KEY `customeid` (`customerid`),
  CONSTRAINT `customeid` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  CONSTRAINT `saleid` FOREIGN KEY (`salerid`) REFERENCES `member` (`id`),
  CONSTRAINT `shoid` FOREIGN KEY (`shopid`) REFERENCES `shop` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
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
-- Table structure for `weeknum`
-- ----------------------------
DROP TABLE IF EXISTS `weeknum`;
CREATE TABLE `weeknum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopid` int(11) NOT NULL,
  `dessertid` int(11) NOT NULL,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weeknum
-- ----------------------------
