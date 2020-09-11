package com.hy.crm.system.alldiscussionposts.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.Page;
import com.hy.crm.system.alldiscussionposts.pojo.Forum;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crm.system.alldiscussionposts.pojo.ForumBo;
import com.hy.crm.system.alldiscussionposts.pojo.LikeSql;
import com.hy.crm.test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 * 帖子表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Mapper
public interface ForumMapper extends BaseMapper<Forum> {


    @SelectProvider(type= LikeSql.class,method="select1")
    public List<ForumBo> QueryForumBo(Page page,int selects, String inputs);


}
