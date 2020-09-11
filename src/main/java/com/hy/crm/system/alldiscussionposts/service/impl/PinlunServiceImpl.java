package com.hy.crm.system.alldiscussionposts.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hy.crm.system.alldiscussionposts.pojo.Forum;
import com.hy.crm.system.alldiscussionposts.pojo.Pinlun;
import com.hy.crm.system.alldiscussionposts.mapper.PinlunMapper;
import com.hy.crm.system.alldiscussionposts.service.IPinlunService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class PinlunServiceImpl extends ServiceImpl<PinlunMapper, Pinlun> implements IPinlunService {

    @Autowired
    private PinlunMapper pinlunMapper;

    @Override
    public Integer InsertPinlun(Pinlun pinlun) {
        return pinlunMapper.insert(pinlun);
    }

    @Override
    public Integer UpdatePinlun(Pinlun pinlun) {
        UpdateWrapper<Pinlun> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("pingid",pinlun.getPingid());
        return pinlunMapper.update(pinlun,updateWrapper);
    }
}
