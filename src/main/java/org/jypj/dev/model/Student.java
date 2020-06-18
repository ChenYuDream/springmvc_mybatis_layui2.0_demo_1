package org.jypj.dev.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class Student implements java.io.Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 主键ID
     */
    @TableId
    private Integer id;
    /**
     * 学号
     */
    @TableField("stunum")
    private String stunum;
    /**
     * 姓名
     */
    @TableField("name")
    private String name;
    /**
     * 性别
     */
    @TableField("sex")
    private String sex;
    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;
    /**
     * 联系方式
     */
    @TableField("phone")
    private String phone;
    /**
     * 班级
     */
    @TableField("clazz")
    private String clazz;
    /**
     * 用户名
     */
    @TableField("username")
    private String username;
    /**
     * 密码
     */
    @TableField("password")
    private String password;

}