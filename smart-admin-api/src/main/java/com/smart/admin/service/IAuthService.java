package com.smart.admin.service;


import com.smart.admin.entity.SysMenu;

import java.util.List;
import java.util.Set;

/**
* 权限认证服务
* @author xiaobai
* @date 2017/10/30 10:28
**/
public interface IAuthService {

    /**
    * 获取用户的所有权限
    * @params userId
    * @author xiaobai
    * @date 2017/10/30 10:29
    **/
    Set<String> getUserPerms(long userId);


    /**
    * 获取用户的菜单列表
    * @params userId
    * @author xiaobai
    * @date 2017/10/30 10:30
    **/
    List<SysMenu> getUserMenuList(Long userId);
}
