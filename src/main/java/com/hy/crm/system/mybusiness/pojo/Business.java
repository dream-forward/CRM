package com.hy.crm.system.mybusiness.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 商机表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Business对象", description="商机表")
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商机id")
    @TableId(value = "busid", type = IdType.AUTO)
    private Integer busid;

    @ApiModelProperty(value = "商机名称（客户+商机）")
    private String busname;

    @ApiModelProperty(value = "商机短名称")
    private String shortname;

    @ApiModelProperty(value = "优先级:1-高,2-中,3-低")
    private String priority;

    @ApiModelProperty(value = "客户来源")
    private String busfrom;

    @ApiModelProperty(value = "预计成交金额")
    private BigDecimal maymoney;

    @ApiModelProperty(value = "预计结单日期")
    private Date maydate;

    @ApiModelProperty(value = "联系人")
    private String busperson;

    @ApiModelProperty(value = "联系人部门")
    private String perdept;

    @ApiModelProperty(value = "联系人职务")
    private String buspostion;

    @ApiModelProperty(value = "联系人办公电话")
    private String busofficenum;

    @ApiModelProperty(value = "联系人移动电话")
    private String busnum;

    @ApiModelProperty(value = "联系人QQ")
    private String busqq;

    @ApiModelProperty(value = "业务需求")
    private String busneed;

    @ApiModelProperty(value = "相关文件")
    private String busfile;

    @ApiModelProperty(value = "商机所属部门")
    private String busdept;

    @ApiModelProperty(value = "商机负责人")
    private String busprincipal;

    @ApiModelProperty(value = "商机参与人")
    private String busparticipant;

    @ApiModelProperty(value = "商机关注人")
    private String busfocus;

    @ApiModelProperty(value = "商机所属客户id")
    private Integer clientid;

    public Integer getBusid() {
        return busid;
    }

    public void setBusid(Integer busid) {
        this.busid = busid;
    }
    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }
    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getBusfrom() {
        return busfrom;
    }

    public void setBusfrom(String busfrom) {
        this.busfrom = busfrom;
    }
    public BigDecimal getMaymoney() {
        return maymoney;
    }

    public void setMaymoney(BigDecimal maymoney) {
        this.maymoney = maymoney;
    }
    public Date getMaydate() {
        return maydate;
    }

    public void setMaydate(Date maydate) {
        this.maydate = maydate;
    }
    public String getBusperson() {
        return busperson;
    }

    public void setBusperson(String busperson) {
        this.busperson = busperson;
    }
    public String getPerdept() {
        return perdept;
    }

    public void setPerdept(String perdept) {
        this.perdept = perdept;
    }
    public String getBuspostion() {
        return buspostion;
    }

    public void setBuspostion(String buspostion) {
        this.buspostion = buspostion;
    }
    public String getBusofficenum() {
        return busofficenum;
    }

    public void setBusofficenum(String busofficenum) {
        this.busofficenum = busofficenum;
    }
    public String getBusnum() {
        return busnum;
    }

    public void setBusnum(String busnum) {
        this.busnum = busnum;
    }
    public String getBusqq() {
        return busqq;
    }

    public void setBusqq(String busqq) {
        this.busqq = busqq;
    }
    public String getBusneed() {
        return busneed;
    }

    public void setBusneed(String busneed) {
        this.busneed = busneed;
    }
    public String getBusfile() {
        return busfile;
    }

    public void setBusfile(String busfile) {
        this.busfile = busfile;
    }
    public String getBusdept() {
        return busdept;
    }

    public void setBusdept(String busdept) {
        this.busdept = busdept;
    }
    public String getBusprincipal() {
        return busprincipal;
    }

    public void setBusprincipal(String busprincipal) {
        this.busprincipal = busprincipal;
    }
    public String getBusparticipant() {
        return busparticipant;
    }

    public void setBusparticipant(String busparticipant) {
        this.busparticipant = busparticipant;
    }
    public String getBusfocus() {
        return busfocus;
    }

    public void setBusfocus(String busfocus) {
        this.busfocus = busfocus;
    }
    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    @Override
    public String toString() {
        return "Business{" +
            "busid=" + busid +
            ", busname=" + busname +
            ", shortname=" + shortname +
            ", priority=" + priority +
            ", busfrom=" + busfrom +
            ", maymoney=" + maymoney +
            ", maydate=" + maydate +
            ", busperson=" + busperson +
            ", perdept=" + perdept +
            ", buspostion=" + buspostion +
            ", busofficenum=" + busofficenum +
            ", busnum=" + busnum +
            ", busqq=" + busqq +
            ", busneed=" + busneed +
            ", busfile=" + busfile +
            ", busdept=" + busdept +
            ", busprincipal=" + busprincipal +
            ", busparticipant=" + busparticipant +
            ", busfocus=" + busfocus +
            ", clientid=" + clientid +
        "}";
    }
}
