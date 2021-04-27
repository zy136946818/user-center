package com.study.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.study.api.UserService;
import com.study.dto.UserScore;
import com.study.dto.UserScoreDetail;
import com.study.enums.ScoreTypeEnum;
import com.study.mapper.UserMapper;
import com.study.dto.User;
import com.study.mapper.UserScoreDetailMapper;
import com.study.mapper.UserScoreMapper;
import com.study.util.FormatUtil;
import com.study.util.MD5Util;
import com.study.util.RandomUUIDUtil;
import com.study.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;


import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author zhangYu
 * @Date 2021/3/17 9:39
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;
    @Resource
    private UserScoreMapper userScoreMapper;
    @Resource
    private UserScoreDetailMapper userScoreDetailMapper;

    /**
     * @Description: 用户注册
     * @Param: [user]
     * @Return: com.study.vo.Result<?>
     * @Auther: zhangYu
     * @Date: 2021/3/17 10:34
     */
    @Override
    public Result userRegister(User user) {
        log.info("userLogin 入参 {}",JSONUtil.toJsonStr(user));
        // 判断用户是否已经注册
        User isExist = userMapper.selectByPhoneOrEmail(user);
        if (isExist != null){
            return Result.fail("该用户已注册！");
        }
        // 生成随机账号
        if (user.getAccount() == null){
            user.setAccount(RandomUUIDUtil.getUUID());
        }
        user.setPassWord(MD5Util.getPwd(user.getPassWord()));
        user.setCreateBy(user.getAccount());
        user.setCreateTime(new Date());
        user.setUpdateBy(user.getAccount());
        user.setUpdateTime(new Date());
        // 添加用户
        userMapper.insertSelective(user);
        // 维护用户积分表
        UserScore userScore = new UserScore();
        userScore.setUserId(user.getId());
        userScore.setScore(1);
        userScore.setTotalScore(1);
        userScore.setUpdateTime(DateUtil.date());
        userScore.setCreateTime(DateUtil.date());
        userScoreMapper.insertSelective(userScore);
        // 维护积分详情表
        UserScoreDetail userScoreDetail = new UserScoreDetail();
        userScoreDetail.setUserId(user.getId());
        userScoreDetail.setScore(1);
        userScoreDetail.setTotalScore(1);
        userScoreDetail.setCreateTime(DateUtil.date());
        userScoreDetail.setScoreType(ScoreTypeEnum.REGISTER.getDesc());
        userScoreDetail.setRemark(ScoreTypeEnum.REGISTER.getDesc());
        userScoreDetailMapper.insertSelective(userScoreDetail);
        return Result.success();
    }

    /**
     * @Description: 用户登录
     * @Param: [userLoginRequest]
     * @Return: com.study.vo.Result<?>
     * @Auther: zhangYu
     * @Date: 2021/3/17 15:27
     */
    @Override
    public Result userLogin(UserLoginRequest userLoginRequest) {
        log.info("userLogin 入参 {}",JSONUtil.toJsonStr(userLoginRequest));
        User user = new User();
        user.setPassWord(MD5Util.getPwd(userLoginRequest.getPassWord()));
        user.setEmail(userLoginRequest.getEmail());
        user.setPhone(userLoginRequest.getPhone());
        // 判断用户是否注册
        User selectByPhoneOrEmail = userMapper.selectByPhoneOrEmail(user);
        if(null == selectByPhoneOrEmail){
            return Result.fail("用户未注册!");
        }
        // 查询用户
        User userLogin = userMapper.userLogin(user);
        // 判断用户密码是否正确
        if (null == userLogin){
            return Result.fail("密码不正确!");
        }
        return Result.success();
    }

    /**
     * @Description: 找回密码
     * @Param: [retrievePasswordRequest]
     * @Return: com.study.vo.Result<?>
     * @Auther: zhangYu
     * @Date: 2021/4/1 8:52
     */
    @Override
    public Result<?> retrievePassword(RetrievePasswordRequest retrievePasswordRequest) {
        log.info("retrievePassword 入参 {}",JSONUtil.toJsonStr(retrievePasswordRequest));
        User user = new User();
        user.setAccount(retrievePasswordRequest.getAccount());
        user.setPhone(retrievePasswordRequest.getPhone());
        user.setPhone(retrievePasswordRequest.getPhone());
        user.setPassWord(MD5Util.getPwd(retrievePasswordRequest.getPassWord()));
        user.setUpdateTime(new Date());
        String newPassWord = MD5Util.getPwd(retrievePasswordRequest.getNewPassWord());
        return Result.success(userMapper.updatePassWordByPhoneOrAccount(user,newPassWord));
    }

    /**
     * @Description: 修改资料
     * @Param: [updateUserDataRequest]
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/6 16:49
     */
    @Override
    public Result updateDataById(UpdateUserDataRequest updateUserDataRequest) {
        log.info("updateDataById 入参{}",JSONUtil.toJsonStr(updateUserDataRequest));
        User user = new User();
        user.setId(updateUserDataRequest.getId());
        user.setUserName(updateUserDataRequest.getUserName());
        user.setAge(updateUserDataRequest.getAge());
        user.setSex(updateUserDataRequest.getSex());
        user.setUpdateTime(new DateTime());
        user.setUpdateBy(Long.toString(updateUserDataRequest.getId()));
        userMapper.updateByPrimaryKeySelective(user);
        return Result.success();
    }

    /**
     * @Description: 修改用户手机号或邮箱
     * @Param: [updatePhoneOrEmailRequest]
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/7 9:29
     */
    @Override
    public Result updatePhoneOrEmail(UpdatePhoneOrEmailRequest updatePhoneOrEmailRequest) {
        log.info("updatePhoneOrEmail 入参 {}",JSONUtil.toJsonStr(updatePhoneOrEmailRequest));
        User user = new User();
        user.setId(updatePhoneOrEmailRequest.getId());
        if (FormatUtil.isPhoneFormat(updatePhoneOrEmailRequest.getPhoneOrEmail())){
            user.setPhone(updatePhoneOrEmailRequest.getPhoneOrEmail());
        }
        if (FormatUtil.isMailFormat(updatePhoneOrEmailRequest.getPhoneOrEmail())) {
            user.setEmail(updatePhoneOrEmailRequest.getPhoneOrEmail());
        }
        user.setPassWord(updatePhoneOrEmailRequest.getPassWord());
        user.setUpdateTime(new Date());
        user.setUpdateBy(Long.toString(updatePhoneOrEmailRequest.getId()));
        userMapper.updateByIdAndPassWord(user);
        return Result.success();
    }
}
