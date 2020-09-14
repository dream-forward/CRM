package com.hy.crm.system.mybusiness.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.system.mybusiness.pojo.Business;
import com.hy.crm.system.mydesktop.bo.MyDesktop;
import com.hy.crm.system.statisticalanalysis.bo.ByBusinessSource;
import com.hy.crm.system.statisticalanalysis.bo.ByIndustryStatistics;
import com.hy.crm.system.statisticalanalysis.bo.SalesFunnel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * 商机表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Mapper
public interface BusinessMapper extends BaseMapper<Business> {

    //我的桌面--根据条件查询商机的预计金额
    @SelectProvider(value = com.hy.crm.system.mydesktop.SelectProvider.class, method = "queryBusMoneyByStatus")
    MyDesktop queryBusMoneyByStatus(String status);

    //统计里面按行业分布查询--占用在此
    @Select("select cli.cliindustry , count(cli.cliindustry) as bcount,sum(bus.maymoney) as bmoney from clientinfo cli  right join business bus on bus.clientid=cli.cliid group by cli.cliindustry")
    List<ByIndustryStatistics> queryBcountBmoney();
    /*@Select("select h.hangyename,t.bcount,t.bmoney from hangye h left join (select cli.cliindustry , count(cli.cliindustry) as bcount,sum(bus.maymoney) as bmoney from clientinfo cli  right join business bus on bus.clientid=cli.cliid group by cli.cliindustry) t on h.hangyename = t.cliindustry")
    List<ByIndustryStatistics> queryBcountBmoney();*/

    //统计里面按来源分布查询--占用在此
    @Select("select bus.busfrom,count(bus.busfrom) as bcount ,sum(bus.maymoney) as bmoney  from business bus group by bus.busfrom ")
    List<ByBusinessSource> queryBcountBmoneyByFrom();

    //商机销售漏斗--占用于此
    @SelectProvider(value = com.hy.crm.system.statisticalanalysis.SelectProvider.class, method = "queryBusinessSales")
    SalesFunnel queryBusinessSales(String stage, String time);

    /**
     * 查询本周商机数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEARWEEK(date_format(addtime,'%Y-%m-%d'),1) = YEARWEEK(now(),1) and busprincipal=#{uname}")
    public Integer queryThisWeek(String uname);

    /**
     * 查询上周商机数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEARWEEK(date_format(addtime,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 and busprincipal=#{uname}")
    public Integer queryLastWeek(String uname);

    /**
     * 查询本月商机数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where date_format(addtime,'%Y-%m')=date_format(now(),'%Y-%m') and busprincipal=#{uname}")
    public Integer queryThisMonth(String uname);

    /**
     * 查询上月商机数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where date_format(addtime,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m') and busprincipal=#{uname}")
    public Integer queryLastMonth(String uname);

    /**
     * 查询本季度商机数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEAR(addtime)=YEAR(now()) AND QUARTER(addtime) = QUARTER(NOW()) and busprincipal=#{uname}")
    public Integer queryThisQuarter(String uname);

    /**
     * 查询上季度商机数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEAR(addtime)=YEAR(now()) AND  QUARTER(addtime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and busprincipal=#{uname}")
    public Integer queryLastQuarter(String uname);

    /**
     * 查询本年度商机数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEAR(addtime)=YEAR(NOW()) and busprincipal=#{uname}")
    public Integer queryThisYear(String uname);

    /**
     * 查询上年度商机数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEAR(addtime)=YEAR(NOW()) and busprincipal=#{uname}")
    public Integer queryLastYear(String uname);

//---------------------------------成交量--------------------------------------------

    /**
     * 查询本周成交数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEARWEEK(date_format(addtime,'%Y-%m-%d'),1) = YEARWEEK(now(),1) and busiphase='成交' and busprincipal=#{uname}")
    public Integer queryThisWeekAndStatus(String uname);

    /**
     * 查询上周成交数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEARWEEK(date_format(addtime,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 and busiphase='成交' and busprincipal=#{uname}")
    public Integer queryLastWeekAndStatus(String uname);

    /**
     * 查询本月成交数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where date_format(addtime,'%Y-%m')=date_format(now(),'%Y-%m')and busiphase='成交'and busprincipal=#{uname} ")
    public Integer queryThisMonthAndStatus(String uname);

    /**
     * 查询上月成交数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where date_format(addtime,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m') and busiphase='成交' and busprincipal=#{uname}")
    public Integer queryLastMonthAndStatus(String uname);

    /**
     * 查询本季度成交数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEAR(addtime)=YEAR(now()) AND QUARTER(addtime) = QUARTER(NOW())and busiphase='成交' and busprincipal=#{uname}")
    public Integer queryThisQuarterAndStatus(String uname);

    /**
     * 查询上季度成交数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEAR(addtime)=YEAR(now()) AND  QUARTER(addtime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and busiphase='成交' and busprincipal=#{uname}")
    public Integer queryLastQuarterAndStatus(String uname);

    /**
     * 查询本年度成交数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEAR(addtime)=YEAR(NOW()) and busiphase='成交' and busprincipal=#{uname}")
    public Integer queryThisYearAndStatus(String uname);

    /**
     * 查询上年度成交数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from business where YEAR(addtime)=YEAR(NOW()) and busiphase='成交' and busprincipal=#{uname}")
    public Integer queryLastYearAndStatus(String uname);

}
