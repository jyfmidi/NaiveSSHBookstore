package com.entity;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.type.StringType;

/**
 * Created by 滩涂上的芦苇 on 2016/6/9.
 */
public class MyLocalDialect extends MySQLDialect{
    public MyLocalDialect() {
        super();
        this.registerFunction("usercount",new SQLFunctionTemplate(new StringType(),"usercount(?1)"));
    }
}
