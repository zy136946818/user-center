package com.study.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 修改用户手机号或邮箱请求vo
 * @Param:
 * @Return:
 * @Auther: zhangYu
 * @Date: 2021/4/7 9:19
 */
@Data
public class UpdatePhoneOrEmailRequest implements Serializable {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 手机号 或 邮箱
     */
    private String phoneOrEmail;

    /**
     * 密码
     */
    private String passWord;

}
