package com.smart.admin.form;

import com.smart.common.form.PageForm;
import io.swagger.annotations.ApiModelProperty;

/**
* 字典查询form
* @author xiaobai
* @date 2017/10/30 12:40
**/
public class DicSearchForm extends PageForm {


	
	@ApiModelProperty("字典编码")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "DicSearchForm{" +
				"code='" + code + '\'' +
				'}';
	}
}
