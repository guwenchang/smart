package com.smart.admin.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.smart.admin.entity.SysRole;
import com.smart.admin.entity.SysRoleMenu;
import com.smart.admin.form.SysRoleForm;
import com.smart.admin.service.ISysRoleMenuService;
import com.smart.admin.service.ISysRoleService;
import com.smart.common.result.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author guxiaobai
 * @since 2017-07-14
 */
@Api(description = "角色接口")
@RestController
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private ISysRoleMenuService sysRoleMenuService;



    @ApiOperation(value = "获取角色列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ApiResult list(){
        List<SysRole> menuList = sysRoleService.selectList(null);
        return ApiResult.success(menuList);
    }


    @ApiOperation(value = "保存角色")
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ApiResult save(@RequestBody SysRoleForm sysRoleForm){

        SysRole sysRole = new SysRole();
            if ( sysRoleForm.getId() != null ) {
                BeanUtils.copyProperties(sysRoleForm,sysRole);
                sysRoleService.updateById(sysRole);

                EntityWrapper<SysRoleMenu> wrapper = new EntityWrapper<>();
                wrapper.eq(SysRoleMenu.ROLE_ID,sysRole.getId());
                sysRoleMenuService.delete(wrapper);
                updateRoleMenu(sysRoleForm, sysRole);
            } else {
                BeanUtils.copyProperties(sysRoleForm,sysRole);
                sysRole.setCreateTime(new Date());
                sysRoleService.insert(sysRole);
                updateRoleMenu(sysRoleForm, sysRole);
            }

        return ApiResult.success();
    }


    @ApiOperation(value = "获取角色详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ApiResult detail(@PathVariable Long id){
        SysRole sysRole = sysRoleService.selectById(id);
        sysRole.setMenuIds(sysRoleService.selectMenuIdsByRoleId(id));
        return ApiResult.success(sysRole);
    }
    private void updateRoleMenu(SysRoleForm sysRoleForm, SysRole sysRole) {
        List<SysRoleMenu> sysRoleMenus = new ArrayList<>();
        for (Long menuId : sysRoleForm.getMenuIds()) {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(sysRole.getId());
            sysRoleMenu.setMenuId(menuId);
            sysRoleMenus.add(sysRoleMenu);
        }
        sysRoleMenuService.insertBatch(sysRoleMenus);
    }

}
