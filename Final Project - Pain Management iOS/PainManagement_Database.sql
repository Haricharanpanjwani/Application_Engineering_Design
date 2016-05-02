create database PainManagement;

use PainManagement;
-- MySQL dump 10.13  Distrib 5.7.9, for osx10.9 (x86_64)
--
-- Host: localhost    Database: smartphone
-- ------------------------------------------------------
-- Server version	5.7.9

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
-- Table structure for table `ACTIONFEEDBACK`
--

DROP TABLE IF EXISTS `ACTIONFEEDBACK`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ACTIONFEEDBACK` (
  `ACTIONID` varchar(255) NOT NULL,
  `USERID` int(11) DEFAULT NULL,
  `PROGRAMID` int(11) DEFAULT NULL,
  `ANSWERVALUE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ACTIONID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACTIONFEEDBACK`
--

LOCK TABLES `ACTIONFEEDBACK` WRITE;
/*!40000 ALTER TABLE `ACTIONFEEDBACK` DISABLE KEYS */;
INSERT INTO `ACTIONFEEDBACK` VALUES ('0',0,0,'good'),('12015-11-09T22:47:47.899',1,0,'Satisfied'),('12015-11-10T18:35:36.268',1,2,'Satisfied'),('12015-11-10T19:36:07.302',1,2,'Satisfied'),('12015-11-10T19:39:14.105',1,2,'Normal');
/*!40000 ALTER TABLE `ACTIONFEEDBACK` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ANSWERINSTRUCTION`
--

DROP TABLE IF EXISTS `ANSWERINSTRUCTION`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ANSWERINSTRUCTION` (
  `INSTRUCTIONID` int(11) NOT NULL,
  `ANSWERID` int(11) DEFAULT NULL,
  `INSTRUCTIONDETAIL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`INSTRUCTIONID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ANSWERINSTRUCTION`
--

LOCK TABLES `ANSWERINSTRUCTION` WRITE;
/*!40000 ALTER TABLE `ANSWERINSTRUCTION` DISABLE KEYS */;
INSERT INTO `ANSWERINSTRUCTION` VALUES (0,0,'No pain'),(1,0,'Worst pain imaginable'),(2,1,'Not at all confident'),(3,1,'Completely confident'),(4,2,'I’m in the worst mood'),(5,2,'My mood is excellent'),(6,3,'All of the time'),(7,3,'Most of the time'),(8,3,'Some of the time'),(9,3,'A little of the time'),(10,3,'None of the time'),(11,4,'Worst sleep imaginable'),(12,4,'My sleep was excellent'),(13,5,'Not at all'),(14,5,'1-5 days'),(15,5,'6 -12 days'),(16,5,'13 - 14 days');
/*!40000 ALTER TABLE `ANSWERINSTRUCTION` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ANSWERS`
--

DROP TABLE IF EXISTS `ANSWERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ANSWERS` (
  `ANSWERID` int(11) NOT NULL,
  `ANSWERTYPE` varchar(255) DEFAULT NULL,
  `ANSWERDETAIL` int(11) DEFAULT NULL,
  PRIMARY KEY (`ANSWERID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ANSWERS`
--

LOCK TABLES `ANSWERS` WRITE;
/*!40000 ALTER TABLE `ANSWERS` DISABLE KEYS */;
INSERT INTO `ANSWERS` VALUES (0,'int',10),(1,'int',6),(2,'int',10),(3,'String',5),(4,'int',10),(5,'String',4);
/*!40000 ALTER TABLE `ANSWERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `COMMENTMODEL`
--

DROP TABLE IF EXISTS `COMMENTMODEL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `COMMENTMODEL` (
  `USERID` int(11) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `COMMENT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `COMMENTMODEL`
--

LOCK TABLES `COMMENTMODEL` WRITE;
/*!40000 ALTER TABLE `COMMENTMODEL` DISABLE KEYS */;
INSERT INTO `COMMENTMODEL` VALUES (0,'admin','feeling better');
/*!40000 ALTER TABLE `COMMENTMODEL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DOCTORPROFILE`
--

DROP TABLE IF EXISTS `DOCTORPROFILE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DOCTORPROFILE` (
  `DOCTORID` int(11) NOT NULL,
  `EMAILID` varchar(255) DEFAULT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `PHONENUM` varchar(255) DEFAULT NULL,
  `SPECIALIST` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`DOCTORID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DOCTORPROFILE`
--

LOCK TABLES `DOCTORPROFILE` WRITE;
/*!40000 ALTER TABLE `DOCTORPROFILE` DISABLE KEYS */;
INSERT INTO `DOCTORPROFILE` VALUES (0,'lobo@gmail.com','Mary','Lobo','6170981234','Pain'),(1,'stella@yahoo.com','Stella','Lobo','6170981234','Pain');
/*!40000 ALTER TABLE `DOCTORPROFILE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MAINCATEGORY`
--

DROP TABLE IF EXISTS `MAINCATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MAINCATEGORY` (
  `CATEGRYID` int(11) NOT NULL,
  `CATEGORYNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CATEGRYID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MAINCATEGORY`
--

LOCK TABLES `MAINCATEGORY` WRITE;
/*!40000 ALTER TABLE `MAINCATEGORY` DISABLE KEYS */;
INSERT INTO `MAINCATEGORY` VALUES (0,'Food as Medicine'),(1,'Medical Tool Box'),(2,'Mind Body Techniques'),(3,'Move My Body'),(4,'Self-Care');
/*!40000 ALTER TABLE `MAINCATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MEDICINEANDPATIENT`
--

DROP TABLE IF EXISTS `MEDICINEANDPATIENT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MEDICINEANDPATIENT` (
  `MPID` int(11) NOT NULL,
  `USERID` int(11) DEFAULT NULL,
  `MEDICINEID` int(11) DEFAULT NULL,
  `MEDICINEDES` varchar(255) DEFAULT NULL,
  `MEDICINENAME` varchar(255) DEFAULT NULL,
  `QUATITY` int(11) DEFAULT NULL,
  `MDPERTIME` float DEFAULT NULL,
  `MAXQUATITY` int(11) DEFAULT NULL,
  PRIMARY KEY (`MPID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MEDICINEANDPATIENT`
--

LOCK TABLES `MEDICINEANDPATIENT` WRITE;
/*!40000 ALTER TABLE `MEDICINEANDPATIENT` DISABLE KEYS */;
INSERT INTO `MEDICINEANDPATIENT` VALUES (0,0,1,'pain relief','Combiflame',12,1,2),(1,1,123,'Stress relief','Aspirin',10,1,4);
/*!40000 ALTER TABLE `MEDICINEANDPATIENT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MEDICINEFEEDBACKMODEL`
--

DROP TABLE IF EXISTS `MEDICINEFEEDBACKMODEL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MEDICINEFEEDBACKMODEL` (
  `MPID` int(11) NOT NULL,
  `DATE` varchar(255) DEFAULT NULL,
  `TIMESTAMP` varchar(255) NOT NULL,
  `MHISTORY` varchar(255) DEFAULT NULL,
  `TOTALAMOUNT` int(11) DEFAULT NULL,
  PRIMARY KEY (`TIMESTAMP`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MEDICINEFEEDBACKMODEL`
--

LOCK TABLES `MEDICINEFEEDBACKMODEL` WRITE;
/*!40000 ALTER TABLE `MEDICINEFEEDBACKMODEL` DISABLE KEYS */;
INSERT INTO `MEDICINEFEEDBACKMODEL` VALUES (0,NULL,'',NULL,NULL),(1,'2015-11-09T22:42:03.124','12015-11-09T22:42:03.124','history',1),(1,'2015-11-10T18:21:33.561','12015-11-10','history',1),(1,'2015-11-10T18:14:19.258','12015-11-10T18:14:19.258','history',1),(1,'2015-11-10T18:17:53.349','12015-11-10T18:17:53.349','history',1),(1,'2015-11-10','12015-11-10T18:23:13.914','historyhistoryhistoryhistoryhistory',4),(1,'2015-11-21','12015-11-21T10:32:03.786','historyhistoryhistoryhistoryhistory',4);
/*!40000 ALTER TABLE `MEDICINEFEEDBACKMODEL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAINCATEGORY`
--

DROP TABLE IF EXISTS `PAINCATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PAINCATEGORY` (
  `PAINID` int(11) NOT NULL,
  `PAINNAME` varchar(255) DEFAULT NULL,
  `DES` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PAINID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAINCATEGORY`
--

LOCK TABLES `PAINCATEGORY` WRITE;
/*!40000 ALTER TABLE `PAINCATEGORY` DISABLE KEYS */;
/*!40000 ALTER TABLE `PAINCATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PATIENTPROFILE`
--

DROP TABLE IF EXISTS `PATIENTPROFILE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PATIENTPROFILE` (
  `USERID` int(11) NOT NULL,
  `FIRSTNAME` varchar(255) DEFAULT NULL,
  `LASTNAME` varchar(255) DEFAULT NULL,
  `GENDER` varchar(255) DEFAULT NULL,
  `DATE` varchar(255) DEFAULT NULL,
  `HEALTHCONDITION` varchar(255) DEFAULT NULL,
  `ISPRESCRIBED` varchar(255) DEFAULT NULL,
  `LANGUAGE` varchar(255) DEFAULT NULL,
  `ENTHNONYM` varchar(255) DEFAULT NULL,
  `ENTHNICITY` varchar(255) DEFAULT NULL,
  `LASTGRADESCHOOL` varchar(255) DEFAULT NULL,
  `CURRENTLYWORKING` varchar(255) DEFAULT NULL,
  `FEET` int(11) DEFAULT NULL,
  `INCHES` int(11) DEFAULT NULL,
  `WEIGHT` int(11) DEFAULT NULL,
  `DOCTORID` int(11) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PATIENTPROFILE`
--

LOCK TABLES `PATIENTPROFILE` WRITE;
/*!40000 ALTER TABLE `PATIENTPROFILE` DISABLE KEYS */;
INSERT INTO `PATIENTPROFILE` VALUES (0,'Admin',NULL,'M',NULL,'Normal',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(1,'Priya','priya','F','2005-10-11','Normal','YES','Japan','Latin','None','Boston','No',5,5,50,1),(2,'Lihui','Zhou','Male','10/23/2015',NULL,NULL,'Chinese','No','Asian',NULL,'YES',6,7,0,1),(3,'Lihui','Zhou','Male','08/23/2015',NULL,NULL,'Chinese','No','Asian',NULL,'NO',5,8,0,1),(4,'neu','neu','Femal','05/23/2014',NULL,NULL,'English','Hispanic','Latin',NULL,'YES',5,4,120,0);
/*!40000 ALTER TABLE `PATIENTPROFILE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PROGRAMDETAILS`
--

DROP TABLE IF EXISTS `PROGRAMDETAILS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PROGRAMDETAILS` (
  `PROGRAMID` int(11) NOT NULL,
  `PROGRAMNAME` varchar(255) DEFAULT NULL,
  `PROGRAMDETAIL` tinyblob,
  `PROGRAMURL` varchar(255) DEFAULT NULL,
  `SUBCATEGORY` int(11) DEFAULT NULL,
  `PROGRAMTYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PROGRAMID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PROGRAMDETAILS`
--

LOCK TABLES `PROGRAMDETAILS` WRITE;
/*!40000 ALTER TABLE `PROGRAMDETAILS` DISABLE KEYS */;
INSERT INTO `PROGRAMDETAILS` VALUES (0,'Introduction to Fiber, Antioxidants, and Snack Foods','The document gives information about healthy eating, which fibrous food should be taken, which foods high in antioxdidant should be taken  and which foods should be avoided. Also it gives tips regarding healthy eating.\n','https://www.youtube.com/watch?v=D4EOMPgjlII',0,'Document'),(1,'Food Guide',NULL,'https://www.youtube.com/watch?v=D4EOMPgjlII',1,'Document'),(2,'Safety measures before taking Herbal Supplements','The document gives information about what precautions and safety measures should be taken before consuming any kind of Herbal Suplements\n','https://www.youtube.com/watch?v=D4EOMPgjlII',2,'Document'),(3,'Advantages of Omega-3','The document gives tips on which foods are high in omega-3 fatty acids and the importance of comsuming food rich with omega-3\n',NULL,3,'Document'),(4,'Vitamins & Minerals','The video explains about how minerals and vitamins help us. Also tells us about which foods are rich in minarals and vitamins\n',NULL,4,'Video'),(5,'Tea',NULL,NULL,5,'Document'),(6,'Water','The document tells us about importance of water and how we can increase the consumption of water.\n',NULL,5,'Document'),(7,'Take a Prescription Medication',NULL,NULL,6,NULL),(8,'Take an Over-the-Counter Medication',NULL,NULL,7,NULL),(9,'What other medications are you taking?',NULL,NULL,8,NULL),(10,'Body Scan','This audio describes meditation to enhance mindfulness. It relaxes the body and soothes your senses\n',NULL,9,'Audio'),(11,'Gentle Yoga','This audio explains gentle yoga. It releases the body\'s most deeply embedded tensions. This is accomplished through carefully sequenced, well-supported, and precisely aligned postures which are designed to unravel spinal tension.',NULL,10,'Audio'),(12,'Loving Kindness Meditation','This meditation invokes loving kindness and friendliness toward oneself and others. With each recitation of the phrases, an intention of planting the seeds of loving wishes over and over in our heart is expressed.\n',NULL,11,'Audio'),(13,'Meditation','The video says about the meditation techniques and how it can be used.\n',NULL,12,'Audio'),(14,'Relaxing Music1','Soothes and relaxes mind\n',NULL,13,'Audio'),(15,'Relaxing Music2','Soothes and relaxes mind\n',NULL,13,'Audio'),(16,'Relaxing Music3','Soothes and relaxes mind\n',NULL,13,'Audio'),(17,'Relaxing Music4','Soothes and relaxes mind\n',NULL,13,'Audio'),(18,'Relaxing Music5','Soothes and relaxes mind\n',NULL,13,'Audio'),(19,'Relaxing Music6','Soothes and relaxes mind\n',NULL,13,'Audio'),(20,'Relaxing Music7','Soothes and relaxes mind\n',NULL,13,'Audio'),(21,'Relaxing Music8','Soothes and relaxes mind\n',NULL,13,'Audio'),(22,'Relaxing Music9','Soothes and relaxes mind\n',NULL,13,'Audio'),(23,'Relaxing Music10','Soothes and relaxes mind\n',NULL,13,'Audio'),(24,'Relaxing Music11','Soothes and relaxes mind\n',NULL,13,'Audio'),(25,'Relaxing Music12','Soothes and relaxes mind\n',NULL,13,'Audio'),(26,'Relaxing Music13','Soothes and relaxes mind\n',NULL,13,'Audio'),(27,'Introduction To Yoga','This video shows how yoga can be done in a peasceful and relaxing manner. This helps realease the stress and tension which we inhibit in us\n',NULL,14,'Video'),(28,'Physical Activity','Physical activity can help reduce your risk for several diseases and health conditions and improve your overall quality of life. Regular physical activity can help protect from health problems such as heart disease, blood pressure, diabetes and so on.',NULL,15,'Document'),(29,'The FITT Equation','FITT equation: FITT stands for Frequency, Intensity, Time and Type. This principle is used to guide the development of unique and bespoke fitness plans that cater for an individual\'s specific needs.\n',NULL,16,'Document'),(30,'Introduction_To_Acupressure','This video tells about what is used for accupressure. Also it gives a good idea about the importance of acupressure.\n',NULL,17,'Video'),(31,'Ice & Heat',NULL,NULL,18,'Document'),(32,'Introduction_To_Self-Massage','This video teaches how to massage your body with love and patience for 15-20 minutes. Here are the recommendations for frequency and pressure depending on the type of massage.\n',NULL,19,'Video'),(33,'The_Importance_Of_Healthy_Sleep','This video describes how sleep plays a vital role in good health and well-being throughout your life. Getting enough quality sleep at the right times can help protect your mental health, physical health, quality of life, and safety.\n',NULL,20,'Video');
/*!40000 ALTER TABLE `PROGRAMDETAILS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUESTIONMODEL`
--

DROP TABLE IF EXISTS `QUESTIONMODEL`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QUESTIONMODEL` (
  `FEEDBACKID` varchar(255) NOT NULL,
  `USERID` int(11) DEFAULT NULL,
  `QUESTIONID` int(11) DEFAULT NULL,
  `ANSWERVALUE` varchar(255) DEFAULT NULL,
  `ANSWERTYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`FEEDBACKID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUESTIONMODEL`
--

LOCK TABLES `QUESTIONMODEL` WRITE;
/*!40000 ALTER TABLE `QUESTIONMODEL` DISABLE KEYS */;
INSERT INTO `QUESTIONMODEL` VALUES ('1 2015-11-06T08:55:06.089',1,1,'5','1'),('1 2015-11-06T09:13:55.820',1,1,'6','1'),('1 2015-11-09T19:22:50.182',1,1,'6','1'),('1 2015-11-09T21:47:17.045',1,1,'10','1'),('1 2015-11-09T21:55:54.319',1,1,'5','1'),('1 2015-11-09T22:00:46.051',1,1,'5','1'),('1 2015-11-09T22:02:54.161',1,1,'5','1'),('1 2015-11-09T22:08:00.348',1,1,'5','1'),('1 2015-11-09T22:17:56.928',1,1,'10','1'),('1 2015-11-09T22:39:16.909',1,1,'5','1'),('1 2015-11-09T22:41:54.801',1,1,'5','1'),('1 2015-11-09T22:55:30.581',1,1,'5','1'),('1 2015-11-09T22:56:30.019',1,1,'5','1'),('1 2015-11-09T22:59:01.649',1,1,'6','1'),('1 2015-11-09T23:01:44.631',1,1,'5','1'),('1 2015-11-10T14:54:08.682',1,1,'5','1'),('1 2015-11-10T15:39:16.781',1,1,'5','1'),('1 2015-11-10T15:41:59.749',1,1,'5','1'),('1 2015-11-10T15:49:25.146',1,1,'5','1'),('1 2015-11-10T15:51:28.772',1,1,'5','1'),('1 2015-11-10T17:41:58.950',1,1,'5','1'),('1 2015-11-10T18:13:32.725',1,1,'5','1'),('1 2015-11-10T18:17:30.831',1,1,'5','1'),('1 2015-11-10T18:21:18.820',1,1,'5','1'),('1 2015-11-10T18:23:01.153',1,1,'5','1'),('1 2015-11-10T18:27:59.748',1,1,'5','1'),('1 2015-11-10T18:35:01.218',1,1,'5','1'),('1 2015-11-10T18:39:34.558',1,1,'5','1'),('1 2015-11-10T18:43:04.822',1,1,'5','1'),('1 2015-11-10T18:44:25.660',1,1,'5','1'),('1 2015-11-10T18:47:35.925',1,1,'5','1'),('1 2015-11-10T18:52:52.585',1,1,'5','1'),('1 2015-11-10T18:55:18.306',1,1,'5','1'),('1 2015-11-10T18:56:18.643',1,1,'5','1'),('1 2015-11-10T19:33:31.202',1,1,'7','1'),('1 2015-11-10T20:21:08.639',1,1,'5','1'),('1 2015-11-21T12:00:58.154',1,1,'6','1'),('1 2015-11-21T12:02:49.438',1,1,'5','1'),('1 2015-11-21T12:03:31.862',1,1,'5','1'),('1 2015-11-21T12:13:26.515',1,1,'5','1'),('1 2015-11-21T12:25:58.004',1,1,'5','1'),('1 2015-11-21T12:29:33.746',1,1,'5','1'),('1 2015-11-21T13:37:21.026',1,1,'5','1'),('1 2015-11-21T13:40:24.964',1,1,'5','1'),('1 2015-11-21T13:44:29.786',1,1,'5','1'),('1 2015-11-21T13:47:39.259',1,1,'5','1'),('1 2015-11-21T13:48:58.190',1,1,'5','1'),('1 2015-11-21T13:53:25.875',1,1,'5','1'),('1 2015-11-21T13:55:44.138',1,1,'5','1'),('1 2015-11-21T14:22:41.993',1,1,'5','1'),('1 2015-11-21T14:24:45.191',1,1,'5','1'),('1 2015-11-21T14:28:47.786',1,1,'5','1'),('1 2015-11-21T14:32:15.371',1,1,'5','1'),('1 2015-11-21T14:36:29.880',1,1,'5','1'),('1 2015-11-21T14:45:25.144',1,1,'5','1'),('1 2015-11-21T14:47:42.708',1,1,'5','1'),('1 2015-11-21T14:56:24.045',1,1,'5','1'),('1 2015-11-21T15:03:27.236',1,1,'5','1'),('1 2015-11-21T15:06:31.973',1,1,'5','1'),('1 2015-11-21T15:11:21.165',1,1,'5','1'),('1 2015-11-21T15:12:29.959',1,1,'5','1'),('1 2015-11-21T15:14:21.458',1,1,'5','1'),('1 2015-11-21T15:18:56.701',1,1,'5','1'),('1 2015-11-21T15:26:59.901',1,1,'5','1'),('1 2015-11-21T15:29:04.674',1,1,'5','1'),('1 2015-11-21T15:33:49.625',1,1,'5','1'),('1 2015-11-21T15:35:39.358',1,1,'5','1'),('1 2015-11-21T15:39:02.746',1,1,'5','1'),('1 2015-11-21T16:34:02.309',1,1,'5','1'),('1 2015-11-21T16:34:49.064',1,1,'5','1'),('1 2015-11-21T16:37:14.887',1,1,'5','1'),('1 2015-11-21T19:32:49.203',1,1,'5','1'),('1 2015-11-21T19:36:39.265',1,1,'5','1'),('1 2015-11-21T20:01:52.299',1,1,'5','1'),('1 2015-11-21T20:44:26.633',1,1,'5','1'),('1 2015-11-21T21:17:04.966',1,1,'5','1'),('1 2015-11-21T22:27:17.302',1,1,'5','1'),('1 2015-11-21T22:38:13.130',1,1,'8','1'),('1 2015-11-22T18:26:55.934',1,1,'5','1'),('1 2015-11-23T00:49:46.814',3,1,'5','1'),('1 2015-11-23T01:01:35.060',4,1,'6','1'),('10 2015-11-09T21:49:40.430',1,10,'5','1'),('10 2015-11-09T21:56:12.239',1,10,'3','1'),('11 2015-11-09T21:49:45.028',1,11,'6','1'),('11 2015-11-09T21:56:14.658',1,11,'3','1'),('2 2015-11-09T21:48:44.880',1,2,'6','1'),('2 2015-11-09T21:55:56.802',1,2,'3','1'),('3 2015-11-09T21:48:55.710',1,3,'6','1'),('3 2015-11-09T21:55:58.888',1,3,'3','1'),('4 2015-11-09T21:49:00.359',1,4,'5','1'),('4 2015-11-09T21:56:00.866',1,4,'3','1'),('5 2015-11-09T21:49:04.492',1,5,'6','1'),('5 2015-11-09T21:56:02.939',1,5,'3','1'),('6 2015-11-09T21:49:08.345',1,6,'5','1'),('6 2015-11-09T21:56:05.101',1,6,'3','1'),('7 2015-11-09T21:49:12.315',1,7,'6','1'),('7 2015-11-09T21:56:07.132',1,7,'3','1'),('8 2015-11-09T21:49:23.831',1,8,'5','1'),('8 2015-11-09T21:56:08.591',1,8,'3','1'),('9 2015-11-09T21:49:32.211',1,9,'6','1'),('9 2015-11-09T21:56:10.689',1,9,'3','1');
/*!40000 ALTER TABLE `QUESTIONMODEL` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `QUESTIONS`
--

DROP TABLE IF EXISTS `QUESTIONS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `QUESTIONS` (
  `QUESTIONID` int(11) NOT NULL,
  `ANSWERID` int(11) DEFAULT NULL,
  `QUESTIONDETAIL` varchar(255) DEFAULT NULL,
  `QUESTIONTYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`QUESTIONID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `QUESTIONS`
--

LOCK TABLES `QUESTIONS` WRITE;
/*!40000 ALTER TABLE `QUESTIONS` DISABLE KEYS */;
INSERT INTO `QUESTIONS` VALUES (0,0,'How would you rate your pain today?','Pain'),(1,1,'Please rate how confident you are that you could enjoy things, despite the pain.','Pain'),(2,1,'Please rate how confident you are that you could do most of the household chores (e.g. tidying-up, washing dishes, etc.), despite the pain.','Pain'),(3,1,'Please rate how confident you are that you could socialize with friends or family members as often as you used to do, despite the pain.','Pain'),(4,1,'Please rate how confident you are that you could cope with pain in most situations.','Pain'),(5,1,'Please rate how confident you are that you could do some form of work, despite the pain (“work” includes housework, paid and unpaid work).','Pain'),(6,1,'Please rate how confident you are that you could still do many of the things you enjoy doing, such as hobbies or leisure activity, despite pain.','Pain'),(7,1,'Please rate how confident you are that you could cope your pain without medication.','Pain'),(8,1,'Please rate how confident you are that you could still accomplish most of your goals in life, despite the pain.','Pain'),(9,1,'Please rate how confident you are that you could live a normal lifestyle, despite the pain.','Pain'),(10,1,'Please rate how confident you are that you could gradually become more active, despite the pain.','Pain'),(11,2,'How would you rate your mood today?','Mood'),(12,3,'How much of the time during the past 4 weeks have you felt calm and peaceful?','Mood'),(13,3,'How much of the time during the past 4 weeks have you had a lot of energy?','Mood'),(14,3,'How much of the time during the past 4 weeks have you felt downhearted and depressed?','Mood'),(15,4,'How was your sleep last night?','Sleep'),(16,5,'How often during the past 2 weeks have you had trouble falling asleep, staying asleep, or sleeping too much?','Sleep');
/*!40000 ALTER TABLE `QUESTIONS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SUBCATEGORY`
--

DROP TABLE IF EXISTS `SUBCATEGORY`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `SUBCATEGORY` (
  `SUBCATEGORYID` int(11) NOT NULL,
  `SUBCATEGORYNAME` varchar(255) DEFAULT NULL,
  `CATEGORYID` int(11) DEFAULT NULL,
  PRIMARY KEY (`SUBCATEGORYID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SUBCATEGORY`
--

LOCK TABLES `SUBCATEGORY` WRITE;
/*!40000 ALTER TABLE `SUBCATEGORY` DISABLE KEYS */;
INSERT INTO `SUBCATEGORY` VALUES (0,'Fiber, Antioxidants & Snack Foods',0),(1,'Food Guide',0),(2,'Herbal Supplements',0),(3,'Omega-3 Fatty-Acids',0),(4,'Vitamins & Minerals',0),(5,'Water & Tea',0),(6,'Take a Prescription Medication',1),(7,'Take an Over-the-Counter Medication',1),(8,'What other medications are you taking?',1),(9,'Body Scan',2),(10,'Gentle Yoga',2),(11,'Loving Kindness Meditation',2),(12,'Meditation',2),(13,'Relaxing Music',2),(14,'Gentle Yoga',3),(15,'Physical Activity',3),(16,'The FITT Equation',3),(17,'Acupressure',4),(18,'Ice & Heat',4),(19,'Self-Massage',4),(20,'Sleep',4);
/*!40000 ALTER TABLE `SUBCATEGORY` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERACCOUNT`
--

DROP TABLE IF EXISTS `USERACCOUNT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERACCOUNT` (
  `USERID` int(11) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `USERPASSWORD` varchar(255) DEFAULT NULL,
  `stat` int(11) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERACCOUNT`
--

LOCK TABLES `USERACCOUNT` WRITE;
/*!40000 ALTER TABLE `USERACCOUNT` DISABLE KEYS */;
INSERT INTO `USERACCOUNT` VALUES (0,'admin','admin',1),(1,'priya','priya',1),(2,'zhou','zhou',1),(3,'lihui','lihui',1),(4,'neu','neu',1),(5,'test','123',1);
/*!40000 ALTER TABLE `USERACCOUNT` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERPAINDETAILS`
--

DROP TABLE IF EXISTS `USERPAINDETAILS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERPAINDETAILS` (
  `PAINID` int(11) NOT NULL,
  `USERID` int(11) DEFAULT NULL,
  `DATE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PAINID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERPAINDETAILS`
--

LOCK TABLES `USERPAINDETAILS` WRITE;
/*!40000 ALTER TABLE `USERPAINDETAILS` DISABLE KEYS */;
INSERT INTO `USERPAINDETAILS` VALUES (0,0,NULL),(1,1,NULL);
/*!40000 ALTER TABLE `USERPAINDETAILS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-06 16:05:24
