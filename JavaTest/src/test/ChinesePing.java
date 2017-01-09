package test;

import java.util.HashMap;
import java.util.Scanner;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
/**
 * http://www.youzitool.com/blog/32.html  得拼音的方式
 * http://blog.csdn.net/liyuanjinglyj/article/details/48709387  引入
 * http://www.bkjia.com/C_jc/522515.html  得字母
 * http://www.bkjia.com/Mysql/488494.html 得字母
 * 在as下行不通
 * http://noobjava.iteye.com/blog/855811
 * http://outofmemory.cn/code-snippet/13621/java-turn--get-letter-method
 * http://blog.csdn.net/ssrc0604hx/article/details/41725355
 * 排序：
 * http://www.jianshu.com/p/28f17939418a
 * @author better
 *
 */
public class ChinesePing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("我们".length());
        System.out.println("汉字转首字母演示，请输入汉字：");
        String str = sc.next();
        
        System.out.print("\r\npingy===：" + toPinyinString(str));
    	
//        String py1 = ChineseToFirstCharUtil.convertTo(str);
//        String py2 = ChineseToFirstCharUtil.convertAndClear(str);
//        String py3 = ChineseToFirstCharUtil.convertAndClearAll(str);
//       
//        System.out.print("\r\n直接转换convertTo：" + py1);
//        System.out.print("\r\n保留一些字符convertAndClear：" + py2);
//        System.out.print("\r\n仅保留字母和数字convertAndClearAll：" + py3);
//        System.out.print("\r\n首字母convertTo：" + ChineseToFirstCharUtil.getFirstSpell(str));
        
	}
	public static void l(String msg){
		System.out.println(msg);
	}
	
	//http://blog.csdn.net/xiao__gui/article/details/8558620
	public static String toPinyinString(String str){
		if (null == str || "".equals(str)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append(getPinyinString(str.charAt(i)));
		}
		return sb.toString();
	}
	/**
	 * 若为英文字符，则直接输出 若字符为多音字，则取第一个
	 */
	public static String getPinyinString(char c) {
		HanyuPinyinOutputFormat format=getPinyinFormat();
		try {
			String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(c, format);
			if (null == pinyin || pinyin.length < 1) {
				return String.valueOf(c);
			}
			return pinyin[0];
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	private static HanyuPinyinOutputFormat getPinyinFormat(){
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		/*
		 * UPPERCASE：大写 (ZHONG)
		 * LOWERCASE：小写 (zhong)
		 */
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		/*
		 * WITHOUT_TONE：无音标 (zhong)
		 * WITH_TONE_NUMBER：1-4数字表示英标 (zhong4)
		 * WITH_TONE_MARK：直接用音标符（必须WITH_U_UNICODE否则异常） (zhòng)
		 */
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		/*
		 * WITH_V：用v表示ü (nv)
		 * WITH_U_AND_COLON：用"u:"表示ü (nu:)
		 * WITH_U_UNICODE：直接用ü (nü)
		 */
		format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
		
		// 返回输出格式
		return format;
	}
	
	
	/**
	 * http://www.cnblogs.com/vir56k/p/4310239.html
	 * @author better
	 *
	 */
	public static class ChineseToFirstCharUtil {
		public static String getFirstSpell(String str){
			return convertTo(str).substring(0,1);
		}
	    /**
	     * 汉字转拼音缩写
	     *
	     * @param str
	     *            要转换的汉字字符串
	     * @return String 拼音缩写
	     */
	    public static String convertTo(String str) {
	        String tempStr = "";
	        for (int i = 0; i < str.length(); i++) {
	            char c = str.charAt(i);
	            l(String.valueOf(c));
	            if (c >= 33 && c <= 126) {// 字母和符号原样保留
	                tempStr += String.valueOf(c);
	            } else {// 累加拼音声母
	                tempStr += getPYChar(String.valueOf(c));
	            }
	        }
	        return tempStr;
	    }
	    
	    /**
	     * 汉字转拼音缩写，清理无效字符（保留一些键盘字符）
	     * @param str 汉字
	     * @return String 缩写
	     */
	    public static String convertAndClear(String str) {
	        return convertTo(str).replace("*", "");
	    }

	    /**
	     * 汉字转拼音缩写，清理无效字符（清理任何非数字和字母）
	     * @param str 汉字
	     * @return String 缩写
	     */
	    public static String convertAndClearAll(String str) {
	        String str1 =  convertTo(str).replace("*", "");
	        StringBuilder sb = new StringBuilder();
	        for(char c : str1.toCharArray()){
	            if((c>=48 && c<= 57) || (c>=65 && c<= 90)   || (c>=97 && c<= 122)){
	                sb.append(c);
	            }
	        }
	        return sb.toString();
	    }
	    
	    /**
	     * 取单个字符的拼音声母
	     *
	     * @param c
	     *            //要转换的单个汉字
	     * @return String 拼音声母
	     */
	    private static String getPYChar(String c) {
	        byte[] array = new byte[2];
	        array = String.valueOf(c).getBytes();
	        int i = (short) (array[0] - '\0' + 256) * 256
	                + ((short) (array[1] - '\0' + 256));
	        if (i < 0xB0A1)
	            return "*";
	        if (i < 0xB0C5)
	            return "A";
	        if (i < 0xB2C1)
	            return "B";
	        if (i < 0xB4EE)
	            return "C";
	        if (i < 0xB6EA)
	            return "D";
	        if (i < 0xB7A2)
	            return "E";
	        if (i < 0xB8C1)
	            return "F";
	        if (i < 0xB9FE)
	            return "G";
	        if (i < 0xBBF7)
	            return "H";
	        if (i < 0xBFA6)
	            return "J";
	        if (i < 0xC0AC)
	            return "K";
	        if (i < 0xC2E8)
	            return "L";
	        if (i < 0xC4C3)
	            return "M";
	        if (i < 0xC5B6)
	            return "N";
	        if (i < 0xC5BE)
	            return "O";
	        if (i < 0xC6DA)
	            return "P";
	        if (i < 0xC8BB)
	            return "Q";
	        if (i < 0xC8F6)
	            return "R";
	        if (i < 0xCBFA)
	            return "S";
	        if (i < 0xCDDA)
	            return "T";
	        if (i < 0xCEF4)
	            return "W";
	        if (i < 0xD1B9)
	            return "X";
	        if (i < 0xD4D1)
	            return "Y";
	        if (i < 0xD7FA)
	            return "Z";
	        return "*";
	    }
	}
}
