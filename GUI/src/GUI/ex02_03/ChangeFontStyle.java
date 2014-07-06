package GUI.ex02_03;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class ChangeFontStyle implements ActionListener {

	private ex02_03 tokei;

	public ChangeFontStyle(ex02_03 ex) {
		this.tokei = ex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Normal") {
			tokei.fontStyle = "Normal";
		} else if (e.getActionCommand() == "Binary") {
			tokei.fontStyle = "Binary";
		}
	}

}

