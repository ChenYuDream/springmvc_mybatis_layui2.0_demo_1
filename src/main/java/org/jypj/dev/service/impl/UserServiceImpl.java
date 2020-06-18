package org.jypj.dev.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jypj.dev.dao.UserMapper;
import org.jypj.dev.model.User;
import org.jypj.dev.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author yu_chen
 * @date 2020-06-17 22:36
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}