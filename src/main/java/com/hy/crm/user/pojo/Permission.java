package com.hy.crm.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
@TableName("permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "权限id")
    @TableId(value = "perid", type = IdType.AUTO)
    private Integer perid;

    @ApiModelProperty(value = "权限名称")
    private String pername;

    @ApiModelProperty(value = "父级id")
    private Integer parentid;

    @ApiModelProperty(value = "权限地址")
    private String perurl;

    public Integer getPerid() {
        return perid;
    }

    public void setPerid(Integer perid) {
        this.perid = perid;
    }
    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }
    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
    public String getPerurl() {
        return perurl;
    }

    public void setPerurl(String perurl) {
        this.perurl = perurl;
    }

    @Override
    public String toString() {
        return "Permission{" +
            "perid=" + perid +
            ", pername=" + pername +
            ", parentid=" + parentid +
            ", perurl=" + perurl +
        "}";
    }
}
