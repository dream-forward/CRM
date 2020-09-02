package com.hy.crm.system.mydocumentary.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 跟单表
 * </p>
 *
 * @author zzx
 * @since 2020-08-28
 */
@ApiModel(value="Documentary对象", description="跟单表")
public class Documentary implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "跟单id")
    @TableId(value = "docid", type = IdType.AUTO)
    private Integer docid;

    @ApiModelProperty(value = "商机id")
    private Integer busiid;

    @ApiModelProperty(value = "跟单时间")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date doctime;

    @ApiModelProperty(value = "跟单主题")
    private String docsubject;

    @ApiModelProperty(value = "跟单分类")
    private String doctype;

    @ApiModelProperty(value = "跟单人")
    private String docuser;

    @ApiModelProperty(value = "详细内容")
    private String content;

    @ApiModelProperty(value = "相关附件")
    private String docfile;

    @ApiModelProperty(value = "商机阶段")
    private String busphase;

    public Integer getDocid() {
        return docid;
    }

    public void setDocid(Integer docid) {
        this.docid = docid;
    }
    public Integer getBusiid() {
        return busiid;
    }

    public void setBusiid(Integer busiid) {
        this.busiid = busiid;
    }
    public Date getDoctime() {
        return doctime;
    }

    public void setDoctime(Date doctime) {
        this.doctime = doctime;
    }
    public String getDocsubject() {
        return docsubject;
    }

    public void setDocsubject(String docsubject) {
        this.docsubject = docsubject;
    }
    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }
    public String getDocuser() {
        return docuser;
    }

    public void setDocuser(String docuser) {
        this.docuser = docuser;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getDocfile() {
        return docfile;
    }

    public void setDocfile(String docfile) {
        this.docfile = docfile;
    }
    public String getBusphase() {
        return busphase;
    }

    public void setBusphase(String busphase) {
        this.busphase = busphase;
    }

    @Override
    public String toString() {
        return "Documentary{" +
            "docid=" + docid +
            ", busiid=" + busiid +
            ", doctime=" + doctime +
            ", docsubject=" + docsubject +
            ", doctype=" + doctype +
            ", docuser=" + docuser +
            ", content=" + content +
            ", docfile=" + docfile +
            ", busphase=" + busphase +
        "}";
    }
}
