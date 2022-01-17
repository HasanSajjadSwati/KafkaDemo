-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: symplified-merchant
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `id` varchar(256) NOT NULL,
  `heading` varchar(256) DEFAULT NULL,
  `description` text,
  `content` text,
  `parent_id` varchar(255) DEFAULT NULL,
  `topic_level` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES ('119e800e-6a4c-47ab-a594-0ffdeb75be1d','Demo',NULL,'Demo Orders Content',NULL,'0'),('3acb7655-a88c-48e0-9be1-feee3a02ba1a','Products',NULL,'Demo Content',NULL,'0'),('5be471cb-a392-46b3-8345-391c31805c0d','Add Product',NULL,NULL,'de0a0b21-2aad-42c1-8f11-c4a6535c1851','2'),('6db8beed-f08d-4554-bdb0-2494e2787dbf','Discount Tier',NULL,NULL,NULL,NULL),('81b09a39-b4ce-4517-b1bb-bab87dadf2a4','Delete Product',NULL,NULL,'de0a0b21-2aad-42c1-8f11-c4a6535c1851','2'),('d8047e09-5f18-484d-9314-a71972c4bd84','Edit Product',NULL,NULL,'de0a0b21-2aad-42c1-8f11-c4a6535c1851','2'),('de0a0b21-2aad-42c1-8f11-c4a6535c1851','Add/Update Product',NULL,NULL,'3acb7655-a88c-48e0-9be1-feee3a02ba1a','1');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-17 16:16:34
