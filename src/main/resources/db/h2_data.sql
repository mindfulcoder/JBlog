insert  into `jdbc_test`(`type`,`name`) values ('com.zaxxer.hikari.HikariDataSource','hikari数据源');
insert  into `jdbc_test`(`type`,`name`) values ('org.apache.commons.dbcp2.BasicDataSource','dbcp2数据源');
insert  into `jdbc_test`(`type`,`name`) values ('test','测试类');
insert  into `jdbc_test`(`type`,`name`) values ('类别2','测试类2');

insert  into `tb_blog`(`blog_id`,`blog_title`,`blog_sub_url`,`blog_cover_image`,`blog_content`,`blog_category_id`,`blog_category_name`,`blog_tags`,`blog_status`,`blog_views`,`enable_comment`,`is_deleted`,`create_time`,`update_time`) values (1,'我是十三','about','/admin/dist/img/rand/33.jpg','## About me\n\n我是一名Java开发者，技术一般，经历平平，但是也一直渴望进步，同时也努力活着，为了人生不留遗憾，也希望能够一直做着自己喜欢的事情，得闲时分享心得、分享一些浅薄的经验，等以后老得不能再老了，就说故事已经讲完了,不去奢求圆满。',20,'About','世界上有一个很可爱的人,现在这个人就在看这句话',1,219,0,0,'2017-03-12 00:31:15','2018-11-12 00:31:15');

insert  into `tb_blog_category`(`category_id`,`category_name`,`category_icon`,`category_rank`,`is_deleted`,`create_time`) values (20,'About','/admin/dist/img/category/10.png',8,0,'2018-11-12 00:28:49');
insert  into `tb_blog_category`(`category_id`,`category_name`,`category_icon`,`category_rank`,`is_deleted`,`create_time`) values (22,'SSM整合进阶篇','/admin/dist/img/category/02.png',19,0,'2018-11-12 10:42:25');
insert  into `tb_blog_category`(`category_id`,`category_name`,`category_icon`,`category_rank`,`is_deleted`,`create_time`) values (24,'日常随笔','/admin/dist/img/category/06.png',22,0,'2018-11-12 10:43:21');

insert  into `tb_blog_comment`(`comment_id`,`blog_id`,`commentator`,`email`,`website_url`,`comment_body`,`comment_create_time`,`commentator_ip`,`reply_body`,`reply_create_time`,`comment_status`,`is_deleted`) values (26,4,'十三','224683568@qq.com','','第一条评论','2019-05-13 10:12:19','','','2019-05-12 21:13:31',1,0);

insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (57,'世界上有一个很可爱的人',0,'2018-11-12 00:31:15');
insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (58,'现在这个人就在看这句话',0,'2018-11-12 00:31:15');
insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (66,'Spring',0,'2018-11-12 10:55:14');
insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (67,'SpringMVC',0,'2018-11-12 10:55:14');
insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (68,'MyBatis',0,'2018-11-12 10:55:14');
insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (69,'easyUI',0,'2018-11-12 10:55:14');
insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (127,'目录',0,'2019-04-24 15:41:39');
insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (128,'AdminLte3',0,'2019-04-24 15:46:16');
insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (130,'SpringBoot',0,'2019-05-13 09:58:54');
insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (131,'入门教程',0,'2019-05-13 09:58:54');
insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (132,'实战教程',0,'2019-05-13 09:58:54');
insert  into `tb_blog_tag`(`tag_id`,`tag_name`,`is_deleted`,`create_time`) values (133,'spring-boot企业级开发',0,'2019-05-13 09:58:54');

insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (266,1,57,'2019-05-13 09:45:42');
insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (267,1,58,'2019-05-13 09:45:42');
insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (269,2,127,'2019-05-13 09:56:49');
insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (270,4,130,'2019-05-13 09:58:54');
insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (271,4,131,'2019-05-13 09:58:54');
insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (272,4,132,'2019-05-13 09:58:54');
insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (273,4,133,'2019-05-13 09:58:54');
insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (274,3,66,'2019-05-13 10:07:27');
insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (275,3,67,'2019-05-13 10:07:27');
insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (276,3,68,'2019-05-13 10:07:27');
insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (277,3,69,'2019-05-13 10:07:27');
insert  into `tb_blog_tag_relation`(`relation_id`,`blog_id`,`tag_id`,`create_time`) values (278,3,128,'2019-05-13 10:07:27');


insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('footerAbout','your personal blog. have fun.','2018-11-11 20:33:23','2018-11-12 11:58:06');
insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('footerCopyRight','2019 十三','2018-11-11 20:33:31','2018-11-12 11:58:06');
insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('footerICP','浙ICP备17008806号-3','2018-11-11 20:33:27','2018-11-12 11:58:06');
insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('footerPoweredBy','https://github.com/ZHENFENG13','2018-11-11 20:33:36','2018-11-12 11:58:06');
insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('footerPoweredByURL','https://github.com/ZHENFENG13','2018-11-11 20:33:39','2018-11-12 11:58:06');
insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('websiteDescription','personal blog是SpringBoot2+Thymeleaf+Mybatis建造的个人博客网站.SpringBoot实战博客源码.个人博客搭建','2018-11-11 20:33:04','2018-11-11 22:05:14');
insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('websiteIcon','/admin/dist/img/favicon.png','2018-11-11 20:33:11','2018-11-11 22:05:14');
insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('websiteLogo','/admin/dist/img/logo2.png','2018-11-11 20:33:08','2018-11-11 22:05:14');
insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('websiteName','personal blog','2018-11-11 20:33:01','2018-11-11 22:05:14');
insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('yourAvatar','/admin/dist/img/13.png','2018-11-11 20:33:14','2019-05-07 21:56:23');
insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('yourEmail','2449207463@qq.com','2018-11-11 20:33:17','2019-05-07 21:56:23');
insert  into `tb_config`(`config_name`,`config_value`,`create_time`,`update_time`) values ('yourName','13','2018-11-11 20:33:20','2019-05-07 21:56:23');

insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (1,0,'tqr','rqwe','rqw',0,1,'2018-10-22 18:57:52');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (2,2,'十三的GitHub','https://github.com/ZHENFENG13','十三分享代码的地方',1,0,'2018-10-22 19:41:04');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (3,2,'十三的博客','http://13blog.site','个人独立博客13blog',14,0,'2018-10-22 19:53:34');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (4,1,'CSDN 图文课','https://gitchat.csdn.net','IT优质内容平台',6,0,'2018-10-22 19:55:55');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (5,2,'十三的博客园','https://www.cnblogs.com/han-1034683568','最开始写博客的地方',17,0,'2018-10-22 19:56:14');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (6,1,'CSDN','https://www.csdn.net/','CSDN-专业IT技术社区官网',4,0,'2018-10-22 19:56:47');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (7,0,'梁桂钊的博客','http://blog.720ui.com','后端攻城狮',1,0,'2018-10-22 20:01:38');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (8,0,'猿天地','http://cxytiandi.com','一个综合性的网站,以程序猿用户为主,提供各种开发相关的内容',12,0,'2018-10-22 20:02:41');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (9,0,'Giraffe Home','https://yemengying.com/','Giraffe Home',0,0,'2018-10-22 20:27:04');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (10,0,'纯洁的微笑','http://www.ityouknow.com','分享技术，分享生活',3,0,'2018-10-22 20:27:16');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (11,0,'afsdf','http://localhost:28080/admin/links','fad',0,1,'2018-10-22 20:27:26');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (12,1,'afsdf','http://localhost','fad1',0,1,'2018-10-24 14:04:18');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (13,0,'郭赵晖','http://guozh.net/','老郭三分地',0,0,'2019-04-24 15:30:19');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (14,0,'dalaoyang','https://www.dalaoyang.cn/','dalaoyang',0,0,'2019-04-24 15:31:50');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (15,0,'mushblog','https://www.sansani.cn','穆世明博客',0,0,'2019-04-24 15:32:19');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (16,1,'实验楼','https://www.shiyanlou.com/','一家专注于IT技术的在线实训平台',17,0,'2019-04-24 16:03:48');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (17,2,'《SSM 搭建精美实用的管理系统》','https://gitbook.cn/gitchat/column/5b4dae389bcda53d07056bc9','Spring+SpringMVC+MyBatis实战课程',18,0,'2019-04-24 16:06:52');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (18,2,'《Spring Boot 入门及前后端分离项目实践》','https://www.shiyanlou.com/courses/1244','SpringBoot实战课程',19,0,'2019-04-24 16:07:27');
insert  into `tb_link`(`link_id`,`link_type`,`link_name`,`link_url`,`link_description`,`link_rank`,`is_deleted`,`create_time`) values (19,2,'《玩转Spring Boot 系列》','https://www.shiyanlou.com/courses/1274','SpringBoot实战课程',20,0,'2019-04-24 16:10:30');

insert  into `tb_test`(`id`,`test_info`) values (1,'SpringBoot-MyBatis测试');

insert into user_detail(username, nick_name, email, phone) values ('admin', 'admin', '', '');