package com.hy.crm.system.mydesktop.service;

import com.hy.crm.system.mydesktop.bo.MyDesktop;

import java.util.List;

/**
 * @Author : Administrator
 * @Date : 2020/9/12 7:54
 * @Description :
 */
public interface IMyDesktopService {
    /**
     * 根据条件查询商机的预计金额
     *
     * @return List<MyDesktop>
     */
    List<MyDesktop> queryBusMoneyByStatus();

    /**
     * 统计客户数量、商机数量、合同数量
     *
     * @return List
     */
    List queryCount();
}
