package com.hy.crm.utils;

import java.util.List;

/**
 * @author 旗木卡卡西
 * @date 2020/7/28 17:49
 */
public class LayuiUtils {
    private Integer code;
    private String msg;
    private Integer count;
    private List data;

    /**
     * 空参构造
     */
    public LayuiUtils() {
    }

    /**
     * 四参构造
     * @param code 响应状态码
     * @param msg 响应提示消息
     * @param count 响应总数
     * @param data 响应数据
     */
    public LayuiUtils(Integer code, String msg, Integer count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
