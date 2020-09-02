package com.hy.crm.system.mydocumentary.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    /**
     * 查询所有跟单
     */
    @ResponseBody
    @RequestMapping("/QueryDocumentary.do")
    public JsonTable QueryDocumentary(int limit,int page){
        JsonTable jsonTable = new JsonTable();
        IPage iPage = new Page<Documentary>(page, limit);
        IPage iPage1 = documentaryService.page(iPage,null);
        jsonTable.setData(iPage1.getRecords());
        jsonTable.setCount((int)iPage1.getTotal());
        jsonTable.setCode(0);
        jsonTable.setMsg("查询成功");
        return jsonTable;
    }


    @RequestMapping("/LikeDocumentary.do")
    @ResponseBody
    public JsonTable LikeDocumentary(int selects,int limit,int page,Documentary documentary){
        Page page1 = new Page(page,limit);
        JsonTable jsontable = new JsonTable();
        jsontable.setCode(0);
        jsontable.setData(documentaryService.LikeDocumentary(selects,documentary));
        jsontable.setCount((int) page1.getTotal());
        return jsontable;
    }


//    @RequestMapping("/LikeDocSubject.do")
//    public JsonTable LikeDocSubject(int limit,int page,Documentary documentary){
//        Page page1 = new Page(page,limit);
//        JsonTable jsontable = new JsonTable();
//        jsontable.setCode(0);
//        jsontable.setData(documentaryService.LikeDocSubject(documentary));
//        jsontable.setCount((int) page1.getTotal());
//        return jsontable;
//    }
//
//
//    @RequestMapping("/LikeDocUser.do")
//    public JsonTable LikeDocUser(int limit,int page,Documentary documentary){
//        Page page1 = new Page(page,limit);
//        JsonTable jsontable = new JsonTable();
//        jsontable.setCode(0);
//        jsontable.setData(documentaryService.LikeDocUser(documentary));
//        jsontable.setCount((int) page1.getTotal());
//        return jsontable;
//    }





}
