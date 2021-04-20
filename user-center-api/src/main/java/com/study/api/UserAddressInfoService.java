package com.study.api;

import com.study.vo.DeleteUserAddressRequest;
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

    /**
     * @Description: 删除用户地址
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/20 14:06
     */
    Result deleteUserAddress(DeleteUserAddressRequest deleteUserAddressRequest, Long userId);
}
