package com.study.controller;

import com.study.api.UserAddressInfoService;
import com.study.vo.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhangYu
 * @Date 2021/4/19 20:32
 */
@RestController
@RequestMapping("/userAddress")
public class UserAddressController {

    @Reference
    private UserAddressInfoService userAddressInfoService;

    /**
     * @Description: 新增地址
     * @Param: [insertUserAddressRequest, userId]
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/20 14:01
     */
    @RequestMapping("/insertUserAddress")
    public Result userRegister(@RequestBody InsertUserAddressRequest insertUserAddressRequest , @RequestHeader("userId") Long userId){
        if (null == userId) {
            return Result.fail("用户未登录");
        }
        insertUserAddressRequest.setUserId(userId);
        return userAddressInfoService.insertUserAddress(insertUserAddressRequest);
    }

    /**
     * @Description: 删除用户地址
     * @Param: [addressId, userId]
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/20 14:34
     */
    @RequestMapping("/deleteUserAddress")
    public Result deleteUserAddress (@RequestBody DeleteUserAddressRequest deleteUserAddressRequest , @RequestHeader("userId") Long userId) {
        if (null == userId) {
            return Result.fail("用户未登录");
        }
        return userAddressInfoService.deleteUserAddress(deleteUserAddressRequest,userId);
    }

    /**
     * @Description: 修改用户地址
     * @Param: [updateUserAddressRequest, userId]
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/20 17:03
     */
    @RequestMapping("/updateUserAddress")
    public Result updateUserAddress (@RequestBody UpdateUserAddressRequest updateUserAddressRequest , @RequestHeader("userId") Long userId) {
        if (null == userId) {
            return Result.fail("用户未登录");
        }
        updateUserAddressRequest.setUserId(userId);
        return userAddressInfoService.updateUserAddress(updateUserAddressRequest);
    }

    /**
     * @Description: 查询用户地址
     * @Param: [userId]
     * @Return: com.study.vo.Result<?>
     * @Auther: zhangYu
     * @Date: 2021/4/20 20:31
     */
    @RequestMapping("/getUserAddress")
    public Result getUserAddressList(@RequestHeader("userId") Long userId) {
        if (null == userId) {
            return Result.fail("用户未登录");
        }
        return userAddressInfoService.getUserAddressList(userId);
    }





}
