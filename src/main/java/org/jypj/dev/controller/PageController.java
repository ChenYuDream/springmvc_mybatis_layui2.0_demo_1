package org.jypj.dev.controller;

import org.jypj.dev.model.Student;
import org.jypj.dev.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {


    @Autowired
    StudentService studentService;

    /**
     * 跳转到后台框架首页
     *
     * @return
     */
    @RequestMapping("/")
    public String toPageMain() {
        return "back/main";
    }

    /**
     * 跳转到第一个菜单
     *
     * @return
     */
    @RequestMapping("page/student/list")
    public String toPageIndex() {
        return "back/student/student_list";
    }

    /**
     * 跳转到第一个菜单
     *
     * @return
     */
    @RequestMapping("page/student/form/{id}")
    public String toPageIndex(@PathVariable String id, HttpServletRequest request) {
        Student student = studentService.getById(id);
        request.setAttribute("student", student);
        return "back/student/student_list";
    }
}
