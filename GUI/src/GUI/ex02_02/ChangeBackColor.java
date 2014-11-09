package GUI.ex02_02;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ChangeBackColor implements ActionListener {

	private ex02_02 tokei;

	public ChangeBackColor(ex02_02 ex) {
		this.tokei = ex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "White") {
			tokei.backColor = Color.WHITE;
		} else if (e.getActionCommand() == "Blue") {
			tokei.backColor = Color.BLUE;
		} else if (e.getActionCommand() == "DarkGray") {
			tokei.backColor = Color.DARK_GRAY;
		} else if (e.getActionCommand() == "LightGray") {
			tokei.backColor = Color.LIGHT_GRAY;
		}
	}
}

