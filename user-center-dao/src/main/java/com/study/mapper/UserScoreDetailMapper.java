package com.study.mapper;


import com.study.dto.UserScoreDetail;

public interface UserScoreDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserScoreDetail record);

    int insertSelective(UserScoreDetail record);

    UserScoreDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserScoreDetail record);

    int updateByPrimaryKey(UserScoreDetail record);
}