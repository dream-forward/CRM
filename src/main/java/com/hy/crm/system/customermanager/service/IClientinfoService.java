package com.hy.crm.system.customermanager.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.system.customermanager.pojo.Clientinfo;

/**
 * <p>
 * 客户信息表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IClientinfoService extends IService<Clientinfo> {
    public IPage queryByLike(Page page, String did, String valu);
}
