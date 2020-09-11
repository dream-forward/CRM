package com.hy.crm.system.mybusiness.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.system.customermanager.pojo.Clientinfo;
import com.hy.crm.system.customermanager.service.IClientinfoService;
import com.hy.crm.system.mybusiness.pojo.Business;
import com.hy.crm.system.mybusiness.service.IBusinessService;
import com.hy.crm.utils.BusinessUtils;
import com.hy.crm.utils.LayuiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /*我的商机里新增商机页面查询当前用户下的所有客户*/
    @RequestMapping(value = "/getCliByUid.do")
    @ResponseBody
    public List<Clientinfo> getClientByUid(HttpServletRequest request){
        //User user=(User)request.getSession().getAttribute("user");
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("buserid",1);
        return clientinfoServiceImpl.list(queryWrapper);
    }
    /*全部商机里新增商机页面查询所有客户*/
    @RequestMapping(value = "/getCli.do")
    @ResponseBody
    public List<Clientinfo> getClient(HttpServletRequest request){
        return clientinfoServiceImpl.list(null);
    }

    /*新增商机 （通用）*/
    @RequestMapping(value = "/business.do")
    @ResponseBody
    public Boolean addBusiness(Business business,String maymoney){
        BigDecimal bigDecimal=new BigDecimal(maymoney);
        business.setMaymoney(bigDecimal);
        business.setBusiphase("初期沟通");
        Date date=new Date();
        Date str=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
             str=simpleDateFormat.parse(simpleDateFormat.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        business.setBusdate(str);
        return businessServiceImpl.save(business);
    }

    /**
     *条件查询即查询全部商机！！！！！！！
     * @param page:当前页
     * @param limit:一页几条
     * @param business：条件查询对象
     * @param day：根据7、30、90天进行查询
     * @param time：根据日期进行查询
     * @param jieduan：已成交已丢单已搁置
     * @param doing:正在进行中的商机
     * @param request:请求对象
     * @return
     */

    /*全部商机*/
    @RequestMapping("/queryBusiness.do")
    @ResponseBody
    public LayuiUtils queryBusiness(Integer page, Integer limit,Business business,String maymoney,Integer day, String time,String jieduan,String doing,HttpServletRequest request){
        if(null==page){
            page=1;
        }

        Page page1=new Page(page,limit);
        if(null!=maymoney) {
            BigDecimal bigDecimal = new BigDecimal(maymoney);
            business.setMaymoney(bigDecimal);
        }
        IPage iPage=businessServiceImpl.queryBusiness(page1,business,day,time,jieduan,doing,request);
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
    /**
     *条件查询即查询全部商机！！！！！！！
     * @param page:当前页
     * @param limit:一页几条
     * @param business：条件查询对象
     * @param day：根据7、30、90天进行查询
     * @param time：根据日期进行查询
     * @param jieduan：已成交已丢单已搁置
     * @param type:我负责的我参与的我关注的
     * @param request:请求对象
     * @return
     */

    /*我的商机*/
    @RequestMapping("/myqueryBusiness.do")
    @ResponseBody
    public LayuiUtils myQueryBusiness(Integer page, Integer limit,Business business,String maymoney,String type,Integer day, String time,String jieduan,HttpServletRequest request){
        if(null==page){
            page=1;
        }
        Page page1=new Page(page,limit);
        if(null!=maymoney) {
            BigDecimal bigDecimal = new BigDecimal(maymoney);
            business.setMaymoney(bigDecimal);
        }
        IPage iPage=businessServiceImpl.myQueryBusiness(page1,business,type,day,time,jieduan,request);
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


    /**
     * 修改前查看
     */
    @GetMapping("/toUpdateBusinessById.do")
    public String  toUpdateBusinessById(Integer id, Model model){
    Business business=businessServiceImpl.getById(id);
    Clientinfo clientinfo=clientinfoServiceImpl.getById(business.getClientid());
    model.addAttribute("business",business);
    model.addAttribute("clientinfo",clientinfo);

        return "/view/toupdatebusiness.html";
    }

    /**
     * 修改页面
     * @param id
     * @param model
     * @param request
     * @return
     */
    @GetMapping("/toUpdateBus.do")
    public String  toUpdateBus(Integer id, Model model,HttpServletRequest request){
        Business business=businessServiceImpl.getById(id);
        Clientinfo clientinfo=clientinfoServiceImpl.getById(business.getClientid());
        QueryWrapper queryWrapper=new QueryWrapper();
       /* User user=(User)request.getSession().getAttribute("user");*/
        queryWrapper.eq("buserid",1);
        model.addAttribute("allclient",clientinfoServiceImpl.list(queryWrapper));
        model.addAttribute("business",business);
        model.addAttribute("clientinfo",clientinfo);
        return "/view/updatebusiness.html";
    }
        /*修改商机*/
    @RequestMapping("/updateBusiness.do")
    @ResponseBody
    public boolean updateBusiness(Business business,String  maymoney){
        if(null!=maymoney) {
            BigDecimal bigDecimal = new BigDecimal(maymoney);
            business.setMaymoney(bigDecimal);
        }
       return  businessServiceImpl.updateById(business);
    }
    /*我的商机页面查询左边菜单栏数量*/
    @RequestMapping("/myqueryCount.do")
    @ResponseBody
    public BusinessUtils myQueryCount(HttpServletRequest request){
        return businessServiceImpl.myBusinessQueryCount(request);
    };
    /*全部商机页面查询左边菜单栏数量*/
    @RequestMapping("/allqueryCount.do")
    @ResponseBody
    public BusinessUtils allBusinessQueryCount(){
        return businessServiceImpl.allBusinessQueryCount();
    };

    /*客户页面到商机列表*/
    @RequestMapping("/queryBusinessById.do")
    public String queryBusinessById(Integer id,Model model){
        model.addAttribute("cid",id);
        return "/view/morebusiness.html";
    }
    /*客户下查找商机*/
    @RequestMapping("/queryBusinessByCid.do")
    @ResponseBody
    public LayuiUtils queryBusinessByCid(Integer page, Integer limit,Business business,String maymoney,Integer cid){
        if(null==page){
            page=1;
        }
        Page page1=new Page(page,limit);
        if(null!=maymoney){
            BigDecimal bigDecimal=new BigDecimal(maymoney);
            business.setMaymoney(bigDecimal);
        }

        IPage iPage=businessServiceImpl.getBusinessByCid(page1,business,cid);
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
    };

}
