package com.study.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhangYu
 * @Date 2021/4/20 16:03
 */
@Data
public class DeleteUserAddressRequest implements Serializable {

    /**
     * 地址id
     */
    private String addressId;
}
