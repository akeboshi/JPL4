package GUI.ex02_04;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ChangeFontColor implements ActionListener {
	private ex02_03 watch;

	public ChangeFontColor(ex02_03 ex) {
		this.watch = ex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "<html><font color=red>■</font>Red</html>") {
			watch.fontColor = Color.RED;
		} else if (e.getActionCommand() == "<html><font color=green>■</font>Green</html>") {
			watch.fontColor = Color.GREEN;
		} else if (e.getActionCommand() == "<html><font color=pink>■</font>Pink</html>") {
			watch.fontColor = Color.PINK;
		} else if (e.getActionCommand() == "<html><font color=yellow>■</font>Yellow</html>") {
			watch.fontColor = Color.YELLOW;
		}
	}
}