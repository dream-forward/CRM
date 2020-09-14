package com.hy.crm.system.mycontract.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public List<ContractBo> QueryContractBo(Page page,int selectss, String inputss){
        return contractMapper.QueryContractBo(page,selectss,inputss);
    }

    @Override
    public List<ContractBo> queryContractByCid(Page page, Integer selectss, String inputss,Integer cid){
        List<ContractBo> contractBoList=contractMapper.queryContractByCid(page,selectss,inputss,cid);
        return contractBoList;
}



}
