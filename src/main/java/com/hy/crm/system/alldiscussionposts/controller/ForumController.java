package com.hy.crm.system.alldiscussionposts.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crm.system.alldiscussionposts.pojo.Forum;
import com.hy.crm.system.alldiscussionposts.pojo.ForumBo;
import com.hy.crm.system.alldiscussionposts.pojo.Pinlun;
import com.hy.crm.system.alldiscussionposts.service.IForumService;
import com.hy.crm.system.alldiscussionposts.service.IPinlunService;
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

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 帖子表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Controller
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    private IForumService forumServiceImpl;

    @Autowired
    private IBusinessService businessServiceImpl;

    @Autowired
    private IPinlunService pinlunServiceImpl;

    @RequestMapping("/QueryForumBo.do")
    @ResponseBody
    public JsonTable QueryForumBo(int limit, int page,int selects, String inputs){
        Page page1 =  PageHelper.startPage(page,limit);
        JsonTable jsontable = new JsonTable();
        jsontable.setCode(0);
        List<ForumBo> boList = forumServiceImpl.QueryForumBo(page1,selects,inputs);
        jsontable.setData(boList);
        jsontable.setCount((int) page1.getTotal());
        return jsontable;
    }


    /**
     * 去新增帖子
     */
    @RequestMapping("/ToAdd.do")
    public String ToAdd(Model model){
        List<Business> business = businessServiceImpl.list();
        model.addAttribute("business",business);
        return "/forum/add.html";
    }


    /**
     * 新增帖子
     */
    @PostMapping("/InsertForum.do")
    public String InsertForum(Forum forum){
        forumServiceImpl.InsertForum(forum);
        return "redirect:/forum/list.html";
    }


    /**
     * 去修改帖子
     */
    @RequestMapping("/ToUpdate.do")
    public String ToUpdate(Model model ,Forum forum){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("forid",forum.getForid());
        Forum forum1 = forumServiceImpl.getOne(queryWrapper);
        System.out.println("forum1----------"+forum1);
        forum1.setForclick(forum1.getForclick()+1);
        forumServiceImpl.UpdateForum(forum1);
        QueryWrapper queryWrapper1 = new QueryWrapper();
        queryWrapper1.eq("forumid",forum1.getForid());
        List<Pinlun> pinlun = pinlunServiceImpl.list(queryWrapper1);
//        if(pinlun.size()>0){
//            for (int i =0; i <pinlun.size() ; i++) {
//                pinlun.get(i).setCallback(i+1);
//            }
//        }
        model.addAttribute("pinlun",pinlun);
        model.addAttribute("forum",forum1);
        return "/forum/update.html";
    }


    /**
     * 回复帖子
     */
    @PostMapping("/UpdatesForum.do")
    public String UpdatesForum(Model model,Forum forum){
        System.out.println(forum+"forum----------------");
        Pinlun pinlun = new Pinlun();
        pinlun.setPinlundate(new Date());
        pinlun.setForumid(forum.getForid());
        pinlun.setPinlunbody(forum.getForbody());

        Forum forum1 = new Forum();
        forum1.setForid(forum.getForid());
        forum1.setFortime(new Date());
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("forid",forum.getForid());
        Forum forum2 = forumServiceImpl.getOne(queryWrapper);
        forum1.setCallback(forum2.getCallback()+1);
        boolean b = pinlunServiceImpl.save(pinlun);
        if (b){
                forumServiceImpl.UpdateForum(forum1);
//                pinlunServiceImpl.UpdatePinlun(pinlun1);
        }
        return "redirect:/forum/ToUpdate.do?forid="+forum.getForid();
    }


    @RequestMapping("/delete.do")
    public boolean delete(Forum forum){
       return forumServiceImpl.removeById(forum.getForid());
    }


}
