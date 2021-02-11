/*
SQLyog Ultimate v9.63 
MySQL - 5.5.5-10.3.16-MariaDB : Database - mutante2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mutante2` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `mutante2`;

/*Table structure for table `mutante` */

DROP TABLE IF EXISTS `mutante`;

CREATE TABLE `mutante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dna` tinyblob DEFAULT NULL,
  `mutacion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `mutante` */

insert  into `mutante`(`id`,`apellido`,`dna`,`mutacion`,`nombre`) values (1,'Lara','¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0ATGCGAt\0CAGTGCt\0TTATGTt\0AGAAGGt\0CCCCTAt\0TCACTG','mutante','Sofia'),(2,'Paredes','¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0GTGCAAt\0CAGTGCt\0TTATGTt\0AGAAGGt\0CCTCTAt\0TTATTG','normal','Armando'),(3,'Dohmen','¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0GTGCAAt\0CAGTGCt\0TTATGTt\0AGAAGGt\0CCCCTAt\0TTTTTG','mutante','Sabrina'),(4,'Honguito','¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0ATGTGAt\0CAGTTCt\0TTAGGTt\0AGAAGGt\0CCACTGt\0TGTTTG','mutante','Pepe'),(6,'Ramos','¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0GTGCGAt\0CAGTGCt\0TTATGTt\0AGAAGGt\0CCCCTAt\0TTATTG','mutante','Laura'),(7,'Rodriguez','¬í\0ur\0[Ljava.lang.String;­ÒVçé{G\0\0xp\0\0\0t\0TTGCAGt\0CAGTGCt\0TTATGTt\0AGAAGGt\0ACTCTAt\0TTATTG','normal','Gerardo');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
