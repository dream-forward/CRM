package com.hy.crm.user.service.impl;

import com.hy.crm.user.pojo.UserRole;
import com.hy.crm.user.mapper.UserRoleMapper;
import com.hy.crm.user.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色中间表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
