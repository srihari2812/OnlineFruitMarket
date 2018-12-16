/* Creating database*/
CREATE DATABASE `myproject`; /* !40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */

/* Creating retailers table*/
CREATE TABLE `retailers` (
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `pan` varchar(45) NOT NULL,
  `wallet` int(10) DEFAULT NULL,
  `scount` int(7) DEFAULT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `PAN_UNIQUE` (`pan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/* Creating shoppers table*/
CREATE TABLE `shoppers` (
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `pan` varchar(45) NOT NULL,
  `wallet` int(10) DEFAULT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `PAN_UNIQUE` (`pan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/* Creating stores table*/
CREATE TABLE `stores` (
  `email`  varchar(45) NOT NULL,
  `name`   varchar(45) NOT NULL,
  `description` varchar(200),
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`email`),
  FOREIGN KEY (`email`) REFERENCES `retailers` (`email`)
);

/* Creating fruits table */
CREATE TABLE `fruits` (
  `email`  varchar(45) NOT NULL,
  `banana_price` int(3) NOT NULL,
  `banana_quantity` int(10) NOT NULL,
  `apple_price` int(3) NOT NULL,
  `apple_quantity` int(10) NOT NULL,
  `watermelon_price` int(3) NOT NULL,
  `watermelon_quantity` int(10) NOT NULL,
  `orange_price` int(3) NOT NULL,
  `orange_quantity` int(10) NOT NULL,
  `papaya_price` int(3) NOT NULL,
  `papaya_quantity` int(10) NOT NULL,
  `pineapple_price` int(3) NOT NULL,
  `pineapple_quantity` int(10) NOT NULL,
  `mango_price` int(3) NOT NULL,
  `mango_quantity` int(10) NOT NULL,
  `pomegranate_price` int(3) NOT NULL,
  `pomegranate_quantity` int(10) NOT NULL,
  `guava_price` int(3) NOT NULL,
  `guava_quantity` int(10) NOT NULL,
  PRIMARY KEY (`email`),
  FOREIGN KEY (`email`) REFERENCES `retailers` (`email`)
);


/* Creating transaction table*/
CREATE TABLE `transaction` (
  `remail`  varchar(45) NOT NULL,
  `semail`  varchar(45) NOT NULL,  
  `amount` int(10) NOT NULL,
  `date` date NOT NULL,
  `description` varchar(45),
  PRIMARY KEY (`remail`,`semail`)
);

/* Commit the changes*/
commit;