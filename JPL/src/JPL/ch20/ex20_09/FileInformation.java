package JPL.ch20.ex20_09;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

class FileInformation {
	private HashMap<String, String> info = new HashMap<>();

	FileInformation(String filenName) throws IOException {
		File file = new File(filenName);
		info.put("AbsolutePath", file.getAbsolutePath());
		info.put("CanonicalPath", file.getCanonicalPath());
		info.put("Name", file.getName());
		info.put("Parent", file.getParent());
		info.put("Path", file.getPath());
		info.put("AbsoluteFile", file.getAbsoluteFile().toString());
		info.put("CanonicalFile", file.getCanonicalFile().toString());
		info.put("FreeSpace", Long.toString(file.getFreeSpace()));
		info.put("TotalSpace", Long.toString(file.getTotalSpace()));
		info.put("UsableSpace", Long.toString(file.getUsableSpace()));
		info.put("isAbsolute", Boolean.toString(file.isAbsolute()));
		info.put("isDirectory", Boolean.toString(file.isDirectory()));
		info.put("isFile", Boolean.toString(file.isFile()));
		info.put("isHidden", Boolean.toString(file.isHidden()));
		info.put("canExcute", Boolean.toString(file.canExecute()));
		info.put("canRead", Boolean.toString(file.canRead()));
		info.put("canWrite", Boolean.toString(file.canWrite()));
		info.put("lastModified", Long.toString(file.lastModified()));
	}

	String getVal(String key) {
		return info.get(key);
	}

	HashMap<String, String> getValAll() {
		return info;
	}

	public static void main(String[] args) {
		try {
			FileInformation fi = new FileInformation(
					"/Users/akari/git/JPL4/JPL/src/JPL/ch20/ex20_08/getLine.dat");
			HashMap<String, String> map = fi.getValAll();
			Set<String> set = map.keySet();
			for (String key : set)
				System.out.println(key + " : " + map.get(key));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}