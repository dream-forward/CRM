package com.hy.crm.system.statisticalanalysis.bo;

import java.math.BigDecimal;

/**
 * @Author : Administrator
 * @Date : 2020/9/10 21:01
 * @Description :商机销售漏斗
 */
public class SalesFunnel {
    //商机百分比
    private String numPercent;
    //金额百分比
    private String moneyPercent;

    //商机总金额
    private BigDecimal money;
    //商机总数量
    private Integer num;

    public String getNumPercent() {
        return numPercent;
    }

    public void setNumPercent(String numPercent) {
        this.numPercent = numPercent;
    }

    public String getMoneyPercent() {
        return moneyPercent;
    }

    public void setMoneyPercent(String moneyPercent) {
        this.moneyPercent = moneyPercent;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
