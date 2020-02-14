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
-- Table structure for table `oggetti`
--

DROP TABLE IF EXISTS `oggetti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `oggetti` (
  `id_oggetto` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `prezzo` double NOT NULL,
  `utente_crea` int NOT NULL,
  `categoria` int NOT NULL,
  `stato` varchar(45) NOT NULL,
  PRIMARY KEY (`id_oggetto`),
  UNIQUE KEY `nome_UNIQUE` (`nome`),
  KEY `utente_creatore_idx` (`utente_crea`),
  KEY `categoria_idx` (`categoria`),
  CONSTRAINT `categoria` FOREIGN KEY (`categoria`) REFERENCES `categorie` (`id_categoria`),
  CONSTRAINT `utente_crea` FOREIGN KEY (`utente_crea`) REFERENCES `utenti` (`id_utente`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `oggetti`
--

LOCK TABLES `oggetti` WRITE;
/*!40000 ALTER TABLE `oggetti` DISABLE KEYS */;
INSERT INTO `oggetti` VALUES (1,'Harry Potter',15,1,9,'1'),(2,'Harry Potter2',18,1,9,'1'),(6,'hp',251,1,6,'1'),(7,'call of duty',59,2,7,'1'),(9,'fujitsu',800,1,6,'0'),(10,'nba 2k20',69,1,7,'1'),(11,'Spider-man 3',20,1,9,'1'),(12,'dark souls 3',49,1,7,'0'),(13,'Titanic',15,2,9,'0'),(14,'barbie',25,2,1,'0'),(15,'sea of thieves',20,2,7,'1'),(16,'FIFA 20',59,2,7,'0'),(17,'ARK',25,2,7,'1'),(18,'Minecraft',20,2,7,'1'),(19,'FIFA19',5,4,7,'0'),(20,'Cod MW',70,6,7,'1');
/*!40000 ALTER TABLE `oggetti` ENABLE KEYS */;
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
