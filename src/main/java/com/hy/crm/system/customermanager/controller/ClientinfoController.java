package com.hy.crm.system.customermanager.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.system.customermanager.pojo.Clientinfo;
import com.hy.crm.system.customermanager.service.IClientinfoService;
import com.hy.crm.utils.LayuiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/clientlist.do")
    @ResponseBody
    public LayuiUtils listClientAll(Integer page, Integer limit, String did, String valu){
        if(null==page){
            page=1;
        }
        Page page1=new Page(page,limit);
        IPage iPage=clientinfoServiceImpl.queryByLike(page1,did,valu);
        if(null!=iPage){
            LayuiUtils utils=new LayuiUtils();
            utils.setData(iPage.getRecords());
            utils.setCode(0);
            utils.setMsg("成功");
            utils.setCount((int)iPage.getTotal());
            return utils;
        }else{
            LayuiUtils utils=new LayuiUtils();
            utils.setData(null);
            utils.setCode(500);
            utils.setMsg("查无此数据");
            utils.setCount(0);
            return utils;
        }

    }
}
