/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-08-04 11:23:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `mobile` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `appstore` varchar(255) DEFAULT NULL,
  `err_code_count` int(11) NOT NULL,
  `iemi` varchar(255) DEFAULT NULL,
  `ifa` varchar(255) DEFAULT NULL,
  `is_active` bit(1) NOT NULL,
  `mac` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '张三', '26', '13915486521', 'sdasda@gmail.com', '', '0', '', '', '\0', '', '', '', '', '0000-00-00 00:00:00');
INSERT INTO `t_user` VALUES ('2', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('3', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('4', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('5', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('6', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('7', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('8', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('9', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('10', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('11', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('12', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('13', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('14', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('15', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('16', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('17', '李四', '30', '13915486521', '11111111111', null, '0', null, null, '\0', null, null, null, null, null);
