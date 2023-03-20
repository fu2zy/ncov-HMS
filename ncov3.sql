/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : ncov

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 14/12/2022 00:38:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for approval_process
-- ----------------------------
DROP TABLE IF EXISTS `approval_process`;
CREATE TABLE `approval_process`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `day` int(11) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `node_status` int(11) NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of approval_process
-- ----------------------------
INSERT INTO `approval_process` VALUES (1, 1, '阳人居家', '广州市', 2, '18646784915', 1, '2022-12-10 20:22:41', '2022-12-10 20:22:47');
INSERT INTO `approval_process` VALUES (2, 1, '去玩', '珠海', 1, '1475874524', 1, '2022-12-13 23:06:30', NULL);

-- ----------------------------
-- Table structure for ban_ji
-- ----------------------------
DROP TABLE IF EXISTS `ban_ji`;
CREATE TABLE `ban_ji`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `xue_yuan_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `xue_yuan_id`(`xue_yuan_id`) USING BTREE,
  CONSTRAINT `ban_ji_ibfk_1` FOREIGN KEY (`xue_yuan_id`) REFERENCES `xue_yuan` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ban_ji
-- ----------------------------
INSERT INTO `ban_ji` VALUES (1, '软件工程1班', 1);
INSERT INTO `ban_ji` VALUES (2, '软件工程2班', NULL);
INSERT INTO `ban_ji` VALUES (3, '马克斯1班', NULL);
INSERT INTO `ban_ji` VALUES (4, '金融1班', NULL);

-- ----------------------------
-- Table structure for china_total
-- ----------------------------
DROP TABLE IF EXISTS `china_total`;
CREATE TABLE `china_total`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `confirm` int(255) NULL DEFAULT NULL,
  `input` int(255) NULL DEFAULT NULL,
  `severe` int(255) NULL DEFAULT NULL,
  `heal` int(255) NULL DEFAULT NULL,
  `dead` int(255) NULL DEFAULT NULL,
  `suspect` int(255) NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 132 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of china_total
-- ----------------------------
INSERT INTO `china_total` VALUES (1, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 06:34:12');
INSERT INTO `china_total` VALUES (2, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 06:34:12');
INSERT INTO `china_total` VALUES (3, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 06:34:12');
INSERT INTO `china_total` VALUES (4, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 06:34:12');
INSERT INTO `china_total` VALUES (5, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 06:34:12');
INSERT INTO `china_total` VALUES (6, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 06:34:12');
INSERT INTO `china_total` VALUES (7, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 06:34:12');
INSERT INTO `china_total` VALUES (8, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 06:34:12');
INSERT INTO `china_total` VALUES (9, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (10, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (11, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (12, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (13, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (14, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (15, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (16, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (17, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (18, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (19, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (20, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (21, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (22, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (23, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (24, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (25, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (26, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (27, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (28, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (29, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (30, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (31, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (32, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (33, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (34, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (35, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (36, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (37, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (38, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (39, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (40, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (41, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (42, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (43, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (44, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 07:19:13');
INSERT INTO `china_total` VALUES (45, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 08:34:15');
INSERT INTO `china_total` VALUES (46, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 08:34:15');
INSERT INTO `china_total` VALUES (47, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 08:34:15');
INSERT INTO `china_total` VALUES (48, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 08:34:15');
INSERT INTO `china_total` VALUES (49, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 08:34:15');
INSERT INTO `china_total` VALUES (50, 2677949, 18705, 0, 293039, 16982, 0, '2022-06-02 08:34:15');
INSERT INTO `china_total` VALUES (51, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (52, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (53, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (54, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (55, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (56, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (57, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (58, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (59, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (60, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (61, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (62, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (63, 2677954, 18705, 0, 293039, 16982, 0, '2022-06-02 13:24:21');
INSERT INTO `china_total` VALUES (64, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-03 02:44:37');
INSERT INTO `china_total` VALUES (65, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-03 02:44:37');
INSERT INTO `china_total` VALUES (66, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-03 02:44:37');
INSERT INTO `china_total` VALUES (67, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-03 02:44:37');
INSERT INTO `china_total` VALUES (68, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-03 02:44:37');
INSERT INTO `china_total` VALUES (69, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-03 04:19:39');
INSERT INTO `china_total` VALUES (70, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-03 23:25:03');
INSERT INTO `china_total` VALUES (71, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-03 23:25:03');
INSERT INTO `china_total` VALUES (72, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-03 23:25:03');
INSERT INTO `china_total` VALUES (73, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (74, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (75, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (76, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (77, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (78, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (79, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (80, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (81, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (82, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (83, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (84, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (85, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 00:25:02');
INSERT INTO `china_total` VALUES (86, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 01:30:04');
INSERT INTO `china_total` VALUES (87, 2754999, 18722, 0, 293315, 17127, 0, '2022-06-04 01:30:04');
INSERT INTO `china_total` VALUES (88, 2831622, 18747, 0, 293675, 17271, 0, '2022-06-04 01:30:04');
INSERT INTO `china_total` VALUES (89, 2831622, 18747, 0, 293675, 17271, 0, '2022-06-04 01:30:04');
INSERT INTO `china_total` VALUES (90, 2831622, 18747, 0, 293675, 17271, 0, '2022-06-04 01:30:04');
INSERT INTO `china_total` VALUES (91, 2831622, 18747, 0, 293675, 17271, 0, '2022-06-04 01:30:04');
INSERT INTO `china_total` VALUES (92, 2831622, 18747, 0, 293675, 17271, 0, '2022-06-04 01:30:04');
INSERT INTO `china_total` VALUES (93, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:20:34');
INSERT INTO `china_total` VALUES (94, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:20:34');
INSERT INTO `china_total` VALUES (95, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:20:34');
INSERT INTO `china_total` VALUES (96, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:20:34');
INSERT INTO `china_total` VALUES (97, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:35:35');
INSERT INTO `china_total` VALUES (98, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:50:35');
INSERT INTO `china_total` VALUES (99, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:50:35');
INSERT INTO `china_total` VALUES (100, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:50:35');
INSERT INTO `china_total` VALUES (101, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:50:35');
INSERT INTO `china_total` VALUES (102, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:50:35');
INSERT INTO `china_total` VALUES (103, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:50:35');
INSERT INTO `china_total` VALUES (104, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 02:50:35');
INSERT INTO `china_total` VALUES (105, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (106, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (107, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (108, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (109, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (110, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (111, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (112, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (113, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (114, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (115, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (116, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 03:35:37');
INSERT INTO `china_total` VALUES (117, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (118, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (119, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (120, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (121, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (122, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (123, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (124, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (125, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (126, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (127, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (128, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (129, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (130, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');
INSERT INTO `china_total` VALUES (131, 2899852, 18770, 0, 293988, 17423, 0, '2022-06-05 05:40:38');

-- ----------------------------
-- Table structure for health_clock
-- ----------------------------
DROP TABLE IF EXISTS `health_clock`;
CREATE TABLE `health_clock`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `morning_temp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `afternoon_temp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `night_temp` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fever_and_cough` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recent_home` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `risk_zone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `recent_zone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `health_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of health_clock
-- ----------------------------
INSERT INTO `health_clock` VALUES (1, '9999', '男', 63, '18333603859', '36.5', '36.5', '36.5', '不发烧咳嗽', '西数', '高风险', '从西川到北京来玩', '健康', '2022-05-26 20:06:12');
INSERT INTO `health_clock` VALUES (7, '好人', '男', 20, '12546852411', '36', NULL, NULL, NULL, '江门', '低风险', '江门', 'good', '2022-12-14 00:33:20');

-- ----------------------------
-- Table structure for hesuan
-- ----------------------------
DROP TABLE IF EXISTS `hesuan`;
CREATE TABLE `hesuan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `result` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hesuan
-- ----------------------------
INSERT INTO `hesuan` VALUES (1, '王心凌', 25, '18333603843', '131022199804251122', '混检', '阴性', '2022-06-11 09:59:56', '2022-06-11 09:59:59');
INSERT INTO `hesuan` VALUES (3, '诸葛孔明', 54, '18333603843', '121212121', '个测', '阴性', '2022-06-10 16:00:00', '2022-06-10 16:00:00');
INSERT INTO `hesuan` VALUES (4, '刘玄德', 25, '18333603843', '1310121212', '咽式嗓子', '阳性', '2022-06-10 16:00:00', '2022-06-10 16:00:00');

-- ----------------------------
-- Table structure for line_trend
-- ----------------------------
DROP TABLE IF EXISTS `line_trend`;
CREATE TABLE `line_trend`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `confirm` int(11) NULL DEFAULT NULL,
  `isolation` int(11) NULL DEFAULT NULL,
  `cure` int(11) NULL DEFAULT NULL,
  `dead` int(11) NULL DEFAULT NULL,
  `similar` int(11) NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of line_trend
-- ----------------------------
INSERT INTO `line_trend` VALUES (1, 786, 456, 79, 53, 123, '2022-05-18 19:12:52');
INSERT INTO `line_trend` VALUES (2, 1000, 563, 96, 78, 213, '2022-05-19 19:13:59');
INSERT INTO `line_trend` VALUES (3, 1200, 653, 115, 98, 312, '2022-05-20 19:14:26');
INSERT INTO `line_trend` VALUES (4, 1563, 759, 165, 110, 320, '2022-05-21 19:14:48');
INSERT INTO `line_trend` VALUES (5, 1789, 865, 220, 210, 365, '2022-05-22 19:15:13');
INSERT INTO `line_trend` VALUES (6, 2134, 987, 276, 256, 400, '2022-05-23 19:15:37');
INSERT INTO `line_trend` VALUES (7, 2563, 1100, 350, 320, 456, '2022-05-24 19:16:14');
INSERT INTO `line_trend` VALUES (8, 1563, 563, 220, 123, 243, '2022-05-25 19:50:26');
INSERT INTO `line_trend` VALUES (9, 3000, 123, 456, 321, 156, '2022-05-26 19:54:25');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `open` int(11) NULL DEFAULT NULL,
  `ordernum` int(11) NULL DEFAULT NULL,
  `available` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, 0, 'menu', '疫情数据可视化', NULL, '&#xe629;', '', 0, 1, 1);
INSERT INTO `menu` VALUES (2, 1, 'menu', '中国疫情地图', NULL, '&#xe62c;', '/toChina', 0, 2, 1);
INSERT INTO `menu` VALUES (3, 1, 'menu', '疫情饼图', NULL, '&#xe62c;', '/toPie', 0, 3, 1);
INSERT INTO `menu` VALUES (4, 1, 'menu', '疫情柱状图', NULL, '&#xe62c;', '/toBar', 0, 4, 1);
INSERT INTO `menu` VALUES (5, 1, 'menu', '疫情折线图', NULL, '&#xe62c;', '/toLine', 0, 5, 1);
INSERT INTO `menu` VALUES (6, 1, 'menu', '全球疫情地图', NULL, '&#xe62c;', '/toGlobal', 0, 6, 1);
INSERT INTO `menu` VALUES (7, 0, 'menu', '疫情数据管理', NULL, '&#xe62d;', NULL, 0, 7, 1);
INSERT INTO `menu` VALUES (8, 7, 'menu', '中国疫情数据管理', NULL, '&#xe62d;', '/toChinaManager', 0, 8, 1);
INSERT INTO `menu` VALUES (9, 0, 'menu', '校园防疫管理', NULL, '&#xe679;', '', 0, 9, 1);
INSERT INTO `menu` VALUES (10, 9, 'menu', '健康打卡记录', NULL, '&#xe62a;', '/toHealthClock', 0, 10, 1);
INSERT INTO `menu` VALUES (11, 0, 'menu', '系统管理', NULL, '&#xe716;', NULL, 1, 17, 1);
INSERT INTO `menu` VALUES (12, 11, 'menu', '菜单管理', NULL, '&#xe649;', '/menu/toMenu', 0, 18, 1);
INSERT INTO `menu` VALUES (14, 11, 'menu', '角色管理', NULL, '&#xe6af;', '/role/toRole', 1, 19, 1);
INSERT INTO `menu` VALUES (18, 11, 'menu', '用户管理', NULL, '&#xe613;', '/user/toUser', 1, 20, 1);
INSERT INTO `menu` VALUES (20, 7, 'menu', '疫情新闻管理', NULL, '&#xe7ae;', '/news/toNews', 1, 15, 1);
INSERT INTO `menu` VALUES (21, 0, 'menu', '校园系统管理', NULL, '&#xe66c;', NULL, 0, 16, 1);
INSERT INTO `menu` VALUES (22, 21, 'menu', '学院管理', NULL, '&#xe62e;', '/xueyuan/toXueYuan', 1, 21, 1);
INSERT INTO `menu` VALUES (23, 21, 'menu', '班级管理', NULL, '&#xe62b;', '/banji/toBanJi', 1, 22, 1);
INSERT INTO `menu` VALUES (24, 9, 'menu', '请假审批管理', NULL, '&#xe672;', '/approval/toApproval', 1, 23, 1);

-- ----------------------------
-- Table structure for nocv_data
-- ----------------------------
DROP TABLE IF EXISTS `nocv_data`;
CREATE TABLE `nocv_data`  (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` int(11) NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nocv_data
-- ----------------------------
INSERT INTO `nocv_data` VALUES (1, '台湾', 10850, '2022-12-13 00:18:23');
INSERT INTO `nocv_data` VALUES (2, '香港', 1561, '2022-12-13 00:18:24');
INSERT INTO `nocv_data` VALUES (3, '湖北', 107, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (4, '吉林', 46, '2022-12-13 00:59:23');
INSERT INTO `nocv_data` VALUES (5, '广东', 2080, '2022-12-13 00:59:25');
INSERT INTO `nocv_data` VALUES (6, '陕西', 117, '2022-12-13 00:59:24');
INSERT INTO `nocv_data` VALUES (7, '福建', 67, '2022-12-13 00:18:23');
INSERT INTO `nocv_data` VALUES (8, '河南', 156, '2022-12-13 00:59:23');
INSERT INTO `nocv_data` VALUES (9, '浙江', 319, '2022-12-13 00:18:23');
INSERT INTO `nocv_data` VALUES (10, '黑龙江', 236, '2022-12-13 16:00:54');
INSERT INTO `nocv_data` VALUES (11, '山东', 232, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (12, '四川', 131, '2022-12-13 00:18:23');
INSERT INTO `nocv_data` VALUES (13, '江苏', 81, '2022-12-13 00:18:23');
INSERT INTO `nocv_data` VALUES (14, '云南', 96, '2022-12-13 00:19:23');
INSERT INTO `nocv_data` VALUES (15, '河北', 127, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (16, '天津', 222, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (17, '内蒙古', 13, '2022-12-13 00:18:24');
INSERT INTO `nocv_data` VALUES (18, '辽宁', 60, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (19, '广西', 44, '2022-12-13 00:59:24');
INSERT INTO `nocv_data` VALUES (20, '湖南', 11, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (21, '江西', 3, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (22, '安徽', 23, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (23, '新疆', 7, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (24, '重庆', 1578, '2022-12-13 00:19:23');
INSERT INTO `nocv_data` VALUES (25, '甘肃', 3, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (26, '山西', 243, '2022-12-13 00:18:23');
INSERT INTO `nocv_data` VALUES (27, '海南', 250, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (28, '贵州', 1, '2022-12-13 16:00:55');
INSERT INTO `nocv_data` VALUES (29, '上海', 219, '2022-12-13 16:00:54');
INSERT INTO `nocv_data` VALUES (30, '宁夏', 26, '2022-12-14 16:00:55');
INSERT INTO `nocv_data` VALUES (31, '澳门', 834, '2022-12-14 16:00:54');
INSERT INTO `nocv_data` VALUES (32, '西藏', 5, '2022-12-13 16:00:54');
INSERT INTO `nocv_data` VALUES (33, '上海市', 865, NULL);
INSERT INTO `nocv_data` VALUES (34, '芜湖', 12, NULL);

-- ----------------------------
-- Table structure for nocv_global_data
-- ----------------------------
DROP TABLE IF EXISTS `nocv_global_data`;
CREATE TABLE `nocv_global_data`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nocv_global_data
-- ----------------------------
INSERT INTO `nocv_global_data` VALUES (1, 'United States', 2055555);
INSERT INTO `nocv_global_data` VALUES (2, 'China', 88888);
INSERT INTO `nocv_global_data` VALUES (3, 'Brazil', 691750008);
INSERT INTO `nocv_global_data` VALUES (4, 'Russia', 10000000);
INSERT INTO `nocv_global_data` VALUES (5, 'United Kingdom', 5000000);
INSERT INTO `nocv_global_data` VALUES (6, 'Spain', 653256);
INSERT INTO `nocv_global_data` VALUES (7, 'France', 195686);
INSERT INTO `nocv_global_data` VALUES (8, 'Germany', 1568956);
INSERT INTO `nocv_global_data` VALUES (9, 'Canada', 1000000);
INSERT INTO `nocv_global_data` VALUES (10, 'Australia', 2000000);
INSERT INTO `nocv_global_data` VALUES (11, 'Japan', 8000000);
INSERT INTO `nocv_global_data` VALUES (12, 'Sudan', 9000000);

-- ----------------------------
-- Table structure for nocv_news
-- ----------------------------
DROP TABLE IF EXISTS `nocv_news`;
CREATE TABLE `nocv_news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `publishby` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nocv_news
-- ----------------------------
INSERT INTO `nocv_news` VALUES (1, '药品需求过高！', '连花清瘟胶囊一盒难求！', '2022-12-14 00:19:04', '热心市民廖先生');
INSERT INTO `nocv_news` VALUES (5, '震惊！', '华商1阳人', '2022-12-14 00:16:10', 'somebody');
INSERT INTO `nocv_news` VALUES (6, '震惊！日本2:1德国', '某男子买1000w德国赢现已离奇失踪', '2022-12-14 00:11:07', 'goodman');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', '拥有所有的权限');
INSERT INTO `role` VALUES (2, '教师', '拥有部分增删改查功能');
INSERT INTO `role` VALUES (3, '学生', '拥有查询与请假功能');
INSERT INTO `role` VALUES (5, '学院院长', '拥有所有菜单栏的增删改查功能');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `rid` int(11) NULL DEFAULT NULL,
  `mid` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1);
INSERT INTO `role_menu` VALUES (1, 2);
INSERT INTO `role_menu` VALUES (1, 3);
INSERT INTO `role_menu` VALUES (1, 4);
INSERT INTO `role_menu` VALUES (1, 5);
INSERT INTO `role_menu` VALUES (1, 6);
INSERT INTO `role_menu` VALUES (1, 7);
INSERT INTO `role_menu` VALUES (1, 8);
INSERT INTO `role_menu` VALUES (1, 20);
INSERT INTO `role_menu` VALUES (1, 9);
INSERT INTO `role_menu` VALUES (1, 10);
INSERT INTO `role_menu` VALUES (1, 11);
INSERT INTO `role_menu` VALUES (1, 12);
INSERT INTO `role_menu` VALUES (1, 14);
INSERT INTO `role_menu` VALUES (1, 18);
INSERT INTO `role_menu` VALUES (1, 21);
INSERT INTO `role_menu` VALUES (1, 22);
INSERT INTO `role_menu` VALUES (1, 23);
INSERT INTO `role_menu` VALUES (5, 1);
INSERT INTO `role_menu` VALUES (5, 2);
INSERT INTO `role_menu` VALUES (5, 3);
INSERT INTO `role_menu` VALUES (5, 4);
INSERT INTO `role_menu` VALUES (5, 5);
INSERT INTO `role_menu` VALUES (5, 6);
INSERT INTO `role_menu` VALUES (5, 7);
INSERT INTO `role_menu` VALUES (5, 8);
INSERT INTO `role_menu` VALUES (5, 20);
INSERT INTO `role_menu` VALUES (5, 9);
INSERT INTO `role_menu` VALUES (5, 10);
INSERT INTO `role_menu` VALUES (5, 11);
INSERT INTO `role_menu` VALUES (5, 12);
INSERT INTO `role_menu` VALUES (5, 21);
INSERT INTO `role_menu` VALUES (5, 22);
INSERT INTO `role_menu` VALUES (5, 23);
INSERT INTO `role_menu` VALUES (3, 1);
INSERT INTO `role_menu` VALUES (3, 2);
INSERT INTO `role_menu` VALUES (3, 3);
INSERT INTO `role_menu` VALUES (3, 4);
INSERT INTO `role_menu` VALUES (3, 5);
INSERT INTO `role_menu` VALUES (3, 6);
INSERT INTO `role_menu` VALUES (3, 9);
INSERT INTO `role_menu` VALUES (3, 24);
INSERT INTO `role_menu` VALUES (2, 1);
INSERT INTO `role_menu` VALUES (2, 2);
INSERT INTO `role_menu` VALUES (2, 3);
INSERT INTO `role_menu` VALUES (2, 4);
INSERT INTO `role_menu` VALUES (2, 5);
INSERT INTO `role_menu` VALUES (2, 6);
INSERT INTO `role_menu` VALUES (2, 7);
INSERT INTO `role_menu` VALUES (2, 8);
INSERT INTO `role_menu` VALUES (2, 20);
INSERT INTO `role_menu` VALUES (2, 9);
INSERT INTO `role_menu` VALUES (2, 10);
INSERT INTO `role_menu` VALUES (2, 24);
INSERT INTO `role_menu` VALUES (2, 21);
INSERT INTO `role_menu` VALUES (2, 23);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `ban_ji_id` int(11) NULL DEFAULT NULL,
  `xue_yuan_id` int(11) NULL DEFAULT NULL,
  `teacher_id` int(11) NULL DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ban_ji_id`(`ban_ji_id`) USING BTREE,
  INDEX `xue_yuan_id`(`xue_yuan_id`) USING BTREE,
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`ban_ji_id`) REFERENCES `ban_ji` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_ibfk_3` FOREIGN KEY (`xue_yuan_id`) REFERENCES `xue_yuan` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', '1', 25, '北京市', '/images/admin1.jpg', '18333603846', '666888', 1, 1, NULL, NULL);
INSERT INTO `user` VALUES (3, 'student', '456789', '1', 18, '江门', '/images/student1.png', '13164587451', '4406666', 1, 1, NULL, NULL);
INSERT INTO `user` VALUES (4, 'teacher', '123456', '1', 25, '广州', '/images/teacher1.png', '13574855124', '44078645452', 1, 1, NULL, NULL);
INSERT INTO `user` VALUES (5, 'yuanzhang', '123456', '1', 40, '上海', '/images/yuanzhang1.png', '12457896547', '44012457835', 4, 2, NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `uid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (3, 3);
INSERT INTO `user_role` VALUES (1, 1);
INSERT INTO `user_role` VALUES (1, 2);
INSERT INTO `user_role` VALUES (1, 3);
INSERT INTO `user_role` VALUES (1, 5);
INSERT INTO `user_role` VALUES (4, 2);
INSERT INTO `user_role` VALUES (5, 5);

-- ----------------------------
-- Table structure for vaccine
-- ----------------------------
DROP TABLE IF EXISTS `vaccine`;
CREATE TABLE `vaccine`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `zhenci` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pici` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `changjia` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `danwei` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vaccine
-- ----------------------------
INSERT INTO `vaccine` VALUES (1, '周瑜打嘟嘟', 66, '18333603843', '131313131', '三针', 'HBAHSDGH1212', '北京生物', '某某剖医院', '2022-06-02 16:00:00');
INSERT INTO `vaccine` VALUES (2, '王一宁', 25, '18333603843', '131202264515545', '三针', '第二批次', '北京生物', '华北电力大学', '2022-06-10 16:00:00');

-- ----------------------------
-- Table structure for xue_yuan
-- ----------------------------
DROP TABLE IF EXISTS `xue_yuan`;
CREATE TABLE `xue_yuan`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xue_yuan
-- ----------------------------
INSERT INTO `xue_yuan` VALUES (1, '数据科学学院');
INSERT INTO `xue_yuan` VALUES (2, '金融学院');
INSERT INTO `xue_yuan` VALUES (3, '马克思主义学院');

SET FOREIGN_KEY_CHECKS = 1;
