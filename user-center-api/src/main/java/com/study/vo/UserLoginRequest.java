package com.study.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 用户登录请求vo
 * @Param:
 * @Return:
 * @Auther: zhangYu
 * @Date: 2021/3/17 15:26
 */
@Data
public class UserLoginRequest implements Serializable {

    /**
     * 用户账号
     */
    private String account;

    /**
     * 密码
     */
    private String passWord;
    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;
}
