package com.hy.crm.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.user.pojo.Role;

import java.util.Set;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
public interface IRoleService extends IService<Role> {
    Set<String> queryRoleByuser(String useraccount);
}
