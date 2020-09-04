package com.hy.crm.system.customermanager.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 客户信息表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@TableName("clientinfo")
public class Clientinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户id")
    @TableId(value = "cliid", type = IdType.AUTO)
    private Integer cliid;

    @ApiModelProperty(value = "客户名称")
    private String cliname;

    @ApiModelProperty(value = "客户拼音")
    private String clipingyin;

    @ApiModelProperty(value = "客户分类")
    private String clitype;

    @ApiModelProperty(value = "客户来源")
    private String clifrom;

    @ApiModelProperty(value = "所属行业")
    private String cliindustry;

    @ApiModelProperty(value = "客户网址")
    private String cliurl;

    @ApiModelProperty(value = "所属国家")
    private String clicountry;

    @ApiModelProperty(value = "所属城市")
    private String clicity;

    @ApiModelProperty(value = "客户详细地址")
    private String cliaddress;

    @ApiModelProperty(value = "邮政编码")
    private String clipostlcode;

    @ApiModelProperty(value = "联系人")
    private String person;

    @ApiModelProperty(value = "联系人部门")
    private String persondept;

    @ApiModelProperty(value = "联系人职务")
    private String personposition;

    @ApiModelProperty(value = "联系人办公电话")
    private String perofficenum;

    @ApiModelProperty(value = "联系人移动电话")
    private String pernum;

    @ApiModelProperty(value = "联系人QQ")
    private String perqq;

    @ApiModelProperty(value = "法人代表")
    private String perparent;

    @ApiModelProperty(value = "注册资本")
    private BigDecimal registeredcapital;

    @ApiModelProperty(value = "附加说明")
    private String append;

    @ApiModelProperty(value = "银行账号")
    private String bankaccount;

    @ApiModelProperty(value = "开户名称")
    private String bankname;

    @ApiModelProperty(value = "开户银行")
    private String bank;

    @ApiModelProperty(value = "银行地址")
    private String bankaddress;

    @ApiModelProperty(value = "税号")
    private String taxnum;

    @ApiModelProperty(value = "电话")
    private String bankphone;

    @ApiModelProperty(value = "用户")
    private Integer buserid;

    public Integer getCliid() {
        return cliid;
    }

    public void setCliid(Integer cliid) {
        this.cliid = cliid;
    }

    public String getCliname() {
        return cliname;
    }

    public void setCliname(String cliname) {
        this.cliname = cliname;
    }

    public String getClipingyin() {
        return clipingyin;
    }

    public void setClipingyin(String clipingyin) {
        this.clipingyin = clipingyin;
    }

    public String getClitype() {
        return clitype;
    }

    public void setClitype(String clitype) {
        this.clitype = clitype;
    }

    public String getClifrom() {
        return clifrom;
    }

    public void setClifrom(String clifrom) {
        this.clifrom = clifrom;
    }

    public String getCliindustry() {
        return cliindustry;
    }

    public void setCliindustry(String cliindustry) {
        this.cliindustry = cliindustry;
    }

    public String getCliurl() {
        return cliurl;
    }

    public void setCliurl(String cliurl) {
        this.cliurl = cliurl;
    }

    public String getClicountry() {
        return clicountry;
    }

    public void setClicountry(String clicountry) {
        this.clicountry = clicountry;
    }

    public String getClicity() {
        return clicity;
    }

    public void setClicity(String clicity) {
        this.clicity = clicity;
    }

    public String getCliaddress() {
        return cliaddress;
    }

    public void setCliaddress(String cliaddress) {
        this.cliaddress = cliaddress;
    }

    public String getClipostlcode() {
        return clipostlcode;
    }

    public void setClipostlcode(String clipostlcode) {
        this.clipostlcode = clipostlcode;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getPersondept() {
        return persondept;
    }

    public void setPersondept(String persondept) {
        this.persondept = persondept;
    }

    public String getPersonposition() {
        return personposition;
    }

    public void setPersonposition(String personposition) {
        this.personposition = personposition;
    }

    public String getPerofficenum() {
        return perofficenum;
    }

    public void setPerofficenum(String perofficenum) {
        this.perofficenum = perofficenum;
    }

    public String getPernum() {
        return pernum;
    }

    public void setPernum(String pernum) {
        this.pernum = pernum;
    }

    public String getPerqq() {
        return perqq;
    }

    public void setPerqq(String perqq) {
        this.perqq = perqq;
    }

    public String getPerparent() {
        return perparent;
    }

    public void setPerparent(String perparent) {
        this.perparent = perparent;
    }

    public BigDecimal getRegisteredcapital() {
        return registeredcapital;
    }

    public void setRegisteredcapital(BigDecimal registeredcapital) {
        this.registeredcapital = registeredcapital;
    }

    public String getAppend() {
        return append;
    }

    public void setAppend(String append) {
        this.append = append;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBankaddress() {
        return bankaddress;
    }

    public void setBankaddress(String bankaddress) {
        this.bankaddress = bankaddress;
    }

    public String getTaxnum() {
        return taxnum;
    }

    public void setTaxnum(String taxnum) {
        this.taxnum = taxnum;
    }

    public String getBankphone() {
        return bankphone;
    }

    public void setBankphone(String bankphone) {
        this.bankphone = bankphone;
    }

    public Integer getBuserid() {
        return buserid;
    }

    public void setBuserid(Integer buserid) {
        this.buserid = buserid;
    }

    @Override
    public String toString() {
        return "Clientinfo{" +
                "cliid=" + cliid +
                ", cliname='" + cliname + '\'' +
                ", clipingyin='" + clipingyin + '\'' +
                ", clitype='" + clitype + '\'' +
                ", clifrom='" + clifrom + '\'' +
                ", cliindustry='" + cliindustry + '\'' +
                ", cliurl='" + cliurl + '\'' +
                ", clicountry='" + clicountry + '\'' +
                ", clicity='" + clicity + '\'' +
                ", cliaddress='" + cliaddress + '\'' +
                ", clipostlcode='" + clipostlcode + '\'' +
                ", person='" + person + '\'' +
                ", persondept='" + persondept + '\'' +
                ", personposition='" + personposition + '\'' +
                ", perofficenum='" + perofficenum + '\'' +
                ", pernum='" + pernum + '\'' +
                ", perqq='" + perqq + '\'' +
                ", perparent='" + perparent + '\'' +
                ", registeredcapital=" + registeredcapital +
                ", append='" + append + '\'' +
                ", bankaccount='" + bankaccount + '\'' +
                ", bankname='" + bankname + '\'' +
                ", bank='" + bank + '\'' +
                ", bankaddress='" + bankaddress + '\'' +
                ", taxnum='" + taxnum + '\'' +
                ", bankphone='" + bankphone + '\'' +
                ", buserid=" + buserid +
                '}';
    }
}
