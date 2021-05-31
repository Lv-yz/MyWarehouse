CREATE DATABASE IF NOT EXISTS MyWarehouse;
use MyWarehouse;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 管理员信息表
-- ----------------------------
DROP TABLE IF EXISTS `Manager`;
CREATE TABLE `Manager` (
`MANAGER_ID` VARCHAR(5) NOT NULL COMMENT '管理员编号',
`MANAGER_NAME` VARCHAR(6) NOT NULL COMMENT '管理员名称',
`PASSWORD` VARCHAR(6)  NOT NULL COMMENT '管理员密码',
PRIMARY KEY (`MANAGER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- 管理员信息初始化
-- ----------------------------
BEGIN;
INSERT INTO `Manager` VALUES ('1001','admin','123456');
INSERT INTO `Manager` VALUES ('1002','handle','123456');
COMMIT;

-- ----------------------------
-- 供应商信息表
-- ----------------------------
DROP TABLE IF EXISTS `Provider`;
CREATE TABLE `Provider` (
`PROVIDER_ID` VARCHAR(5) NOT NULL COMMENT '供应商id',
`PROVIDER_NAME` varchar(20) NOT NULL COMMENT '供应商名称',
`PROVIDER_ADDRESS` varchar(30) DEFAULT NULL COMMENT '供应商地址',
`PROVIDER_TEL` varchar(11) NOT NULL COMMENT '供应商电话',
PRIMARY KEY (`PROVIDER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- 供应商信息初始化
-- ----------------------------
-- BEGIN;
-- INSERT INTO `Provider` VALUES ('1101','','','');
--
-- COMMIT;

-- ----------------------------
-- 客户信息表
-- ----------------------------
DROP TABLE IF EXISTS `Customer`;
CREATE TABLE `Customer` (
`CUSTOMER_ID` VARCHAR(5) NOT NULL COMMENT '客户id',
`CUSTOMER_NAME` VARCHAR(20) NOT NULL COMMENT '客户名',
`CUSTOMER_TEL` varchar(20) NOT NULL COMMENT '客户电话',
`CUSTOMER_ADDRESS` varchar(30) DEFAULT NULL COMMENT '客户地址',
PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- 客户信息表初始化
-- ----------------------------
-- BEGIN;
-- INSERT INTO `Customer` VALUES ('1214', '醴陵荣旗瓷业有限公司', '17716786888','中国 湖南 醴陵市 嘉树乡玉茶村柏树组');
-- INSERT INTO `Customer` VALUES ('1215', '深圳市松林达电子有限公司', '85263335-820','中国 广东 深圳市宝安区 深圳市宝安区福永社区桥头村桥塘路育');
-- INSERT INTO `Customer` VALUES ('1216', '郑州绿之源饮品有限公司 ', '87094196','中国 河南 郑州市 郑州市嘉亿东方大厦609');
-- COMMIT;

-- ----------------------------
-- 物品信息表
-- ----------------------------
DROP TABLE IF EXISTS `Goods`;
CREATE TABLE `Goods` (
`GOOD_ID` VARCHAR(5) NOT NULL COMMENT '物品id',
`GOOD_NAME` varchar(20) NOT NULL COMMENT '物品名称',
`GOOD_TYPE` varchar(5) DEFAULT NULL COMMENT '物品类型',
`GOOD_VALUE` double NOT NULL COMMENT '物品数量',
`GOOD_PAPER` varchar(5) NOT NULL COMMENT '物品单位',
PRIMARY KEY (`GOOD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- 武平信息表初始化
-- ----------------------------
-- BEGIN;
-- INSERT INTO `wms_goods` VALUES (103,'五孔插座西门子墙壁开关','电器',1.85);
-- INSERT INTO `wms_goods` VALUES (104,'陶瓷马克杯','陶瓷',3.5);
-- INSERT INTO `wms_goods` VALUES (105,'精酿苹果醋','饮料',300);
-- INSERT INTO `wms_goods` VALUES (106,'王老吉','饮料',18900);
-- COMMIT;
DROP TABLE IF EXISTS `Goods_In`;
CREATE TABLE `Goods_In` (
`GOOD_IN_ID` VARCHAR(5) NOT NULL COMMENT '入库单编号',
`GOOD_ID` VARCHAR(5) NOT NULL COMMENT '物品id',
`PROVIDER_ID` VARCHAR(5) NOT NULL COMMENT '供应商id',
`GOOD_DATE` DATE NOT NULL COMMENT '入库时间',
`GOOD_VALUE` DOUBLE NOT NULL COMMENT '入库单价',
`GOOD_NUM` INT NOT NULL COMMENT '入库数量',
PRIMARY KEY (`GOOD_IN_ID`),
FOREIGN KEY(`GOOD_ID`) REFERENCES `Goods`(`GOOD_ID`),
FOREIGN KEY(`PROVIDER_ID`) REFERENCES `Provider`(`PROVIDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `Goods_Out`;
CREATE TABLE `Goods_Out` (
`GOOD_OUT_ID` VARCHAR(5) NOT NULL COMMENT '出库单编号',
`GOOD_ID` VARCHAR(5) NOT NULL COMMENT '物品id',
`CUSTOMER_ID` VARCHAR(5) NOT NULL COMMENT '客户id',
`GOOD_DATE` DATE NOT NULL COMMENT '出库时间',
`GOOD_VALUE` DOUBLE NOT NULL COMMENT '出库单价',
`GOOD_NUM` INT NOT NULL COMMENT '出库数量',
PRIMARY KEY (`GOOD_OUT_ID`),
FOREIGN KEY(`GOOD_ID`) REFERENCES `Goods`(`GOOD_ID`),
FOREIGN KEY(`CUSTOMER_ID`) REFERENCES `Customer`(`CUSTOMER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;


SET FOREIGN_KEY_CHECKS = 1;
