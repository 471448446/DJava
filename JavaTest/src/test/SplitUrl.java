package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitUrl {
	static String Url = "http://testpic.easylines.cn:9999/pic/customer/coment.html?type=-1&show=0&data=b5bpmxdSwnw1ND91WI1C7H/Ud/aM8CpSSeAyZBIgxDg=&action=0";

	public static void main(String[] args) {
//		RegexFind("\\b\\w+=\\w+", Url);
		System.out.println(urlTruncatePage(Url));
		Map<String, String> map = urlRequestP(Url);
		for(String key:map.keySet()){
			l("key="+key+",value="+map.get(key));
		}
	}

	private static String urlTruncatePage(String strURL) {
		String strAllParam = null;
		String[] arrSplit = null;
//		strURL = strURL.trim().toLowerCase();
		strURL = strURL.trim();
		arrSplit = strURL.split("[?]");
		if (strURL.length() > 1) {
			if (arrSplit.length > 1) {
				if (arrSplit[1] != null) {
					strAllParam = arrSplit[1];
				}
			}
		}

		return strAllParam;
	}

	/**
	 * 解析出url参数中的键值对 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
	 * 
	 * @param URL url地址
	 * @return url请求参数部分
	 */
	public static Map<String, String> urlRequestP(String URL) {
		Map<String, String> mapRequest = new HashMap<String, String>();
		String[] arrSplitParameter ;
		String strUrlParam = urlTruncatePage(URL);
		if (strUrlParam == null) {
			return mapRequest;
		}
		// 每个键值为一组
		arrSplitParameter = strUrlParam.split("[&]");
		for (String strSplit : arrSplitParameter) {
			String[] arrSplitEqual;
			arrSplitEqual = strSplit.split("[=]");
			// 解析出键值
			if (arrSplitEqual.length > 1) {
				// 正确解析 value有多个==
				String value=strSplit.substring(arrSplitEqual[0].length()+1, strSplit.length());
				mapRequest.put(arrSplitEqual[0], value);
			} else {
				if (arrSplitEqual[0] != "") {
					// 只有参数没有值，不加入
					mapRequest.put(arrSplitEqual[0], "");
				}
			}
		}
		return mapRequest;
	}
	 /**
     * @param regex  正在表达式
     * @param string 匹配的字符串
     * @return 用于 需要XXX分钟支付
     */
    public static String RegexFind(String regex, String string) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        String res = string;
        while (matcher.find()) {
            res = matcher.group();
            l("RegexFind "+regex+" = "+res);
        }
        return res;
    }
    public static List<String> RegexFinds(String regex, String string) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        String res = string;
        List<String> list=new ArrayList<String>();
        while (matcher.find()) {
            res = matcher.group();
            list.add(matcher.group());
            l("RegexFinds "+regex+" = "+res);
        }
        return list;
    }
	private static void l(String msg){
		System.out.println(msg);
	}

}
