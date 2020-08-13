package com.dh.service;




import com.dh.entity.Type;

import java.util.List;

public interface TypeService {

    /**
     * 通过code，获取数据字典详情
     * @param code typecode
     * @return
     */
    List<Type> getTypeByCode(String code);

    /**
     * 获取银行卡验证最大次数
     * @return  最大次数
     */
    int getMaxFourElementTimes();

    /**
     * 获取活体检测最大次数
     * @return 最大次数
     */
    int getMaxLivingBodyTimes();


    void add(Type type);
}
