-- MySQL dump 10.13  Distrib 8.3.0, for macos14 (arm64)
--
-- Host: localhost    Database: ray-framework
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sys_auth_log`
--

DROP TABLE IF EXISTS `sys_auth_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_auth_log`
(
    `id`              bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `type`            tinyint                                                       NOT NULL COMMENT '日志类型：1=登录；2=登出；',
    `create_time`     timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '登录时间',
    `create_user`     char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '登录人',
    `login_ip`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '登录IP地址',
    `browser`         varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '浏览器',
    `browser_version` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '浏览器版本',
    `platform`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '平台',
    `os`              varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作系统',
    `os_version`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '操作系统版本',
    `engine`          varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '引擎',
    `engine_version`  varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '引擎版本',
    `exe_time`        bigint                                                        NOT NULL DEFAULT '0' COMMENT '执行时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统认证日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_auth_log`
--

LOCK
TABLES `sys_auth_log` WRITE;
/*!40000 ALTER TABLE `sys_auth_log` DISABLE KEYS */;
INSERT INTO `sys_auth_log`
VALUES (1, 1, '2024-04-28 07:23:27', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 31),
       (2, 2, '2024-04-28 07:25:42', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 19),
       (3, 2, '2024-04-28 07:25:43', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 0),
       (4, 2, '2024-04-28 07:25:55', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 0),
       (5, 1, '2024-04-28 07:31:02', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 310),
       (6, 2, '2024-04-28 07:31:10', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 24),
       (7, 1, '2024-04-28 08:49:31', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 166),
       (8, 2, '2024-04-28 08:58:56', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 25),
       (9, 1, '2024-04-28 08:59:31', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 10),
       (10, 2, '2024-04-28 09:25:04', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 28),
       (11, 1, '2024-04-28 09:25:08', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 42),
       (12, 2, '2024-04-28 09:26:34', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 28),
       (13, 1, '2024-04-28 09:26:51', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 43),
       (14, 2, '2024-04-29 01:25:54', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 32),
       (15, 1, '2024-04-29 01:25:56', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 48),
       (16, 2, '2024-04-29 02:24:10', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 28),
       (17, 1, '2024-04-29 02:38:34', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 336),
       (18, 2, '2024-04-29 02:38:41', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 22),
       (19, 1, '2024-04-29 08:41:33', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 358),
       (20, 1, '2024-04-29 09:27:56', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 363),
       (21, 2, '2024-04-29 09:28:09', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 23),
       (22, 1, '2024-04-29 09:30:07', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 39),
       (23, 2, '2024-04-29 09:30:15', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 18),
       (24, 1, '2024-04-29 09:30:33', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 9741),
       (25, 2, '2024-04-29 09:30:45', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 22),
       (26, 1, '2024-04-29 09:38:13', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 49007),
       (27, 2, '2024-04-29 09:41:43', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 63),
       (28, 1, '2024-04-29 09:41:46', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 56),
       (29, 2, '2024-04-29 10:13:32', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 40),
       (30, 1, '2024-04-29 10:13:35', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 50),
       (31, 2, '2024-05-11 09:16:57', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 37),
       (32, 1, '2024-05-11 09:17:15', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 69),
       (33, 1, '2024-05-11 09:32:05', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 68),
       (34, 1, '2024-05-11 09:32:42', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 64),
       (35, 1, '2024-05-13 01:16:08', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 58),
       (36, 1, '2024-05-13 01:20:26', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 60),
       (37, 1, '2024-05-13 01:56:54', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 55),
       (38, 1, '2024-05-13 01:57:06', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 35),
       (39, 1, '2024-05-13 01:58:34', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 53),
       (40, 1, '2024-05-13 02:00:13', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 49),
       (41, 1, '2024-05-13 02:07:54', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 22),
       (42, 1, '2024-05-13 02:17:03', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 49),
       (43, 1, '2024-05-13 02:17:39', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 49),
       (44, 1, '2024-05-13 02:24:43', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 54),
       (45, 1, '2024-05-13 02:24:52', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 53),
       (46, 1, '2024-05-13 08:19:02', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 43),
       (47, 1, '2024-05-13 08:20:43', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 49),
       (48, 1, '2024-05-13 09:02:21', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 46),
       (49, 1, '2024-05-13 09:24:43', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 36),
       (50, 1, '2024-05-17 02:25:32', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 194),
       (51, 1, '2024-05-17 02:42:45', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 62),
       (52, 1, '2024-05-17 03:51:16', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 60),
       (53, 1, '2024-05-17 08:43:45', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 58),
       (54, 1, '2024-05-17 08:45:20', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 32),
       (55, 1, '2024-05-17 08:49:04', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 42),
       (56, 1, '2024-05-17 09:32:29', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 62),
       (57, 1, '2024-05-21 02:32:31', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 34),
       (58, 1, '2024-05-21 02:37:40', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 42),
       (59, 1, '2024-05-21 02:38:04', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 47),
       (60, 1, '2024-05-21 02:42:52', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 36),
       (61, 1, '2024-05-21 02:44:17', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 27),
       (62, 1, '2024-05-21 02:44:44', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 32),
       (63, 1, '2024-05-21 02:45:56', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 36),
       (64, 1, '2024-05-21 02:47:18', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 32),
       (65, 1, '2024-05-21 02:48:21', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 39),
       (66, 1, '2024-05-21 02:53:10', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 39),
       (67, 1, '2024-05-21 02:57:34', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 30),
       (68, 1, '2024-05-21 03:09:55', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 37),
       (69, 1, '2024-05-21 07:21:25', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 42),
       (70, 1, '2024-05-21 07:21:53', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 37),
       (71, 1, '2024-05-21 07:27:11', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 38),
       (72, 1, '2024-05-23 07:56:37', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 132),
       (73, 1, '2024-05-23 07:57:29', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 355),
       (74, 1, '2024-05-24 03:23:52', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 39),
       (75, 1, '2024-05-24 03:24:57', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 51),
       (76, 1, '2024-05-24 03:25:14', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 45),
       (77, 1, '2024-05-24 03:27:37', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 44),
       (78, 1, '2024-05-24 03:27:49', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 47),
       (79, 1, '2024-05-24 03:28:02', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 38),
       (80, 1, '2024-05-24 03:29:21', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 42),
       (81, 1, '2024-05-24 03:29:34', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 40),
       (82, 1, '2024-05-24 03:29:40', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 27),
       (83, 1, '2024-05-24 03:30:38', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 27),
       (84, 2, '2024-05-24 03:30:42', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 24),
       (85, 1, '2024-05-24 06:47:27', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 33),
       (86, 1, '2024-05-24 12:38:37', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 358),
       (87, 2, '2024-05-24 12:39:05', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 20),
       (88, 1, '2024-05-24 12:39:12', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 46),
       (89, 1, '2024-05-24 12:42:10', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 60),
       (90, 1, '2024-05-24 12:44:45', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 54),
       (91, 1, '2024-05-24 12:49:17', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 165),
       (92, 2, '2024-05-24 12:51:37', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 63),
       (93, 1, '2024-05-24 12:51:40', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 55),
       (94, 1, '2024-05-24 13:04:33', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 154),
       (95, 2, '2024-05-24 13:05:52', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 25),
       (96, 1, '2024-05-24 13:05:56', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 62),
       (97, 2, '2024-05-24 13:13:38', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 20),
       (98, 1, '2024-05-24 13:13:40', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 51),
       (99, 2, '2024-05-24 13:13:53', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 27),
       (100, 1, '2024-05-24 13:13:58', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 61),
       (101, 2, '2024-05-25 09:40:20', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 20),
       (102, 1, '2024-05-25 09:41:48', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 60),
       (103, 2, '2024-05-25 09:48:58', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 16),
       (104, 1, '2024-05-25 09:49:00', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 48),
       (105, 2, '2024-05-25 09:50:30', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 19),
       (106, 1, '2024-05-25 09:50:32', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 49),
       (107, 2, '2024-05-25 09:50:52', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 13),
       (108, 1, '2024-05-25 09:50:55', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 45),
       (109, 2, '2024-05-25 09:52:00', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 13),
       (110, 1, '2024-05-25 09:52:03', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 51),
       (111, 2, '2024-05-25 09:52:12', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 11),
       (112, 1, '2024-05-25 09:52:14', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '124.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 47),
       (113, 2, '2024-05-27 02:43:16', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '125.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 10),
       (114, 1, '2024-05-27 02:43:22', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '125.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 30),
       (115, 1, '2024-05-28 03:19:13', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Unknown', '', 'Unknown',
        'Unknown', '', 'Unknown', '', 370),
       (116, 1, '2024-05-29 09:42:10', '2bd631f674af40f19c73c0d8962a4d28', '127.0.0.1', 'Chrome', '125.0.0.0', 'Mac',
        'OSX', '10_15_7', 'Webkit', '537.36', 217);
/*!40000 ALTER TABLE `sys_auth_log` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `sys_dept`
--

DROP TABLE IF EXISTS `sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dept`
(
    `id`          bigint                                                    NOT NULL AUTO_INCREMENT COMMENT '主键',
    `parent_code` char(32) COLLATE utf8mb4_general_ci                       NOT NULL COMMENT '父级编号',
    `code`        char(32) COLLATE utf8mb4_general_ci                       NOT NULL COMMENT '编号',
    `name`        varchar(32) COLLATE utf8mb4_general_ci                    NOT NULL DEFAULT '' COMMENT '名称',
    `status`      tinyint                                                   NOT NULL DEFAULT '0' COMMENT '状态：0=停用；1=启用',
    `sequence`    int                                                       NOT NULL DEFAULT '0' COMMENT '排序',
    `remark`      varchar(256) COLLATE utf8mb4_general_ci                   NOT NULL DEFAULT '' COMMENT '备注',
    `deleted`     tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
    `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` timestamp                                                 NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_user` char(32) COLLATE utf8mb4_general_ci                       NOT NULL DEFAULT '' COMMENT '修改人',
    `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `sys_dept_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统部门表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dept`
--

LOCK
TABLES `sys_dept` WRITE;
/*!40000 ALTER TABLE `sys_dept` DISABLE KEYS */;
INSERT INTO `sys_dept`
VALUES (1, '0', '6220837f5a994d11a4f5cb4833fc216a', '德玛西亚', 0, 0, '', 0, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-04-28 07:18:51', '2bd631f674af40f19c73c0d8962a4d28', '2024-04-29 09:22:36');
/*!40000 ALTER TABLE `sys_dept` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `code`        char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL COMMENT '编号',
    `name`        varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '名称',
    `value`       varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '字典值',
    `status`      tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：0=停用；1=启用',
    `remark`      varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
    `deleted`     tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
    `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '修改人',
    `modify_time` timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK
TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict`
VALUES (1, '3606a726056c4f72903493a43a62b193', '性别', 'GENDER', 1, '', 0, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-28 06:22:59', '2bd631f674af40f19c73c0d8962a4d28', '2024-05-28 06:23:17'),
       (2, 'a812a48ce14a48f38c8ddc9f5ab984af', '方向', 'DIRECTION', 1, '', 0, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-30 06:39:27', '2bd631f674af40f19c73c0d8962a4d28', '2024-05-30 10:51:58'),
       (3, 'bc14496899be4d61a4314ff0025c672e', '测试1', 'TEST1', 1, '', 1, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-30 10:11:41', '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:53:11'),
       (4, '223e8c29d02e43b78be25a93f99f593e', '测试2', 'TEST2', 1, '', 1, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-30 10:54:14', '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:53:11'),
       (5, '77b64a60db80486f8238d1e492e02daf', '测试3', 'TEST3', 1, '', 1, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-30 10:55:50', '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:53:11'),
       (6, '5bd0023525cd4b03b7ba6290be3d4a36', '测试4', 'TEST4', 1, '', 1, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-30 10:55:59', '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:53:11'),
       (7, '2f1a03b292b9402287454c9a12c18d09', '测试5', 'TEST5', 1, '', 1, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-30 10:56:04', '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:53:11'),
       (8, 'ec500a22f9ce46d3a18b9e87a782fdfe', '测试6', 'TEST6', 1, '', 1, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-30 11:05:49', '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:53:11'),
       (9, 'c9d2372540464bd9999d1603da6008ae', '测试7', 'TEST7', 1, '', 1, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-30 11:05:55', '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:53:11'),
       (10, '06a80c6ba3614cb6803a7f7837272aa1', '测试8', 'TEST8', 1, '', 1, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-30 11:06:01', '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:53:11'),
       (11, '6bc10de58ba148c9af40f9e972b8fba3', '测试9', 'TEST9', 1, '', 1, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-30 11:06:06', '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:53:11'),
       (12, '17419b93799a42d8b23e3183eb270d2f', '测试10', 'TEST10', 1, '', 1, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-30 11:06:13', '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:53:11');
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `sys_dict_item`
--

DROP TABLE IF EXISTS `sys_dict_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict_item`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `dict_value`  varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '所属字典',
    `code`        char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL COMMENT '编号',
    `name`        varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '内容名称',
    `value`       varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL COMMENT '字典值',
    `status`      tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态：0=停用；1=启用',
    `sequence`    int                                                           NOT NULL DEFAULT '100' COMMENT '排序',
    `remark`      varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
    `deleted`     tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
    `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '修改人',
    `modify_time` timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict_item`
--

LOCK
TABLES `sys_dict_item` WRITE;
/*!40000 ALTER TABLE `sys_dict_item` DISABLE KEYS */;
INSERT INTO `sys_dict_item`
VALUES (2, 'GENDER', '50d32e1e15cf498e87dfccdefe7d9bc9', '男', 'MALE', 1, 1, '', 0, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-06-04 03:58:13', '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:48:26'),
       (3, 'GENDER', '8c583631b761435bb6ff4c03022f4367', '女', 'FEMALE', 1, 2, '', 0,
        '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:39:54', '2bd631f674af40f19c73c0d8962a4d28',
        '2024-06-04 06:49:20'),
       (5, 'DIRECTION', 'fc60415f377b4ef183675f7a964aed34', '东', 'EAST', 1, 1, '', 0,
        '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:49:36', '2bd631f674af40f19c73c0d8962a4d28',
        '2024-06-04 06:49:36'),
       (6, 'DIRECTION', 'c9ce6f8cf7e34e32a9022e24e0d402da', '西', 'WEST', 1, 2, '', 0,
        '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:50:44', '2bd631f674af40f19c73c0d8962a4d28',
        '2024-06-04 06:51:22'),
       (7, 'DIRECTION', '229eb399e9ec43b4a25b4206a94018bb', '南', 'SOUTH', 1, 3, '', 0,
        '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:51:18', '2bd631f674af40f19c73c0d8962a4d28',
        '2024-06-04 06:51:18'),
       (8, 'DIRECTION', '16505e5563fe4965846662f78e2cc6e1', '北', 'NORTH', 1, 4, '', 0,
        '2bd631f674af40f19c73c0d8962a4d28', '2024-06-04 06:51:51', '2bd631f674af40f19c73c0d8962a4d28',
        '2024-06-04 06:51:51');
/*!40000 ALTER TABLE `sys_dict_item` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `sys_func`
--

DROP TABLE IF EXISTS `sys_func`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_func`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `parent_code` char(32) COLLATE utf8mb4_general_ci                           NOT NULL COMMENT '父级编号',
    `code`        char(32) COLLATE utf8mb4_general_ci                           NOT NULL COMMENT '编号',
    `name`        varchar(32) COLLATE utf8mb4_general_ci                        NOT NULL DEFAULT '' COMMENT '名称',
    `type`        tinyint                                                       NOT NULL DEFAULT '0' COMMENT '类型：0=目录，1=功能；2=按钮',
    `icon`        varchar(32) COLLATE utf8mb4_general_ci                        NOT NULL DEFAULT '' COMMENT '图标',
    `path`        varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '路由地址',
    `redirect`    varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '重定向地址',
    `linkable`    tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否外链',
    `cacheable`   tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否缓存',
    `visible`     tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可见',
    `always_show` tinyint(1) NOT NULL DEFAULT '0' COMMENT '始终显示根菜单',
    `permission`  varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '权限',
    `component`   varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '组件',
    `sequence`    int                                                           NOT NULL DEFAULT '0' COMMENT '排序',
    `remark`      varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
    `deleted`     tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
    `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '修改人',
    `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `sys_func_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统功能表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_func`
--

LOCK
TABLES `sys_func` WRITE;
/*!40000 ALTER TABLE `sys_func` DISABLE KEYS */;
INSERT INTO `sys_func`
VALUES (1, '0', '0e5580ae61f54380bbc9f473655060bc', '系统管理', 0, 'system', '/system', '', 0, 0, 1, 1, 'ray:system',
        'Layout', 0, '', 0, '2bd631f674af40f19c73c0d8962a4d28', '2024-04-29 02:40:45',
        '2bd631f674af40f19c73c0d8962a4d28', '2024-05-25 09:41:43'),
       (2, '0e5580ae61f54380bbc9f473655060bc', '6bfb7cc5de7a4d9c9b70d8563c7377ec', '用户管理', 1, 'user', 'user', '', 0,
        0, 1, 0, 'ray:system:users', 'system/user/index', 1, '', 0, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-04-29 09:22:11', '2bd631f674af40f19c73c0d8962a4d28', '2024-05-24 13:13:48'),
       (3, '0e5580ae61f54380bbc9f473655060bc', '7982cdc53a124340ab7da5e3f130b419', '角色管理', 1, 'role', 'role', '', 0,
        0, 1, 0, 'ray:system:roles', 'system/role/index', 2, '', 0, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-25 09:44:17', '2bd631f674af40f19c73c0d8962a4d28', '2024-05-25 09:44:17'),
       (4, '0e5580ae61f54380bbc9f473655060bc', '86132348f09a4a8299d949d12f1237b4', '菜单管理', 1, 'menu', 'menu', '', 0,
        0, 1, 0, 'ray:system:funcs', 'system/menu/index', 3, '', 0, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-25 09:46:02', '2bd631f674af40f19c73c0d8962a4d28', '2024-05-25 09:47:56'),
       (5, '0e5580ae61f54380bbc9f473655060bc', '9c476acf5ed34dd19a4f8037a065a669', '部门管理', 1, 'tree', 'dept', '', 0,
        0, 1, 0, 'ray:system:depts', 'system/dept/index', 4, '', 0, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-25 09:47:50', '2bd631f674af40f19c73c0d8962a4d28', '2024-05-25 09:51:55'),
       (6, '0e5580ae61f54380bbc9f473655060bc', '5b9a474efbc14b6e865e51cbbd16f311', '字典管理', 1, 'dict', 'dict', '', 0,
        0, 1, 0, 'ray:system:dicts', 'system/dict/index', 5, '', 0, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-05-25 09:48:49', '2bd631f674af40f19c73c0d8962a4d28', '2024-05-25 09:51:55');
/*!40000 ALTER TABLE `sys_func` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `code`        char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL COMMENT '编号',
    `name`        varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '名称',
    `status`      tinyint                                                       NOT NULL DEFAULT '0' COMMENT '状态：0=停用；1=启用',
    `sequence`    int                                                           NOT NULL DEFAULT '0' COMMENT '排序',
    `remark`      varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
    `deleted`     tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
    `create_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_user` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '修改人',
    `modify_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `sys_role_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK
TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role`
VALUES (1, '3eec56d8fd634f8f860428b3f61a0f6d', 'ROLE_SUPER_ADMIN', 0, 0, '', 0, '2bd631f674af40f19c73c0d8962a4d28',
        '2024-04-28 07:19:30', '2bd631f674af40f19c73c0d8962a4d28', '2024-04-29 09:22:24');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `sys_role_func_relation`
--

DROP TABLE IF EXISTS `sys_role_func_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_func_relation`
(
    `id`        bigint                              NOT NULL AUTO_INCREMENT COMMENT '主键',
    `role_code` char(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编号',
    `func_code` char(32) COLLATE utf8mb4_general_ci NOT NULL COMMENT '功能编号',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色与功能的关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_func_relation`
--

LOCK
TABLES `sys_role_func_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_func_relation` DISABLE KEYS */;
INSERT INTO `sys_role_func_relation`
VALUES (1, '3eec56d8fd634f8f860428b3f61a0f6d', '0e5580ae61f54380bbc9f473655060bc'),
       (2, '3eec56d8fd634f8f860428b3f61a0f6d', '6bfb7cc5de7a4d9c9b70d8563c7377ec'),
       (3, '3eec56d8fd634f8f860428b3f61a0f6d', '7982cdc53a124340ab7da5e3f130b419'),
       (4, '3eec56d8fd634f8f860428b3f61a0f6d', '86132348f09a4a8299d949d12f1237b4'),
       (5, '3eec56d8fd634f8f860428b3f61a0f6d', '9c476acf5ed34dd19a4f8037a065a669'),
       (6, '3eec56d8fd634f8f860428b3f61a0f6d', '5b9a474efbc14b6e865e51cbbd16f311');
/*!40000 ALTER TABLE `sys_role_func_relation` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `sys_role_user_relation`
--

DROP TABLE IF EXISTS `sys_role_user_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_user_relation`
(
    `id`        bigint                                                    NOT NULL AUTO_INCREMENT COMMENT '主键',
    `role_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色编号',
    `user_code` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户编号',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统角色与用户的关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_user_relation`
--

LOCK
TABLES `sys_role_user_relation` WRITE;
/*!40000 ALTER TABLE `sys_role_user_relation` DISABLE KEYS */;
INSERT INTO `sys_role_user_relation`
VALUES (1, '3eec56d8fd634f8f860428b3f61a0f6d', '2bd631f674af40f19c73c0d8962a4d28');
/*!40000 ALTER TABLE `sys_role_user_relation` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_user`
(
    `id`           bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '主键',
    `dept_code`    char(32) COLLATE utf8mb4_general_ci                           NOT NULL COMMENT '部门编号',
    `code`         char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL COMMENT '编号',
    `phone_number` varchar(32) COLLATE utf8mb4_general_ci                        NOT NULL COMMENT '手机号码',
    `name`         varchar(32) COLLATE utf8mb4_general_ci                        NOT NULL DEFAULT '' COMMENT '姓名',
    `password`     char(32) COLLATE utf8mb4_general_ci                           NOT NULL COMMENT '密码',
    `email`        varchar(128) COLLATE utf8mb4_general_ci                       NOT NULL COMMENT '邮箱',
    `avatar`       varchar(256) COLLATE utf8mb4_general_ci                       NOT NULL DEFAULT '' COMMENT '头像',
    `status`       tinyint                                                       NOT NULL DEFAULT '0' COMMENT '状态：0=停用；1=启用',
    `remark`       varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注',
    `deleted`      tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
    `create_user`  char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time`  timestamp                                                     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `modify_user`  char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '修改人',
    `modify_time`  timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `sys_user_unique` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK
TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
INSERT INTO `sys_user`
VALUES (1, '6220837f5a994d11a4f5cb4833fc216a', '2bd631f674af40f19c73c0d8962a4d28', '17600891908', '盖伦',
        '670b14728ad9902aecba32e22fa4f6bd', '17600891908@qq.com',
        'https://oss.youlai.tech/youlai-boot/2023/05/16/811270ef31f548af9cffc026dfc3777b.gif', 0, '', 0, '\'\'',
        '2024-04-25 08:18:08', '', '2024-05-27 02:42:54');
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Dumping routines for database 'ray-framework'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-14 14:41:51
