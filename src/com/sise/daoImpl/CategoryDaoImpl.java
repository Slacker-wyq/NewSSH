package com.sise.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.sise.bean.Category;
import com.sise.bean.News;
import com.sise.dao.CategoryDao;
@Transactional
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao {

	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(category);
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(category);
	}

	@Override
	public Category getCategoryById(Integer id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Category.class, id);
	}

	@Override
	public void deleteCategory(Category category) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(category);
	}

	@Override
	public List<Category> findAllCategory() {
		// TODO Auto-generated method stub
		return (List<Category>) getHibernateTemplate().find("from Category");
	}

	@Override
	public List<Category> findCategoryByPageNum(final Integer num) {
		final String hql="from Category order by id ASC";
		return (List<Category>) getHibernateTemplate().execute(new HibernateCallback <List<Category>>() {

			@Override
			public List doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql); 
				query.setFirstResult(num); 
				query.setMaxResults(3); 
				List<Category> list = query.list(); 
				return list;
			}
		});
	}

}
