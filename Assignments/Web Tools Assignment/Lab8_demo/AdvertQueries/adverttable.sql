delimiter $$

CREATE TABLE `adverttable` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `message` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `user` bigint(20) unsigned NOT NULL,
  `category` bigint(20) unsigned NULL,
  PRIMARY KEY (`id`),
  KEY `fk_advert_user` (`user`),
  KEY `fk_advert_category` (`category`),
  CONSTRAINT `fk_advert_user` FOREIGN KEY (`user`) REFERENCES `usertable` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_advert_category` FOREIGN KEY (`category`) REFERENCES `categorytable` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1$$