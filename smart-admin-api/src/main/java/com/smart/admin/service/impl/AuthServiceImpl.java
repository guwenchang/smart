package com.smart.admin.service.impl;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.smart.admin.entity.SysMenu;
import com.smart.admin.service.IAuthService;
import com.smart.admin.service.ISysMenuService;
import com.smart.admin.service.ISysUserService;
import com.smart.common.consts.Constant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private ISysMenuService sysMenuService;
    @Autowired
    private ISysUserService sysUserService;


    @Override
    public Set<String> getUserPerms(long userId) {
        List<String> permsList;
        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            List<SysMenu> menuList = sysMenuService.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(SysMenu menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserService.selectPermsByUserId(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public List<SysMenu> getUserMenuList(Long userId) {
        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            return getAllMenuList(null);
        }
        //用户菜单列表
        List<Long> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList);
    }

    /**
     * 获取所有菜单列表
     */
    private List<SysMenu> getAllMenuList(List<Long> menuIdList){
        //查询根菜单列表
        List<SysMenu> menuList = queryListParentId(0L, menuIdList);
        //递归获取子菜单
        getMenuTreeList(menuList, menuIdList);
        return menuList;
    }


    public List<SysMenu> queryListParentId(Long parentId, List<Long> menuIdList) {
        EntityWrapper<SysMenu> menuWrapper = new EntityWrapper<>();
        menuWrapper.eq(SysMenu.PARENT_ID,parentId);
        menuWrapper.orderBy(SysMenu.ORDER_NUM,true);
        List<SysMenu> menuList = sysMenuService.selectList(menuWrapper);
        if(menuIdList == null){
            return menuList;
        }
        List<SysMenu> userMenuList = new ArrayList<>();
        for(SysMenu menu : menuList){
            if(menuIdList.contains(menu.getId())){
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }


    /**
     * 递归
     */
    private List<SysMenu> getMenuTreeList(List<SysMenu> menuList, List<Long> menuIdList){
        List<SysMenu> subMenuList = new ArrayList();
        for(SysMenu entity : menuList){
            if(entity.getType() == Constant.MenuType.CATALOG.getValue()){//目录
                entity.setChildren(getMenuTreeList(queryListParentId(entity.getId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }
        return subMenuList;
    }
}
