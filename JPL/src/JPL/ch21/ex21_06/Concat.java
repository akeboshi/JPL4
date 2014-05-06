package JPL.ch21.ex21_06;

import java.io.IOException;
import java.io.InputStream;

public class Concat {

    public static void concat(String[] fileList) throws IOException{
    	EnumerationImpl ei = new EnumerationImpl(fileList);
    	while (ei.hasMoreElements()){
    		InputStream in = ei.nextElement();
    		int ch;
    		while((ch = in.read()) != -1){
    			System.out.println((char)ch);
    		}
    	}
    }
}