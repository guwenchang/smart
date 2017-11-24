package com.smart.admin.service.impl;

import com.smart.admin.entity.SysUser;
import com.smart.admin.mapper.SysUserMapper;
import com.smart.admin.service.ISysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author xiaobai
 * @since 2017-11-24
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public List<String> selectPermsByUserId(long userId) {
        return this.baseMapper.selectPermsByUserId(userId);
    }

    @Override
    public List<Long> queryAllMenuId(Long userId) {
        return this.baseMapper.queryAllMenuId(userId);
    }

    @Override
    public List<Long> selectRoleIdsByUserId(Long id) {
        return this.baseMapper.selectRoleIdsByUserId(id);    }
}
