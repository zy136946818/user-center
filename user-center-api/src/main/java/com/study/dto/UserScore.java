package com.study.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * user_score
 * @author 
 */
@Data
public class UserScore implements Serializable {
    private Long id;

    private Long userId;

    /**
     * 当前积分
     */
    private Integer score;

    /**
     * 累计获得积分
     */
    private Integer totalScore;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}