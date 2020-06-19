package org.jypj.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    /**
     * 跳转到后台框架首页
     * @return
     */
    @RequestMapping("/")
    public String toPageMain() {
        return "back/main";
    }

    /**
     * 跳转到第一个菜单
     * @return
     */
    @RequestMapping("page/index")
    public String toPageIndex() {
        return "back/index";
    }
}
