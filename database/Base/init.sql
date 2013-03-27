/**
 * 创建数据库 Navi
 * 
 * 1.判断 navi 数据库是否存在，如果存在则删除
 * 2.创建数据库 navi ，并设置字符类型为 utf-8
 * 3.使用数据库 navi
 * */

drop database if exists navi;
create database navi default charset utf-8;