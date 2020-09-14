package com.hy.crm.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.user.mapper.RoleMapper;
import com.hy.crm.user.pojo.Role;
import com.hy.crm.user.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
/**
 * 根据用户名查询自己的角色
 * @param useraccount
 * @return
 */
        @Override
        public Set<String> queryRoleByuser(String useraccount){
            List<Role> roles = roleMapper.queryRoleByuser(useraccount);
            Set<String> set = new HashSet<>();
            for (Role role:roles){
                set.add(role.getRolename());
            }
            return set;
        }
    };

