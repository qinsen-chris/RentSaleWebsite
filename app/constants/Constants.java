package constants;

import java.util.ArrayList;
import java.util.List;


import play.Play;

/**
 * @author qinsen
 * @created 2017年4月27日
 * @description 
 */
public class Constants {
	public static final boolean TRUE = true;
	public static final boolean FALSE = false;

	public static final boolean ENABLE = true; // 启用
	public static final boolean NOT_ENABLE = false; // 不启用
	
	public static final int YEAR = -1;// 年
	public static final int MONTH = 0; // 月
	public static final int DAY = 1; // 日

	public static final int _ONE = -1;
	public static final int _TWO = -2;
	public static final int _THREE = -3;
	public static final int _FOUR = -4;
	public static final int _FIVE = -5;
	public static final int _SIX = -6;
	public static final int _SEVEN = -7;
	public static final int _EIGHT = -8;
	public static final int _NINE = -9;
	public static final int _TEN = -10;

	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE = 9;
	public static final int TEN = 10;
	public static final int FIFTEEN = 15;

	public static final int INSERT = 1;
	public static final int DELETE = 2;
	public static final int UPDATE = 3;
	public static final int SELECT = 4;
	
	/** 开发模式 */
	public static final boolean DEV_PROD = Play.configuration.getProperty("application.mode").equals("dev") ? true : false;
	
	/**
	 * 分页主题
	 */
	public static final int PAGE_SIMPLE = 1;
	public static final int PAGE_ASYNCH = 2;
	
	/**
	 * 默认风格
	 */
	public static final int PAGE_STYLE_DEFAULT = 1;

	public static final String BASE_URL = Play.configuration.getProperty("test.application.baseUrl") + Play.configuration.getProperty("http.path") + "/";
	public static final String HTTP_PATH = Play.configuration.getProperty("http.path");
	
	/**
	 * 文件格式
	 * @author lzp
	 * @version 6.0
	 * @created 2014-8-16
	 */
	public class FileFormat {
		public static final int IMG = 1;	//图片
		public static final int TXT = 2;	//文本
		public static final int VIDEO = 3;	//视频
		public static final int AUDIO = 4;	//音频
		public static final int XLS = 5;	//表格
		public static final int WORD = 6;	//word
		public static final int PDF = 7;	//pdf
	}
	
	/**
	 * 部分加密action标识
	 */
	public static final String USER_ID_SIGN = "u"; // 用户ID
	public static final String SUPERVISOR_ID_SIGN = "supervisor_id"; // 管理员ID
	public static final String ITEM_ID_SIGN = "i"; // 资料ID
	public static final String USER_ITEM_ID_SIGN = "ui"; // 用户资料ID
	/**
	 * 加密串有效时间(s)
	 */
	public static final int VALID_TIME = 3600;
	public static final int PICTURE_SIZE = 10 * 1024 * 1024; // 图片限制大小(10M左右)
	public static final int TXT_SIZE = 5 * 1024 * 1024; // 文本限制大小(5M左右)
	public static final int VIDEO_SIZE = 100 * 1024 * 1024; // 视频限制大小(100M左右)
	public static final int AUDIO_SIZE = 100 * 1024 * 1024; // 音频限制大小(100M左右)
	public static final int XLS_SIZE = 5 * 1024 * 1024; // 表格限制大小(5M左右)
	
	public static final String ENCRYPTION_KEY = Play.configuration.getProperty("fixed.secret");	
	
	public static final String LOCALHOST_IP = "127.0.0.1";
}
