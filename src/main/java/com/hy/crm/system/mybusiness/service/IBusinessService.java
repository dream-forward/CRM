package com.hy.crm.system.mybusiness.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.system.mybusiness.pojo.Business;
import com.hy.crm.utils.BusinessUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 商机表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IBusinessService extends IService<Business> {
    public IPage queryBusiness(Page page, Business business, Integer day, String time, String jieduan, String doing, HttpServletRequest request);
    public IPage myQueryBusiness(Page page,Business business, String type, Integer day, String time, String jieduan, HttpServletRequest request);
    public BusinessUtils myBusinessQueryCount(HttpServletRequest request);
    public BusinessUtils allBusinessQueryCount();
    public IPage getBusinessByCid(Page page, Business business, Integer cid);
}
