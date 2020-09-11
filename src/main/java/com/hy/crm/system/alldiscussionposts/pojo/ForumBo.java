package com.hy.crm.system.alldiscussionposts.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


public class ForumBo implements Serializable {

    @ApiModelProperty(value = "帖子ID")
    @TableId(value = "forid", type = IdType.AUTO)
    private Integer forid;

    @ApiModelProperty(value = "帖子主题")
    private String forsubject;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "发帖时间")
    private Date fordate;

    @ApiModelProperty(value = "发帖人ID")
    private Integer userid;

    @ApiModelProperty(value = "商机ID")
    private Integer busid;

    @ApiModelProperty(value = "帖子分类")
    private String fortype;

    @ApiModelProperty(value = "相关附件")
    private String forfile;

    @ApiModelProperty(value = "帖子标签")
    private String forflag;

    @ApiModelProperty(value = "帖子内容")
    private String forbody;

    @ApiModelProperty(value = "帖子点击数")
    private Integer forclick;

    @ApiModelProperty(value = "帖子回复数")
    private Integer callback;

    @ApiModelProperty(value = "精华")
    private String smert;

    @ApiModelProperty(value = "置顶")
    private String top;

    @ApiModelProperty(value = "用户姓名")
    private String username;

    @ApiModelProperty(value = "商机名称（客户+商机）")
    private String busname;

//    @DateTimeFormat(pattern="yyyy-MM-dd")
//    @ApiModelProperty(value = "评论时间")
//    private Date pinlundate;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "最后回复时间")
    private Date fortime;

    public Date getFortime() {
        return fortime;
    }

    public void setFortime(Date fortime) {
        this.fortime = fortime;
    }

//    public Date getPinlundate() {
//        return pinlundate;
//    }
//
//    public void setPinlundate(Date pinlundate) {
//        this.pinlundate = pinlundate;
//    }

    public Integer getForid() {
        return forid;
    }

    public void setForid(Integer forid) {
        this.forid = forid;
    }

    public String getForsubject() {
        return forsubject;
    }

    public void setForsubject(String forsubject) {
        this.forsubject = forsubject;
    }

    public Date getFordate() {
        return fordate;
    }

    public void setFordate(Date fordate) {
        this.fordate = fordate;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getBusid() {
        return busid;
    }

    public void setBusid(Integer busid) {
        this.busid = busid;
    }

    public String getFortype() {
        return fortype;
    }

    public void setFortype(String fortype) {
        this.fortype = fortype;
    }

    public String getForfile() {
        return forfile;
    }

    public void setForfile(String forfile) {
        this.forfile = forfile;
    }

    public String getForflag() {
        return forflag;
    }

    public void setForflag(String forflag) {
        this.forflag = forflag;
    }

    public String getForbody() {
        return forbody;
    }

    public void setForbody(String forbody) {
        this.forbody = forbody;
    }

    public Integer getForclick() {
        return forclick;
    }

    public void setForclick(Integer forclick) {
        this.forclick = forclick;
    }

    public Integer getCallback() {
        return callback;
    }

    public void setCallback(Integer callback) {
        this.callback = callback;
    }

    public String getSmert() {
        return smert;
    }

    public void setSmert(String smert) {
        this.smert = smert;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }
}
