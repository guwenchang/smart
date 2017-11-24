package com.smart.common.annotation;

import java.lang.annotation.*;

/**
* 登录注解
* @author xiaobai
* @date 2017/10/29 14:58
**/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {

	/**
	 * 执行动作
	 * {@link Action}
	 */
	Action action() default Action.Normal;
	
}
