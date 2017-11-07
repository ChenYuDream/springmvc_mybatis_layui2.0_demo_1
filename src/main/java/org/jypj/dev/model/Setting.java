package org.jypj.dev.model;

import com.google.gson.Gson;
import lombok.Data;

import java.util.Date;

/**
 * logo 官网地址等设置
 *
 * @author chenyu
 */
public class Setting implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private int id; //配置信息（logo，首页banner，其他页面banner）
    private String config; //配置信息
    private Date modifyTime; //修改时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}