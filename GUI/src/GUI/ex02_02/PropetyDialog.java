package GUI.ex02_02;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class PropetyDialog extends Dialog implements ActionListener,ItemListener ,DocumentListener,AdjustmentListener{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	Color fontColor = new Color(0xff0000);
	Color backColor = new Color(0xffffff);
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel12 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel34 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	JPanel panel7 = new JPanel();
	JTextField textRed = new JTextField(Integer.toString(fontColor.getRed()), 3);
	JTextField textGreen = new JTextField(Integer.toString(fontColor.getGreen()),
			3);
	JTextField textBlue = new JTextField(Integer.toString(fontColor.getBlue()), 3);
	JTextField backTextRed = new JTextField(Integer.toString(backColor.getRed()),
			3);
	JTextField backTextGreen = new JTextField(Integer.toString(backColor
			.getGreen()), 3);
	JTextField backTextBlue = new JTextField(
			Integer.toString(backColor.getBlue()), 3);
	JTextField clockFontSize = new JTextField("1", 5);
	double clockFontSizeDouble = 1;
	Choice fontChoice = new Choice();
	String fontChoiceString = "Normal";
	ex02_02 ClockMain;
	JScrollBar bar= new JScrollBar(JScrollBar.HORIZONTAL, 100, 1, 10, 200);

	public PropetyDialog(ex02_02 ClockMain) {
		super(new Frame());
		this.ClockMain = ClockMain;
		setSize(400, 200);
		setResizable(false);
		setTitle("プロパティ");
		setLayout(new GridLayout(5, 1));
		add(panel1);
		add(panel2);
		add(panel6);
		add(panel7);
		add(panel5);

		JButton fontButton = new JButton("FontColor");
		panel1.add(fontButton);
		fontButton.addActionListener(this);

		JButton backButton = new JButton("BackgroundColor");
		panel2.add(backButton);
		backButton.addActionListener(this);

		// panel12.add(panel1);
		// panel12.add(panel2);
		// panel34.add(panel3);
		// panel34.add(panel4);
		//
		// panel1.add(new Label("font color"));
		//
		// panel2.add(new Label("R"));
		// panel2.add(textRed);
		//
		// panel2.add(new Label("G"));
		// panel2.add(textGreen);
		//
		// panel2.add(new Label("B"));
		// panel2.add(textBlue);
		//
		// panel3.add(new Label("back color"));
		//
		// panel4.add(new Label("R"));
		// panel4.add(backTextRed);
		//
		// panel4.add(new Label("G"));
		// panel4.add(backTextGreen);
		//
		// panel4.add(new Label("B"));
		// panel4.add(backTextBlue);

		panel6.add(new Label("font"));
		fontChoice.addItem("Normal");
		fontChoice.addItem("Binary");
		panel6.add(fontChoice);
		fontChoice.addItemListener(this);

//		panel7.add(new Label("font sizse"));
//		panel7.add(clockFontSize);
//		clockFontSize.getDocument().addDocumentListener(this);

		panel7.add(bar);
		bar.setPreferredSize(new Dimension(150, 17));
		bar.addAdjustmentListener(this);

		JButton okButton = new JButton("ok");
		panel5.add(okButton);
		okButton.setPreferredSize(new Dimension(200, 20));
		okButton.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				setVisible(false);
			}
		});
		this.repaint();

	}

	public void viewProperty() {
		setVisible(true);
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ok") {
//			if (textRed == null || textRed.getText().equals(""))
//				textRed.setText("0");
//			if (textGreen == null || textGreen.getText().equals(""))
//				textGreen.setText("0");
//			if (textBlue == null || textBlue.getText().equals(""))
//				textBlue.setText("0");
//			if (backTextRed == null || backTextRed.getText().equals(""))
//				backTextRed.setText("255");
//			if (backTextGreen == null || backTextGreen.getText().equals(""))
//				backTextGreen.setText("255");
//			if (backTextBlue == null || backTextBlue.getText().equals(""))
//				backTextBlue.setText("255");
//			if (clockFontSize == null || clockFontSize.getText().equals(""))
//				clockFontSize.setText("1");
//			ClockMain.fontSize = 1 / Double
//					.parseDouble(clockFontSize.getText());
//			ClockMain.repaint();
			setVisible(false);
		} else if (e.getActionCommand() == "FontColor") {
			ClockMain.fontColor = JColorChooser.showDialog(this, "色の選択",
					ClockMain.fontColor);

		} else if (e.getActionCommand() == "BackgroundColor") {

			ClockMain.backColor = JColorChooser.showDialog(this, "色の選択",
					ClockMain.backColor);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getSource());
		if (e.getSource() == fontChoice){
			ClockMain.fontStyle = fontChoice.getSelectedItem();
		}

	}

	@Override
	public void insertUpdate(DocumentEvent paramDocumentEvent) {
		ClockMain.fontSize = 1 / Double
				.parseDouble(clockFontSize.getText());

	}

	@Override
	public void removeUpdate(DocumentEvent paramDocumentEvent) {

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		ClockMain.fontSize = 1 / Double
				.parseDouble(clockFontSize.getText());

	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent paramAdjustmentEvent) {
		ClockMain.fontSize = 1 / (bar.getValue()/100.0);
	}
}