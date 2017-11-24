package com.smart.admin.form;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
* 系统用户form
* @author xiaobai
* @date 2017/10/30 12:40
**/
public class SysUserForm {


	/**
	 * id
	 */
	@ApiModelProperty("id")
	private Long id;

	/**
	 * 姓名
	 */
	@ApiModelProperty("姓名")
	private String realName;
	/**
	 * 密码
	 */
	@ApiModelProperty("姓名")
	private String password;
	/**
	 * 手机号
	 */
	@ApiModelProperty("姓名")
	private String mobile;

	@ApiModelProperty("角色id数据")
	private List<Long> roleIds;


	@ApiModelProperty("是否禁用")
	private Boolean isStop;

	public Boolean getStop() {
		return isStop;
	}

	public void setStop(Boolean stop) {
		isStop = stop;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	@Override
	public String toString() {
		return "SysUserForm{" +
				"id=" + id +
				", realName='" + realName + '\'' +
				", password='" + password + '\'' +
				", mobile='" + mobile + '\'' +
				", roleIds=" + roleIds +
				", isStop=" + isStop +
				'}';
	}
}
