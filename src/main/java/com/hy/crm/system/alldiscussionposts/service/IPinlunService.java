package com.hy.crm.system.alldiscussionposts.service;

import com.hy.crm.system.alldiscussionposts.pojo.Pinlun;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IPinlunService extends IService<Pinlun> {

    /**
     * 添加评论
     */
    public Integer InsertPinlun(Pinlun pinlun);

    /**
     * 修改评论
     */
    public Integer UpdatePinlun(Pinlun pinlun);
}
