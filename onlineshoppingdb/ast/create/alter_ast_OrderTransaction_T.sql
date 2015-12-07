

ALTER TABLE `ast_OrderTransaction_T` ADD CONSTRAINT FOREIGN KEY (`orderId`) REFERENCES `ast_OrderMain_T`(`orderId`);

