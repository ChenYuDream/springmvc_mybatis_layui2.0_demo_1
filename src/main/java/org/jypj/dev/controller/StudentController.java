package org.jypj.dev.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.jypj.dev.constant.BaseConstant;
import org.jypj.dev.model.Student;
import org.jypj.dev.model.User;
import org.jypj.dev.result.Result;
import org.jypj.dev.result.ResultUtil;
import org.jypj.dev.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    /**
     * 查询所有学生
     *
     * @return
     */
    @RequestMapping("list")
    public Result selectAll(HttpSession session) {
        User user = (User) session.getAttribute(BaseConstant.BACK_SESSION_USER);
        if (!Objects.isNull(user)) {
            if (StringUtils.equals(user.getRole(), BaseConstant.ROLE_TYPE_STUDENT)) {
                Student student = studentService.getById(user.getId());
                List<Student> list = new ArrayList<>();
                list.add(student);
                return ResultUtil.success(list);
            }
        } else {
            ResultUtil.fail("登录超时");
        }
        List<Student> list = studentService.list();
        return ResultUtil.success(list);
    }

}
