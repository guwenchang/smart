package com.smart.admin.form;


import java.util.List;
/**
 * 角色form
 * @author xiaobai
 * @date 2017/10/30 12:40
 **/
public class SysRoleForm {


	private Long id;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 权限id数组
	 */
	private List<Long> menuIds;


	public List<Long> getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(List<Long> menuIds) {
		this.menuIds = menuIds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "SysRoleForm{" +
				"id=" + id +
				", roleName='" + roleName + '\'' +
				", remark='" + remark + '\'' +
				", menuIds=" + menuIds +
				'}';
	}
}
