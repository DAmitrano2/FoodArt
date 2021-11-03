CREATE DATABASE  IF NOT EXISTS `food_art` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `food_art`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: food_art
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
-- Table structure for table `voce`
--

DROP TABLE IF EXISTS `voce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voce` (
  `idOrdine` int NOT NULL,
  `idProdotto` int NOT NULL,
  `quantita` float NOT NULL,
  `prezzo` float NOT NULL,
  PRIMARY KEY (`idOrdine`,`idProdotto`),
  KEY `idVoceProdotto_idx` (`idProdotto`),
  CONSTRAINT `idVoceOrdine` FOREIGN KEY (`idOrdine`) REFERENCES `ordine` (`idOrdine`),
  CONSTRAINT `idVoceProdotto` FOREIGN KEY (`idProdotto`) REFERENCES `prodotto` (`idProdotto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voce`
--

LOCK TABLES `voce` WRITE;
/*!40000 ALTER TABLE `voce` DISABLE KEYS */;
INSERT INTO `voce` VALUES (1,1,1,6),(4,2,1,11.5),(5,3,2,1.25),(6,4,6,9.2),(7,5,5,3),(24,7,1,25),(24,33,1,2.5),(25,49,1,0.8),(26,2,4,11.5),(27,5,1,3),(28,5,5,3),(29,7,1,25),(29,33,1,2.5),(29,34,1,25),(31,56,1,5.73),(33,13,1,4),(35,13,2,4),(36,3,5,1.25),(37,3,4,1.25),(38,3,1,1.25),(39,54,1,6),(39,55,1,5.8),(39,56,1,5.73),(40,54,1,6),(40,55,1,5.8),(40,56,1,5.73);
/*!40000 ALTER TABLE `voce` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-29 16:16:36
