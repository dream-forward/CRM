package com.hy.crm.system.statisticalanalysis.bo;

/**
 * @Author : Administrator
 * @Date : 2020/9/9 11:32
 * @Description :按行业分布统计
 */
public class ByIndustryStatistics {
    //行业
    private String cliindustry;
    //商机数
    private String bcount;
    //金额
    private String bmoney;

    public ByIndustryStatistics() {
    }

    public ByIndustryStatistics(String cliindustry, String bcount, String bmoney) {
        this.cliindustry = cliindustry;
        this.bcount = bcount;
        this.bmoney = bmoney;
    }

    public String getCliindustry() {
        return cliindustry;
    }

    public void setCliindustry(String cliindustry) {
        this.cliindustry = cliindustry;
    }

    public String getBcount() {
        return bcount;
    }

    public void setBcount(String bcount) {
        this.bcount = bcount;
    }

    public String getBmoney() {
        return bmoney;
    }

    public void setBmoney(String bmoney) {
        this.bmoney = bmoney;
    }
}
