drop table if exists segment_tab;
create table segment_tab(
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