/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : electric

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2013-07-09 08:29:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` varchar(15) NOT NULL,
  `aname` varchar(45) NOT NULL,
  `pwd` varchar(15) NOT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('001', 'Admin1', '100');
INSERT INTO `admin` VALUES ('002', 'Admin2', '002');

-- ----------------------------
-- Table structure for `clause`
-- ----------------------------
DROP TABLE IF EXISTS `clause`;
CREATE TABLE `clause` (
  `cid` varchar(15) NOT NULL,
  `cname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clause
-- ----------------------------
INSERT INTO `clause` VALUES ('001', '油温');
INSERT INTO `clause` VALUES ('002', '油位');
INSERT INTO `clause` VALUES ('003', '声响');
INSERT INTO `clause` VALUES ('004', '瓷套管是否清洁，有无破损裂纹、放电痕迹');
INSERT INTO `clause` VALUES ('005', '各连接头接触是否良好，有无发热松动');
INSERT INTO `clause` VALUES ('006', '绝缘拉杆及拉杆绝缘子是否完好无缺陷，连接软铜片是否完整，有无断片');
INSERT INTO `clause` VALUES ('007', '隔离开关本体应该完好，三相触头在合闸时应同期到位，有无错位或不同期到位现象');
INSERT INTO `clause` VALUES ('008', '触头应平整光滑，有无脏污锈蚀变形');
INSERT INTO `clause` VALUES ('009', '触头弹簧或弹簧片应完好，有无变形损坏');

-- ----------------------------
-- Table structure for `clauseofdevice`
-- ----------------------------
DROP TABLE IF EXISTS `clauseofdevice`;
CREATE TABLE `clauseofdevice` (
  `did` varchar(15) NOT NULL,
  `cid` varchar(15) NOT NULL,
  PRIMARY KEY (`did`,`cid`),
  KEY `did_idx` (`did`),
  KEY `cid_idx` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clauseofdevice
-- ----------------------------
INSERT INTO `clauseofdevice` VALUES ('001', '001');
INSERT INTO `clauseofdevice` VALUES ('001', '002');
INSERT INTO `clauseofdevice` VALUES ('001', '003');
INSERT INTO `clauseofdevice` VALUES ('002', '001');
INSERT INTO `clauseofdevice` VALUES ('002', '002');
INSERT INTO `clauseofdevice` VALUES ('002', '003');
INSERT INTO `clauseofdevice` VALUES ('003', '004');
INSERT INTO `clauseofdevice` VALUES ('003', '005');
INSERT INTO `clauseofdevice` VALUES ('003', '006');
INSERT INTO `clauseofdevice` VALUES ('004', '004');
INSERT INTO `clauseofdevice` VALUES ('004', '005');
INSERT INTO `clauseofdevice` VALUES ('004', '006');
INSERT INTO `clauseofdevice` VALUES ('005', '007');
INSERT INTO `clauseofdevice` VALUES ('005', '008');
INSERT INTO `clauseofdevice` VALUES ('005', '009');
INSERT INTO `clauseofdevice` VALUES ('006', '007');
INSERT INTO `clauseofdevice` VALUES ('006', '008');
INSERT INTO `clauseofdevice` VALUES ('006', '009');
INSERT INTO `clauseofdevice` VALUES ('007', '001');
INSERT INTO `clauseofdevice` VALUES ('007', '002');
INSERT INTO `clauseofdevice` VALUES ('007', '003');

-- ----------------------------
-- Table structure for `device`
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `did` varchar(15) NOT NULL,
  `dname` varchar(45) DEFAULT NULL,
  `twoDimensionCode` varchar(100) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES ('001', '1#变', '28282828', '变压器', '北京');
INSERT INTO `device` VALUES ('002', '2#变', '21212121', '变压器', '高新区');
INSERT INTO `device` VALUES ('003', '1#断', '13131313', '断路器', '历下区');
INSERT INTO `device` VALUES ('004', '2#断', '31313131', '断路器', '章丘区');
INSERT INTO `device` VALUES ('005', '1#开', '25252525', '开关', '天桥区');
INSERT INTO `device` VALUES ('006', '1#开', '25252525', '开关', '高新区');

-- ----------------------------
-- Table structure for `deviceclauseofmodule`
-- ----------------------------
DROP TABLE IF EXISTS `deviceclauseofmodule`;
CREATE TABLE `deviceclauseofmodule` (
  `mid` varchar(15) NOT NULL,
  `did` varchar(15) NOT NULL,
  `cid` varchar(15) NOT NULL,
  PRIMARY KEY (`mid`,`did`,`cid`),
  KEY `mid4_idx` (`mid`),
  KEY `did_idx` (`did`),
  KEY `cid_idx` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deviceclauseofmodule
-- ----------------------------
INSERT INTO `deviceclauseofmodule` VALUES ('001', '001', '001');
INSERT INTO `deviceclauseofmodule` VALUES ('001', '001', '002');
INSERT INTO `deviceclauseofmodule` VALUES ('001', '001', '003');
INSERT INTO `deviceclauseofmodule` VALUES ('002', '003', '004');
INSERT INTO `deviceclauseofmodule` VALUES ('002', '003', '005');
INSERT INTO `deviceclauseofmodule` VALUES ('002', '003', '006');
INSERT INTO `deviceclauseofmodule` VALUES ('003', '005', '007');
INSERT INTO `deviceclauseofmodule` VALUES ('003', '005', '008');
INSERT INTO `deviceclauseofmodule` VALUES ('003', '005', '009');

-- ----------------------------
-- Table structure for `deviceclauseoftask`
-- ----------------------------
DROP TABLE IF EXISTS `deviceclauseoftask`;
CREATE TABLE `deviceclauseoftask` (
  `tid` varchar(15) NOT NULL,
  `did` varchar(15) NOT NULL,
  `cid` varchar(15) NOT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`tid`,`did`,`cid`),
  KEY `tid3_idx` (`tid`),
  KEY `did3_idx` (`did`),
  KEY `cid_idx` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of deviceclauseoftask
-- ----------------------------
INSERT INTO `deviceclauseoftask` VALUES ('001', '001', '001', '20C');
INSERT INTO `deviceclauseoftask` VALUES ('001', '001', '002', '100cm');
INSERT INTO `deviceclauseoftask` VALUES ('001', '001', '003', '无');
INSERT INTO `deviceclauseoftask` VALUES ('001', '003', '004', '清洁，无破损、放电痕迹');
INSERT INTO `deviceclauseoftask` VALUES ('001', '003', '005', '各连接头接触良好，无发热松动');
INSERT INTO `deviceclauseoftask` VALUES ('001', '003', '006', '绝缘拉杆及拉杆绝缘子完好无缺陷，连接软铜片是完整，无断片');

-- ----------------------------
-- Table structure for `fault`
-- ----------------------------
DROP TABLE IF EXISTS `fault`;
CREATE TABLE `fault` (
  `fid` varchar(15) NOT NULL,
  `did` varchar(15) NOT NULL,
  `content` varchar(100) NOT NULL,
  `time` datetime DEFAULT NULL,
  `processed` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fault
-- ----------------------------
INSERT INTO `fault` VALUES ('001', '001&&1#变', '油温过高', '2013-07-04 20:00:00', '否');
INSERT INTO `fault` VALUES ('002', '001&&1#变', '油位过高', '2013-07-03 15:00:00', '是');
INSERT INTO `fault` VALUES ('003', '002&&2#变', '有声响', '2013-06-18 20:00:00', '否');
INSERT INTO `fault` VALUES ('004', '003&&1#断', '瓷套管不清洁，有破损裂纹、放电痕迹', '2013-05-22 20:00:00', '是');

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `mid` varchar(15) NOT NULL,
  `mname` varchar(50) NOT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('001', '高新区巡线模板');
INSERT INTO `module` VALUES ('002', '高新区查电模板');
INSERT INTO `module` VALUES ('003', '历下区巡线模板');

-- ----------------------------
-- Table structure for `task`
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `tid` varchar(15) NOT NULL,
  `stime` datetime DEFAULT NULL,
  `etime` datetime DEFAULT NULL,
  `state` enum('done','going','overTime') NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('001', '2013-06-20 08:00:00', '2013-07-07 12:00:00', 'done');

-- ----------------------------
-- Table structure for `taskofworker`
-- ----------------------------
DROP TABLE IF EXISTS `taskofworker`;
CREATE TABLE `taskofworker` (
  `wid` varchar(15) NOT NULL,
  `tid` varchar(15) NOT NULL,
  `atime` datetime DEFAULT NULL,
  `ftime` datetime DEFAULT NULL,
  PRIMARY KEY (`wid`,`tid`),
  KEY `wid_idx` (`wid`),
  KEY `tid_idx` (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of taskofworker
-- ----------------------------
INSERT INTO `taskofworker` VALUES ('001', '001', '2013-06-20 08:00:00', '2013-06-25 12:00:00');

-- ----------------------------
-- Table structure for `worker`
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker` (
  `wid` varchar(15) NOT NULL,
  `wname` varchar(45) NOT NULL,
  `pwd` varchar(45) NOT NULL,
  `age` varchar(45) DEFAULT NULL,
  `addr` varchar(45) DEFAULT NULL,
  `typet` varchar(45) DEFAULT NULL,
  `wtime` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES ('001', '张三', '001', '30', '高新区', '电工', '2年');
INSERT INTO `worker` VALUES ('002', '李四', '002', '28', '章丘区', '巡线工', '1年');
INSERT INTO `worker` VALUES ('003', '王五', '003', '30', '天桥区', '巡线工', '2年');
INSERT INTO `worker` VALUES ('004', '张三', '004', '33', '高新区', '电工', '2年');
INSERT INTO `worker` VALUES ('005', '赵六', '004', '26', '高新区', '电工', '2年');
INSERT INTO `worker` VALUES ('006', '李四', '1', '26', '高新区', '巡线工', '2年');
