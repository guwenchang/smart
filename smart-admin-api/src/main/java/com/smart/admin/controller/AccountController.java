package com.smart.admin.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.smart.admin.entity.SysMenu;
import com.smart.admin.entity.SysUser;
import com.smart.admin.form.ChangeForm;
import com.smart.admin.form.LoginForm;
import com.smart.admin.service.IAuthService;
import com.smart.admin.service.ISysUserService;
import com.smart.common.annotation.Action;
import com.smart.common.annotation.Login;
import com.smart.common.consts.Constant;
import com.smart.common.result.ApiResult;
import com.smart.common.utils.MD5Util;
import com.smart.common.utils.ValidateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author guxiaobai
 * @since 2017-07-17
 */
@Api(description = "账户相关接口")
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {



    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IAuthService authService;

    @ApiOperation(value = "账户登录")
    @Login(action = Action.Skip)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult login(@Valid @RequestBody LoginForm loginForm, BindingResult result){
        if (result.hasErrors()) {
            return ApiResult.validate(ValidateUtil.toStringJson(result));
        }
        EntityWrapper<SysUser> sysUserEntityWrapper = new EntityWrapper<>();
        sysUserEntityWrapper.eq(SysUser.MOBILE,loginForm.getMobile());
        SysUser sysUser = sysUserService.selectOne(sysUserEntityWrapper);
        //账号不存在、密码错误
        if(sysUser == null || !sysUser.getPassword().equals(MD5Util.md5(loginForm.getPassword()+sysUser.getSalt()))){
            return ApiResult.error("账号或密码不正确");
        }
        return login(sysUser);
    }

    private ApiResult login(SysUser sysUser) {

        Map<String,Object> map = new HashMap<>();
        map.put("token",request.getSession().getId());
        map.put("user",sysUser);
        Set<String> permissions = authService.getUserPerms(sysUser.getId());
        request.getSession().setAttribute(Constant.USER_PERMS,permissions);
        request.getSession().setAttribute(Constant.CURRENT_USER,sysUser);
        return ApiResult.success(map);
    }



    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ApiResult changePassword(@Valid @RequestBody ChangeForm changeForm, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return ApiResult.validate(ValidateUtil.toStringJson(result));
        }
        SysUser sysUser = sysUserService.selectById(currentUserId());
        if (!sysUser.getPassword().equals(MD5Util.md5(changeForm.getOldPassword()+sysUser.getSalt()))) {
            return ApiResult.validate("原密码不正确");
        }
        sysUser.setPassword(MD5Util.md5(changeForm.getPassword()+sysUser.getSalt()));
        sysUserService.updateById(sysUser);
        return ApiResult.success();
    }

    @ApiOperation(value = "登出")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ApiResult logout() throws Exception {
        request.getSession().invalidate();
        return ApiResult.success();
    }


    /**
     * 用户菜单列表
     */
    @ApiOperation(value = "获取用户的菜单列表和权限列表")
    @RequestMapping(value = "/perms" ,method = RequestMethod.GET)
    public ApiResult getPerms(){
        List<SysMenu> menuList = authService.getUserMenuList(currentUserId());
        Set<String> permissions = authService.getUserPerms(currentUserId());
        Map<String,Object> map = new HashMap<>();
        map.put("menuList", menuList);
        map.put("permissions", permissions);
        return ApiResult.success(map);
    }

}
