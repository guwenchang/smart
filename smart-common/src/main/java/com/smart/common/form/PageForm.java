package com.smart.common.form;

import io.swagger.annotations.ApiModelProperty;

/**
* 分页查询的基础form
* @author xiaobai
* @date 2017/10/30 12:40
**/
public class PageForm {


	
	@ApiModelProperty("页码")
	private int pageNo = 1;

	@ApiModelProperty("每页记录数")
	private int pageSize = 20;

	@ApiModelProperty("排序字段")
	private String orderByField = "id";

	@ApiModelProperty("排序字段")
	private boolean isAsc = false;


	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getOrderByField() {
		return orderByField;
	}

	public void setOrderByField(String orderByField) {
		this.orderByField = orderByField;
	}

	public boolean isAsc() {
		return isAsc;
	}

	public void setAsc(boolean asc) {
		isAsc = asc;
	}

	@Override
	public String toString() {
		return "SearchForm{" +
				"pageNo=" + pageNo +
				", pageSize=" + pageSize +
				", orderByField='" + orderByField + '\'' +
				", isAsc=" + isAsc +
				'}';
	}
}
