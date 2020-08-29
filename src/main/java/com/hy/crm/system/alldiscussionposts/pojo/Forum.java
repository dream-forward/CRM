package com.hy.crm.system.alldiscussionposts.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 帖子表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@TableName("forum")
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "帖子ID")
    @TableId(value = "forid", type = IdType.AUTO)
    private Integer forid;

    @ApiModelProperty(value = "帖子主题")
    private String forsubject;

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

    @Override
    public String toString() {
        return "Forum{" +
            "forid=" + forid +
            ", forsubject=" + forsubject +
            ", fordate=" + fordate +
            ", userid=" + userid +
            ", busid=" + busid +
            ", fortype=" + fortype +
            ", forfile=" + forfile +
            ", forflag=" + forflag +
            ", forbody=" + forbody +
            ", forclick=" + forclick +
            ", callback=" + callback +
            ", smert=" + smert +
            ", top=" + top +
        "}";
    }
}
