package com.sise.daoImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.sise.bean.News;
import com.sise.dao.NewsDao;

@Transactional
public class NewsDaoImpl extends HibernateDaoSupport implements NewsDao {

	@Override
	public void addNews(News news) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(news);
	}

	@Override
	public void updateNews(News news) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(news);
	}

	@Override
	public News getNewsById(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(News.class,id);
	}

	@Override
	public void deleteNews(News news) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(news);
	}

	@Override
	public List<News> findAllNews() {
		// TODO Auto-generated method stub
		return (List<News>) getHibernateTemplate().find("from News");
	}

	@Override
	public List<News> findPartNews(final Integer num) {
		// TODO Auto-generated method stub
		return (List<News>) getHibernateTemplate().execute(new HibernateCallback <List<News>>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("from News where category_id=?0"); 
				query.setParameter(0, num);
				List<News>lists=query.list();
				return lists;
			}
		});
	}
	
	@Override
	public List<News> findNewsByPageNum(final Integer num) {
		// TODO Auto-generated method stub
		final String hql="from News order by id ASC";
		return (List<News>) getHibernateTemplate().execute(new HibernateCallback <List<News>>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql); 
				query.setFirstResult(num); 
				query.setMaxResults(4); 
				List<News> list = query.list(); 
				return list;
			}
		});
	}

	@Override
	public List<News> getNewsByCategory_id(final Integer cid) {
		// TODO Auto-generated method stub
		return (List<News>) getHibernateTemplate().execute(new HibernateCallback <List<News>>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("from News where category_id=?0"); 
				query.setParameter(0, cid);
				List<News>lists=query.list();
				return lists;
			}
		});
	}
	
	@Override
	public List<News> findPartNewsByNum(final Integer id, final Integer num) {
		return (List<News>) getHibernateTemplate().execute(new HibernateCallback <List<News>>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("from News where category_id=?0 order by id ASC"); 
				query.setParameter(0, id);
				query.setFirstResult(num); 
				query.setMaxResults(4); 
				List<News> list = query.list(); 
				return list;
			}
		});
		
	}

	@Override
	public List<News> findNewsByClicksASC() {
		// TODO Auto-generated method stub
		return (List<News>) getHibernateTemplate().find("from News order by clicks DESC");
	}

	@Override
	public List<News> findNewsByLikeTitle(final String title) {
		// TODO Auto-generated method stub
		return (List<News>) getHibernateTemplate().execute(new HibernateCallback <List<News>>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query = session.createQuery("from News where title like ?0"); 
				query.setParameter(0,"%"+title+"%");
				List<News>lists=query.list();
				if(lists.size()>0){
				return lists;
				}else {
					return null;
				}
			}
		});
	}

	@Override
	public List<News> findNewsByIssueTime(final String start, final String end) {
		// TODO Auto-generated method stub
		return (List<News>)getHibernateTemplate().execute(new HibernateCallback <List<News>>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date beginDate = null; 
				Date endDate = null;
				try {
					beginDate = df.parse(start);
					endDate = df.parse(end);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Query query = session.createQuery("from News where issueTime<:endDate and issueTime>=:beginDate"); 
				query.setDate("beginDate",beginDate);   
			    query.setDate("endDate",endDate);
				List<News>lists=query.list();
				if(lists.size()>0){
					System.out.println(lists.size());
				return lists;
				}else {
					return null;
				}
			}
		});
		
	}
	
}
	
