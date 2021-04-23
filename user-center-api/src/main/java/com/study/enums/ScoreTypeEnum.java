package com.study.enums;

/**
 * @Description: 积分变化类型
 * @Param:
 * @Return:
 * @Auther: zhangYu
 * @Date: 2021/4/22 17:21
 */
public enum ScoreTypeEnum {
	/**
	 *
	 */
	REGISTER(0, "注册赠送"),
	/**
	 *
	 */
	SIGN(1, "签到赠送"),
	/**
	 *
	 */
	BACK_ADJUST(2, "商家调整"),
	/**
	 *
	 */
	CONSUME(3, "消费赠送"),
	/**
	 *
	 */
	DEDUCT(4, "积分抵扣");

	private int value;
	private String desc;

	private ScoreTypeEnum(int value, String desc) {
		this.value = value;
		this.desc = desc;

	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
