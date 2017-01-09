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
	 * ������url�����еļ�ֵ�� �� "index.jsp?Action=del&id=123"��������Action:del,id:123����map��
	 * 
	 * @param URL url��ַ
	 * @return url�����������
	 */
	public static Map<String, String> urlRequestP(String URL) {
		Map<String, String> mapRequest = new HashMap<String, String>();
		String[] arrSplitParameter ;
		String strUrlParam = urlTruncatePage(URL);
		if (strUrlParam == null) {
			return mapRequest;
		}
		// ÿ����ֵΪһ��
		arrSplitParameter = strUrlParam.split("[&]");
		for (String strSplit : arrSplitParameter) {
			String[] arrSplitEqual;
			arrSplitEqual = strSplit.split("[=]");
			// ��������ֵ
			if (arrSplitEqual.length > 1) {
				// ��ȷ���� value�ж��==
				String value=strSplit.substring(arrSplitEqual[0].length()+1, strSplit.length());
				mapRequest.put(arrSplitEqual[0], value);
			} else {
				if (arrSplitEqual[0] != "") {
					// ֻ�в���û��ֵ��������
					mapRequest.put(arrSplitEqual[0], "");
				}
			}
		}
		return mapRequest;
	}
	 /**
     * @param regex  ���ڱ��ʽ
     * @param string ƥ����ַ���
     * @return ���� ��ҪXXX����֧��
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
