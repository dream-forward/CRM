package com.hy.crm.system.mydesktop.bo;

import io.swagger.models.auth.In;

/**
 * @Author : Administrator
 * @Date : 2020/9/12 8:28
 * @Description :
 */
public class MyDesktop {
    //客户、商机、合同总数
    private Integer count;

    //商机预计金额
    private String money;

    public MyDesktop() {
    }

    public MyDesktop(Integer count, String money) {
        this.count = count;
        this.money = money;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
