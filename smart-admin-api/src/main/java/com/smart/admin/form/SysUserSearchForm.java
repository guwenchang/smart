package com.smart.admin.form;

import com.smart.common.form.PageForm;
import io.swagger.annotations.ApiModelProperty;

/**
* 字典查询form
* @author xiaobai
* @date 2017/10/30 12:40
**/
public class SysUserSearchForm extends PageForm {

	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String realName;
	/**
	 * 手机号
	 */
	@ApiModelProperty("手机号")
	private String mobile;


	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "SysUserSearchForm{" +
				"realName='" + realName + '\'' +
				", mobile='" + mobile + '\'' +
				'}';
	}
}
