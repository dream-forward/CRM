package com.hy.crm.system.aftersalesservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.crm.system.aftersalesservice.pojo.Aftersales;
import com.hy.crm.system.aftersalesservice.mapper.AftersalesMapper;
import com.hy.crm.system.aftersalesservice.service.IAftersalesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 售后服务表 服务实现类
 * </p>
 *
 * @author ll
 * @since 2020-08-28
 */
@Service
public class AftersalesServiceImpl extends ServiceImpl<AftersalesMapper, Aftersales> implements IAftersalesService {

    @Autowired
    private AftersalesMapper aftersalesMapper;

    /**
     * 查询售后服务信息（模糊+分页）
     *
     * @param name
     * @param value
     * @param page
     * @param limit
     * @return
     */
    @Override
    public IPage queryAfterSales(String name, String value, int page, int limit) {
        Page<Aftersales> page1 = new Page<>(page, limit);
        //如果参数为空查询所有
        if (StringUtils.isEmpty(name) && StringUtils.isEmpty(value)) {
            return aftersalesMapper.selectPage(page1, null);
        } else {
            QueryWrapper wrapper = new QueryWrapper<>();
            wrapper.like(name, value);//主题
            IPage iPage = aftersalesMapper.selectPage(page1, wrapper);
            return iPage;
        }
    }

    @Override
    public IPage queryAftersalesByTime(String flag, int page, int limit) {
        Page<Aftersales> page1 = new Page<>(page, limit);
        QueryWrapper<Aftersales> wrapper = new QueryWrapper<>();
        IPage iPage = null;
        //如果传过来的字符串等于This-week-the-new（作用于表格数据展示）或者等于-This-week-the-new（作用于统计数量）
        if ("This-week-the-new".equals(flag) || "-This-week-the-new".equals(flag)) {
            wrapper.apply("YEARWEEK(date_format(beginservicedate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)");
            iPage = aftersalesMapper.selectPage(page1, wrapper);
        } else if ("Last-week-the-new".equals(flag) || "-Last-week-the-new".equals(flag)) {
            wrapper.apply("YEARWEEK(date_format(beginservicedate,'%Y-%m-%d'),1) = YEARWEEK(now(),1)-1");
            iPage = aftersalesMapper.selectPage(page1, wrapper);
        } else if ("This-month-the-new".equals(flag) || "-This-month-the-new".equals(flag)) {
            wrapper.apply("date_format(beginservicedate,'%Y-%m')=date_format(now(),'%Y-%m')");
            iPage = aftersalesMapper.selectPage(page1, wrapper);
        } else if ("Last-month-the-new".equals(flag) || "-Last-month-the-new".equals(flag)) {
            wrapper.apply("date_format(beginservicedate,'%Y-%m')=date_format(DATE_SUB(curdate(), INTERVAL 1 MONTH),'%Y-%m')");
            iPage = aftersalesMapper.selectPage(page1, wrapper);
        } else if ("This-quarter-the-new".equals(flag) || "-This-quarter-the-new".equals(flag)) {
            wrapper.apply("YEAR(beginservicedate)=YEAR(now()) AND QUARTER(beginservicedate) = QUARTER(NOW())");
            iPage = aftersalesMapper.selectPage(page1, wrapper);
        } else if ("Last-quarter-the-new".equals(flag) || "-Last-quarter-the-new".equals(flag)) {
            wrapper.apply("YEAR(beginservicedate)=YEAR(now()) AND  QUARTER(beginservicedate)=QUARTER(DATE_SUB(now(),interval 1 QUARTER))");
            iPage = aftersalesMapper.selectPage(page1, wrapper);
        }
        return iPage;
    }
}
