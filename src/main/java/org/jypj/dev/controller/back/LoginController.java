package org.jypj.dev.controller.back;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.jypj.dev.constant.BaseConstant;
import org.jypj.dev.model.User;
import org.jypj.dev.result.Result;
import org.jypj.dev.result.ResultUtil;
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
        Result result = new Result();
        User user = new User();
        if (StringUtils.isAnyEmpty(userName, password) || !(USER_NAME.equals(userName)) || !(PASSWORD.equals(password))) {
            return new Result(-2);
        }
        user.setUsername(userName);
        session.setAttribute(BaseConstant.BACK_SESSION_USER, user);
        return result;
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
            user = new User(userName, password);
        } else {
            ResultUtil.fail("用户已经存在");
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
