package com.hy.crm.system.statisticalanalysis;

/**
 * @Author : Administrator
 * @Date : 2020/9/10 11:56
 * @Description :漏斗统计查询辅助类
 */
public class SelectProvider {
    public String queryBusinessSales(String stage, String time) {
        StringBuilder builder = new StringBuilder(" select count(*) as num,sum(bus.maymoney) as money from business bus,record re where re.bid=bus.busid ");
        if ("初期沟通".equals(stage)) {
            builder.append(" and re.status =  '初期沟通' ");
        }
        if ("方案和报价".equals(stage)) {
            builder.append(" and re.status = '方案和报价' ");
        }
        if ("竞争或投标".equals(stage)) {
            builder.append(" and re.status = '竞争或投标' ");
        }
        if ("商务谈判".equals(stage)) {
            builder.append(" and re.status = '商务谈判' ");
        }
        if ("成交".equals(stage)) {
            builder.append(" and re.status = '成交' ");
        }
        if ("本年度".equals(time)) {
            builder.append(" and YEAR(bus.addtime)=YEAR(NOW()) ");
        }
        if ("上年度".equals(time)) {
            builder.append(" and YEAR(bus.addtime) = YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR)) ");
        }
        if ("本季度".equals(time)) {
            builder.append(" and YEAR(bus.addtime)=YEAR(now()) AND QUARTER(bus.addtime) = QUARTER(NOW()) ");
        }
        if ("上季度".equals(time)) {
            builder.append(" and YEAR(bus.addtime)=YEAR(now()) AND  QUARTER(bus.addtime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) ");
        }
        return builder.toString();
    }
}
