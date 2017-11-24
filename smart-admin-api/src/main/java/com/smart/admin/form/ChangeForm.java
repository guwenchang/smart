package com.smart.admin.form;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class ChangeForm {


	
	/** 原密码 */
	@NotBlank(message="原密码不能为空")
	@Length(min = 5, max = 20, message = "密码长度为5-20之间")
	@ApiModelProperty("原密码")
	private String oldPassword;


	/** 密码 */
	@NotBlank(message="新密码不能为空")
	@Length(min = 5, max = 20, message = "密码长度为5-20之间")
	@ApiModelProperty("新密码")
	private String password;


	public String getOldPassword() {
		return oldPassword;
	}


	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ChangeForm{" +
				"oldPassword='" + oldPassword + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
