package com.hy.crm.system.customermanager.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.system.aftersalesservice.mapper.AftersalesMapper;
import com.hy.crm.system.aftersalesservice.pojo.Aftersales;
import com.hy.crm.system.customermanager.bo.ClientBo;
import com.hy.crm.system.customermanager.mapper.ClientinfoMapper;
import com.hy.crm.system.customermanager.pojo.Clientinfo;
import com.hy.crm.system.customermanager.service.IClientinfoService;
import com.hy.crm.system.mybusiness.mapper.BusinessMapper;
import com.hy.crm.system.mybusiness.pojo.Business;
import com.hy.crm.system.mycontract.mapper.ContractMapper;
import com.hy.crm.system.mycontract.mapper.IncomeMapper;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.hy.crm.system.mycontract.pojo.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 客户信息表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class ClientinfoServiceImpl extends ServiceImpl<ClientinfoMapper, Clientinfo> implements IClientinfoService {
    @Autowired
    private ClientinfoMapper clientinfoMapper;
    @Autowired
    private BusinessMapper businessMapper;
    @Autowired
    private ContractMapper contractMapper;
    @Autowired
    private AftersalesMapper aftersalesMapper;
    @Autowired
    private IncomeMapper incomeMapper;
    @Override
    public IPage queryByLike(Page page, String did, String valu){
        IPage iPage=null;
        //查询所有客户
        if(null==did || "0".equals(did) && "".equals(valu) || null==valu ){
            iPage=clientinfoMapper.selectPage(page,null);
        }else{ //按条件查询客户
            QueryWrapper queryWrappe=new QueryWrapper<>();
            if("1001".equals(did) || "0".equals(did)){
                queryWrappe.like("cliname",valu);
            }else if("1002".equals(did)){
                queryWrappe.like("clipingyin",valu);
            }else if("1003".equals(did)){
                queryWrappe.like("clifrom",valu);
            }else if("1004".equals(did)){
                queryWrappe.like("clicountry",valu);
            }else if("1005".equals(did)){
                queryWrappe.like("clicity",valu);
            }else if("1006".equals(did)){
                queryWrappe.like("cliindustry",valu);
            }
            iPage=clientinfoMapper.selectPage(page,queryWrappe);
        }
        List<Clientinfo> listcli=iPage.getRecords();
        List<ClientBo> clientBoList=new ArrayList<>();
        if(null!=listcli){
            for(Clientinfo clientinfo:listcli){
                ClientBo clientBo=new ClientBo();
                clientBo.setCliid(clientinfo.getCliid());
                clientBo.setClientname(clientinfo.getCliname());
                QueryWrapper queryWrapper1=new QueryWrapper();
                queryWrapper1.eq("clientid",clientinfo.getCliid());
                List<Business> businessList=businessMapper.selectList(queryWrapper1);

                clientBo.setBuscount(businessList.size());

                BigDecimal allmoney = new BigDecimal("0.00");
                for(Business business:businessList){
                    allmoney=allmoney.add(business.getMaymoney());
                }

                clientBo.setSummoney(allmoney);

                QueryWrapper queryWrapper2=new QueryWrapper();
                queryWrapper2.eq("clientid",clientinfo.getCliid());
                List<Contract> contractList=contractMapper.selectList(queryWrapper2);

                clientBo.setConcount(contractList.size());

                BigDecimal allmoney1=new BigDecimal("0.00");
                for(Contract contract:contractList){
                    allmoney1=allmoney1.add(contract.getConmoney());
                }

                clientBo.setSumcon(allmoney1);

                BigDecimal lastMoney=getBackMoney(contractList);
                System.out.println("当前客户收入总额："+lastMoney);
                clientBo.setIncmoneyall(lastMoney);
                QueryWrapper queryWrapper3=new QueryWrapper();
                queryWrapper3.eq("clientname",clientinfo.getCliid());
                List<Aftersales> aftersalesList=aftersalesMapper.selectList(queryWrapper3);
                System.out.println("当前客户售后服务数："+aftersalesList.size());

                clientBo.setAfterCount(aftersalesList.size());

                int i=0;
                for(Aftersales aftersales:aftersalesList){
                   i+=aftersales.getServicecore();
                }

                String q = new DecimalFormat("0.0").format((float)i/aftersalesList.size());
                System.out.println("当前客户服务均分："+q);

                clientBo.setAvgservicecore(q);

                clientBoList.add(clientBo);
               System.out.println("-----------------"+clientBo);
            }
            System.out.println("最后最后最后+"+clientBoList.size());
            iPage.setRecords(clientBoList);
            return iPage;
        }
            return null;
    }

public BigDecimal getBackMoney(List<Contract> contractList){
        System.out.println("jinnjinsniida");
        BigDecimal lastMoney=new BigDecimal("0.00");
        for(Contract contract:contractList){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("contid",contract.getConnum());
           List<Income> incomeList=incomeMapper.selectList(queryWrapper);
           BigDecimal bigDecimal=new BigDecimal("0.00");
           for(Income income:incomeList){
               bigDecimal=bigDecimal.add(income.getIncmoney());
           }
           System.out.println("------------"+bigDecimal);
            lastMoney=lastMoney.add(bigDecimal);
        }
        return lastMoney;
}

}
