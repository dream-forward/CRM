package com.hy.crm.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户与角色中间表
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
@TableName("user_role")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "urid", type = IdType.AUTO)
    private Integer urid;

    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "角色id")
    private Integer rid;

    public Integer getUrid() {
        return urid;
    }

    public void setUrid(Integer urid) {
        this.urid = urid;
    }
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "UserRole{" +
            "urid=" + urid +
            ", uid=" + uid +
            ", rid=" + rid +
        "}";
    }
}
