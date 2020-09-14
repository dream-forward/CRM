package com.hy.crm.system.mydesktop;

/**
 * @Author : Administrator
 * @Date : 2020/9/12 7:59
 * @Description :我的桌面查询片段
 */
public class SelectProvider {
    public String queryBusMoneyByStatus(String status) {
        //根据条件查询商机的预计金额
        StringBuilder builder = new StringBuilder("select ifnull(sum(bus.maymoney),0.00) as money from business bus where 1 = 1 ");
        if ("已成交".equals(status)) {
            builder.append(" and bus.busiphase = '成交' ");
        }
        if ("已丢单".equals(status)) {
            builder.append(" and bus.busiphase = '丢单' ");
        }
        if ("已搁置".equals(status)) {
            builder.append(" and bus.busiphase = '搁置' ");
        }
        if ("进行中".equals(status)) {
            builder.append(" and bus.busiphase in ('初期沟通','方案和报价','竞争或投标','商务谈判') ");
        }
        return builder.toString();

    }
}

