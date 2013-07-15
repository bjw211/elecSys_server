/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : electric1

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2013-07-15 16:27:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` varchar(15) NOT NULL,
  `aname` varchar(45) DEFAULT NULL,
  `pwd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('001', 'Admin1', '001');
INSERT INTO `admin` VALUES ('002', 'Admin2', '002');

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `did` varchar(15) NOT NULL,
  `dname` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `qr` varchar(255) DEFAULT NULL,
  `checkItem` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('1', '1#变', '变压器', '高新区', '设备号:1,设备名称:1#变,设备类型:变压器,设备安放地址:高新区', '001油温@002油位@003声响');
INSERT INTO `device` VALUES ('2', '2#变', '变压器', '高新区', '设备号:2,设备名称:2#变,设备类型:变压器,设备安放地址:高新区', '001油温@002油位@003声响');
INSERT INTO `device` VALUES ('3', '1#断', '断路器', '历下区', '设备号:3,设备名称:1#断,设备类型:断路器,设备安放地址:历下区', '004瓷套管是否清洁，有无破损裂纹、放电痕迹@005各连接头接触是否良好，有无发热松动@006绝缘拉杆及拉杆绝缘子是否完好无缺陷，连接软铜片是否完整，有无断片');
INSERT INTO `device` VALUES ('4', '2#断', '断路器', '长清区', '设备号:4,设备名称:2#断,设备类型:断路器,设备安放地址:长清区', '004瓷套管是否清洁，有无破损裂纹、放电痕迹@005各连接头接触是否良好，有无发热松动@006绝缘拉杆及拉杆绝缘子是否完好无缺陷，连接软铜片是否完整，有无断片');
INSERT INTO `device` VALUES ('5', '1#开', '开关', '高新区', '设备号:5,设备名称:1#开,设备类型:开关,设备安放地址:高新区', '007隔离开关本体应该完好，三相触头在合闸时应同期到位，有无错位或不同期到位现象@008触头应平整光滑，有无脏污锈蚀变形@009触头弹簧或弹簧片应完好，有无变形损坏');
INSERT INTO `device` VALUES ('6', '2#开', '开关', '历下区', '设备号:6,设备名称:2#开,设备类型:开关,设备安放地址:历下区', '007隔离开关本体应该完好，三相触头在合闸时应同期到位，有无错位或不同期到位现象@008触头应平整光滑，有无脏污锈蚀变形@009触头弹簧或弹簧片应完好，有无变形损坏');
INSERT INTO `device` VALUES ('7', '7', '变压器', '7', '设备号:7,设备名称:7,设备类型:变压器,设备安放地址:7', '001油温@002油位@003声响');

-- ----------------------------
-- Table structure for `fault`
-- ----------------------------
DROP TABLE IF EXISTS `fault`;
CREATE TABLE `fault` (
  `fid` int(10) NOT NULL AUTO_INCREMENT,
  `did` varchar(45) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `solved` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fault
-- ----------------------------
INSERT INTO `fault` VALUES ('1', '1--1#变', '油温过高，及时更换机油', '2013-06-13', '是');
INSERT INTO `fault` VALUES ('2', '1--1#变', '有声响', '2013-06-27', '是');
INSERT INTO `fault` VALUES ('3', '2--2#变', '油位过低，及时补充', '2013-07-03', '否');
INSERT INTO `fault` VALUES ('4', '3--1#断', '各连接头接触松动，有发热松动', '2013-07-07', '是');
INSERT INTO `fault` VALUES ('5', '5--1#开', '触头不平整光滑，有脏污锈蚀变形', '2013-06-18', '否');

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `mid` varchar(15) NOT NULL,
  `mname` varchar(45) DEFAULT NULL,
  `devices` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('1', '高新区巡线模板', '4@1@1#变@2@2#变@3@1#断@6@2#开');
INSERT INTO `module` VALUES ('2', '历下区电力检查模板', '3@1@1#变@5@1#开@6@2#开');
INSERT INTO `module` VALUES ('3', '章丘市电力检查模板', '3@1@1#变@3@1#断@5@1#开');
INSERT INTO `module` VALUES ('4', '泰安市电力检查模板', '3@2@2#变@4@2#断@6@2#开');
INSERT INTO `module` VALUES ('5', '章丘市巡线模板', '2@1@1#变@2@2#变');

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `tid` varchar(15) NOT NULL,
  `did` varchar(15) NOT NULL,
  `cid` varchar(15) NOT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tid`,`did`,`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('3', '5', '1', '6随便');
INSERT INTO `result` VALUES ('3', '5', '2', '7随便');
INSERT INTO `result` VALUES ('3', '5', '3', '8随便');

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `tid` varchar(15) NOT NULL,
  `tname` varchar(45) DEFAULT NULL,
  `stime` date DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `etime` date DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `worker_wid` varchar(15) NOT NULL,
  `devices` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `fk_task_worker1_idx` (`worker_wid`),
  CONSTRAINT `fk_task_worker1` FOREIGN KEY (`worker_wid`) REFERENCES `worker` (`wid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('1', '高新区巡线', '2013-06-11', '2013-06-14', '2013-06-13', 'DONE', '001', '3@11 #变@22#变@31#断');
INSERT INTO `task` VALUES ('2', '历下区电力检查', '2013-06-19', '2013-06-28', '2013-06-26', 'DONE', '002', '4@11#变@22#变@31#断@62#开');
INSERT INTO `task` VALUES ('3', '高新区线路检修', '2013-06-18', '2013-07-20', '2013-07-13', 'DONE', '003', '1@51#开');
INSERT INTO `task` VALUES ('4', '章丘市线路检查', '2013-07-01', '2013-07-04', '2013-07-03', 'UNDO', '001', '2@11#变@62#开');
INSERT INTO `task` VALUES ('5', '泰安市线路检查', '2013-06-27', '2013-06-30', '2013-07-03', 'OVERTIME', '001', '2@31#断@42#断');

-- ----------------------------
-- Table structure for `worker`
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `wid` varchar(15) NOT NULL,
  `wname` varchar(45) DEFAULT NULL,
  `pwd` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `wtime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('001', '张三', '001', '30', '高新区', '巡线工', '2年');
INSERT INTO `worker` VALUES ('002', '李四', '002', '32', '历下区', '巡线工', '3年');
INSERT INTO `worker` VALUES ('003', '王五', '003', '28', '高新区', '电工', '5年');
INSERT INTO `worker` VALUES ('004', '赵六', '004', '35', '高新区', '巡线工', '3年');
INSERT INTO `worker` VALUES ('005', '张三', '005', '40', '历下区', '电工', '5年');
INSERT INTO `worker` VALUES ('007', '张三', '007', '28', '高新区', '巡线工', '2年');
