package com.hy.crm.system.mybusiness.bo;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 旗木卡卡西
 * @date 2020/9/5 9:02
 */
public class BusinessBo implements Serializable {
    private Integer busid;

    @ApiModelProperty(value = "商机名称（客户+商机）")
    private String busname;

    private String busiphase;

    @ApiModelProperty(value = "预计成交金额")
    private BigDecimal maymoney;

    @ApiModelProperty(value = "商机负责人")
    private String busprincipal;

    /*最后跟单时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastTime;
}
