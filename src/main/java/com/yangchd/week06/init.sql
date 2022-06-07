/* 用户表*/
CREATE TABLE IF NOT EXISTS `user` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(32) NOT NULL comment '名称',
    `password` varchar(64) NOT NULL comment '密码',
    `phone` varchar(32) NOT NULL comment '收集号码',
    `identify_card` varchar(32) NOT NULL comment '身份证号',
    `email` varchar(64) NOT NULL comment '邮箱',
    `create_time` int NOT NULL,
    `update_time` int NOT NULL,
    `create_user` int NOT NULL,
    `update_user` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET='utf8mb4'

/* 商品表*/
CREATE TABLE IF NOT EXISTS `good` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(32) NOT NULL comment '名称',
    `description` varchar(1024) NOT NULL comment '描述',
    `price` int NOT NULL,
    `create_time` int NOT NULL,
    `update_time` int NOT NULL,
    `create_user` int NOT NULL,
    `update_user` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET='utf8mb4'

/* 商店表*/
CREATE TABLE IF NOT EXISTS `store` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(32) NOT NULL comment '名称',
    `description` varchar(1024) comment '描述' NOT NULL,
    `create_time` int NOT NULL,
    `update_time` int NOT NULL,
    `create_user` int NOT NULL,
    `update_user` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET='utf8mb4'

/* 订单表*/
CREATE TABLE IF NOT EXISTS `order` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `status` int NOT NULL comment '状态',
    `code` varchar(32) NOT NULL comment '编号',
    `create_time` int NOT NULL,
    `update_time` int NOT NULL,
    `create_user` int NOT NULL,
    `update_user` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET='utf8mb4'

/* 商店商品关系表*/
CREATE TABLE IF NOT EXISTS `good_store` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `good_id` bigint NOT NULL comment '商品id',
    `store_id` bigint NOT NULL comment '商店id',
    `create_time` int NOT NULL,
    `update_time` int NOT NULL,
    `create_user` int NOT NULL,
    `update_user` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET='utf8mb4'

/* 商品订单关系表*/
CREATE TABLE IF NOT EXISTS `good_order` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `good_id` bigint NOT NULL comment '商品id',
    `order_id` bigint NOT NULL comment '订单id',
    `create_time` int NOT NULL,
    `update_time` int NOT NULL,
    `create_user` int NOT NULL,
    `update_user` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET='utf8mb4'

