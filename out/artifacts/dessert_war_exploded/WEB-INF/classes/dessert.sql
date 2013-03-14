/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50513
Source Host           : localhost:3306
Source Database       : dessert

Target Server Type    : MYSQL
Target Server Version : 50513
File Encoding         : 65001

Date: 2013-03-13 13:12:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `card`
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) NOT NULL,
  `state` int(11) NOT NULL,
  `money` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('1', '18', '1', '52');
INSERT INTO `card` VALUES ('2', '21', '1', '88');
INSERT INTO `card` VALUES ('3', '20', '0', '0');
INSERT INTO `card` VALUES ('4', '19', '1', '78');
INSERT INTO `card` VALUES ('7', '28', '1', '42');
INSERT INTO `card` VALUES ('8', '29', '1', '4');
INSERT INTO `card` VALUES ('9', '30', '0', '0');
INSERT INTO `card` VALUES ('10', '31', '1', '106');

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
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('18', 'www', '4eae35f1b35977a00ebd8086c259d4c9', '23', '0', '达到 桃花源', '0');
INSERT INTO `customer` VALUES ('19', 'aaa', '21232f297a57a5a743894a0e4a801fc3', '23', '0', '河南，淮阳', '0');
INSERT INTO `customer` VALUES ('20', 'hqtc', '21232f297a57a5a743894a0e4a801fc3', '34', '0', 'erer', '0');
INSERT INTO `customer` VALUES ('21', 'her', '76d80224611fc919a5d54f0ff9fba446', '19', '1', 'her home', '0');
INSERT INTO `customer` VALUES ('28', 'qwe', '76d80224611fc919a5d54f0ff9fba446', '23', '0', '大南京', '0');
INSERT INTO `customer` VALUES ('29', 'ren', '00559ea764f3549e2a9c714ecd8af73f', '23', '0', '假定符合', '0');
INSERT INTO `customer` VALUES ('30', 'mmm', 'c4efd5020cb49b9d3257ffa0fbccc0ae', '23', '0', 'er', '0');
INSERT INTO `customer` VALUES ('31', 'nnn', 'a1931ec126bbad3fa7a3fc64209fd921', '20', '0', 'guangzhou', '0');

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
INSERT INTO `dessert` VALUES ('6', '麦圈', '12');
INSERT INTO `dessert` VALUES ('7', '营养蛋糕', '9');
INSERT INTO `dessert` VALUES ('8', '大果冻', '2');
INSERT INTO `dessert` VALUES ('9', '冰淇淋', '3.2');
INSERT INTO `dessert` VALUES ('10', '老酸奶', '10');
INSERT INTO `dessert` VALUES ('11', '     ', '8');

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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('9', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', '1');
INSERT INTO `member` VALUES ('10', 'meng', '70110c42465beafda6c139ba93fe1eca', 'manager', '2');
INSERT INTO `member` VALUES ('16', 'aaa', '47bce5c74f589f4867dbd57e9ca9f808', 'saler', '1');
INSERT INTO `member` VALUES ('17', 'qqq', 'b2ca678b4c936f905fb82f2733f5297f', 'saler', '2');
INSERT INTO `member` VALUES ('18', 'yanxin', 'dcfb7b61fc0da2ef7deb549fde4467cd', 'saler', '3');
INSERT INTO `member` VALUES ('19', 'tom', '34b7da764b21d298ef307d04d8152dc5', 'saler', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('1', '3', '7', '4');
INSERT INTO `orderitem` VALUES ('2', '4', '8', '12');
INSERT INTO `orderitem` VALUES ('3', '5', '8', '20');
INSERT INTO `orderitem` VALUES ('4', '5', '6', '2');
INSERT INTO `orderitem` VALUES ('5', '6', '7', '22');
INSERT INTO `orderitem` VALUES ('6', '7', '6', '4');
INSERT INTO `orderitem` VALUES ('7', '8', '11', '2');
INSERT INTO `orderitem` VALUES ('8', '8', '6', '2');
INSERT INTO `orderitem` VALUES ('9', '9', '11', '12');
INSERT INTO `orderitem` VALUES ('10', '10', '6', '2');
INSERT INTO `orderitem` VALUES ('11', '11', '6', '3');
INSERT INTO `orderitem` VALUES ('12', '12', '6', '1');
INSERT INTO `orderitem` VALUES ('13', '13', '6', '1');
INSERT INTO `orderitem` VALUES ('14', '14', '6', '1');
INSERT INTO `orderitem` VALUES ('15', '15', '6', '2');
INSERT INTO `orderitem` VALUES ('16', '16', '6', '2');
INSERT INTO `orderitem` VALUES ('17', '16', '6', '3');
INSERT INTO `orderitem` VALUES ('18', '17', '6', '1');

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
  PRIMARY KEY (`id`),
  KEY `shoid` (`shopid`),
  KEY `saleid` (`salerid`),
  KEY `customeid` (`customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of torder
-- ----------------------------
INSERT INTO `torder` VALUES ('3', '1', '0', '21', '36');
INSERT INTO `torder` VALUES ('4', '1', '0', '21', '24');
INSERT INTO `torder` VALUES ('5', '1', '0', '21', '56');
INSERT INTO `torder` VALUES ('6', '1', '0', '21', '198');
INSERT INTO `torder` VALUES ('7', '1', '0', '21', '32');
INSERT INTO `torder` VALUES ('8', '1', '0', '0', '32');
INSERT INTO `torder` VALUES ('9', '1', '0', '0', '96');
INSERT INTO `torder` VALUES ('10', '2', '0', '28', '24');
INSERT INTO `torder` VALUES ('11', '2', '0', '28', '36');
INSERT INTO `torder` VALUES ('12', '1', '0', '28', '12');
INSERT INTO `torder` VALUES ('13', '1', '0', '28', '12');
INSERT INTO `torder` VALUES ('14', '1', '0', '18', '12');
INSERT INTO `torder` VALUES ('15', '1', '0', '18', '24');
INSERT INTO `torder` VALUES ('16', '2', '0', '18', '60');
INSERT INTO `torder` VALUES ('17', '2', '0', '18', '12');

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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of weeknum
-- ----------------------------
INSERT INTO `weeknum` VALUES ('29', '1', '11', '1', '1', '妙脆角');
INSERT INTO `weeknum` VALUES ('30', '1', '7', '4', '1', '营养素');
INSERT INTO `weeknum` VALUES ('31', '1', '8', '4', '1', '大果冻');
INSERT INTO `weeknum` VALUES ('32', '1', '6', '71', '1', '麦圈');
INSERT INTO `weeknum` VALUES ('33', '1', '6', '66', '2', '麦圈');
INSERT INTO `weeknum` VALUES ('34', '1', '8', '88', '2', '大果冻');
INSERT INTO `weeknum` VALUES ('35', '1', '9', '99', '3', '冰淇淋');
INSERT INTO `weeknum` VALUES ('36', '3', '9', '56', '1', '冰淇淋');
INSERT INTO `weeknum` VALUES ('37', '3', '10', '66', '1', '老酸奶');
INSERT INTO `weeknum` VALUES ('38', '2', '5', '10', '1', '牛奶');
INSERT INTO `weeknum` VALUES ('39', '2', '6', '11', '1', '麦圈');
