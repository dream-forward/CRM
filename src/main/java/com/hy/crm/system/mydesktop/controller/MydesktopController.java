package com.hy.crm.system.mydesktop.controller;

import com.hy.crm.system.mydesktop.bo.MyDesktop;
import com.hy.crm.system.mydesktop.service.IMyDesktopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author : Administrator
 * @Date : 2020/9/11 20:01
 * @Description :我的桌面统计
 */
@Controller
@RequestMapping("/mydesktop")
public class MydesktopController {

    @Autowired
    private IMyDesktopService myDesktopServiceImpl;

    //根据不同状态查询商机预计金额
    @GetMapping("/queryBusMoneyByStatus.do")
    @ResponseBody
    public List<MyDesktop> queryBusMoneyByStatus() {
        return myDesktopServiceImpl.queryBusMoneyByStatus();
    }

    //统计各种总数量
    @GetMapping("/queryCount.do")
    @ResponseBody
    public List<MyDesktop> queryCount() {
        return myDesktopServiceImpl.queryCount();
    }
}
