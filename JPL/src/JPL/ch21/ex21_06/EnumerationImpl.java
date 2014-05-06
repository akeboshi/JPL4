package JPL.ch21.ex21_06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class EnumerationImpl implements Enumeration<InputStream> {
	private String[] fileList;
	private int count = 0;

	public EnumerationImpl(String[] fileList) {
		this.fileList = fileList;
	}

	@Override
	public boolean hasMoreElements() {
		if (count < fileList.length) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public InputStream nextElement() {
		InputStream in = null;
		if (!hasMoreElements()) {
			throw new NoSuchElementException();
		} else {
			String nextFile = fileList[count];
			count++;
			try {
				in = new FileInputStream(nextFile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return in;
	}
}
