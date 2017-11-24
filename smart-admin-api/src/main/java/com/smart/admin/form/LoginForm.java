package com.smart.admin.form;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class LoginForm {



	@ApiModelProperty("手机号")
	@NotEmpty(message = "手机号不能为空")
	@Pattern(regexp = "[1][23578][0-9]{9}", message = "手机号不合法")
	private String mobile;


	@ApiModelProperty("密码")
	@NotBlank(message="密码不能为空")
	private String password;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginForm{" +
				"mobile='" + mobile + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
