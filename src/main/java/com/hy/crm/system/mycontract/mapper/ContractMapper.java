package com.hy.crm.system.mycontract.mapper;

import com.github.pagehelper.Page;
import com.hy.crm.system.alldiscussionposts.pojo.LikeSql;
import com.hy.crm.system.mycontract.pojo.Contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.system.mycontract.pojo.ContractBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * 合同表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Mapper
public interface ContractMapper extends BaseMapper<Contract> {

    @SelectProvider(type= LikeSql.class,method="select2")
    public List<ContractBo> QueryContractBo(Page page,int selectss, String inputss);


}
