package com.tao.dao;



import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.tao.dao.base.impl.BaseDaoImpl;
import com.tao.model.Users;

@Component("userDao")
public class UserDao extends BaseDaoImpl<Users>{
	@Override
	public List<Users> getAllListByObj(String tag, Users obj)
			throws DataAccessException {
		List<Users> users = new ArrayList<Users>();
		Users u = new Users();
		u.setName("wangtao");
		u.setPassword("password");
		users.add(u);
		return users;
	}
}
