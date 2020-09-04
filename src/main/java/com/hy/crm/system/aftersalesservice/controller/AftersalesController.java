package com.hy.crm.system.aftersalesservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.system.aftersalesservice.pojo.Aftersales;
import com.hy.crm.system.aftersalesservice.service.IAftersalesService;
import com.hy.crm.system.customermanager.pojo.Clientinfo;
import com.hy.crm.system.customermanager.service.IClientinfoService;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.hy.crm.system.mycontract.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 售后服务表 前端控制器
 * </p>
 *
 * @author lilei
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/aftersales")
public class AftersalesController {

    @Autowired
    private IClientinfoService clientinfoServiceImpl;
    @Autowired
    private IContractService contractServiceImpl;
    @Autowired
    private IAftersalesService aftersalesServiceImpl;

    //查询所有客户
    @GetMapping("/queryAllClient.do")
    @ResponseBody
    public List<Clientinfo> queryAllClient() {
        List<Clientinfo> clientinfo = clientinfoServiceImpl.list();
        System.out.println(clientinfo.size());
        return clientinfo;
    }

    //根据客户id查询所有合同信息
    @GetMapping("/queryAllContract.do")
    @ResponseBody
    public List<Contract> queryAllContract(Integer cid) {
        List<Contract> contracts = contractServiceImpl.list(new QueryWrapper<Contract>().eq("clientid", cid));
        for (Contract contract : contracts) {
            System.out.println("开始时间-" + contract.getBegindate());
        }
        System.out.println(contracts.size());
        return contracts;
    }

    //添加售后信息
    @PostMapping("/addAfterSales.do")
    @ResponseBody
    public boolean addAfterSales(Aftersales aftersales) {
        System.out.println("进添加");
        return aftersalesServiceImpl.save(aftersales);
    }

    //查询售后信息
    public void queryAftersales(Aftersales aftersales, int page, int limit) {
        IPage iPage = aftersalesServiceImpl.queryAfterSales(aftersales, page, limit);
    }
}
