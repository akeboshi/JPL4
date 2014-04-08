package JPL.ch20.ex20_11;

import java.io.File;

class FileDisp{
	public void dispFile(File dir,String suffix){
		String[] files = dir.list(new SuffixFilter(suffix));
		for(String file : files)
			System.out.println(file);
	}
	
	public static void main(String[] args) {
		FileDisp fd = new FileDisp();
		fd.dispFile(new File("/Users/akari/git/JPL4/JPL/src/JPL/ch20/ex20_11"), ".java");
	}
}