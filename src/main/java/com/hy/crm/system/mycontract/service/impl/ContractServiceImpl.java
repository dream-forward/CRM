package com.hy.crm.system.mycontract.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.hy.crm.system.mycontract.mapper.ContractMapper;
import com.hy.crm.system.mycontract.service.IContractService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crm.system.mydocumentary.pojo.JsonTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public JsonTable LikeContract(int limit, int page, int selects, String inputs) {
        JsonTable jsonTable = new JsonTable();
        IPage iPage = new Page<Contract>(page, limit);
        QueryWrapper<Contract> queryWrapper = new QueryWrapper<>();
//        if (selects == 1){
//            queryWrapper.like("docuser",inputs);
//        }else if (selects == 2){
//            queryWrapper.like("doctime",inputs);
//        }else
//        if (selects == 3){
//            queryWrapper.like("docsubject",inputs);
//        }
        IPage iPage1 = contractMapper.selectPage(iPage,queryWrapper);
        jsonTable.setData(iPage1.getRecords());
        jsonTable.setCount((int)iPage1.getTotal());
        jsonTable.setCode(0);
        jsonTable.setMsg("查询成功");
        return jsonTable;
    }
}
