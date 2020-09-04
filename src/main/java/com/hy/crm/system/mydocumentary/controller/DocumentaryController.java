package com.hy.crm.system.mydocumentary.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.system.mybusiness.service.IBusinessService;
import com.hy.crm.system.mydocumentary.pojo.Documentary;
import com.hy.crm.system.mydocumentary.pojo.JsonTable;
import com.hy.crm.system.mydocumentary.service.IDocumentaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

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
//    private
    /**
     * 模糊查询 and 查询所有
     */
    @RequestMapping("/LikeDocumentary.do")
    @ResponseBody
    public JsonTable LikeDocumentary(int limit, int page, int selects, String inputs){
        return documentaryService.LikeDocumentary(limit,page,selects,inputs);
    }

    /**
     * 去新增跟单
     */
    @RequestMapping("/QueryDocumentaryByid.do")
    @ResponseBody
    public List<Documentary> QueryDocumentaryByid(Integer busiid){
        return documentaryService.QueryDocumentaryByid(busiid);
    }


    /**
     * 去新增跟单
     */
    @RequestMapping("/AddDocumentary.do")
    public String AddDocumentary(Model model){
        model.addAttribute("business",businessServiceImpl.list());
        return "documentary/add.html";
    }


    /**
     * 新增跟单
     */
    @RequestMapping("/InsertDocumentary.do")
    public String InsertDocumentary(Documentary documentary){
        documentaryService.InsertDocumentary(documentary);
        return "documentary/list.html";
    }




}
