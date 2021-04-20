package com.study.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhangYu
 * @Date 2021/4/2 8:51
 */
@Data
public class UpdateUserDataRequest implements Serializable {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 用户名称
     */
    private String userName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;


}
