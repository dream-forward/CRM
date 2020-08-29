package com.hy.crm.user.service.impl;

import com.hy.crm.user.pojo.User;
import com.hy.crm.user.mapper.UserMapper;
import com.hy.crm.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
