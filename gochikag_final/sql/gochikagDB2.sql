-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: gochikag
-- ------------------------------------------------------
-- Server version   5.7.17-log

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
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `amount` float NOT NULL,
  `delete_flg` tinyint(1) NOT NULL,
  `registration_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `item_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`),
  CONSTRAINT `cart_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `cart_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart2`
--

DROP TABLE IF EXISTS `cart2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cart2` (
  `user_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `amount` float NOT NULL,
  `item_count` int(11) NOT NULL,
  `cart_flg` tinyint(1) NOT NULL DEFAULT '0',
  `credit_flg` tinyint(1) NOT NULL DEFAULT '0',
  `confirm_flg` tinyint(1) NOT NULL DEFAULT '0',
  KEY `item_id` (`item_id`),
  CONSTRAINT `cart2_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart2`
--

LOCK TABLES `cart2` WRITE;
/*!40000 ALTER TABLE `cart2` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit`
--

DROP TABLE IF EXISTS `credit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit` (
  `user_id` int(11) NOT NULL,
  `card_brand` varchar(255) NOT NULL,
  `name_e` varchar(255) NOT NULL,
  `credit_number` varchar(255) NOT NULL,
  `security_code` int(11) NOT NULL,
  `expiration_day` varchar(255) NOT NULL,
  `updated_date` datetime NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `credit_number` (`credit_number`),
  CONSTRAINT `credit_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit`
--

LOCK TABLES `credit` WRITE;
/*!40000 ALTER TABLE `credit` DISABLE KEYS */;
/*!40000 ALTER TABLE `credit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit2`
--

DROP TABLE IF EXISTS `credit2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `credit2` (
  `user_id` int(11) NOT NULL,
  `card_brand` varchar(255) DEFAULT NULL,
  `name_e` varchar(255) DEFAULT NULL,
  `login_id` varchar(255) DEFAULT NULL,
  `first_six_digits` varchar(255) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `use_day` datetime DEFAULT NULL,
  KEY `user_id` (`user_id`),
  CONSTRAINT `credit2_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit2`
--

LOCK TABLES `credit2` WRITE;
/*!40000 ALTER TABLE `credit2` DISABLE KEYS */;
/*!40000 ALTER TABLE `credit2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detail`
--

DROP TABLE IF EXISTS `detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detail` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `detail_ja` varchar(255) DEFAULT NULL,
  `detail_en` varchar(255) DEFAULT NULL,
  `deleteflg` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`item_id`),
  KEY `index_item_id` (`item_id`),
  CONSTRAINT `detail_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detail`
--

LOCK TABLES `detail` WRITE;
/*!40000 ALTER TABLE `detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `main_picture` varchar(255) DEFAULT NULL,
  `stock_number` int(11) NOT NULL,
  `delete_flg` tinyint(1) NOT NULL DEFAULT '0',
  `registration_date` datetime NOT NULL,
  `updated_date` datetime NOT NULL,
  `category` enum('kagu','kaden','sale') NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pictures`
--

DROP TABLE IF EXISTS `pictures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pictures` (
  `item_id` int(11) NOT NULL,
  `sub_picture1` varchar(255) NOT NULL,
  `sub_picture2` varchar(255) NOT NULL,
  `sub_picture3` varchar(255) NOT NULL,
  `delete_flg` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`item_id`),
  CONSTRAINT `pictures_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pictures`
--

LOCK TABLES `pictures` WRITE;
/*!40000 ALTER TABLE `pictures` DISABLE KEYS */;
/*!40000 ALTER TABLE `pictures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `item_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `item_count` int(11) NOT NULL,
  `amount` float NOT NULL,
  `purchase_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_date` datetime NOT NULL,
  KEY `item_id` (`item_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `purchase_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`),
  CONSTRAINT `purchase_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`),
  CONSTRAINT `purchase_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase2`
--

DROP TABLE IF EXISTS `purchase2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase2` (
  `item_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `item_count` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `purchase_day` datetime DEFAULT NULL,
  KEY `user_id` (`user_id`),
  CONSTRAINT `purchase2_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase2`
--

LOCK TABLES `purchase2` WRITE;
/*!40000 ALTER TABLE `purchase2` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `phone_email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `login_flg` tinyint(1) NOT NULL DEFAULT '0',
  `user_flg` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-21 13:30:11