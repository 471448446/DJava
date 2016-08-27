package effectjava.builder;

public class Dialog2 {
	private DialogController controller;

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
		private DialogController controller;

		public Builder() {
			// TODO Auto-generated constructor stub
			controller = new DialogController();
		}

		public Builder setTitle(String title) {
			controller.mtitle = title;
			return this;
		}

		public Builder setContent(String title) {
			controller.mcontent = title;
			return this;
		}

		public Builder setNegText(String title) {
			controller.mnegText = title;
			return this;
		}

		public Builder setPosText(String title) {
			controller.mposttext = title;
			return this;
		}

		/**
		 * 返回外层类
		 * 
		 * @return
		 */
		public Dialog2 create() {
			// return new Dialog2(this);
			final Dialog2 dialog2 = new Dialog2();
			// 赋值
			controller.apply(dialog2.controller);
			return dialog2;
		}

		public Dialog2 show() {
			Dialog2 dialog2 = create();
			dialog2.show();
			return dialog2;
		}
	}

	/**
	 * 带有类不类参数的 构造函数
	 * 
	 * @param builder
	 */

	private Dialog2() {
		controller= new DialogController();
	}

	public String show() {
		return "dialog内容:" + controller.mtitle + "," + controller.mcontent
				+ "," + controller.mposttext + "," + controller.mnegText;
	}
}
