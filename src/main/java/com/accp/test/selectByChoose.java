package com.accp.test;

import com.accp.dao.ProviderMapper;
import com.accp.entity.Provider;
import com.accp.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class selectByChoose {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        ProviderMapper providerMapper = sqlSession.getMapper(ProviderMapper.class);
        Provider provider=new Provider();
//        provider.setProName("北京");
        provider.setProCode("Z");
        List<Provider> billList = providerMapper.selectByChoose(provider);
        for (Provider provider1: billList
             ) {
            System.out.println(provider1.getProName()+"---"+provider1.getProCode());
        }
    }
}
