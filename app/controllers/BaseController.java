package controllers;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shove.web.security.InjectionInterceptor;

import constants.Constants;
import play.Play;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.Http.Request;
import utils.ErrorInfo;
public class BaseController extends Controller {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

	//@Before(unless={"front.account.LoginAndRegisterAction.setCode","Application.images","front.account.LoginAndRegisterAction.getImg"})
	protected static void injectionInterceptor() throws Exception {
		
	}

	/**
	 * 获取当前请求根路径
	 * 
	 * @return
	 */
	public static String getBaseURL() {
		String baseURL = Constants.BASE_URL;

		Request req = Request.current();
		if (req != null) {
			baseURL = req.getBase()
					+ Play.configuration.getProperty("http.path") + "/";
		}

		return baseURL;
	}
	
	/**
	 * 跳转错误提示页面
	 */
	public static void payErrorInfo(ErrorInfo error){
		render(error);
	}
	
	/**
	 * 跳转用，没有实际业务意义
	 */
	public static void chinaPrnCloseSuccess(){
		render();
	}
	
	/**
	 * 跳转用，没有实际业务意义
	 * @param error
	 */
	public static void chinaPrnCloseError(ErrorInfo error){
		render(error);
	}
	
	public static void chinaPnrCreateError(ErrorInfo error){
		render(error);
	}
	
	public static void chinaPnrCreateSuccess(){
		render();
	}
	
	/**
	 * 支付成功跳转页面
	 */
	public static void paySuccessInfo(String orderId, String cmdId){
		
	}
	
	/**
	 * 模拟表单提交
	 * @param maps
	 * @param action
	 */
	protected static void submitForm(Map<String,String> maps,String action){
		String htmlValue = buildFormParams(maps, action);
		renderHtml(htmlValue);
	}
	
	/**
	 * 构造表单信息
	 * @param maps
	 * @param action
	 * @return
	 */
	protected static String buildFormParams(Map<String,String> maps,String action){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<!DOCTYPE html>")
		.append("<html>")
		.append("<head>")
		.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />")
		.append("<title>Servlet AccountServlet</title>")
		.append("</head>")
		.append("<body>")
		.append("<h4>处理中...</h4>")
		.append("<form action="+action+" id=\"frm1\" method=\"post\">");
		for(Entry<String, String> entry : maps.entrySet()){
			buffer.append("<input type=\"hidden\" name="+entry.getKey()+" value="+entry.getValue()+" />");
		}
		buffer.append("</form>")
		.append("<script language=\"javascript\">")
		.append("document.getElementById(\"frm1\").submit();")
		.append("</script>")
		.append("</body>")
		.append("</html>");
		return buffer.toString();
	}


	/**
	 * 构造只含body内的表单信息
	 * @param maps
	 * @param action
	 * @return
	 */
	protected static String buildPureFormParams(Map<String,String> maps,String action){
		StringBuffer buffer = new StringBuffer();
		buffer.append("<form action="+action+" id=\"frm1\" method=\"post\">");
		for(Entry<String, String> entry : maps.entrySet()){
			buffer.append("<input type=\"hidden\" name="+entry.getKey()+" value="+entry.getValue()+" />");
		}
		buffer.append("</form>")
				.append("<script language=\"javascript\">")
				.append("document.getElementById(\"frm1\").submit();")
				.append("</script>");
		return buffer.toString();
	}

	/**
	 * 代理访问，插入响应头。
	 * 
	 * 解决文件下载的问题
	 */
	protected static void renderBinary(File file, String filename) {
		LOGGER.debug("设置响应头");

    	// 解决ie8不能下载的问题
    	response.setHeader("Expires", "0");
    	response.setHeader("Pragma","public");
    	response.setHeader("Cache-Control", "must-revalidate,post-check=0, pre-check=0");
    	response.setHeader("Cache-Control","public");

    	// 设置下载文件名
    	if (filename != null) {
    		try {
				filename = URLEncoder.encode(filename, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				LOGGER.error("filename={}", filename,e);
			}
    	}
    	String fileNameHeader = String.format("attachment; filename=\"%s\"; filename*=utf-8''%s", filename, filename);
    	LOGGER.debug("fileNameHeader={}", fileNameHeader);
    	response.setHeader("Content-Disposition", fileNameHeader);
    	
		Controller.renderBinary(file, filename);
	}
}
