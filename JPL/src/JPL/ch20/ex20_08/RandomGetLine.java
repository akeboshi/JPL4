package JPL.ch20.ex20_08;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

class RandomGetLine{
	RandomAccessFile raf;
	ArrayList<Long> table = new ArrayList<Long>();

	RandomGetLine(String fileName) throws IOException {
		raf = new RandomAccessFile(fileName, "r");
		String line;
		Long point = raf.getFilePointer();
		while ((line = raf.readLine()) != null) {
			if (line.startsWith("%%")) {
				table.add(point);
			}
			point = raf.getFilePointer();
		}
	}

	String getLine() throws IOException {
		int lineNum = (int) (Math.floor (Math.random () * table.size()));
		raf.seek(table.get(lineNum));
		return raf.readLine();
	}

	public static void main(String[] args) {
		try {
			RandomGetLine rgl = new RandomGetLine("/Users/akari/git/JPL4/JPL/src/JPL/ch20/ex20_08/getLine.dat");
			for (int i = 0; i < 10; i++)
				System.out.println(rgl.getLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}