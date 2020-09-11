package com.hy.crm.system.statisticalanalysis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.system.mybusiness.mapper.BusinessMapper;
import com.hy.crm.system.mycontract.mapper.ContractMapper;
import com.hy.crm.system.mydocumentary.mapper.DocumentaryMapper;
import com.hy.crm.system.statisticalanalysis.bo.ByBusinessSource;
import com.hy.crm.system.statisticalanalysis.bo.ByIndustryStatistics;
import com.hy.crm.system.statisticalanalysis.bo.SalesFunnel;
import com.hy.crm.system.statisticalanalysis.bo.StatisticsByTime;
import com.hy.crm.system.statisticalanalysis.service.IMyStatisticsService;
import com.hy.crm.user.mapper.UserMapper;
import com.hy.crm.user.pojo.User;
import com.hy.crm.utils.LayuiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Administrator
 * @Date : 2020/9/8 10:16
 * @Description :我的统计服务类
 */
@Service
public class MyStatisticsServiceImpl implements IMyStatisticsService {
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private DocumentaryMapper documentaryMapper;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private UserMapper userMapper;

    //查询统计数量（商机数-成交数-跟单数-合同数）
    @Override
    public List<List> queryStatisticsNum(String flag) {
        System.out.println("--" + flag);
        QueryWrapper wrapper1 = new QueryWrapper<>();
        QueryWrapper wrapper2 = new QueryWrapper<>();
        QueryWrapper wrapper3 = new QueryWrapper<>();
        QueryWrapper wrapper4 = new QueryWrapper<>();
        QueryWrapper wrapper5 = new QueryWrapper<>();
        QueryWrapper wrapper6 = new QueryWrapper<>();
        QueryWrapper wrapper7 = new QueryWrapper<>();
        QueryWrapper wrapper8 = new QueryWrapper<>();
        List<List> list = new ArrayList<>();
        if ("商机数".equals(flag)) {
            //本周
            wrapper1.apply(" YEARWEEK(date_format(addtime,'%Y-%m-%d'),1) = YEARWEEK(now(),1) ");
            //上周
            wrapper2.apply(" YEARWEEK(date_format(addtime,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 ");
            //本月
            wrapper3.apply(" date_format(addtime,'%Y-%m')=date_format(now(),'%Y-%m') ");
            //上月
            wrapper4.apply(" date_format(addtime,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m') ");
            //本季度
            wrapper5.apply(" YEAR(addtime)=YEAR(now()) AND QUARTER(addtime) = QUARTER(NOW()) ");
            //上季度
            wrapper6.apply(" YEAR(addtime)=YEAR(now()) AND  QUARTER(addtime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) ");
            //本年度
            wrapper7.apply(" YEAR(addtime)=YEAR(NOW()) ");
            //上年度
            wrapper8.apply(" YEAR(addtime) = YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR)) ");

            list.add(businessMapper.selectList(wrapper1));
            list.add(businessMapper.selectList(wrapper2));
            list.add(businessMapper.selectList(wrapper3));
            list.add(businessMapper.selectList(wrapper4));
            list.add(businessMapper.selectList(wrapper5));
            list.add(businessMapper.selectList(wrapper6));
            list.add(businessMapper.selectList(wrapper7));
            list.add(businessMapper.selectList(wrapper8));
        } else if ("成交数".equals(flag)) {
            //本周
            wrapper1.apply(" YEARWEEK(date_format(addtime,'%Y-%m-%d'),1) = YEARWEEK(now(),1) " + " and busiphase = '成交' ");
            //上周
            wrapper2.apply(" YEARWEEK(date_format(addtime,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 " + " and busiphase = '成交' ");
            //本月
            wrapper3.apply(" date_format(addtime,'%Y-%m')=date_format(now(),'%Y-%m') " + " and busiphase = '成交' ");
            //上月
            wrapper4.apply(" date_format(addtime,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m') " + " and busiphase = '成交' ");
            //本季度
            wrapper5.apply(" YEAR(addtime)=YEAR(now()) AND QUARTER(addtime) = QUARTER(NOW()) " + " and busiphase = '成交' ");
            //上季度
            wrapper6.apply(" YEAR(addtime)=YEAR(now()) AND  QUARTER(addtime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) " + " and busiphase = '成交' ");
            //本年度
            wrapper7.apply(" YEAR(addtime)=YEAR(NOW()) " + " and busiphase = '成交' ");
            //上年度
            wrapper8.apply(" YEAR(addtime) = YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR)) " + " and busiphase = '成交' ");

            list.add(businessMapper.selectList(wrapper1));
            list.add(businessMapper.selectList(wrapper2));
            list.add(businessMapper.selectList(wrapper3));
            list.add(businessMapper.selectList(wrapper4));
            list.add(businessMapper.selectList(wrapper5));
            list.add(businessMapper.selectList(wrapper6));
            list.add(businessMapper.selectList(wrapper7));
            list.add(businessMapper.selectList(wrapper8));
        } else if ("跟单数".equals(flag)) {
            //本周
            wrapper1.apply(" YEARWEEK(date_format(doctime,'%Y-%m-%d'),1) = YEARWEEK(now(),1) ");
            //上周
            wrapper2.apply(" YEARWEEK(date_format(doctime,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 ");
            //本月
            wrapper3.apply(" date_format(doctime,'%Y-%m')=date_format(now(),'%Y-%m') ");
            //上月
            wrapper4.apply(" date_format(doctime,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m') ");
            //本季度
            wrapper5.apply(" YEAR(doctime)=YEAR(now()) AND QUARTER(doctime) = QUARTER(NOW()) ");
            //上季度
            wrapper6.apply(" YEAR(doctime)=YEAR(now()) AND  QUARTER(doctime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) ");
            //本年度
            wrapper7.apply(" YEAR(doctime)=YEAR(NOW()) ");
            //上年度
            wrapper8.apply(" YEAR(doctime) = YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR)) ");

            list.add(documentaryMapper.selectList(wrapper1));
            list.add(documentaryMapper.selectList(wrapper2));
            list.add(documentaryMapper.selectList(wrapper3));
            list.add(documentaryMapper.selectList(wrapper4));
            list.add(documentaryMapper.selectList(wrapper5));
            list.add(documentaryMapper.selectList(wrapper6));
            list.add(documentaryMapper.selectList(wrapper7));
            list.add(documentaryMapper.selectList(wrapper8));
        } else if ("合同数".equals(flag)) {
            //本周
            wrapper1.apply(" YEARWEEK(date_format(condate,'%Y-%m-%d'),1) = YEARWEEK(now(),1) ");
            //上周
            wrapper2.apply(" YEARWEEK(date_format(condate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 ");
            //本月
            wrapper3.apply(" date_format(condate,'%Y-%m')=date_format(now(),'%Y-%m') ");
            //上月
            wrapper4.apply(" date_format(condate,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m') ");
            //本季度
            wrapper5.apply(" YEAR(condate)=YEAR(now()) AND QUARTER(condate) = QUARTER(NOW()) ");
            //上季度
            wrapper6.apply(" YEAR(condate)=YEAR(now()) AND  QUARTER(condate)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) ");
            //本年度
            wrapper7.apply(" YEAR(condate)=YEAR(NOW()) ");
            //上年度
            wrapper8.apply(" YEAR(condate) = YEAR(DATE_SUB(NOW(),INTERVAL 1 YEAR)) ");

            list.add(contractMapper.selectList(wrapper1));
            list.add(contractMapper.selectList(wrapper2));
            list.add(contractMapper.selectList(wrapper3));
            list.add(contractMapper.selectList(wrapper4));
            list.add(contractMapper.selectList(wrapper5));
            list.add(contractMapper.selectList(wrapper6));
            list.add(contractMapper.selectList(wrapper7));
            list.add(contractMapper.selectList(wrapper8));
        }

        return list;
    }

    //分别根据用户查询（本周统计）
    @Override
    public List<StatisticsByTime> queryBnumByWeek() {
        new Page<>();
        //查询所有用户信息
        List<User> users = userMapper.selectList(null);
        List<StatisticsByTime> weekList = new ArrayList<>();
        for (User user : users) {
            StatisticsByTime sbt = new StatisticsByTime();
            //循环获取用户id
            sbt.setUserName(user.getUsername());
            //查询商机数（本周）
            sbt.setBusinessThisWeek(businessMapper.queryThisWeek(user.getUsername()));
            //查询商机数（上周）
            sbt.setBusinessLastWeek(businessMapper.queryLastWeek(user.getUsername()));
            //查询成交数（本周）
            sbt.setAccomplishThisWeek(businessMapper.queryThisWeekAndStatus(user.getUsername()));
            //查询成交数（上周）
            sbt.setAccomplishLastWeek(businessMapper.queryLastWeekAndStatus(user.getUsername()));
            //查询跟单数（本周）
            sbt.setDocumentaryThisWeek(documentaryMapper.thisWeek(user.getUsername()));
            //查询跟单数（上周）
            sbt.setDocumentaryLastWeek(documentaryMapper.LastWeek(user.getUsername()));
            //查询合同数（本周）
            sbt.setContractThisWeek(contractMapper.thisWeek(user.getUserid()));
            //查询合同数（上周）
            sbt.setContractLastWeek(contractMapper.LastWeek(user.getUserid()));
            weekList.add(sbt);
        }
        return weekList;
    }

    //分别根据用户查询（本月统计）
    @Override
    public List<StatisticsByTime> queryBnumByMonth() {
        //查询所有用户信息
        List<User> users = userMapper.selectList(null);
        List<StatisticsByTime> weekList = new ArrayList<>();
        for (User user : users) {
            StatisticsByTime sbt = new StatisticsByTime();
            //循环获取用户id
            sbt.setUserName(user.getUsername());
            //查询商机数（本月）
            sbt.setBusinessThisWeek(businessMapper.queryThisMonth(user.getUsername()));
            //查询商机数（上月）
            sbt.setBusinessLastWeek(businessMapper.queryLastMonth(user.getUsername()));
            //查询成交数（本月）
            sbt.setAccomplishThisWeek(businessMapper.queryThisMonthAndStatus(user.getUsername()));
            //查询成交数（上月）
            sbt.setAccomplishLastWeek(businessMapper.queryLastMonthAndStatus(user.getUsername()));
            //查询跟单数（本月）
            sbt.setDocumentaryThisWeek(documentaryMapper.thisMonth(user.getUsername()));
            //查询跟单数（上月）
            sbt.setDocumentaryLastWeek(documentaryMapper.lastMonth(user.getUsername()));
            //查询合同数（本月）
            sbt.setContractThisWeek(contractMapper.thisMonth(user.getUserid()));
            //查询合同数（上月）
            sbt.setContractLastWeek(contractMapper.LastMonth(user.getUserid()));
            weekList.add(sbt);
        }
        return weekList;
    }

    //分别根据用户查询（本季度统计）
    @Override
    public List<StatisticsByTime> queryBnumByQuarter() {
        //查询所有用户信息
        List<User> users = userMapper.selectList(null);
        List<StatisticsByTime> weekList = new ArrayList<>();
        for (User user : users) {
            StatisticsByTime sbt = new StatisticsByTime();
            //循环获取用户id
            sbt.setUserName(user.getUsername());
            //查询商机数（本月）
            sbt.setBusinessThisWeek(businessMapper.queryThisQuarter(user.getUsername()));
            //查询商机数（上月）
            sbt.setBusinessLastWeek(businessMapper.queryLastQuarter(user.getUsername()));
            //查询成交数（本月）
            sbt.setAccomplishThisWeek(businessMapper.queryThisQuarterAndStatus(user.getUsername()));
            //查询成交数（上月）
            sbt.setAccomplishLastWeek(businessMapper.queryLastQuarterAndStatus(user.getUsername()));
            //查询跟单数（本月）
            sbt.setDocumentaryThisWeek(documentaryMapper.thisQuarter(user.getUsername()));
            //查询跟单数（上月）
            sbt.setDocumentaryLastWeek(documentaryMapper.LastQuarter(user.getUsername()));
            //查询合同数（本月）
            sbt.setContractThisWeek(contractMapper.thisQuarter(user.getUserid()));
            //查询合同数（上月）
            sbt.setContractLastWeek(contractMapper.LastQuarter(user.getUserid()));
            weekList.add(sbt);
        }
        return weekList;
    }

    //分别根据用户查询（本年度统计）
    @Override
    public List<StatisticsByTime> queryBnumByYear() {
        //查询所有用户信息
        List<User> users = userMapper.selectList(null);
        List<StatisticsByTime> weekList = new ArrayList<>();
        for (User user : users) {
            StatisticsByTime sbt = new StatisticsByTime();
            //循环获取用户id
            sbt.setUserName(user.getUsername());
            //查询商机数（本月）
            sbt.setBusinessThisWeek(businessMapper.queryThisYear(user.getUsername()));
            //查询商机数（上月）
            sbt.setBusinessLastWeek(businessMapper.queryLastYear(user.getUsername()));
            //查询成交数（本月）
            sbt.setAccomplishThisWeek(businessMapper.queryThisYearAndStatus(user.getUsername()));
            //查询成交数（上月）
            sbt.setAccomplishLastWeek(businessMapper.queryLastYearAndStatus(user.getUsername()));
            //查询跟单数（本月）
            sbt.setDocumentaryThisWeek(documentaryMapper.thisYear(user.getUsername()));
            //查询跟单数（上月）
            sbt.setDocumentaryLastWeek(documentaryMapper.LastYear(user.getUsername()));
            //查询合同数（本月）
            sbt.setContractThisWeek(contractMapper.thisYear(user.getUserid()));
            //查询合同数（上月）
            sbt.setContractLastWeek(contractMapper.LastYear(user.getUserid()));
            weekList.add(sbt);
        }
        return weekList;
    }

    //商机销售漏斗
    @Override
    public LayuiUtils queryBusinessFunnel(String time) {

        //数字格式化成百分比
        NumberFormat format = NumberFormat.getPercentInstance();
        //设置保留几位小数
        format.setMaximumFractionDigits(2);

        SalesFunnel salesFunnel = businessMapper.queryBusinessSales("初期沟通", time);
        if (salesFunnel.getNum() == 0) {
            salesFunnel.setNumPercent(format.format(0.00));
            salesFunnel.setMoneyPercent(format.format(0.00));
        } else {
            salesFunnel.setNumPercent(format.format(1.00));
            salesFunnel.setMoneyPercent(format.format(1.00));
        }

        SalesFunnel salesFunnel1 = businessMapper.queryBusinessSales("方案和报价", time);
        //判断数量计算百分比
        if (salesFunnel1.getNum() != 0 && salesFunnel.getNum() != 0) {
            salesFunnel1.setNumPercent(format.format((float) (salesFunnel1.getNum() / salesFunnel.getNum())));
        } else {
            salesFunnel1.setNumPercent(format.format(0.00));
        }
        //判断金额计算百分比
        if (salesFunnel1.getMoney() != null && salesFunnel.getMoney() != null) {//如果有值就相除
            salesFunnel1.setMoneyPercent(format.format(salesFunnel1.getMoney().divide(salesFunnel.getMoney(), 2, BigDecimal.ROUND_HALF_EVEN)));
        } else {//否则为0
            salesFunnel1.setMoneyPercent(format.format(0.00));
        }

        SalesFunnel salesFunnel2 = businessMapper.queryBusinessSales("竞争或投标", time);
        //商机数
        if (salesFunnel2.getNum() != 0 && salesFunnel.getNum() != 0) {
            salesFunnel2.setNumPercent(format.format((float) (salesFunnel2.getNum() / salesFunnel.getNum())));
        } else {
            salesFunnel2.setNumPercent(format.format(0.00));
        }
        //金额数
        if (salesFunnel2.getMoney() != null && salesFunnel.getMoney() != null) {
            salesFunnel2.setMoneyPercent(format.format(salesFunnel2.getMoney().divide(salesFunnel.getMoney(), 2, BigDecimal.ROUND_HALF_EVEN)));
        } else {
            salesFunnel2.setMoneyPercent(format.format(0.00));
        }

        SalesFunnel salesFunnel3 = businessMapper.queryBusinessSales("商务谈判", time);
        //商机数
        if (salesFunnel3.getNum() != 0 && salesFunnel.getNum() != 0) {
            salesFunnel3.setNumPercent(format.format((float) (salesFunnel3.getNum() / salesFunnel.getNum())));
        } else {
            salesFunnel3.setNumPercent(format.format(0.00));
        }
        //金额数
        if (salesFunnel3.getMoney() != null && salesFunnel.getMoney() != null) {
            salesFunnel3.setMoneyPercent(format.format(salesFunnel3.getMoney().divide(salesFunnel.getMoney(), 2, BigDecimal.ROUND_HALF_EVEN)));
        } else {
            salesFunnel3.setMoneyPercent(format.format(0.00));
        }

        SalesFunnel salesFunnel4 = businessMapper.queryBusinessSales("成交", time);
        //商机数
        if (salesFunnel4.getNum() != 0 && salesFunnel.getNum() != 0) {
            salesFunnel4.setNumPercent(format.format((float) (salesFunnel4.getNum() / salesFunnel.getNum())));
        } else {
            salesFunnel4.setNumPercent(format.format(0.00));
        }
        //金额数
        if (salesFunnel4.getMoney() != null && salesFunnel.getMoney() != null) {
            salesFunnel4.setMoneyPercent(format.format(salesFunnel4.getMoney().divide(salesFunnel.getMoney(), 2, BigDecimal.ROUND_HALF_EVEN)));
        } else {
            salesFunnel4.setMoneyPercent(format.format(0.00));
        }

        List<SalesFunnel> list = new ArrayList<>();
        list.add(salesFunnel);//初期沟通
        list.add(salesFunnel1);//方案和报价
        list.add(salesFunnel2);//竞争或投标
        list.add(salesFunnel3);//商务谈判
        list.add(salesFunnel4);//成交
        return new LayuiUtils(0, "漏斗查询成功", list.size(), list);

    }

    //按行业分布查询(按行业查询商机数以及总金额)
    @Override
    public List<ByIndustryStatistics> queryBcountBmoney() {
        String[] str = new String[]{
                "IT|互联网|通信|电子",
                "房产|建筑建设|物业",
                "管理咨询|教育科研|中介服务",
                "加工制造|仪表设备",
                "金融|银行|保险",
                "酒店旅游",
                "能源矿产|石油化工",
                "消费零售|贸易|交通物流",
                "医药生物|医疗保健",
                "政府|非赢利机构|科研",
                "其他"};
        List<ByIndustryStatistics> list = businessMapper.queryBcountBmoney();
        List list1 = new ArrayList<>();
        if (list.size() > 0) {
            for (ByIndustryStatistics b : list) {
                list1.add(b.getCliindustry());
            }
            if (!list1.contains(str[0])) {
                list.add(new ByIndustryStatistics(str[0], "0", "0.00"));
            }
            if (!list1.contains(str[1])) {
                list.add(new ByIndustryStatistics(str[1], "0", "0.00"));
            }
            if (!list1.contains(str[2])) {
                list.add(new ByIndustryStatistics(str[2], "0", "0.00"));
            }
            if (!list1.contains(str[3])) {
                list.add(new ByIndustryStatistics(str[3], "0", "0.00"));
            }
            if (!list1.contains(str[4])) {
                list.add(new ByIndustryStatistics(str[4], "0", "0.00"));
            }
            if (!list1.contains(str[5])) {
                list.add(new ByIndustryStatistics(str[5], "0", "0.00"));
            }
            if (!list1.contains(str[6])) {
                list.add(new ByIndustryStatistics(str[6], "0", "0.00"));
            }
            if (!list1.contains(str[7])) {
                list.add(new ByIndustryStatistics(str[7], "0", "0.00"));
            }
            if (!list1.contains(str[8])) {
                list.add(new ByIndustryStatistics(str[8], "0", "0.00"));
            }
            if (!list1.contains(str[9])) {
                list.add(new ByIndustryStatistics(str[9], "0", "0.00"));
            }
            if (!list1.contains(str[10])) {
                list.add(new ByIndustryStatistics(str[10], "0", "0.00"));
            }
        }
        return list;
    }

    //按来源分布查询(按来源查询商机数以及总金额)
    @Override
    public List<ByBusinessSource> queryBcountBmoneyByFrom() {
        String[] str = new String[]{
                "电话访问",
                "独立开发",
                "二次销售",
                "合作伙伴",
                "互联网",
                "客户介绍",
                "客户来电",
                "老客户",
                "媒体宣传"};
        List<ByBusinessSource> list = businessMapper.queryBcountBmoneyByFrom();
        List list1 = new ArrayList<>();
        if (list.size() > 0) {
            for (ByBusinessSource b : list) {
                list1.add(b.getBusfrom());
            }
            if (!list1.contains(str[0])) {
                list.add(new ByBusinessSource(str[0], "0", "0.00"));
            }
            if (!list1.contains(str[1])) {
                list.add(new ByBusinessSource(str[1], "0", "0.00"));
            }
            if (!list1.contains(str[2])) {
                list.add(new ByBusinessSource(str[2], "0", "0.00"));
            }
            if (!list1.contains(str[3])) {
                list.add(new ByBusinessSource(str[3], "0", "0.00"));
            }
            if (!list1.contains(str[4])) {
                list.add(new ByBusinessSource(str[4], "0", "0.00"));
            }
            if (!list1.contains(str[5])) {
                list.add(new ByBusinessSource(str[5], "0", "0.00"));
            }
            if (!list1.contains(str[6])) {
                list.add(new ByBusinessSource(str[6], "0", "0.00"));
            }
            if (!list1.contains(str[7])) {
                list.add(new ByBusinessSource(str[7], "0", "0.00"));
            }
            if (!list1.contains(str[8])) {
                list.add(new ByBusinessSource(str[8], "0", "0.00"));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMaximumFractionDigits(2);//设置保留几位小数
        System.out.println("百分比为：" + format.format(1.00));
    }

}
