package com.hy.crm.system.mycontract.service;

import com.github.pagehelper.Page;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.system.mycontract.pojo.ContractBo;
import com.hy.crm.system.mydocumentary.pojo.JsonTable;

import java.util.List;

/**
 * <p>
 * 合同表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IContractService extends IService<Contract> {


    public List<ContractBo> QueryContractBo(Page page,int selectss, String inputss);



}
