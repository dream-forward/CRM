package com.hy.crm.system.mybusiness.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.system.mybusiness.mapper.BusinessMapper;
import com.hy.crm.system.mybusiness.pojo.Business;
import com.hy.crm.system.mybusiness.service.IBusinessService;
import com.hy.crm.utils.BusinessUtils;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 商机表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {
    @Autowired
    private BusinessMapper businessMapper;
    @Override
    public IPage queryBusiness(Page page, Business business,Integer day, String time, String jieduan, String doing, HttpServletRequest request){
        IPage iPage=null;
        if(//查询所有
                (null==business.getBusiphase() || "".equals(business.getBusiphase())) &&
                        (null==business.getBusname() || "".equals(business.getBusname())) &&
                        (null==business.getBusprincipal() || "".equals(business.getBusprincipal())) &&
                        (null==business.getBusdept() || "".equals(business.getBusdept())) &&
                        (null==business.getMaymoney() || "".equals(business.getMaymoney())) &&
                        (null==business.getMaydate() || "".equals(business.getMaydate())) &&
                        (null==day || "".equals(day) )&&
                        (null==time || "".equals(time)) &&
                        (null==doing || "".equals(doing)) &&
                        (null==jieduan || "".equals(jieduan))
        ){
            iPage=businessMapper.selectPage(page,null);
        }else{//带条件查询
            QueryWrapper queryWrapper=new QueryWrapper();
          if(null!=doing && !"".equals(doing)){//正在进行的商机
                  queryWrapper.in("busiphase","初期沟通","方案和报价","竞争或投标","商务谈判");
                iPage=businessMapper.selectPage(page,queryWrapper);
            }else if(null!=day && !"".equals(day)){//7/30/90天未跟单
                if(7==day){
                    queryWrapper.isNull("lastdate");
                    queryWrapper.apply("date_sub(curdate(), INTERVAL 7 DAY) <= date(busdate)");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if(30==day){
                    queryWrapper.isNull("lastdate");
                    queryWrapper.apply("date_sub(curdate(), INTERVAL 30 DAY) <= date(busdate)");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if(90==day){
                    queryWrapper.isNull("lastdate");
                    queryWrapper.apply("date_sub(curdate(), INTERVAL 90 DAY) <= date(busdate)");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }

            }else if(null!=time && !"".equals(time)){//周月季度
                if("time1".equals(time)){
                    queryWrapper.apply("YEARWEEK(date_format(busdate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if("time2".equals(time)){
                    queryWrapper.apply("YEARWEEK(date_format(busdate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if("time3".equals(time)){
                    queryWrapper.apply("date_format(busdate,'%Y-%m')=date_format(now(),'%Y-%m')");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if("time4".equals(time)){
                    queryWrapper.apply("date_format(busdate,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m')");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if("time5".equals(time)){
                    queryWrapper.apply("YEAR(busdate)=YEAR(now()) AND QUARTER(busdate) = QUARTER(NOW())");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if("time6".equals(time)){
                    queryWrapper.apply("YEAR(busdate)=YEAR(now()) AND  QUARTER(busdate)=QUARTER(DATE_SUB(now(),interval 1 QUARTER))");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }
            }else if(null!=jieduan && !"".equals(jieduan)){//阶段
                queryWrapper.eq("busiphase",jieduan);
                iPage=businessMapper.selectPage(page,queryWrapper);
            }else{
                //form表单多条件拼接查询（通用）
            if(!StringUtils.isNullOrEmpty(business.getBusname())){
                queryWrapper.like("busname",business.getBusname());
            }
            if(!StringUtils.isNullOrEmpty(business.getBusprincipal())){
                queryWrapper.eq("busprincipal",business.getBusprincipal());
            }
            if(!StringUtils.isNullOrEmpty(business.getBusdept())){
                queryWrapper.eq("busdept",business.getBusdept());
            }
            if(null!=business.getMaymoney()){
                queryWrapper.eq("maymoney",business.getMaymoney());
            }
            if(null!=(business.getMaydate())){
                queryWrapper.eq("maydate",business.getMaydate());
            }
            iPage=businessMapper.selectPage(page,queryWrapper);

        }
        }

            return iPage;
    }

            /*我的商机*/
    @Override
    public IPage myQueryBusiness(Page page,Business business, String type, Integer day, String time, String jieduan, HttpServletRequest request){
        IPage iPage=null;
        QueryWrapper queryWrapper=new QueryWrapper();
      /*   User user=(User)request.getSession().getAttribute("user");
        String username=user.getUsername();*/
        if(//查询所有(两页通用)
                (null==business.getBusiphase() || "".equals(business.getBusiphase())) &&
                        (null==business.getBusname() || "".equals(business.getBusname())) &&
                        (null==business.getBusprincipal() || "".equals(business.getBusprincipal())) &&
                        (null==business.getBusdept() || "".equals(business.getBusdept())) &&
                        (null==business.getMaymoney() || "".equals(business.getMaymoney())) &&
                        (null==business.getMaydate() || "".equals(business.getMaydate())) &&
                        (null==day || "".equals(day) )&&
                        (null==time || "".equals(time)) &&
                        (null==jieduan || "".equals(jieduan)) &&
                        (null==type || "".equals(type))
        ){
            queryWrapper.eq("busprincipal","张三");
            iPage=businessMapper.selectPage(page,queryWrapper);
        }else{//带条件查询（两页通用）
            if(!StringUtils.isNullOrEmpty(type)){//我负责的/我参与的/我关注的（我的商机）
                if("type1".equals(type)){
                    queryWrapper.eq("busprincipal","张三");
                }else if("type2".equals(type)){
                    queryWrapper.eq("busparticipant","张三");
                }else if("type3".equals(type)){
                    queryWrapper.eq("busfocus","张三");
                }
                iPage=businessMapper.selectPage(page,queryWrapper);
            }else if(null!=day && !"".equals(day)){//7/30/90天未跟单（通用）
                if(7==day){
                    queryWrapper.isNull("lastdate");
                    queryWrapper.apply("date_sub(curdate(), INTERVAL 7 DAY) <= date(busdate)");
                    queryWrapper.eq("busprincipal","张三");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if(30==day){
                    queryWrapper.isNull("lastdate");
                    queryWrapper.apply("date_sub(curdate(), INTERVAL 30 DAY) <= date(busdate)");
                    queryWrapper.eq("busprincipal","张三");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if(90==day){
                    queryWrapper.isNull("lastdate");
                    queryWrapper.apply("date_sub(curdate(), INTERVAL 90 DAY) <= date(busdate)");
                    queryWrapper.eq("busprincipal","张三");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }

            }else if(null!=time && !"".equals(time)){//周月季度（通用）
                if("time1".equals(time)){
                    queryWrapper.apply("YEARWEEK(date_format(busdate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)");
                    queryWrapper.eq("busprincipal","张三");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if("time2".equals(time)){
                    queryWrapper.apply("YEARWEEK(date_format(busdate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1");
                    queryWrapper.eq("busprincipal","张三");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if("time3".equals(time)){
                    queryWrapper.apply("date_format(busdate,'%Y-%m')=date_format(now(),'%Y-%m')");
                    queryWrapper.eq("busprincipal","张三");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if("time4".equals(time)){
                    queryWrapper.apply("date_format(busdate,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m')");
                    queryWrapper.eq("busprincipal","张三");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if("time5".equals(time)){
                    queryWrapper.apply("YEAR(busdate)=YEAR(now()) AND QUARTER(busdate) = QUARTER(NOW())");
                    queryWrapper.eq("busprincipal","张三");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }else if("time6".equals(time)){
                    queryWrapper.apply("YEAR(busdate)=YEAR(now()) AND  QUARTER(busdate)=QUARTER(DATE_SUB(now(),interval 1 QUARTER))");
                    queryWrapper.eq("busprincipal","张三");
                    iPage=businessMapper.selectPage(page,queryWrapper);
                }
            }else if(null!=jieduan && !"".equals(jieduan)){//阶段（通用）
                queryWrapper.eq("busiphase",jieduan);
                queryWrapper.eq("busprincipal","张三");
                iPage=businessMapper.selectPage(page,queryWrapper);
            }else{
                //form表单多条件拼接查询（通用）
                if(!StringUtils.isNullOrEmpty(business.getBusname())){
                    queryWrapper.like("busname",business.getBusname());
                }
                if(!StringUtils.isNullOrEmpty(business.getBusdept())){
                    queryWrapper.eq("busdept",business.getBusdept());
                }
                if(null!=business.getMaymoney()){
                    queryWrapper.eq("maymoney",business.getMaymoney());
                }
                if(null!=(business.getMaydate())){
                    queryWrapper.eq("maydate",business.getMaydate());
                }
                queryWrapper.eq("busprincipal","张三");
                iPage=businessMapper.selectPage(page,queryWrapper);
            }
        }

        return iPage;
    };


    @Override
    public BusinessUtils myBusinessQueryCount(HttpServletRequest request){
        BusinessUtils businessUtils=new BusinessUtils();
        QueryWrapper queryWrapper1=new QueryWrapper();
        queryWrapper1.eq("busprincipal","张三");
        int count=businessMapper.selectList(queryWrapper1).size();
        if(count>0){
            businessUtils.setFuze(count);
        }else{
            businessUtils.setFuze(0);
        }

        QueryWrapper queryWrapper2=new QueryWrapper();
        queryWrapper2.eq("busparticipant","张三");
       int count1=businessMapper.selectList(queryWrapper2).size();
        if(count1>0){
            businessUtils.setCanyu(count1);
        }else{
            businessUtils.setCanyu(0);
        }

        QueryWrapper queryWrapper3=new QueryWrapper();
        queryWrapper3.eq("busfocus","张三");
        int count2=businessMapper.selectList(queryWrapper3).size();
        if(count2>0){
            businessUtils.setGuanzhu(count2);
        }else{
            businessUtils.setGuanzhu(0);
        }



        QueryWrapper queryWrapper4=new QueryWrapper();
            queryWrapper4.isNull("lastdate");
            queryWrapper4.apply("date_sub(curdate(), INTERVAL 7 DAY) <= date(busdate)");
            queryWrapper4.eq("busprincipal","张三");
            int count3=businessMapper.selectList(queryWrapper4).size();
            if(count3>0){
                businessUtils.setQi(count3);
            }else{
                businessUtils.setQi(0);
            }


        QueryWrapper queryWrapper5=new QueryWrapper();
        queryWrapper5.isNull("lastdate");
        queryWrapper5.apply("date_sub(curdate(), INTERVAL 30 DAY) <= date(busdate)");
        queryWrapper5.eq("busprincipal","张三");
        int count4=businessMapper.selectList(queryWrapper5).size();
        if(count4>0){
            businessUtils.setSanshi(count4);
        }else{
            businessUtils.setSanshi(0);
        }

        QueryWrapper queryWrapper6=new QueryWrapper();
        queryWrapper6.isNull("lastdate");
        queryWrapper6.apply("date_sub(curdate(), INTERVAL 90 DAY) <= date(busdate)");
        queryWrapper6.eq("busprincipal","张三");
        int count5=businessMapper.selectList(queryWrapper6).size();
        if(count5>0){
            businessUtils.setJiushi(count5);
        }else{
            businessUtils.setJiushi(0);
        }

        QueryWrapper queryWrapper7=new QueryWrapper();
            queryWrapper7.apply("YEARWEEK(date_format(busdate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)");
            queryWrapper7.eq("busprincipal","张三");
            int count6=businessMapper.selectList(queryWrapper7).size();
            if(count6>0){
                businessUtils.setBenzhou(count6);
            }else{
                businessUtils.setBenzhou(0);
            }

        QueryWrapper queryWrapper8=new QueryWrapper();
        queryWrapper8.apply("YEARWEEK(date_format(busdate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1");
        queryWrapper8.eq("busprincipal","张三");
        int count7=businessMapper.selectList(queryWrapper8).size();
        if(count7>0){
            businessUtils.setShangzhou(count7);
        }else{
            businessUtils.setShangzhou(0);
        }

        QueryWrapper queryWrapper9=new QueryWrapper();
        queryWrapper9.apply("date_format(busdate,'%Y-%m')=date_format(now(),'%Y-%m')");
        queryWrapper9.eq("busprincipal","张三");
        int count8=businessMapper.selectList(queryWrapper9).size();
        if(count8>0){
            businessUtils.setBenyue(count8);
        }else{
            businessUtils.setBenyue(0);
        }

        QueryWrapper queryWrapper10=new QueryWrapper();
        queryWrapper10.apply("date_format(busdate,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m')");
        queryWrapper10.eq("busprincipal","张三");
            int count9=businessMapper.selectList(queryWrapper10).size();
            if(count9>0){
                businessUtils.setShangyue(count9);
            }else{
                businessUtils.setShangyue(0);
            }


        QueryWrapper queryWrapper11=new QueryWrapper();
        queryWrapper11.apply("YEAR(busdate)=YEAR(now()) AND QUARTER(busdate) = QUARTER(NOW())");
        queryWrapper11.eq("busprincipal","张三");
            int count10=businessMapper.selectList(queryWrapper11).size();
            if(count10>0){
                businessUtils.setBenjidu(count10);
            }else{
                businessUtils.setBenjidu(0);
            }

            QueryWrapper queryWrapper12=new QueryWrapper();
             queryWrapper12.apply("YEAR(busdate)=YEAR(now()) AND  QUARTER(busdate)=QUARTER(DATE_SUB(now(),interval 1 QUARTER))");
             queryWrapper12.eq("busprincipal","张三");
            int count11=businessMapper.selectList(queryWrapper12).size();
            if(count11>0){
                businessUtils.setShangjidu(count11);
            }else{
                businessUtils.setShangjidu(0);
            }

            QueryWrapper queryWrapper13=new QueryWrapper();
        queryWrapper13.eq("busiphase","成交");
        queryWrapper13.eq("busprincipal","张三");
        int count12=businessMapper.selectList(queryWrapper13).size();
        if(count12>0){
            businessUtils.setChengjiao(count12);
        }else{
            businessUtils.setChengjiao(0);
        }

        QueryWrapper queryWrapper14=new QueryWrapper();
        queryWrapper14.eq("busiphase","丢单");
        queryWrapper14.eq("busprincipal","张三");
        int count13=businessMapper.selectList(queryWrapper14).size();
        if(count13>0){
            businessUtils.setDiudan(count13);
        }else{
            businessUtils.setDiudan(0);
        }

        QueryWrapper queryWrapper15=new QueryWrapper();
        queryWrapper15.eq("busiphase","搁置");
        queryWrapper15.eq("busprincipal","张三");
        int count14=businessMapper.selectList(queryWrapper15).size();
        if(count14>0){
            businessUtils.setGezhi(count14);
        }else{
            businessUtils.setGezhi(0);
        }

        return businessUtils;
    };

    @Override
    public BusinessUtils allBusinessQueryCount(){
        BusinessUtils businessUtils=new BusinessUtils();
        QueryWrapper queryWrapper3=new QueryWrapper();
        queryWrapper3.in("busiphase","初期沟通","方案和报价","竞争或投标","商务谈判");
        int count2=businessMapper.selectList(queryWrapper3).size();
        if(count2>0){
            businessUtils.setJingxingzhong(count2);
        }else{
            businessUtils.setJingxingzhong(0);
        }



        QueryWrapper queryWrapper4=new QueryWrapper();
        queryWrapper4.isNull("lastdate");
        queryWrapper4.apply("date_sub(curdate(), INTERVAL 7 DAY) <= date(busdate)");
        int count3=businessMapper.selectList(queryWrapper4).size();
        if(count3>0){
            businessUtils.setQi(count3);
        }else{
            businessUtils.setQi(0);
        }


        QueryWrapper queryWrapper5=new QueryWrapper();
        queryWrapper5.isNull("lastdate");
        queryWrapper5.apply("date_sub(curdate(), INTERVAL 30 DAY) <= date(busdate)");
        int count4=businessMapper.selectList(queryWrapper5).size();
        if(count4>0){
            businessUtils.setSanshi(count4);
        }else{
            businessUtils.setSanshi(0);
        }

        QueryWrapper queryWrapper6=new QueryWrapper();
        queryWrapper6.isNull("lastdate");
        queryWrapper6.apply("date_sub(curdate(), INTERVAL 90 DAY) <= date(busdate)");
        int count5=businessMapper.selectList(queryWrapper6).size();
        if(count5>0){
            businessUtils.setJiushi(count5);
        }else{
            businessUtils.setJiushi(0);
        }

        QueryWrapper queryWrapper7=new QueryWrapper();
        queryWrapper7.apply("YEARWEEK(date_format(busdate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)");
        int count6=businessMapper.selectList(queryWrapper7).size();
        if(count6>0){
            businessUtils.setBenzhou(count6);
        }else{
            businessUtils.setBenzhou(0);
        }

        QueryWrapper queryWrapper8=new QueryWrapper();
        queryWrapper8.apply("YEARWEEK(date_format(busdate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1");
        int count7=businessMapper.selectList(queryWrapper8).size();
        if(count7>0){
            businessUtils.setShangzhou(count7);
        }else{
            businessUtils.setShangzhou(0);
        }

        QueryWrapper queryWrapper9=new QueryWrapper();
        queryWrapper9.apply("date_format(busdate,'%Y-%m')=date_format(now(),'%Y-%m')");
        int count8=businessMapper.selectList(queryWrapper9).size();
        if(count8>0){
            businessUtils.setBenyue(count8);
        }else{
            businessUtils.setBenyue(0);
        }

        QueryWrapper queryWrapper10=new QueryWrapper();
        queryWrapper10.apply("date_format(busdate,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m')");
        int count9=businessMapper.selectList(queryWrapper10).size();
        if(count9>0){
            businessUtils.setShangyue(count9);
        }else{
            businessUtils.setShangyue(0);
        }


        QueryWrapper queryWrapper11=new QueryWrapper();
        queryWrapper11.apply("YEAR(busdate)=YEAR(now()) AND QUARTER(busdate) = QUARTER(NOW())");
        int count10=businessMapper.selectList(queryWrapper11).size();
        if(count10>0){
            businessUtils.setBenjidu(count10);
        }else{
            businessUtils.setBenjidu(0);
        }

        QueryWrapper queryWrapper12=new QueryWrapper();
        queryWrapper12.apply("YEAR(busdate)=YEAR(now()) AND  QUARTER(busdate)=QUARTER(DATE_SUB(now(),interval 1 QUARTER))");
        int count11=businessMapper.selectList(queryWrapper12).size();
        if(count11>0){
            businessUtils.setShangjidu(count11);
        }else{
            businessUtils.setShangjidu(0);
        }

        QueryWrapper queryWrapper13=new QueryWrapper();
        queryWrapper13.eq("busiphase","成交");
        int count12=businessMapper.selectList(queryWrapper13).size();
        if(count12>0){
            businessUtils.setChengjiao(count12);
        }else{
            businessUtils.setChengjiao(0);
        }

        QueryWrapper queryWrapper14=new QueryWrapper();
        queryWrapper14.eq("busiphase","丢单");
        int count13=businessMapper.selectList(queryWrapper14).size();
        if(count13>0){
            businessUtils.setDiudan(count13);
        }else{
            businessUtils.setDiudan(0);
        }

        QueryWrapper queryWrapper15=new QueryWrapper();
        queryWrapper15.eq("busiphase","搁置");
        int count14=businessMapper.selectList(queryWrapper15).size();
        if(count14>0){
            businessUtils.setGezhi(count14);
        }else{
            businessUtils.setGezhi(0);
        }


        return businessUtils;
    };

    @Override
    public IPage getBusinessByCid(Page page, Business business,Integer cid){
        if(null==cid){
            return null;
        }else{
            if(//查询所有

                    (null==business.getBusiphase() || "".equals(business.getBusiphase())) &&
                            (null==business.getBusname() || "".equals(business.getBusname())) &&
                            (null==business.getBusprincipal() || "".equals(business.getBusprincipal())) &&
                            (null==business.getBusdept() || "".equals(business.getBusdept())) &&
                            (null==business.getMaymoney() || "".equals(business.getMaymoney())) &&
                            (null==business.getMaydate() || "".equals(business.getMaydate()))
            ){
                QueryWrapper queryWrapper=new QueryWrapper();
                queryWrapper.eq("clientid",cid);
                return  businessMapper.selectPage(page,queryWrapper);

            }else{ //form表单多条件拼接查询（通用）
                QueryWrapper queryWrapper=new QueryWrapper();
                if(!StringUtils.isNullOrEmpty(business.getBusname())){
                    queryWrapper.like("busname",business.getBusname());
                }
                if(!StringUtils.isNullOrEmpty(business.getBusprincipal())){
                    queryWrapper.eq("busprincipal",business.getBusprincipal());
                }
                if(!StringUtils.isNullOrEmpty(business.getBusdept())){
                    queryWrapper.eq("busdept",business.getBusdept());
                }
                if(null!=business.getMaymoney()){
                    queryWrapper.eq("maymoney",business.getMaymoney());
                }
                if(null!=(business.getMaydate())){
                    queryWrapper.eq("maydate",business.getMaydate());
                }
                queryWrapper.eq("clientid",cid);
               return  businessMapper.selectPage(page,queryWrapper);
            }

        }
    };




}
