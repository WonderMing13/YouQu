CREATE TABLE youqu.user_info_role
(
    id bigint(20) PRIMARY KEY NOT NULL,
    user_id bigint(20) COMMENT 'user_info的外键',
    role_id bigint(20) COMMENT 'user_role的外键
',
    creator varchar(10) COMMENT '创建人',
    create_time datetime COMMENT '创建时间',
    modifier varchar(10) COMMENT '确认人',
    modify_time datetime COMMENT '确认时间'
);
CREATE UNIQUE INDEX user_info_role_id_uindex ON youqu.user_info_role (id);
INSERT INTO youqu.user_info_role (id, user_id, role_id, creator, create_time, modifier, modify_time) VALUES (2019012217304837758, 2019012217304837178, 2019012217304837787, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_info_role (id, user_id, role_id, creator, create_time, modifier, modify_time) VALUES (2019012217304837759, 2019012217304837178, 2019012217304837788, 'wangdm', '2019-01-22 17:30:48', null, null);