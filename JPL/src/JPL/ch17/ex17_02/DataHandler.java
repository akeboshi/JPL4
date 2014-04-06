package JPL.ch17.ex17_02;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;

class DataHandler {
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;

	byte[] readFile(File file) {
		byte[] data;

		if (lastFile != null && file.equals(lastFile.get())) {
			data = lastData.get();
			if (data != null)
				return data;
		}

		data = readByteFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
		return data;
	}

	public WeakReference<File> getLastFile(){
		return lastFile;
	}

	private static byte[] readByteFromFile(File file) {
		byte[] b = new byte[1];
		FileInputStream fileInputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;

		try {
			fileInputStream = new FileInputStream(file);
			byteArrayOutputStream = new ByteArrayOutputStream();

			while (fileInputStream.read(b) > 0) {
				byteArrayOutputStream.write(b);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (byteArrayOutputStream != null)
					byteArrayOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (fileInputStream != null)
					fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return byteArrayOutputStream.toByteArray();
	}
}