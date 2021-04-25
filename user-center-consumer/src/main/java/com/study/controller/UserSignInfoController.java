package com.study.controller;

import com.study.api.UserSignInfoService;
import com.study.vo.Result;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author zhangYu
 * @Date 2021/4/22 17:03
 */
@RestController
@RequestMapping("/userSignInfo")
public class UserSignInfoController {

    @Resource
    private UserSignInfoService userSignInfoService;

    /**
     * @Description: 用户签到
     * @Param: [userId]
     * @Return: com.study.vo.Result<?>
     * @Auther: zhangYu
     * @Date: 2021/4/23 14:33
     */
    @RequestMapping("/userSignInfo")
    public Result<?> userSignInfo(@RequestHeader("userId") Long userId){
        if (null == userId){
            return Result.fail("用户未登录");
        }
        return userSignInfoService.userSignInfo(userId);
    }
    /**
     * @Description: 用户签到次数
     * @Param: [headers]
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/23 14:34
     */
    @RequestMapping("/userSignInfoCount")
    public Result userSignInfoCount(@RequestHeader("userId") Long userId) {
        if (null == userId){
            return Result.fail("用户未登录");
        }
        return userSignInfoService.userSignInfoCount(userId);
    }
}
