package business;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.cache.Cache;
import play.mvc.Scope.Session;

/**
 * 用户的业务实体
 * @author cp
 * @version 6.0
 * @created 2014年3月21日 下午4:25:45
 */
public class User  implements Serializable{
	/**
	 * 是否允许登录(管理员是否锁定 true锁定)
	 */
	public boolean isAllowLogin;
	/**
	 * 缺少的字段
	 * 是否是有效会员（充值就是有效会员）
	 * 基本信息中的邮箱
	 */
	public long id;
	/**
	 * 获得当前缓存中的user
	 * @return
	 */
	public static User currUser() {
		/*定时任务下，无法获取当前登录用户*/
		if (Session.current() == null) {
			return null;
		}
		
		String encryString = Session.current().getId();
		if(StringUtils.isBlank(encryString)) {
			return null;
		}
		
		String userId = Cache.get("front_"+encryString) + "";	
		if(StringUtils.isBlank(userId)){
			return null;
		}
		User user = (User)Cache.get("userId_"+userId);
		if(user == null) {
			return null;
		}
		
		//被管理员锁定，退出登录
		if (user.isAllowLogin) {
			user.removeCurrUser();
			return null;
		}
		
		return user;
	}
	
	/**
	 * 退出时清除cookie和缓存
	 */
	public static void removeCurrUser() {
		String encryString = Session.current().getId();
		String userId = Cache.get("front_"+encryString) + "";
		Cache.delete("front_"+encryString);
		Cache.delete("userId_"+userId);
	}
}
