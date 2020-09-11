package com.hy.crm.system.mycontract.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.system.alldiscussionposts.pojo.ForumBo;
import com.hy.crm.system.customermanager.pojo.Clientinfo;
import com.hy.crm.system.customermanager.service.IClientinfoService;
import com.hy.crm.system.mybusiness.pojo.Business;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.hy.crm.system.mycontract.pojo.ContractBo;
import com.hy.crm.system.mycontract.service.IContractService;
import com.hy.crm.system.mydocumentary.pojo.Documentary;
import com.hy.crm.system.mydocumentary.pojo.JsonTable;
import com.hy.crm.user.pojo.User;
import com.hy.crm.user.service.IUserRoleService;
import com.hy.crm.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 合同表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractServiceImpl;

    @Autowired
    private IClientinfoService clientinfoServiceImpl;

    @Autowired
    private IUserService userServiceImpl;

    @RequestMapping("/QueryContractBo.do")
    @ResponseBody
    public JsonTable QueryContractBo(int limit, int page,int selectss, String inputss){
        Page page1 =  PageHelper.startPage(page,limit);
        JsonTable jsontable = new JsonTable();
        jsontable.setCode(0);
        List<ContractBo> boList = contractServiceImpl.QueryContractBo(page1,selectss,inputss);
        jsontable.setData(boList);
        jsontable.setCount((int) page1.getTotal());
        return jsontable;
    }


    /**
     * 去修改
     */
    @RequestMapping("/ToUpdate.do")
    public String ToUpdate(Model model, Contract contract){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("conid",contract.getConid());
        Contract contract1 = contractServiceImpl.getOne(queryWrapper);
        QueryWrapper queryWrapper1 = new QueryWrapper();
        queryWrapper1.eq("cliid",contract.getClientid());
        Clientinfo clientinfo = clientinfoServiceImpl.getOne(queryWrapper1);
        QueryWrapper queryWrapper2 = new QueryWrapper();
        queryWrapper.eq("userid",contract.getUserid());
        User user = userServiceImpl.getOne(queryWrapper2);
        model.addAttribute("user",user);
        model.addAttribute("client",clientinfo);
        model.addAttribute("cont",contract1);
        return "/contract/update.html";
    }

    /**
     * 去新增
     */
    @RequestMapping("/QueryClient.do")
    @ResponseBody
    public List<Clientinfo> QueryClient(){
      return  clientinfoServiceImpl.list();
    }



    /**
     * 根据客户ID查询
     */
    @PostMapping("/AddClientinfo.do")
    @ResponseBody
    public Clientinfo AddClientinfo(Integer cliid){
        return clientinfoServiceImpl.getById(cliid);
    }

    @PostMapping("/InsertContract.do")
    public String InsertContract(Clientinfo clientinfo,Contract contract){
        contract.setConname(clientinfo.getCliname()+"-"+contract.getShortname());
        contractServiceImpl.save(contract);
        return "/contract/list.html";
    }

    @PostMapping("/UpdateContract.do")
    public String UpdateContract(Contract contract){
        UpdateWrapper<Contract> updateWrapper = new UpdateWrapper<>();
        System.out.println("contract.getConid()--------------------------"+contract.getConid());
        updateWrapper.eq("conid",contract.getConid());
        contractServiceImpl.update(contract,updateWrapper);
        return "/contract/list.html";
    }


}
