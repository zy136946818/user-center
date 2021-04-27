package com.study.controller;

import com.study.api.UserService;
import com.study.dto.User;
import com.study.util.FormatUtil;
import com.study.vo.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author zhangYu
 * @Date 2021/3/17 9:36
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService userService;
    /**
     * @Description: 用户注册
     * @Param: [user]
     * @Return: com.study.vo.Result<?>
     * @Auther: zhangYu
     * @Date: 2021/3/17 11:58
     */
    @RequestMapping("/userRegister")
    public Result<?> userRegister(@RequestBody User user){

        if (null == user.getEmail() && null == user.getPhone()){
            return Result.fail("邮箱或手机号不能为空");
        }
        if (null == user.getPassWord()) {
            return Result.fail("密码不能为空!");
        }
        return userService.userRegister(user);
    }

    /**
     * 用户登录
     * @Author zhangYu
     * @Date 2021/3/31 15:15
     * @param
     * @return null
     */
    @RequestMapping("/userLogin")
    public Result<?> userLogin(@RequestBody UserLoginRequest userLoginRequest){

        if (null == userLoginRequest.getEmail() && null == userLoginRequest.getPhone()){
            return Result.fail("邮箱或手机号不能为空");
        }
        if (null == userLoginRequest.getPassWord()) {
            return Result.fail("密码不能为空!");
        }
        return userService.userLogin(userLoginRequest);
    }

    /**
     * 找回密码
     * @Author zhangYu
     * @Date 2021/3/31 15:21
     * @return com.study.vo.Result<?>
     */
    @RequestMapping("/retrievePassword")
    public Result<?> retrievePassword (@RequestBody RetrievePasswordRequest retrievePasswordRequest){

        if(null == retrievePasswordRequest.getAccount() && null == retrievePasswordRequest.getPhone()){
            return Result.fail("账号或手机号不能为空");
        }
        if (null == retrievePasswordRequest.getPassWord()){
            return Result.fail("密码不能为空");
        }
        if (null == retrievePasswordRequest.getNewPassWord()){
            return Result.fail("新密码不能为空");
        }
        return userService.retrievePassword(retrievePasswordRequest);
    }

    /**
     * @Description: 修改资料
     * @Param: [updateUserDataRequest]
     * @Return: com.study.vo.Result<?>
     * @Auther: zhangYu
     * @Date: 2021/4/6 16:25
     */
    @RequestMapping("/updateUserData")
    public Result updateUserData(@RequestBody UpdateUserDataRequest updateUserDataRequest, @RequestHeader("userId") Long userId){
        if (null == userId){
            return Result.fail("用户未登录");
        }
        if (null == updateUserDataRequest.getAge() || null == updateUserDataRequest.getUserName() || null == updateUserDataRequest.getSex()){
            return Result.success("资料已最新");
        }
        updateUserDataRequest.setId(userId);
        return userService.updateDataById(updateUserDataRequest);
    }

    /**
     * @Description: 修改手机号或邮箱
     * @Param: []
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/7 9:18
     */
    @RequestMapping("/updatePhoneOrEmail")
    public Result updatePhoneOrEmail(@RequestBody UpdatePhoneOrEmailRequest updatePhoneOrEmailRequest, @RequestHeader("userId") Long userId){
        if (null == userId) {
            return Result.fail("用户未登录");
        }
        if (null == updatePhoneOrEmailRequest.getPhoneOrEmail()) {
            return Result.fail("邮箱或者手机号不能为空");
        }
        if (null == updatePhoneOrEmailRequest.getPassWord()) {
            return Result.fail("密码不能为空");
        }
        updatePhoneOrEmailRequest.setId(userId);
        return userService.updatePhoneOrEmail(updatePhoneOrEmailRequest);
    }

    /**
     * @Description: 注销用户
     * @Param: [userId]
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/27 15:30
     */
    @RequestMapping("/logOffUser")
    public Result logOffUser(@RequestHeader Long userId) {
        if (null == userId) {
            return Result.fail("用户未登录");
        }
        return userService.logOffUser(userId);
    }

    @RequestMapping("/getUserList")
    public Result<?> getUserList(@RequestBody BasePageRequestVo basePageRequestVo) {
        return userService.getUserList(basePageRequestVo);
    }
}
