CREATE DATABASE  IF NOT EXISTS `sorveteria` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sorveteria`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: sorveteria
-- ------------------------------------------------------
-- Server version	5.7.10-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `calda`
--

DROP TABLE IF EXISTS `calda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calda` (
  `IDCALDA` smallint(6) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDCALDA`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calda`
--

LOCK TABLES `calda` WRITE;
/*!40000 ALTER TABLE `calda` DISABLE KEYS */;
INSERT INTO `calda` VALUES (1,'Chocolate'),(2,'Limão'),(3,'Caramelo'),(4,'Morango');
/*!40000 ALTER TABLE `calda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedor` (
  `IDFORNECEDOR` smallint(6) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(255) DEFAULT NULL,
  `idMarca` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`IDFORNECEDOR`),
  KEY `FK_FORNECEDOR_idMarca` (`idMarca`),
  CONSTRAINT `FK_FORNECEDOR_idMarca` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`IDMARCA`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'Nestlé',1);
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `idPessoaFuncionario` int(11) NOT NULL,
  `SALARIO` double DEFAULT NULL,
  PRIMARY KEY (`idPessoaFuncionario`),
  CONSTRAINT `FK_FUNCIONARIO_idPessoaFuncionario` FOREIGN KEY (`idPessoaFuncionario`) REFERENCES `pessoa` (`IDPESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,2000),(2,1200);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `IDMARCA` smallint(6) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDMARCA`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (1,'Kibon');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metodopagamento`
--

DROP TABLE IF EXISTS `metodopagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `metodopagamento` (
  `IDPAGAMENTO` smallint(6) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDPAGAMENTO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodopagamento`
--

LOCK TABLES `metodopagamento` WRITE;
/*!40000 ALTER TABLE `metodopagamento` DISABLE KEYS */;
INSERT INTO `metodopagamento` VALUES (1,'Cartão de Crédito'),(2,'Cartão de Débito'),(3,'Dinheiro');
/*!40000 ALTER TABLE `metodopagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pessoa` (
  `IDPESSOA` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(31) DEFAULT NULL,
  `CPF` bigint(20) DEFAULT NULL,
  `DATANASCIMENTO` date DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDPESSOA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (1,'F',12345678900,'1995-04-01','JC'),(2,'F',12345678900,'1994-04-01','JC 2');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `IDPRODUTO` int(11) NOT NULL AUTO_INCREMENT,
  `NOME` varchar(255) DEFAULT NULL,
  `PRECO` double DEFAULT NULL,
  `QUANTIDADEESTOQUE` smallint(6) DEFAULT NULL,
  `idCalda` smallint(6) DEFAULT NULL,
  `idFornecedor` smallint(6) DEFAULT NULL,
  `idPagamento` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`IDPRODUTO`),
  KEY `FK_PRODUTO_idPagamento` (`idPagamento`),
  KEY `FK_PRODUTO_idCalda` (`idCalda`),
  KEY `FK_PRODUTO_idFornecedor` (`idFornecedor`),
  CONSTRAINT `FK_PRODUTO_idCalda` FOREIGN KEY (`idCalda`) REFERENCES `calda` (`IDCALDA`),
  CONSTRAINT `FK_PRODUTO_idFornecedor` FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedor` (`IDFORNECEDOR`),
  CONSTRAINT `FK_PRODUTO_idPagamento` FOREIGN KEY (`idPagamento`) REFERENCES `metodopagamento` (`IDPAGAMENTO`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'Peralta',20,30,1,1,1);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtosabor`
--

DROP TABLE IF EXISTS `produtosabor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtosabor` (
  `idProduto` int(11) NOT NULL,
  `idSabor` smallint(6) NOT NULL,
  PRIMARY KEY (`idProduto`,`idSabor`),
  KEY `FK_ProdutoSabor_idSabor` (`idSabor`),
  CONSTRAINT `FK_ProdutoSabor_idProduto` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`IDPRODUTO`),
  CONSTRAINT `FK_ProdutoSabor_idSabor` FOREIGN KEY (`idSabor`) REFERENCES `sabor` (`IDSABOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtosabor`
--

LOCK TABLES `produtosabor` WRITE;
/*!40000 ALTER TABLE `produtosabor` DISABLE KEYS */;
INSERT INTO `produtosabor` VALUES (1,2);
/*!40000 ALTER TABLE `produtosabor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sabor`
--

DROP TABLE IF EXISTS `sabor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sabor` (
  `IDSABOR` smallint(6) NOT NULL AUTO_INCREMENT,
  `DESCRICAO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDSABOR`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sabor`
--

LOCK TABLES `sabor` WRITE;
/*!40000 ALTER TABLE `sabor` DISABLE KEYS */;
INSERT INTO `sabor` VALUES (1,'Prestígio'),(2,'Flocos'),(3,'Uva'),(4,'Abacaxi'),(5,'Morango'),(6,'Chocolate'),(7,'Coco'),(8,'Leite Condensado'),(9,'Leite Ninho');
/*!40000 ALTER TABLE `sabor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idPessoaUsuario` int(11) NOT NULL,
  `LOGIN` varchar(255) DEFAULT NULL,
  `SENHA` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPessoaUsuario`),
  CONSTRAINT `FK_USUARIO_idPessoaUsuario` FOREIGN KEY (`idPessoaUsuario`) REFERENCES `pessoa` (`IDPESSOA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'teste','2e6f9b0d5885b6010f9167787445617f553a735f'),(2,'jc','e5c9e749120edb7315a3fc542baeab622b51e345');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venda`
--

DROP TABLE IF EXISTS `venda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venda` (
  `IDVENDA` int(11) NOT NULL AUTO_INCREMENT,
  `DATA` datetime DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDVENDA`),
  KEY `FK_VENDA_idPessoa` (`idPessoa`),
  CONSTRAINT `FK_VENDA_idPessoa` FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`IDPESSOA`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venda`
--

LOCK TABLES `venda` WRITE;
/*!40000 ALTER TABLE `venda` DISABLE KEYS */;
INSERT INTO `venda` VALUES (1,'2019-06-28 00:00:00',1),(2,'2019-06-12 00:00:00',2);
/*!40000 ALTER TABLE `venda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendaproduto`
--

DROP TABLE IF EXISTS `vendaproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendaproduto` (
  `PRECO` double DEFAULT NULL,
  `idProduto` int(11) NOT NULL,
  `idVenda` int(11) NOT NULL,
  PRIMARY KEY (`idProduto`,`idVenda`),
  KEY `FK_VENDAPRODUTO_idVenda` (`idVenda`),
  CONSTRAINT `FK_VENDAPRODUTO_idProduto` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`IDPRODUTO`),
  CONSTRAINT `FK_VENDAPRODUTO_idVenda` FOREIGN KEY (`idVenda`) REFERENCES `venda` (`IDVENDA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendaproduto`
--

LOCK TABLES `vendaproduto` WRITE;
/*!40000 ALTER TABLE `vendaproduto` DISABLE KEYS */;
INSERT INTO `vendaproduto` VALUES (25,1,1),(256,1,2);
/*!40000 ALTER TABLE `vendaproduto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-28 18:10:19
