create database 4this_oms_test3;

use 4this_oms_test3;

-- MySQL dump 10.19  Distrib 10.3.31-MariaDB, for debian-linux-gnueabihf (armv7l)
--
-- Host: localhost    Database: 4this_oms_test3
-- ------------------------------------------------------
-- Server version	10.3.31-MariaDB-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `candidate` (
  `candidate_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `candidate_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `candidate_recruit` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `candidate_birth` int(11) DEFAULT NULL,
  `candidate_attend` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `candidate_ticket_photo` mediumblob DEFAULT NULL,
  `candidate_photo` mediumblob DEFAULT NULL,
  `candidate_issue` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '미출석',
  `exam_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `exam_place_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `candidate_examNum` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`candidate_examNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES ('c01','전형','모집단위',20001001,'2021-11-24 15:52:32','',NULL,'출석 완료','e01','ep01','c01-e01'),('c01','전형','모집단위',20001001,'2021-11-24 15:53:37','',NULL,'출석처리중','e04','ep04','c01-e04'),('c02','전형','모집단위',20001002,'2021-12-25 15:00:00','',NULL,'출석처리중','e01','ep01','c02-e01'),('c02','전형','모집단위',20001002,'2021-11-24 15:18:03','',NULL,'출석처리중','e04','ep04','c02-e04'),('c03','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e01','ep01','c03-e01'),('c03','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e04','ep04','c03-e04'),('c04','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e01','ep01','c04-e01'),('c04','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e04','ep04','c04-e04'),('c05','전형','모집단위',20001002,'0000-00-00 00:00:00','',NULL,'미출석','e01','ep01','c05-e01'),('c05','전형','모집단위',20001002,'0000-00-00 00:00:00','',NULL,'미출석','e04','ep04','c05-e04'),('c06','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e01','ep01','c06-e01'),('c06','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e04','ep04','c06-e04'),('c07','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e01','ep01','c07-e01'),('c07','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e04','ep04','c07-e04'),('c08','전형','모집단위',20001002,'0000-00-00 00:00:00','',NULL,'미출석','e01','ep01','c08-e01'),('c08','전형','모집단위',20001002,'0000-00-00 00:00:00','',NULL,'미출석','e04','ep04','c08-e04'),('c09','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e01','ep01','c09-e01'),('c09','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e04','ep04','c09-e04'),('c10','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e01','ep01','c10-e01'),('c10','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e04','ep04','c10-e04'),('c11','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e02','ep02','c11-e02'),('c11','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e03','ep03','c11-e03'),('c12','전형','모집단위',20001002,'0000-00-00 00:00:00','',NULL,'미출석','e02','ep02','c12-e02'),('c12','전형','모집단위',20001002,'0000-00-00 00:00:00','',NULL,'미출석','e03','ep03','c12-e03'),('c13','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e02','ep02','c13-e02'),('c13','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e03','ep03','c13-e03'),('c14','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e02','ep02','c14-e02'),('c14','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e03','ep03','c14-e03'),('c15','전형','모집단위',20001002,'0000-00-00 00:00:00','',NULL,'미출석','e02','ep02','c15-e02'),('c15','전형','모집단위',20001002,'0000-00-00 00:00:00','',NULL,'미출석','e03','ep03','c15-e03'),('c16','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e02','ep02','c16-e02'),('c16','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e03','ep03','c16-e03'),('c17','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e02','ep02','c17-e02'),('c17','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e03','ep03','c17-e03'),('c18','전형','모집단위',20001002,'0000-00-00 00:00:00','',NULL,'미출석','e02','ep02','c18-e02'),('c18','전형','모집단위',20001002,'0000-00-00 00:00:00','',NULL,'미출석','e03','ep03','c18-e03'),('c19','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e02','ep02','c19-e02'),('c19','전형','모집단위',20001003,'0000-00-00 00:00:00','',NULL,'미출석','e03','ep03','c19-e03'),('c20','전형','모집단위',20001001,'2021-11-24 22:53:43','',NULL,'출석 완료','e02','ep02','c20-e02'),('c20','전형','모집단위',20001001,'0000-00-00 00:00:00','',NULL,'미출석','e03','ep03','c20-e03');
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam` (
  `exam_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `exam_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `exam_time` datetime NOT NULL,
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES ('e01','2021년 정보처리산업기사 4회 필기','2021-11-30 19:00:00'),('e02','2021년 정보처리산업기사 4회 실기','2021-12-04 15:00:00'),('e03','제43회 SQL 개발자','2021-11-20 10:00:00'),('e04','제 34회 리눅스 마스터 2급 2차','2021-12-25 15:00:00');
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_place`
--

DROP TABLE IF EXISTS `exam_place`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_place` (
  `exam_place_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `exam_place_location` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`exam_place_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_place`
--

LOCK TABLES `exam_place` WRITE;
/*!40000 ALTER TABLE `exam_place` DISABLE KEYS */;
INSERT INTO `exam_place` VALUES ('ep01','명지전문대학 공학관 815호'),('ep02','명지전문대학 사회교육관 510호'),('ep03','명지전문대학 본관 103호'),('ep04','명지전문대학 예체능관 203호');
/*!40000 ALTER TABLE `exam_place` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `overseer_assign`
--

DROP TABLE IF EXISTS `overseer_assign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `overseer_assign` (
  `overseer_assign_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `overseer_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `exam_place_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `exam_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`overseer_assign_id`),
  KEY `overseer_id` (`overseer_id`),
  KEY `exam_place_id` (`exam_place_id`),
  KEY `overseer_assign_ibfk_3` (`exam_id`),
  CONSTRAINT `overseer_assign_ibfk_1` FOREIGN KEY (`overseer_id`) REFERENCES `overseer` (`overseer_id`),
  CONSTRAINT `overseer_assign_ibfk_2` FOREIGN KEY (`exam_place_id`) REFERENCES `exam_place` (`exam_place_id`),
  CONSTRAINT `overseer_assign_ibfk_3` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `overseer_assign`
--

LOCK TABLES `overseer_assign` WRITE;
/*!40000 ALTER TABLE `overseer_assign` DISABLE KEYS */;
INSERT INTO `overseer_assign` VALUES ('oa01','o01','ep01','e01'),('oa02','o02','ep02','e02'),('oa03','o03','ep03','e03'),('oa04','o04','ep04','e04');
/*!40000 ALTER TABLE `overseer_assign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `user_role` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('c01','학생01','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c02','학생02','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c03','학생03','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c04','학생04','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c05','학생05','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c06','학생06','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c07','학생07','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c08','학생07','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c09','학생09','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c10','학생10','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c11','학생11','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c12','학생12','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c13','학생13','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c14','학생14','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c15','학생15','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c16','학생16','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c17','학생17','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c18','학생18','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c19','학생19','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c20','학생20','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c21','학생21','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c22','학생22','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c23','학생23','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c24','학생24','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c25','학생25','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c26','학생26','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c27','학생27','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c28','학생28','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c29','학생29','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c30','학생30','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c31','학생31','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c32','학생32','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c33','학생33','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c34','학생34','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c35','학생35','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c36','학생36','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c37','학생37','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c38','학생38','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c39','학생39','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('c40','학생40','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','candidate'),('o01','감독01','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','overseer'),('o02','감독02','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','overseer'),('o03','감독03','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','overseer'),('o04','감독04','$2a$10$ouBKIXhyC7mMs0Naz5gE..t3qJSuzK2gJXzhA9yTFJr4iEd1fmUVW','overseer');
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

-- Dump completed on 2021-11-24 15:25:35
