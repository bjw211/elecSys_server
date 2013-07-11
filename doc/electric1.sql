/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : electric1

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2013-07-11 09:11:32
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
INSERT INTO `admin` VALUES ('001', 'Admin1', '100');
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
INSERT INTO `device` VALUES ('001', '1#变', '变压器', '高新区', '12121212', '1油温*2油位*3声响*');
INSERT INTO `device` VALUES ('002', '2#变', '变压器', '高新区', '13131313', '1油温*2油位*3声响');
INSERT INTO `device` VALUES ('003', '1#断', '断路器', '历下区', '14141414', '4瓷套管是否清洁，有无破损裂纹、放电痕迹*5各连接头接触是否良好，有无发热松动*6绝缘拉杆及拉杆绝缘子是否完好无缺陷，连接软铜片是否完整，有无断片*');
INSERT INTO `device` VALUES ('004', '2#断', '断路器', '长清区', '25252525', '4瓷套管是否清洁，有无破损裂纹、放电痕迹*5各连接头接触是否良好，有无发热松动*6绝缘拉杆及拉杆绝缘子是否完好无缺陷，连接软铜片是否完整，有无断片*');
INSERT INTO `device` VALUES ('005', '1#开', '开关', '高新区', '26262626', '7隔离开关本体应该完好，三相触头在合闸时应同期到位，有无错位或不同期到位现象*8触头应平整光滑，有无脏污锈蚀变形*9触头弹簧或弹簧片应完好，有无变形损坏');
INSERT INTO `device` VALUES ('006', '2#开', '开关', '历下区', '27272727', '7隔离开关本体应该完好，三相触头在合闸时应同期到位，有无错位或不同期到位现象*8触头应平整光滑，有无脏污锈蚀变形*9触头弹簧或弹簧片应完好，有无变形损坏*');
INSERT INTO `device` VALUES ('007', '3#变', '变压器', '天桥区', '39393939', '1油温*2油位*3声响');
INSERT INTO `device` VALUES ('008', '4#变', '变压器', '泰安市', '78787878', '51515');

-- ----------------------------
-- Table structure for `fault`
-- ----------------------------
DROP TABLE IF EXISTS `fault`;
CREATE TABLE `fault` (
  `fid` varchar(15) NOT NULL,
  `did` varchar(45) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `solved` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fault
-- ----------------------------
INSERT INTO `fault` VALUES ('001', '001--1#变', '油温过高，及时更换机油', '2013-06-13', '是');
INSERT INTO `fault` VALUES ('002', '001--1#变', '有声响', '2013-06-27', '是');
INSERT INTO `fault` VALUES ('003', '002--2#变', '油位过低，及时补充', '2013-07-03', '否');
INSERT INTO `fault` VALUES ('004', '003--1#断', '各连接头接触松动，有发热松动', '2013-07-07', '是');
INSERT INTO `fault` VALUES ('005', '005--1#开', '触头不平整光滑，有脏污锈蚀变形', '2013-06-18', '否');

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
INSERT INTO `module` VALUES ('001', '高新区巡线模板', '4*001*1#变*002*2#变*003*1#断*006*2#开*');

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `tid` varchar(15) NOT NULL,
  `did` varchar(15) NOT NULL,
  `cid` varchar(15) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tid`,`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('001', '001', '1', '20C');
INSERT INTO `result` VALUES ('001', '002', '2', '15cm');

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
INSERT INTO `task` VALUES ('001', '高新区巡线任务', '2013-06-11', '2013-06-14', '2013-06-13', 'DONE', '001', '311# 变22#变31#断');
INSERT INTO `task` VALUES ('002', '历下区电力检查', '2013-06-19', '2013-06-28', '2013-06-26', 'DONE', '002', '411#变22#变31#断42#开');
INSERT INTO `task` VALUES ('003', '高新区线路检修', '2013-06-18', '2013-07-20', '2013-06-24', 'UNDO', '001', '11#开');
INSERT INTO `task` VALUES ('004', '章丘市线路检查', '2013-07-01', '2013-07-04', '2013-07-03', 'DONE', '001', '21#变2#开');
INSERT INTO `task` VALUES ('005', '泰安市线路检查', '2013-06-27', '2013-06-30', '2013-07-03', 'OVERTIME', '001', '21#断2#断');

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
INSERT INTO `worker` VALUES ('006', '张三', '006', '22', '22', '22', '22');
