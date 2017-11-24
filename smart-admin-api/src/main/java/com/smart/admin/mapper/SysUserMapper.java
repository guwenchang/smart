package com.smart.admin.mapper;

import com.smart.admin.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 系统用户 Mapper 接口
 * </p>
 *
 * @author xiaobai
 * @since 2017-11-24
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 获取用户的所有权限
     * @param userId
     * @return
     */
    List<String> selectPermsByUserId(long userId);

    /**
     * 获取用户的所有菜单
     * @param userId
     * @return
     */
    List<Long> queryAllMenuId(Long userId);

    /**
     * 获取用户的角色id数据
     * @param userId
     * @return
     */
    List<Long> selectRoleIdsByUserId(Long userId);
}