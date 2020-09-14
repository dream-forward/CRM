package com.hy.crm.system.mycontract.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 收入说明
 * </p>
 *
 * @author TH
 * @since 2020-09-03
 */
@TableName("income")
@ApiModel(value="Income对象", description="收入说明")
public class Income implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "收入id")
    @TableId(value = "incid", type = IdType.AUTO)
    private Integer incid;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "收入日期")
    private Date incdate;

    @ApiModelProperty(value = "收入分类")
    private String inctype;

    @ApiModelProperty(value = "收入金额")
    private BigDecimal incmoney;

    @ApiModelProperty(value = "大写金额")
    private String bigwrite;

    @ApiModelProperty(value = "收款方式:1-现金,2-银行转账")
    private String incby;

    @ApiModelProperty(value = "登记人")
    private String incuser;

    @ApiModelProperty(value = "关联人员")
    private String aboutperson;

    @ApiModelProperty(value = "关联部门")
    private String aboutdept;

    @ApiModelProperty(value = "对方单位")
    private String hisdept;

    @ApiModelProperty(value = "关联合同")
    private String contid;

    @ApiModelProperty(value = "收入说明")
    private String inctext;

    public Integer getIncid() {
        return incid;
    }

    public void setIncid(Integer incid) {
        this.incid = incid;
    }
    public Date getIncdate() {
        return incdate;
    }

    public void setIncdate(Date incdate) {
        this.incdate = incdate;
    }
    public String getInctype() {
        return inctype;
    }

    public void setInctype(String inctype) {
        this.inctype = inctype;
    }
    public BigDecimal getIncmoney() {
        return incmoney;
    }

    public void setIncmoney(BigDecimal incmoney) {
        this.incmoney = incmoney;
    }
    public String getBigwrite() {
        return bigwrite;
    }

    public void setBigwrite(String bigwrite) {
        this.bigwrite = bigwrite;
    }
    public String getIncby() {
        return incby;
    }

    public void setIncby(String incby) {
        this.incby = incby;
    }
    public String getIncuser() {
        return incuser;
    }

    public void setIncuser(String incuser) {
        this.incuser = incuser;
    }
    public String getAboutperson() {
        return aboutperson;
    }

    public void setAboutperson(String aboutperson) {
        this.aboutperson = aboutperson;
    }
    public String getAboutdept() {
        return aboutdept;
    }

    public void setAboutdept(String aboutdept) {
        this.aboutdept = aboutdept;
    }
    public String getHisdept() {
        return hisdept;
    }

    public void setHisdept(String hisdept) {
        this.hisdept = hisdept;
    }
    public String getContid() {
        return contid;
    }

    public void setContid(String contid) {
        this.contid = contid;
    }
    public String getInctext() {
        return inctext;
    }

    public void setInctext(String inctext) {
        this.inctext = inctext;
    }

    @Override
    public String toString() {
        return "Income{" +
            "incid=" + incid +
            ", incdate=" + incdate +
            ", inctype=" + inctype +
            ", incmoney=" + incmoney +
            ", bigwrite=" + bigwrite +
            ", incby=" + incby +
            ", incuser=" + incuser +
            ", aboutperson=" + aboutperson +
            ", aboutdept=" + aboutdept +
            ", hisdept=" + hisdept +
            ", contid=" + contid +
            ", inctext=" + inctext +
        "}";
    }
}
