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
	 * 手机号
	 */
	@ApiModelProperty("姓名")
	private String mobile;

	@ApiModelProperty("角色id数据")
	private List<Long> roleIds;


	@ApiModelProperty("是否禁用")
	private Boolean isStop;

	public Boolean getIsStop() {
		return isStop;
	}

	public void setIsStop(Boolean isStop) {
		this.isStop = isStop;
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
				", mobile='" + mobile + '\'' +
				", roleIds=" + roleIds +
				", isStop=" + isStop +
				'}';
	}
}
