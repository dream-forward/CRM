package com.hy.crm.system.mydocumentary.service;

import com.hy.crm.system.mydocumentary.pojo.Documentary;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.system.mydocumentary.pojo.JsonTable;

import java.util.List;

/**
 * <p>
 * 跟单表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IDocumentaryService extends IService<Documentary> {

    /**
     * 模糊查询 and 查询所有
     */
    public JsonTable LikeDocumentary(int limit, int page, int selects, String inputs);

    /**
     * 查询所有
     */
    public List<Documentary> QueryDocumentary();

    /**
     * 根据商机ID查询
     */
    public List<Documentary> QueryDocumentaryByid(Integer busiid);

    /**
     * 新增跟单
     */
    public int InsertDocumentary(Documentary documentary);


}
