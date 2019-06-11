package com.sise.dao;

import com.sise.bean.User;

public interface UserDao {
	public User getUserByUserName(String name,String password);
}
