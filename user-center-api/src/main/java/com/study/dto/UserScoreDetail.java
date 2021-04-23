package com.study.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user_score_detail
 * @author 
 */
@Data
public class UserScoreDetail implements Serializable {
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 积分变化值
     */
    private Integer score;

    /**
     * 积分变化后的积分值
     */
    private Integer totalScore;

    /**
     * 积分创建时间
     */
    private Date createTime;

    /**
     * 积分变化描述
     */
    private String scoreType;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}