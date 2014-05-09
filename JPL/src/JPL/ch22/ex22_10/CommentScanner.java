package JPL.ch22.ex22_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommentScanner {

	// 無視される文字列
	public static void main(String[] args) {
		String file = new File("").getAbsolutePath()
				+ "/src/JPL/ch22/ex22_10/CommentScanner.java";
		List<String> list = null;
		try {
			list = new CommentScanner().read(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		for(String s: list)
			System.out.println(s);
	}

	public List<String> read(Readable source) {
		Scanner scan = new Scanner(source);
		scan.useDelimiter("//.*");
		List<String> list = new ArrayList<>();
		while (scan.hasNext()) {
			list.add(scan.next());
		}
		scan.close();
		return list;
	}
}