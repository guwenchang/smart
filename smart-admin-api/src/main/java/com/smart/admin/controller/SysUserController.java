package com.smart.admin.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.smart.admin.entity.SysUser;
import com.smart.admin.entity.SysUserRole;
import com.smart.admin.form.SysUserForm;
import com.smart.admin.form.SysUserSearchForm;
import com.smart.admin.service.ISysUserRoleService;
import com.smart.admin.service.ISysUserService;
import com.smart.common.result.ApiResult;
import com.smart.common.utils.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author guxiaobai
 * @since 2017-07-14
 */
@Api(description = "用户接口")
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysUserRoleService sysUserRoleService;



    @ApiOperation(value = "用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResult list(@RequestBody SysUserSearchForm sysUserSearchForm){
        Page<SysUser> page = getPage(sysUserSearchForm);
        EntityWrapper<SysUser> wrapper = new EntityWrapper<>();
        if (StringUtils.isNotBlank(sysUserSearchForm.getMobile())){
            wrapper.eq(SysUser.MOBILE,sysUserSearchForm.getMobile());
        }
        if (StringUtils.isNotBlank(sysUserSearchForm.getRealName())){
            wrapper.like(SysUser.REAL_NAME,sysUserSearchForm.getRealName());
        }
        sysUserService.selectPage(page,wrapper);
        return ApiResult.success(page);
    }


    @ApiOperation(value = "用户保存")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ApiResult list(@RequestBody SysUserForm sysUserForm){

        SysUser sysUser = new SysUser();
            if ( sysUserForm.getId() != null ) {
                BeanUtils.copyProperties(sysUserForm,sysUser);
                sysUserService.updateById(sysUser);
                EntityWrapper<SysUserRole> wrapper = new EntityWrapper<>();
                wrapper.eq(SysUserRole.USER_ID,sysUserForm.getId());
                sysUserRoleService.delete(wrapper);
                updateUserRole(sysUserForm,sysUser);
            } else {
                BeanUtils.copyProperties(sysUserForm,sysUser);
                sysUser.setPassword(MD5Util.md5(sysUser.getMobile().substring(5)));
                sysUserService.insert(sysUser);
                updateUserRole(sysUserForm,sysUser);
            }

        return ApiResult.success();
    }

    @ApiOperation(value = "获取用户详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ApiResult detail(@PathVariable Long id){
        SysUser sysUser = sysUserService.selectById(id);
        sysUser.setRoleIds(sysUserService.selectRoleIdsByUserId(id));
        return ApiResult.success(sysUser);
    }



    private void updateUserRole(SysUserForm sysUserForm,SysUser sysUser) {
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        for (Long roleId : sysUserForm.getRoleIds()) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(roleId);
            sysUserRole.setUserId(sysUser.getId());
            sysUserRoles.add(sysUserRole);
        }
        sysUserRoleService.insertBatch(sysUserRoles);
    }


}
