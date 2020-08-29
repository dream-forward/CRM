/*
Navicat MySQL Data Transfer

Source Server         : HY_2019_01
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : crm

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2020-08-29 07:33:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `aftersales`
-- ----------------------------
DROP TABLE IF EXISTS `aftersales`;
CREATE TABLE `aftersales` (
  `asid` int(11) NOT NULL AUTO_INCREMENT COMMENT '售后服务id',
  `assubject` varchar(255) NOT NULL COMMENT '售后服务主题',
  `asstep` varchar(20) DEFAULT NULL COMMENT '步骤',
  `asperson` varchar(20) DEFAULT NULL COMMENT '责任人',
  `participation` varchar(20) DEFAULT NULL COMMENT '参与人',
  `clientname` int(11) DEFAULT NULL COMMENT '客户名称',
  `contractnum` varchar(30) NOT NULL COMMENT '合同编号',
  `contractinfo` varchar(255) NOT NULL COMMENT '合同主要信息',
  `hispeople` varchar(30) NOT NULL COMMENT '对方联系人',
  `fixedphone` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `mobilephone` varchar(20) DEFAULT NULL COMMENT '移动电话',
  `emailqq` varchar(30) DEFAULT NULL COMMENT '邮件/QQ',
  `servicetype` varchar(30) NOT NULL COMMENT '服务类型',
  `beginservicedate` date NOT NULL COMMENT '服务开启时间',
  `endservicedate` date NOT NULL COMMENT '服务停止时间',
  `servicecontent` text NOT NULL COMMENT '服务内容',
  `clifeedback` text COMMENT '客户反馈',
  `serviceperson` varchar(20) NOT NULL COMMENT '服务人员',
  `servicecore` varchar(10) DEFAULT NULL COMMENT '服务评分',
  `asfile` varchar(255) DEFAULT NULL COMMENT '相关附件',
  PRIMARY KEY (`asid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='售后服务表';

-- ----------------------------
-- Records of aftersales
-- ----------------------------

-- ----------------------------
-- Table structure for `billing`
-- ----------------------------
DROP TABLE IF EXISTS `billing`;
CREATE TABLE `billing` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '开票表id',
  `priority` enum('3','2','1') DEFAULT NULL COMMENT '优先级:1-高,2-中,3-低',
  `billsubject` varchar(100) NOT NULL COMMENT '主题',
  `billend` date DEFAULT NULL COMMENT '结束时间',
  `billstep` varchar(50) DEFAULT NULL COMMENT '步骤',
  `billperson` varchar(30) DEFAULT NULL COMMENT '责任人',
  `billjoinperson` varchar(30) DEFAULT NULL COMMENT '参与人',
  `billaddress` varchar(255) DEFAULT NULL COMMENT '开票详细地址',
  `billpeople` varchar(30) NOT NULL COMMENT '申请人姓名',
  `billdept` varchar(20) NOT NULL COMMENT '所属部门',
  `billdate` date NOT NULL COMMENT '申请日期',
  `billtiaokuan` text COMMENT '主要技术条款',
  `hisclientname` varchar(50) NOT NULL COMMENT '对方单位全称',
  `billcon` varchar(50) DEFAULT NULL COMMENT '关联合同编号',
  `billtype` varchar(30) NOT NULL COMMENT '开票种类',
  `billcildept` varchar(30) DEFAULT NULL COMMENT '纳税人识别号',
  `bankaccount` varchar(30) DEFAULT NULL COMMENT '开户行账号',
  `bankaddress` varchar(255) DEFAULT NULL COMMENT '开户地址',
  `billmoney` decimal(10,0) unsigned NOT NULL COMMENT '开户金额',
  `billdaxie` varchar(50) DEFAULT NULL COMMENT '大写',
  `billtime` date DEFAULT NULL COMMENT '开票日期',
  `billnum` varchar(30) DEFAULT NULL COMMENT '发票号码',
  `billfile` varchar(50) DEFAULT NULL COMMENT '相关附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='开票申请表';

-- ----------------------------
-- Records of billing
-- ----------------------------

-- ----------------------------
-- Table structure for `business`
-- ----------------------------
DROP TABLE IF EXISTS `business`;
CREATE TABLE `business` (
  `busid` int(10) NOT NULL AUTO_INCREMENT COMMENT '商机id',
  `busname` varchar(50) DEFAULT NULL COMMENT '商机名称（客户+商机）',
  `shortname` varchar(30) NOT NULL COMMENT '商机短名称',
  `priority` enum('3','2','1') DEFAULT NULL COMMENT '优先级:1-高,2-中,3-低',
  `busfrom` varchar(50) NOT NULL COMMENT '客户来源',
  `maymoney` decimal(20,2) DEFAULT NULL COMMENT '预计成交金额',
  `maydate` date DEFAULT NULL COMMENT '预计结单日期',
  `busperson` varchar(20) NOT NULL COMMENT '联系人',
  `perdept` varchar(20) DEFAULT NULL COMMENT '联系人部门',
  `buspostion` varchar(20) DEFAULT NULL COMMENT '联系人职务',
  `busofficenum` varchar(20) DEFAULT NULL COMMENT '联系人办公电话',
  `busnum` varchar(20) DEFAULT NULL COMMENT '联系人移动电话',
  `busqq` varchar(20) DEFAULT NULL COMMENT '联系人QQ',
  `busneed` text NOT NULL COMMENT '业务需求',
  `busfile` varchar(255) DEFAULT NULL COMMENT '相关文件',
  `busdept` varchar(20) DEFAULT NULL COMMENT '商机所属部门',
  `busprincipal` varchar(20) NOT NULL COMMENT '商机负责人',
  `busparticipant` varchar(20) DEFAULT NULL COMMENT '商机参与人',
  `busfocus` varchar(20) DEFAULT NULL COMMENT '商机关注人',
  `clientid` int(10) NOT NULL COMMENT '商机所属客户id',
  PRIMARY KEY (`busid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商机表';

-- ----------------------------
-- Records of business
-- ----------------------------

-- ----------------------------
-- Table structure for `clientinfo`
-- ----------------------------
DROP TABLE IF EXISTS `clientinfo`;
CREATE TABLE `clientinfo` (
  `cliid` int(10) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `cliname` varchar(50) NOT NULL COMMENT '客户名称',
  `clipingyin` varchar(50) NOT NULL COMMENT '客户拼音',
  `clitype` varchar(50) NOT NULL COMMENT '客户分类',
  `clifrom` varchar(50) NOT NULL COMMENT '客户来源',
  `cliindustry` varchar(100) NOT NULL COMMENT '所属行业',
  `cliurl` varchar(100) DEFAULT NULL COMMENT '客户网址',
  `clicountry` varchar(50) NOT NULL COMMENT '所属国家',
  `clicity` varchar(50) NOT NULL COMMENT '所属城市',
  `cliaddress` varchar(255) DEFAULT NULL COMMENT '客户详细地址',
  `clipostlcode` varchar(20) DEFAULT NULL COMMENT '邮政编码',
  `person` varchar(30) NOT NULL COMMENT '联系人',
  `persondept` varchar(30) DEFAULT NULL COMMENT '联系人部门',
  `personposition` varchar(30) DEFAULT NULL COMMENT '联系人职务',
  `perofficenum` varchar(30) DEFAULT NULL COMMENT '联系人办公电话',
  `pernum` varchar(30) NOT NULL COMMENT '联系人移动电话',
  `perqq` varchar(20) DEFAULT NULL COMMENT '联系人QQ',
  `perparent` varchar(20) DEFAULT NULL COMMENT '法人代表',
  `registeredcapital` decimal(20,2) DEFAULT NULL COMMENT '注册资本',
  `append` text COMMENT '附加说明',
  `bankaccount` varchar(30) DEFAULT NULL COMMENT '银行账号',
  `bankname` varchar(30) DEFAULT NULL COMMENT '开户名称',
  `bank` varchar(30) DEFAULT NULL COMMENT '开户银行',
  `bankaddress` varchar(50) DEFAULT NULL COMMENT '银行地址',
  `taxnum` varchar(50) DEFAULT NULL COMMENT '税号',
  `bankphone` varchar(20) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`cliid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户信息表';

-- ----------------------------
-- Records of clientinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `contract`
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `conid` int(11) NOT NULL AUTO_INCREMENT COMMENT '合同id',
  `conname` varchar(50) DEFAULT NULL COMMENT '合同名称（客户名称+合同名称）',
  `shortname` varchar(30) NOT NULL COMMENT '商机短名称',
  `conpriority` enum('3','2','1') DEFAULT NULL COMMENT '合同优先级:1-高,2-中,3-低',
  `clientid` int(11) DEFAULT NULL COMMENT '客户id',
  `connum` varchar(30) NOT NULL COMMENT '合同编号',
  `conmoney` double(20,2) NOT NULL COMMENT '合同金额',
  `condate` date DEFAULT NULL COMMENT '签约日期',
  `begindate` date NOT NULL COMMENT '生效时间',
  `enddate` date NOT NULL COMMENT '失效日期',
  `conperson` varchar(30) NOT NULL COMMENT '对方联系人',
  `conofficenum` varchar(20) DEFAULT NULL COMMENT '固定电话',
  `conphone` varchar(20) NOT NULL COMMENT '移动电话',
  `conqq` varchar(20) DEFAULT NULL COMMENT '邮件/QQ',
  `Technicalclause` text NOT NULL COMMENT '主要技术条款',
  `businessclause` text NOT NULL COMMENT '商务条款',
  `confile` varchar(100) DEFAULT NULL COMMENT '相关附件',
  `condept` int(11) NOT NULL COMMENT '合同所属部门',
  `associatedpersonnel` varchar(20) NOT NULL COMMENT '关联人员',
  `currentstatus` enum('4','3','2','1') NOT NULL COMMENT '合同状态:1-执行,2-关闭,3-撤除,4-搁置',
  PRIMARY KEY (`conid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='合同表';

-- ----------------------------
-- Records of contract
-- ----------------------------

-- ----------------------------
-- Table structure for `documentary`
-- ----------------------------
DROP TABLE IF EXISTS `documentary`;
CREATE TABLE `documentary` (
  `docid` int(11) NOT NULL AUTO_INCREMENT COMMENT '跟单id',
  `busiid` int(11) NOT NULL COMMENT '商机id',
  `doctime` date NOT NULL COMMENT '跟单时间',
  `docsubject` varchar(255) NOT NULL COMMENT '跟单主题',
  `doctype` varchar(50) NOT NULL COMMENT '跟单分类',
  `docuser` varchar(20) NOT NULL COMMENT '跟单人',
  `content` varchar(255) DEFAULT NULL COMMENT '详细内容',
  `docfile` varchar(255) DEFAULT NULL COMMENT '相关附件',
  `busphase` varchar(50) NOT NULL COMMENT '商机阶段',
  PRIMARY KEY (`docid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='跟单表';

-- ----------------------------
-- Records of documentary
-- ----------------------------

-- ----------------------------
-- Table structure for `forum`
-- ----------------------------
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `forid` int(50) NOT NULL AUTO_INCREMENT COMMENT '帖子ID',
  `forsubject` varchar(50) NOT NULL COMMENT '帖子主题',
  `fordate` date NOT NULL COMMENT '发帖时间',
  `userid` int(50) NOT NULL COMMENT '发帖人ID',
  `busid` int(50) NOT NULL COMMENT '商机ID',
  `fortype` varchar(50) NOT NULL COMMENT '帖子分类',
  `forfile` varchar(50) DEFAULT NULL COMMENT '相关附件',
  `forflag` varchar(50) DEFAULT NULL COMMENT '帖子标签',
  `forbody` text NOT NULL COMMENT '帖子内容',
  `forclick` int(50) DEFAULT NULL COMMENT '帖子点击数',
  `callback` int(50) DEFAULT NULL COMMENT '帖子回复数',
  `smert` varchar(50) DEFAULT NULL COMMENT '精华',
  `top` varchar(50) DEFAULT NULL COMMENT '置顶',
  PRIMARY KEY (`forid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='帖子表';

-- ----------------------------
-- Records of forum
-- ----------------------------

-- ----------------------------
-- Table structure for `income`
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `incid` int(11) NOT NULL AUTO_INCREMENT COMMENT '收入id',
  `incdate` date NOT NULL COMMENT '收入日期',
  `inctype` varchar(20) NOT NULL COMMENT '收入分类',
  `incmoney` double(20,2) NOT NULL COMMENT '收入金额',
  `bigwrite` varchar(20) NOT NULL COMMENT '大写金额',
  `incby` enum('2','1') NOT NULL COMMENT '收款方式:1-现金,2-银行转账',
  `incuser` varchar(20) NOT NULL COMMENT '登记人',
  `aboutperson` varchar(20) DEFAULT NULL COMMENT '关联人员',
  `aboutdept` varchar(255) DEFAULT NULL COMMENT '关联部门',
  `hisdept` varchar(50) DEFAULT NULL COMMENT '对方单位',
  `contid` varchar(30) NOT NULL COMMENT '关联合同',
  `inctext` text COMMENT '收入说明',
  PRIMARY KEY (`incid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='收入说明';

-- ----------------------------
-- Records of income
-- ----------------------------

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `perid` int(10) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `pername` varchar(100) DEFAULT NULL COMMENT '权限名称',
  `parentid` int(10) DEFAULT NULL COMMENT '父级id',
  `perurl` varchar(100) DEFAULT NULL COMMENT '权限地址',
  PRIMARY KEY (`perid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for `pinlun`
-- ----------------------------
DROP TABLE IF EXISTS `pinlun`;
CREATE TABLE `pinlun` (
  `pingid` int(50) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `forumid` int(50) NOT NULL COMMENT '回复的帖子ID',
  `pinlunbody` varchar(255) NOT NULL COMMENT '评论内容',
  `pinlundate` date NOT NULL COMMENT '评论时间',
  `parentid` int(50) NOT NULL COMMENT '父级ID',
  PRIMARY KEY (`pingid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

-- ----------------------------
-- Records of pinlun
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `roleid` int(10) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `rolename` varchar(50) NOT NULL COMMENT '角色名称',
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `rpid` int(10) NOT NULL AUTO_INCREMENT,
  `roleid` int(10) DEFAULT NULL COMMENT '角色id',
  `perid` int(10) DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`rpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色与权限中间表';

-- ----------------------------
-- Records of role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户姓名',
  `useraccount` varchar(50) NOT NULL COMMENT '用户账号',
  `userpassword` varchar(255) NOT NULL COMMENT '账号密码',
  `userimg` varchar(255) NOT NULL COMMENT '用户头像',
  `deptname` varchar(20) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `urid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NOT NULL COMMENT '用户id',
  `rid` int(10) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`urid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与角色中间表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
