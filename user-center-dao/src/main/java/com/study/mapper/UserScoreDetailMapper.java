package com.study.mapper;


import com.study.dto.UserScoreDetail;

public interface UserScoreDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserScoreDetail record);

    int insertSelective(UserScoreDetail record);

    UserScoreDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserScoreDetail record);

    int updateByPrimaryKey(UserScoreDetail record);

    /**
     * @Description: 获取用户最新积分详情
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/25 11:04
     */
    UserScoreDetail getUserTotalScore(Long userId);


}