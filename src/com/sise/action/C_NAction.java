package com.sise.action;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sise.bean.Category;
import com.sise.bean.News;
import com.sise.dao.CategoryDao;
import com.sise.dao.NewsDao;
public class C_NAction extends ActionSupport {
	private int cid;
	private Category category;
	private News news;
	private List<News> newses;
	private List<Category> categorys;
	private int pageSize=4;
	private int pageTotal;
	private int pageNum=1;//当前页数
	private float newCount;
	private File file;
	private String fileFileName;
	private String fileContentType;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	@Resource
	private CategoryDao categoryDao;
	@Resource
	private NewsDao newsDao;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<News> getNewses() {
		return newses;
	}
	public void setNewses(List<News> newses) {
		this.newses = newses;
	}
	public List<Category> getCategorys() {
		return categorys;
	}
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	
	public String categoryAdd(){
		List<Category>lists=categoryDao.findAllCategory();
		int c=0;
		for(Category categorys:lists){
			if(category.getCategoryName().equals(categorys.getCategoryName())){
				c++;
			}
		}
		System.out.println(c);
		if(c==0){
		categoryDao.addCategory(category);
		}else{
			ActionContext.getContext().getSession().put("msg","类型已经存在");
		}
		return SUCCESS;
	}
	
	public String categoryUpdate(){
		category=categoryDao.getCategoryById(cid);
		return "update";
	}
	
	public String categoryUpdated(){
		List<Category>lists=categoryDao.findAllCategory();
		int c=0;
		for(Category categorys:lists){
			if(category.getCategoryName().equals(categorys.getCategoryName())){
				c++;
			}
		}
		if(c==0){
			categoryDao.updateCategory(category);
		}else{
			ActionContext.getContext().getSession().put("msg","类型已经存在");
		}
		
		return SUCCESS;
	}
	
	public String categoryDelete(){
		category=categoryDao.getCategoryById(cid);
		List<News>lnews=newsDao.getNewsByCategory_id(cid);
		if(lnews.size()==0){
			categoryDao.deleteCategory(category);
		}else{
			ActionContext.getContext().getSession().put("msg","存在次类型新闻不可以直接删除");
		}
		return SUCCESS;
	}
	
	public String categoryList(){
		categorys=categoryDao.findAllCategory();
		return "list";
	}
	
	public String newsAdd(){
		categorys=categoryDao.findAllCategory();
		ActionContext.getContext().getSession().put("categorys", categorys);
		return "add";
		
	}
	
	public String newsAdded() throws IOException{
		category=categoryDao.getCategoryById(cid);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date=df.format(new Date());
		if(file != null){	
			String path = ServletActionContext.getServletContext().getRealPath("upload");			
			// 创建文件类型对象:		
			File diskFile = new File(path + "//" + fileFileName);		
			// 文件上传:	
			FileUtils.copyFile(file, diskFile);	
			news.setImgs("upload/"+ fileFileName);
		}
		news.setIssueTime(date);
		news.setClicks(1);
		news.setCategory(category);
		newsDao.addNews(news);
		return SUCCESS;
	}
	public String newsList(){
		//分页
		categorys=categoryDao.findAllCategory();
		newCount=newsDao.findAllNews().size();//新闻总数
		pageTotal=(int) Math.ceil(newCount/pageSize);//总页数
		ActionContext.getContext().getSession().put("pageTotal", pageTotal);
		ActionContext.getContext().getSession().put("pageNum", pageNum);
		newses=newsDao.findNewsByPageNum((pageNum-1)*pageSize);
		return "lists";
	}
	public String listNewsPart(){
		category=categoryDao.getCategoryById(cid);
		newses=newsDao.findPartNews(cid);
		ActionContext.getContext().getSession().put("cid", cid);
		newCount=newses.size();//该类型新闻总数
		pageTotal=(int)Math.ceil(newCount/pageSize);//总页数
		ActionContext.getContext().getSession().put("pageTotal", pageTotal);
		ActionContext.getContext().getSession().put("pageNum", pageNum);
		categorys=categoryDao.findAllCategory();
		newses=newsDao.findPartNewsByNum(cid, (pageNum-1)*pageSize);
		return "listspart";
	}
	public String newsLook(){
		news=newsDao.getNewsById(cid);
		return "look";
	}
	
	public String newsUpdate(){
		news=newsDao.getNewsById(cid);
		categorys=categoryDao.findAllCategory();
		return "updates";
	}
	
	public String newsUpdated(){
		category=categoryDao.getCategoryById(cid);
		news.setCategory(category);
		newsDao.updateNews(news);
		return "suc";
	}
	public String newsDelete(){
		news=newsDao.getNewsById(cid);
		newsDao.deleteNews(news);
		return "suc";
	}
	
}