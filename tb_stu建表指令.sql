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