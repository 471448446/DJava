package effectjava.builder;

public class BuilderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dialog dialog = new Dialog.Builder().setTitle("hEllo").setContent("内容")
				.setNegText("取消 ").create();
		Dialog2 dialog2 = new Dialog2.Builder().setTitle("hEllo")
				.setContent("内容").setPosText("确定").setNegText("取消 ").create();
		System.out.println(dialog.show() + "\n" + dialog2.show());
	}

}
