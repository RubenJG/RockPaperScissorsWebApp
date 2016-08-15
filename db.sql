/*

This is the sql script that creates the tables needed in the database
for this application to work properly.

The database and user are always needed, but the table can also be
automatically created by the application depending on the contents
of the application.properties file

*/

create database rps;

grant all on rps.* to 'rps' identified by 'rps2016!#';

use rps;

CREATE TABLE `dbplayer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `score` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_t78yt3rgpvsq2wka6dqkq9xq3` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
