CREATE TABLE youqu.user_privilege
(
    id bigint(20) PRIMARY KEY NOT NULL,
    privilege_name varchar(45) COMMENT '权限',
    menu_name varchar(8) COMMENT '菜单显示名称',
    parent_id bigint(20) COMMENT '所属父级id',
    state_name varchar(50) COMMENT '模块名称',
    creator varchar(25) COMMENT '创建人',
    create_time datetime COMMENT '创建时间
',
    modifier varchar(25) COMMENT '修改人',
    modify_time datetime COMMENT '修改时间'
);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012217304838991, 'HOME_MANAGER', '首页管理', null, 'content.statistic', 'wangdm', '2019-01-03 10:28:26', null, null);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012309324848206, 'HOME_STATISTICS', '首页统计', 2019010310282628593, 'content.statistic.statistics', 'wangdm', '2019-01-03 10:28:26', null, null);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012309324848353, 'SYSTEM_ORDER_INFO_MANAGER', '订单管理', null, 'content.order', 'wangdm', '2019-01-03 10:28:26', null, null);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012309324848357, 'SYSTEM_ORDER_INFO', '订单信息', 2019012114394755363, 'content.order.systemOrderInfo', 'wangdm', '2019-01-03 10:28:26', null, null);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012309324848366, 'SYSTEM_USER_INFO', '用户信息', 2019012114372599800, 'content.user.system', 'wangdm', '2019-01-03 10:28:26', null, null);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012309324848368, 'SYSTEM_LOG', '系统日志', 2019012114340709504, 'content.system.systemLog', 'wangdm', '2019-01-03 10:28:26', null, null);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012309324848370, 'SYSTEM_CONSTANT', '系统常量', 2019012114340709504, 'content.system.systemConstant', 'wangdm', '2019-01-03 10:28:26', null, null);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012309324848382, 'SYSTEM_USER_MANAGER', '用户管理', null, 'content.user', 'wangdm', '2019-01-03 10:28:26', null, null);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012309324848385, 'SYSTEM_MANAGER', '系统管理', null, 'content.system', 'wangdm', '2019-01-03 10:28:26', null, null);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012309324848394, 'SYSTEM_UER_ROLE', '用户角色', 2019012114372599800, 'content.user.systemRole', 'wangdm', '2019-01-03 10:28:26', null, null);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012309324848446, 'SYSTEM_MERCHANT_INFO', '商品信息', 2019012114411518836, 'content.merchant.systemMerchantInfo', 'wangdm', '2019-01-03 10:28:26', null, null);
INSERT INTO youqu.user_privilege (id, privilege_name, menu_name, parent_id, state_name, creator, create_time, modifier, modify_time) VALUES (2019012309324848480, 'SYSTEM_MERCHANT_INFO_MANAGER', '商品管理', null, 'content.merchant', 'wangdm', '2019-01-03 10:28:26', null, null);