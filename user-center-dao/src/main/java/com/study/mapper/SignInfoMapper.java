package com.study.mapper;


import com.study.dto.SignInfo;
import org.apache.ibatis.annotations.Param;


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
    SignInfo selectBySignDateAndUserId(@Param("userId") Long userId, @Param("signDate") String signDate);

    /**
     * @Description: 统计用户当前月签到天数
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/23 16:13
     */
    Integer getUserSignInfoCountByUserId(@Param("userId") Long userId,@Param("month") Integer month);



}