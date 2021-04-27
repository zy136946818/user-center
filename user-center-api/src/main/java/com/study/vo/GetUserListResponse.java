package com.study.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 请求用户信息响应VO
 * @Auther: zhangYu
 * @Date: 2021/4/27 16:20
 */
@Data
public class GetUserListResponse implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 找回密码
     */
    private String newPassword;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private String updateBy;

}
