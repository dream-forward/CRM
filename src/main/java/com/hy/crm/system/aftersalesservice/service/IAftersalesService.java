package com.hy.crm.system.aftersalesservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.system.aftersalesservice.pojo.Aftersales;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 售后服务表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IAftersalesService extends IService<Aftersales> {

    //分页+模糊查询（售后哦）
    IPage queryAfterSales(Aftersales aftersales, int page, int limit);
}
