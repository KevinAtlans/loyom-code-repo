/**
 * 创建博客表
 * 
 * 1. 判断博客表是否存在，存在则删除
 * 2. 创建博客
 *  2.1. 创建各个字段
 *  2.2. 设置主键 Id 并加上自增
 *  2.3. 设定字段 enable 的默认值为启用
 *  2.4. 对博客标题加上索引
 *  2.5. 添加对于用户的外键关联
 *  
 * */
drop table if exists blog_tab;
create table blog_tab(
    id                  bigint          not null    auto_increment  primary key,
    user_id             bigint          not null,
    title               varchar(200)    not null,
    content             text            not null,
    create_date         timestamp       not null default now(),
    last_update_date    timestamp       not null default now(),
    enable              boolean         not null default true,
    index blog_title(title),
    foreign key(user_id) references user_tab(id)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

/**
 * 创建博文的评论表
 * 
 * 1. 判断评论表是否存在，存在则删除
 * 2. 创建评论表
 *  2.1. 创建各个字段
 *  2.2. 设置主键 Id 并加上自增
 *  2.3. 设定字段 enable 的默认值为启用
 *  2.4. 对评论的Id和博客Id建立关联索引
 *  2.5. 添加对于博客表的外键关联
 *  
 * */
drop table if exists comment_tab;
create table comment_tab(
    id                  bigint          not null    auto_increment  primary key,
    blog_id             bigint          not null,
    nick                varchar(200)    not null,
    content             text            not null,
    create_date         timestamp       not null default now(),
    examine             boolean         not null default true,
    enable              boolean         not null default true,
    index blog_comment(id, blog_id),
    foreign key(blog_id) references blog_tab(id)
    
)ENGINE=InnoDB DEFAULT CHARSET=utf8;