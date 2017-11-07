package org.jypj.dev.controller.back;

import org.apache.commons.lang3.StringUtils;
import org.jypj.dev.constant.BaseConstant;
import org.jypj.dev.dao.SettingDao;
import org.jypj.dev.model.User;
import org.jypj.dev.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author ChenYu
 * @date 2017-06-05
 */
@Controller
@RequestMapping("back")
public class LoginController {

    private static final String USER_NAME = "admin";

    private static final String PASSWORD = "123456";


    @Resource
    private SettingDao settingDao;

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
        user.setUserName(userName);
        session.setAttribute(BaseConstant.BACK_SESSION_USER, user);
        return result;
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
