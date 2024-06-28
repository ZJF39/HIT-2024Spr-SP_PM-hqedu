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