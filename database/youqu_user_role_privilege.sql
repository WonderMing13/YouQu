CREATE TABLE youqu.user_role_privilege
(
    id bigint(20) PRIMARY KEY NOT NULL,
    role_id bigint(20) COMMENT 'user_role表的外键',
    privilege_id bigint(20) COMMENT 'user_privilege表的外键',
    creator varchar(10) COMMENT '创建人',
    create_time datetime COMMENT '创建时间',
    modifier varchar(10) COMMENT '修改人',
    modify_time datetime COMMENT '确认时间'
);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012217304838974, 2019012217304837787, 2019012217304838991, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012309281363846, 2019012217304837787, 2019012309324848206, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012309281363938, 2019012217304837787, 2019012309324848385, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012309281363991, 2019012217304837787, 2019012309324848368, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012309281363998, 2019012217304837787, 2019012309324848370, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012309281364093, 2019012217304837787, 2019012309324848382, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012309281364135, 2019012217304837787, 2019012309324848366, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012309281364169, 2019012217304837787, 2019012309324848394, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012309310082120, 2019012217304837787, 2019012309324848353, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012309310082142, 2019012217304837787, 2019012309324848357, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012309310082178, 2019012217304837787, 2019012309324848480, 'wangdm', '2019-01-22 17:30:48', null, null);
INSERT INTO youqu.user_role_privilege (id, role_id, privilege_id, creator, create_time, modifier, modify_time) VALUES (2019012309310082202, 2019012217304837787, 2019012309324848446, 'wangdm', '2019-01-22 17:30:48', null, null);