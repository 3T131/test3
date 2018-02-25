package com.accp.biz;

import com.accp.entity.Bill;
import com.accp.entity.Provider;

import javax.swing.text.StyledEditorKit;
import java.util.List;

public interface ProviderBiz {


    /**
     * 查询所有供应商或者加上条件
     * @return
     */
    List<Provider> listByParam(Provider provider);

    /**
     * 更改Provider
     * @param provider
     * @return
     */
    Boolean modify(Provider provider);

    /**
     * 按ID查询Provider
     * @param id
     * @return
     */
    Provider getProviderById(Integer id);

    Boolean del(Integer id);


}
