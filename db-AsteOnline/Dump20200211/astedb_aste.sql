-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: astedb
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `aste`
--

DROP TABLE IF EXISTS `aste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aste` (
  `id_asta` int NOT NULL AUTO_INCREMENT,
  `durata_timeslot` int NOT NULL,
  `data_creazione` date NOT NULL,
  `stato` int NOT NULL,
  `tipo_asta` int NOT NULL,
  `perc_penale` int NOT NULL,
  `utente_creator` int NOT NULL,
  `oggetto_asta` int NOT NULL,
  `tipo_timeslot` int NOT NULL,
  `utente_offerta_max` int NOT NULL,
  `offerta_max` int NOT NULL,
  `num_off_rimanenti` int NOT NULL,
  PRIMARY KEY (`id_asta`),
  KEY `utente_creator_idx` (`utente_creator`),
  KEY `oggetto_asta_idx` (`oggetto_asta`),
  CONSTRAINT `oggetto_asta` FOREIGN KEY (`oggetto_asta`) REFERENCES `oggetti` (`id_oggetto`),
  CONSTRAINT `utente_creator` FOREIGN KEY (`utente_creator`) REFERENCES `utenti` (`id_utente`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aste`
--

LOCK TABLES `aste` WRITE;
/*!40000 ALTER TABLE `aste` DISABLE KEYS */;
INSERT INTO `aste` VALUES (1,3,'2020-02-09',0,0,0,1,1,0,0,0,3),(2,4,'2020-02-09',0,0,25,1,2,1,0,0,4),(3,5,'2020-02-09',0,1,0,1,10,0,0,0,5),(4,7,'2020-02-09',0,0,50,1,11,0,0,0,7),(6,3,'2020-02-09',0,0,0,1,6,0,0,0,3),(7,3,'2020-02-09',2,0,25,2,7,0,1,65,0),(8,3,'2020-02-10',2,0,0,2,15,0,1,35,0),(9,3,'2020-02-10',3,1,25,2,16,0,1,60,0),(10,3,'2020-02-10',2,1,0,2,17,0,4,50,0),(11,3,'2020-02-11',2,0,0,2,18,0,1,30,0),(12,3,'2020-02-11',2,0,0,6,20,0,1,80,0);
/*!40000 ALTER TABLE `aste` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-11 15:53:45
