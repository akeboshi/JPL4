package JPL.ch17.ex17_02;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ref.WeakReference;

import org.junit.Test;

public class DataHandlerTest {

	@Test
	public void test() {
		File file = new File("test.dat");
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(file);
			fileWriter.write("foo bar");
		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if(fileWriter != null)
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		DataHandler dataHandler = new DataHandler();
		byte[] b;

		b = dataHandler.readFile(new File("test.dat"));
		assertEquals(new String(b), "foo bar");
		WeakReference<File> weakFile = dataHandler.getLastFile();

		assertNotNull(weakFile.get()); //改修前
		Runtime.getRuntime().gc(); // 回収
		assertNull(weakFile.get()); // 回収済み
	}

}
