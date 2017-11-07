package org.jypj.dev.model;

import com.google.gson.Gson;

/**
 * 用户表
 *
 * @author chenyu
 */
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String id; //主键
    private String userNum; //人员编号(工号)
    private String userName; //用户姓名
    private String password; //密码
    private String passwordMd5; //MD加密密码
    private String roleType; //角色类型
    private String createDate; //创建时间


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public void setPasswordMd5(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {

        return new Gson().toJson(this);
    }

}