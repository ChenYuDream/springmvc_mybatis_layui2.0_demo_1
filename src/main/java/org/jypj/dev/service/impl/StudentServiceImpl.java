package org.jypj.dev.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jypj.dev.dao.StudentMapper;
import org.jypj.dev.model.Student;
import org.jypj.dev.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author yu_chen
 * @date 2020-06-17 22:33
 **/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {


}