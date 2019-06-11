package com.sise.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sise.bean.User;
import com.sise.dao.UserDao;

public class UserAction extends ActionSupport implements ModelDriven{
	@Resource
	private UserDao userDao;
	private String str;
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	private User user=new User();
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public String login() throws Exception{
		User user1=userDao.getUserByUserName(user.getUsername(),user.getPassword());
		if(user1==null){
			str="用户名或密码错误";
			return "login";
		}
		ActionContext.getContext().getSession().put("login",user1);
		return "admin";
	}
	
	
}
