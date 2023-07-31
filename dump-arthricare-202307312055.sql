-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: arthricare
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `medications`
--

DROP TABLE IF EXISTS `medications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medications` (
  `medication_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `medication_type` varchar(255) DEFAULT NULL,
  `medication_name` varchar(255) DEFAULT NULL,
  `medication_category` varchar(255) DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL,
  `dosage_unit` decimal(5,2) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `medicationExpiration` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`medication_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `medications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medications`
--

LOCK TABLES `medications` WRITE;
/*!40000 ALTER TABLE `medications` DISABLE KEYS */;
INSERT INTO `medications` VALUES (3,2,'TypeA','Medication3','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(4,2,'TypeB','Medication4','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(5,3,'TypeA','Medication5','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(6,3,'TypeB','Medication6','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(7,4,'TypeA','Medication7','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(8,4,'TypeB','Medication8','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(9,5,'TypeA','Medication9','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(10,5,'TypeB','Medication10','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(11,6,'TypeA','Medication11','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(12,6,'TypeB','Medication12','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(13,7,'TypeA','Medication13','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(14,7,'TypeB','Medication14','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(15,8,'TypeA','Medication15','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(16,8,'TypeB','Medication16','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(17,9,'TypeA','Medication17','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(18,9,'TypeB','Medication18','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(19,10,'TypeA','Medication19','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(20,10,'TypeB','Medication20','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(36,1,'medication','Ibuprofen','table','once',1.50,'2023-06-06','2023-06-07','eat before Lunch',0),(37,1,'medication','Penicillin','table','once',0.50,'2023-06-07','2023-06-08',NULL,0),(68,11,NULL,'Ibuprofen','table','twice',0.50,'2023-07-27','2023-07-31','',1),(69,11,NULL,'Ibuprofen','table','twice',0.50,'2023-07-25','2023-07-26','',1),(70,11,NULL,'Penicillin','table','twice',1.00,'2023-07-29','2023-08-02','eat on time',0);
/*!40000 ALTER TABLE `medications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reminders`
--

DROP TABLE IF EXISTS `reminders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reminders` (
  `reminder_id` int NOT NULL AUTO_INCREMENT,
  `medication_id` int NOT NULL,
  `reminder_time` time NOT NULL,
  `date` date DEFAULT NULL,
  `alreadyTakeMedication` tinyint(1) DEFAULT '0',
  `takeMed_time` datetime DEFAULT NULL,
  `reminder_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`reminder_id`),
  KEY `medication_id` (`medication_id`),
  CONSTRAINT `reminders_ibfk_1` FOREIGN KEY (`medication_id`) REFERENCES `medications` (`medication_id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminders`
--

LOCK TABLES `reminders` WRITE;
/*!40000 ALTER TABLE `reminders` DISABLE KEYS */;
INSERT INTO `reminders` VALUES (33,68,'08:00:00','2023-07-27',0,NULL,'2023-07-27 08:00:00'),(34,68,'10:00:00','2023-07-27',0,NULL,'2023-07-27 10:00:00'),(35,68,'08:00:00','2023-07-28',0,NULL,'2023-07-28 08:00:00'),(36,68,'10:00:00','2023-07-28',0,NULL,'2023-07-28 10:00:00'),(37,68,'08:00:00','2023-07-29',0,NULL,'2023-07-29 08:00:00'),(38,68,'10:00:00','2023-07-29',0,NULL,'2023-07-29 10:00:00'),(39,68,'08:00:00','2023-07-30',0,NULL,'2023-07-30 08:00:00'),(40,68,'10:00:00','2023-07-30',0,NULL,'2023-07-30 10:00:00'),(41,68,'08:00:00','2023-07-31',1,'2023-07-31 11:57:01','2023-07-31 08:00:00'),(42,68,'10:00:00','2023-07-31',1,'2023-07-31 10:00:00','2023-07-31 10:00:00'),(43,69,'08:00:00','2023-07-25',0,NULL,'2023-07-25 08:00:00'),(44,69,'10:00:00','2023-07-25',0,NULL,'2023-07-25 10:00:00'),(45,69,'08:00:00','2023-07-26',0,NULL,'2023-07-26 08:00:00'),(46,69,'10:00:00','2023-07-26',0,NULL,'2023-07-26 10:00:00'),(111,70,'10:00:00','2023-07-29',0,NULL,'2023-07-29 10:00:00'),(112,70,'17:00:00','2023-07-29',0,NULL,'2023-07-29 17:00:00'),(113,70,'10:00:00','2023-07-30',0,NULL,'2023-07-30 10:00:00'),(114,70,'17:00:00','2023-07-30',0,NULL,'2023-07-30 17:00:00'),(115,70,'10:00:00','2023-07-31',0,NULL,'2023-07-31 10:00:00'),(116,70,'17:00:00','2023-07-31',0,NULL,'2023-07-31 17:00:00'),(117,70,'10:00:00','2023-08-01',0,NULL,'2023-08-01 10:00:00'),(118,70,'17:00:00','2023-08-01',0,NULL,'2023-08-01 17:00:00'),(119,70,'10:00:00','2023-08-02',0,NULL,'2023-08-02 10:00:00'),(120,70,'17:00:00','2023-08-02',0,NULL,'2023-08-02 17:00:00');
/*!40000 ALTER TABLE `reminders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rewards`
--

DROP TABLE IF EXISTS `rewards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rewards` (
  `user_id` int DEFAULT NULL,
  `loginRewardClaimed` tinyint(1) DEFAULT '1',
  `loginRewardClaimedDate` date DEFAULT NULL,
  `profileRewardClaimed` tinyint(1) DEFAULT '0',
  KEY `user_id` (`user_id`),
  CONSTRAINT `rewards_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rewards`
--

LOCK TABLES `rewards` WRITE;
/*!40000 ALTER TABLE `rewards` DISABLE KEYS */;
INSERT INTO `rewards` VALUES (9,1,NULL,0),(11,0,'2023-07-28',1),(7,1,NULL,0),(5,1,NULL,0),(4,1,NULL,0),(10,0,'2023-07-26',1),(2,1,NULL,1),(3,1,NULL,0),(8,1,NULL,0),(6,1,NULL,0),(1,1,NULL,0),(15,0,'2023-07-28',0);
/*!40000 ALTER TABLE `rewards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `weight` decimal(5,2) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `point` varchar(100) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'John Doe',25,'Male',75.50,'john.doe@example.com','123456','0'),(2,'Jane Smith',30,'Female',62.30,'jane.smith@example.com','234567','100'),(3,'Michael Johnson',35,'Male',80.10,'michael.johnson@example.com','345678','0'),(4,'Emily Brown',28,'Female',58.70,'emily.brown@example.com','456789','0'),(5,'David Wilson',32,'Male',68.90,'david.wilson@example.com','567890','0'),(6,'Sophia Taylor',27,'Female',55.20,'sophia.taylor@example.com','678901','0'),(7,'Daniel Anderson',31,'Male',73.80,'daniel.anderson@example.com','789012','0'),(8,'Olivia Martinez',29,'Female',61.10,'olivia.martinez@example.com','890123','0'),(9,'Alexander Thomas',34,'Male',77.60,'alexander.thomas@example.com','901234','0'),(10,'Emma Garcia',26,'Female',59.40,'emma.garcia@example.com','012345','135'),(11,'Alice Smith',28,'Female',62.25,'alice@example.com','77k66','3470'),(15,'',0,'Male',NULL,'88644@gmail.com','123','35');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'arthricare'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-31 20:55:36
