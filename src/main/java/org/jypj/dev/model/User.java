package org.jypj.dev.model;

import com.google.gson.Gson;
import lombok.Data;

import java.util.Date;

/**
 * 用户表
 *
 * @author chenyu
 */
@Data
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;
    /**
     * 用户编号
     */
    private String userNum;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 角色类型
     */
    private String roleType;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新时间
     */
    private Date updateDate;





}