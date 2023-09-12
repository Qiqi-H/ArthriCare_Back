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
-- Table structure for table `community_chats_channels`
--

DROP TABLE IF EXISTS `community_chats_channels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community_chats_channels` (
  `channel_id` bigint NOT NULL AUTO_INCREMENT,
  `user_from_id` varchar(255) NOT NULL COMMENT 'User ID of the message sender',
  `user_to_id` varchar(255) NOT NULL COMMENT 'User ID of the message receiver',
  `last_update_time` bigint NOT NULL,
  `new_content` varchar(255) NOT NULL,
  PRIMARY KEY (`channel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_chats_channels`
--

LOCK TABLES `community_chats_channels` WRITE;
/*!40000 ALTER TABLE `community_chats_channels` DISABLE KEYS */;
INSERT INTO `community_chats_channels` VALUES (2,'1-John Doe','11-Alice Smith',1693348105,'1+1=2');
/*!40000 ALTER TABLE `community_chats_channels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `community_chats_histories`
--

DROP TABLE IF EXISTS `community_chats_histories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community_chats_histories` (
  `content_id` bigint NOT NULL AUTO_INCREMENT,
  `channel_id` bigint NOT NULL,
  `created_timestamp` bigint NOT NULL,
  `content` varchar(510) NOT NULL,
  `sender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`content_id`),
  KEY `channel_id` (`channel_id`),
  CONSTRAINT `community_chats_histories_ibfk_1` FOREIGN KEY (`channel_id`) REFERENCES `community_chats_channels` (`channel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_chats_histories`
--

LOCK TABLES `community_chats_histories` WRITE;
/*!40000 ALTER TABLE `community_chats_histories` DISABLE KEYS */;
INSERT INTO `community_chats_histories` VALUES (3,2,1693153771,'hi','1-John Doe'),(4,2,1693153793,'long time no see','1-John Doe'),(5,2,1693162751,'hi','11-Alice Smith'),(6,2,1693162777,'how are you','11-Alice Smith'),(7,2,1693162794,'i\'m fine think you','11-Alice Smith'),(8,2,1693163206,'good','1-John Doe'),(9,2,1693163327,'how do you feel','1-John Doe'),(10,2,1693163368,'no bad','11-Alice Smith'),(11,2,1693163442,'how about you','11-Alice Smith'),(12,2,1693187345,'i\'m fine','1-John Doe'),(13,2,1693187358,'thank you','1-John Doe'),(14,2,1693348054,'hi','1-John Doe'),(15,2,1693348058,'hello','11-Alice Smith'),(16,2,1693348061,'stupid Don','1-John Doe'),(17,2,1693348069,'：（','11-Alice Smith'),(18,2,1693348070,'hahahha','1-John Doe'),(19,2,1693348091,'23333','1-John Doe'),(20,2,1693348095,'555555555','11-Alice Smith'),(21,2,1693348102,'512','11-Alice Smith'),(22,2,1693348105,'1+1=2','1-John Doe');
/*!40000 ALTER TABLE `community_chats_histories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `community_posts`
--

DROP TABLE IF EXISTS `community_posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community_posts` (
  `post_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Identifier for the post, for better indexing',
  `user_id` bigint NOT NULL COMMENT 'Identifier for the user who posted the discussion',
  `title` varchar(255) NOT NULL COMMENT 'Title of the post',
  `content` varchar(510) NOT NULL COMMENT 'Content of the post',
  `created_timestamp` bigint NOT NULL COMMENT 'Time when the post was created (stored as a timestamp)',
  `forum_section` varchar(50) NOT NULL COMMENT 'Category to group the post, e.g., symptoms, treatment, lifestyle, etc.',
  `have_image` tinyint(1) NOT NULL DEFAULT '0',
  `like_num` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `community_posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_posts`
--

LOCK TABLES `community_posts` WRITE;
/*!40000 ALTER TABLE `community_posts` DISABLE KEYS */;
INSERT INTO `community_posts` VALUES (1,11,'test','test',1691443839,'symptoms',0,0),(2,11,'ss','Sure, here\'s a 510-character English example:\n\n\"In the realm of possibilities, where dreams converge with reality, we find the essence of human potential. It\'s in these moments of exploration that we discover the breadth of our capabilities, reaching for the stars, grasping the intangible. With every step, we write our story, a narrative woven with aspirations, setbacks, and triumphs. This journey, full of twists and turns, shapes us into who we are meant to become. Embrace the challenges, for they mold t',1691445592,'symptoms',0,0),(3,11,'test','\nSure, here\'s a 510-character English example:\n\n\"In the realm of possibilities, where dreams converge with reality, we find the essence of human potential. It\'s in these moments of exploration that we discover the breadth of our capabilities, reaching for the stars, grasping the intangible. With every step, we write our story, a narrative woven with aspirations, setbacks, and triumphs. This journey, full of twists and turns, shapes us into who we are meant to become. Embrace the challenges, for they mold ',1691445719,'symptoms',0,0),(4,11,'test with image','test with image',1691554606,'symptoms',0,0),(5,11,'test with image','test with image',1691554668,'symptoms',0,0),(6,11,'test with image','test with image',1691554828,'symptoms',0,0),(7,11,'test','t',1691554904,'symptoms',0,0),(8,11,'test','final test',1691555062,'symptoms',1,0),(9,11,'test test','test with more image',1691558531,'symptoms',1,0);
/*!40000 ALTER TABLE `community_posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `community_posts_images`
--

DROP TABLE IF EXISTS `community_posts_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community_posts_images` (
  `image_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Unique identifier for each image',
  `post_id` bigint NOT NULL COMMENT 'Identifier for the post this image belongs to',
  `image_path` varchar(255) NOT NULL COMMENT 'File path or name for the image',
  PRIMARY KEY (`image_id`),
  KEY `post_id` (`post_id`),
  CONSTRAINT `community_posts_images_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `community_posts` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_posts_images`
--

LOCK TABLES `community_posts_images` WRITE;
/*!40000 ALTER TABLE `community_posts_images` DISABLE KEYS */;
INSERT INTO `community_posts_images` VALUES (1,8,'uploadImages\\c90d9fb4-d96c-491e-85f9-4184d67e90c9_20230810002422.png'),(2,9,'uploadImages\\5fd8443d-4258-4d0c-a135-c41fb9aaedee_20230810012211.png'),(3,9,'uploadImages\\3110d265-9aae-43c0-8ce1-89a89b99afb9_20230810012211.png'),(4,9,'uploadImages\\0f644ac5-79df-4608-9461-991452dc12cc_20230810012211.png');
/*!40000 ALTER TABLE `community_posts_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `community_posts_replies`
--

DROP TABLE IF EXISTS `community_posts_replies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community_posts_replies` (
  `reply_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Unique identifier for each reply',
  `post_id` bigint NOT NULL COMMENT 'Identifier for the post to which the reply belongs',
  `user_id` bigint NOT NULL COMMENT 'Identifier for the user who posted the reply',
  `content` varchar(510) NOT NULL COMMENT 'Content of the reply',
  `created_timestamp` int NOT NULL COMMENT 'Time when the reply was created (stored as a timestamp)',
  PRIMARY KEY (`reply_id`),
  KEY `post_id` (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `community_posts_replies_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `community_posts` (`post_id`),
  CONSTRAINT `community_posts_replies_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_posts_replies`
--

LOCK TABLES `community_posts_replies` WRITE;
/*!40000 ALTER TABLE `community_posts_replies` DISABLE KEYS */;
INSERT INTO `community_posts_replies` VALUES (1,2,11,'cool',1691457103),(2,2,11,'new cool',1691457952),(3,2,11,'new new cool',1691531004),(4,9,11,'cool',1692288240);
/*!40000 ALTER TABLE `community_posts_replies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `community_posts_replies_images`
--

DROP TABLE IF EXISTS `community_posts_replies_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `community_posts_replies_images` (
  `image_id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Unique identifier for each image reply',
  `reply_id` bigint NOT NULL COMMENT 'Identifier for the reply this image belongs to',
  `image_path` varchar(255) NOT NULL COMMENT 'File path or name for the image',
  PRIMARY KEY (`image_id`),
  KEY `reply_id` (`reply_id`),
  CONSTRAINT `community_posts_replies_images_ibfk_1` FOREIGN KEY (`reply_id`) REFERENCES `community_posts_replies` (`reply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_posts_replies_images`
--

LOCK TABLES `community_posts_replies_images` WRITE;
/*!40000 ALTER TABLE `community_posts_replies_images` DISABLE KEYS */;
/*!40000 ALTER TABLE `community_posts_replies_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medications`
--

DROP TABLE IF EXISTS `medications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medications` (
  `medication_id` int NOT NULL AUTO_INCREMENT,
  `user_id` bigint DEFAULT NULL,
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
  CONSTRAINT `medications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medications`
--

LOCK TABLES `medications` WRITE;
/*!40000 ALTER TABLE `medications` DISABLE KEYS */;
INSERT INTO `medications` VALUES (3,2,'TypeA','Medication3','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(4,2,'TypeB','Medication4','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(5,3,'TypeA','Medication5','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(6,3,'TypeB','Medication6','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(7,4,'TypeA','Medication7','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(8,4,'TypeB','Medication8','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(9,5,'TypeA','Medication9','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(10,5,'TypeB','Medication10','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(11,6,'TypeA','Medication11','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(12,6,'TypeB','Medication12','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(13,7,'TypeA','Medication13','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(14,7,'TypeB','Medication14','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(15,8,'TypeA','Medication15','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(16,8,'TypeB','Medication16','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(17,9,'TypeA','Medication17','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(18,9,'TypeB','Medication18','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(19,10,'TypeA','Medication19','CategoryA','daily',1.00,'2023-01-01','2023-12-31',NULL,0),(20,10,'TypeB','Medication20','CategoryB','twice daily',2.00,'2023-01-01','2023-12-31',NULL,0),(36,1,'medication','Ibuprofen','table','once',1.50,'2023-06-06','2023-06-07','eat before Lunch',0),(37,1,'medication','Penicillin','table','once',0.50,'2023-06-07','2023-06-08',NULL,0),(68,11,NULL,'Ibuprofen','Tablet','Twice a Day',0.50,'2023-07-27','2023-07-31','',1),(69,11,NULL,'Ibuprofen','Tablet','Twice a Day',0.50,'2023-07-25','2023-07-26','',1),(70,11,NULL,'Penicillin','Tablet','Twice a Day',1.00,'2023-07-29','2023-08-02','eat on time',1),(71,11,NULL,'Anakinra','Pill','Twice a Day',1.00,'2023-08-03','2023-08-05','',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminders`
--

LOCK TABLES `reminders` WRITE;
/*!40000 ALTER TABLE `reminders` DISABLE KEYS */;
INSERT INTO `reminders` VALUES (33,68,'08:00:00','2023-07-27',0,NULL,'2023-07-27 08:00:00'),(34,68,'10:00:00','2023-07-27',0,NULL,'2023-07-27 10:00:00'),(35,68,'08:00:00','2023-07-28',0,NULL,'2023-07-28 08:00:00'),(36,68,'10:00:00','2023-07-28',0,NULL,'2023-07-28 10:00:00'),(37,68,'08:00:00','2023-07-29',0,NULL,'2023-07-29 08:00:00'),(38,68,'10:00:00','2023-07-29',0,NULL,'2023-07-29 10:00:00'),(39,68,'08:00:00','2023-07-30',0,NULL,'2023-07-30 08:00:00'),(40,68,'10:00:00','2023-07-30',0,NULL,'2023-07-30 10:00:00'),(41,68,'08:00:00','2023-07-31',1,'2023-07-31 11:57:01','2023-07-31 08:00:00'),(42,68,'10:00:00','2023-07-31',1,'2023-07-31 10:00:00','2023-07-31 10:00:00'),(43,69,'08:00:00','2023-07-25',0,NULL,'2023-07-25 08:00:00'),(44,69,'10:00:00','2023-07-25',0,NULL,'2023-07-25 10:00:00'),(45,69,'08:00:00','2023-07-26',0,NULL,'2023-07-26 08:00:00'),(46,69,'10:00:00','2023-07-26',0,NULL,'2023-07-26 10:00:00'),(121,70,'10:00:00','2023-07-29',0,NULL,'2023-07-29 10:00:00'),(122,70,'18:00:00','2023-07-29',0,NULL,'2023-07-29 18:00:00'),(123,70,'10:00:00','2023-07-30',0,NULL,'2023-07-30 10:00:00'),(124,70,'18:00:00','2023-07-30',0,NULL,'2023-07-30 18:00:00'),(125,70,'10:00:00','2023-07-31',0,NULL,'2023-07-31 10:00:00'),(126,70,'18:00:00','2023-07-31',1,'2023-07-31 18:00:00','2023-07-31 18:00:00'),(127,70,'10:00:00','2023-08-01',1,'2023-08-01 13:06:52','2023-08-01 10:00:00'),(128,70,'18:00:00','2023-08-01',0,NULL,'2023-08-01 18:00:00'),(129,70,'10:00:00','2023-08-02',0,NULL,'2023-08-02 10:00:00'),(130,70,'18:00:00','2023-08-02',0,NULL,'2023-08-02 18:00:00'),(155,71,'09:00:00','2023-08-03',0,NULL,'2023-08-03 09:00:00'),(156,71,'14:00:00','2023-08-03',0,NULL,'2023-08-03 14:00:00'),(157,71,'09:00:00','2023-08-04',0,NULL,'2023-08-04 09:00:00'),(158,71,'14:00:00','2023-08-04',0,NULL,'2023-08-04 14:00:00'),(159,71,'09:00:00','2023-08-05',0,NULL,'2023-08-05 09:00:00'),(160,71,'14:00:00','2023-08-05',0,NULL,'2023-08-05 14:00:00');
/*!40000 ALTER TABLE `reminders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rewards`
--

DROP TABLE IF EXISTS `rewards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rewards` (
  `user_id` bigint DEFAULT NULL,
  `loginRewardClaimed` tinyint(1) DEFAULT '1',
  `loginRewardClaimedDate` date DEFAULT NULL,
  `profileRewardClaimed` tinyint(1) DEFAULT '0',
  KEY `user_id` (`user_id`),
  CONSTRAINT `rewards_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rewards`
--

LOCK TABLES `rewards` WRITE;
/*!40000 ALTER TABLE `rewards` DISABLE KEYS */;
INSERT INTO `rewards` VALUES (9,1,NULL,0),(11,0,'2023-08-03',1),(7,1,NULL,0),(5,1,NULL,0),(4,1,NULL,0),(10,0,'2023-07-26',1),(2,1,NULL,1),(3,1,NULL,0),(8,1,NULL,0),(6,1,NULL,0),(1,1,NULL,0),(15,0,'2023-07-28',0);
/*!40000 ALTER TABLE `rewards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `weight` decimal(5,2) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `point` varchar(100) DEFAULT '0',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'John Doe',25,'Male',75.50,'john.doe@example.com','123456','0'),(2,'Jane Smith',30,'Female',62.30,'jane.smith@example.com','234567','100'),(3,'Michael Johnson',35,'Male',80.10,'michael.johnson@example.com','345678','0'),(4,'Emily Brown',28,'Female',58.70,'emily.brown@example.com','456789','0'),(5,'David Wilson',32,'Male',68.90,'david.wilson@example.com','567890','0'),(6,'Sophia Taylor',27,'Female',55.20,'sophia.taylor@example.com','678901','0'),(7,'Daniel Anderson',31,'Male',73.80,'daniel.anderson@example.com','789012','0'),(8,'Olivia Martinez',29,'Female',61.10,'olivia.martinez@example.com','890123','0'),(9,'Alexander Thomas',34,'Male',77.60,'alexander.thomas@example.com','901234','0'),(10,'Emma Garcia',26,'Female',59.40,'emma.garcia@example.com','012345','135'),(11,'Alice Smith',30,'Female',62.25,'alice@example.com','77k66','3655'),(15,'',0,'Male',NULL,'88644@gmail.com','123','35');
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

-- Dump completed on 2023-09-11 16:17:08
