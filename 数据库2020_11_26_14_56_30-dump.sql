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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue`
--

LOCK TABLES `issue` WRITE;
/*!40000 ALTER TABLE `issue` DISABLE KEYS */;
INSERT INTO `issue` VALUES (27,'164003','创建Issue的Bug','2020-11-24 00:00:00','2020-11-25 00:00:00','2020-11-24 00:00:00',3,'v1.0','1. 重新创建Issue账号\n2. 登陆\n3. 创建','liangyuerong','k1971','创建Issue',0,'加勒比海盗'),(28,'9a1369','修改Issue的Bug','2020-11-24 00:00:00','2020-11-26 00:00:00','2020-11-24 00:00:00',3,'v1.1','1.选择图片上传\n2.console.log()报错','liangyuerong','caihaifeng','第二个Issue',-1,'1. 采用vue-element-UI解决'),(29,'f61927','关闭Issue','2020-11-24 00:00:00','2020-11-27 00:00:00','2020-11-24 00:00:00',3,'v1.0','1.登陆蔡海锋的账号\n2.指定修改人为xaioke','caihaifeng','k1971','派给xiaoke',-1,'目前已解决，可能是版本问题'),(30,'f61928','关闭Issue','2020-11-24 00:00:00','2020-11-27 00:00:00','2020-11-24 00:00:00',3,'v1.0','1.登陆蔡海锋的账号\n2.指定修改人为xaioke','caihaifeng','k1971','派给xiaoke',-1,'目前已解决，可能是版本问题'),(31,'f61929','关闭Issue','2020-11-24 00:00:00','2020-11-27 00:00:00','2020-11-24 00:00:00',3,'v1.0','1.登陆蔡海锋的账号\n2.指定修改人为xaioke','caihaifeng','k1971','派给xiaoke',-1,'目前已解决，可能是版本问题'),(32,'ef20f9','test','2020-11-26 09:41:57','2020-11-26 09:46:00',NULL,3,'test','1.test\n2.test','caihaifeng','987654321','test',0,NULL),(33,'71bc1e','test','2020-11-26 09:45:32','2020-11-26 09:50:00',NULL,3,'test','1.test\n2.test\n3.test','caihaifeng','a123456','test',0,NULL),(34,'e236e8','试ham','2020-11-26 09:48:44','2020-11-26 09:52:00',NULL,3,'试ham','1\n2\n3\n4','caihaifeng','987654321','试ham',0,NULL),(35,'5c6150','发发','2020-11-26 09:52:25','2020-11-26 09:56:00',NULL,3,'阿发','发放大法','caihaifeng','987654321','现在的工时费',0,NULL),(36,'b752c5','dasda','2020-11-26 09:57:54','2020-11-26 09:59:00',NULL,3,'sadad','dsadsadddadaddada','caihaifeng','wairuigood123','按时发发',0,NULL),(37,'2798a7','gsgssdg','2020-11-26 09:58:27','2020-11-26 09:03:00',NULL,3,'gdsgsdgds','fdsfsaffdss','caihaifeng','wairuigood123','fsfsgs',0,NULL),(38,'cdf7d2','dsadasd','2020-11-26 09:59:01','2020-11-26 09:02:00',NULL,3,'dddaad','dsaasddsa','caihaifeng','liangyuerong','dsasad',0,'试一下'),(39,'737eb4','asdasd','2020-11-26 09:59:33','2020-11-27 09:59:00',NULL,3,'dsaddsa','dsadasd','caihaifeng','wairuigood123','dadsa',0,NULL),(40,'6261f7','dasdsasaddsasaasafsadsgg','2020-11-26 10:12:25','2020-11-26 10:15:00',NULL,3,'dsffdsfdsfds','dsfdsffdsdsffdsfes','caihaifeng','a123456','daddasda',0,NULL),(41,'b92f09','wqe','2020-11-26 10:22:57','2020-11-26 10:25:00',NULL,2,'qw','111111111111111111111\n22222222222','caihaifeng','a123456','dsgdgds',0,NULL),(42,'570a73','bug','2020-11-26 11:50:44','2020-11-28 11:50:00',NULL,3,'v1.00.1','test1','caihaifeng','1234567893','test1',0,NULL),(43,'d5ec36','bug','2020-11-26 11:52:04','2020-12-19 14:52:00',NULL,3,'v1.00.2','tst1','caihaifeng','1234567891','test2',0,NULL),(44,'0bbd89','bug','2020-11-26 11:54:03','2020-11-28 11:53:00',NULL,3,'v,d12','2e','caihaifeng','1234567891','321321',0,NULL),(45,'9d4822','bug','2020-11-26 11:57:23','2020-11-28 11:57:00',NULL,3,'v232','d21d21','caihaifeng','21','test3',0,NULL),(46,'31d706','bug','2020-11-26 11:57:25','2020-11-28 11:57:00',NULL,3,'v232','d21d21','caihaifeng','21','test3',0,NULL),(47,'4be713','bug','2020-11-26 11:57:29','2020-11-28 11:57:00',NULL,3,'v232','d21d21','caihaifeng','21','test3',0,NULL),(48,'567e2b','bug','2020-11-26 11:57:36','2020-11-28 11:57:00',NULL,3,'v232','d21d21','caihaifeng','21','test3',0,NULL),(49,'7f6332','gsgsg','2020-11-26 12:21:27','2020-11-26 12:24:00',NULL,3,'sdgsggds','dssadsadsaas','caihaifeng','21','就这个',0,NULL),(50,'295b37','gsgsg','2020-11-26 12:23:35','2020-11-26 12:24:00',NULL,3,'sdgsggds','dssadsadsaas','caihaifeng','21','就这个',0,NULL),(51,'2c9e20','大撒旦','2020-11-26 12:53:22','2020-11-26 12:55:00',NULL,3,' 大师的飒飒','花费大概','caihaifeng','101','萨芬大师傅',0,NULL),(52,'27ea32','公司大股东','2020-11-26 13:05:07','2020-11-26 13:08:00',NULL,3,'故事故事大概','方式的更大的','caihaifeng','wairuigood123','方式实施哥特式',0,NULL);
/*!40000 ALTER TABLE `issue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue_picture`
--

DROP TABLE IF EXISTS `issue_picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issue_picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `issue_no` varchar(10) NOT NULL,
  `img_url` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='Issue的图片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue_picture`
--

LOCK TABLES `issue_picture` WRITE;
/*!40000 ALTER TABLE `issue_picture` DISABLE KEYS */;
INSERT INTO `issue_picture` VALUES (1,'b92f09','F:/JMPX/1606357377622login.jpg'),(2,'b92f09','F:/JMPX/1606357377636issue.gif'),(3,'b92f09','F:/JMPX/160636264517510.jfif'),(4,'b92f09','F:/JMPX/160636264518212.jpg'),(5,'295b37','F:/JMPX/1606364615437error.jpg'),(6,'295b37','F:/JMPX/1606364615600return.gif'),(7,'27ea32','F:/JMPX/1606367107302issue.gif'),(8,'27ea32','F:/JMPX/1606367107396error.jpg'),(9,'27ea32','F:/JMPX/1606367107401return.gif');
/*!40000 ALTER TABLE `issue_picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue_refuse_reason`
--

DROP TABLE IF EXISTS `issue_refuse_reason`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issue_refuse_reason` (
  `issue_no` varchar(10) NOT NULL,
  `reason` longtext,
  PRIMARY KEY (`issue_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue_refuse_reason`
--

LOCK TABLES `issue_refuse_reason` WRITE;
/*!40000 ALTER TABLE `issue_refuse_reason` DISABLE KEYS */;
INSERT INTO `issue_refuse_reason` VALUES ('cdf7d2','小事');
/*!40000 ALTER TABLE `issue_refuse_reason` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `issue_report`
--

DROP TABLE IF EXISTS `issue_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `issue_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `login_id` varchar(30) NOT NULL COMMENT '用户ID，对于user表的loginID字段',
  `username` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `create_count` int(11) DEFAULT '0' COMMENT '创建Issue数',
  `receive_count` int(11) DEFAULT '0' COMMENT '收到Issue数',
  `modify_count` int(11) DEFAULT '0' COMMENT '修改Issue数',
  `finished_per` float DEFAULT '0' COMMENT '完成率',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='issue报表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `issue_report`
--

LOCK TABLES `issue_report` WRITE;
/*!40000 ALTER TABLE `issue_report` DISABLE KEYS */;
INSERT INTO `issue_report` VALUES (15,'liangyuerong',NULL,2,1,0,0),(16,'k1971','xiaoke',0,2,2,100),(17,'caihaifeng','caihaifeng',22,1,1,-2147480000),(18,'987654321','七七',0,3,0,0),(19,'a123456','a123456',0,3,0,0),(20,'wairuigood123','nameless',0,4,0,0),(21,'1234567893','张三',0,1,0,0),(22,'1234567891','张三',0,2,0,0),(23,'21','蔡海锋',0,1,0,0),(24,'101','梁悦荣',0,1,0,0);
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
  `loginID` varchar(30) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `role` int(11) DEFAULT '0',
  `registeDate` datetime DEFAULT NULL,
  PRIMARY KEY (`sortID`),
  UNIQUE KEY `user_loginID_uindex` (`loginID`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (43,'k1971','xiaoke','1971367778@163.com','Aa!11111',1,0,'2020-11-24 00:00:00'),(44,'caihaifeng','caihaifeng','caihaifeng@163.com','Caihaifeng!',1,0,'2020-11-24 00:00:00'),(45,'liangyuerong','Liangyuerong','Liangyuerong@qq.com','Liangyuerong!',1,1,'2020-11-24 00:00:00'),(46,'987654321','七七','163@163.com','Aa@123456',1,0,'2020-11-24 00:00:00'),(47,'a123456','a123456','123456789@qq.com','La!12345',1,0,'2020-11-25 00:00:00'),(48,'wairuigood123','nameless','12345677@qq.com','!Qw88888888',1,0,'2020-11-25 00:00:00'),(49,'101','梁悦荣','12345@qq.com','123456',1,0,NULL),(50,'21','蔡海锋','12345@qq.com','123456',1,0,'2020-11-26 10:36:01'),(51,'218','蔡海锋','12345@qq.com','123456',1,0,'2020-11-26 10:41:53'),(52,'1234567891','张三','12345678@163.com','Aa@123456',1,0,'2020-11-26 00:00:00'),(53,'1234567893','张三','12345678@163.com','Aa@123456',1,0,'2020-11-26 00:00:00'),(54,'ccc','ccc','ccc@qq.com','Aa@123456',1,1,'2020-11-26 00:00:00');
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

-- Dump completed on 2020-11-26 14:56:30
