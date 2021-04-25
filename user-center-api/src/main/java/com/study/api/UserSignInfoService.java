package com.study.api;

import com.study.vo.Result;

/**
 * @Author zhangYu
 * @Date 2021/4/22 17:04
 */
public interface UserSignInfoService {

    /**
     * @Description: 用户签到
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/23 8:46
     */
    Result userSignInfo(Long userId);
    /**
     * @Description: 用户签到次数
     * @Param:
     * @Return:
     * @Auther: zhangYu
     * @Date: 2021/4/23 16:05
     */
    Result userSignInfoCount(Long userId);





}
