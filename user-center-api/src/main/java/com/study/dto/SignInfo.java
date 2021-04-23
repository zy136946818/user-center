package com.study.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * sign_info
 * @author 
 */
@Data
public class SignInfo implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 签到日期
     */
    private Date signDate;

    /**
     * 当月签到天数
     */
    private Integer signTimeMonth;

    private static final long serialVersionUID = 1L;
}