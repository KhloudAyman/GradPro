-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: multiagent
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `has_task`
--

DROP TABLE IF EXISTS `has_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `has_task` (
  `ROBOT` int(11) NOT NULL,
  `TASK` int(11) NOT NULL,
  `INFO` varchar(128) DEFAULT 'unidentified',
  KEY `Robot_idx` (`ROBOT`),
  KEY `TASK_idx` (`TASK`),
  CONSTRAINT `ROBOT` FOREIGN KEY (`ROBOT`) REFERENCES `robot` (`robot_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `TASK` FOREIGN KEY (`TASK`) REFERENCES `task` (`T_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `has_task`
--

LOCK TABLES `has_task` WRITE;
/*!40000 ALTER TABLE `has_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `has_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `robot`
--

DROP TABLE IF EXISTS `robot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `robot` (
  `robot_id` int(11) NOT NULL AUTO_INCREMENT,
  `robot_availability` tinyint(4) DEFAULT '1',
  `fk_task_id` int(11) DEFAULT NULL,
  `robot_x` int(11) DEFAULT NULL,
  `robot_y` int(11) DEFAULT NULL,
  `robot_maxLoad` float DEFAULT NULL,
  `robot_nooftasks` int(11) DEFAULT NULL,
  `robot_totaldistance` int(11) DEFAULT NULL,
  `robot_state` int(11) DEFAULT '0',
  `robotIP` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`robot_id`),
  KEY `fk_task_id_idx` (`fk_task_id`),
  CONSTRAINT `fk_task_id` FOREIGN KEY (`fk_task_id`) REFERENCES `task` (`T_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `robot`
--

LOCK TABLES `robot` WRITE;
/*!40000 ALTER TABLE `robot` DISABLE KEYS */;
INSERT INTO `robot` VALUES (3,1,NULL,2,2,3.5,NULL,NULL,0,'10.0.0.1');
/*!40000 ALTER TABLE `robot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `T_ID` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `taskload` float DEFAULT NULL,
  `startX` int(11) DEFAULT NULL,
  `startY` int(11) DEFAULT NULL,
  `endX` int(11) DEFAULT NULL,
  `endY` int(11) DEFAULT NULL,
  `taskname` varchar(45) DEFAULT NULL,
  `taskAvailability` int(11) DEFAULT NULL,
  PRIMARY KEY (`T_ID`),
  KEY `user_idx` (`user`),
  CONSTRAINT `user` FOREIGN KEY (`user`) REFERENCES `user` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,NULL,5.5,2,2,10,10,'Task1',NULL);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(125) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `adminOrUser` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (10,'toqa','toqa@gmail.com','193c7882c2bb867a8e76d89f2001e57e0006212df60eb9b17a53b3c78b3d2019','01111111111','admin'),(12,'afnan','afnan@gmail.com','37b6a882ef80bab9fc7aea6ea855b5f175e09f8e9e9b402c4a210b782063318b','01212121212','admin'),(13,'basma','basma@gmail.com','6c6d84024931d201d6a818219bb3fe7c760919aecf462966c705b4411ef3688b','01210101010','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'multiagent'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-26 16:04:24
