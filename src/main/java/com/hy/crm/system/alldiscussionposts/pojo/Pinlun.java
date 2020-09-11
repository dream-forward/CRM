package com.hy.crm.system.alldiscussionposts.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 评论表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@TableName("pinlun")
public class Pinlun implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论ID")
    @TableId(value = "pingid", type = IdType.AUTO)
    private Integer pingid;

    @ApiModelProperty(value = "回复的帖子ID")
    private Integer forumid;


    @ApiModelProperty(value = "评论内容")
    private String pinlunbody;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    @ApiModelProperty(value = "评论时间")
    private Date pinlundate;

//    @ApiModelProperty(value = "父级ID")
//    private Integer parentid;


    public Integer getPingid() {
        return pingid;
    }

    public void setPingid(Integer pingid) {
        this.pingid = pingid;
    }
    public Integer getForumid() {
        return forumid;
    }

    public void setForumid(Integer forumid) {
        this.forumid = forumid;
    }
    public String getPinlunbody() {
        return pinlunbody;
    }

    public void setPinlunbody(String pinlunbody) {
        this.pinlunbody = pinlunbody;
    }
    public Date getPinlundate() {
        return pinlundate;
    }

    public void setPinlundate(Date pinlundate) {
        this.pinlundate = pinlundate;
    }
//    public Integer getParentid() {
//        return parentid;
//    }
//
//    public void setParentid(Integer parentid) {
//        this.parentid = parentid;
//    }

    @Override
    public String toString() {
        return "Pinlun{" +
            "pingid=" + pingid +
            ", forumid=" + forumid +
            ", pinlunbody=" + pinlunbody +
            ", pinlundate=" + pinlundate +
//            ", parentid=" + parentid +
        "}";
    }
}
