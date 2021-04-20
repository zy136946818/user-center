package com.study.api;

import com.study.dto.User;
import com.study.vo.*;

/**
 * @Author zhangYu
 * @Date 2021/3/17 9:43
 */

public interface UserService {

    /**
     * @Description: 用户注册
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/3/17 10:34
     */
    Result userRegister(User user);

    /**
     * @Description: 用户登录
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/3/17 15:24
     */
    Result userLogin(UserLoginRequest userLoginRequest);

    /**
     * @Description: 找回密码
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/1 8:51
     */
    Result<?> retrievePassword(RetrievePasswordRequest retrievePasswordRequest);

    /**
     * @Description: 修改资料
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/6 16:49
     */
    Result updateDataById(UpdateUserDataRequest updateUserDataRequest);

    /**
     * @Description: 修改用户手机号或者邮箱
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/7 9:27
     */
    Result updatePhoneOrEmail(UpdatePhoneOrEmailRequest updatePhoneOrEmailRequest);

}
