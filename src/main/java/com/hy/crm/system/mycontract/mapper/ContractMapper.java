package com.hy.crm.system.mycontract.mapper;

import com.github.pagehelper.Page;
import com.hy.crm.system.alldiscussionposts.pojo.LikeSql;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.system.mycontract.pojo.ContractBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * 合同表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Mapper
public interface ContractMapper extends BaseMapper<Contract> {

    //下面是查询合同数
    /*
     * 查询个人各个时间段合同数量
     * */

    /**
     * 查询本周合同数量
     *
     * @param uid 所传入的用户id
     * @return
     */
    @Select("select count(*) from contract where YEARWEEK(date_format(condate,'%Y-%m-%d'),1) = YEARWEEK(now(),1) and userid=#{uid}")
    public Integer thisWeek(Integer uid);

    /**
     * 查询上周合同数量
     *
     * @param uid 所传入的用户id
     * @return
     */
    @Select("select count(*) from contract where YEARWEEK(date_format(condate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 and userid=#{uid}")
    public Integer LastWeek(Integer uid);

    /**
     * 查询本月合同数量
     *
     * @param uid 所传入的用户id
     * @return
     */
    @Select("select count(*) from contract where date_format(condate,'%Y-%m')=date_format(now(),'%Y-%m') and userid=#{uid}")
    public Integer thisMonth(Integer uid);

    /**
     * 查询上月合同数量
     *
     * @param uid 所传入的用户id
     * @return
     */
    @Select("select count(*) from contract where date_format(condate,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m') and userid=#{uid}")
    public Integer LastMonth(Integer uid);

    /**
     * 查询本季度合同数量
     *
     * @param uid 所传入的用户id
     * @return
     */
    @Select("select count(*) from contract where YEAR(condate)=YEAR(now()) AND QUARTER(condate) = QUARTER(NOW()) and userid=#{uid}")
    public Integer thisQuarter(Integer uid);

    /**
     * 查询上季度合同数量
     *
     * @param uid 所传入的用户id
     * @return
     */
    @Select("select count(*) from contract where YEAR(condate)=YEAR(now()) AND  QUARTER(condate)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and userid=#{uid}")
    public Integer LastQuarter(Integer uid);

    /**
     * 查询本年度合同数量
     *
     * @param uid 所传入的用户id
     * @return
     */
    @Select("select count(*) from contract where YEAR(condate)=YEAR(NOW()) and userid=#{uid}")
    public Integer thisYear(Integer uid);

    /**
     * 查询上年度合同数量
     *
     * @param uid 所传入的用户id
     * @return
     */
    @Select("select count(*) from contract where YEAR(condate)=YEAR(NOW()) and userid=#{uid}")
    public Integer LastYear(Integer uid);
    @SelectProvider(type= LikeSql.class,method="select2")
    public List<ContractBo> QueryContractBo(Page page, int selectss, String inputss);


}
