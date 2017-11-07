package org.jypj.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ChenYu
 * @date 2017-05-17
 */
@Controller
public class PageController {

    /**
     * 跳转到后台登录页
     *
     * @return
     */
    @RequestMapping("back")
    public String toBackIndex() {
        return "back/index";
    }

    /**
     * 跳转到前台首页
     * @return
     */
    @RequestMapping("page/index")
    public String toPageIndex() {
        return "web/index_page";
    }
}
