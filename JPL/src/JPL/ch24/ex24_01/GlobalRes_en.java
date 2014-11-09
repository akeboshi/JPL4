package JPL.ch24.ex24_01;

import java.util.ListResourceBundle;

public class GlobalRes_en extends ListResourceBundle{
	public static final String HELLO = "hello";
	public static final String GOODBYE = "goodbye";

	private static final Object[][] contents = {
		{ GlobalRes.HELLO, "Hello"},
		{ GlobalRes.GOODBYE, "Goodbye"},
	};

	@Override
	protected Object[][] getContents() {
		return contents;
	}

}