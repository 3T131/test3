package com.accp.biz.impl;

import com.accp.biz.BillBiz;
import com.accp.dao.BillMapper;
import com.accp.entity.Bill;
import com.accp.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BillBizImpl implements BillBiz {
    BillMapper billMapper=null;

    /**
     * 查询所有订单
     * @return
     */
    public List<Bill> listAll() {
        SqlSession sqlSession = MyBatisUtil.openSession();
        billMapper= sqlSession.getMapper(BillMapper.class);
        return billMapper.selectAll();
    }

    /**
     * 按供应商ID或商品名称或是否支付查询
     * @return
     */
    public List<Bill> listByParam(Bill bill) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        billMapper= sqlSession.getMapper(BillMapper.class);
        return billMapper.listByParam(bill);
    }

    /**
     * 按供应商ID查询
     * @param id
     * @return
     */
    public Bill getById(Integer id) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        billMapper= sqlSession.getMapper(BillMapper.class);
        return billMapper.selectById(id);
    }
    /**
     * 修改Bill
     * @param bill
     * @return
     */
    public Boolean modify(Bill bill) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        billMapper= sqlSession.getMapper(BillMapper.class);
        return billMapper.update(bill)>0;
    }

    /**
     * 删除按Id
     * @param id
     * @return
     */
    public Boolean del(Integer id) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        billMapper= sqlSession.getMapper(BillMapper.class);
        return billMapper.delete(id)>0;
    }

    public List<Bill> listByProviderId(Integer[] ids) {
        SqlSession sqlSession = MyBatisUtil.openSession();
        billMapper= sqlSession.getMapper(BillMapper.class);
        return billMapper.selectByProviderId(ids);
    }
}
