package org.jypj.dev.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jypj.dev.dao.UserMapper;
import org.jypj.dev.model.User;
import org.jypj.dev.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}