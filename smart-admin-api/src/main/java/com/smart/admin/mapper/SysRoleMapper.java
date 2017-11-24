package com.smart.admin.mapper;

import com.smart.admin.entity.SysRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 角色 Mapper 接口
 * </p>
 *
 * @author xiaobai
 * @since 2017-11-24
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<Long> selectMenuIdsByRoleId(Long id);

}