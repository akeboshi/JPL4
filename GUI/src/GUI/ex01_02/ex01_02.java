package GUI.ex01_02;

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
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;


public class ex01_02 extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private PropetyDialog propertyDialog;
	private double resize = 1.0;

	public static void main(String args[]) {

		ex01_02 app = new ex01_02("");

		app.setSize(660, 360 + 50);
		app.setResizable(false);
		app.setVisible(true);
		app.startClock(app);
	}

	public ex01_02(String title) {
		super(title);
		propertyDialog = new PropetyDialog(this);
		generateMenu();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				System.exit(0);
			}
		});
	}

	public void startClock(ex01_02 clock) {
		while (true) {
			try {
				Thread.sleep(1000);
				clock.repaint();
			} catch (InterruptedException e) {
				System.out.println("error" + e);
			}
		}
	}

	public void generateMenu() {
		MenuBar menubar = new MenuBar();
		setMenuBar(menubar);

		Menu Menu1 = new Menu("ファイル");
		menubar.add(Menu1);

		MenuItem newm = new MenuItem("プロパティ");
		MenuItem closem = new MenuItem("閉じる");

		// メニューアイテムの追加
		Menu1.add(newm);
		Menu1.add(closem);

		// イベントリスクの設定
		newm.addActionListener(this);
		closem.addActionListener(this);

	}

	public void paint(Graphics g) {
		resize = propertyDialog.clockFontSizeDouble;
		this.setSize((int) (660 / resize), (int) (360 / resize) + 50);
		g.setColor(propertyDialog.backColor);
		g.fillRect(0, 0, (int) (660 / resize) + 1,
				(int) (360 / resize) + 50 + 1);

		Dimension size = getSize();
		Image back = createImage(size.width, size.height);

		Graphics buffer = back.getGraphics();

		Calendar cal1 = Calendar.getInstance();
		int hour = cal1.get(Calendar.HOUR_OF_DAY);
		int minute = cal1.get(Calendar.MINUTE);
		int second = cal1.get(Calendar.SECOND);
		set_time(buffer, 0, hour / 10);
		set_time(buffer, 1, hour % 10);
		set_time(buffer, 2, minute / 10);
		set_time(buffer, 3, minute % 10);
		set_time(buffer, 4, second / 10);
		set_time(buffer, 5, second % 10);
		g.drawImage(back, 0, 0, this);
	}

	void set_time(Graphics g, int area, int num) {
		g.setColor(propertyDialog.fontColor);
		int x = area * 100;
		if (propertyDialog.fontChoiceString.equals("Normal")) {
			switch (num) {
			case 0:
				zero(g, x);
				break;
			case 1:
				one(g, x);
				break;
			case 2:
				two(g, x);
				break;
			case 3:
				three(g, x);
				break;
			case 4:
				four(g, x);
				break;
			case 5:
				five(g, x);
				break;
			case 6:
				six(g, x);
				break;
			case 7:
				seven(g, x);
				break;
			case 8:
				eight(g, x);
				break;
			case 9:
				nine(g, x);
				break;
			default:
				break;
			}
		} else if (propertyDialog.fontChoiceString.equals("Binary")) {
			switch (num) {
			case 0:
				zero2(g, x);
				break;
			case 1:
				one2(g, x);
				break;
			case 2:
				two2(g, x);
				break;
			case 3:
				three2(g, x);
				break;
			case 4:
				four2(g, x);
				break;
			case 5:
				five2(g, x);
				break;
			case 6:
				six2(g, x);
				break;
			case 7:
				seven2(g, x);
				break;
			case 8:
				eight2(g, x);
				break;
			case 9:
				nine2(g, x);
				break;
			default:
				break;
			}
		}

	}

	public void zero(Graphics g, int x) {
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (310 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
	}

	public void one(Graphics g, int x) {
		g.fillRect((int) ((90 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
	}

	public void two(Graphics g, int x) {
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (180 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (310 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
	}

	public void three(Graphics g, int x) {
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (180 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (310 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
	}

	public void four(Graphics g, int x) {
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (180 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
	}

	public void five(Graphics g, int x) {
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (180 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (310 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
	}

	public void six(Graphics g, int x) {
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (180 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (310 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
	}

	public void seven(Graphics g, int x) {
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
	}

	public void eight(Graphics g, int x) {
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (180 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (310 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));

	}

	public void nine(Graphics g, int x) {
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (50 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (180 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((30 + x) / resize), (int) (310 / resize) + 50,
				(int) (80 / resize), (int) (20 / resize));
		g.fillRect((int) ((90 + x) / resize), (int) (180 / resize) + 50,
				(int) (20 / resize), (int) (150 / resize));

	}

	public void zero2(Graphics g, int x) {
		drawClockCircle(g, (int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (120 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (190 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (260 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
	}

	public void one2(Graphics g, int x) {
		g.fillOval((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (120 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (190 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (260 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
	}

	public void two2(Graphics g, int x) {
		drawClockCircle(g, (int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		g.fillOval((int) ((30 + x) / resize), (int) (120 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (190 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (260 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
	}

	public void three2(Graphics g, int x) {
		g.fillOval((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		g.fillOval((int) ((30 + x) / resize), (int) (120 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (190 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (260 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
	}

	public void four2(Graphics g, int x) {
		drawClockCircle(g, (int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (120 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		g.fillOval((int) ((30 + x) / resize), (int) (190 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (260 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
	}

	public void five2(Graphics g, int x) {
		g.fillOval((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (120 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		g.fillOval((int) ((30 + x) / resize), (int) (190 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (260 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
	}

	public void six2(Graphics g, int x) {
		drawClockCircle(g, (int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		g.fillOval((int) ((30 + x) / resize), (int) (120 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		g.fillOval((int) ((30 + x) / resize), (int) (190 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (260 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
	}

	public void seven2(Graphics g, int x) {
		g.fillOval((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		g.fillOval((int) ((30 + x) / resize), (int) (120 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		g.fillOval((int) ((30 + x) / resize), (int) (190 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (260 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
	}

	public void eight2(Graphics g, int x) {
		drawClockCircle(g, (int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (120 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (190 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		g.fillOval((int) ((30 + x) / resize), (int) (260 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
	}

	public void nine2(Graphics g, int x) {
		g.fillOval((int) ((30 + x) / resize), (int) (50 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (120 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		drawClockCircle(g, (int) ((30 + x) / resize),
				(int) (190 / resize) + 50, (int) (80 / resize),
				(int) (80 / resize));
		g.fillOval((int) ((30 + x) / resize), (int) (260 / resize) + 50,
				(int) (80 / resize), (int) (80 / resize));
	}

	public void drawClockCircle(Graphics g, int x, int y, int width, int height) {
		g.fillOval(x, y, width, height);
		g.setColor(propertyDialog.backColor);
		g.fillOval(x + (int) (5 / resize), y + (int) (5 / resize), width
				- (int) (10 / resize), height - (int) (10 / resize));
		g.setColor(propertyDialog.fontColor);
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
