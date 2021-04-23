package com.study.mapper;


import com.study.dto.UserScore;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface UserScoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserScore record);

    int insertSelective(UserScore record);

    UserScore selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserScore record);

    int updateByPrimaryKey(UserScore record);

    /**
     * @Description:查询用户积分
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/23 10:39
     */
    UserScore selectByUserId(@Param("userId") Long userId);
    /**
     * @Description: 修改积分
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/23 10:47
     */
    int updateByUpdateTimeAndUserId(@Param("userScore") UserScore userScore,@Param("updateTime") String updateTime);
}