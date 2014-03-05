package GUI.ex01_04;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import java.util.prefs.Preferences;

import javax.swing.text.StyledEditorKit.FontSizeAction;


public class ex01_04 extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private PropetyDialog propertyDialog;
	private double resize = 1.0;

	public static void main(String args[]) {

		ex01_04 app = new ex01_04("");

		app.setSize(660, 360 + 50);
		app.setResizable(false);
		app.setVisible(true);
		app.startClock(app);
	}

	public ex01_04(String title) {
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

	public void startClock(ex01_04 clock) {
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

		Dimension size = getSize();
		Image back = createImage(size.width, size.height);

		Graphics buffer = back.getGraphics();

		buffer.setColor(propertyDialog.backColor);
		buffer.fillRect(0, 0, (int) (660 / resize) + 1,
				(int) (360 / resize) + 50 + 1);

		Calendar cal1 = Calendar.getInstance();
		int hour = cal1.get(Calendar.HOUR_OF_DAY);
		int minute = cal1.get(Calendar.MINUTE);
		int second = cal1.get(Calendar.SECOND);
		set_time(buffer, 0, hour / 10);
		set_time(buffer, 1, hour % 10);
		set_time(buffer, 2, minute / 10);
		set_time(buffer, 3, minute % 10);
		set_time(buffer, 4, second / 10);
		set_time(buffer, 5, second %10);
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
	Choice clockFontSize = new Choice();
	double clockFontSizeDouble = 1;
	String clockFontSizeString = "1.0";
	Choice fontChoice = new Choice();
	String fontChoiceString = "Normal";
	
	private Color bufFontColor = fontColor;
	private Color bufBackColor = backColor;
	private String bufFontSizeString = clockFontSizeString;
	private String bufFontChoiceString = "Normal";
	Frame ClockMain;
	
	private Preferences clockParam = Preferences.userRoot().node("clockParam");

	public PropetyDialog(Frame owner) {
		super(owner);
		
		fontColor = new Color(Integer.parseInt(clockParam.get("fr", "255")),
				Integer.parseInt(clockParam.get("fg", "0")),
				Integer.parseInt(clockParam.get("fb", "0")));
		textRed.setText(clockParam.get("fr", "255"));
		textGreen.setText(clockParam.get("fg", "0"));
		textBlue.setText(clockParam.get("fb", "0"));
		
		backColor = new Color(Integer.parseInt(clockParam.get("br", "255")),
				Integer.parseInt(clockParam.get("bg", "255")),
				Integer.parseInt(clockParam.get("bb", "255")));
		backTextRed.setText(clockParam.get("br", "255"));
		backTextGreen.setText(clockParam.get("bg", "255"));
		backTextBlue.setText(clockParam.get("bb", "255"));
		
		clockFontSizeString = clockParam.get("fs", "1");
		clockFontSizeDouble = 1 / Double.parseDouble(clockFontSizeString);
		fontChoiceString = clockParam.get("fc", "Normal");
		ClockMain = owner;
		setSize(300, 160);
		setResizable(false);
		setTitle("プロパティ");
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();

		Label fontLabel = new Label("font");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.WEST;
		layout.setConstraints(fontLabel, gbc);
		add(fontLabel);

		Label fontSizeLabel = new Label("font size");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.WEST;
		layout.setConstraints(fontSizeLabel, gbc);
		add(fontSizeLabel);
		
		Label fontColorLabel = new Label("font color");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.WEST;
		layout.setConstraints(fontColorLabel, gbc);
		add(fontColorLabel);
		
		Label backColorLabel = new Label("back color");
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.WEST;
		layout.setConstraints(backColorLabel, gbc);
		add(backColorLabel);
		
		fontChoice.addItem("Normal");
		fontChoice.addItem("Binary");
		gbc.gridx = 6;
		gbc.gridy = 0;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(fontChoice, gbc);
		add(fontChoice);
		
		
		clockFontSize.addItem("0.3");
		clockFontSize.addItem("0.5");
		clockFontSize.addItem("0.8");
		clockFontSize.addItem("1.0");
		clockFontSize.addItem("1.5");
		clockFontSize.addItem("2.0");
		gbc.gridx = 6;
		gbc.gridy = 1;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(clockFontSize, gbc);
		add(clockFontSize);
		
		Label redLabel = new Label("R");
		gbc.gridx = 6;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(redLabel, gbc);
		add(redLabel);
		
		gbc.gridx = 7;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(textRed, gbc);
		add(textRed);
		
		Label greenLabel = new Label("G");
		gbc.gridx = 8;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(greenLabel, gbc);
		add(greenLabel);
		
		gbc.gridx = 9;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(textGreen, gbc);
		add(textGreen);
		
		Label blueLabel = new Label("B");
		gbc.gridx = 10;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(blueLabel, gbc);
		add(blueLabel);
		
		gbc.gridx = 11;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(textBlue, gbc);
		add(textBlue);
		
		Label redLabel2 = new Label("R");
		gbc.gridx = 6;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(redLabel2, gbc);
		add(redLabel2);
		
		gbc.gridx = 7;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(backTextRed, gbc);
		add(backTextRed);
		
		Label greenLabel2 = new Label("G");
		gbc.gridx = 8;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(greenLabel2, gbc);
		add(greenLabel2);
		
		gbc.gridx = 9;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(backTextGreen, gbc);
		add(backTextGreen);
		
		Label blueLabel2 = new Label("B");
		gbc.gridx = 10;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(blueLabel2, gbc);
		add(blueLabel2);
		
		gbc.gridx = 11;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.EAST;
		layout.setConstraints(backTextBlue, gbc);
		add(backTextBlue);
		
		Button okButton = new Button("ok");
		okButton.setPreferredSize(new Dimension(200, 20));
		okButton.addActionListener(this);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.CENTER;
		layout.setConstraints(okButton, gbc);
		add(okButton);
		
		Button cancelButton = new Button("cancel");
		cancelButton.setPreferredSize(new Dimension(200, 20));
		cancelButton.addActionListener(this);
		gbc.gridx = 6;
		gbc.gridy = 4;
		gbc.gridwidth = 6;
		gbc.gridheight = 1;	
		gbc.anchor = GridBagConstraints.CENTER;
		layout.setConstraints(cancelButton, gbc);
		add(cancelButton);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				setVisible(false);
			}
		});

	}

	public void viewProperty() {
		fontChoice.select(fontChoiceString);
		clockFontSize.select(clockFontSizeString);
		

		bufFontColor = fontColor;
		bufBackColor = backColor;
		bufFontChoiceString = fontChoiceString;
		bufFontSizeString = clockFontSize.getSelectedItem();
		
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
			fontColor = new Color(Integer.parseInt(textRed.getText()),
					Integer.parseInt(textGreen.getText()),
					Integer.parseInt(textBlue.getText()));
			backColor = new Color(Integer.parseInt(backTextRed.getText()),
					Integer.parseInt(backTextGreen.getText()),
					Integer.parseInt(backTextBlue.getText()));
			clockFontSizeString = clockFontSize.getSelectedItem();
			clockFontSizeDouble = 1 / Double.parseDouble(clockFontSizeString);
			fontChoiceString = fontChoice.getSelectedItem();
			
			clockParam.put("fs", clockFontSizeString);
			clockParam.put("fc", fontChoiceString);
			clockParam.put("fr", textRed.getText());
			clockParam.put("fg", textGreen.getText());
			clockParam.put("fb", textBlue.getText());
			clockParam.put("br", backTextRed.getText());
			clockParam.put("bg", backTextGreen.getText());
			clockParam.put("bb", backTextBlue.getText());
			
			
			ClockMain.repaint();
		} else if (e.getActionCommand() == "cancel") {
			fontColor = bufFontColor;
			backColor = bufBackColor;
			clockFontSizeString = bufFontSizeString;
			clockFontSizeDouble = 1 / Double.parseDouble(clockFontSizeString);
			fontChoiceString  = bufFontChoiceString;
			/*
			 * 表示戻せ
			 */
			textRed.setText(Integer.toString(fontColor.getRed()));
			textGreen.setText(Integer.toString(fontColor.getGreen()));
			textBlue.setText(Integer.toString(fontColor.getBlue()));
			backTextRed.setText(Integer.toString(backColor.getRed()));
			backTextGreen.setText(Integer.toString(backColor.getGreen()));
			backTextBlue.setText(Integer.toString(backColor.getBlue()));
			clockFontSize.select(clockFontSizeString);
			fontChoice.select(fontChoiceString);
			ClockMain.repaint();
		}

	}
}
