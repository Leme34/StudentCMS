/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : cms

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 21/06/2019 09:46:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员昵称',
  PRIMARY KEY (`id`, `nickname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '管理员');

-- ----------------------------
-- Table structure for t_auth
-- ----------------------------
DROP TABLE IF EXISTS `t_auth`;
CREATE TABLE `t_auth`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统后台接口',
  `admin_auth` tinyint(4) NOT NULL DEFAULT 1 COMMENT '管理员是否有权限查看',
  `teacher_auth` tinyint(4) NOT NULL DEFAULT 0 COMMENT '教师是否有权限查看',
  `student_auth` tinyint(4) NOT NULL DEFAULT 0 COMMENT '学生是否有权限查看',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_auth
-- ----------------------------
INSERT INTO `t_auth` VALUES (10, '主界面', '/CMS/main/', 1, 1, 1);
INSERT INTO `t_auth` VALUES (11, '学生信息管理', '/CMS/student/', 1, 0, 0);
INSERT INTO `t_auth` VALUES (12, '教师信息管理', '/CMS/teacher/', 1, 0, 0);
INSERT INTO `t_auth` VALUES (13, '课程信息管理', '/CMS/course/', 1, 0, 0);
INSERT INTO `t_auth` VALUES (14, '系统权限', '/CMS/auth/', 1, 0, 0);
INSERT INTO `t_auth` VALUES (15, '公告管理', '/CMS/notice/', 1, 0, 0);
INSERT INTO `t_auth` VALUES (16, '查看公告', '/CMS/notice/look', 1, 1, 1);
INSERT INTO `t_auth` VALUES (17, '公告列表', '/CMS/notice/list', 1, 1, 1);
INSERT INTO `t_auth` VALUES (18, '教师课程', '/CMS/course/getMyCourse', 1, 1, 0);
INSERT INTO `t_auth` VALUES (19, '可选课程列表', '/CMS/course/choiceList', 1, 0, 1);
INSERT INTO `t_auth` VALUES (20, '结束课程', '/CMS/course/complete', 1, 1, 0);
INSERT INTO `t_auth` VALUES (21, '学生列表', '/CMS/student/stulist', 1, 1, 0);
INSERT INTO `t_auth` VALUES (22, '录入成绩', '/CMS/score/update', 1, 1, 0);
INSERT INTO `t_auth` VALUES (23, '学生选课', '/CMS/score/choiceCourse', 1, 0, 1);
INSERT INTO `t_auth` VALUES (24, '取消选课', '/CMS/score/delete', 1, 0, 1);
INSERT INTO `t_auth` VALUES (26, '查看成绩', '/CMS/score/stuScore', 1, 0, 1);
INSERT INTO `t_auth` VALUES (27, '密码管理', '/CMS/pswd/', 1, 1, 1);
INSERT INTO `t_auth` VALUES (28, '基本课程管理', '/CMS/basecourse/', 1, 0, 0);
INSERT INTO `t_auth` VALUES (29, '成绩报表', '/CMS/score/', 1, 1, 0);

-- ----------------------------
-- Table structure for t_base_course
-- ----------------------------
DROP TABLE IF EXISTS `t_base_course`;
CREATE TABLE `t_base_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '基本课程id',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名',
  `synopsis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 137 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_base_course
-- ----------------------------
INSERT INTO `t_base_course` VALUES (1, 'C语言', '本课程介绍计算机结构化程序设计的思想、方法和技巧；C语言的基本知识和概念；Ｃ语言丰富的运算符和数据类型，以及C语言的结构控制语句；在本课程中，函数的概念和指针的使用是课程重点和难点。');
INSERT INTO `t_base_course` VALUES (2, '数据结构与算法', '数据结构是计算机科学的一门非常重要的专业基础课，内容丰富，涉及面广，我校计算机专业的本科主干基础课程，也是非计算机类本科生和研究生学习计算机的选修课。');
INSERT INTO `t_base_course` VALUES (3, '操作系统', '操作系统是计算机科学与技术领域中最为活跃的学科之一,因而操作系统课程也自然是该专业的一门核心的专业基础课。操作系统课程内容综合了基础理论教学、课程实践教学、最新技术追踪等多项内容。');
INSERT INTO `t_base_course` VALUES (4, '计算机网络', '计算机网络是计算机专业学生必修的一门专业基础课和核心课程，它是后续课程《计算机系统安全》、《网络管理技术》、《TCP/IP与网络互联》等理论课程，以及《网络课程设计》等实践教学环节的先行课。');
INSERT INTO `t_base_course` VALUES (5, '软件工程', '该课程主要介绍软件工程的基本概念、原理和典型的技术方法。该课程的主要目的是通过教学，使学生了解工程学原理在软件开发中的应用，对计算机科学专业和信息工程专业学生理解软件开发过程和软件工程学具有重要意义。');
INSERT INTO `t_base_course` VALUES (6, 'Linux入门', 'Linux是适用于多种平台的计算机操作系统，也是免费的非商品化的操作系统。本课程以Redhat Linux系统为基础，试图对Linux系统一个简洁而全面的介绍，使学生在较短时间内对该操作系统有个大概的了解。');
INSERT INTO `t_base_course` VALUES (134, '手撕Spring源码', '带你手把手仿照Spring源码编写的SpringMVC，还原MyDispatcherServlet处理流程：注解扫描，初始化ioc容器（定位、载入、注册、实例化、依赖注入），handlerMapping，视图解析 ...');
INSERT INTO `t_base_course` VALUES (135, '分布式系统设计', '主要是以下两个方面\n1.  近些年分布式系统领域都在做些什么。\n2.  为什么现在投入分布式系统的学习和研究是值得的。\n我会尽可能多地去介绍更 “实用” 的分布式系统知识。');
INSERT INTO `t_base_course` VALUES (136, 'RESTful API设计规范', 'RESTful 是目前最流行的 API 设计规范，用于 Web 数据接口的设计。\n它的大原则容易把握，但是细节不容易做对。本文总结 RESTful 的设计细节，介绍如何设计出易于理解和使用的 API。');

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '选课课程id',
  `start_date` date NULL DEFAULT NULL COMMENT '开设日期',
  `end_date` date NULL DEFAULT NULL COMMENT '结束日期',
  `class_hour` smallint(6) NULL DEFAULT NULL COMMENT '总课时',
  `test_mode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考核方式',
  `student_num` int(11) NULL DEFAULT NULL COMMENT '最大可选人数',
  `choice_num` int(11) NULL DEFAULT 0 COMMENT '已选人数',
  `complete` int(11) NOT NULL DEFAULT 0 COMMENT '是否是完成的课程',
  `t_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '外键-教师号',
  `base_course_id` int(11) NOT NULL COMMENT '外键-基本课程号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `teacher_course`(`t_id`) USING BTREE,
  INDEX `course`(`base_course_id`) USING BTREE,
  CONSTRAINT `course` FOREIGN KEY (`base_course_id`) REFERENCES `t_base_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher_course` FOREIGN KEY (`t_id`) REFERENCES `t_teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES (7, '2019-09-01', '2019-12-31', 54, '考试', 40, 2, 0, '1560310', 1);
INSERT INTO `t_course` VALUES (13, '2019-09-15', '2020-01-06', 120, '教考分离', 80, 2, 0, '1560310', 5);
INSERT INTO `t_course` VALUES (15, '2019-06-19', '2020-06-18', 200, '教考分离', 188, 1, 1, '19980831', 134);
INSERT INTO `t_course` VALUES (16, '2019-06-20', '2020-08-18', 55, '开卷', 68, 3, 1, '19980831', 135);
INSERT INTO `t_course` VALUES (17, '2019-06-30', '2019-08-25', 38, '开卷', 50, 3, 1, '19980831', 136);
INSERT INTO `t_course` VALUES (18, '2019-06-30', '2019-06-19', 100, '教考分离', 75, 5, 1, '19980831', 2);
INSERT INTO `t_course` VALUES (19, '2019-06-30', '2019-07-30', 40, '教考分离', 90, 7, 1, '19980831', 6);

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '通知id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `author` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `auth` int(11) NOT NULL DEFAULT 3 COMMENT '查看权限（1、全体可见 2、仅教师可见 3、仅管理员可见）',
  `date` date NOT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES (5, 'test3全体可见公告', '管理员', '', 1, '2019-06-18');
INSERT INTO `t_notice` VALUES (6, 'test2教师可见公告', '管理员', '', 2, '2019-06-18');
INSERT INTO `t_notice` VALUES (7, 'test1管理员可见公告', '管理员', '', 3, '2019-06-18');

-- ----------------------------
-- Table structure for t_score
-- ----------------------------
DROP TABLE IF EXISTS `t_score`;
CREATE TABLE `t_score`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩id',
  `score` int(11) NOT NULL DEFAULT 0 COMMENT '考试成绩',
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '考察结果',
  `c_id` int(11) NOT NULL COMMENT '外键-课程id',
  `s_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '外键-学号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `score_stu`(`s_id`) USING BTREE,
  INDEX `score_course`(`c_id`) USING BTREE,
  CONSTRAINT `score_course` FOREIGN KEY (`c_id`) REFERENCES `t_course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `score_stu` FOREIGN KEY (`s_id`) REFERENCES `t_student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_score
-- ----------------------------
INSERT INTO `t_score` VALUES (23, 0, '', 7, '20160310529');
INSERT INTO `t_score` VALUES (24, 100, '99.99', 15, '20160310529');
INSERT INTO `t_score` VALUES (25, 0, '', 13, '20160310529');
INSERT INTO `t_score` VALUES (28, 95, '95', 16, '20160310550');
INSERT INTO `t_score` VALUES (29, 98, '98', 17, '20160310550');
INSERT INTO `t_score` VALUES (30, 100, '99', 16, '20160310529');
INSERT INTO `t_score` VALUES (31, 100, '99', 17, '20160310529');
INSERT INTO `t_score` VALUES (33, 90, '90', 16, '20160310500');
INSERT INTO `t_score` VALUES (34, 92, '92', 17, '20160310500');
INSERT INTO `t_score` VALUES (35, 96, '98', 18, '20160310529');
INSERT INTO `t_score` VALUES (36, 92, '92', 18, '20160310600');
INSERT INTO `t_score` VALUES (37, 91, '91', 19, '20160310600');
INSERT INTO `t_score` VALUES (38, 88, '88', 18, '20160310601');
INSERT INTO `t_score` VALUES (39, 92, '92', 19, '20160310601');
INSERT INTO `t_score` VALUES (40, 60, '60', 18, '20160310602');
INSERT INTO `t_score` VALUES (41, 93, '93', 19, '20160310602');
INSERT INTO `t_score` VALUES (42, 94, '94', 19, '20160310603');
INSERT INTO `t_score` VALUES (43, 59, '59', 18, '20160310603');
INSERT INTO `t_score` VALUES (44, 0, '', 13, '20160310603');
INSERT INTO `t_score` VALUES (45, 98, '99', 19, '20160310529');
INSERT INTO `t_score` VALUES (46, 97, '97', 19, '20160310500');
INSERT INTO `t_score` VALUES (47, 96, '96', 19, '20160310550');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `admission_date` date NOT NULL COMMENT '入学日期',
  `major` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业',
  `grade` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `education` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学历',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('20160310500', 'E10ADC3949BA59ABBE56E057F20F883E', 'Lee', '男', '2016-09-06', '计算机科学与技术', '16计科5班', '本科');
INSERT INTO `t_student` VALUES ('20160310529', 'E10ADC3949BA59ABBE56E057F20F883E', '梁圣达', '男', '2016-09-06', '计算机科学与技术', '16计科5班', '本科');
INSERT INTO `t_student` VALUES ('20160310550', 'E10ADC3949BA59ABBE56E057F20F883E', 'Lee34', '女', '2016-09-06', '计算机科学与技术', '16计科5班', '本科');
INSERT INTO `t_student` VALUES ('20160310600', 'E10ADC3949BA59ABBE56E057F20F883E', '老王', '男', '2016-09-06', '计算机科学与技术', '16计科6班', '本科');
INSERT INTO `t_student` VALUES ('20160310601', 'E10ADC3949BA59ABBE56E057F20F883E', '张三', '男', '2016-09-06', '计算机科学与技术', '16计科6班', '本科');
INSERT INTO `t_student` VALUES ('20160310602', 'E10ADC3949BA59ABBE56E057F20F883E', '李四', '男', '2016-09-06', '计算机科学与技术', '16计科6班', '本科');
INSERT INTO `t_student` VALUES ('20160310603', 'E10ADC3949BA59ABBE56E057F20F883E', '王五', '女', '2016-09-06', '计算机科学与技术', '16计科6班', '本科');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '教师职工号',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `synopsis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('1560310', '80F5407A5CD59BB453A7963085661654', '蔡老师', '1916年至1927年任北京大学校长，革新北大，开“学术”与“自由”之风；1920年至1930年，蔡元培同时兼任中法大学校长。');
INSERT INTO `t_teacher` VALUES ('1560311', 'E10ADC3949BA59ABBE56E057F20F883E', '陈老师', 'test2');
INSERT INTO `t_teacher` VALUES ('1560312', 'E10ADC3949BA59ABBE56E057F20F883E', '张老师', 'test3');
INSERT INTO `t_teacher` VALUES ('19980831', 'E10ADC3949BA59ABBE56E057F20F883E', '梁老师', '毕业于广东科学技术大学（原佛山科学技术学院）');

SET FOREIGN_KEY_CHECKS = 1;
