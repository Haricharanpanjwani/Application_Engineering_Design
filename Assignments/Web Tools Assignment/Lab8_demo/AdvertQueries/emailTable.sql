CREATE TABLE `emailtable` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `emailId` varchar(225) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_email_user` FOREIGN KEY (`id`) REFERENCES `usertable` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;