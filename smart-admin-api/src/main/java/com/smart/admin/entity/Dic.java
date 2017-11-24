package com.smart.admin.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 字典数据
 * </p>
 *
 * @author xiaobai
 * @since 2017-11-24
 */
@TableName("smart_dic")
public class Dic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主鍵id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 字典编码
     */
	private String code;
    /**
     * 字典值
     */
	private String value;
    /**
     * 字典视图值
     */
	private String name;
    /**
     * 排序号
     */
	@TableField("order_num")
	private Integer orderNum;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	public static final String ID = "id";

	public static final String CODE = "code";

	public static final String VALUE = "value";

	public static final String NAME = "name";

	public static final String ORDER_NUM = "order_num";

	@Override
	public String toString() {
		return "Dic{" +
			"id=" + id +
			", code=" + code +
			", value=" + value +
			", name=" + name +
			", orderNum=" + orderNum +
			"}";
	}
}
