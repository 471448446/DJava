package sometest.refractor;

public abstract class BaseClass {
	public BaseClass(){
		System.out.println(getTag()+"���쿪ʼ����start ");
		addName1();
		addname2();
		System.out.println(getTag()+"���쿪ʼ���� end");
	}
	protected void addName1() {
		
	}
	protected abstract void addname2();
	protected abstract String getTag();
}
