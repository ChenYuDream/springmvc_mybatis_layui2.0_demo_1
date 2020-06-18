package org.jypj.dev.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_user")
public class User implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Integer id;
    /**
     *
     */
    @TableField("code")
    private String code;
    /**
     *
     */
    @TableField("username")
    private String username;
    /**
     *
     */
    @TableField("password")
    private String password;
    /**
     *
     */
    @TableField("state")
    private String state;


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}