package GUI.ex02_02;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

import javax.swing.JFrame;


public class ex02_02 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private PropetyDialog propertyDialog;
	private double resize = 1.0;

	public static void main(String args[]) {

		ex02_02 app = new ex02_02("");

		app.setSize(660, 360 + 50);
		app.setResizable(false);
		app.setVisible(true);
		app.startClock(app);
	}

	public ex02_02(String title) {
		super(title);
		propertyDialog = new PropetyDialog(this);
		generateMenu();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				System.exit(0);
			}
		});
	}

	public void update(Graphics g){
		paint(g);
	}

	public void startClock(ex02_02 clock) {
		while (true) {
			try {
				Thread.sleep(1);
				clock.repaint();
			} catch (InterruptedException e) {
				System.out.println("error" + e);
			}
		}
	}

	public void generateMenu() {
//		JMenuBar menubar = new JMenuBar();
//		setJMenuBar(menubar);
//
//		JMenu Menu1 = new JMenu("ファイル");
//		menubar.add(Menu1);
//
//		JMenuItem newm = new JMenuItem("プロパティ");
//		JMenuItem closem = new JMenuItem("閉じる");
//
//		// メニューアイテムの追加
//		Menu1.add(newm);
//		Menu1.add(closem);
//
//		// イベントリスクの設定
//		newm.addActionListener(this);
//		closem.addActionListener(this);

	}

	public void paint(Graphics g) {
		resize = propertyDialog.clockFontSizeDouble;
		this.setSize((int) (660 / resize), (int) (360 / resize) + 50);

		Dimension size = getSize();
		Image back = createImage(size.width, size.height);

		Graphics buffer = back.getGraphics();

		buffer.setColor(propertyDialog.backColor);
		buffer.fillRect(0, 0, (int) (660 / resize) + 1,
				(int) (360 / resize) + 50 + 1);


		g.drawImage(back, 0, 0, this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "プロパティ") {
			propertyDialog.viewProperty();
		} else if (e.getActionCommand() == "閉じる") {
			System.exit(0);
		}
	}
}

class PropetyDialog extends Dialog implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	Color fontColor = new Color(0xff0000);
	Color backColor = new Color(0xffffff);
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel12 = new Panel();
	Panel panel3 = new Panel();
	Panel panel4 = new Panel();
	Panel panel34 = new Panel();
	Panel panel5 = new Panel();
	Panel panel6 = new Panel();
	Panel panel7 = new Panel();
	TextField textRed = new TextField(Integer.toString(fontColor.getRed()), 3);
	TextField textGreen = new TextField(Integer.toString(fontColor.getGreen()),
			3);
	TextField textBlue = new TextField(Integer.toString(fontColor.getBlue()), 3);
	TextField backTextRed = new TextField(Integer.toString(backColor.getRed()),
			3);
	TextField backTextGreen = new TextField(Integer.toString(backColor
			.getGreen()), 3);
	TextField backTextBlue = new TextField(
			Integer.toString(backColor.getBlue()), 3);
	TextField clockFontSize = new TextField("1", 5);
	double clockFontSizeDouble = 1;
	Choice fontChoice = new Choice();
	String fontChoiceString = "Normal";
	Frame ClockMain;

	public PropetyDialog(Frame owner) {
		super(owner);
		ClockMain = owner;
		setSize(400, 200);
		setResizable(false);
		setTitle("プロパティ");
		setLayout(new GridLayout(5, 1));
		add(panel12);
		add(panel34);
		add(panel6);
		add(panel7);
		add(panel5);

		panel12.add(panel1);
		panel12.add(panel2);
		panel34.add(panel3);
		panel34.add(panel4);

		panel1.add(new Label("font color"));

		panel2.add(new Label("R"));
		panel2.add(textRed);

		panel2.add(new Label("G"));
		panel2.add(textGreen);

		panel2.add(new Label("B"));
		panel2.add(textBlue);

		panel3.add(new Label("back color"));

		panel4.add(new Label("R"));
		panel4.add(backTextRed);

		panel4.add(new Label("G"));
		panel4.add(backTextGreen);

		panel4.add(new Label("B"));
		panel4.add(backTextBlue);

		panel6.add(new Label("font"));
		fontChoice.addItem("Normal");
		fontChoice.addItem("Binary");
		panel6.add(fontChoice);

		panel7.add(new Label("font sizse"));
		panel7.add(clockFontSize);

		Button okButton = new Button("ok");
		okButton.setPreferredSize(new Dimension(200, 20));
		okButton.addActionListener(this);
		panel5.add(okButton);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				setVisible(false);
			}
		});

	}

	public void viewProperty() {


		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ok") {
			if(textRed == null || textRed.getText().equals(""))textRed.setText("0");
			if(textGreen == null || textGreen.getText().equals(""))textGreen.setText("0");
			if(textBlue == null || textBlue.getText().equals(""))textBlue.setText("0");
			if(backTextRed == null || backTextRed.getText().equals(""))backTextRed.setText("255");
			if(backTextGreen == null || backTextGreen.getText().equals(""))backTextGreen.setText("255");
			if(backTextBlue == null || backTextBlue.getText().equals(""))backTextBlue.setText("255");
			if(clockFontSize == null || clockFontSize.getText().equals(""))clockFontSize.setText("1");
			fontColor = new Color(Integer.parseInt(textRed.getText()),
					Integer.parseInt(textGreen.getText()),
					Integer.parseInt(textBlue.getText()));
			backColor = new Color(Integer.parseInt(backTextRed.getText()),
					Integer.parseInt(backTextGreen.getText()),
					Integer.parseInt(backTextBlue.getText()));
			clockFontSizeDouble = 1 / Double.parseDouble(clockFontSize
					.getText());
			fontChoiceString = fontChoice.getSelectedItem();
			ClockMain.repaint();
		}

	}
}
