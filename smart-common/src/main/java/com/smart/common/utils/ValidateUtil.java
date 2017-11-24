package com.smart.common.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
* 校验工具类
* @author xiaobai
* @date 2017/10/29 15:06
**/

public class ValidateUtil {

	public static String toStringJson(BindingResult result){
		
		String msg = "";
		for(FieldError fieldError : result.getFieldErrors()){
			msg = msg + fieldError.getDefaultMessage();
			break;
		}
		return msg;
		
	}
	
}
