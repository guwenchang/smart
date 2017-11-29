package com.smart.admin.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author xiaobai
 * @since 2017-11-24
 */
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 姓名
     */
	@TableField("real_name")
	private String realName;
    /**
     * 密码
     */
	@JSONField(serialize = false)
	private String password;
    /**
     * 手机号
     */
	private String mobile;
    /**
     * 盐
     */
	@JSONField(serialize = false)
	private String salt;
    /**
     * 部门id
     */
	@TableField("dept_id")
	private Long deptId;
    /**
     * 状态  1：禁用   0：正常
     */
	@TableField("is_stop")
	private Boolean isStop;
    /**
     * 创建时间
     */
	@TableField("create_time")
	@JSONField(serialize = false)
	private Date createTime;


	/**
	 * 用户对应的角色id数组
	 */
	@TableField(exist = false)
	private List<Long> roleIds;


	public List<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Boolean isIsStop() {
		return isStop;
	}

	public void setIsStop(Boolean isStop) {
		this.isStop = isStop;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public static final String ID = "id";

	public static final String REAL_NAME = "real_name";

	public static final String PASSWORD = "password";

	public static final String MOBILE = "mobile";

	public static final String SALT = "salt";

	public static final String DEPT_ID = "dept_id";

	public static final String IS_STOP = "is_stop";

	public static final String CREATE_TIME = "create_time";

	@Override
	public String toString() {
		return "SysUser{" +
			"id=" + id +
			", realName=" + realName +
			", password=" + password +
			", mobile=" + mobile +
			", salt=" + salt +
			", deptId=" + deptId +
			", isStop=" + isStop +
			", createTime=" + createTime +
			"}";
	}
}
