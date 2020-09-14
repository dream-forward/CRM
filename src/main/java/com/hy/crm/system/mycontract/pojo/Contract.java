package com.hy.crm.system.mycontract.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 合同表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@TableName("contract")
public class Contract implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "合同id")
    @TableId(value = "conid", type = IdType.AUTO)
    private Integer conid;

    @ApiModelProperty(value = "合同名称（客户名称+合同名称）")
    private String conname;

    @ApiModelProperty(value = "商机短名称")
    private String shortname;

    @ApiModelProperty(value = "合同优先级:1-高,2-中,3-低")
    private String conpriority;

    @ApiModelProperty(value = "客户id")
    private Integer clientid;

    @ApiModelProperty(value = "合同编号")
    private String connum;

    @ApiModelProperty(value = "合同金额")
    private BigDecimal conmoney;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "签约日期")
    private Date condate;
    @DateTimeFormat(pattern="yyyy-MM-dd")

    @ApiModelProperty(value = "生效时间")
    private Date begindate;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "失效日期")
    private Date enddate;

    @ApiModelProperty(value = "对方联系人")
    private String conperson;

    @ApiModelProperty(value = "固定电话")
    private String conofficenum;

    @ApiModelProperty(value = "移动电话")
    private String conphone;

    @ApiModelProperty(value = "邮件/QQ")
    private String conqq;

    @ApiModelProperty(value = "主要技术条款")
    @TableField("Technicalclause")
    private String Technicalclause;

    @ApiModelProperty(value = "商务条款")
    private String businessclause;

    @ApiModelProperty(value = "相关附件")
    private String confile;

    @ApiModelProperty(value = "合同所属部门")
    private String condept;

    @ApiModelProperty(value = "关联人员")
    private String associatedpersonnel;

    @ApiModelProperty(value = "合同状态:1-执行,2-关闭,3-撤除,4-搁置")
    private String currentstatus;

    private Integer userid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getConid() {
        return conid;
    }

    public void setConid(Integer conid) {
        this.conid = conid;
    }
    public String getConname() {
        return conname;
    }

    public void setConname(String conname) {
        this.conname = conname;
    }
    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }
    public String getConpriority() {
        return conpriority;
    }

    public void setConpriority(String conpriority) {
        this.conpriority = conpriority;
    }
    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }
    public String getConnum() {
        return connum;
    }

    public void setConnum(String connum) {
        this.connum = connum;
    }
    public BigDecimal getConmoney() {
        return conmoney;
    }

    public void setConmoney(BigDecimal conmoney) {
        this.conmoney = conmoney;
    }
    public Date getCondate() {
        return condate;
    }

    public void setCondate(Date condate) {
        this.condate = condate;
    }
    public Date getBegindate() {
        return begindate;
    }

    public void setBegindate(Date begindate) {
        this.begindate = begindate;
    }
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    public String getConperson() {
        return conperson;
    }

    public void setConperson(String conperson) {
        this.conperson = conperson;
    }
    public String getConofficenum() {
        return conofficenum;
    }

    public void setConofficenum(String conofficenum) {
        this.conofficenum = conofficenum;
    }
    public String getConphone() {
        return conphone;
    }

    public void setConphone(String conphone) {
        this.conphone = conphone;
    }
    public String getConqq() {
        return conqq;
    }

    public void setConqq(String conqq) {
        this.conqq = conqq;
    }
    public String getTechnicalclause() {
        return Technicalclause;
    }

    public void setTechnicalclause(String Technicalclause) {
        this.Technicalclause = Technicalclause;
    }
    public String getBusinessclause() {
        return businessclause;
    }

    public void setBusinessclause(String businessclause) {
        this.businessclause = businessclause;
    }
    public String getConfile() {
        return confile;
    }

    public void setConfile(String confile) {
        this.confile = confile;
    }
    public String getCondept() {
        return condept;
    }

    public void setCondept(String condept) {
        this.condept = condept;
    }

    public String getAssociatedpersonnel() {
        return associatedpersonnel;
    }

    public void setAssociatedpersonnel(String associatedpersonnel) {
        this.associatedpersonnel = associatedpersonnel;
    }
    public String getCurrentstatus() {
        return currentstatus;
    }

    public void setCurrentstatus(String currentstatus) {
        this.currentstatus = currentstatus;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "conid=" + conid +
                ", conname='" + conname + '\'' +
                ", shortname='" + shortname + '\'' +
                ", conpriority='" + conpriority + '\'' +
                ", clientid=" + clientid +
                ", connum='" + connum + '\'' +
                ", conmoney=" + conmoney +
                ", condate=" + condate +
                ", begindate=" + begindate +
                ", enddate=" + enddate +
                ", conperson='" + conperson + '\'' +
                ", conofficenum='" + conofficenum + '\'' +
                ", conphone='" + conphone + '\'' +
                ", conqq='" + conqq + '\'' +
                ", Technicalclause='" + Technicalclause + '\'' +
                ", businessclause='" + businessclause + '\'' +
                ", confile='" + confile + '\'' +
                ", condept='" + condept + '\'' +
                ", associatedpersonnel='" + associatedpersonnel + '\'' +
                ", currentstatus='" + currentstatus + '\'' +
                ", userid=" + userid +
                '}';
    }
}
