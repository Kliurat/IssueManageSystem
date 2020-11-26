-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.31-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 ibm_issue2 的数据库结构
CREATE DATABASE IF NOT EXISTS `ibm_issue2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ibm_issue2`;

-- 导出  表 ibm_issue2.admin 结构
CREATE TABLE IF NOT EXISTS `admin` (
  `Admin` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 正在导出表  ibm_issue2.admin 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`Admin`, `password`) VALUES
	('Admin', 'Admin123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

-- 导出  表 ibm_issue2.issue 结构
CREATE TABLE IF NOT EXISTS `issue` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `issue_no` varchar(45) DEFAULT NULL COMMENT 'Issue编号',
  `issue_type` varchar(45) DEFAULT NULL COMMENT 'Issue类型',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `plan_modify_time` datetime DEFAULT NULL COMMENT '计划修改时间',
  `actual_complte_time` datetime DEFAULT NULL COMMENT '实际完成时间',
  `priority` int(11) DEFAULT '4' COMMENT '优先级：1：最高；2：较高；3：一般；4：低',
  `influent_version` varchar(45) DEFAULT NULL COMMENT '影响版本',
  `re_step` longtext COMMENT '重现步骤',
  `create_person_ID` varchar(30) DEFAULT NULL COMMENT 'Issue创建人ID',
  `modify_person_ID` varchar(30) DEFAULT NULL COMMENT 'Issue指定修改人',
  `title` varchar(110) DEFAULT NULL COMMENT 'Issue标题',
  `status` int(11) DEFAULT NULL COMMENT 'Issue状态:  -1：已关闭；0：待解决；1：待验证',
  `solution` longtext COMMENT 'issue的解决方案',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `issue_no_UNIQUE` (`issue_no`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- 正在导出表  ibm_issue2.issue 的数据：~26 rows (大约)
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` (`id`, `issue_no`, `issue_type`, `create_date`, `plan_modify_time`, `actual_complte_time`, `priority`, `influent_version`, `re_step`, `create_person_ID`, `modify_person_ID`, `title`, `status`, `solution`) VALUES
	(27, '164003', 'New Feather', '2020-11-24 00:00:00', '2020-11-25 00:00:00', '2020-11-24 00:00:00', 3, 'v1.0.0', '1. 重新创建Issue账号\n2. 登陆\n3. 创建', 'A001', 'A002', '按钮是否显示\n', 0, '加勒比海盗'),
	(28, '9a1369', 'New Feather', '2020-11-24 00:00:00', '2020-11-26 00:00:00', '2020-11-24 00:00:00', 3, 'v1.0.0', '"1、打开系统页面\n2、点击注册按钮"\n', 'A002', 'A002', '点击注册\r\n', -1, '1. 采用vue-element-UI解决'),
	(29, 'f61927', 'Story', '2020-11-24 00:00:00', '2020-11-27 00:00:00', '2020-11-24 00:00:00', 3, 'v1.0.0', '"填写内容：\n登陆ID：123456789123456789123456789123456\n姓名：张三\n邮箱：\r\n\r\n12345678@163.com\n输入密码：Aa@123456\n确认密码：Aa@123456"\r\n', 'A001', 'A004', '登陆ID超过30个字符\r\n', -1, '目前已解决，可能是版本问题'),
	(30, 'f61928', 'New Feather', '2020-11-24 00:00:00', '2020-11-27 00:00:00', '2020-11-24 00:00:00', 3, 'v1.0.0', '"填写内容：\n登陆ID：1234567891\n姓名：张三张三张三张三张三\n张三张三张三张\r\n\r\n三张三张三\n邮箱：12345678@163.com\n输入密码：Aa@123456\n确认密码：Aa@123456"\r\n', 'A002', 'A002', '登陆姓名超过30个字符\r\n', -1, '目前已解决，可能是版本问题'),
	(31, 'f61929', 'Story', '2020-11-24 00:00:00', '2020-11-27 00:00:00', '2020-11-24 00:00:00', 3, 'v1.0.0', '"填写内容：\n登陆ID：1234567891\n姓名：张三\n邮\r\n\r\n箱:123456789123456789123456789@163.com\n输入密码：Aa@123456\n确认密码：Aa@123456"\r\n', 'A001', 'A004', '登陆邮箱超过30个字符\r\n', -1, '目前已解决，可能是版本问题'),
	(32, 'ef20f9', 'Task', '2020-11-26 09:41:57', '2020-11-26 09:46:00', NULL, 3, 'v1.0.0', '"填写内容：\n登陆ID：1234567891\n姓名：张三\n邮箱:12345678@163.com\n输入密码：1234567Aa\n确认密码：\r\n\r\n1234567Aa"\r\n', 'A002', 'A002', '输入密码缺少特殊字符', 0, NULL),
	(33, '71bc1e', 'Task', '2020-11-26 09:45:32', '2020-11-26 09:50:00', NULL, 3, 'v1.0.0', '"填写内容：\n登陆ID：1234567891\n姓名：张三\n邮箱:12345678@163.com\n输入密码：1234567a@\n确认密码：\r\n\r\n1234567a@"\r\n', 'A001', 'A003', '输入密码缺少大写字母', 0, NULL),
	(34, 'e236e8', 'New Feather', '2020-11-26 09:48:44', '2020-11-26 09:52:00', NULL, 3, 'v1.0.0', '"填写内容：\n登陆ID：123456789123456789123456789123456\n姓名：张三\n邮箱:12345678@163.com\n输\r\n\r\n入密码：1234567A@\n确认密码：1234567A@"\r\n', 'A002', 'A003', '输入密码缺少小写字母', 0, NULL),
	(35, '5c6150', 'Story', '2020-11-26 09:52:25', '2020-11-26 09:56:00', NULL, 3, 'v1.0.0', '"填写内容：\n登陆ID：1234567891\n姓名：张三\n邮箱:12345678@163.com\n输入密码：1234@Aa\n确认密码：\r\n\r\n1234@Aa"\r\n', 'A003', 'A003', '输入密码少于8位', 0, NULL),
	(36, 'b752c5', 'New Feather', '2020-11-26 09:57:54', '2020-11-26 09:59:00', NULL, 3, 'v1.0.0', '"填写内容：\n登陆ID：1234567891\n姓名：张三\n邮箱12345678@163.com\n输入密码：Aa@123456\n确认\r\n\r\n密码：Aa@1234561"\r\n', 'A003', 'A002', '"确认密码是否与 \n密码相同检测"', 0, NULL),
	(37, '2798a7', 'Story', '2020-11-26 09:58:27', '2020-11-26 09:03:00', NULL, 3, 'v1.0.0', '"1、填写内容：\n登陆ID：1234567891\n姓名：张三\n邮箱12345678@163.com\n输入密码：Aa@123456\n确认密码\r\n\r\n：Aa@123456\n2、点击确认按钮"\r\n', 'A002', 'A004', '正确填入信息', 0, NULL),
	(38, 'cdf7d2', 'Task', '2020-11-26 09:59:01', '2020-11-26 09:02:00', NULL, 3, 'v1.0.0', '"1、打开系统主页\n2、未登陆的系统用户点击登陆按钮"', 'A004', 'A001', '点击登陆', 0, '试一下'),
	(39, '737eb4', 'Story', '2020-11-26 09:59:33', '2020-11-27 09:59:00', NULL, 3, 'v1.0.0', '"1、填写内容：\n登陆ID：123456789123456789123456789123456\n输入密码：Aa@123456\n"\r\n', 'A001', 'A002', '登陆ID超过30个字符', 0, NULL),
	(40, '6261f7', 'New Feather', '2020-11-26 10:12:25', '2020-11-26 10:15:00', NULL, 3, 'v1.0.0', '"1、填写内容：\n登陆ID：1234567891\n输入密码：Aa@123456123456789123456789123456789123456\n2、\r\n\r\n点击登陆按钮"', 'A001', 'A002', '登陆密码超过30个字符', 0, NULL),
	(41, 'b92f09', 'Task', '2020-11-26 10:22:57', '2020-11-26 10:25:00', NULL, 2, 'v1.0.0', '"1、填写内容：\n登陆ID：1234567891\n输入密码：Aa@12345\n2、点击登陆按钮"\n', 'A001', 'A002', '输入错\r\n\r\n误密码', 0, NULL),
	(42, '570a73', 'bug', '2020-11-26 11:50:44', '2020-11-28 11:50:00', NULL, 3, 'v1.0.0', '"1、填写内容：\n登陆ID：1234567891\n输入密码：Aa@123456\n2、点击登陆按钮"\r\n', 'A001', 'A002', '输入\r\n\r\n正确信息', 0, NULL),
	(43, 'd5ec36', 'bug', '2020-11-26 11:52:04', '2020-12-19 14:52:00', NULL, 3, 'v1.0.0', '"1、打开系统主页\n2、成功登陆\n3、点击修改个人信息按钮"', 'A001', 'A002', '"已登录用户点击修\n改个人\r\n\r\n信息按钮"', 0, NULL),
	(44, '0bbd89', 'bug', '2020-11-26 11:54:03', '2020-11-28 11:53:00', NULL, 3, 'v1.0.0', '进入用户个人信息修改页面\r\n', 'A001', 'A002', '修改登陆ID', 0, NULL),
	(45, '9d4822', 'bug', '2020-11-26 11:57:23', '2020-11-28 11:57:00', NULL, 3, 'v1.0.0', '"1、进入用户个人信息修改页面\n2、填写内容：\n姓名：张三张三张三张三张三\n张三张三张三张三张三张三\n张\r\n\r\n三张三张三张三张三张三\n邮箱：12345678@163.com\n输入密码：Aa@123456\n确认密码：Aa@123456"\r\n', 'A001', 'A002', '修改邮箱超过30个字符', 0, NULL),
	(46, '31d706', 'bug', '2020-11-26 11:57:25', '2020-11-28 11:57:00', NULL, 3, 'v1.0.0', '"\n2、填写内容：\n姓名：张三\n邮箱:123456789123456789123456789@163.com\n输入密码：Aa@123456\n确认密码\r\n\r\n：Aa@123456"\r\n', 'A001', 'A002', '修改姓名超过30个字符', 0, NULL),
	(47, '4be713', 'bug', '2020-11-26 11:57:29', '2020-11-28 11:57:00', NULL, 3, 'v1.0.0', '"1、进入用户个人信息修改页面\n2、填写内容：\n登陆ID：1234567891\n姓名：张三\n邮箱:12345678@163.com\n\r\n\r\n输入密码：1234567Aa\n确认密码：1234567Aa"\r\n', 'A001', 'A002', '修改密码缺少特殊字符', 0, NULL),
	(48, '567e2b', 'bug', '2020-11-26 11:57:36', '2020-11-28 11:57:00', NULL, 3, 'v1.0.0', '"1、进入用户个人信息修改页面\n2、填写内容：\n姓名：张三\n邮箱:12345678@163.com\n输入密码：1234567a@\n\r\n\r\n确认密码：1234567a@"\r\n', 'A001', 'A002', '修改密码缺少大写字母', 0, NULL),
	(49, '7f6332', 'Task', '2020-11-26 12:21:27', '2020-11-26 12:24:00', NULL, 3, 'v1.0.0', '"1、进入用户个人信息修改页面\n2、填写内容：\n姓名：张三\n邮箱:12345678@163.com\n输入密码：1234567A@\r\n\r\n\n确认密码：1234567A@\n3、点击确认按钮"\r\n', 'A001', 'A002', '修改密码缺少小写字母', 0, NULL),
	(50, '295b37', 'Sub-Task', '2020-11-26 12:23:35', '2020-11-26 12:24:00', NULL, 3, 'v1.0.0', '"1、进入用户个人信息修改页面\n2、填写内容：\n姓名：张三\n邮箱:12345678@163.com\n输入密码：\r\n\r\n1234@Aa\n确认密码：1234@Aa"', 'A001', 'A002', '修改密码少于8个字母', 0, NULL),
	(51, '2c9e20', 'New Feather', '2020-11-26 12:53:22', '2020-11-26 12:55:00', NULL, 3, 'v1.0.0', '"1、打开系统页面\r\n2、用普通用户账号登陆\r\n3、点击“创建新Issue”按钮"\r\n', 'A001', 'A002', '萨芬大师傅', 0, NULL),
	(52, '27ea32', 'New Feather', '2020-11-26 13:05:07', '2020-11-26 13:08:00', NULL, 3, 'v1.0.0', '"1、打开系统页面\n2、用普通用户账号登陆\n3、观察系统页面"\n', 'A001', 'A002', '"确认密码是否\r\n\r\n与 \n修改密码相同检测"', 0, NULL);
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;

-- 导出  表 ibm_issue2.issue_picture 结构
CREATE TABLE IF NOT EXISTS `issue_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `issue_no` varchar(10) NOT NULL,
  `img_url` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='Issue的图片';

-- 正在导出表  ibm_issue2.issue_picture 的数据：~9 rows (大约)
/*!40000 ALTER TABLE `issue_picture` DISABLE KEYS */;
INSERT INTO `issue_picture` (`id`, `issue_no`, `img_url`) VALUES
	(1, 'b92f09', 'F:/JMPX/1606357377622login.jpg'),
	(2, 'b92f09', 'F:/JMPX/1606357377636issue.gif'),
	(3, 'b92f09', 'F:/JMPX/160636264517510.jfif'),
	(4, 'b92f09', 'F:/JMPX/160636264518212.jpg'),
	(5, '295b37', 'F:/JMPX/1606364615437error.jpg'),
	(6, '295b37', 'F:/JMPX/1606364615600return.gif'),
	(7, '27ea32', 'F:/JMPX/1606367107302issue.gif'),
	(8, '27ea32', 'F:/JMPX/1606367107396error.jpg'),
	(9, '27ea32', 'F:/JMPX/1606367107401return.gif');
/*!40000 ALTER TABLE `issue_picture` ENABLE KEYS */;

-- 导出  表 ibm_issue2.issue_refuse_reason 结构
CREATE TABLE IF NOT EXISTS `issue_refuse_reason` (
  `issue_no` varchar(10) NOT NULL,
  `reason` longtext,
  PRIMARY KEY (`issue_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  ibm_issue2.issue_refuse_reason 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `issue_refuse_reason` DISABLE KEYS */;
INSERT INTO `issue_refuse_reason` (`issue_no`, `reason`) VALUES
	('cdf7d2', '小事');
/*!40000 ALTER TABLE `issue_refuse_reason` ENABLE KEYS */;

-- 导出  表 ibm_issue2.issue_report 结构
CREATE TABLE IF NOT EXISTS `issue_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `login_id` varchar(30) NOT NULL COMMENT '用户ID，对于user表的loginID字段',
  `username` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `create_count` int(11) DEFAULT '0' COMMENT '创建Issue数',
  `receive_count` int(11) DEFAULT '0' COMMENT '收到Issue数',
  `modify_count` int(11) DEFAULT '0' COMMENT '修改Issue数',
  `finished_per` float DEFAULT '0' COMMENT '完成率',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 COMMENT='issue报表';

-- 正在导出表  ibm_issue2.issue_report 的数据：~30 rows (大约)
/*!40000 ALTER TABLE `issue_report` DISABLE KEYS */;
INSERT INTO `issue_report` (`id`, `login_id`, `username`, `create_count`, `receive_count`, `modify_count`, `finished_per`) VALUES
	(56, 'A001', '吕布', 18, 1, 0, 0),
	(57, 'A002', '徐庶', 5, 19, 2, 10.5263),
	(58, 'A003', '姜维', 2, 3, 0, 0),
	(59, 'A004', '曹丕', 1, 3, 2, 66.6667),
	(60, 'A005', '刘禅', 0, 0, 0, NULL),
	(61, 'A006', '曹真', 0, 0, 0, NULL),
	(62, 'A007', '曹爽', 0, 0, 0, NULL),
	(63, 'A008', '马良', 0, 0, 0, NULL),
	(64, 'A009', '王允', 0, 0, 0, NULL),
	(65, 'A010', '甘宁', 0, 0, 0, NULL),
	(66, 'A011', '左慈', 0, 0, 0, NULL),
	(67, 'A012', '孔融', 0, 0, 0, NULL),
	(68, 'A013', '冯习', 0, 0, 0, NULL),
	(69, 'A014', '邓芝', 0, 0, 0, NULL),
	(70, 'A015', '文钦', 0, 0, 0, NULL),
	(71, 'A016', '田丰', 0, 0, 0, NULL),
	(72, 'U001', '司马懿', 0, 0, 0, NULL),
	(73, 'U002', '周瑜', 0, 0, 0, NULL),
	(74, 'U003', '张飞', 0, 0, 0, NULL),
	(75, 'U004', '鲁肃', 0, 0, 0, NULL),
	(76, 'U005', '孙策', 0, 0, 0, NULL),
	(77, 'U006', '董卓', 0, 0, 0, NULL),
	(78, 'U007', '庞统', 0, 0, 0, NULL),
	(79, 'U008', '刘备', 0, 0, 0, NULL),
	(80, 'U009', '曹操', 0, 0, 0, NULL),
	(81, 'U010', '郭嘉', 0, 0, 0, NULL),
	(82, 'U011', '关羽', 0, 0, 0, NULL),
	(83, 'U012', '马超', 0, 0, 0, NULL),
	(84, 'U013', '赵云', 0, 0, 0, NULL),
	(85, 'U014', '孙权', 0, 0, 0, NULL);
/*!40000 ALTER TABLE `issue_report` ENABLE KEYS */;

-- 导出  表 ibm_issue2.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `sortID` int(11) NOT NULL AUTO_INCREMENT,
  `loginID` varchar(30) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `role` int(11) DEFAULT '0',
  `registeDate` datetime DEFAULT NULL,
  PRIMARY KEY (`sortID`),
  UNIQUE KEY `user_loginID_uindex` (`loginID`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4;

-- 正在导出表  ibm_issue2.user 的数据：~46 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`sortID`, `loginID`, `username`, `email`, `password`, `status`, `role`, `registeDate`) VALUES
	(55, 'A001', '吕布', '268907332@qq.com', '123456', 1, 0, '2020-11-26 14:19:03'),
	(56, 'A002', '徐庶', '268907333@qq.com', '123456', 1, 0, '2020-11-26 15:19:03'),
	(57, 'A003', '姜维', '268907334@qq.com', '123456', 1, 0, '2020-11-26 15:19:03'),
	(58, 'A004', '曹丕', '268907335@qq.com', '123456', 1, 0, '2020-10-26 15:19:03'),
	(59, 'A005', '刘禅', '268907336@qq.com', '123456', 1, 0, '2020-11-22 15:19:03'),
	(60, 'A006', '曹真', '268907337@qq.com', '123456', 1, 0, '2020-11-26 15:19:03'),
	(61, 'A007', '曹爽', '268907338@qq.com', '1', 1, 0, '2020-10-21 04:19:03'),
	(62, 'A008', '马良', '268907339@qq.com', '1', 1, 0, '2020-11-16 15:19:03'),
	(63, 'A009', '王允', '268907340@qq.com', '1', 1, 0, '2020-10-26 15:19:03'),
	(64, 'A010', '甘宁', '268907341@qq.com', '1', 1, 0, '2020-11-26 15:19:03'),
	(65, 'A011', '左慈', '268907342@qq.com', '1', 1, 0, '2020-11-26 15:19:03'),
	(66, 'A012', '孔融', '268907343@qq.com', '1', 1, 0, '2020-11-15 15:19:03'),
	(67, 'A013', '冯习', '268907344@qq.com', '1', 1, 0, '2020-11-06 15:19:03'),
	(68, 'A014', '邓芝', '268907345@qq.com', '1', 1, 0, '2020-11-12 15:19:03'),
	(69, 'A015', '文钦', '268907346@qq.com', '1', 1, 0, '2020-11-13 15:19:03'),
	(70, 'A016', '田丰', '268907347@qq.com', '1', 1, 0, '2020-11-13 15:19:03'),
	(71, 'U001', '司马懿', '268907348@qq.com', '1', 1, 1, '2020-11-14 15:19:03'),
	(72, 'U002', '周瑜', '268907349@qq.com', '1', 1, 1, '2020-11-26 15:19:03'),
	(73, 'U003', '张飞', '268907350@qq.com', '1', 1, 1, '2020-11-26 15:19:03'),
	(74, 'U004', '鲁肃', '268907351@qq.com', '1', 1, 1, '2020-11-26 15:19:03'),
	(75, 'U005', '孙策', '268907352@qq.com', '1', 1, 1, '2020-11-16 15:19:03'),
	(76, 'U006', '董卓', '268907353@qq.com', '1', 1, 1, '2020-11-15 15:19:03'),
	(77, 'U007', '庞统', '268907354@qq.com', '1', 1, 1, '2020-11-13 15:19:03'),
	(78, 'U008', '刘备', '268907355@qq.com', '1', 1, 1, '2020-11-26 15:19:03'),
	(79, 'U009', '曹操', '268907356@qq.com', '1', 1, 1, '2020-11-15 14:19:03'),
	(80, 'U010', '郭嘉', '268907357@qq.com', '1', 1, 1, '2020-11-17 15:19:03'),
	(81, 'U011', '关羽', '268907358@qq.com', '1', 1, 1, '2020-11-26 15:19:03'),
	(82, 'U012', '马超', '268907359@qq.com', '1', 1, 1, '2020-11-26 15:19:03'),
	(83, 'U013', '赵云', '268907360@qq.com', '1', 1, 1, '2020-11-26 15:19:03'),
	(84, 'U014', '孙权', '268907361@qq.com', '1', 1, 1, '2020-11-26 15:19:03'),
	(85, 'A017', '吕布', '268907332@qq.com', '123456', 1, 0, '2020-11-26 16:50:43'),
	(86, 'A018', '徐庶', '268907333@qq.com', '123456', 1, 0, '2020-11-26 16:50:43'),
	(87, 'A019', '姜维', '268907334@qq.com', '123456', 1, 0, '2020-11-26 16:50:43'),
	(88, 'A020', '曹丕', '268907335@qq.com', '123456', 1, 0, '2020-11-26 16:50:43'),
	(89, 'A021', '刘禅', '268907336@qq.com', '123456', 1, 0, '2020-11-26 16:50:43'),
	(90, 'A022', '曹真', '268907337@qq.com', '123456', 1, 0, '2020-11-26 16:50:43'),
	(91, 'A023', '曹爽', '268907338@qq.com', '1', 1, 0, '2020-11-26 16:50:43'),
	(92, 'A024', '马良', '268907339@qq.com', '1', 1, 0, '2020-11-26 16:50:43'),
	(93, 'A025', '王允', '268907340@qq.com', '1', 1, 0, '2020-11-26 16:50:43'),
	(94, 'A026', '甘宁', '268907341@qq.com', '1', 1, 0, '2020-11-26 16:50:43'),
	(95, 'A027', '左慈', '268907342@qq.com', '1', 1, 0, '2020-11-26 16:50:43'),
	(96, 'A028', '孔融', '268907343@qq.com', '1', 1, 0, '2020-11-26 16:50:43'),
	(97, 'A029', '冯习', '268907344@qq.com', '1', 1, 0, '2020-11-26 16:50:43'),
	(98, 'A030', '邓芝', '268907345@qq.com', '1', 1, 0, '2020-11-26 16:50:43'),
	(99, 'A031', '文钦', '268907346@qq.com', '1', 1, 0, '2020-11-26 16:50:43'),
	(100, 'A032', '田丰', '268907347@qq.com', '1', 1, 0, '2020-11-26 16:50:43');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
