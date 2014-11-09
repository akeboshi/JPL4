package JPL.ch20.ex20_11;

import java.io.File;
import java.io.FilenameFilter;

class SuffixFilter implements FilenameFilter{
	private String suffix;
	
	public SuffixFilter(String suffix){
		this.suffix = suffix;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(suffix);
	}
	
}