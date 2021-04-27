package com.study.vo;

import lombok.Data;

/**
 * @Description: 分页基础请求Vo
 * @Auther: zhangYu
 * @Date: 2021/4/27 16:17
 */
@Data
public class BasePageRequestVo {

	/**
	 * 请求页码
	 */
	private int pageNum = 1;

	/**
	 * 每页记录数
	 */
	private int pageSize = 10;
}
