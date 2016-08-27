package effectjava.builder;

import java.sql.Date;

public class Dialog {
	private String mtitle;
	private String mcontent;
	private String mposttext;
	private String mnegText;

	/**
	 * 静态类
	 * 
	 * @author Better
	 * 
	 */
	public static class Builder {
		/**
		 * 由android
		 * AlertDialog源码可以知道。这部分私有变量也可以封到一个类里里面，访问属性为public，在调用apply（）函数来赋值。
		 */
		private String mtitle;
		private String mcontent;
		private String mposttext;
		private String mnegText;

		public Builder setTitle(String title) {
			mtitle = title;
			return this;
		}

		public Builder setContent(String title) {
			mcontent = title;
			return this;
		}

		public Builder setNegText(String title) {
			mnegText = title;
			return this;
		}

		public Builder setPosText(String title) {
			mposttext = title;
			return this;
		}

		/**
		 * 返回外层类
		 * 
		 * @return
		 */
		public Dialog create() {
			// compareTo的compareTo方法
			// Date date= new Date(2012, 1, 1);
			// Date date2= new Date(2012, 1, 1);
			// date.compareTo(date2);
			return new Dialog(this);
		}
	}

	/**
	 * 带有类不类参数的 构造函数
	 * 
	 * @param builder
	 */
	private Dialog(Builder builder) {
		mtitle = builder.mtitle;
		mcontent = builder.mcontent;
		mposttext = builder.mposttext;
		mnegText = builder.mnegText;
	}

	public String show() {
		// TODO Auto-generated method stub
		return "dialog内容:" + mtitle + "," + mcontent + "," + mposttext + ","
				+ mnegText;
	}
}
