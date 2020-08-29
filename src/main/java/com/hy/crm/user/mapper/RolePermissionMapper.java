package com.hy.crm.user.mapper;

import com.hy.crm.user.pojo.RolePermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色与权限中间表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

}
