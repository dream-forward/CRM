package com.hy.crm.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.user.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select * from role where roleid in(\n" +
            "\t\t\t\t\t\t\tselect rid from user_role where uid in(\n" +
            "\t\t\t\t\t\t\t\t\t\t\tselect userid from user where useraccount = #{value} ))")
    List<Role> queryRoleByuser(String username);
}
