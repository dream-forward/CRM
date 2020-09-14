package com.hy.crm.system.aftersalesservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.system.aftersalesservice.pojo.Aftersales;

/**
 * <p>
 * 售后服务表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IAftersalesService extends IService<Aftersales> {

    /**
     * 分页+模糊查询（售后哦）
     * @param name
     * @param value
     * @param page
     * @param limit
     * @return
     */
    IPage queryAfterSales(String name,String value, int page, int limit);

    /**
     * 分类
     * @param
     * @param page
     * @param limit
     * @return
     */
    /*IPage queryAfterSalesByState(String aftersalesstatus,int page, int limit);*/

    /**
     *
     * @param flag 时间标记
     * @param page 当前页
     * @param limit 每页条数
     * @return
     */
    IPage queryAftersalesByTime(String flag, int page, int limit);

    /**
     *
     * @param name
     * @param value
     * @param page
     * @param limit
     * @param cid
     * @return
     */
    IPage queryAfterListByCid(String name, String value, int page, int limit,Integer cid);
}
