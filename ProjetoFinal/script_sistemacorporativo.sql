CREATE DATABASE  IF NOT EXISTS `sistemacorporativo` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `sistemacorporativo`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: sistemacorporativo
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `conta_despesa`
--

DROP TABLE IF EXISTS `conta_despesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `conta_despesa` (
  `despesa_id` int(11) NOT NULL AUTO_INCREMENT,
  `despesa_data` date DEFAULT NULL,
  `despesa_valor` double NOT NULL,
  `despesa_descricao` varchar(75) COLLATE utf8_unicode_ci DEFAULT NULL,
  `despesa_conta_id` int(11) NOT NULL,
  `categoria_id` int(11) NOT NULL,
  PRIMARY KEY (`despesa_id`),
  KEY `fk_conta_despesa` (`despesa_conta_id`),
  KEY `fk_conta_categoria` (`categoria_id`),
  CONSTRAINT `fk_conta_categoria` FOREIGN KEY (`categoria_id`) REFERENCES `despesa_categoria` (`categoria_id`),
  CONSTRAINT `fk_conta_despesa` FOREIGN KEY (`despesa_conta_id`) REFERENCES `presta_conta` (`conta_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conta_despesa`
--

LOCK TABLES `conta_despesa` WRITE;
/*!40000 ALTER TABLE `conta_despesa` DISABLE KEYS */;
INSERT INTO `conta_despesa` VALUES (1,'2018-01-01',12,'dadasds',24,1),(2,'2018-01-01',1255,'dadasds',24,1),(3,'2018-01-01',800000000,'teste',25,1),(4,'2018-12-04',699,'hfghfghfh',29,3),(5,'2018-12-14',10,'teste',30,1),(6,'2018-12-14',30,'teste',30,1),(7,'2018-12-13',5,'dfgdfgfdg',31,4),(8,'2018-12-05',121,'dfhdfhd',32,3),(9,'2018-12-11',12,'fgdfgdffd',33,1),(10,'2018-12-13',888888888,'dfgdfgf',34,1);
/*!40000 ALTER TABLE `conta_despesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `despesa_categoria`
--

DROP TABLE IF EXISTS `despesa_categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `despesa_categoria` (
  `categoria_id` int(11) NOT NULL,
  `categoria_descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`categoria_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `despesa_categoria`
--

LOCK TABLES `despesa_categoria` WRITE;
/*!40000 ALTER TABLE `despesa_categoria` DISABLE KEYS */;
INSERT INTO `despesa_categoria` VALUES (1,'Refeicao'),(2,'Taxi'),(3,'Estacionamento'),(4,'Brinde'),(5,'Passagem'),(6,'Hospedagem');
/*!40000 ALTER TABLE `despesa_categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funcionario` (
  `fun_id` int(11) NOT NULL AUTO_INCREMENT,
  `fun_nome` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `fun_senha` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `fun_login` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `fun_rg` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `fun_cpf` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `fun_data_cadastro` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fun_responsavel` int(11) NOT NULL,
  `fun_perfil` int(11) NOT NULL,
  `fun_email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`fun_id`),
  KEY `fk_funcionario_perfil` (`fun_perfil`),
  CONSTRAINT `fk_funcionario_perfil` FOREIGN KEY (`fun_perfil`) REFERENCES `funcionario_perfil` (`perfil_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'leonardo','admin','admin','1233333','12334444','2018-10-26 00:00:00',1,1,''),(4,'admin2','admin','admin2','123','123','2018-01-01 00:00:00',1,1,'admin@gmail.com'),(5,'admin1','admin','admin1','12345','1234','2018-01-01 00:00:00',0,1,'aaaaaa'),(6,'andrei','andrei','andrei','1234','12344','2018-01-01 00:00:00',0,1,'andrei@hotmail.com'),(7,'hamilton','admin','hamilton','1234','1234','2018-01-01 00:00:00',0,1,'dsaadasd'),(8,'testeDao','aaaaaaaa','testeDao','1234','1234','2018-01-01 00:00:00',0,1,'aaaaaaa'),(9,'Teste','Teste','Teste','22222','12345','2018-11-06 21:46:30',0,1,'sfdfdd'),(10,'crispin','admin','crispin','98.989.898-9','999.999.999-99','2018-12-07 22:35:16',2,1,'testets');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario_perfil`
--

DROP TABLE IF EXISTS `funcionario_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `funcionario_perfil` (
  `perfil_id` int(11) NOT NULL,
  `perfil_descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`perfil_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario_perfil`
--

LOCK TABLES `funcionario_perfil` WRITE;
/*!40000 ALTER TABLE `funcionario_perfil` DISABLE KEYS */;
INSERT INTO `funcionario_perfil` VALUES (1,'Administrador'),(2,'Chefe'),(3,'Funcionario');
/*!40000 ALTER TABLE `funcionario_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grandeareaconhecimento`
--

DROP TABLE IF EXISTS `grandeareaconhecimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `grandeareaconhecimento` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grandeareaconhecimento`
--

LOCK TABLES `grandeareaconhecimento` WRITE;
/*!40000 ALTER TABLE `grandeareaconhecimento` DISABLE KEYS */;
/*!40000 ALTER TABLE `grandeareaconhecimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mes_referencia`
--

DROP TABLE IF EXISTS `mes_referencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mes_referencia` (
  `id` int(11) NOT NULL,
  `descricao` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mes_referencia`
--

LOCK TABLES `mes_referencia` WRITE;
/*!40000 ALTER TABLE `mes_referencia` DISABLE KEYS */;
INSERT INTO `mes_referencia` VALUES (1,'Janeiro'),(2,'Fevereiro'),(3,'Março'),(4,'Abril'),(5,'Maio'),(6,'Junho'),(7,'Julho'),(8,'Agosto'),(9,'Setembro'),(10,'Outubro'),(11,'Novembro'),(12,'Dezembro');
/*!40000 ALTER TABLE `mes_referencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presta_conta`
--

DROP TABLE IF EXISTS `presta_conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `presta_conta` (
  `conta_id` int(11) NOT NULL AUTO_INCREMENT,
  `conta_cartao` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idmes_referencia` int(11) DEFAULT NULL,
  `fun_id` int(11) NOT NULL,
  `status_id` int(11) NOT NULL,
  `conta_tipo` int(11) NOT NULL,
  PRIMARY KEY (`conta_id`),
  KEY `fk_funcionario_conta` (`fun_id`),
  KEY `fk_status_conta` (`status_id`),
  KEY `fk_mes_referencia` (`idmes_referencia`),
  CONSTRAINT `fk_funcionario_conta` FOREIGN KEY (`fun_id`) REFERENCES `funcionario` (`fun_id`),
  CONSTRAINT `fk_mes_referencia` FOREIGN KEY (`idmes_referencia`) REFERENCES `mes_referencia` (`id`),
  CONSTRAINT `fk_status_conta` FOREIGN KEY (`status_id`) REFERENCES `status_conta` (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presta_conta`
--

LOCK TABLES `presta_conta` WRITE;
/*!40000 ALTER TABLE `presta_conta` DISABLE KEYS */;
INSERT INTO `presta_conta` VALUES (2,'123455',NULL,1,2,1),(3,'1234765',NULL,1,2,1),(4,'12345678',NULL,1,2,1),(5,'12345',NULL,1,2,1),(6,'12345',NULL,1,2,1),(7,'12345',NULL,1,2,1),(8,'123456',NULL,1,2,1),(9,'12345',NULL,1,2,1),(10,'121212',NULL,1,2,1),(11,'123345',NULL,1,2,1),(12,'2323',NULL,1,2,1),(13,'1234566',NULL,1,2,1),(14,'567',NULL,1,2,1),(15,'',NULL,1,2,1),(16,'32323',NULL,1,2,1),(17,'5656',NULL,1,2,1),(18,'123',NULL,1,2,1),(19,'2222',NULL,1,2,1),(20,'123456',NULL,1,2,1),(21,'12345',NULL,1,2,1),(22,'12121',NULL,1,2,1),(23,'99999',NULL,1,2,1),(24,'555555',NULL,1,2,1),(25,'#############',NULL,1,2,1),(29,'0',NULL,1,3,2),(30,'',NULL,1,3,2),(31,'',NULL,10,1,2),(32,'22222222',NULL,1,3,1),(33,'12121215',3,10,2,1),(34,'12525252',4,1,3,1);
/*!40000 ALTER TABLE `presta_conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status_conta`
--

DROP TABLE IF EXISTS `status_conta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `status_conta` (
  `status_id` int(11) NOT NULL,
  `status_descricao` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status_conta`
--

LOCK TABLES `status_conta` WRITE;
/*!40000 ALTER TABLE `status_conta` DISABLE KEYS */;
INSERT INTO `status_conta` VALUES (1,'Aprovado'),(2,'Reprovado'),(3,'Aguardando Aprovação');
/*!40000 ALTER TABLE `status_conta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'sistemacorporativo'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-11 21:30:35
