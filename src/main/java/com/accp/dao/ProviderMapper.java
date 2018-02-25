package com.accp.dao;

import com.accp.entity.Bill;
import com.accp.entity.Provider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProviderMapper {

    List<Provider> listAll();

    Provider getProviderById(@Param("id") Integer id);

    List<Provider> listByParam(Provider provider);

    Integer update(Provider provider);

    Integer delete(Integer id);

    List<Provider> selectByChoose(Provider provider);



}
