package JPL.ch21.ex21_05;

import java.util.ListIterator;

import org.junit.Test;

public class ArrayBunchListTest {

	@Test
	public void test() {
		String[][] arrays = new String[3][];
		char c = 'A';
		for (int i = 0; i < arrays.length; i++) {
			arrays[i] = new String[i + 1];
			for (int j = 0; j < arrays[i].length; j++) {
				arrays[i][j] = String.valueOf(c++);
			}
		}

		ListIterator<String> i = new ArrayBunchList<String>(arrays)
				.listIterator();

		try {
			i.set("aa");
		} catch (IllegalStateException e) {
			System.out.println("next or Previos 呼び出し前にsetメソッドは使用できません");
		}

		while (i.hasNext()) {
			System.out.println("値 = " + i.next() + "\t 次のindex = "
					+ i.nextIndex());
		}
		// setのテスト
		i.previous();
		i.previous();
		i.set("CH");
		i.next();
		i.next();
		System.out.println();
		while (i.hasPrevious()) {
			System.out.println("値 = " + i.previous() + "\t 前のindex = "
					+ i.previousIndex());
		}
	}
}
