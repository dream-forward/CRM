package com.hy.crm.system.aftersalesservice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crm.system.aftersalesservice.pojo.Aftersales;
import com.hy.crm.system.aftersalesservice.service.IAftersalesService;
import com.hy.crm.system.customermanager.pojo.Clientinfo;
import com.hy.crm.system.customermanager.service.IClientinfoService;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.hy.crm.system.mycontract.service.IContractService;
import com.hy.crm.utils.LayuiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    //查询售后信息---可模糊查询+分页
    @GetMapping("/queryAftersales.do")
    @ResponseBody
    public LayuiUtils queryAftersales(String name, String value, int page, int limit) {
        System.out.println("~~~~~~" + name + "~~~~~~" + value);
        LayuiUtils layuiUtils = new LayuiUtils();
        IPage iPage = aftersalesServiceImpl.queryAfterSales(name, value, page, limit);
        layuiUtils.setCode(0);
        layuiUtils.setMsg("查询成功");
        layuiUtils.setCount((int) iPage.getTotal());
        layuiUtils.setData(iPage.getRecords());
        return layuiUtils;
    }

    //点击主题时查询售后服务详情
    @GetMapping("/queryAfterSalesDetail.do")
    public String queryAfterSalesDetail(int asid, Model model) {
        //根据售后表id查询信息
        Aftersales aftersales = aftersalesServiceImpl.getById(asid);
        //再拿到合同编号查询合同信息
        Contract contract = contractServiceImpl.getOne(new QueryWrapper<Contract>().eq("connum", aftersales.getContractnum()));
        //根据客户id查询客户信息
        Clientinfo clientinfo = clientinfoServiceImpl.getById(aftersales.getClientname());
        System.out.println("1-" + aftersales);
        System.out.println("2-" + contract);
        System.out.println("3-" + clientinfo);
        model.addAttribute("clientinfo", clientinfo);//设置客户信息
        model.addAttribute("aftersales", aftersales);//设置售后信息
        model.addAttribute("contract", contract);//设置合同信息
        return "/view/aftersalesdetails.html";
    }

    //分类查询（处理中、已完成、已撤除）
    /*@GetMapping("/queryAfterSalesByState.do")
    @ResponseBody
    public void queryAfterSalesByState(String aftersalesstatus,int page, int limit){
        System.out.println("当前状态："+aftersalesstatus);
        LayuiUtils layuiUtils = new LayuiUtils();
        //如果传过来的分类不为空
        if(StringUtils.isNotEmpty(aftersalesstatus)){
            List<Aftersales> aftersales = aftersalesServiceImpl.list(new QueryWrapper<Aftersales>().eq("aftersalesstatus",aftersalesstatus));
            layuiUtils.setCode(0);
            layuiUtils.setMsg("查询成功");
            layuiUtils.setCount();
        }
    }*/

    //根据时间阶段查询售后信息--- +分页
    @GetMapping("/queryAftersalesByTime.do")
    @ResponseBody
    public LayuiUtils queryAftersalesByTime(String flag, int page, int limit) {
        System.out.println("===" + flag);
        LayuiUtils layuiUtils = new LayuiUtils();
        IPage iPage = aftersalesServiceImpl.queryAftersalesByTime(flag, page, limit);
        layuiUtils.setCode(0);
        layuiUtils.setMsg("查询成功");
        layuiUtils.setCount((int) iPage.getTotal());
        layuiUtils.setData(iPage.getRecords());
        return layuiUtils;
    }


    //去客户管理页面查询某客户的售后列表
    @RequestMapping("/toAfterList.do")
    public String toAfterList(Integer cid,Model model){
        model.addAttribute("cid",cid);
        return "/view/moreafter.html";
    }

    //客户管理页面查询某客户的售后列表
    @RequestMapping("/afterList.do")
    @ResponseBody
    public LayuiUtils queryAfterListByCid(String name, String value, int page, int limit,Integer cid){
        LayuiUtils layuiUtils = new LayuiUtils();
        IPage iPage = aftersalesServiceImpl.queryAfterListByCid(name,value,page,limit,cid);
        layuiUtils.setCode(0);
        layuiUtils.setMsg("查询成功");
        layuiUtils.setCount((int) iPage.getTotal());
        layuiUtils.setData(iPage.getRecords());
        return layuiUtils;
    }

}
