package com.sise.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sise.bean.News;
import com.sise.bean.User;
import com.sise.dao.UserDao;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User getUserByUserName(final String name,final String password) {
		// TODO Auto-generated method stub
		User user=new User();
		List<User>lists=getHibernateTemplate().execute(new HibernateCallback <List<User>>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("from User where username=?0 and password=?1"); 
				query.setParameter(0, name);
				query.setParameter(1, password);
				List<User>lists=query.list();
				return lists;
			}
		});
		if(lists.size()==0){
			return null;
		}else{
			user=lists.get(0);
			return user;
		}
		
	}

}
