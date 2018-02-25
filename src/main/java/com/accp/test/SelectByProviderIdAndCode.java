package com.accp.test;

import com.accp.dao.BillMapper;
import com.accp.entity.Bill;
import com.accp.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectByProviderIdAndCode {
    public static void main(String[] args) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        BillMapper billMapper = sqlSession.getMapper(BillMapper.class);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("list", Arrays.asList(1,2,3));
        map.put("billCode","018");
        List<Bill> billList = billMapper.selectByProviderIdAndCode(map);
        for (Bill b: billList) {
            System.out.println(b.getProductName()+"---"+b.getProviderId());
        }
    }
}
