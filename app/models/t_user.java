package models;

import java.util.Date;
import javax.persistence.Entity;
import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class t_user extends Model {
	
	public Date time;
	
	@Required(message="姓名不能为空")
	@MaxSize(value=20,message="姓名长度为2-20个字符")
	@MinSize(value=2,message="姓名长度为2-20个字符")
	@Match(value="^[\u4E00-\u9FA5A-Za-z0-9_]+$",message="姓名不能含有特殊字符")
	public String name;
	
	@Required(message="邮箱不能为空")
	@Match(value="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$",message="邮箱格式不正确")
	public String email;
	
	@Required(message="密码不能为空")
	public String password;

	public String photo;
	
	public String telephone;
	
	public String mobile;
	
	/**
	 * 是否时 活跃会员（充值就成为活跃会员）
	 */
	public boolean is_active;
	
	//个人用户使用
	//------------------------------------------------
	public String appstore; //应用市场 默认不为空
	public String mac; //设备mac地址 默认 不为空
	public String ifa; //设备ifa编码  默认 可为空
	public String iemi; //设备iemi编码  默认 可为空
	//------------------------------------------------
	//验证码错误次数
	public int err_code_count;
	
	public t_user() {
	}

	public t_user(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public t_user(long id, boolean isActive) {
		this.id = id;
		this.is_active = isActive;
	}
	
	/**
	 * 用于查询用户通过名字(发送系统通知)
	 */
	public t_user(String name, String mobile, String email) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}
		
	/**
	 * 选择用户
	 * @param id ID
	 * @param name 名称
	 */
	public t_user(long id, String name){
		this.id = id;
		this.name = name;
	}
	
}
