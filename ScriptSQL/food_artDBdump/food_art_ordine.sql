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
-- Table structure for table `ordine`
--

DROP TABLE IF EXISTS `ordine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordine` (
  `idOrdine` int NOT NULL AUTO_INCREMENT,
  `dataOra` datetime NOT NULL,
  `via` varchar(45) NOT NULL,
  `nCivico` varchar(7) NOT NULL,
  `citta` varchar(45) NOT NULL,
  `provincia` varchar(25) NOT NULL,
  `cap` char(5) NOT NULL,
  `nCarta` char(16) NOT NULL,
  `stato` varchar(45) NOT NULL,
  `descrizione` text,
  `idUtente` int NOT NULL,
  PRIMARY KEY (`idOrdine`),
  KEY `idUtenteOrdine_idx` (`idUtente`),
  CONSTRAINT `idUtenteOrdine` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`idUtente`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordine`
--

LOCK TABLES `ordine` WRITE;
/*!40000 ALTER TABLE `ordine` DISABLE KEYS */;
INSERT INTO `ordine` VALUES (1,'2021-01-29 14:15:00','Via dello Stadio','18','Pagani','SA','84016','4542202461315128','In elaborazione',NULL,1),(4,'2021-01-15 14:17:02','Via Filettine','194','Pagani','SA','84016','4737095838902536','Spedito',NULL,2),(5,'2021-01-03 14:19:04','Vico della Fede','193','San Giuseppe','NA','80047','4604309867044171','Consegnato',NULL,3),(6,'2021-01-17 14:21:06','Via Merliano','7','Nola','NA','80035','4347789489144545','Consegnato',NULL,4),(7,'2021-01-19 14:23:08','Via Verdi','15','Avellino','AV','83100','4006440393358134','Consegnato',NULL,5),(8,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(9,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(10,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(11,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(12,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(13,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(14,'2021-10-25 00:00:00','Via Speranza','10','Frosinone','FR','03100','4322321913886985','In elaborazione',NULL,4),(15,'2021-10-25 00:00:00','Via Speranza','10','Frosinone','FR','03100','4322321913886985','In elaborazione',NULL,4),(16,'2021-10-25 00:00:00','Via Speranza','10','Frosinone','FR','03100','4322321913886985','In elaborazione',NULL,4),(17,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(18,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(19,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(20,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(21,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(22,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(23,'2021-10-25 00:00:00','Via Speranza','10','Frosinone','FR','03100','4347789489144545','In elaborazione',NULL,4),(24,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(25,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(26,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(27,'2021-10-25 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(28,'2021-10-25 00:00:00','Via Speranza','10','Frosinone','FR','03100','4347789489144545','In elaborazione',NULL,4),(29,'2021-10-26 00:00:00','Via Merliano','7','Nola','NA','80035','4347789489144545','In elaborazione',NULL,4),(30,'2021-10-26 00:00:00','Via Merliano','7','Nola','NA','80035','4347789489144545','In elaborazione',NULL,4),(31,'2021-10-26 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(32,'2021-10-26 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(33,'2021-10-26 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(34,'2021-10-26 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(35,'2021-10-26 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(36,'2021-10-27 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(37,'2021-10-27 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(38,'2021-10-28 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(39,'2021-10-29 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4),(40,'2021-10-29 00:00:00','Via Merliano','7','Nola','NA','80035','4322321913886985','In elaborazione',NULL,4);
/*!40000 ALTER TABLE `ordine` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-29 16:16:44
