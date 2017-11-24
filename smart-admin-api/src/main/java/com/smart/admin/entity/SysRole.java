package com.smart.admin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author xiaobai
 * @since 2017-11-24
 */
@TableName("sys_role")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 角色名称
     */
	@TableField("role_name")
	private String roleName;
    /**
     * 备注
     */
	private String remark;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	/**
	 * 对应的权限id
	 */
	@TableField(exist = false)
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public static final String ID = "id";

	public static final String ROLE_NAME = "role_name";

	public static final String REMARK = "remark";

	public static final String CREATE_TIME = "create_time";

	@Override
	public String toString() {
		return "SysRole{" +
			"id=" + id +
			", roleName=" + roleName +
			", remark=" + remark +
			", createTime=" + createTime +
			"}";
	}
}
