package com.smart.admin.service.impl;

import com.smart.admin.entity.User;
import com.smart.admin.mapper.UserMapper;
import com.smart.admin.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 业务用户 服务实现类
 * </p>
 *
 * @author xiaobai
 * @since 2017-11-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
	
}
