package com.hy.crm.system.customermanager.bo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 旗木卡卡西
 * @date 2020/9/2 20:37
 */

public class ClientBo implements Serializable {
    @ApiModelProperty(value = "客户id")
    private Integer cliid;
    //客户名称
    private String clientname;
    //当前客户商机数
    private Integer buscount;
    //当前客户的预计成交金额总和
    private BigDecimal summoney;
    //当前用户合同数
    private Integer concount;
    //当前用户合同总金额
    private BigDecimal sumcon;
    //当前客户回款总额
    private BigDecimal incmoneyall;
    //售后服务数
    private Integer afterCount;
    //售后服务均分
    private String avgservicecore;

    public Integer getCliid() {
        return cliid;
    }

    public void setCliid(Integer cliid) {
        this.cliid = cliid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public Integer getBuscount() {
        return buscount;
    }

    public void setBuscount(Integer buscount) {
        this.buscount = buscount;
    }

    public BigDecimal getSummoney() {
        return summoney;
    }

    public void setSummoney(BigDecimal summoney) {
        this.summoney = summoney;
    }

    public Integer getConcount() {
        return concount;
    }

    public void setConcount(Integer concount) {
        this.concount = concount;
    }

    public BigDecimal getSumcon() {
        return sumcon;
    }

    public void setSumcon(BigDecimal sumcon) {
        this.sumcon = sumcon;
    }

    public BigDecimal getIncmoneyall() {
        return incmoneyall;
    }

    public void setIncmoneyall(BigDecimal incmoneyall) {
        this.incmoneyall = incmoneyall;
    }

    public Integer getAfterCount() {
        return afterCount;
    }

    public void setAfterCount(Integer afterCount) {
        this.afterCount = afterCount;
    }

    public String getAvgservicecore() {
        return avgservicecore;
    }

    public void setAvgservicecore(String avgservicecore) {
        this.avgservicecore = avgservicecore;
    }

    @Override
    public String toString() {
        return "ClientBo{" +
                "cliid=" + cliid +
                ", clientname='" + clientname + '\'' +
                ", buscount=" + buscount +
                ", summoney=" + summoney +
                ", concount=" + concount +
                ", sumcon=" + sumcon +
                ", incmoneyall=" + incmoneyall +
                ", afterCount=" + afterCount +
                ", avgservicecore='" + avgservicecore + '\'' +
                '}';
    }
}
