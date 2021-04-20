package com.study.mapper;


import com.study.dto.UserAddressInfo;
import org.apache.ibatis.annotations.Param;

public interface UserAddressInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAddressInfo record);

    int insertSelective(UserAddressInfo record);

    UserAddressInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAddressInfo record);

    int updateByPrimaryKey(UserAddressInfo record);

    /**
     * @Description: 删除用户地址
     * @Auther: zhangYu
     * @Date: 2021/4/20 14:10
     */
    int updateByAddressIdAndUserId(UserAddressInfo userAddressInfo);
}