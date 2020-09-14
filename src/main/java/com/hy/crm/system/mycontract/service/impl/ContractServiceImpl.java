package com.hy.crm.system.mycontract.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.Page;
import com.hy.crm.system.mycontract.mapper.ContractMapper;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.hy.crm.system.mycontract.pojo.ContractBo;
import com.hy.crm.system.mycontract.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 合同表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract> implements IContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public List<ContractBo> QueryContractBo(Page page,int selectss, String inputss,Contract contract){
        return contractMapper.QueryContractBo(page,selectss,inputss,contract);
    }

    @Override
    public IPage QueryContractByTime(String flag, int page, int limit) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Contract> page1 = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(page,limit);
        QueryWrapper<Contract> queryWrapper = new QueryWrapper<>();
        IPage iPage = null;
        //如果传过来的字符串等于This-week-the-new（作用于表格数据展示）或者等于-This-week-the-new（作用于统计数量）
        if ("This-week-the-new".equals(flag) || "-This-week-the-new".equals(flag)) {
            queryWrapper.apply("YEARWEEK(date_format(begindate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)");
            iPage = contractMapper.selectPage(page1, queryWrapper);
        } else if ("Last-week-the-new".equals(flag) || "-Last-week-the-new".equals(flag)) {
            queryWrapper.apply("YEARWEEK(date_format(begindate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1");
            iPage = contractMapper.selectPage(page1, queryWrapper);
        } else if ("This-month-the-new".equals(flag) || "-This-month-the-new".equals(flag)) {
            queryWrapper.apply("date_format(begindate,'%Y-%m')=date_format(now(),'%Y-%m')");
            iPage = contractMapper.selectPage(page1, queryWrapper);
        } else if ("Last-month-the-new".equals(flag) || "-Last-month-the-new".equals(flag)) {
            queryWrapper.apply("date_format(begindate,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m')");
            iPage = contractMapper.selectPage(page1, queryWrapper);
        } else if ("This-quarter-the-new".equals(flag) || "-This-quarter-the-new".equals(flag)) {
            queryWrapper.apply("YEAR(begindate)=YEAR(now()) AND QUARTER(begindate) = QUARTER(NOW())");
            iPage = contractMapper.selectPage(page1, queryWrapper);
        } else if ("Last-quarter-the-new".equals(flag) || "-Last-quarter-the-new".equals(flag)) {
            queryWrapper.apply("YEAR(begindate)=YEAR(now()) AND  QUARTER(begindate)=QUARTER(DATE_SUB(now(),interval 1 QUARTER))");
            iPage = contractMapper.selectPage(page1, queryWrapper);
        }
        return iPage;
    }

    @Override
    public List<ContractBo> queryContractByCid(Page page, Integer selectss, String inputss,Integer cid){
        List<ContractBo> contractBoList=contractMapper.queryContractByCid(page,selectss,inputss,cid);
        return contractBoList;
}


    @Override
    public IPage queryContract(String name, String value, int page, int limit) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Contract> page1 = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(page,limit);
        //如果参数为空查询所有
        if (StringUtils.isEmpty(name) && StringUtils.isEmpty(value)) {
            return contractMapper.selectPage(page1, null);
        } else {
            QueryWrapper wrapper = new QueryWrapper<>();
            wrapper.like(name, value);//主题
            IPage iPage = contractMapper.selectPage(page1, wrapper);
            return iPage;
        }
    }

    @Override
    public Integer UpdateContract(Contract contract) {
        UpdateWrapper<Contract> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("conid",contract.getConid());
        return contractMapper.update(contract,updateWrapper);
    }

}
