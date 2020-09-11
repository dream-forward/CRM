package com.hy.crm.system.alldiscussionposts.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.hy.crm.system.alldiscussionposts.pojo.Forum;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crm.system.alldiscussionposts.pojo.ForumBo;

import java.util.List;

/**
 * <p>
 * 帖子表 服务类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
public interface IForumService extends IService<Forum> {

    /**
     * 联合查询查询所有
     */
    public List<ForumBo> QueryForumBo(Page page,int selects, String inputs);

    /**
     * 添加帖子
     */
    public Integer InsertForum(Forum forum);

    /**
     * 修改帖子
     */
    public Integer UpdateForum(Forum forum);


}
