package com.study.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 找回密码请求vo
 * @Param:
 * @Return:
 * @Auther: zhangYu
 * @Date: 2021/3/31 15:23
 */
@Data
public class RetrievePasswordRequest implements Serializable {
    /**
     * 用户账号
     */
    private String account;
    /**
     * 密码
     */
    private String passWord;

    /**
     * 新密码
     */
    private String newPassWord;
    /**
     * 手机号
     */
    private String phone;

}
