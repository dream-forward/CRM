package com.hy.crm.system.mydesktop.service.impl;

import com.hy.crm.system.customermanager.mapper.ClientinfoMapper;
import com.hy.crm.system.customermanager.pojo.Clientinfo;
import com.hy.crm.system.mybusiness.mapper.BusinessMapper;
import com.hy.crm.system.mybusiness.pojo.Business;
import com.hy.crm.system.mycontract.mapper.ContractMapper;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.hy.crm.system.mydesktop.bo.MyDesktop;
import com.hy.crm.system.mydesktop.service.IMyDesktopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Administrator
 * @Date : 2020/9/12 7:53
 * @Description : 我的桌面service
 */
@Service
public class MyDesktopServiceImpl implements IMyDesktopService {

    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private ClientinfoMapper clientinfoMapper;
    @Autowired
    private ContractMapper contractMapper;

    /**
     * 根据商机状态查询预计成交金额
     *
     * @return List<MyDesktop>
     */
    @Override
    public List<MyDesktop> queryBusMoneyByStatus() {
        List<MyDesktop> list = new ArrayList<>();
        MyDesktop myDesktop1 = businessMapper.queryBusMoneyByStatus("已成交");
        MyDesktop myDesktop2 = businessMapper.queryBusMoneyByStatus("已丢单");
        MyDesktop myDesktop3 = businessMapper.queryBusMoneyByStatus("已搁置");
        MyDesktop myDesktop4 = businessMapper.queryBusMoneyByStatus("进行中");
        list.add(myDesktop1);
        list.add(myDesktop2);
        list.add(myDesktop3);
        list.add(myDesktop4);
        return list;
    }

    /**
     * 我的桌面-统计数量
     * @return
     */
    @Override
    public List<MyDesktop> queryCount() {
        List<MyDesktop> list = new ArrayList<>();
        //统计客户数量
        List<Clientinfo> clientinfos = clientinfoMapper.selectList(null);
        if (clientinfos.size() == 0) {
            list.add(new MyDesktop(0, null));
        } else {
            list.add(new MyDesktop(clientinfos.size(), null));
        }
        //统计商机数量
        List<Business> businesses = businessMapper.selectList(null);
        if (businesses.size() == 0) {
            list.add(new MyDesktop(0, null));
        } else {
            list.add(new MyDesktop(businesses.size(), null));
        }
        //统计合同数量
        List<Contract> contracts = contractMapper.selectList(null);
        if (contracts.size() == 0) {
            list.add(new MyDesktop(0, null));
        } else {
            list.add(new MyDesktop(contracts.size(), null));
        }
        return list;
    }

}
