DROP TABLE IF EXISTS `ast_Cart_T`;

CREATE TABLE `ast_Cart_T` ( `cartId` VARCHAR(256) NOT NULL, `itemId` VARCHAR(256) NOT NULL, `quantity` INT(10) NOT NULL, `itemUnitPrice` DOUBLE(10,2) NULL DEFAULT NULL, `itemSubTotal` DOUBLE(10,2) NULL DEFAULT NULL, `userId` VARCHAR(64) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`cartId`));

