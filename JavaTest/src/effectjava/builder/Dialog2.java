package effectjava.builder;

public class Dialog2 {
	private DialogController controller;

	/**
	 * ��̬��
	 * 
	 * @author Better
	 * 
	 */
	public static class Builder {
		/**
		 * ��android
		 * AlertDialogԴ�����֪�����ⲿ��˽�б���Ҳ���Է⵽һ���������棬��������Ϊpublic���ڵ���apply������������ֵ��
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
		 * ���������
		 * 
		 * @return
		 */
		public Dialog2 create() {
			// return new Dialog2(this);
			final Dialog2 dialog2 = new Dialog2();
			// ��ֵ
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
	 * �����಻������� ���캯��
	 * 
	 * @param builder
	 */

	private Dialog2() {
		controller= new DialogController();
	}

	public String show() {
		return "dialog����:" + controller.mtitle + "," + controller.mcontent
				+ "," + controller.mposttext + "," + controller.mnegText;
	}
}
