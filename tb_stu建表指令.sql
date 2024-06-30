CREATE DATABASE haoqiEdu;

CREATE TABLE `tb_stu` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `name` varchar(10) NOT NULL COMMENT '学员姓名',
  `tel_num` varchar(11) DEFAULT NULL COMMENT '电话号码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='学员管理表'


INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaoming', 123456, '小明',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaowang', 123456, '小王',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaogang', 123456, '小刚',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaohong', 123456, '小红',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaolv', 123456, '小绿',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaohuang', 123456, '小黃',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaohei', 123456, '小黑',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaobai', 123456, '小白',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaochi', 123456, '小赤',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaocheng', 123456, '小橙',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaoqing', 123456, '小青',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaolan', 123456, '小蓝',12345678891);
INSERT INTO tb_stu (username, password, name,tel_num)
VALUES ('xiaozi', 123456, '小紫',12345678891);


CREATE TABLE `tb_teacher` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL COMMENT '教师姓名',
  `salary` int NOT NULL COMMENT '教师工资',
  `age` int DEFAULT NULL COMMENT '教师年龄',
  `sex` int DEFAULT '1' COMMENT '教师性别1-男 2-女',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='讲师管理表'

INSERT into tb_teacher(name, salary, age, sex)
VALUES('王老师',4000,32,1);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('张老师',3000,48,2);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('李老师',2000,37,1);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('赵老师',1000,42,2);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('孙老师',5000,29,1);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('钱老师',6000,35,2);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('聂老师',7000,66,1);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('周老师',8000,43,1);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('吴老师',4000,33,2);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('郑老师',3000,34,2);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('余老师',5000,31,2);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('魏老师',6000,36,2);
INSERT into tb_teacher(name, salary, age, sex)
VALUES('杨老师',4000,52,2);


CREATE TABLE `tb_company` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '企业id',
  `name` varchar(20) NOT NULL COMMENT '企业名称',
  `flag` int NOT NULL DEFAULT '0' COMMENT '认证状态1-已认证0-未认证',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='企业信息管理'

insert into tb_company(name, flag) values ('华为',0);
insert into tb_company(name, flag) values ('中兴',0);
insert into tb_company(name, flag) values ('电信',0);
insert into tb_company(name, flag) values ('移动',0);
insert into tb_company(name, flag) values ('联通',0);
insert into tb_company(name, flag) values ('哈工大',0);
insert into tb_company(name, flag) values ('百度',0);
insert into tb_company(name, flag) values ('阿里',0);
insert into tb_company(name, flag) values ('腾讯',0);
insert into tb_company(name, flag) values ('美团',0);
insert into tb_company(name, flag) values ('饿了么',0);
insert into tb_company(name, flag) values ('网易',0);
insert into tb_company(name, flag) values ('字节',0);



CREATE TABLE `tb_trainapp` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL COMMENT '申请项目名',
  `company_id` int NOT NULL COMMENT '申请公司id',
  `start_date` date NOT NULL COMMENT '开始日期',
  `end_date` date NOT NULL COMMENT '结束日期',
  PRIMARY KEY (`id`),
  KEY `train_company_fk` (`company_id`),
  CONSTRAINT `train_company_fk` FOREIGN KEY (`company_id`) REFERENCES `tb_company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='培训申请表'

INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目1',1,'2024-01-01','2024-01-07');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目2',1,'2024-02-01','2024-02-14');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目3',2,'2024-05-11','2024-05-22');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目4',3,'2021-01-01','2021-01-02');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目5',5,'2021-01-01','2021-01-02');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目6',6,'2021-01-01','2021-01-02');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目7',7,'2021-01-01','2021-01-02');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目8',8,'2021-01-01','2021-01-02');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目9',9,'2021-01-01','2021-01-02');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目10',10,'2021-01-01','2021-01-02');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目13',13,'2021-01-01','2021-01-02');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目14',14,'2021-01-01','2021-01-02');
INSERT INTO tb_trainapp(name, company_id, start_date, end_date)
VALUES('培训项目15',15,'2021-01-01','2021-01-02');

CREATE TABLE `tb_course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL COMMENT '课程名称',
  `teacher_id` int NOT NULL COMMENT '讲师id',
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `course_teacher___fk` (`teacher_id`),
  CONSTRAINT `course_teacher___fk` FOREIGN KEY (`teacher_id`) REFERENCES `tb_teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='课程表'

