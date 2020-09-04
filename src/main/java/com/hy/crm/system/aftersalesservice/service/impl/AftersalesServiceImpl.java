package com.hy.crm.system.aftersalesservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.system.aftersalesservice.pojo.Aftersales;
import com.hy.crm.system.aftersalesservice.mapper.AftersalesMapper;
import com.hy.crm.system.aftersalesservice.service.IAftersalesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 售后服务表 服务实现类
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@Service
public class AftersalesServiceImpl extends ServiceImpl<AftersalesMapper, Aftersales> implements IAftersalesService {

    @Autowired
    private AftersalesMapper aftersalesMapper;
    @Override
    public IPage queryAfterSales(Aftersales aftersales, int page, int limit) {
        if(null == aftersales){

        }else {
            QueryWrapper wrapper = new QueryWrapper<>();
            //判断输入主题不为空
            if(null != aftersales.getAssubject() && "".equals(aftersales.getAssubject())){
                wrapper.eq("assubject",aftersales.getAssubject());//主题

            }
            Page<Aftersales> page1= new Page<>(page,limit);
             IPage iPage = aftersalesMapper.selectPage(page1,wrapper);
            return iPage;
        }
        return null;
    }
}
