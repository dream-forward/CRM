package com.hy.crm.system.statisticalanalysis.bo;

/**
 * @Author : Administrator
 * @Date : 2020/9/10 11:46
 * @Description :统计--商机销售漏斗
 */
public class BusinessSales {

    //商机数
    private String num;
    //商机金额
    private String money;

    public BusinessSales() {
    }

    public BusinessSales(String num, String money) {
        this.num = num;
        this.money = money;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
