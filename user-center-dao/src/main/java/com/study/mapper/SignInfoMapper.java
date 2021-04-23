package com.study.mapper;


import com.study.dto.SignInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SignInfo record);

    int insertSelective(SignInfo record);

    SignInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SignInfo record);

    int updateByPrimaryKey(SignInfo record);

    /**
     * @Description: 通过创建时候查询，判断用户当天是否已签到
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/23 10:00
     */
    List<SignInfo> selectBySignDateAndUserId(@Param("userId") Long userId, @Param("signDate") String signDate);
}