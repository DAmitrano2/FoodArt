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
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `idUtente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) NOT NULL,
  `cognome` varchar(25) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `amministratore` tinyint(1) NOT NULL DEFAULT '0',
  `rivenditore` tinyint(1) NOT NULL DEFAULT '0',
  `bloccato` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idUtente`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'Alfonso','Zappia','alfonsozappia00@gmail.com','YWRtaW5hbGY=',0,0,0),(2,'Davide','Amitrano','davideamitrano98@gmail.com','YW1pdHJhbm8=',0,0,0),(3,'Donato','Miranda','donatomirando93@gmail.com','ZG9uYXRvMTc=',0,0,0),(4,'Harry','Potter','harrypotter98@gmail.com','aG9yY3J1eDg=',0,0,0),(5,'Ron','Weasley','ronweasley99@gmail.com','cm9ud2Vhc2xleQ==',0,0,0),(6,'Hermione','Granger','hermionegranger97@gmail.com','aGVybWlvbmU=',0,1,0),(7,'Cristiano','Ronaldo','cristianoronaldo85@gmail.com','bWlnbGlvcmVkaXR1dHRp',0,1,0),(8,'Romelu','Lukaku','romelulukaku93@gmail.com','Ymlncm9tOTM=',0,1,0),(9,'Zlatan','Ibrahimović','zlatanibrahimovic81@gmail.com','ZGlvemxhdGFu',0,1,0),(10,'Marshall','Mathers','eminem72@gmail.com','c2xpbXNoYWR5',0,1,0),(11,'Bill','Gates','billgates55@gmail.com','bWljcm9zb2Z0Cg==',1,0,0),(12,'Jeff','Bezos','jeffbezos64@gmail.com','YW1hem9uNjQ=',1,0,0),(13,'Elon','Musk','elonmusk71@gmail.com','ZXRlc2xhNzE=',1,0,0),(14,'Leonardo','Pieraccioni','leonardopieraccioni65@gmail.com','dG9zY2FuYTE=',0,1,0),(15,'Emma','Watson','emmawatson90@gmail.com','ZXcxNTA0OTA=',0,1,0),(16,'Lionel','Messi','leomessi87@gmail.com','Z29hdGFyZ2U=',0,1,0),(17,'Antonio','Dalia','antoniodalia98@gmail.com','c2VpY2hlcmlubw==',0,1,0),(18,'Vincenzo','Esposito','vincenzoesposito00@gmail.com','a2luZ3ZpbnM=',0,1,0),(19,'Simone','Inzaghi','simoneinzaghi76@gmail.com','c2ltb25lNzY=',0,1,0),(20,'Samir','Handanovič','samirhandanovic84@gmail.com','c2FtaXI4NDU=',0,1,0),(21,'Denzel','Dumfries','denzeldumfries96@gmail.com','ZGVuemVsOTY=',0,1,0),(22,'Roberto','Gagliardini','robertogagliardini94@gmail.com','cm9iZXJ0bzk0',0,1,0),(23,'Christian','Eriksen','christianeriksen92@gmail.com','Y2hyaXN0aWFuOTI=',0,1,0),(24,'Lautaro','Martínez','lautaromartinez97@gmail.com','bGF1dGFybzk3',0,1,0),(25,'Hakan','Çalhanoğlu','hakancalhanoglu94@gmail.com','aGFrYW45NDU=',0,1,0),(27,'Leonardo','DiCaprio','leonardodicaprio74@gmail.com','b3NjYXI3NA==',0,1,0);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-29 16:16:35
