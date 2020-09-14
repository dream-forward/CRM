package com.hy.crm.system.mycontract.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.hy.crm.system.mycontract.pojo.Income;
import com.hy.crm.system.mycontract.service.IContractService;
import com.hy.crm.system.mycontract.service.IIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

/**
 * <p>
 * 收入说明 前端控制器
 * </p>
 *
 * @author TH
 * @since 2020-09-03
 */
@Controller
@RequestMapping("/income")
public class IncomeController {

    @Autowired
    private IIncomeService incomeServiceImpl;

    @Autowired
    private IContractService contractServiceImpl;

    @RequestMapping("/InsertIncome.do")
    public String InsertIncome(Income income,Contract contract){
//       System.out.println("income.getIncmoney()-----------------"+income.getIncmoney());
//       BigDecimal incum = income.getIncmoney();
//       QueryWrapper queryWrapper = new QueryWrapper();
//       queryWrapper.eq("conid",income.getContid());
//       Contract contract = contractServiceImpl.getOne(queryWrapper);
//        System.out.println("contract.getConmoney()-----------------"+contract.getConmoney());
//       BigDecimal conNum = contract.getConmoney();
//       BigDecimal conmoney = incum.add(conNum);
//       contract.setConmoney(conmoney);
        income.setIncuser(String.valueOf(contract.getUserid()));
        income.setContid(String.valueOf(contract.getConid()));
       boolean b = incomeServiceImpl.save(income);
//       if (b){
//           contractServiceImpl.UpdateContract(contract);
//       }
       return "/contract/list.html";
    }
}
