package com.smart.admin.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.smart.admin.entity.SysUser;
import com.smart.common.consts.Constant;
import com.smart.common.form.PageForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
* 基础controller
* @author xiaobai
* @date 2017/10/30 11:54
**/
public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	@Autowired
	protected HttpSession session;

	protected <T> Page<T> getPage(PageForm pageForm) {
		Page<T> page = new Page<T>(pageForm.getPageNo(), pageForm.getPageSize());
		page.setOrderByField(pageForm.getOrderByField());
		page.setAsc(pageForm.isAsc());
		return page;
	}


	protected SysUser currentUser() {
		return (SysUser) request.getSession().getAttribute(Constant.CURRENT_USER);
	}

	protected Long currentUserId() {
		return currentUser().getId();
	}




}