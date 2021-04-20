package com.study.api;

import com.study.vo.InsertUserAddressRequest;
import com.study.vo.Result;

/**
 * @Author zhangYu
 * @Date 2021/4/19 20:36
 */
public interface UserAddressInfoService {

    /**
     * @Description: 添加地址
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/19 20:43
     */
    Result insertUserAddress(InsertUserAddressRequest insertUserAddressRequest);
}
