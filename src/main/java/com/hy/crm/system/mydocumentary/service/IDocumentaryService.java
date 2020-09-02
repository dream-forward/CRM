package com.hy.crm.system.mydocumentary.service;

import com.hy.crm.system.mydocumentary.pojo.Documentary;
import com.baomidou.mybatisplus.extension.service.IService;

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
     * 根据跟单时间模糊查询
     * @param documentary
     * @return
     */
    public List<Documentary> LikeDocumentary(int selects,Documentary documentary);

//    /**
//     * 根据跟单主题模糊查询
//     * @param documentary
//     * @return
//     */
//    public List<Documentary> LikeDocSubject(Documentary documentary);
//
//    /**
//     * 根据跟单人模糊查询
//     * @param documentary
//     * @return
//     */
//    public List<Documentary> LikeDocUser(Documentary documentary);



}
