-- MySQL dump 10.13  Distrib 5.7.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ibm_issue
-- ------------------------------------------------------
-- Server version	5.7.31-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `Admin` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('Admin','Admin123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue`
--

DROP TABLE IF EXISTS `issue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issue` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `issue_no` varchar(45) DEFAULT NULL COMMENT 'Issue编号',
  `issue_type` varchar(45) DEFAULT NULL COMMENT 'Issue类型',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `plan_modify_time` date DEFAULT NULL COMMENT '计划修改时间',
  `actual_complte_time` date DEFAULT NULL COMMENT '实际完成时间',
  `priority` int(11) DEFAULT '4' COMMENT '优先级：1：最高；2：较高；3：一般；4：低',
  `influent_version` varchar(45) DEFAULT NULL COMMENT '影响版本',
  `re_step` longtext COMMENT '重现步骤',
  `create_person_ID` varchar(30) DEFAULT NULL COMMENT 'Issue创建人ID',
  `modify_person_ID` varchar(30) DEFAULT NULL COMMENT 'Issue指定修改人',
  `title` varchar(45) DEFAULT NULL COMMENT 'Issue标题',
  `status` int(11) DEFAULT NULL COMMENT 'Issue状态:  -1：已关闭；0：待解决；1：待验证',
  `solution` longtext COMMENT 'issue的解决方案',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `issue_no_UNIQUE` (`issue_no`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue`
--

LOCK TABLES `issue` WRITE;
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` VALUES (1,'3','1','2020-11-17','2020-11-18','2020-11-18',1,'1.0.0','广告之后更精彩','1','1','我要修改issue,issueNo改为4',1,NULL),(2,'1','1','2020-11-16','2020-11-17','2020-11-17',1,'1.0.0','广告之后更精彩','1','2','这是标题11',2,NULL),(3,'2','1','2020-11-16','2020-11-17','2020-11-17',1,'1.0.0','广告之后更精彩','2','3','这是标题11',1,NULL),(4,'4','1','2020-11-16','2020-11-17','2020-11-17',1,'1.0.0','广告之后更精彩','3','4','这是标题11',1,NULL),(5,'5','1','2020-11-16','2020-11-17','2020-11-17',1,'1.0.0','广告之后更精彩','1','5','这是标题11',1,NULL),(6,'6','1','2020-11-16','2020-11-17','2020-11-17',1,'1.0.0','我一定会回来的','2','6','这是标题11',1,NULL),(7,'7','1','2020-11-16','2020-11-17','2020-11-17',1,'1.0.0','好讨厌的感觉！！','4','7','这是标题11',1,NULL),(8,'8','1','2020-11-16','2020-11-17','2020-11-17',1,'1.0.0','金戈铁马，气吞万里如虎','1','1','这是标题11',1,NULL),(9,'9','1','2020-11-16','2020-11-17','2020-11-17',1,'1.0.0','1.打开PC端网站，删除用户；2.打开服务器，删除db','2','2','这是标题11',1,NULL),(10,'10','1','2020-11-16','2020-11-17','2020-11-17',1,'1.0.0','数据库删除了，无法恢复','6','3','这是标题11',1,NULL),(12,'11','1','2020-11-17','2020-11-18','2020-11-18',1,'1.0.0','狭路相逢勇者胜，勇者非莽者','7','4','这是标题11',1,NULL),(13,'12','1','2020-11-19','2020-11-28','2020-11-21',1,'1.0.0','狭路相逢勇者胜，勇者非莽者','1','2','用户1创建Issue指派用户2去完成',0,NULL),(14,'97c9e2db4db84acd8c2ea4312584e654','1','2020-11-19','2020-11-28',NULL,1,'1.0.0','1.启动服务器2.修改用户信息',NULL,'2','用户1创建Issue指派用户2去完成',0,NULL),(15,'8749e82dade64bceb03b76e90fc43453','1','2020-11-19','2020-11-28',NULL,1,'1.0.0','1.启动服务器2.修改用户信息',NULL,'2','用户1创建Issue指派用户2去完成',0,NULL),(16,'91cbf1429b354e05b63797da24c9046d','1','2020-11-19','2020-11-28',NULL,1,'1.0.0','1.启动服务器2.修改用户信息',NULL,'2','用户1创建Issue指派用户2去完成',0,NULL),(17,'27b48e85181245ae8801c7a7ae48faa0','1','2020-11-19','2020-11-28',NULL,1,'1.0.0','1.启动服务器2.修改用户信息','1','2','用户1创建Issue指派用户2去完成',0,NULL);
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue_report`
--

DROP TABLE IF EXISTS `issue_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issue_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` varchar(30) NOT NULL COMMENT '用户ID，对于user表的loginID字段',
  `username` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `create_count` int(11) DEFAULT '0' COMMENT '创建Issue数',
  `receive_count` int(11) DEFAULT '0' COMMENT '收到Issue数',
  `modify_count` int(11) DEFAULT '0' COMMENT '修改Issue数',
  `finish_count` int(11) DEFAULT '0' COMMENT '完成(解决)的issue数',
  `finished_per` float DEFAULT '0' COMMENT '完成率',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='issue报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue_report`
--

LOCK TABLES `issue_report` WRITE;
/*!40000 ALTER TABLE `issue_report` DISABLE KEYS */;
INSERT INTO `issue_report` VALUES (1,'1','张三',6,0,0,0,0),(2,'2','李四',0,5,0,0,0),(3,'3','王五',0,0,0,0,0),(4,'4','李云龙',0,0,0,0,0),(5,'5','周卫国',0,0,0,0,0),(6,'6','周卫国',0,0,0,0,0),(7,'7','周卫国',0,0,0,0,0);
/*!40000 ALTER TABLE `issue_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `sortID` int(11) NOT NULL AUTO_INCREMENT,
  `loginID` int(11) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `registeDate` date DEFAULT NULL,
  PRIMARY KEY (`sortID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'张三','2657001648@qq.com','123456',0,1,'2018-11-18'),(2,2,'李四','2657001890@qq.com','123456',1,0,'2020-11-18'),(3,3,'王五','2657001890@qq.com','123456',1,0,'2020-12-18'),(4,4,'李云龙','2657001890@qq.com','123456',1,0,'2020-11-18'),(5,5,'周卫国','1234556789@qq.com','123456',1,0,'2020-11-18'),(6,6,'周卫国','1234556789@qq.com','123456',1,0,'2020-11-18'),(7,7,'周卫国','1234556789@qq.com','789000',1,0,'2020-11-18');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-19 17:33:13
