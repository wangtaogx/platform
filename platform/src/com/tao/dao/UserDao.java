package com.tao.dao;



import org.springframework.stereotype.Component;

import com.tao.dao.base.impl.BaseDaoImpl;
import com.tao.model.Users;

@Component("userDao")
public class UserDao extends BaseDaoImpl<Users>{
}
