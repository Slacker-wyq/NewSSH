package com.sise.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sise.bean.Category;
import com.sise.bean.News;
import com.sise.dao.CategoryDao;
import com.sise.dao.NewsDao;

public class FrontPageAction extends ActionSupport {
	@Resource
	private CategoryDao categoryDao;
	@Resource
	private NewsDao newsDao;
	private List<Category> categorys;
	private int cid;
	private List<News>newses;
	private String title;
	private Date startDate;
	private Date endDate;
	private News news;

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<News> getNewses() {
		return newses;
	}

	public void setNewses(List<News> newses) {
		this.newses = newses;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	//前端首页
	public String frontPage(){
		categorys=categoryDao.findAllCategory();
		newses=newsDao.findNewsByClicksASC();
		ActionContext.getContext().getSession().put("clicks", newses);
		return "front";
	}
	//前端显示类型新闻
	public String frontPart(){
		newses=newsDao.findPartNews(cid);
		return "part";
	}
	//搜索新闻
	public String frontFind(){
		newses=newsDao.findNewsByLikeTitle(title);
		if(newses==null){
			ActionContext.getContext().getSession().put("find","不存在类似新闻请重新查询");
			return "front";
		}
		return "part";
	}
	public String frontTime(){
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String start=df.format(startDate);
		DateFormat dfnow=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String end=df.format(endDate);
		newses=newsDao.findNewsByIssueTime(start, end);
		if(newses==null){
			return "front";
		}
		return "time";
	}
	public String frontLook(){
		news=newsDao.getNewsById(cid);
		int clicks=((int)news.getClicks())+1;
		news.setClicks(clicks);
		newsDao.updateNews(news);
		return "frontLook";
	}
}
