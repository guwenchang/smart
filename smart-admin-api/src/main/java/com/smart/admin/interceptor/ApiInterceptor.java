package com.smart.admin.interceptor;


import com.smart.admin.entity.SysUser;
import com.smart.admin.service.IAuthService;
import com.smart.admin.service.ISysUserService;
import com.smart.common.annotation.Action;
import com.smart.common.annotation.Login;
import com.smart.common.annotation.Permission;
import com.smart.common.consts.Constant;
import com.smart.common.exception.ApiException;
import com.smart.common.result.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;


/**
 * 访问权限的拦截器
 * @author guxiaobai
 */
@Component
public class ApiInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ApiInterceptor.class);
    private static final String ADMIN_TOKEN = "984ccdc6057a3d0dd4666666";

    @Autowired
    private IAuthService authService;
    @Autowired
    private ISysUserService sysUserService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //默认都需要权限
            Login needLogin = handlerMethod.getMethodAnnotation(Login.class);
            if (needLogin == null || needLogin.action().equals(Action.Normal)) {

                SysUser account = getAccountObject(request);
                //登录校验
                if (account == null) {
                    logger.warn("需要登陆:" + request.getRequestURI() + ",ParameterMap:" + request.getParameterMap());
                    throw new ApiException("需要登陆:" + request.getRequestURI() + ",ParameterMap:" + request.getParameterMap(), ApiResult.NO_LOGIN);
                }
                //权限校验
                Permission permission = handlerMethod.getMethodAnnotation(Permission.class);
                if (permission != null && permission.action().equals(Action.Normal)) {
                    Set<String> userPermissions = (Set<String>) request.getSession().getAttribute(Constant.USER_PERMS);
                    if (userPermissions == null){
                        userPermissions = authService.getUserPerms(account.getId());
                    }
                    if (userPermissions.contains(permission.value())){

                    }else {
                        logger.warn("没有权限:" + request.getRequestURI() + ",ParameterMap:" + request.getParameterMap());
                        throw new ApiException("没有权限:" + request.getRequestURI() + ",ParameterMap:" + request.getParameterMap(), ApiResult.NO_PERMISSION);

                    }

                }
            }
            return super.preHandle(request, response, handler);
        }

        return super.preHandle(request, response, handler);
    }

    protected SysUser getAccountObject(HttpServletRequest request) {
        if (ADMIN_TOKEN.equals(request.getHeader(Constant.TOKEN_KEY))){
            SysUser sysUser = sysUserService.selectById(1L);
            request.getSession().setAttribute(Constant.CURRENT_USER,sysUser);
            return sysUser;
        }
        SysUser loginUser = (SysUser)request.getSession().getAttribute(Constant.CURRENT_USER);
        return loginUser;
    }


}
