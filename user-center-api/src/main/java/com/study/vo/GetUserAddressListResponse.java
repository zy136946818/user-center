package com.study.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 查询用户地址
 * @Param:
 * @Return:
 * @Auther: zhangYu
 * @Date: 2021/4/20 20:26
 */
@Data
public class GetUserAddressListResponse implements Serializable {

    /**
     * 地址id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 一级（省编号）
     */
    private String provinceCode;

    /**
     * 二级（市编号）
     */
    private String cityCode;

    /**
     * 三级（县、县级市、区编号）
     */
    private String countryCode;

    /**
     * 四级（镇、街道编号）
     */
    private String townCode;

    /**
     * 五级（村、社区）
     */
    private String villageCode;

    /**
     * 一级（省名称）
     */
    private String provinceName;

    /**
     * 二级（市名称）
     */
    private String cityName;

    /**
     * 三级（县、县级市、区名称）
     */
    private String countryName;

    /**
     * 四级（镇、街道名称）
     */
    private String townName;

    /**
     * 五级（村、社区）名称
     */
    private String villageName;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 区域：省市区县组合
     */
    private String addressRegion;

    /**
     * 邮政编码
     */
    private String postalCode;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;



}
