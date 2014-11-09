package JPL.ch22.ex22_12;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class ReadAttr{
	@SuppressWarnings({ "rawtypes", "unchecked","resource" })
	public static Attributed readAttr(Reader source) throws IOException{
		Scanner in = new Scanner(source);
		AttributedImpl attrs = new AttributedImpl();
		Attr attr = null;
		while(in.hasNext()){
			if(attr != null){
				attr.setValue(in.next());
				attr = null;
			}
			else{
				attr = new Attr(in.next());
				attrs.add(attr);
			}
		}
		return attrs;
	}
}