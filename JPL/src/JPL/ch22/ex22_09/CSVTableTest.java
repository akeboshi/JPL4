package JPL.ch22.ex22_09;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import org.junit.Test;


public class CSVTableTest {
	private static final String path = new File("").getAbsolutePath()
			+ "/src/JPL/ch22/ex22_08/test.csv";
	private static final int NUM = 10000;
	@Test
	public void test() throws Exception {
		culc("^(.*),(.*),(.*)");
		culc("^([^,]*),([^,]*),([^,]*)$");
		culc("^([^,]+),([^,]+),([^,]+)$");
		culc("^([^,]+?),([^,]+?),([^,]+?)$");

	}

	private void culc(String exp) throws Exception{
		long start = System.currentTimeMillis();
		for(int i = 0 ; i < NUM ; i++)
			CSVTable.readCSVTable(new FileReader(path), 3 , exp);
		long end = System.currentTimeMillis();
		List<String[]> list = CSVTable.readCSVTable(new FileReader(path), 3 , exp);

		System.out.println("正規表現:" + exp + "  時間:" + (end -start));
		StringBuilder sb = new StringBuilder();
		for (String[] ss : list) {
			for (String s : ss) {
				sb.append(s);
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}


}
