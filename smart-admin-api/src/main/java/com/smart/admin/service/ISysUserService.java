package com.smart.admin.service;

import com.smart.admin.entity.SysUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author xiaobai
 * @since 2017-11-24
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 获取用户的所有权限
     * @params userId
     * @author xiaobai
     * @date 2017/10/30 10:29
     **/
    List<String> selectPermsByUserId(long userId);

    /**
     * 获取用户的菜单列表
     * @params userId
     * @author xiaobai
     * @date 2017/10/30 10:30
     **/
    List<Long> queryAllMenuId(Long userId);

    /**
     * 获取用户的角色id列表
     * @params id
     * @author xiaobai
     * @date 2017/10/30 10:30
     **/
    List<Long> selectRoleIdsByUserId(Long id);
}
