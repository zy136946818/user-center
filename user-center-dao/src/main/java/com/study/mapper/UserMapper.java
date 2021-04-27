package com.study.mapper;


import com.study.dto.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * @Description: 通过手机号或邮箱查询用户
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/3/17 17:09
     */
    User selectByPhoneOrEmail(User user);

    /**
     * @Description: 通过手机号或账号查询用户
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/3/17 17:09
     */
    User selectByPhoneOrAccount(User user);


    /**
     * @Description: 用户登录
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/3/17 15:57
     */
    User userLogin(User user);

    /**
     * @Description: 修改密码
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/1 9:05
     */
    int updatePassWordByPhoneOrAccount(@Param("user") User record, @Param("newPassWord") String newPassWord);

    /**
     * @Description: 修改用户手机号或邮箱
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/7 9:56
     */
    int updateByIdAndPassWord(User record);

    /**
     * @Description: 通过userId判断用户是否注册
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/27 15:36
     */
    Long isExistUser(Long userId);

    /**
     * @Description: 获取用户列表
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/27 16:28
     */
    List<User> getUserList();
}