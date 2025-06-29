CREATE DATABASE  IF NOT EXISTS `ars` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ars`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: ars
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `aadhar` varchar(20) DEFAULT NULL,
  `destination` varchar(100) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `seating_class` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`booking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (1,'ld1','laksya',9,'m','65757','dubai','2022-02-02','2'),(2,'ld1','ll',19,'male','1232','dubai','2023-02-23','2'),(3,'ld1','ll',19,'male','1232','dubai','2023-02-23','2'),(4,'RJ45','RISHI',20,'M','123456789','MUMBAI','2024-04-12','2'),(8,'sk','suhani',19,'female','123456327896','Kolkata','2024-06-25','economy');
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `user_id` varchar(20) NOT NULL,
  `passwd` varchar(20) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `contact` char(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('vg2412','V78647','Vishesh Goyal','8871500881','vishesh78647@gmail.com'),('ld1009','LD1009','Lakshya Dubey','8889525140','lakshya.dubey04@gmail.com'),('pd98','PD98','Prateek Dubey','8720050791','prateek.dubey98@gmail.com'),('yb55','YB55','Yash Bhargava','9425323034','yash.bhargav@gmail.com'),('kns45','KNS45','Kanishk Shukla','8889525140','kanishk.shukla@gmail.com'),('lakshyaji','1094','LAKSHYA DUBEY','8889525140','lakshya.dubey04@gmail.com'),('garv00','1111','GARV GANGWANI','9685988806','garv.gangwani04@gmail.com'),('rishij','1234','Rishi Joshi','9399979454','rishi.joshi69@gmail.com'),('ld04','1234','Lakshya Dubey','8889525140','lakshya.dubey04@gmail.com'),('sk00','1234','suhani','9876543210','suhani.kha@h'),('ld00','1234','Lakshya Dubey','8889525140','lakshya.dubey04@gmail.com'),('ab00','1234','abhijeet','9893836800','abhijeet.gmail'),('mn00','1234','Munnu','8889525140','munnuphy@gmail.com'),('gg00','8888','Garv Gangwani','9685988806','garv.gang@gmail.com'),('nd00','1234','nidhi mam','8529637412','nidhi.mam@gmail.com'),('av00','1234','avi singh','7778596524','ksjdcbkda'),('ak00','1234','Bebo Singhal','6479178256','akriti.bebo@gmail.com'),('ld1094','0000','Lakshya Dubey','8889525140','lakshya.dubey10@gmail.com'),('ak19','1234','ash singhal','1234567890','aku@singhal'),('suh123','suh123','Suhani Khandelwal','9425323045','suhani.khan@gmail.com'),('avi01','avi1','avi singh baghel','3456765','avi@gmail.com'),('ld1','ld1','lakshya','8889525142','lakshya.dubey@gamil.cm'),('avi','avi','divyendra','9685309010','avisingh@gmail.com'),('SUHA1','SUHA1','SUHANI','9876567890','SUHANAKHANDELWAL@GMAIL.COM'),('dubey','dubey','Lakshya Dubey','8889525140','lakshya.dubey04@gmail.com'),('RJ45','RJ45','RISHI JOSHI','999696999','RISHI.JOSHI@GMAIL.COM'),('mb01','mb01','mayank ','456123894','mayank.bhar@gmail.com'),('ld10','ld10','Lakshya ','1234567896','lakshya.dubey04@gmail.com'),('sk','sk','Suhani','8889525149','suhanan@gmaill'),('ks','ks','kashish','8975642310','kash@gmail'),('ab12','ab12','Abhaydeep sir','9632587412','abhaydeep@gmail.com'),('ash123','ash123','aashi ','8889525140','aashi@gmail.com'),('dsdsds','dsds','Lakshya Dubey','sdds','ssddsddssssssssssss'),('test123','test123','LAKSHYA DUBEY','9997634234','lakshya.dubey10@gmail.com');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight` (
  `F_No` varchar(20) NOT NULL,
  `Dprt` varchar(20) DEFAULT NULL,
  `Arvl` varchar(30) DEFAULT NULL,
  `Dprt_time` varchar(20) DEFAULT NULL,
  `Arvl_Time` varchar(20) DEFAULT NULL,
  `fare` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`F_No`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('ic94','Indore','Chennai','0530','0800',2000.00),('id95','Indore','Dubai','1400','2220',12000.00),('ik96','Indore','Kolkata','0845','1315',2500.00),('im97','Indore','Mumbai','0300','0430',3500.00),('in98','Indore','New Delhi','0445','0630',4000.00);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ic94`
--

DROP TABLE IF EXISTS `ic94`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ic94` (
  `psg_id` varchar(20) NOT NULL,
  `psg_name` varchar(20) DEFAULT NULL,
  `psg_age` int DEFAULT NULL,
  `psg_gdr` varchar(10) DEFAULT NULL,
  `DOF` date DEFAULT NULL,
  `psg_seat` varchar(10) DEFAULT NULL,
  `seat_class` varchar(15) DEFAULT NULL,
  `user_id` varchar(10) DEFAULT NULL,
  `Dprt_time` varchar(20) DEFAULT NULL,
  `Arvl_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`psg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ic94`
--

LOCK TABLES `ic94` WRITE;
/*!40000 ALTER TABLE `ic94` DISABLE KEYS */;
INSERT INTO `ic94` VALUES ('1234123123','lakshya',18,'M','2023-12-12','A88','Economy','',NULL,NULL),('776655331122','Lakshya Dubey',18,'M','2022-12-30','C52','Business','ld1009','0000','0530');
/*!40000 ALTER TABLE `ic94` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `id95`
--

DROP TABLE IF EXISTS `id95`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `id95` (
  `psg_id` varchar(20) NOT NULL,
  `psg_name` varchar(20) DEFAULT NULL,
  `psg_age` int DEFAULT NULL,
  `psg_gdr` varchar(10) DEFAULT NULL,
  `DOF` date DEFAULT NULL,
  `psg_seat` varchar(10) DEFAULT NULL,
  `seat_class` varchar(15) DEFAULT NULL,
  `user_id` varchar(10) DEFAULT NULL,
  `Dprt_time` varchar(20) DEFAULT NULL,
  `Arvl_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`psg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `id95`
--

LOCK TABLES `id95` WRITE;
/*!40000 ALTER TABLE `id95` DISABLE KEYS */;
INSERT INTO `id95` VALUES ('123412341234','aashi',19,'F','2024-05-25','B40','Business','ash123','1200','1400'),('123445','lakshya',98,'M','2024-04-23','A17','Business','avi1',NULL,NULL),('123454','dubey',12,'M','2023-02-22','B32','Business','',NULL,NULL),('123456789','suhani',34,'F','2024-01-31','A98','Business','suh123','1200','1400'),('23440098','SUHANI KHANDELWAL',19,'M','2024-04-25','B04','Business','SUHA1',NULL,NULL),('234523464567','akriti',19,'F','2024-02-14','A60','Business','ak19','1200','1400'),('566756787567','avi singh',18,'M','2023-04-26','A41','Business','av00','1200','1400');
/*!40000 ALTER TABLE `id95` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ik96`
--

DROP TABLE IF EXISTS `ik96`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ik96` (
  `psg_id` varchar(20) NOT NULL,
  `psg_name` varchar(20) DEFAULT NULL,
  `psg_age` int DEFAULT NULL,
  `psg_gdr` varchar(10) DEFAULT NULL,
  `DOF` date DEFAULT NULL,
  `psg_seat` varchar(10) DEFAULT NULL,
  `seat_class` varchar(15) DEFAULT NULL,
  `user_id` varchar(10) DEFAULT NULL,
  `Dprt_time` varchar(20) DEFAULT NULL,
  `Arvl_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`psg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ik96`
--

LOCK TABLES `ik96` WRITE;
/*!40000 ALTER TABLE `ik96` DISABLE KEYS */;
INSERT INTO `ik96` VALUES ('112233445588','Keshav Gupta',18,'M','2022-02-12','A82','Business','ld1009','1315','0845'),('123456','lakshya',24,'M','2023-03-23','B94','Business','avi1',NULL,NULL),('23354642','shabbar ',23,'M','2023-03-23','A17','Business','avi1',NULL,NULL),('45644564845649','Lakshya Dubey',18,'M','2023-07-31','A74','Business','ld1094','1315','0845'),('779955331144','Lakshya Dubey',18,'M','2022-12-02','C50','Business','pd98','1315','0845'),('7799664422','PRATEEK DUBEY',24,'M','2022-02-12','B89','Business','','1315','0845');
/*!40000 ALTER TABLE `ik96` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `im97`
--

DROP TABLE IF EXISTS `im97`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `im97` (
  `psg_id` varchar(20) NOT NULL,
  `psg_name` varchar(20) DEFAULT NULL,
  `psg_age` int DEFAULT NULL,
  `psg_gdr` varchar(10) DEFAULT NULL,
  `DOF` date DEFAULT NULL,
  `psg_seat` varchar(10) DEFAULT NULL,
  `seat_class` varchar(15) DEFAULT NULL,
  `user_id` varchar(10) DEFAULT NULL,
  `Dprt_time` varchar(20) DEFAULT NULL,
  `Arvl_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`psg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `im97`
--

LOCK TABLES `im97` WRITE;
/*!40000 ALTER TABLE `im97` DISABLE KEYS */;
INSERT INTO `im97` VALUES ('1144889966','Lakshya Dubey',18,'M','2022-02-12','B20','Business','ld1009','0430','0300'),('123423453456','Lakshya Dubey',18,'M','2023-04-24','B63','Business','ld00','0430','0300'),('456756787890','Akriti Singhal',18,'F','2023-04-24','A70','Business','ld00','0430','0300'),('456789876543','mayank',19,'M','2024-04-12','A18','Economy','mb01',NULL,NULL),('517547161458','akriti singhal',18,'F','2023-04-05','A04','Business','lakshyaji','0430','0300'),('567845673456','rishi joshi',18,'M','2023-04-24','A19','Business','rishij','0430','0300'),('67890456789','suhani',18,'M','2023-04-24','B65','Business','sk00','0430','0300'),('778899556644','Chetan Sharma',30,'M','2022-12-25','A78','Business','ld1009','0430','0300');
/*!40000 ALTER TABLE `im97` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `in98`
--

DROP TABLE IF EXISTS `in98`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `in98` (
  `psg_id` varchar(20) NOT NULL,
  `psg_name` varchar(20) DEFAULT NULL,
  `psg_age` int DEFAULT NULL,
  `psg_gdr` varchar(10) DEFAULT NULL,
  `DOF` date DEFAULT NULL,
  `psg_seat` varchar(10) DEFAULT NULL,
  `seat_class` varchar(15) DEFAULT NULL,
  `user_id` varchar(10) DEFAULT NULL,
  `Dprt_time` varchar(20) DEFAULT NULL,
  `Arvl_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`psg_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `in98`
--

LOCK TABLES `in98` WRITE;
/*!40000 ALTER TABLE `in98` DISABLE KEYS */;
INSERT INTO `in98` VALUES ('123345','avi',12,'M','2023-02-22','C40','Business','',NULL,NULL),('445566998877','Arnav Dubey',19,'M','2022-12-04','A86','Business','ld1009','0630','0445');
/*!40000 ALTER TABLE `in98` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-29 23:52:22
