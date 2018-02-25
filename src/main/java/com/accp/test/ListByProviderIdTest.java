package com.accp.test;

import com.accp.biz.BillBiz;
import com.accp.biz.impl.BillBizImpl;
import com.accp.entity.Bill;
import com.accp.util.MyBatisUtil;

import java.util.Arrays;
import java.util.List;

public class ListByProviderIdTest {
    public static void main(String[] args) {
        //jnm,n,mn,mnm,
        BillBiz billBiz=new BillBizImpl();
        Integer[] integers=new Integer[]{1,2,3};
        List<Bill> billList = billBiz.listByProviderId(integers);
        for (Bill b: billList) {
            System.out.println(b.getProductName()+"---"+b.getProviderId());
        }
    }
}
