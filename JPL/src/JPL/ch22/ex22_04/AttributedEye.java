package JPL.ch22.ex22_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class AttributedEye<E> implements Observer {
	AttributedImpl<E> watching;
	public List<Object> test = new ArrayList<>();

	public AttributedEye(AttributedImpl<E> attributed) {
		watching = attributed;
		watching.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o != watching) {
			throw new IllegalArgumentException();
		}
		test.add(arg);
		System.out.println(arg);
	}

}