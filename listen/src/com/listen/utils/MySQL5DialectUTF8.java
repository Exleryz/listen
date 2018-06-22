package com.listen.utils;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * @Auther: Exler
 * @Date: 2018/5/21 08:35
 * @Description: hibernate 自动建表 utf-8 编码
 */
public class MySQL5DialectUTF8 extends MySQL5InnoDBDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
