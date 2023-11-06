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
INSERT INTO `community_chats_channels` VALUES (2,'1-John Doe','11-Alice Smith',1695250524,'same');
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_chats_histories`
--

LOCK TABLES `community_chats_histories` WRITE;
/*!40000 ALTER TABLE `community_chats_histories` DISABLE KEYS */;
INSERT INTO `community_chats_histories` VALUES (3,2,1693153771,'hi','1-John Doe'),(4,2,1693153793,'long time no see','1-John Doe'),(5,2,1693162751,'hi','11-Alice Smith'),(6,2,1693162777,'how are you','11-Alice Smith'),(7,2,1693162794,'i\'m fine think you','11-Alice Smith'),(8,2,1693163206,'good','1-John Doe'),(9,2,1693163327,'how do you feel','1-John Doe'),(10,2,1693163368,'no bad','11-Alice Smith'),(11,2,1693163442,'how about you','11-Alice Smith'),(12,2,1693187345,'i\'m fine','1-John Doe'),(13,2,1693187358,'thank you','1-John Doe'),(14,2,1693348054,'hi','1-John Doe'),(15,2,1693348058,'hello','11-Alice Smith'),(16,2,1693348061,'stupid Don','1-John Doe'),(17,2,1693348069,'：（','11-Alice Smith'),(18,2,1693348070,'hahahha','1-John Doe'),(19,2,1693348091,'23333','1-John Doe'),(20,2,1693348095,'555555555','11-Alice Smith'),(21,2,1693348102,'512','11-Alice Smith'),(22,2,1693348105,'1+1=2','1-John Doe'),(23,2,1695246899,'hi','11-Alice Smith'),(24,2,1695249401,'i can talk to you','11-Alice Smith'),(25,2,1695250349,'me too','1-John Doe'),(26,2,1695250431,'happy','11-Alice Smith'),(27,2,1695250524,'same','1-John Doe');
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
  `comment_num` bigint NOT NULL DEFAULT '0',
  PRIMARY KEY (`post_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `community_posts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_posts`
--

LOCK TABLES `community_posts` WRITE;
/*!40000 ALTER TABLE `community_posts` DISABLE KEYS */;
INSERT INTO `community_posts` VALUES (17,11,'21M diagnosed with Rheumatoid Arthritis','I\'m a 21M who was recently diagnosed with Rheumatoid Arthritis by a GP. It was first assumed I had some form of vasculitis, but I failed to ask what exactly my blood test results had shown that had her determine RA. It\'s a long wait for a specialist, if I can get one, and I can\'t find much on this disease in people my age. It is also to my understanding that blood test don\'t always point to a definitive diagnosis. I\'ve had problem beginning as early as 12 and they never went away. I finally igno',1698246020,'symptoms',1,0,0),(18,1,'“Morning” stiffness worse in the middle of the night?','While I am stiff for an hour or two in the morning, the stiffness seems much worse in the middle of the night or if I get up really early. Last night I almost bit it when I got up to go to the washroom because my brain headed in the direction of the bathroom but my hips and knees were locked and didn\'t want to move. Sometimes I walk like a penguin in the middle of the night (but not the cute ones!) due to feet and ankle stiffness but in the morning it isn\'t quite so bad. Anyone else find this?',1698246284,'symptoms',1,0,0),(19,2,'When to resume mtx','I started mtx just over three weeks ago, took the first two weekly doses then got sick with Norovirus. Next dose was due on Saturday but pharmacist recommended not taking it until I\'m \'feeling completely better.\' Although the diarrhoea stopped by Thursday I still feel a bit washed out, shall I just take the next dose now I\'m clear of the virus?',1698797390,'symptoms',0,0,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_posts_images`
--

LOCK TABLES `community_posts_images` WRITE;
/*!40000 ALTER TABLE `community_posts_images` DISABLE KEYS */;
INSERT INTO `community_posts_images` VALUES (7,17,'uploadImages\\5b83ed6c-7069-4091-8c04-8a416bd153b4_20231026130019.png'),(8,17,'uploadImages\\61e8511f-2442-4496-b7e4-66bca26653c5_20231026130019.png'),(9,17,'uploadImages\\8c505f0e-b4c2-42bd-8aa5-d7fbe0298650_20231026130019.png'),(10,18,'uploadImages\\2da2f1cf-aefa-46ac-9895-5f0abef1ff8f_20231026130444.png'),(11,18,'uploadImages\\a2350b36-a298-42af-baa7-b1332fdc5c19_20231026130444.png'),(12,18,'uploadImages\\4618bdea-cc3c-4d38-8dac-dac37932a111_20231026130444.png'),(13,18,'uploadImages\\9bf8aadf-3289-480b-ab3a-627babec82c6_20231026130444.png');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `community_posts_replies`
--

LOCK TABLES `community_posts_replies` WRITE;
/*!40000 ALTER TABLE `community_posts_replies` DISABLE KEYS */;
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
  `medication_name` varchar(255) DEFAULT NULL,
  `medication_category` varchar(255) DEFAULT NULL,
  `frequency` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `medicationExpiration` tinyint(1) DEFAULT '0',
  `dosage_unit` bigint NOT NULL DEFAULT '1',
  `duration` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `reminder_times` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `reminder_Date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`medication_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `medications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medications`
--

LOCK TABLES `medications` WRITE;
/*!40000 ALTER TABLE `medications` DISABLE KEYS */;
INSERT INTO `medications` VALUES (3,2,'Medication3','CategoryA','daily','2023-01-01','2023-12-31',NULL,1,1,NULL,NULL,NULL),(4,2,'Medication4','CategoryB','twice daily','2023-01-01','2023-12-31',NULL,1,1,NULL,NULL,NULL),(5,3,'Medication5','CategoryA','daily','2023-01-01','2023-12-31',NULL,0,1,NULL,NULL,NULL),(6,3,'Medication6','CategoryB','twice daily','2023-01-01','2023-12-31',NULL,0,1,NULL,NULL,NULL),(7,4,'Medication7','CategoryA','daily','2023-01-01','2023-12-31',NULL,0,1,NULL,NULL,NULL),(8,4,'Medication8','CategoryB','twice daily','2023-01-01','2023-12-31',NULL,0,1,NULL,NULL,NULL),(9,5,'Medication9','CategoryA','daily','2023-01-01','2023-12-31',NULL,0,1,NULL,NULL,NULL),(10,5,'Medication10','CategoryB','twice daily','2023-01-01','2023-12-31',NULL,0,1,NULL,NULL,NULL),(11,6,'Medication11','CategoryA','daily','2023-01-01','2023-12-31',NULL,0,1,NULL,NULL,NULL),(12,6,'Medication12','CategoryB','twice daily','2023-01-01','2023-12-31',NULL,0,1,NULL,NULL,NULL),(13,7,'Medication13','CategoryA','daily','2023-01-01','2023-12-31',NULL,0,1,NULL,NULL,NULL),(14,7,'Medication14','CategoryB','twice daily','2023-01-01','2023-12-31',NULL,0,1,NULL,NULL,NULL),(15,8,'Medication15','CategoryA','daily','2023-01-01','2023-12-31',NULL,0,1,NULL,NULL,NULL),(16,8,'Medication16','CategoryB','twice daily','2023-01-01','2023-12-31',NULL,0,1,'Every 1 week(s) eat once, eat 6 times ','[\"10:00\",\"14:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(17,9,'Medication17','CategoryA','daily','2023-01-01','2023-12-31',NULL,0,1,'Every 1 week(s) eat once, eat 6 times ','[\"10:00\",\"14:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(18,9,'Medication18','CategoryB','twice daily','2023-01-01','2023-12-31',NULL,0,1,'Every 1 week(s) eat once, eat 6 times ','[\"10:00\",\"14:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(19,10,'Medication19','CategoryA','daily','2023-01-01','2023-12-31',NULL,0,1,'Every 1 week(s) eat once, eat 6 times ','[\"10:00\",\"14:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(20,10,'Medication20','CategoryB','twice daily','2023-01-01','2023-12-31',NULL,0,1,'Every 1 week(s) eat once, eat 6 times ','[\"10:00\",\"14:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(36,1,'Ibuprofen','table','once','2023-06-06','2023-06-07','eat before Lunch',1,1,'Every 1 week(s) eat once, eat 6 times ','[\"10:00\",\"14:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(37,1,'Penicillin','table','once','2023-06-07','2023-06-08',NULL,1,1,'Every 1 week(s) eat once, eat 6 times ','[\"10:00\",\"14:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(68,11,'Ibuprofen','Tablet','Twice a Day','2023-07-27','2023-07-31','',1,1,'Every 1 week(s) eat once, eat 6 times ','[\"10:00\",\"14:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(70,11,'Penicillin','Tablet','Twice a Day','2023-07-29','2023-08-02','eat on time',1,1,'Every 1 week(s) eat once, eat 6 times ','[\"10:00\",\"14:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(74,11,'Penicillin','Pill','twice','2023-09-21','2023-09-24','eat on time',1,1,'Every 1 week(s) eat once, eat 6 times ','[\"10:00\",\"14:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(84,11,'Abatacept','Pill','Intermittent medication','2023-10-20','2023-11-24','eat on time',0,1,'Every 1 week(s) eat once, eat 6 times ','[\"10:00\",\"14:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(85,11,'Allopurinol','Tablet','Daily medication','2023-10-20','2023-10-27','eat before lunch',1,1,'20/10/2023 - 27/10/2023, 1 week(s)','[\"15:00\",\"20:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(86,11,'Prednisolone','Drop','Daily medication','2023-10-22','2023-10-29',NULL,1,1,'22/10/2023 - 29/10/2023, 1 week(s)','[\"08:00\",\"12:00\",\"16:00\"]','[\"2023-10-20\",\"2023-10-27\",\"2023-11-03\",\"2023-11-10\",\"2023-11-17\",\"2023-11-24\"]'),(93,11,'Colchicine','Drop','Daily medication','2023-10-25','2023-11-01','',1,1,'25/10/2023 - 1/11/2023, 1 week(s)','[\"08:00\",\"10:00\",\"12:00\"]','[\"2023-10-25\",\"2023-11-01\"]');
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
) ENGINE=InnoDB AUTO_INCREMENT=650 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reminders`
--

LOCK TABLES `reminders` WRITE;
/*!40000 ALTER TABLE `reminders` DISABLE KEYS */;
INSERT INTO `reminders` VALUES (33,68,'08:00:00','2023-07-27',0,NULL,'2023-07-27 08:00:00'),(34,68,'10:00:00','2023-07-27',0,NULL,'2023-07-27 10:00:00'),(35,68,'08:00:00','2023-07-28',0,NULL,'2023-07-28 08:00:00'),(36,68,'10:00:00','2023-07-28',0,NULL,'2023-07-28 10:00:00'),(37,68,'08:00:00','2023-07-29',0,NULL,'2023-07-29 08:00:00'),(38,68,'10:00:00','2023-07-29',0,NULL,'2023-07-29 10:00:00'),(39,68,'08:00:00','2023-07-30',0,NULL,'2023-07-30 08:00:00'),(40,68,'10:00:00','2023-07-30',0,NULL,'2023-07-30 10:00:00'),(41,68,'08:00:00','2023-07-31',1,'2023-07-31 11:57:01','2023-07-31 08:00:00'),(42,68,'10:00:00','2023-07-31',1,'2023-07-31 10:00:00','2023-07-31 10:00:00'),(121,70,'10:00:00','2023-07-29',0,NULL,'2023-07-29 10:00:00'),(122,70,'18:00:00','2023-07-29',0,NULL,'2023-07-29 18:00:00'),(123,70,'10:00:00','2023-07-30',0,NULL,'2023-07-30 10:00:00'),(124,70,'18:00:00','2023-07-30',0,NULL,'2023-07-30 18:00:00'),(125,70,'10:00:00','2023-07-31',0,NULL,'2023-07-31 10:00:00'),(126,70,'18:00:00','2023-07-31',1,'2023-07-31 18:00:00','2023-07-31 18:00:00'),(127,70,'10:00:00','2023-08-01',1,'2023-08-01 13:06:52','2023-08-01 10:00:00'),(128,70,'18:00:00','2023-08-01',0,NULL,'2023-08-01 18:00:00'),(129,70,'10:00:00','2023-08-02',0,NULL,'2023-08-02 10:00:00'),(130,70,'18:00:00','2023-08-02',0,NULL,'2023-08-02 18:00:00'),(173,74,'09:00:00','2023-09-21',0,NULL,'2023-09-21 09:00:00'),(174,74,'15:00:00','2023-09-21',0,NULL,'2023-09-21 15:00:00'),(175,74,'09:00:00','2023-09-22',0,NULL,'2023-09-22 09:00:00'),(176,74,'15:00:00','2023-09-22',0,NULL,'2023-09-22 15:00:00'),(177,74,'09:00:00','2023-09-23',0,NULL,'2023-09-23 09:00:00'),(178,74,'15:00:00','2023-09-23',0,NULL,'2023-09-23 15:00:00'),(179,74,'09:00:00','2023-09-24',1,'2023-10-15 21:42:58','2023-09-24 09:00:00'),(180,74,'15:00:00','2023-09-24',1,'2023-09-24 15:00:00','2023-09-24 15:00:00'),(193,85,'15:00:00','2023-10-20',0,NULL,'2023-10-20 15:00:00'),(194,85,'20:00:00','2023-10-20',0,NULL,'2023-10-20 20:00:00'),(195,85,'15:00:00','2023-10-21',1,'2023-10-21 15:00:00','2023-10-21 15:00:00'),(196,85,'20:00:00','2023-10-21',1,'2023-10-21 20:00:00','2023-10-21 20:00:00'),(197,85,'15:00:00','2023-10-22',1,'2023-10-22 15:00:00','2023-10-22 15:00:00'),(198,85,'20:00:00','2023-10-22',1,'2023-10-22 01:23:38','2023-10-22 20:00:00'),(199,85,'15:00:00','2023-10-23',0,NULL,'2023-10-23 15:00:00'),(200,85,'20:00:00','2023-10-23',0,NULL,'2023-10-23 20:00:00'),(201,85,'15:00:00','2023-10-24',1,'2023-10-24 20:51:57','2023-10-24 15:00:00'),(202,85,'20:00:00','2023-10-24',0,NULL,'2023-10-24 20:00:00'),(203,85,'15:00:00','2023-10-25',0,NULL,'2023-10-25 15:00:00'),(204,85,'20:00:00','2023-10-25',0,NULL,'2023-10-25 20:00:00'),(205,85,'15:00:00','2023-10-26',0,NULL,'2023-10-26 15:00:00'),(206,85,'20:00:00','2023-10-26',0,NULL,'2023-10-26 20:00:00'),(207,85,'15:00:00','2023-10-27',0,NULL,'2023-10-27 15:00:00'),(208,85,'20:00:00','2023-10-27',0,NULL,'2023-10-27 20:00:00'),(209,86,'08:00:00','2023-10-22',0,NULL,'2023-10-22 08:00:00'),(210,86,'12:00:00','2023-10-22',0,NULL,'2023-10-22 12:00:00'),(211,86,'16:00:00','2023-10-22',0,NULL,'2023-10-22 16:00:00'),(212,86,'08:00:00','2023-10-23',0,NULL,'2023-10-23 08:00:00'),(213,86,'12:00:00','2023-10-23',0,NULL,'2023-10-23 12:00:00'),(214,86,'16:00:00','2023-10-23',0,NULL,'2023-10-23 16:00:00'),(215,86,'08:00:00','2023-10-24',0,NULL,'2023-10-24 08:00:00'),(216,86,'12:00:00','2023-10-24',0,NULL,'2023-10-24 12:00:00'),(217,86,'16:00:00','2023-10-24',0,NULL,'2023-10-24 16:00:00'),(218,86,'08:00:00','2023-10-25',0,NULL,'2023-10-25 08:00:00'),(219,86,'12:00:00','2023-10-25',0,NULL,'2023-10-25 12:00:00'),(220,86,'16:00:00','2023-10-25',0,NULL,'2023-10-25 16:00:00'),(221,86,'08:00:00','2023-10-26',0,NULL,'2023-10-26 08:00:00'),(222,86,'12:00:00','2023-10-26',0,NULL,'2023-10-26 12:00:00'),(223,86,'16:00:00','2023-10-26',0,NULL,'2023-10-26 16:00:00'),(224,86,'08:00:00','2023-10-27',0,NULL,'2023-10-27 08:00:00'),(225,86,'12:00:00','2023-10-27',0,NULL,'2023-10-27 12:00:00'),(226,86,'16:00:00','2023-10-27',0,NULL,'2023-10-27 16:00:00'),(227,86,'08:00:00','2023-10-28',0,NULL,'2023-10-28 08:00:00'),(228,86,'12:00:00','2023-10-28',0,NULL,'2023-10-28 12:00:00'),(229,86,'16:00:00','2023-10-28',0,NULL,'2023-10-28 16:00:00'),(230,86,'08:00:00','2023-10-29',0,NULL,'2023-10-29 08:00:00'),(231,86,'12:00:00','2023-10-29',0,NULL,'2023-10-29 12:00:00'),(232,86,'16:00:00','2023-10-29',0,NULL,'2023-10-29 16:00:00'),(336,84,'10:00:00','2023-10-20',0,NULL,'2023-10-20 10:00:00'),(337,84,'14:00:00','2023-10-20',0,NULL,'2023-10-20 14:00:00'),(338,84,'20:00:00','2023-10-20',0,NULL,'2023-10-20 20:00:00'),(339,84,'10:00:00','2023-10-27',0,NULL,'2023-10-27 10:00:00'),(340,84,'14:00:00','2023-10-27',0,NULL,'2023-10-27 14:00:00'),(341,84,'20:00:00','2023-10-27',0,NULL,'2023-10-27 20:00:00'),(342,84,'10:00:00','2023-11-03',1,'2023-11-03 10:00:00','2023-11-03 10:00:00'),(343,84,'14:00:00','2023-11-03',0,NULL,'2023-11-03 14:00:00'),(344,84,'20:00:00','2023-11-03',0,NULL,'2023-11-03 20:00:00'),(345,84,'10:00:00','2023-11-10',0,NULL,'2023-11-10 10:00:00'),(346,84,'14:00:00','2023-11-10',0,NULL,'2023-11-10 14:00:00'),(347,84,'20:00:00','2023-11-10',0,NULL,'2023-11-10 20:00:00'),(348,84,'10:00:00','2023-11-17',0,NULL,'2023-11-17 10:00:00'),(349,84,'14:00:00','2023-11-17',0,NULL,'2023-11-17 14:00:00'),(350,84,'20:00:00','2023-11-17',0,NULL,'2023-11-17 20:00:00'),(351,84,'10:00:00','2023-11-24',0,NULL,'2023-11-24 10:00:00'),(352,84,'14:00:00','2023-11-24',0,NULL,'2023-11-24 14:00:00'),(353,84,'20:00:00','2023-11-24',0,NULL,'2023-11-24 20:00:00'),(626,93,'08:00:00','2023-10-25',0,NULL,'2023-10-25 08:00:00'),(627,93,'10:00:00','2023-10-25',0,NULL,'2023-10-25 10:00:00'),(628,93,'12:00:00','2023-10-25',0,NULL,'2023-10-25 12:00:00'),(629,93,'08:00:00','2023-10-26',0,NULL,'2023-10-26 08:00:00'),(630,93,'10:00:00','2023-10-26',0,NULL,'2023-10-26 10:00:00'),(631,93,'12:00:00','2023-10-26',0,NULL,'2023-10-26 12:00:00'),(632,93,'08:00:00','2023-10-27',0,NULL,'2023-10-27 08:00:00'),(633,93,'10:00:00','2023-10-27',0,NULL,'2023-10-27 10:00:00'),(634,93,'12:00:00','2023-10-27',0,NULL,'2023-10-27 12:00:00'),(635,93,'08:00:00','2023-10-28',0,NULL,'2023-10-28 08:00:00'),(636,93,'10:00:00','2023-10-28',0,NULL,'2023-10-28 10:00:00'),(637,93,'12:00:00','2023-10-28',0,NULL,'2023-10-28 12:00:00'),(638,93,'08:00:00','2023-10-29',0,NULL,'2023-10-29 08:00:00'),(639,93,'10:00:00','2023-10-29',0,NULL,'2023-10-29 10:00:00'),(640,93,'12:00:00','2023-10-29',0,NULL,'2023-10-29 12:00:00'),(641,93,'08:00:00','2023-10-30',1,'2023-10-30 08:00:00','2023-10-30 08:00:00'),(642,93,'10:00:00','2023-10-30',0,NULL,'2023-10-30 10:00:00'),(643,93,'12:00:00','2023-10-30',0,NULL,'2023-10-30 12:00:00'),(644,93,'08:00:00','2023-10-31',1,'2023-10-31 08:00:00','2023-10-31 08:00:00'),(645,93,'10:00:00','2023-10-31',1,'2023-10-31 10:00:00','2023-10-31 10:00:00'),(646,93,'12:00:00','2023-10-31',1,'2023-10-31 13:00:00','2023-10-31 12:00:00'),(647,93,'08:00:00','2023-11-01',1,'2023-11-01 08:00:00','2023-11-01 08:00:00'),(648,93,'10:00:00','2023-11-01',1,'2023-11-01 10:00:00','2023-11-01 10:00:00'),(649,93,'12:00:00','2023-11-01',1,'2023-11-01 12:00:00','2023-11-01 12:00:00');
/*!40000 ALTER TABLE `reminders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reward_puzzles`
--

DROP TABLE IF EXISTS `reward_puzzles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reward_puzzles` (
  `puzzle_id` int NOT NULL AUTO_INCREMENT,
  `puzzle_name` varchar(255) NOT NULL,
  `section_id` int NOT NULL,
  `path` varchar(1024) NOT NULL,
  PRIMARY KEY (`puzzle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reward_puzzles`
--

LOCK TABLES `reward_puzzles` WRITE;
/*!40000 ALTER TABLE `reward_puzzles` DISABLE KEYS */;
/*!40000 ALTER TABLE `reward_puzzles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rewards`
--

DROP TABLE IF EXISTS `rewards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rewards` (
  `user_id` bigint NOT NULL,
  `loginRewardClaimed` tinyint(1) DEFAULT '1',
  `loginRewardClaimedDate` date DEFAULT NULL,
  `profileRewardClaimed` tinyint(1) DEFAULT '0',
  `puzzle_num` bigint NOT NULL DEFAULT '0',
  `puzzle_array` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `rewards_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rewards`
--

LOCK TABLES `rewards` WRITE;
/*!40000 ALTER TABLE `rewards` DISABLE KEYS */;
INSERT INTO `rewards` VALUES (1,0,'2023-11-01',0,1,''),(2,0,'2023-11-01',1,1,''),(3,1,NULL,0,0,''),(4,1,NULL,0,0,''),(5,1,NULL,0,0,''),(6,1,NULL,0,0,''),(7,1,NULL,0,0,''),(8,1,NULL,0,0,''),(9,1,NULL,0,0,''),(10,0,'2023-07-26',1,0,''),(11,0,'2023-11-03',1,27,'');
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
  `gender` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `weight` decimal(5,2) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `point` varchar(100) DEFAULT '0',
  `height` bigint NOT NULL DEFAULT '170',
  `weight_unit` varchar(100) NOT NULL DEFAULT 'kg',
  `height_unit` varchar(100) NOT NULL DEFAULT 'cm',
  `avatar_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'avatar3fcdaf19-402d-4b30-a8c6-2e74bb645aa2_20231101215633.png',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'John Doe',25,'Male',75.50,'john.doe@example.com','123456','35',170,'kg','cm','avatar\\6e14286d-f0bd-4d42-b131-3966593f38db_20231101160814.png'),(2,'Jane Smith',30,'Female',62.30,'jane.smith@example.com','234567','135',170,'kg','cm','avatar\\ade9f8b1-1b2f-44df-9bae-a5dbfdf09162_20231101220418.png'),(3,'Michael Johnson',35,'Male',80.10,'michael.johnson@example.com','345678','0',170,'kg','cm','avatar\\3fcdaf19-402d-4b30-a8c6-2e74bb645aa2_20231101215633.png'),(4,'Emily Brown',28,'Female',58.70,'emily.brown@example.com','456789','0',170,'kg','cm','avatar\\3fcdaf19-402d-4b30-a8c6-2e74bb645aa2_20231101215633.png'),(5,'David Wilson',32,'Male',68.90,'david.wilson@example.com','567890','0',170,'kg','cm','avatar\\3fcdaf19-402d-4b30-a8c6-2e74bb645aa2_20231101215633.png'),(6,'Sophia Taylor',27,'Female',55.20,'sophia.taylor@example.com','678901','0',170,'kg','cm','avatar\\3fcdaf19-402d-4b30-a8c6-2e74bb645aa2_20231101215633.png'),(7,'Daniel Anderson',31,'Male',73.80,'daniel.anderson@example.com','789012','0',170,'kg','cm','avatar\\3fcdaf19-402d-4b30-a8c6-2e74bb645aa2_20231101215633.png'),(8,'Olivia Martinez',29,'Female',61.10,'olivia.martinez@example.com','890123','0',170,'kg','cm','avatar\\3fcdaf19-402d-4b30-a8c6-2e74bb645aa2_20231101215633.png'),(9,'Alexander Thomas',34,'Male',77.60,'alexander.thomas@example.com','901234','0',170,'kg','cm','avatar\\3fcdaf19-402d-4b30-a8c6-2e74bb645aa2_20231101215633.png'),(10,'Emma Garcia',26,'Female',59.40,'emma.garcia@example.com','012345','135',170,'kg','cm','avatar\\3fcdaf19-402d-4b30-a8c6-2e74bb645aa2_20231101215633.png'),(11,'Alice Smith',30,'Female',62.25,'alice@example.com','77k66','7050',170,'kg','cm','avatar\\de00d374-805d-46ba-b78a-7e670e2b060f_20231031210242.png');
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

-- Dump completed on 2023-11-06 13:17:06
