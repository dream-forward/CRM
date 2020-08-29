package com.hy.crm.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色与权限中间表
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
@TableName("role_permission")
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rpid", type = IdType.AUTO)
    private Integer rpid;

    @ApiModelProperty(value = "角色id")
    private Integer roleid;

    @ApiModelProperty(value = "权限id")
    private Integer perid;

    public Integer getRpid() {
        return rpid;
    }

    public void setRpid(Integer rpid) {
        this.rpid = rpid;
    }
    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
            "rpid=" + rpid +
            ", roleid=" + roleid +
            ", perid=" + perid +
        "}";
    }
}
