/*
Navicat MySQL Data Transfer

Source Server         : 小创
Source Server Version : 50726
Source Host           : 192.168.1.60:3306
Source Database       : xchuangw

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-08-13 14:56:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_s_type
-- ----------------------------
DROP TABLE IF EXISTS `t_s_type`;
CREATE TABLE `t_s_type` (
  `ID` varchar(32) NOT NULL,
  `typecode` varchar(50) NOT NULL,
  `typename` varchar(50) NOT NULL,
  `typepid` varchar(32) DEFAULT NULL,
  `typegroupid` varchar(32) NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  KEY `FK_nw2b22gy7plh7pqows186odmq` (`typepid`) USING BTREE,
  KEY `FK_3q40mr4ebtd0cvx79matl39x1` (`typegroupid`) USING BTREE,
  CONSTRAINT `t_s_type_ibfk_1` FOREIGN KEY (`typegroupid`) REFERENCES `t_s_typegroup` (`ID`),
  CONSTRAINT `t_s_type_ibfk_2` FOREIGN KEY (`typepid`) REFERENCES `t_s_type` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Table structure for t_s_typegroup
-- ----------------------------
DROP TABLE IF EXISTS `t_s_typegroup`;
CREATE TABLE `t_s_typegroup` (
  `ID` varchar(32) NOT NULL,
  `typegroupcode` varchar(50) NOT NULL,
  `typegroupname` varchar(50) NOT NULL,
  `isedit` tinyint(1) NOT NULL DEFAULT '0',
  `user_id` varchar(32) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uk_t_s_typegroup_typegroupcode` (`typegroupcode`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
