package com.hy.crm.system.mydocumentary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.system.mydocumentary.pojo.Documentary;
import com.hy.crm.system.mydocumentary.mapper.DocumentaryMapper;
import com.hy.crm.system.mydocumentary.pojo.JsonTable;
import com.hy.crm.system.mydocumentary.service.IDocumentaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 跟单表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service("documentaryService")
public class DocumentaryServiceImpl extends ServiceImpl<DocumentaryMapper, Documentary> implements IDocumentaryService {

    @Autowired
    private DocumentaryMapper documentaryMapper;



    /**
     * 模糊查询 and 查询所有
     */
    @Override
    public JsonTable LikeDocumentary(int limit, int page, int selects, String inputs) {
        JsonTable jsonTable = new JsonTable();
        IPage iPage = new Page<Documentary>(page, limit);
        QueryWrapper<Documentary> queryWrapper = new QueryWrapper<>();
        if (selects == 1 && inputs != null && inputs.equals("")){
                queryWrapper.like("docuser",inputs);
        }else if (selects == 2 && inputs != null && inputs.equals("")){
                queryWrapper.like("doctime",inputs);
        }else
            if (selects == 3 && inputs != null && inputs.equals("")){
                queryWrapper.like("docsubject",inputs);
        }
        IPage iPage1 = documentaryMapper.selectPage(iPage,queryWrapper);
        jsonTable.setData(iPage1.getRecords());
        jsonTable.setCount((int)iPage1.getTotal());
        jsonTable.setCode(0);
        jsonTable.setMsg("查询成功");
        return jsonTable;
    }


    /**
     * 新增跟单
     */
    @Override
    public Integer InsertDocumentary(Documentary documentary) {
        return documentaryMapper.insert(documentary);
    }

    /**
     * 修改跟单
     */
    @Override
    public Integer UpdateDocumentary(Documentary documentary) {
        UpdateWrapper<Documentary> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("docid",documentary.getDocid());
        return documentaryMapper.update(documentary,updateWrapper);
    }

}
