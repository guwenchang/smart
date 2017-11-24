package com.smart.common.annotation;

/**
* 权限验证行为
* @author xiaobai
* @date 2017/10/29 14:57
**/

public enum Action {
	/** 正常（默认） */
	Normal("0", "执行权限验证"),
	
	/** 跳过 */
	Skip("1", "跳过权限验证");

	/** 主键 */
	private final String key;

	/** 描述 */
	private final String desc;

	Action(final String key, final String desc) {
		this.key = key;
		this.desc = desc;
	}

	public String getKey() {
		return this.key;
	}

	public String getDesc() {
		return this.desc;
	}

}