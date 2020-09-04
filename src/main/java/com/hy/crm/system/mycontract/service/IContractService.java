package com.hy.crm.system.mycontract.service;

import com.hy.crm.system.mycontract.pojo.Contract;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.system.mydocumentary.pojo.JsonTable;

/**
 * <p>
 * 合同表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IContractService extends IService<Contract> {

    /**
     * 模糊查询 and 查询所有
     */
    public JsonTable LikeContract(int limit, int page, int selects, String inputs);
}
