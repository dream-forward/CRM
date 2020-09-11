package com.hy.crm.system.statisticalanalysis.service;

import com.hy.crm.system.statisticalanalysis.bo.ByBusinessSource;
import com.hy.crm.system.statisticalanalysis.bo.ByIndustryStatistics;
import com.hy.crm.system.statisticalanalysis.bo.StatisticsByTime;
import com.hy.crm.utils.LayuiUtils;

import java.util.List;

/**
 * @Author : Administrator
 * @Date : 2020/9/8 11:28
 * @Description :
 */
public interface IMyStatisticsService {

     /**
      * 我的统计
      * @param flag（分别传：商机数、成交数、跟单数、合同数）
      * @return
      */
     List<List> queryStatisticsNum(String flag);

     /**
      * 查询本周统计
      * @return List<StatisticsByTime>
      */
     List<StatisticsByTime> queryBnumByWeek();

     /**
      * 查询本月统计
      * @return List<StatisticsByTime>
      */
     List<StatisticsByTime> queryBnumByMonth();
     /**
      * 查询本季度统计
      * @return List<StatisticsByTime>
      */
     List<StatisticsByTime> queryBnumByQuarter();
     /**
      * 查询本年统计
      * @return List<StatisticsByTime>
      */
     List<StatisticsByTime> queryBnumByYear();

     /**
      * 商机销售漏斗
      * @param time 所传入时间标记
      * @return
      */
     LayuiUtils queryBusinessFunnel(String time);


     /**
      * 按行业分布统计
      * @return
      */
     List<ByIndustryStatistics> queryBcountBmoney();

     /**
      * 按商机来源统计
      * @return
      */
     List<ByBusinessSource> queryBcountBmoneyByFrom();
}
