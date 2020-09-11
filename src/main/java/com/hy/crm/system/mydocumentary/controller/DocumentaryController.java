package com.hy.crm.system.mydocumentary.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.system.customermanager.pojo.Clientinfo;
import com.hy.crm.system.customermanager.service.IClientinfoService;
import com.hy.crm.system.mybusiness.pojo.Business;
import com.hy.crm.system.mybusiness.service.IBusinessService;
import com.hy.crm.system.mydocumentary.pojo.Documentary;
import com.hy.crm.system.mydocumentary.pojo.JsonTable;
import com.hy.crm.system.mydocumentary.service.IDocumentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 跟单表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/documentary")
public class DocumentaryController {

    @Autowired
    private IDocumentaryService documentaryService;

    @Autowired
    private IBusinessService businessServiceImpl;

    @Autowired
    private IClientinfoService clientinfoServiceImpl;


    /**
     * 模糊查询 and 查询所有
     */
    @RequestMapping("/LikeDocumentary.do")
    @ResponseBody
    public JsonTable LikeDocumentary(int limit, int page, int selects, String inputs){
        return documentaryService.LikeDocumentary(limit,page,selects,inputs);
    }

    /**
     * 根据跟单表商机id查询
     */
    @PostMapping("/QueryDocumentaryByid.do")
    @ResponseBody
    public JsonTable QueryDocumentaryByid(Integer busiid){
        JsonTable jsonTable=new JsonTable();
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("busiid",busiid);
        List<Documentary> list= documentaryService.list(queryWrapper);
        if(list.size()>0){
            jsonTable.setCode(0);
            jsonTable.setData(list);
        }else{
            jsonTable.setMsg("无跟单记录");
        }
        return jsonTable;
    }


    /**
     * 去新增跟单
     */
    @RequestMapping("/AddDocumentarys.do")
    public String AddDocumentarys(Model model){
        model.addAttribute("business",businessServiceImpl.list());
        return "/documentary/add.html";
    }


    /**
     * 根据商机ID查询
     */
    @PostMapping("/AddDocumentary.do")
    @ResponseBody
    public JsonTable AddDocumentary(Integer busid){
        JsonTable jsonTable=new JsonTable();
        Business business=businessServiceImpl.getById(busid);
        jsonTable.setMsg(business.getBusname());
        return jsonTable;
    }

    /**
     * 新增跟单
     */
    @PostMapping("/InsertDocumentary.do")
    public String InsertDocumentary(Documentary documentary,String theme){
        documentary.setDocsubject(theme+"-"+documentary.getDoctype());
        documentaryService.save(documentary);
        return "redirect:/documentary/list.html";
    }

    /**
     * 去修改跟单
     */
    @RequestMapping("/ToUpdate.do")
    public String ToUpdate(Model model,Documentary documentary){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("busid",documentary.getBusiid());
        Business business = businessServiceImpl.getOne(queryWrapper);
        QueryWrapper queryWrapper1 = new QueryWrapper();
        queryWrapper1.eq("cliid",business.getClientid());
        Clientinfo clientinfo = clientinfoServiceImpl.getOne(queryWrapper1);
        model.addAttribute("busine",business);
        model.addAttribute("client",clientinfo);
        return "/documentary/update.html";
    }

    /**
     * 修改跟单
     */
    @PostMapping("/UpdateDocumentary.do")
    public String UpdateDocumentary(Documentary documentary){
        documentaryService.UpdateDocumentary(documentary);
        return "forward:/documentary/list.html";
    }



}
