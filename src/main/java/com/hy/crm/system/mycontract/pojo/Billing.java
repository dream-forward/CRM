package com.hy.crm.system.mycontract.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 开票申请表
 * </p>
 *
 * @author TH
 * @since 2020-09-08
 */
@ApiModel(value="Billing对象", description="开票申请表")
public class Billing implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "开票表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "优先级:1-高,2-中,3-低")
    private String priority;

    @ApiModelProperty(value = "主题")
    private String billsubject;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "结束时间")
    private Date billend;

    @ApiModelProperty(value = "步骤")
    private String billstep;

    @ApiModelProperty(value = "责任人")
    private String billperson;

    @ApiModelProperty(value = "参与人")
    private String billjoinperson;

    @ApiModelProperty(value = "开票详细地址")
    private String billaddress;

    @ApiModelProperty(value = "申请人姓名")
    private String billpeople;

    @ApiModelProperty(value = "所属部门")
    private String billdept;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "申请日期")
    private Date billdate;

    @ApiModelProperty(value = "主要技术条款")
    private String billtiaokuan;

    @ApiModelProperty(value = "对方单位全称")
    private String hisclientname;

    @ApiModelProperty(value = "关联合同编号")
    private String billcon;

    @ApiModelProperty(value = "开票种类")
    private String billtype;

    @ApiModelProperty(value = "纳税人识别号")
    private String billcildept;

    @ApiModelProperty(value = "开户行账号")
    private String bankaccount;

    @ApiModelProperty(value = "开户地址")
    private String bankaddress;

    @ApiModelProperty(value = "开户金额")
    private BigDecimal billmoney;

    @ApiModelProperty(value = "大写")
    private String billdaxie;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "开票日期")
    private Date billtime;

    @ApiModelProperty(value = "发票号码")
    private String billnum;

    @ApiModelProperty(value = "相关附件")
    private String billfile;

    @ApiModelProperty(value = "用户ID")
    private Integer buserid;

    @ApiModelProperty(value = "合同id")
    private Integer kconid;

    public Integer getKconid() {
        return kconid;
    }

    public void setKconid(Integer kconid) {
        this.kconid = kconid;
    }

    public Date getBillend() {
        return billend;
    }

    public void setBillend(Date billend) {
        this.billend = billend;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public Date getBilltime() {
        return billtime;
    }

    public void setBilltime(Date billtime) {
        this.billtime = billtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
    public String getBillsubject() {
        return billsubject;
    }

    public void setBillsubject(String billsubject) {
        this.billsubject = billsubject;
    }

    public String getBillstep() {
        return billstep;
    }

    public void setBillstep(String billstep) {
        this.billstep = billstep;
    }
    public String getBillperson() {
        return billperson;
    }

    public void setBillperson(String billperson) {
        this.billperson = billperson;
    }
    public String getBilljoinperson() {
        return billjoinperson;
    }

    public void setBilljoinperson(String billjoinperson) {
        this.billjoinperson = billjoinperson;
    }
    public String getBilladdress() {
        return billaddress;
    }

    public void setBilladdress(String billaddress) {
        this.billaddress = billaddress;
    }
    public String getBillpeople() {
        return billpeople;
    }

    public void setBillpeople(String billpeople) {
        this.billpeople = billpeople;
    }
    public String getBilldept() {
        return billdept;
    }

    public void setBilldept(String billdept) {
        this.billdept = billdept;
    }

    public String getBilltiaokuan() {
        return billtiaokuan;
    }

    public void setBilltiaokuan(String billtiaokuan) {
        this.billtiaokuan = billtiaokuan;
    }
    public String getHisclientname() {
        return hisclientname;
    }

    public void setHisclientname(String hisclientname) {
        this.hisclientname = hisclientname;
    }
    public String getBillcon() {
        return billcon;
    }

    public void setBillcon(String billcon) {
        this.billcon = billcon;
    }
    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }
    public String getBillcildept() {
        return billcildept;
    }

    public void setBillcildept(String billcildept) {
        this.billcildept = billcildept;
    }
    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }
    public String getBankaddress() {
        return bankaddress;
    }

    public void setBankaddress(String bankaddress) {
        this.bankaddress = bankaddress;
    }
    public BigDecimal getBillmoney() {
        return billmoney;
    }

    public void setBillmoney(BigDecimal billmoney) {
        this.billmoney = billmoney;
    }
    public String getBilldaxie() {
        return billdaxie;
    }

    public void setBilldaxie(String billdaxie) {
        this.billdaxie = billdaxie;
    }

    public String getBillnum() {
        return billnum;
    }

    public void setBillnum(String billnum) {
        this.billnum = billnum;
    }
    public String getBillfile() {
        return billfile;
    }

    public void setBillfile(String billfile) {
        this.billfile = billfile;
    }
    public Integer getBuserid() {
        return buserid;
    }

    public void setBuserid(Integer buserid) {
        this.buserid = buserid;
    }

    @Override
    public String toString() {
        return "Billing{" +
            "id=" + id +
            ", priority=" + priority +
            ", billsubject=" + billsubject +
            ", billend=" + billend +
            ", billstep=" + billstep +
            ", billperson=" + billperson +
            ", billjoinperson=" + billjoinperson +
            ", billaddress=" + billaddress +
            ", billpeople=" + billpeople +
            ", billdept=" + billdept +
            ", billdate=" + billdate +
            ", billtiaokuan=" + billtiaokuan +
            ", hisclientname=" + hisclientname +
            ", billcon=" + billcon +
            ", billtype=" + billtype +
            ", billcildept=" + billcildept +
            ", bankaccount=" + bankaccount +
            ", bankaddress=" + bankaddress +
            ", billmoney=" + billmoney +
            ", billdaxie=" + billdaxie +
            ", billtime=" + billtime +
            ", billnum=" + billnum +
            ", billfile=" + billfile +
            ", buserid=" + buserid +
        "}";
    }
}
