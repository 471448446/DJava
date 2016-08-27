package effectjava.builder;

import java.sql.Date;

public class Dialog {
	private String mtitle;
	private String mcontent;
	private String mposttext;
	private String mnegText;

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
		 * ���������
		 * 
		 * @return
		 */
		public Dialog create() {
			// compareTo��compareTo����
			// Date date= new Date(2012, 1, 1);
			// Date date2= new Date(2012, 1, 1);
			// date.compareTo(date2);
			return new Dialog(this);
		}
	}

	/**
	 * �����಻������� ���캯��
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
		return "dialog����:" + mtitle + "," + mcontent + "," + mposttext + ","
				+ mnegText;
	}
}
