package com.smart.admin.service;

import com.smart.admin.entity.SysRole;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author xiaobai
 * @since 2017-11-24
 */
public interface ISysRoleService extends IService<SysRole> {
    List<Long> selectMenuIdsByRoleId(Long id);

}
