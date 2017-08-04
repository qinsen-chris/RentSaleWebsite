package controllers;

import play.Play;
import play.db.jpa.Blob;
import play.db.jpa.JPA;
import play.mvc.*;
import utils.ErrorInfo;
import utils.PageBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shove.Convert;

import models.*;

public class Application extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class); 
    public static void index() {
        render();
    }
    
    public static void sayHello(String myname){
    	PageBean<t_user> pageBean = new PageBean<t_user>();
    	render(myname,pageBean);
    }
    
	/**
	 * 根据用户名获得用户
	 * @return
	 */
	public static void queryUser(int currPage, int pageSize) {
		ErrorInfo error = new ErrorInfo();
		error.clear();
		
		if(currPage ==0){
			currPage = 1;
		}
		if(pageSize == 0){
			pageSize =10;
		}
		String sql = "select name, mobile, email from t_user";
		List<t_user> t_userList = null;
		
		try {
			EntityManager em = JPA.em();
            Query query = em.createNativeQuery(sql.toString());
            
            query.setFirstResult((currPage - 1) * pageSize);
            query.setMaxResults(pageSize);
            t_userList = query.getResultList();
		}catch(Exception e) {
			LOGGER.info("对不起，根据用户名查询用户时：",e);
			error.code = -1;
			error.msg = "查询用户失败";
			
		}
		PageBean<t_user> pageBean = new PageBean<t_user>();
		pageBean.page = t_userList;
		pageBean.currPage = currPage;
		pageBean.pageSize = pageSize;
		
		
		String sqlCount = "select count(1) from t_user";
		try {
			EntityManager em = JPA.em();
            Query query = em.createNativeQuery(sqlCount.toString());
            int totalCount = Convert.strToInt(query.getResultList().get(0)+"",0);
            pageBean.totalCount = totalCount;
		}catch(Exception e) {
			LOGGER.info("对不起，查询用户总数时：",e);
			error.code = -1;
			error.msg = "查询用户失败";
		}
		
		error.code = 0;
		render(pageBean);
	}
	
//	/**
//	 * 查询所有用户
//	 * @return
//	 */
//	public static void queryUser() {
//		
//		String sql = "select new t_user(name, mobile, email) from t_user";
//		List<t_user> t_userList = null;
//		
//		try {
//			t_userList = t_user.find(sql).fetch();
//		}catch(Exception e) {
//			e.printStackTrace();
//			LOGGER.info("根据用户名查询用户时："+e.getMessage());
//			
//		}
//		render(t_userList);
//	}
	
	/**
	 * 图片查看
	 * @param uuid
	 * @throws FileNotFoundException
	 */
	public static void images(String uuid) throws FileNotFoundException{
		Blob blob = new Blob();
    	InputStream is = null;
		response.setContentTypeIfNotSet("image/png");
		try {
			is = new FileInputStream(new File(blob.getStore(), uuid.split("\\.")[0]));
		} catch (Exception e) {
			LOGGER.error("查看图片出错！",e);
			is = new FileInputStream(Play.getFile("public/images/default.png"));
		}
    	renderBinary(is);
	}
	
	
	/**
	 * 跳转到编辑器页面
	 * @param sign
	 */
	public static void showEditorPage(){
		render();
	}
	


}