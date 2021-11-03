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
-- Table structure for table `indirizzoconsegna`
--

DROP TABLE IF EXISTS `indirizzoconsegna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `indirizzoconsegna` (
  `idIndirizzoConsegna` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) NOT NULL,
  `cognome` varchar(25) NOT NULL,
  `nTelefono` varchar(11) NOT NULL,
  `via` varchar(45) NOT NULL,
  `nCivico` varchar(7) NOT NULL,
  `citta` varchar(45) NOT NULL,
  `provincia` varchar(25) NOT NULL,
  `cap` char(5) NOT NULL,
  `descrizione` text,
  `idUtente` int NOT NULL,
  PRIMARY KEY (`idIndirizzoConsegna`),
  KEY `idUtenteIndirizzo_idx` (`idUtente`),
  CONSTRAINT `idUtenteIndirizzo` FOREIGN KEY (`idUtente`) REFERENCES `utente` (`idUtente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `indirizzoconsegna`
--

LOCK TABLES `indirizzoconsegna` WRITE;
/*!40000 ALTER TABLE `indirizzoconsegna` DISABLE KEYS */;
INSERT INTO `indirizzoconsegna` VALUES (1,'Alfonso','Zappia','3271284294','Via dello Stadio','18','Pagani','SA','84016','Secondo Piano',1),(2,'Davide','Amitrano','3332396559','Via Filettine','194','Pagani','SA','84016','Ultimo Cancello a sinistra',2),(3,'Donato','Miranda','3319356835','Vico della Fede','193','San Giuseppe','NA','80047',NULL,3),(4,'Harry','Potter','3399957698','Via Merliano','7','Nola','NA','80035','Interno 2',4),(5,'Ron','Weasley','3663660849','Via Verdi','15','Avellino','AV','83100','Cancello Verde',5),(6,'Harry','Potter','3664389094','Via Speranza','10','Frosinone','FR','03100','Primo cancello a destra',4);
/*!40000 ALTER TABLE `indirizzoconsegna` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-29 16:16:37
