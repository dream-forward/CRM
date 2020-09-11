package com.hy.crm.system.statisticalanalysis.bo;

/**
 * @Author : Administrator
 * @Date : 2020/9/10 15:41
 * @Description :根据时间统计商机情况
 */
public class StatisticsByTime {
    //用户id
    private Integer userId;
    //用户名称
    private String userName;
    //商机本周
    private Integer businessThisWeek;
    //商机上周
    private Integer businessLastWeek;
    //成交本周
    private Integer accomplishThisWeek;
    //成交上周
    private Integer accomplishLastWeek;
    //跟单本
    private Integer documentaryThisWeek;
    //跟单上
    private Integer documentaryLastWeek;
    //合同本
    private Integer contractThisWeek;
    //合同上
    private Integer contractLastWeek;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getBusinessThisWeek() {
        return businessThisWeek;
    }

    public void setBusinessThisWeek(Integer businessThisWeek) {
        this.businessThisWeek = businessThisWeek;
    }

    public Integer getBusinessLastWeek() {
        return businessLastWeek;
    }

    public void setBusinessLastWeek(Integer businessLastWeek) {
        this.businessLastWeek = businessLastWeek;
    }

    public Integer getAccomplishThisWeek() {
        return accomplishThisWeek;
    }

    public void setAccomplishThisWeek(Integer accomplishThisWeek) {
        this.accomplishThisWeek = accomplishThisWeek;
    }

    public Integer getAccomplishLastWeek() {
        return accomplishLastWeek;
    }

    public void setAccomplishLastWeek(Integer accomplishLastWeek) {
        this.accomplishLastWeek = accomplishLastWeek;
    }

    public Integer getDocumentaryThisWeek() {
        return documentaryThisWeek;
    }

    public void setDocumentaryThisWeek(Integer documentaryThisWeek) {
        this.documentaryThisWeek = documentaryThisWeek;
    }

    public Integer getDocumentaryLastWeek() {
        return documentaryLastWeek;
    }

    public void setDocumentaryLastWeek(Integer documentaryLastWeek) {
        this.documentaryLastWeek = documentaryLastWeek;
    }

    public Integer getContractThisWeek() {
        return contractThisWeek;
    }

    public void setContractThisWeek(Integer contractThisWeek) {
        this.contractThisWeek = contractThisWeek;
    }

    public Integer getContractLastWeek() {
        return contractLastWeek;
    }

    public void setContractLastWeek(Integer contractLastWeek) {
        this.contractLastWeek = contractLastWeek;
    }
}
