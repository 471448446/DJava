package sometest.refractor;

public class TomName extends BaseClass {

	@Override
	protected void addname2() {
		// TODO Auto-generated method stub
		System.out.println(getTag() + " ,调用addname2()");
	}

	@Override
	protected void addName1() {
		System.out.println(getTag() + " ,调用addname1()");
	}

	@Override
	protected String getTag() {
		// TODO Auto-generated method stub
		return TomName.class.getSimpleName();
	}

}
