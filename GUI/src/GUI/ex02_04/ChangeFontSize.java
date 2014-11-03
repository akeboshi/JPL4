package GUI.ex02_04;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ChangeFontSize implements ActionListener {

	private ex02_04 tokei;

	public ChangeFontSize(ex02_04 ex) {
		this.tokei = ex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "0.5") {
			tokei.fontSize = 1/0.5;
		} else if (e.getActionCommand() == "1.0") {
			tokei.fontSize = 1/1.0;
		} else if (e.getActionCommand() == "1.5") {
			tokei.fontSize = 1/1.5;
		} else if (e.getActionCommand() == "2.0") {
			tokei.fontSize = 1/2.0;
		}
	}
}

