package com.hy.crm.user.mapper;

import com.hy.crm.user.pojo.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户与角色中间表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
