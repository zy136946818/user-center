package com.study.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.study.api.UserAddressInfoService;
import com.study.dto.UserAddressInfo;
import com.study.mapper.UserAddressInfoMapper;
import com.study.vo.InsertUserAddressRequest;
import com.study.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;

/**
 * @Author zhangYu
 * @Date 2021/4/19 20:36
 */
@Slf4j
@Service
public class UserAddressInfoServiceImpl implements UserAddressInfoService {

    @Resource
    private UserAddressInfoMapper userAddressInfoMapper;

    /**
     * @Description: 地址添加
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/19 20:57
     */
    @Override
    public Result insertUserAddress(InsertUserAddressRequest insertUserAddressRequest) {
        log.info("insertUserAddress ===== >入参{}", JSONUtil.toJsonStr(insertUserAddressRequest));
        UserAddressInfo userAddressInfo = new UserAddressInfo();
        userAddressInfo.setUserId(insertUserAddressRequest.getUserId());
        userAddressInfo.setProvinceCode(insertUserAddressRequest.getProvinceCode());
        userAddressInfo.setCityCode(insertUserAddressRequest.getCityCode());
        userAddressInfo.setCountryCode(insertUserAddressRequest.getCountryCode());
        userAddressInfo.setTownCode(insertUserAddressRequest.getTownCode());
        userAddressInfo.setVillageCode(insertUserAddressRequest.getVillageCode());
        userAddressInfo.setProvinceName(insertUserAddressRequest.getProvinceName());
        userAddressInfo.setCityName(insertUserAddressRequest.getCityName());
        userAddressInfo.setCountryName(insertUserAddressRequest.getCountryName());
        userAddressInfo.setTownName(insertUserAddressRequest.getTownName());
        userAddressInfo.setVillageName(insertUserAddressRequest.getVillageName());
        userAddressInfo.setAddressDetail(insertUserAddressRequest.getAddressDetail());
        userAddressInfo.setPostalCode(insertUserAddressRequest.getPostalCode());
        userAddressInfo.setDeleted(0);
        userAddressInfo.setCreateTime(DateUtil.date());
        userAddressInfo.setCreateBy(Long.toString(insertUserAddressRequest.getUserId()));
        userAddressInfo.setUpdateTime(DateUtil.date());
        userAddressInfo.setUpdateBy(Long.toString(insertUserAddressRequest.getUserId()));
        userAddressInfoMapper.insertSelective(userAddressInfo);
        return Result.success();
    }

}
