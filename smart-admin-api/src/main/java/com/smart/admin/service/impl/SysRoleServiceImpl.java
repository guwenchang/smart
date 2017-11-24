package com.smart.admin.service.impl;

import com.smart.admin.entity.SysRole;
import com.smart.admin.mapper.SysRoleMapper;
import com.smart.admin.service.ISysRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author xiaobai
 * @since 2017-11-24
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public List<Long> selectMenuIdsByRoleId(Long id) {
        return this.baseMapper.selectMenuIdsByRoleId(id);
    }

}
