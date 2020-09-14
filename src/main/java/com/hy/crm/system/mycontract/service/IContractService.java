package com.hy.crm.system.mycontract.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.hy.crm.system.alldiscussionposts.pojo.Forum;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.hy.crm.system.mycontract.pojo.ContractBo;

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


    public List<ContractBo> QueryContractBo(Page page,int selectss, String inputss,Contract contract);

    public List<ContractBo> queryContractByCid(Page page, Integer selectss, String inputss,Integer cid);

    public IPage QueryContractByTime(String flag, int page, int limit);

    public IPage queryContract(String name,String value, int page, int limit);

    public Integer UpdateContract(Contract contract);
}
