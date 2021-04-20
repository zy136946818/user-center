package com.study.controller;

import com.mysql.cj.util.StringUtils;
import com.study.api.UserAddressInfoService;
import com.study.dto.User;
import com.study.vo.InsertUserAddressRequest;
import com.study.vo.Result;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhangYu
 * @Date 2021/4/19 20:32
 */
@RestController
@RequestMapping("/userAddress")
public class UserAddressController {

    @Reference
    private UserAddressInfoService userAddressInfoService;

    @RequestMapping("/insertUserAddress")
    public Result userRegister(@RequestBody InsertUserAddressRequest insertUserAddressRequest , @RequestHeader("userId") Long userId){
        if (null == userId) {
            return Result.fail("用户未登录");
        }
        insertUserAddressRequest.setUserId(userId);
        return userAddressInfoService.insertUserAddress(insertUserAddressRequest);
    }


}
