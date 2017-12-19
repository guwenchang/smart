package com.smart.admin.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 部门表
 * </p>
 *
 * @author xiaobai
 * @since 2017-12-19
 */
@TableName("sys_dept")
public class SysDept implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 上级部门ID，一级部门为0
     */
	@TableField("parent_id")
	private Long parentId;
    /**
     * 部门名称
     */
	private String name;
    /**
     * 排序
     */
	@TableField("order_num")
	private Integer orderNum;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 删除标志
     */
	@TableField("delete_flag")
	private Boolean deleteFlag;


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

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public static final String ID = "id";

	public static final String PARENT_ID = "parent_id";

	public static final String NAME = "name";

	public static final String ORDER_NUM = "order_num";

	public static final String CREATE_TIME = "create_time";

	public static final String DELETE_FLAG = "delete_flag";

	@Override
	public String toString() {
		return "SysDept{" +
			"id=" + id +
			", parentId=" + parentId +
			", name=" + name +
			", orderNum=" + orderNum +
			", createTime=" + createTime +
			", deleteFlag=" + deleteFlag +
			"}";
	}
}
