package com.accp.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public  class  MyBatisUtil {
    private static SqlSessionFactory factory=null;
    static {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("myBatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactoryBuilder factoryBuilder=new SqlSessionFactoryBuilder();
        factory=factoryBuilder.build(is);
    }

    public static SqlSession openSession(){
        return factory.openSession(true);
    }
}
