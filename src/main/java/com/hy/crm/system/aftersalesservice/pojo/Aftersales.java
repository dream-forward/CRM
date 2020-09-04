package com.hy.crm.system.aftersalesservice.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 售后服务表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@TableName("aftersales")
public class Aftersales implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "售后服务id")
    @TableId(value = "asid", type = IdType.AUTO)
    private Integer asid;

    @ApiModelProperty(value = "售后服务主题")
    private String assubject;

    @ApiModelProperty(value = "步骤")
    private String asstep;

    @ApiModelProperty(value = "责任人")
    private String asperson;

    @ApiModelProperty(value = "参与人")
    private String participation;

    @ApiModelProperty(value = "客户名称")
    private Integer clientname;

    @ApiModelProperty(value = "合同编号")
    private String contractnum;

    @ApiModelProperty(value = "合同主要信息")
    private String contractinfo;

    @ApiModelProperty(value = "对方联系人")
    private String hispeople;

    @ApiModelProperty(value = "固定电话")
    private String fixedphone;

    @ApiModelProperty(value = "移动电话")
    private String mobilephone;

    @ApiModelProperty(value = "邮件/QQ")
    private String emailqq;

    @ApiModelProperty(value = "服务类型")
    private String servicetype;

    @ApiModelProperty(value = "服务方式")
    private String servicefs;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "服务开启时间")
    private Date beginservicedate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "服务停止时间")
    private Date endservicedate;

    @ApiModelProperty(value = "服务内容")
    private String servicecontent;

    @ApiModelProperty(value = "客户反馈")
    private String clifeedback;

    @ApiModelProperty(value = "服务人员")
    private String serviceperson;

    @ApiModelProperty(value = "服务评分")
    private Integer servicecore;

    @ApiModelProperty(value = "相关附件")
    private String asfile;

    @ApiModelProperty(value = "售后状态")
    private String aftersalesstatus;

    public String getServicefs() {
        return servicefs;
    }

    public void setServicefs(String servicefs) {
        this.servicefs = servicefs;
    }

    public String getAftersalesstatus() {
        return aftersalesstatus;
    }

    public void setAftersalesstatus(String aftersalesstatus) {
        this.aftersalesstatus = aftersalesstatus;
    }

    public Integer getAsid() {
        return asid;
    }

    public void setAsid(Integer asid) {
        this.asid = asid;
    }
    public String getAssubject() {
        return assubject;
    }

    public void setAssubject(String assubject) {
        this.assubject = assubject;
    }
    public String getAsstep() {
        return asstep;
    }

    public void setAsstep(String asstep) {
        this.asstep = asstep;
    }
    public String getAsperson() {
        return asperson;
    }

    public void setAsperson(String asperson) {
        this.asperson = asperson;
    }
    public String getParticipation() {
        return participation;
    }

    public void setParticipation(String participation) {
        this.participation = participation;
    }
    public Integer getClientname() {
        return clientname;
    }

    public void setClientname(Integer clientname) {
        this.clientname = clientname;
    }
    public String getContractnum() {
        return contractnum;
    }

    public void setContractnum(String contractnum) {
        this.contractnum = contractnum;
    }
    public String getContractinfo() {
        return contractinfo;
    }

    public void setContractinfo(String contractinfo) {
        this.contractinfo = contractinfo;
    }
    public String getHispeople() {
        return hispeople;
    }

    public void setHispeople(String hispeople) {
        this.hispeople = hispeople;
    }
    public String getFixedphone() {
        return fixedphone;
    }

    public void setFixedphone(String fixedphone) {
        this.fixedphone = fixedphone;
    }
    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }
    public String getEmailqq() {
        return emailqq;
    }

    public void setEmailqq(String emailqq) {
        this.emailqq = emailqq;
    }
    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }
    public Date getBeginservicedate() {
        return beginservicedate;
    }

    public void setBeginservicedate(Date beginservicedate) {
        this.beginservicedate = beginservicedate;
    }
    public Date getEndservicedate() {
        return endservicedate;
    }

    public void setEndservicedate(Date endservicedate) {
        this.endservicedate = endservicedate;
    }
    public String getServicecontent() {
        return servicecontent;
    }

    public void setServicecontent(String servicecontent) {
        this.servicecontent = servicecontent;
    }
    public String getClifeedback() {
        return clifeedback;
    }

    public void setClifeedback(String clifeedback) {
        this.clifeedback = clifeedback;
    }
    public String getServiceperson() {
        return serviceperson;
    }

    public void setServiceperson(String serviceperson) {
        this.serviceperson = serviceperson;
    }
    public Integer getServicecore() {
        return servicecore;
    }

    public void setServicecore(Integer servicecore) {
        this.servicecore = servicecore;
    }
    public String getAsfile() {
        return asfile;
    }

    public void setAsfile(String asfile) {
        this.asfile = asfile;
    }

    @Override
    public String toString() {
        return "Aftersales{" +
            "asid=" + asid +
            ", assubject=" + assubject +
            ", asstep=" + asstep +
            ", asperson=" + asperson +
            ", participation=" + participation +
            ", clientname=" + clientname +
            ", contractnum=" + contractnum +
            ", contractinfo=" + contractinfo +
            ", hispeople=" + hispeople +
            ", fixedphone=" + fixedphone +
            ", mobilephone=" + mobilephone +
            ", emailqq=" + emailqq +
            ", servicetype=" + servicetype +
            ", beginservicedate=" + beginservicedate +
            ", endservicedate=" + endservicedate +
            ", servicecontent=" + servicecontent +
            ", clifeedback=" + clifeedback +
            ", serviceperson=" + serviceperson +
            ", servicecore=" + servicecore +
            ", asfile=" + asfile +
        "}";
    }
}
