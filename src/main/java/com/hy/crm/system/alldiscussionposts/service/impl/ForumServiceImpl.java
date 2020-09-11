package com.hy.crm.system.alldiscussionposts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.hy.crm.system.alldiscussionposts.pojo.Forum;
import com.hy.crm.system.alldiscussionposts.mapper.ForumMapper;
import com.hy.crm.system.alldiscussionposts.pojo.ForumBo;
import com.hy.crm.system.alldiscussionposts.service.IForumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 帖子表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class ForumServiceImpl extends ServiceImpl<ForumMapper, Forum> implements IForumService {

    @Autowired
    private ForumMapper forumMapper;

    /**
     * 联合查询查询所有
     */
    @Override
    public List<ForumBo> QueryForumBo(Page page,int selects, String inputs) {
        return forumMapper.QueryForumBo(page,selects,inputs);
    }

    /**
     * 添加帖子
     */
    @Override
    public Integer InsertForum(Forum forum) {
        return forumMapper.insert(forum);
    }

    /**
     * 修改帖子
     */
    @Override
    public Integer UpdateForum(Forum forum) {
        UpdateWrapper<Forum> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("forid",forum.getForid());
        return forumMapper.update(forum,updateWrapper);
    }
}
