package effectjava.builder;

/**
 * ���ԱȽ϶�ʱ
 * 
 * @author Better
 * 
 */
public class DialogController {
	public String mtitle;
	public String mcontent;
	public String mposttext;
	public String mnegText;

	public void apply(DialogController controller) {
		controller.mtitle = mtitle;
		controller.mcontent = mcontent;
		controller.mnegText = mnegText;
		controller.mposttext = mposttext;
	}
}
