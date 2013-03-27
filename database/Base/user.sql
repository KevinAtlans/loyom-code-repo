use navi;

/**
 * 创建用户表
 * 
 * 1. 判断用户表是否存在，存在则删除
 * 2. 创建用户表
 *  2.1. 创建各个字段
 *  2.2. 设置主键 Id 并加上自增
 *  2.3. 设定字段 enable 的默认值为启用
 *  2.4. 对用户昵称创建索引
 *  
 * */

drop table if exists user_tab;
create table user_tab(
    id          bigint          not null    auto_increment  primary key,
    nick        varchar(40)     null,
    account     varchar(50)     not null,
    pass        varchar(50)     not null,
    joined      timestamp       not null default now(),
    enable      boolean         not null default true,
    index user_nick(nick)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 * 
 * 创建用户信息扩展表
 * 
 * 1.判断用户信息扩展表是否存在，如果存在则删除
 * 2.创建用户信息扩展表
 *  2.1. 创建各个字段
 *  2.2. 设置主键 Id 并加上自增
 *  2.3. 对用户表的关联建立索引
 *  2.4. 创建外键关联
 * */

drop table if exists user_extend_tab;
create table user_extend_tab(
    id          bigint          not null    auto_increment  primary key,
    user_id     bigint          not null,
    mail        varchar(50)     null,
    phone       varchar(20)     null,
    index user_uid (user_id),
    foreign key(user_id) references user_tab(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;