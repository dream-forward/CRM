package com.hy.crm.system.mybusiness.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.system.customermanager.pojo.Clientinfo;
import com.hy.crm.system.customermanager.service.IClientinfoService;
import com.hy.crm.system.mybusiness.pojo.Business;
import com.hy.crm.system.mybusiness.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 商机表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private IBusinessService businessServiceImpl;
    @Autowired
    private IClientinfoService clientinfoServiceImpl;

    @RequestMapping(value = "/getCliByUid.do")
    @ResponseBody
    public List<Clientinfo> getClientByUid(HttpServletRequest request){
        //User user=(User)request.getSession().getAttribute("user");
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("buserid",1);
        return clientinfoServiceImpl.list(queryWrapper);
    }

    @RequestMapping(value = "/business.do")
    public void addBusiness(Business business){
        business.setBusiphase("初期沟通");
        businessServiceImpl.save(business);
    }
}
