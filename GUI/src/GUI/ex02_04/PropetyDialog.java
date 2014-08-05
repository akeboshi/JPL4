package GUI.ex02_04;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

class PropetyDialog extends JDialog implements ActionListener,ItemListener,AdjustmentListener{
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
	ex02_03 ClockMain;
	JScrollBar bar= new JScrollBar(JScrollBar.HORIZONTAL, 100, 1, 10, 200);
	private Color saveBackColor;
	private Color saveFontColor;
	private String saveFontStyle;
	private double saveFontSize;

	public PropetyDialog(ex02_03 ClockMain) {
		super(new Frame());
		this.ClockMain = ClockMain;
		setSize(400, 200);
		setResizable(false);
		setTitle("プロパティ");

		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		Label fontLabel = new Label("font color");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 100;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(fontLabel, gbc);
		add(fontLabel);

		// フォントカラー表示
		JButton fontButton = new JButton("FontColor");
		gbc.gridx = 100;
		gbc.gridy = 0;
		gbc.gridwidth = 100;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		layout.setConstraints(fontButton, gbc);
		add(fontButton);
		fontButton.addActionListener(this);

		// バックグラウンドカラー
		Label backLabel = new Label("background color");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 100;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(backLabel, gbc);
		add(backLabel);

		JButton backButton = new JButton("BackgroundColor");
		gbc.gridx = 100;
		gbc.gridy = 1;
		gbc.gridwidth = 100;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		layout.setConstraints(backButton, gbc);
		add(backButton);
		backButton.addActionListener(this);

		// フォントスタイル
		JLabel labelFontStyle = new JLabel("font style");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 100;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(labelFontStyle, gbc);
		add(labelFontStyle);

		fontChoice.addItem("Normal");
		fontChoice.addItem("Binary");
		gbc.gridx = 100;
		gbc.gridy = 2;
		gbc.gridwidth = 100;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.WEST;
		layout.setConstraints(fontChoice, gbc);
		add(fontChoice);
		fontChoice.addItemListener(this);

		// フォントサイズ
		JLabel labelFontSize = new JLabel("size");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 100;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(labelFontSize, gbc);
		add(labelFontSize);

		gbc.gridx = 100;
		gbc.gridy = 3;
		gbc.gridwidth = 100;
		gbc.gridheight = 1;
		bar.setPreferredSize(new Dimension(150, 15));
		setMinimumSize(bar.getPreferredSize());
		panel1.add(bar);
		layout.setConstraints(panel1, gbc);
		panel1.setMinimumSize(new Dimension((int)bar.getPreferredSize().getWidth(),(int)bar.getPreferredSize().getHeight()+5));
		add(panel1);
		bar.addAdjustmentListener(this);


		JButton okButton = new JButton("ok");
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 100;
		gbc.gridheight = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		layout.setConstraints(okButton, gbc);
		add(okButton);
		okButton.setPreferredSize(new Dimension(200, 20));
		okButton.addActionListener(this);

		JButton cancelButton = new JButton("cancel");
		gbc.gridx = 100;
		gbc.gridy = 4;
		gbc.gridwidth = 100;
		gbc.gridheight = 1;
		layout.setConstraints(cancelButton, gbc);
		add(cancelButton);
		cancelButton.setPreferredSize(new Dimension(200, 20));
		cancelButton.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				setVisible(false);
			}
		});

	}

	public void viewProperty() {
		if (!isVisible()){
			saveBackColor = ClockMain.backColor;
			saveFontColor = ClockMain.fontColor;
			saveFontSize = ClockMain.fontSize;
			saveFontStyle = ClockMain.fontStyle;
		}

		System.out.println(ClockMain.fontSize);
		bar.setValue((int)(100.0/ClockMain.fontSize));
		System.out.println(bar.getValue());
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ok") {
			setVisible(false);
		} else if (e.getActionCommand() == "FontColor") {
			ClockMain.fontColor = JColorChooser.showDialog(this, "色の選択",
					ClockMain.fontColor);

		} else if (e.getActionCommand() == "BackgroundColor") {

			ClockMain.backColor = JColorChooser.showDialog(this, "色の選択",
					ClockMain.backColor);
		} else if (e.getActionCommand() == "cancel"){
			ClockMain.backColor = saveBackColor;
			ClockMain.fontColor = saveFontColor;
			ClockMain.fontSize = saveFontSize;
			ClockMain.fontStyle = saveFontStyle;
			setVisible(false);
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
	public void adjustmentValueChanged(AdjustmentEvent paramAdjustmentEvent) {
		ClockMain.fontSize = 1 / (bar.getValue()/100.0);
	}
}