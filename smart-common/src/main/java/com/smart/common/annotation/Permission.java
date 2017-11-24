package com.smart.common.annotation;

import java.lang.annotation.*;


/**
* 权限注解
* @author xiaobai
* @date 2017/10/29 14:59
**/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
	
	/**
	 * 权限内容
	 */
	String value() default "";

	/**
	 * 执行动作
	 * {@link Action}
	 */
	Action action() default Action.Normal;

}