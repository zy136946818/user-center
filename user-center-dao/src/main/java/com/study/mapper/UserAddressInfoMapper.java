package com.study.mapper;


import com.study.dto.UserAddressInfo;

public interface UserAddressInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAddressInfo record);

    int insertSelective(UserAddressInfo record);

    UserAddressInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAddressInfo record);

    int updateByPrimaryKey(UserAddressInfo record);
}