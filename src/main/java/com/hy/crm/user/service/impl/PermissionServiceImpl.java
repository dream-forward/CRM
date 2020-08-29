package com.hy.crm.user.service.impl;

import com.hy.crm.user.pojo.Permission;
import com.hy.crm.user.mapper.PermissionMapper;
import com.hy.crm.user.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
