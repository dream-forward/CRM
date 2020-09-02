package com.hy.crm.system.customermanager.controller;


import com.hy.crm.system.customermanager.pojo.Clientinfo;
import com.hy.crm.system.customermanager.service.IClientinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * 客户信息表 前端控制器
 * </p>
 *
 * @author th
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/clientinfo")
public class ClientinfoController {
    @Autowired
private IClientinfoService clientinfoServiceImpl;
    @PostMapping("/addclient.do")
    public void addclient(Clientinfo clientinfo){
        if(null!=clientinfo){
            if(clientinfo.getCliname()!="" && clientinfo.getCliname().trim().length()>0
            && clientinfo.getClifrom()!="" && clientinfo.getClifrom().trim().length()>0
            && clientinfo.getClicountry()!="" && clientinfo.getClicountry().trim().length()>0
            && clientinfo.getClicity()!="" && clientinfo.getClicity().trim().length()>0
            ){
                if(clientinfo.getClitype().equals("0")){
                clientinfo.setClitype("普通客户");
            }
                clientinfo.setBuserid(1);
                clientinfoServiceImpl.save(clientinfo);
            }
        }
    }
}
