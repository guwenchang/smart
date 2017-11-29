/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : smart

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-29 19:25:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for smart_dic
-- ----------------------------
DROP TABLE IF EXISTS `smart_dic`;
CREATE TABLE `smart_dic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主鍵id',
  `code` varchar(32) DEFAULT NULL COMMENT '字典编码',
  `value` varchar(32) DEFAULT NULL COMMENT '字典值',
  `name` varchar(32) DEFAULT NULL COMMENT '字典视图值',
  `order_num` int(11) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COMMENT='字典数据';

-- ----------------------------
-- Records of smart_dic
-- ----------------------------
INSERT INTO `smart_dic` VALUES ('1', 'educationType', '1', '博士', '1');
INSERT INTO `smart_dic` VALUES ('2', 'educationType', '2', '硕士', '2');
INSERT INTO `smart_dic` VALUES ('3', 'educationType', '3', '本科', '3');
INSERT INTO `smart_dic` VALUES ('4', 'educationType', '4', '大专', '4');
INSERT INTO `smart_dic` VALUES ('5', 'educationType', '5', '中专', '5');
INSERT INTO `smart_dic` VALUES ('6', 'educationType', '6', '高中', '6');
INSERT INTO `smart_dic` VALUES ('7', 'educationType', '7', '初中', '7');
INSERT INTO `smart_dic` VALUES ('8', 'educationType', '8', '小学', '8');
INSERT INTO `smart_dic` VALUES ('9', 'educationType', '9', '文盲', '9');
INSERT INTO `smart_dic` VALUES ('13', 'professionType', '1', '干部', '1');
INSERT INTO `smart_dic` VALUES ('14', 'professionType', '2', '专业技术人员', '2');
INSERT INTO `smart_dic` VALUES ('15', 'professionType', '3', '工人', '3');
INSERT INTO `smart_dic` VALUES ('16', 'professionType', '4', '农民', '4');
INSERT INTO `smart_dic` VALUES ('17', 'professionType', '5', '职员', '5');
INSERT INTO `smart_dic` VALUES ('18', 'professionType', '6', '军人', '6');
INSERT INTO `smart_dic` VALUES ('19', 'professionType', '7', '自由职业', '7');
INSERT INTO `smart_dic` VALUES ('20', 'professionType', '8', '无', '8');
INSERT INTO `smart_dic` VALUES ('97', 'maritalStatus', '1', '未婚', '1');
INSERT INTO `smart_dic` VALUES ('98', 'maritalStatus', '2', '初婚', '2');
INSERT INTO `smart_dic` VALUES ('99', 'maritalStatus', '3', '再婚', '3');
INSERT INTO `smart_dic` VALUES ('100', 'nation', '1', '汉族', '1');
INSERT INTO `smart_dic` VALUES ('101', 'nation', '2', '少数民族', '2');

-- ----------------------------
-- Table structure for smart_user
-- ----------------------------
DROP TABLE IF EXISTS `smart_user`;
CREATE TABLE `smart_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `nick_name` varchar(32) DEFAULT NULL COMMENT '昵称',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `salt` varchar(20) DEFAULT NULL COMMENT '盐',
  `open_id` varchar(64) DEFAULT NULL COMMENT 'openid',
  `union_id` varchar(255) DEFAULT NULL COMMENT '微信唯一id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `is_stop` bit(1) DEFAULT b'0' COMMENT '是否停用',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COMMENT='业务用户';

-- ----------------------------
-- Records of smart_user
-- ----------------------------
INSERT INTO `smart_user` VALUES ('1', '15210015381', '顾小白', 'E10ADC3949BA59ABBE56E057F20F883E', null, null, null, '', '\0', '2017-10-09 16:05:51');
INSERT INTO `smart_user` VALUES ('87', '18518769512', null, '094A1C11518555662C972193F7C4AE19', null, null, null, null, '\0', '2017-11-10 15:25:26');
INSERT INTO `smart_user` VALUES ('88', '18109405346', null, '9E09890CBBD1A265503B30DDC891A57E', null, null, null, 'blob:http://127.0.0.1:8080/bb3005ab-ad4b-4275-8055-c8978f25c6be', '\0', '2017-11-10 19:00:15');
INSERT INTO `smart_user` VALUES ('89', '18298374985', null, '0C83EBDBB44533815B0391396F6DDC91', null, null, null, 'http://otqeble9t.bkt.clouddn.com/FqvfCdgCEFf8EkqSH978MeajPTaq', '\0', '2017-11-10 19:03:39');
INSERT INTO `smart_user` VALUES ('91', 'string', null, 'B2F5FF47436671B6E533D8DC3614845D', null, null, null, 'string', '\0', '2017-11-17 11:27:11');
INSERT INTO `smart_user` VALUES ('92', '18518769512', null, '094A1C11518555662C972193F7C4AE19', null, null, null, null, '\0', '2017-11-17 12:03:28');
INSERT INTO `smart_user` VALUES ('93', '18518769512', null, '094A1C11518555662C972193F7C4AE19', null, null, null, null, '\0', '2017-11-17 12:15:20');
INSERT INTO `smart_user` VALUES ('94', '18518769512', null, '094A1C11518555662C972193F7C4AE19', null, null, null, null, '\0', '2017-11-17 12:25:53');
INSERT INTO `smart_user` VALUES ('102', '18210192900', null, 'C438A342F0DBB2982F21D1BEFEED8AF1', null, null, null, null, '\0', '2017-11-17 23:51:34');
INSERT INTO `smart_user` VALUES ('104', null, null, null, null, null, null, null, '\0', '2017-11-20 14:07:53');
INSERT INTO `smart_user` VALUES ('105', null, null, null, null, null, null, null, '\0', '2017-11-20 16:38:41');
INSERT INTO `smart_user` VALUES ('106', null, null, null, null, null, null, null, '\0', '2017-11-20 17:12:42');
INSERT INTO `smart_user` VALUES ('107', null, null, null, null, null, null, null, '\0', '2017-11-20 17:14:22');
INSERT INTO `smart_user` VALUES ('108', null, null, null, null, null, null, null, '\0', '2017-11-20 17:18:53');
INSERT INTO `smart_user` VALUES ('109', null, null, null, null, null, null, null, '\0', '2017-11-20 17:19:13');
INSERT INTO `smart_user` VALUES ('110', null, null, null, null, null, null, null, '\0', '2017-11-20 17:19:46');
INSERT INTO `smart_user` VALUES ('111', null, null, null, null, null, null, null, '\0', '2017-11-20 17:20:09');
INSERT INTO `smart_user` VALUES ('112', null, null, null, null, null, null, null, '\0', '2017-11-20 17:22:31');
INSERT INTO `smart_user` VALUES ('113', '18518769512', null, '094A1C11518555662C972193F7C4AE19', null, null, null, null, '\0', '2017-11-22 12:24:05');
INSERT INTO `smart_user` VALUES ('114', '18518769512', null, '094A1C11518555662C972193F7C4AE19', null, null, null, null, '\0', '2017-11-22 12:24:16');
INSERT INTO `smart_user` VALUES ('115', '18518769512', null, '094A1C11518555662C972193F7C4AE19', null, null, null, null, '\0', '2017-11-22 12:25:01');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '上级部门ID，一级部门为0',
  `name` varchar(20) DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `is_deleted` bit(1) DEFAULT b'0' COMMENT '状态  1：禁用   0：正常',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='菜单权限管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '0', '系统管理', null, null, '0', 'system', '1');
INSERT INTO `sys_menu` VALUES ('2', '1', '用户管理', '/sys/user/list', 'userList', '1', 'system', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '角色管理', '/sys/role/list', 'roleList', '1', 'system', '2');
INSERT INTO `sys_menu` VALUES ('4', '1', '权限管理', '/sys/menu/list', 'menuList', '1', 'system', '3');
INSERT INTO `sys_menu` VALUES ('5', '1', '字典数据', '/sys/dic/list', 'dicList', '1', 'system', '4');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', '后台管理员', '2017-07-27 15:40:23');
INSERT INTO `sys_role` VALUES ('9', '测试车', '测测', '2017-11-28 17:49:13');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='角色与菜单对应关系';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('14', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('15', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('16', '1', '3');
INSERT INTO `sys_role_menu` VALUES ('17', '1', '4');
INSERT INTO `sys_role_menu` VALUES ('18', '1', '5');
INSERT INTO `sys_role_menu` VALUES ('23', '9', '2');
INSERT INTO `sys_role_menu` VALUES ('24', '9', '3');
INSERT INTO `sys_role_menu` VALUES ('25', '9', '4');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `real_name` varchar(32) DEFAULT '' COMMENT '姓名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `salt` varchar(32) DEFAULT NULL COMMENT '盐',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '部门id',
  `is_stop` bit(1) DEFAULT b'0' COMMENT '状态  1：禁用   0：正常',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '管理员', '9FE469EF74F17DC7809655D86218ED27', '15210015381', '3f41de1c7dda447ab450ff011e363f89', '1', '\0', '2016-11-09 11:11:11');
INSERT INTO `sys_user` VALUES ('2', '测试测试', '9DD1F6392D04539324C0718D53B08137', '17611265680', '8ec18253a557497dbbe4ad88d3aaf03f', null, '\0', '2017-11-29 17:56:29');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户与角色对应关系';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('13', '1', '1');
INSERT INTO `sys_user_role` VALUES ('14', '1', '9');
INSERT INTO `sys_user_role` VALUES ('15', '2', '1');
