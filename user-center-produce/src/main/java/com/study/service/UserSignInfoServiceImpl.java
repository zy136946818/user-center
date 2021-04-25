package com.study.service;

import cn.hutool.core.date.DateUtil;
import com.study.api.UserSignInfoService;
import com.study.dto.SignInfo;
import com.study.dto.UserScore;
import com.study.dto.UserScoreDetail;
import com.study.enums.ScoreTypeEnum;
import com.study.mapper.SignInfoMapper;
import com.study.mapper.UserScoreDetailMapper;
import com.study.mapper.UserScoreMapper;
import com.study.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;

/**
 * @Author zhangYu
 * @Date 2021/4/22 17:05
 */
@Slf4j
@Service
public class UserSignInfoServiceImpl implements UserSignInfoService {

    @Resource
    private SignInfoMapper signInfoMapper;

    @Resource
    private UserScoreMapper userScoreMapper;

    @Resource
    private UserScoreDetailMapper userScoreDetailMapper;
    /**
     * @Description: 用户签到
     * @Param: [userId]
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/23 8:46
     */
    @Override
    public Result userSignInfo(Long userId) {
        log.info("userSignInfo 用户签到 ======> 入参{}",userId);
        String signDate = DateUtil.today();
        // 判断用户今日是否已签到
        SignInfo isSignInfo = signInfoMapper.selectBySignDateAndUserId(userId, signDate);
        if (isSignInfo != null){
            return Result.success("今天已签到");
        }
        SignInfo signInfo = new SignInfo();
        signInfo.setUserId(userId);
        signInfo.setSignDate(DateUtil.date());
        // 获取当月已签到天数
        Integer signInfoCount = signInfoMapper.getUserSignInfoCountByUserId(userId, DateUtil.month(DateUtil.date())+1);
        signInfo.setSignTimeMonth(signInfoCount+1);
        // 签到
        int i = signInfoMapper.insertSelective(signInfo);
        if (i <= 0) {
            return Result.fail("签到失败,请重试");
        }
        int flag = 0;
        while (flag < 3) {
            UserScore userScore = userScoreMapper.selectByUserId(userId);
            if (userScore == null) {
                UserScore user = new UserScore();
                user.setUserId(userId);
                user.setScore(1);
                user.setTotalScore(1);
                user.setCreateTime(DateUtil.date());
                user.setUpdateTime(DateUtil.date());
                userScoreMapper.insertSelective(user);
                break;
            }
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime = formatter.format(userScore.getUpdateTime());
            userScore.setUserId(userId);
            userScore.setScore(userScore.getScore()+1);
            userScore.setTotalScore(userScore.getTotalScore()+1);
            userScore.setUpdateTime(DateUtil.date());
            int isUpdate = userScoreMapper.updateByUpdateTimeAndUserId(userScore, updateTime);
            if (isUpdate > 0) {
                break;
            }
            flag++;
        }
        // 维护积分详情表
        UserScoreDetail userTotalScore = userScoreDetailMapper.getUserTotalScore(userId);
        UserScoreDetail userScoreDetail = new UserScoreDetail();
        userScoreDetail.setUserId(userId);
        userScoreDetail.setScore(1);
        userScoreDetail.setTotalScore(1);
        if (userTotalScore != null) {
            userScoreDetail.setTotalScore(userTotalScore.getTotalScore()+1);
        }
        userScoreDetail.setCreateTime(DateUtil.date());
        userScoreDetail.setScoreType(ScoreTypeEnum.SIGN.getDesc());
        userScoreDetail.setRemark(ScoreTypeEnum.SIGN.getDesc());
        userScoreDetailMapper.insertSelective(userScoreDetail);
        return Result.success();
    }


    /**
     * @Description: 用户签到次数
     * @Param: [userId]
     * @Return: com.study.vo.Result
     * @Auther: zhangYu
     * @Date: 2021/4/23 16:06
     */
    @Override
    public Result userSignInfoCount(Long userId) {
        log.info("userSignInfoCount 用户签到次数 ======= > 入参{}:",userId);
        int month = DateUtil.month(DateUtil.date())+1;
        Integer count = signInfoMapper.getUserSignInfoCountByUserId(userId, month);
        log.info("userSignInfoCount 用户签到次数 ======= > 反参{}:",count);
        return Result.success(count);
    }

}
