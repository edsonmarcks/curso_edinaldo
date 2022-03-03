-- MariaDB dump 10.19  Distrib 10.4.22-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: db_clinica
-- ------------------------------------------------------
-- Server version	10.4.22-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
--CREATE DATABASE;

create database if not exists db_clinica;
--
-- Table structure for table `agendamento`
--
use db_clinica;

DROP TABLE IF EXISTS `agendamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agendamento` (
  `age_id` int(11) NOT NULL AUTO_INCREMENT,
  `age_paciente_id` int(11) NOT NULL,
  `age_medico_id` int(11) NOT NULL,
  `age_data` date NOT NULL,
  `age_hora` varchar(20) NOT NULL,
  `age_status` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`age_id`),
  KEY `age_paciente_id` (`age_paciente_id`),
  KEY `age_medico_id` (`age_medico_id`),
  CONSTRAINT `agendamento_ibfk_1` FOREIGN KEY (`age_paciente_id`) REFERENCES `paciente` (`pac_id`),
  CONSTRAINT `agendamento_ibfk_2` FOREIGN KEY (`age_medico_id`) REFERENCES `medico` (`med_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agendamento`
--

LOCK TABLES `agendamento` WRITE;
/*!40000 ALTER TABLE `agendamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `agendamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `consulta` (
  `con_id` int(11) NOT NULL AUTO_INCREMENT,
  `con_paciente_id` int(11) NOT NULL,
  `con_medico_id` int(11) NOT NULL,
  `con_data` date NOT NULL,
  `con_hora` varchar(20) NOT NULL,
  `con_status` varchar(40) DEFAULT NULL,
  `con_diagnostico` text DEFAULT NULL,
  `con_medicacao` text DEFAULT NULL,
  PRIMARY KEY (`con_id`),
  KEY `con_paciente_id` (`con_paciente_id`),
  KEY `con_medico_id` (`con_medico_id`),
  CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`con_paciente_id`) REFERENCES `paciente` (`pac_id`),
  CONSTRAINT `consulta_ibfk_2` FOREIGN KEY (`con_medico_id`) REFERENCES `medico` (`med_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (
  `med_id` int(11) NOT NULL AUTO_INCREMENT,
  `med_nome` varchar(100) NOT NULL,
  `med_data_admissao` date NOT NULL,
  `med_especializacao` varchar(50) NOT NULL,
  `med_telefone` varchar(20) NOT NULL,
  `med_CRM` varchar(20) NOT NULL,
  `med_email` varchar(100) NOT NULL,
  PRIMARY KEY (`med_id`),
  UNIQUE KEY `crm_med` (`med_CRM`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES (1,'Carlos Antonio','1963-03-22','Geriatra','743665555','88877788','carlosanto@gmail.com');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `pac_id` int(11) NOT NULL AUTO_INCREMENT,
  `pac_nome` varchar(100) NOT NULL,
  `pac_sexo` varchar(20) DEFAULT NULL,
  `pac_nasc` date NOT NULL,
  `pac_cpf` varchar(20) NOT NULL,
  `pac_telefone` varchar(20) DEFAULT NULL,
  `pac_email` varchar(100) DEFAULT NULL,
  `pac_rua` varchar(50) DEFAULT NULL,
  `pac_bairro` varchar(50) DEFAULT NULL,
  `pac_cidade` varchar(50) DEFAULT NULL,
  `pac_estado` char(3) DEFAULT NULL,
  PRIMARY KEY (`pac_id`),
  UNIQUE KEY `pac_cpf` (`pac_cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (1,'José da Silva Jardim','M','1980-03-10','11144477735','7455888855','josesilva@gmail.com','Nova Odessa','São Joao','Xique-Xique','BA');
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `use_id` int(11) NOT NULL AUTO_INCREMENT,
  `use_nome` varchar(20) NOT NULL,
  `use_senha` varchar(20) NOT NULL,
  `use_permissao` varchar(40) NOT NULL,
  PRIMARY KEY (`use_id`),
  UNIQUE KEY `use_nome` (`use_nome`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'jose','123','USER_COMUM'),(2,'maria','5222','ADMIN'),(3,'joana','4844','USER_COMUM'),(4,'miguel','1155','MEDICO'),(5,'edsonmarcks','[C@2a28648c','ADMIN'),(10,'edsonmarcks2','1234567899','ADMIN'),(14,'maria2','12345679','USER_COMUM');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-22 10:33:45
