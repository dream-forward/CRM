package com.hy.crm.system.mydocumentary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.system.mydocumentary.pojo.Documentary;
import com.hy.crm.system.mydocumentary.mapper.DocumentaryMapper;
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

    @Override
    public List<Documentary> LikeDocumentary(int selects,Documentary documentary) {
        QueryWrapper<Documentary> queryWrapper = new QueryWrapper<>();
//        System.out.println("000000"+ selects);
//        if (selects == 1){
//            System.out.println("111111111111"+ selects);
//            if(documentary.getDocuser() != null && documentary.getDocuser() != ""){
//                queryWrapper.like("docuser",documentary.getDocuser());
//            }
//        }else if (selects == 2){
//            System.out.println("22222"+ selects);
//            if(documentary.getDoctime() != null){
//                queryWrapper.like("doctime",documentary.getDoctime());
//            }
//        }else
//            if (selects == 3){
//            System.out.println("3333333"+ selects);
//            if(documentary.getDocsubject() != null && documentary.getDocsubject() != ""){
//                queryWrapper.like("docsubject",documentary.getDocsubject());
//            }
//        }
        return documentaryMapper.selectList(queryWrapper);
    }


}
