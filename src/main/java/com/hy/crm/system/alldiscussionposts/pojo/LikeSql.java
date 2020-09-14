package com.hy.crm.system.alldiscussionposts.pojo;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public class LikeSql {


    public String select1(Page page, int selects, String inputs) {
        StringBuffer sql = new StringBuffer("SELECT * FROM forum f LEFT JOIN USER u ON u.userid = f.userid LEFT JOIN business b ON f.busid = b.busid WHERE 1=1");
        if(selects == 1 && inputs !=null && !inputs.equals("")){
            sql.append(" and forsubject like  '%"+inputs+"%'");
        }
        if(selects == 2 && inputs !=null && !inputs.equals("")){
            sql.append(" and username like  '%"+inputs+"%'");
        }
        if(selects == 3 && inputs !=null && !inputs.equals("")){
            sql.append(" and forflag like  '%"+inputs+"%'");
        }
        if(selects == 4 && inputs !=null && inputs !=""){
            sql.append(" and forclick like  '%"+inputs+"%'");
        }
        if(selects == 5 && inputs !=null && inputs !=""){
            sql.append(" and callback like  '%"+inputs+"%'");
        }
        return sql.toString();
    }


    public String select2(Page page, int selectss, String inputss) {
        StringBuffer sql = new StringBuffer("SELECT * FROM contract c LEFT JOIN billing b ON c.conid = b.kconid LEFT JOIN  income i   ON c.conid = i.contid WHERE 1=1");
        if(selectss == 1 && inputss !=null && !inputss.equals("")){
            sql.append(" and conname like  '%"+inputss+"%'");
        }
        if(selectss == 2 && inputss !=null && !inputss.equals("")){
            sql.append(" and connum like  '%"+inputss+"%'");
        }
        if(selectss == 3 && inputss !=null && !inputss.equals("")){
            sql.append(" and condept like  '%"+inputss+"%'");
        }
        if(selectss == 4 && inputss !=null && inputss !=""){
            sql.append(" and associatedpersonnel like  '%"+inputss+"%'");
        }
        if(selectss == 5 && inputss !=null && inputss !=""){
            sql.append(" and conmoney like  '%"+inputss+"%'");
        }
        if(selectss == 6 && inputss !=null && inputss !=""){
            sql.append(" and condate like  '%"+inputss+"%'");
        }
        return sql.toString();
    }


    public String select3(Page page, @Param("selectss") Integer selectss, @Param("inputss") String inputss, @Param("cid") Integer cid) {
        StringBuffer sql = new StringBuffer("SELECT * FROM contract c LEFT JOIN billing b ON c.conid = b.kconid LEFT JOIN  income i   ON c.conid = i.contid WHERE 1=1");
        if(null!=selectss && selectss == 1 &&  !"".equals(inputss)){
            sql.append(" and conname like  '%"+inputss+"%'");
        }
        if(null!=selectss && selectss == 2 && !"".equals(inputss)){
            sql.append(" and connum like  '%"+inputss+"%'");
        }
        if(null!=selectss && selectss == 3 && !"".equals(inputss)){
            sql.append(" and condept like  '%"+inputss+"%'");
        }
        if(null!=selectss && selectss == 4 && !"".equals(inputss)){
            sql.append(" and associatedpersonnel like  '%"+inputss+"%'");
        }
        if(null!=selectss && selectss == 5 && !"".equals(inputss)){
            sql.append(" and conmoney like  '%"+inputss+"%'");
        }
        if(null!=selectss && selectss == 6 && !"".equals(inputss)){
            sql.append(" and condate like  '%"+inputss+"%'");
        }
        if(null!=cid){
            sql.append(" and clientid="+cid);
        }
        return sql.toString();
    }
}
