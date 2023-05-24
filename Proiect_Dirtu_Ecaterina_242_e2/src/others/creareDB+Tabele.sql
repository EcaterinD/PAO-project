CREATE DATABASE `pao`;


CREATE TABLE `meniu` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pret` float(5,2) DEFAULT NULL,
  `timpPreparare` int DEFAULT NULL,
  `gramaj` int DEFAULT NULL,
  `tipSandwich` varchar(30) DEFAULT NULL,
  `nrSuplimente` int DEFAULT NULL,
  `cantitateCartofi` int DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `desert` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pret` float(5,2) DEFAULT NULL,
  `timpPreparare` int DEFAULT NULL,
  `gramaj` int DEFAULT NULL,
  `tipDesert` varchar(30) DEFAULT NULL,
  `aroma` varchar(30) DEFAULT NULL,
  `topping` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `bautura` (
  `id` int NOT NULL AUTO_INCREMENT,
  `pret` float(5,2) DEFAULT NULL,
  `eCaldaRece` varchar(5) DEFAULT NULL,
  `denumire` varchar(30) DEFAULT NULL,
  `dimensiune` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `cumparator` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nume` varchar(30) DEFAULT NULL,
  `varsta` int DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `ntTel` varchar(15) DEFAULT NULL,
  `adresa` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `comanda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cumparatorId` int DEFAULT NULL,
  `meniuId` int DEFAULT NULL,
  `desertId` int DEFAULT NULL,
  `bauturaId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cumparatorId` (`cumparatorId`),
  KEY `meniuId` (`meniuId`),
  KEY `desertId` (`desertId`),
  KEY `bauturaId` (`bauturaId`),
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`cumparatorId`) REFERENCES `cumparator` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_ibfk_2` FOREIGN KEY (`meniuId`) REFERENCES `meniu` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_ibfk_3` FOREIGN KEY (`desertId`) REFERENCES `desert` (`id`) ON DELETE CASCADE,
  CONSTRAINT `order_ibfk_4` FOREIGN KEY (`bauturaId`) REFERENCES `bautura` (`id`) ON DELETE CASCADE
);