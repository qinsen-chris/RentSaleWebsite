package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import business.User;

public class NumberUtil {

	public static Pattern patternInt = Pattern.compile("(^[+-]?([0-9]|([1-9][0-9]*)))");
//	public static Pattern patternInt = Pattern.compile("^[+-]?[0-9]+$");
	
	public static Pattern patternDouble = Pattern.compile("^[+-]?(([1-9]\\d*\\.?\\d+)|(0{1}\\.\\d+)|0{1})");//判断是否为小数
//	public static Pattern patternDouble = Pattern.compile("\\d+\\.\\d+$|-\\d+\\.\\d+$");//判断是否为小数

	public static boolean isNumeric(String str) { 
		if(StringUtils.isBlank(str)) {
			return false;
		}
		
		for (int i = str.length();--i>=0;){
			if (!Character.isDigit(str.charAt(i))){
				return false;    
				}   
		}   return true;  
	} 
	
	/**
	 * 判断是否是个整数（int,long等）
	 * @param str
	 * @return
	 */
	public static boolean isNumericInt(String str) {
		if(str == null) {
			return false;
		}
		
		return patternInt.matcher(str).matches();
	}
	
	/**
	 * 判断是否是个小数（double,float等）
	 * @param str
	 * @return
	 */
	public static boolean isNumericDouble(String str) {
		if(str == null) {
			return false;
		}
		
		return patternDouble.matcher(str).matches()||isNumericInt(str);
	}
	
	public static boolean isBoolean(String str) {
		if(str == null) {
			return false;
		}
		
		return str.equals("true") || str.equals("false");
	}
	
	public static boolean isDate(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			format.parse(str);
		} catch (ParseException e) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * 生成订单编号
	 * @return
	 */
	public static String getBillNo(int type) {
		java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
		java.text.SimpleDateFormat formatter2 = new java.text.SimpleDateFormat("yyyyMMddHHmmss"); 
		Random random = new Random(); 
		String billno = type+"X"+User.currUser().id+formatter2.format(currentTime) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
		
		return billno;
	}
	
	/**
	 * 生成订单编号
	 * @return
	 */
	public static String getBillNo(String uid) {
		java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
		java.text.SimpleDateFormat formatter2 = new java.text.SimpleDateFormat("yyyyMMddHHmmss"); 
		Random random = new Random(); 
		String billno = uid+formatter2.format(currentTime) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9) + random.nextInt(9);
		
		return billno;
	}

	/**
	 * 把int类型转换成long类型
	 */
	public static long getLongVal(int value) {
		return Long.parseLong(value + "");
	}
	
	public static BigDecimal initBigDecimal(BigDecimal obj){
		if(obj==null){
			return BigDecimal.ZERO;
		}
		return obj;
	}
	/**
	 * 金额格式化
	 */
	public static String amountFormat(double amount) {
		DecimalFormat myformat = new DecimalFormat();
		myformat.applyPattern("##,###.00");
		
		return myformat.format(amount);
	}
	
	/**
	 * 单个时间格式化
	 */
	public static String timeFormat(int time) {
		DecimalFormat myformat = new DecimalFormat();
		myformat.applyPattern("###00");
		
		return myformat.format(time);
	}
	
	/**
	 * 2个double比较
	 * 
	 * @param d1
	 * @param d2
	 * @param scale 小数位数
	 * @param roundingMode
	 * @return
	 */
	public static int compare(double d1, double d2, int scale, RoundingMode roundingMode) {
		BigDecimal obj1 = BigDecimal.valueOf(d1);
		BigDecimal obj2 = BigDecimal.valueOf(d2);
		obj1 = obj1.setScale(scale, roundingMode);
		obj2 = obj2.setScale(scale, roundingMode);
		return obj1.compareTo(obj2);
	}

	/**
	 * 判断2个double的值是否相等。
	 * 
	 * @param d1
	 * @param d2
	 * @param scale 小数位数，剩余小数位舍去
	 * @return
	 */
	public static boolean isEquals(double d1, double d2, int scale) {
		return compare(d1, d2, scale, RoundingMode.DOWN) == 0 ? true : false;
	}

	/**
	 * 判断2个double的值是否相等。
	 * 
	 * @param d1
	 * @param d2
	 * @param scale 小数位数，默认刻度为5位小数
	 * @return
	 */
	public static boolean isEquals(double d1, double d2) {
		return compare(d1, d2, 5, RoundingMode.DOWN) == 0 ? true : false;
	}
	
	/**
	 * 两位小数 去尾
	 * @param apr
	 * @return
	 */
	public static Double getFormatApr(Double apr) {
		if(apr == null){
			apr = 0.0;
		}
		DecimalFormat formater = new DecimalFormat("###,##0.00");
	    formater.setMaximumFractionDigits(2);
	    formater.setGroupingSize(0);
	    formater.setRoundingMode(RoundingMode.FLOOR);
	    Double formatApr = Double.valueOf(formater.format(apr));
		return formatApr;
	}
	
	/**
	 * 两位小数 去尾
	 * @param apr
	 * @return
	 */
	public static String getStringFormatApr(Double apr) {
		if(apr == null){
			apr = 0.0;
		}
		DecimalFormat formater = new DecimalFormat("##0.00");
		formater.setMaximumFractionDigits(2);
		formater.setGroupingSize(0);
		formater.setRoundingMode(RoundingMode.FLOOR);
		return formater.format(apr);
	}
	
	/**
	 * 两位小数 默认去尾 可自传RoundingMode模式
	 * @param apr
	 * @return
	 */
	public static Double getFormatApr(Double apr,RoundingMode roundingMode) {
		if(apr == null){
			apr = 0.0;
		}
		
		if(roundingMode==null){
			roundingMode = RoundingMode.FLOOR;
		}
		DecimalFormat formater = new DecimalFormat("###,##0.00");
		formater.setMaximumFractionDigits(2);
		formater.setGroupingSize(0);
		formater.setRoundingMode(roundingMode);
		Double formatApr = Double.valueOf(formater.format(apr));
		return formatApr;
	}
	
	/**
	 * 格式化字符串
	 * @param obj 字符串
	 * @param start 显示前几位
	 * @param end   显示后几位
	 * @return
	 */
	public static String formatString(String obj,int start,int end){
		if(StringUtils.isBlank(obj)){
			return "";
		}
		
		StringBuffer buff = new StringBuffer(obj);
		
		for(int i=start;i<obj.length()-end;i++){
			buff.replace(i, i+1, "*");
		}
		return buff.toString();
	}
	
	/**
	 * 格式化手机号
	 * 默认显示前两位
	 * @param obj 字符串
	 * @return
	 */
	public static String formatMobile(String obj){
		return formatString(obj, 2, 0);
	}
	
	/**
	 * 格式化姓名
	 * 默认显示前一位
	 * @param obj 字符串
	 * @return
	 */
	public static String formatName(String obj){
		return formatString(obj, 1, 0);
	}
	
	/**
	 * 格式化身份证号
	 * 默认显示前三位,后三位
	 * @param obj 字符串
	 * @return
	 */
	public static String formatIdentity(String obj){
		return formatString(obj, 3, 3);
	}

	/**
	 * 格式化银行卡号
	 * Author Jzy
	 * 2016年8月11日 
	 * @param obj
	 * @return
	 */
	public static String formatBankCard(String obj){
		return formatString(obj, 4, 4);
	}
	
	/**
	 * double数据去尾保留scale位小数
	 * 
	 * @param source
	 * @param scale
	 * @return
	 */
	public static double doubleRoundDown(double source, int scale) {
		if (scale < 0) {
			throw new RuntimeException("小数位数不能小于0");
		}
		BigDecimal bigDecimal = BigDecimal.valueOf(source);
		return bigDecimal.setScale(scale, BigDecimal.ROUND_DOWN).doubleValue();
	}

	/**
	 * double数据四舍五入保留scale位小数
	 * 
	 * @param source
	 * @param scale
	 * @return
	 */
	public static double doubleRoundHalfUp(double source, int scale) {
		if (scale < 0) {
			throw new RuntimeException("小数位数不能小于0");
		}
		BigDecimal bigDecimal = BigDecimal.valueOf(source);
		return bigDecimal.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	/**
	 * 姓名显示规则：未实名认证成功（已汇付认证成功为准）用户显示“未实名”，实名认证成功用户当不少于3个字时，
	 * 显示首尾两个字（例如冯*滨），隐藏几个字显示几个*。当为2个字时，显示后面汉字（如叶总，显示为  *辉）
	 * Author Jzy
	 * 2017年3月14日 
	 * @param reality_name
	 * @return
	 */
	public static String formatXinUserName(boolean isOpenAccount,String obj) {
		if(!isOpenAccount){
			return "";
		}
		
		if(StringUtils.isBlank(obj)){
			return "";
		}
		
		//默认前0,后1
		int start = 0;
		int end = 1;
		StringBuffer buff = new StringBuffer(obj);
		
		if(isOpenAccount){
			if(obj.length()>2){
				//长度>2 则默认前1,后1
				start = 1;
			}
		}
		
		for(int i=start;i<obj.length()-end;i++){
			buff.replace(i, i+1, "*");
		}
		return buff.toString();
	}

	/** 
     * 将double格式化为指定小数位的String，不足小数位用0补全 
     * 
     * @param v     需要格式化的数字 
     * @param scale 小数点后保留几位 
     * @return 
     */  
    public static String roundByScale(double v, int scale) {  
        if (scale < 0) {  
            throw new IllegalArgumentException(  
                    "The   scale   must   be   a   positive   integer   or   zero");  
        }  
        if(scale == 0){  
            return new DecimalFormat("0").format(v);  
        }  
        String formatStr = "0.";  
        for(int i=0;i<scale;i++){  
            formatStr = formatStr + "0";  
        }  
        return new DecimalFormat(formatStr).format(v);  
    } 
	
}
