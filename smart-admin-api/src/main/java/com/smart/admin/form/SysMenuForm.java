package com.smart.admin.form;

import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单form
 * @author xiaobai
 * @date 2017/10/30 12:40
 **/
public class SysMenuForm {


	@ApiModelProperty("id")
	private Long id;
	/**
	 * 父菜单ID，一级菜单为0
	 */
	@ApiModelProperty("父菜单ID")
	private Long parentId;
	/**
	 * 菜单名称
	 */
	@ApiModelProperty("菜单名称")
	private String name;
	/**
	 * 菜单URL
	 */
	@ApiModelProperty("菜单URL")
	private String url;
	/**
	 * 授权(多个用逗号分隔，如：user:list,user:create)
	 */
	@ApiModelProperty("授权(多个用逗号分隔，如：user:list,user:create)")
	private String perms;
	/**
	 * 类型   0：目录   1：菜单   2：按钮
	 */
	@ApiModelProperty("类型   0：目录   1：菜单   2：按钮")
	private Integer type;
	/**
	 * 菜单图标
	 */
	@ApiModelProperty("菜单图标")
	private String icon;
	/**
	 * 排序
	 */
	@ApiModelProperty("排序")
	private Integer orderNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	public String toString() {
		return "SysMenuForm{" +
				"id=" + id +
				", parentId=" + parentId +
				", name='" + name + '\'' +
				", url='" + url + '\'' +
				", perms='" + perms + '\'' +
				", type=" + type +
				", icon='" + icon + '\'' +
				", orderNum=" + orderNum +
				'}';
	}
}
