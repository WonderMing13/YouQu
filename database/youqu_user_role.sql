CREATE TABLE youqu.user_role
(
    id bigint(20) PRIMARY KEY NOT NULL,
    role varchar(45) COMMENT '角色',
    role_name varchar(5) COMMENT '角色名称',
    is_apply smallint(6) COMMENT '是否启用 0:禁用 1:启用',
    creator varchar(15) COMMENT '创建人',
    create_time datetime COMMENT '创建时间',
    modifier varchar(15) COMMENT '确认人',
    modify_time datetime COMMENT '确认时间'
);
INSERT INTO youqu.user_role (id, role, role_name, is_apply, creator, create_time, modifier, modify_time) VALUES (2019012217304837787, 'ADMIN', '管理员', 1, 'wangdm', '2019-01-22 17:30:48', null, null);