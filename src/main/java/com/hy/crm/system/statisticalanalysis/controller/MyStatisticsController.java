package com.hy.crm.system.statisticalanalysis.controller;

import com.hy.crm.system.statisticalanalysis.bo.ByBusinessSource;
import com.hy.crm.system.statisticalanalysis.bo.ByIndustryStatistics;
import com.hy.crm.system.statisticalanalysis.bo.StatisticsByTime;
import com.hy.crm.system.statisticalanalysis.service.IMyStatisticsService;
import com.hy.crm.utils.LayuiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Administrator
 * @Date : 2020/9/8 10:14
 * @Description :我的统计
 */
@Controller
@RequestMapping("/myStatistics")
public class MyStatisticsController {
    @Autowired
    IMyStatisticsService myStatisticsServiceImpl;

    //查询我的统计数量（商机数-成交数-跟单数-合同数32条数据）
    @GetMapping("/queryStatisticsNum.do")
    @ResponseBody
    public Map<String, Integer> queryStatisticsNum(String flag) {
        System.out.println(flag);
        List<List> list = myStatisticsServiceImpl.queryStatisticsNum(flag);
        System.out.println("共计长度：" + list.size());
        Map<String, Integer> map = new HashMap<>();
        int num = 0;
        for (List l : list) {
            num++;
            map.put("t" + num, l.size());
        }
        return map;
    }

    //本周统计
    @GetMapping("/queryBnumByWeek.do")
    @ResponseBody
    public LayuiUtils queryBnumByWeek() {
        List<StatisticsByTime> list = myStatisticsServiceImpl.queryBnumByWeek();
        return new LayuiUtils(0, "查询本周成功", list.size(), list);
    }

    //本月统计
    @GetMapping("/queryBnumByMonth.do")
    @ResponseBody
    public LayuiUtils queryBnumByMonth() {
        List<StatisticsByTime> list = myStatisticsServiceImpl.queryBnumByMonth();
        return new LayuiUtils(0, "查询本月成功", list.size(), list);
    }

    //本季度统计
    @GetMapping("/queryBnumByQuarter.do")
    @ResponseBody
    public LayuiUtils queryBnumByQuarter() {
        List<StatisticsByTime> list = myStatisticsServiceImpl.queryBnumByQuarter();
        return new LayuiUtils(0, "查询本季度成功", list.size(), list);
    }

    //本年统计
    @GetMapping("/queryBnumByYear.do")
    @ResponseBody
    public LayuiUtils queryBnumByYear() {
        List<StatisticsByTime> list = myStatisticsServiceImpl.queryBnumByYear();
        return new LayuiUtils(0, "查询本年度成功", list.size(), list);
    }

    //商机销售漏斗-全部
    @GetMapping("/queryBusinessFunnelAll.do")
    @ResponseBody
    public LayuiUtils queryBusinessFunnelAll(String time) {
        return myStatisticsServiceImpl.queryBusinessFunnel(time);
    }

    //按行业分布统计
    @GetMapping("/queryBcountBmoney.do")
    @ResponseBody
    public LayuiUtils queryBcountBmoney() {
        List<ByIndustryStatistics> list = myStatisticsServiceImpl.queryBcountBmoney();
        System.out.println("---" + list.size());
        return new LayuiUtils(0, "查询成功", list.size(), list);
    }

    //按商机来源统计
    @GetMapping("/queryBcountBmoneyByFrom.do")
    @ResponseBody
    public LayuiUtils queryBcountBmoneyByFrom() {
        List<ByBusinessSource> list = myStatisticsServiceImpl.queryBcountBmoneyByFrom();
        return new LayuiUtils(0, "查询成功", list.size(), list);
    }
}
