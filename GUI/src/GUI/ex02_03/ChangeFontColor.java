package GUI.ex02_03;

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
		if (e.getActionCommand() == "Red") {
			watch.fontColor = Color.RED;
		} else if (e.getActionCommand() == "Green") {
			watch.fontColor = Color.GREEN;
		} else if (e.getActionCommand() == "Pink") {
			watch.fontColor = Color.PINK;
		} else if (e.getActionCommand() == "Yellow") {
			watch.fontColor = Color.YELLOW;
		}
	}
}