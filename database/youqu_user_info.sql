CREATE TABLE youqu.user_info
(
    id bigint(20) PRIMARY KEY NOT NULL,
    user_name varchar(15) COMMENT '用户登录账号',
    user_password varchar(100) COMMENT '密码',
    real_name varchar(5) COMMENT '用户真实姓名',
    phone char(11) COMMENT '手机号',
    email varchar(20) COMMENT '邮箱',
    address varchar(45) COMMENT '收货地址',
    is_apply smallint(6) DEFAULT '1',
    creator varchar(10) COMMENT '创建人',
    create_time datetime COMMENT '创建时间',
    modifier varchar(10) COMMENT '确认人',
    modify_time datetime COMMENT '确认时间
'
);
INSERT INTO youqu.user_info (id, user_name, user_password, real_name, phone, email, address, is_apply, creator, create_time, modifier, modify_time) VALUES (2019012217304837178, 'wangdm', '$2a$10$FuiXiEZ0R8BtJlGV/MdJxOi5YGsr9T.0.h0swIQxzjG/MO/fVxtc.', '王德明', '18750928494', '550207385@qq.com', 'xiamen', 1, 'wangdm', '2019-01-22 17:30:48', null, null);