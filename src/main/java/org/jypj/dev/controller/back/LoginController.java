package org.jypj.dev.controller.back;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.jypj.dev.constant.BaseConstant;
import org.jypj.dev.model.Student;
import org.jypj.dev.model.User;
import org.jypj.dev.result.Result;
import org.jypj.dev.result.ResultUtil;
import org.jypj.dev.service.StudentService;
import org.jypj.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Wrapper;
import java.util.Objects;

@Controller
@RequestMapping("back")
public class LoginController {

    private static final String USER_NAME = "admin";

    private static final String PASSWORD = "123456";


    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    /**
     * 跳转到登录页
     *
     * @return
     */
    @RequestMapping(value = "login")
    public String toLogin() {

        return "back/login";
    }

    /**
     * 跳转到后台框架页
     *
     * @return
     */
    @RequestMapping(value = "main")
    public String toMain() {
        return "back/main";
    }

    /**
     * 跳转到后台框架页
     *
     * @return
     */
    @RequestMapping(value = "toRegister")
    public String toRegister() {
        return "back/register";
    }

    /**
     * 登录
     *
     * @param userName
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "check")
    public Result login(String userName, String password, HttpSession session) {
        User one = userService.getOne(new QueryWrapper<User>().eq("username", userName));
        if (Objects.isNull(one) || !StringUtils.equals(one.getPassword(), password)) {
            return ResultUtil.fail("用户名或者密码不正确");
        }
        session.setAttribute(BaseConstant.BACK_SESSION_USER, one);
        return ResultUtil.success();
    }

    /**
     * @param userName        用户名
     * @param password        密码
     * @param confirmPassword 确认密码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "register")
    public Result register(String userName, String password, String confirmPassword) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", userName));
        if (Objects.isNull(user)) {
//            只能注册学生
            user = new User(userName, password, BaseConstant.ROLE_TYPE_STUDENT);
        } else {
            ResultUtil.fail("该用户已经存在");
        }
        return ResultUtil.successOrFail(userService.save(user));
    }

    /**
     * 注销登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}
