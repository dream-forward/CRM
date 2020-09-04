package com.hy.crm.system.mydocumentary.mapper;

import com.hy.crm.system.mydocumentary.pojo.Documentary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 跟单表 Mapper 接口
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Mapper
public interface DocumentaryMapper extends BaseMapper<Documentary> {

    /**
     * 根据商机ID查询
     */
    @Select("select * from documentary where busiid = #{busiid}")
    public List<Documentary> QueryDocumentaryByid(Integer busiid);
}
