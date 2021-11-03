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
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `idFeedback` int NOT NULL AUTO_INCREMENT,
  `titolo` varchar(50) NOT NULL,
  `commento` text NOT NULL,
  `valutazione` float NOT NULL DEFAULT '0',
  `idCommentatore` int NOT NULL,
  `idProdotto` int DEFAULT NULL,
  `idRivenditore` int DEFAULT NULL,
  PRIMARY KEY (`idFeedback`),
  KEY `idFeedCommentatore_idx` (`idCommentatore`),
  KEY `idFeedProdotto_idx` (`idProdotto`),
  KEY `idFeedRivenditore_idx` (`idRivenditore`),
  CONSTRAINT `idFeedCommentatore` FOREIGN KEY (`idCommentatore`) REFERENCES `utente` (`idUtente`),
  CONSTRAINT `idFeedProdotto` FOREIGN KEY (`idProdotto`) REFERENCES `prodotto` (`idProdotto`),
  CONSTRAINT `idFeedRivenditore` FOREIGN KEY (`idRivenditore`) REFERENCES `utente` (`idUtente`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'Perfetta','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras diam libero, varius in lectus in, ultricies rhoncus urna. Nulla sollicitudin elementum laoreet. Cras dolor tortor, feugiat ut congue sed, venenatis.',4,1,1,6),(2,'Buonissima','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras diam libero, varius in lectus in, ultricies rhoncus urna. Nulla sollicitudin elementum laoreet. Cras dolor tortor, feugiat ut congue sed, venenatis.',5,2,1,6),(3,'Davvero delicata','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras diam libero, varius in lectus in, ultricies rhoncus urna. Nulla sollicitudin elementum laoreet. Cras dolor tortor, feugiat ut congue sed, venenatis.',4,3,1,6),(4,'Una confettura fantastica','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras diam libero, varius in lectus in, ultricies rhoncus urna. Nulla sollicitudin elementum laoreet. Cras dolor tortor, feugiat ut congue sed, venenatis.',5,4,1,6),(5,'Sapore fantastico','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras diam libero, varius in lectus in, ultricies rhoncus urna. Nulla sollicitudin elementum laoreet. Cras dolor tortor, feugiat ut congue sed, venenatis.',4,1,2,14),(6,'Una mistura pressoché perfetta','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras diam libero, varius in lectus in, ultricies rhoncus urna. Nulla sollicitudin elementum laoreet. Cras dolor tortor, feugiat ut congue sed, venenatis.',5,2,2,14),(7,'Vero salame toscano','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras diam libero, varius in lectus in, ultricies rhoncus urna. Nulla sollicitudin elementum laoreet. Cras dolor tortor, feugiat ut congue sed, venenatis.',4,3,2,14),(8,'Gusto dolce','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras diam libero, varius in lectus in, ultricies rhoncus urna. Nulla sollicitudin elementum laoreet. Cras dolor tortor, feugiat ut congue sed, venenatis.',4,1,3,7),(9,'Succose e dolci','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras diam libero, varius in lectus in, ultricies rhoncus urna. Nulla sollicitudin elementum laoreet. Cras dolor tortor, feugiat ut congue sed, venenatis.',5,2,3,7),(10,'Il piacere della birra artigianale','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras diam libero, varius in lectus in, ultricies rhoncus urna. Nulla sollicitudin elementum laoreet. Cras dolor tortor, feugiat ut congue sed, venenatis.',4,1,4,15);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-29 16:16:43
