USE `test`;

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(50) DEFAULT NULL,
  `roleDesc` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

insert  into `sys_role`(`id`,`roleName`,`roleDesc`)
values (1,'院长','负责全面工作'),
       (2,'研究员','课程研发工作'),
       (3,'讲师','授课工作'),
       (4,'助教','协助解决学生的问题');

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `phoneNum` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

insert  into `sys_user`(`id`,`username`,`email`,`password`,`phoneNum`)
values (1,'zhangsan','zhangsan@itcast.cn','123','13888888888'),
       (2,'lisi','lisi@itcast.cn','123','13999999999'),
       (3,'wangwu','wangwu@itcast.cn','123','18599999999');

DROP TABLE IF EXISTS `sys_user_role`;

CREATE TABLE `sys_user_role` (
  `userId` bigint(20) NOT NULL,
  `roleId` bigint(20) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `sys_user_role_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `sys_user_role_ibfk_2` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `sys_user_role`(`userId`,`roleId`)
values (1,1),(1,2),(2,2),(2,3);

use test;

select * from sys_user_role ur, sys_role r where ur.roleId = r.id and ur.userId = 1;

