/*
Navicat MySQL Data Transfer

Source Server         : myconnect
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : ordersystem

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2020-07-23 17:47:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for order_admin
-- ----------------------------
DROP TABLE IF EXISTS `order_admin`;
CREATE TABLE `order_admin` (
  `AdminId` int(20) NOT NULL AUTO_INCREMENT,
  `AdminName` varchar(50) DEFAULT NULL,
  `AdminPassword` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AdminId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_admin
-- ----------------------------

-- ----------------------------
-- Table structure for order_control_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `order_control_enterprise`;
CREATE TABLE `order_control_enterprise` (
  `ControlNum` int(11) NOT NULL,
  `ControlType` varchar(50) DEFAULT NULL,
  `AdminId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ControlNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_control_enterprise
-- ----------------------------

-- ----------------------------
-- Table structure for order_control_user
-- ----------------------------
DROP TABLE IF EXISTS `order_control_user`;
CREATE TABLE `order_control_user` (
  `ControlNum` int(11) NOT NULL,
  `ControlType` varchar(50) DEFAULT NULL,
  `AdminId` int(11) DEFAULT NULL,
  PRIMARY KEY (`ControlNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_control_user
-- ----------------------------

-- ----------------------------
-- Table structure for order_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `order_enterprise`;
CREATE TABLE `order_enterprise` (
  `EnterpriseId` varchar(50) NOT NULL,
  `EnterpriseName` varchar(50) DEFAULT NULL,
  `EnterprisePassword` varchar(50) DEFAULT NULL,
  `EnterprisePhone` varchar(50) DEFAULT NULL,
  `EnterpriseHead` varchar(255) DEFAULT NULL,
  `EnterpriseExpend` float(10,2) DEFAULT NULL,
  PRIMARY KEY (`EnterpriseId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_enterprise
-- ----------------------------
INSERT INTO `order_enterprise` VALUES ('eewe', '213', '12312', '31', '1232', '224.70');

-- ----------------------------
-- Table structure for order_menu
-- ----------------------------
DROP TABLE IF EXISTS `order_menu`;
CREATE TABLE `order_menu` (
  `MenuId` int(11) NOT NULL AUTO_INCREMENT,
  `MenuPhoto` varchar(255) DEFAULT NULL,
  `MenuName` varchar(50) DEFAULT NULL,
  `MenuRetail` float(50,2) DEFAULT NULL,
  `MenuIntroduction` text,
  `MenuTypeId` int(11) DEFAULT NULL,
  `MenuUpDate` date DEFAULT NULL,
  PRIMARY KEY (`MenuId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_menu
-- ----------------------------
INSERT INTO `order_menu` VALUES ('1', 'images/pizza_img1.png', '玛格丽特披萨', '76.50', '玛格丽特披萨是一种美味的美食，以脆皮披萨面皮、小番茄等为原料，以番茄酱汁等为调料。该美食主要通过烘烤的方法制作而成。', '1', '2020-05-12');
INSERT INTO `order_menu` VALUES ('2', 'images/pizza_img2.png', '奶酪披萨', '65.00', '奶酪披萨是一道美味的西式餐品，主要制作材料为自发粉、奶酪丝、小西红柿、火腿肠、西兰花等，制作简单易学，操作方便，营养丰富。', '1', '2020-03-14');
INSERT INTO `order_menu` VALUES ('3', 'images/pizza_img3.png', '奶油披萨', '76.50', '玛格丽特披萨是一种美味的美食，以脆皮披萨面皮、小番茄等为原料，以番茄酱汁等为调料。该美食主要通过烘烤的方法制作而成。', '1', '2020-05-12');
INSERT INTO `order_menu` VALUES ('4', 'images/pizza_img4.png', '海鲜披萨', '65.00', '奶酪披萨是一道美味的西式餐品，主要制作材料为自发粉、奶酪丝、小西红柿、火腿肠、西兰花等，制作简单易学，操作方便，营养丰富。', '1', '2020-03-14');
INSERT INTO `order_menu` VALUES ('5', 'images/pizza_img5.png', '牛肉披萨', '76.50', '玛格丽特披萨是一种美味的美食，以脆皮披萨面皮、小番茄等为原料，以番茄酱汁等为调料。该美食主要通过烘烤的方法制作而成。', '1', '2020-05-12');
INSERT INTO `order_menu` VALUES ('6', 'images/pizza_img6.png', '雪域披萨', '65.00', '奶酪披萨是一道美味的西式餐品，主要制作材料为自发粉、奶酪丝、小西红柿、火腿肠、西兰花等，制作简单易学，操作方便，营养丰富。', '1', '2020-03-14');
INSERT INTO `order_menu` VALUES ('7', 'images/pizza_img1.png', '奥尔良披萨', '76.50', '玛格丽特披萨是一种美味的美食，以脆皮披萨面皮、小番茄等为原料，以番茄酱汁等为调料。该美食主要通过烘烤的方法制作而成。', '1', '2020-05-12');
INSERT INTO `order_menu` VALUES ('8', 'images/pizza_img2.png', '神奇披萨', '65.00', '奶酪披萨是一道美味的西式餐品，主要制作材料为自发粉、奶酪丝、小西红柿、火腿肠、西兰花等，制作简单易学，操作方便，营养丰富。', '1', '2020-03-14');
INSERT INTO `order_menu` VALUES ('9', 'images/pizza_img3.png', '至尊披萨', '76.50', '玛格丽特披萨是一种美味的美食，以脆皮披萨面皮、小番茄等为原料，以番茄酱汁等为调料。该美食主要通过烘烤的方法制作而成。', '1', '2020-05-12');
INSERT INTO `order_menu` VALUES ('10', 'images/pizza_img4.png', '美味披萨', '65.00', '奶酪披萨是一道美味的西式餐品，主要制作材料为自发粉、奶酪丝、小西红柿、火腿肠、西兰花等，制作简单易学，操作方便，营养丰富。', '1', '2020-03-14');
INSERT INTO `order_menu` VALUES ('11', 'images/pizza_img5.png', '蟹黄披萨', '76.50', '玛格丽特披萨是一种美味的美食，以脆皮披萨面皮、小番茄等为原料，以番茄酱汁等为调料。该美食主要通过烘烤的方法制作而成。', '1', '2020-05-12');
INSERT INTO `order_menu` VALUES ('12', 'images/pizza_img6.png', '榴莲披萨', '65.00', '奶酪披萨是一道美味的西式餐品，主要制作材料为自发粉、奶酪丝、小西红柿、火腿肠、西兰花等，制作简单易学，操作方便，营养丰富。', '1', '2020-03-14');
INSERT INTO `order_menu` VALUES ('13', 'images/Fries.png', '盐薯条', '10.00', '是一种以马铃薯为原料，切成条状后油炸而成的食品，源起于比利时。是现在最常见的快餐食品之一，流行于世界各地。', '4', '2020-05-12');
INSERT INTO `order_menu` VALUES ('14', 'images/pro_img5.png', '薯片', '10.50', '是指由马铃薯（土豆）制成的零食。薯片制作方法是把马铃薯去皮后切为薄片', '4', '2020-05-12');
INSERT INTO `order_menu` VALUES ('15', 'images/pro_img6.png', '炸鸡快', '10.50', '是一种以马铃薯为原料，切成条状后油炸而成的食品，源起于比利时。是现在最常见的快餐食品之一，流行于世界各地。', '4', '2020-05-12');
INSERT INTO `order_menu` VALUES ('16', 'images/pro_img7.png', '洋葱圈', '10.00', '是一种以马铃薯为原料，切成条状后油炸而成的食品，源起于比利时。是现在最常见的快餐食品之一，流行于世界各地。', '4', '2020-06-12');
INSERT INTO `order_menu` VALUES ('17', 'images/pro_img8.png', '薯饼', '10.50', '是一种以马铃薯为原料，切成条状后油炸而成的食品，源起于比利时。是现在最常见的快餐食品之一，流行于世界各地。', '4', '2020-05-12');
INSERT INTO `order_menu` VALUES ('18', 'images/pro_img9.png', '油炸豆腐', '9.00', '是一种以马铃薯为原料，切成条状后油炸而成的食品，源起于比利时。是现在最常见的快餐食品之一，流行于世界各地。', '4', '2020-05-16');
INSERT INTO `order_menu` VALUES ('21', 'images/bug1.png', '牛肉汉堡', '21.00', '牛肉汉堡是一款快餐食物，制作原料主要有牛肉馅、洋葱、胡萝卜等。是现代西式快餐中的主要食物', '2', '2020-05-15');
INSERT INTO `order_menu` VALUES ('22', 'images/bug2.png', '鸡腿汉堡', '22.00', '牛肉汉堡是一款快餐食物，制作原料主要有牛肉馅、洋葱、胡萝卜等。是现代西式快餐中的主要食物', '2', '2020-05-15');
INSERT INTO `order_menu` VALUES ('23', 'images/bug3.png', '鳕鱼汉堡', '23.00', '牛肉汉堡是一款快餐食物，制作原料主要有牛肉馅、洋葱、胡萝卜等。是现代西式快餐中的主要食物', '2', '2020-05-15');
INSERT INTO `order_menu` VALUES ('24', 'images/bug4.png', '奶酪汉堡', '24.00', '牛肉汉堡是一款快餐食物，制作原料主要有牛肉馅、洋葱、胡萝卜等。是现代西式快餐中的主要食物', '2', '2020-05-15');
INSERT INTO `order_menu` VALUES ('28', 'images/Salad.png', '水果沙拉', '28.00', '蔬菜沙拉是一道以圆白菜、番茄、黄瓜等作为主要食材制作而成的美食。蔬菜沙拉是一种非常营养健康的饮食方法。', '3', '2020-05-15');
INSERT INTO `order_menu` VALUES ('29', 'images/Salad2.png', '蔬菜沙拉', '29.00', '蔬菜沙拉是一道以圆白菜、番茄、黄瓜等作为主要食材制作而成的美食。蔬菜沙拉是一种非常营养健康的饮食方法。', '3', '2020-05-15');
INSERT INTO `order_menu` VALUES ('30', 'images/tea1.png', '红茶', '11.00', '香气物质比鲜叶明显增加。所以红茶具有红茶、红汤、红叶和香甜味醇的特征', '5', '2020-05-15');
INSERT INTO `order_menu` VALUES ('31', 'images/tea2.png', '奶茶', '11.00', '奶茶为蒙古高原游牧民族的日常饮品，蒙古高原是游牧民族的故乡，最正宗的就是蒙古奶茶。', '5', '2020-05-15');

-- ----------------------------
-- Table structure for order_menu_type
-- ----------------------------
DROP TABLE IF EXISTS `order_menu_type`;
CREATE TABLE `order_menu_type` (
  `MenuTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `MenuType` varchar(255) NOT NULL,
  `MenuClass` varchar(255) NOT NULL,
  PRIMARY KEY (`MenuTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_menu_type
-- ----------------------------
INSERT INTO `order_menu_type` VALUES ('1', '披萨', 'pizza active');
INSERT INTO `order_menu_type` VALUES ('2', '汉堡', 'burger1');
INSERT INTO `order_menu_type` VALUES ('3', '沙拉', 'salads');
INSERT INTO `order_menu_type` VALUES ('4', '杂食', 'fries');
INSERT INTO `order_menu_type` VALUES ('5', '饮品', 'drinks');

-- ----------------------------
-- Table structure for order_remark
-- ----------------------------
DROP TABLE IF EXISTS `order_remark`;
CREATE TABLE `order_remark` (
  `MenuId` varchar(50) NOT NULL,
  `UserId` varchar(50) NOT NULL,
  `Remark` text,
  PRIMARY KEY (`MenuId`,`UserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_remark
-- ----------------------------

-- ----------------------------
-- Table structure for order_ticket
-- ----------------------------
DROP TABLE IF EXISTS `order_ticket`;
CREATE TABLE `order_ticket` (
  `TicketId` int(50) NOT NULL AUTO_INCREMENT,
  `UserId` varchar(50) NOT NULL,
  `MenuId` varchar(50) NOT NULL,
  `EnterpriseId` int(50) DEFAULT NULL,
  `TicketAddress` varchar(200) DEFAULT NULL,
  `TicketState` int(50) DEFAULT NULL,
  `TicketNum` int(50) DEFAULT NULL,
  `TicketTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`TicketId`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_ticket
-- ----------------------------
INSERT INTO `order_ticket` VALUES ('1', '99311592887600205219921917877755', '2', '22222', '广东省', '1', '3', '2020-04-25 17:01:58');
INSERT INTO `order_ticket` VALUES ('2', '99311592887600205219921917877755', '3', '22222', '深圳市', '0', '1', '2020-06-22 13:00:45');
INSERT INTO `order_ticket` VALUES ('3', '98318536351300205218141434861374', '28', '11111', '四川贵州', '0', '1', '2020-06-09 13:04:04');
INSERT INTO `order_ticket` VALUES ('4', '67165812317599197716971399912421', '16', null, '深圳市高明区福田街道西区3栋404', '0', '5', '2020-07-09 14:53:40');

-- ----------------------------
-- Table structure for order_user
-- ----------------------------
DROP TABLE IF EXISTS `order_user`;
CREATE TABLE `order_user` (
  `UserId` varchar(50) NOT NULL,
  `UserFname` varchar(50) DEFAULT NULL,
  `UserTname` varchar(50) DEFAULT NULL,
  `UserSex` char(1) DEFAULT NULL,
  `UserHead` varchar(255) DEFAULT NULL,
  `UserPassword` varchar(50) DEFAULT NULL,
  `UserPhone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`UserId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of order_user
-- ----------------------------
INSERT INTO `order_user` VALUES ('111431606227300205273401371983228', 'exaid', null, 'M', null, '-83969981442369794107251185832258223648', '18200892683');
INSERT INTO `order_user` VALUES ('113082468240200205212301348075869', '核心高达', null, 'M', null, '-169829226153273981968091948762660178231', '18200892680');
INSERT INTO `order_user` VALUES ('113451989841700205288761045455361', 'gundam', null, 'M', null, '-169829226153273981968091948762660178231', '18200892682');
INSERT INTO `order_user` VALUES ('4263244135400205271249448429209', 'ccc', null, 'F', null, '-82461163360076010380277270909580304663', '13689765677');
INSERT INTO `order_user` VALUES ('67165812317599197716971399912421', 'wwwww', null, 'M', null, '-53803683128988481556320160447865884862', '18200892682');
INSERT INTO `order_user` VALUES ('7759674405600205259201516739630', 'zaia', null, 'M', null, '27821034766960509388926908989250651739', '18200892680');
INSERT INTO `order_user` VALUES ('79103420451700205211674423848829', 'build', null, 'M', null, '15028982701447611937917504231140404345', '18200892682');
INSERT INTO `order_user` VALUES ('98318536351300205218141434861374', 'hayami', null, 'F', null, '-139695783799064248343851432038745571054', '18200892682');
INSERT INTO `order_user` VALUES ('98754229233100205219925286387035', 'core', null, 'F', null, '69426775085212228881266153194386034486', '18200892682');
INSERT INTO `order_user` VALUES ('99311592887600205219921917877755', 'freedom', null, 'M', null, '-53803683128988481556320160447865884862', '18200892682');
