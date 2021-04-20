package com.study.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.study.api.UserAddressInfoService;
import com.study.dto.UserAddressInfo;
import com.study.mapper.UserAddressInfoMapper;
import com.study.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * @Description: 删除用户地址
     * @Param: [deleteUserAddressRequest, userId]
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/20 16:05
     */
    @Override
    public Result deleteUserAddress(DeleteUserAddressRequest deleteUserAddressRequest, Long userId) {
        log.info("deleteUserAddress 删除用户地址 =======> 入参 {} {}",JSONUtil.toJsonStr(deleteUserAddressRequest),userId);
        // 封装数据
        UserAddressInfo userAddressInfo = new UserAddressInfo();
        userAddressInfo.setUserId(userId);
        userAddressInfo.setId(Long.parseLong(deleteUserAddressRequest.getAddressId()));
        userAddressInfo.setUpdateTime(DateUtil.date());
        userAddressInfo.setUpdateBy(Long.toString(userId));
        int i = userAddressInfoMapper.updateByAddressIdAndUserId(userAddressInfo);
        log.info("deleteUserAddress 删除用户地址 =======> 返参 {}",i);
        return Result.success();
    }

    /**
     * @Description: 修改用户地址
     * @Param: [updateUserAddressRequest]
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/20 16:23
     */
    @Override
    public Result updateUserAddress(UpdateUserAddressRequest updateUserAddressRequest) {
        log.info("updateUserAddress 修改用户地址 ======> 入参{}",JSONUtil.toJsonStr(updateUserAddressRequest));
        UserAddressInfo userAddressInfo = new UserAddressInfo();
        userAddressInfo.setId(updateUserAddressRequest.getAddressId());
        userAddressInfo.setUserId(updateUserAddressRequest.getUserId());
        userAddressInfo.setProvinceCode(updateUserAddressRequest.getProvinceCode());
        userAddressInfo.setCityCode(updateUserAddressRequest.getCityCode());
        userAddressInfo.setCountryCode(updateUserAddressRequest.getCountryCode());
        userAddressInfo.setTownCode(updateUserAddressRequest.getTownCode());
        userAddressInfo.setVillageCode(updateUserAddressRequest.getVillageCode());
        userAddressInfo.setProvinceName(updateUserAddressRequest.getProvinceName());
        userAddressInfo.setCityName(updateUserAddressRequest.getCityName());
        userAddressInfo.setCountryName(updateUserAddressRequest.getCountryName());
        userAddressInfo.setTownName(updateUserAddressRequest.getTownName());
        userAddressInfo.setVillageName(updateUserAddressRequest.getVillageName());
        userAddressInfo.setAddressDetail(updateUserAddressRequest.getAddressDetail());
        userAddressInfo.setPostalCode(updateUserAddressRequest.getPostalCode());
        userAddressInfo.setUpdateTime(DateUtil.date());
        userAddressInfo.setUpdateBy(Long.toString(updateUserAddressRequest.getUserId()));
        int i = userAddressInfoMapper.updateUserByUserIdAndAddressId(userAddressInfo);
        log.info("updateUserAddress 修改用户地址 ======> 返参{}",i);
        return Result.success();
    }

    /**
     * @Description: 查询用户地址
     * @Param: [userId]
     * @Return: com.study.vo.Result<?>
     * @Auther: zhangYu
     * @Date: 2021/4/20 20:43
     */
    @Override
    public Result getUserAddressList(Long userId) {
        log.info("getUserAddressList 查询用户地址入参 ======> {}",userId);
        List<UserAddressInfo> userAddressInfos = userAddressInfoMapper.selectByUserId(userId);
        if (userAddressInfos.size() <= 0){
            return Result.success("暂无可用地址");
        }
        List<GetUserAddressListResponse> responseList = new ArrayList<GetUserAddressListResponse>();
        for (UserAddressInfo userAddressInfo : userAddressInfos) {
            GetUserAddressListResponse getUserAddressListResponse = new GetUserAddressListResponse();
            getUserAddressListResponse.setId(userAddressInfo.getId());
            getUserAddressListResponse.setUserId(userAddressInfo.getUserId());
            getUserAddressListResponse.setProvinceCode(userAddressInfo.getProvinceCode());
            getUserAddressListResponse.setCityCode(userAddressInfo.getCityCode());
            getUserAddressListResponse.setCountryCode(userAddressInfo.getCountryCode());
            getUserAddressListResponse.setTownCode(userAddressInfo.getTownCode());
            getUserAddressListResponse.setVillageCode(userAddressInfo.getVillageCode());
            getUserAddressListResponse.setProvinceName(userAddressInfo.getProvinceName());
            getUserAddressListResponse.setCityName(userAddressInfo.getCityName());
            getUserAddressListResponse.setCountryName(userAddressInfo.getCountryName());
            getUserAddressListResponse.setTownName(userAddressInfo.getTownName());
            getUserAddressListResponse.setVillageName(userAddressInfo.getVillageName());
            getUserAddressListResponse.setAddressDetail(userAddressInfo.getAddressDetail());
            getUserAddressListResponse.setAddressRegion(userAddressInfo.getAddressRegion());
            getUserAddressListResponse.setPostalCode(userAddressInfo.getPostalCode());
            getUserAddressListResponse.setCreateTime(DateUtil.formatTime(userAddressInfo.getCreateTime()));
            getUserAddressListResponse.setCreateBy(userAddressInfo.getCreateBy());
            getUserAddressListResponse.setUpdateBy(userAddressInfo.getUpdateBy());
            getUserAddressListResponse.setUpdateTime(DateUtil.formatDateTime(userAddressInfo.getUpdateTime()));
            responseList.add(getUserAddressListResponse);
        }
        log.info("getUserAddressList 查询用户地址返参 ======> {}",JSONUtil.toJsonStr(responseList));
        return Result.success(responseList);
    }

}
