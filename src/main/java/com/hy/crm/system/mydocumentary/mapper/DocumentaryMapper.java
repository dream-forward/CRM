package com.hy.crm.system.mydocumentary.mapper;

import com.hy.crm.system.mydocumentary.pojo.Documentary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 跟单表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Mapper
public interface DocumentaryMapper extends BaseMapper<Documentary> {

    /**
     * 根据商机ID查询
     */
    @Select("select * from documentary where busiid = #{busiid}")
    public List<Documentary> QueryDocumentaryByid(Integer busiid);

    //下面是查询跟单数

    /**
     * 查询本周跟单数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from documentary where YEARWEEK(date_format(doctime,'%Y-%m-%d'),1) = YEARWEEK(now(),1) and docuser=#{uname}")
    public Integer thisWeek(String uname);

    /**
     * 查询上周跟单数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from documentary where YEARWEEK(date_format(doctime,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1 and docuser=#{uname}")
    public Integer LastWeek(String uname);

    /**
     * 查询本月跟单数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from documentary where date_format(doctime,'%Y-%m')=date_format(now(),'%Y-%m') and docuser=#{uname}")
    public Integer thisMonth(String uname);

    /**
     * 查询上月跟单数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from documentary where date_format(doctime,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m') and docuser=#{uname}")
    public Integer lastMonth(String uname);

    /**
     * 查询本季度跟单数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from documentary where YEAR(doctime)=YEAR(now()) AND QUARTER(doctime) = QUARTER(NOW()) and docuser=#{uname}")
    public Integer thisQuarter(String uname);

    /**
     * 查询上季度跟单数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from documentary where YEAR(doctime)=YEAR(now()) AND  QUARTER(doctime)=QUARTER(DATE_SUB(now(),interval 1 QUARTER)) and docuser=#{uname}")
    public Integer LastQuarter(String uname);

    /**
     * 查询本年度跟单数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from documentary where YEAR(doctime)=YEAR(NOW()) and docuser=#{uname}")
    public Integer thisYear(String uname);

    /**
     * 查询上年度跟单数量
     *
     * @param uname 所传入的用户名
     * @return
     */
    @Select("select count(*) from documentary where YEAR(doctime)=YEAR(NOW()) and docuser=#{uname}")
    public Integer LastYear(String uname);
}
