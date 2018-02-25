package com.accp.biz.impl;

import com.accp.biz.ProviderBiz;
import com.accp.dao.ProviderMapper;
import com.accp.entity.Provider;
import com.accp.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ProviderBizImpl implements ProviderBiz {

    ProviderMapper providerMapper=null;
    /**
     * 查询所有供应商或者按参数查询
     * @return
     */
    public List<Provider> listByParam(Provider provider) {
        SqlSession session = MyBatisUtil.openSession();
        providerMapper = session.getMapper(ProviderMapper.class);
        return providerMapper.listByParam(provider);
    }
    /**
     * 更改Provider
     * @param provider
     * @return
     */
    public Boolean modify(Provider provider) {
        SqlSession session = MyBatisUtil.openSession();
        providerMapper = session.getMapper(ProviderMapper.class);
        return providerMapper.update(provider)>0;
    }

    /**
     * 按ID查询
     * @param id
     * @return
     */
    public Provider getProviderById(Integer id) {
        SqlSession session = MyBatisUtil.openSession();
        providerMapper = session.getMapper(ProviderMapper.class);
        return providerMapper.getProviderById(id);
    }

    public Boolean del(Integer id) {
        SqlSession session = MyBatisUtil.openSession();
        providerMapper = session.getMapper(ProviderMapper.class);
        return providerMapper.delete(id)>0;
    }
}
