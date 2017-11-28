package com.smart.admin.controller;


import com.smart.admin.entity.SysMenu;
import com.smart.admin.form.SysMenuForm;
import com.smart.admin.service.IAuthService;
import com.smart.admin.service.ISysMenuService;
import com.smart.common.result.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author guxiaobai
 * @since 2017-07-14
 */
@Api(description = "权限接口")
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController extends BaseController {

    @Autowired
    private IAuthService authService;

    @Autowired
    private ISysMenuService sysMenuService;


    @ApiOperation(value = "获取权限列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ApiResult list(){
        List<SysMenu> userMenuList = authService.getUserMenuList(1L);
        return ApiResult.success(userMenuList);
    }


    @ApiOperation(value = "获取权限详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ApiResult detail(@PathVariable Long id){
        SysMenu sysMenu = sysMenuService.selectById(id);
        if (sysMenu.getParentId() == 0){
            sysMenu.setParentName("顶层菜单");
        }else {
            SysMenu parent = sysMenuService.selectById(sysMenu.getParentId());
            sysMenu.setParentName(parent.getName());
        }
        return ApiResult.success(sysMenu);
    }


    @ApiOperation(value = "保存权限")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ApiResult save(@RequestBody SysMenuForm sysMenuForm){
        SysMenu sysMenu = new SysMenu();
        if ( sysMenuForm.getId() != null ) {
            BeanUtils.copyProperties(sysMenuForm,sysMenu);
            sysMenuService.updateById(sysMenu);
        } else {
            BeanUtils.copyProperties(sysMenuForm,sysMenu);
            sysMenuService.insert(sysMenu);
        }
        return ApiResult.success();
    }
}
