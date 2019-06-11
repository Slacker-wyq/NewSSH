package com.sise.dao;

import java.util.List;

import com.sise.bean.Category;
import com.sise.bean.News;

public interface CategoryDao {
	public void addCategory(Category category);
	public void updateCategory(Category category);
	public Category getCategoryById(Integer id);
	public void deleteCategory(Category category);
	public List<Category> findAllCategory();
	public List<Category> findCategoryByPageNum(Integer num);
}
