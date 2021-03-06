package GUI.ex01_03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class ex01_03 extends Window implements ActionListener, MouseListener,
		MouseMotionListener {
	private static final long serialVersionUID = 1L;
	private PropetyDialog propertyDialog;
	private double resize = 1.0;
	private PopupMenu pop = new PopupMenu("popup");
	private Point startDrag, startPos;
	public String fontStyle = "Normal";
	public double fontSize = 1;
	public Color fontColor = new Color(0xff0000);
	public Color backColor = new Color(0xffffff);

	public static void main(String args[]) {

		ex01_03 app = new ex01_03("");

		app.setSize(660, 360 + 50);
		app.setVisible(true);
		app.startClock(app);
	}

	public ex01_03(String title) {
		super(new Frame());
		propertyDialog = new PropetyDialog(this);
		generateMenu();
		generatePopUp();
		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				System.exit(0);
			}
		});
	}

	public void startClock(ex01_03 clock) {
		while (true) {
			try {
				Thread.sleep(1);
				clock.repaint();
			} catch (InterruptedException e) {
				System.out.println("error" + e);
			}
		}
	}

	public void generatePopUp() {

		MenuItem newm = new MenuItem("プロパティ");
		MenuItem closem = new MenuItem("閉じる");
		Menu fontStyleMenu = new Menu("FontStyle");
		Menu fontSizeMenu = new Menu("FontSize");
		Menu fontColorMenu = new Menu("FontColor");
		Menu backColorMenu = new Menu("backColor");

		ChangeFont changeFont = new ChangeFont(this);

		MenuItem binaryFont = new MenuItem("Binary");
		binaryFont.addActionListener(changeFont);
		fontStyleMenu.add(binaryFont);

		MenuItem normalFont = new MenuItem("Normal");
		normalFont.addActionListener(changeFont);
		fontStyleMenu.add(normalFont);


		ChangeFontSize changeSize = new ChangeFontSize(this);

		MenuItem fontSize1 = new MenuItem("0.5");
		MenuItem fontSize2 = new MenuItem("1.0");
		MenuItem fontSize3 = new MenuItem("1.5");
		MenuItem fontSize4 = new MenuItem("2.0");

		fontSize1.addActionListener(changeSize);
		fontSize2.addActionListener(changeSize);
		fontSize3.addActionListener(changeSize);
		fontSize4.addActionListener(changeSize);

		fontSizeMenu.add(fontSize1);
		fontSizeMenu.add(fontSize2);
		fontSizeMenu.add(fontSize3);
		fontSizeMenu.add(fontSize4);

		ChangeFontColor changeFontColor = new ChangeFontColor(this);

		MenuItem fontColor1 = new MenuItem("Red");
		MenuItem fontColor2 = new MenuItem("Green");
		MenuItem fontColor3 = new MenuItem("Pink");
		MenuItem fontColor4 = new MenuItem("Yellow");

		fontColor1.addActionListener(changeFontColor);
		fontColor2.addActionListener(changeFontColor);
		fontColor3.addActionListener(changeFontColor);
		fontColor4.addActionListener(changeFontColor);

		fontColorMenu.add(fontColor1);
		fontColorMenu.add(fontColor2);
		fontColorMenu.add(fontColor3);
		fontColorMenu.add(fontColor4);

		ChangeBackColor changeBackColor = new ChangeBackColor(this);

		MenuItem backColor1 = new MenuItem("White");
		MenuItem backColor2 = new MenuItem("Blue");
		MenuItem backColor3 = new MenuItem("DarkGray");
		MenuItem backColor4 = new MenuItem("LightGray");

		backColor1.addActionListener(changeBackColor);
		backColor2.addActionListener(changeBackColor);
		backColor3.addActionListener(changeBackColor);
		backColor4.addActionListener(changeBackColor);

		backColorMenu.add(backColor1);
		backColorMenu.add(backColor2);
		backColorMenu.add(backColor3);
		backColorMenu.add(backColor4);

		// メニューアイテムの追加
		pop.add(fontStyleMenu);
		pop.add(fontSizeMenu);
		pop.add(fontColorMenu);
		pop.add(backColorMenu);
		pop.add(closem);

		// イベントリスクの設定
		newm.addActionListener(this);
		closem.addActionListener(this);
		add(pop);
	}

	public void generateMenu() {
		MenuBar menubar = new MenuBar();

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

	public void update(Graphics g) {
		paint(g);
	}

	public void paint(Graphics g) {
		resize = fontSize;
		this.setSize((int) (660 / resize), (int) (360 / resize) + 50);

		Dimension size = getSize();
		Image back = createImage(size.width, size.height);

		Graphics buffer = back.getGraphics();

		buffer.setColor(backColor);
		buffer.fillRect(0, 0, (int) (660 / resize) + 1,
				(int) (360 / resize) + 50 + 1);
		WatchPainter watchPainter = WatchePainterFactory.factory(buffer, fontStyle, fontColor, backColor, fontSize);
		watchPainter.paintTime();
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

	@Override
	public void mouseClicked(MouseEvent e) {
		if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {

		}
		if ((e.getModifiers() & MouseEvent.BUTTON2_MASK) != 0) {
			// 中央

		}
		if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
			// 右
			pop.show(this, e.getX(), e.getY());
		}
	}

	Point getScreenLocation(MouseEvent e) {
		Point p1 = e.getPoint();
		Point p2 = this.getLocationOnScreen();
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {// TODO
																// 自動生成されたメソッド・スタブif
																// ((e.getModifiers()
																// &
																// MouseEvent.BUTTON1_MASK)
																// != 0) {
			startDrag = getScreenLocation(e);
			startPos = this.getLocation();
		}
		if ((e.getModifiers() & MouseEvent.BUTTON2_MASK) != 0) {
			// 中央

		}
		if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
			// 右
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {
			Point cursor = getScreenLocation(e);
			int xdiff = cursor.x - startDrag.x;
			int ydiff = cursor.y - startDrag.y;
			this.setLocation(startPos.x + xdiff, startPos.y + ydiff);
		}
		if ((e.getModifiers() & MouseEvent.BUTTON2_MASK) != 0) {
			// 中央

		}
		if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
			// 右
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
}

class ChangeFont implements ActionListener {

	private ex01_03 tokei;

	public ChangeFont(ex01_03 ex) {
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

class ChangeFontSize implements ActionListener {

	private ex01_03 tokei;

	public ChangeFontSize(ex01_03 ex) {
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

class ChangeBackColor implements ActionListener {

	private ex01_03 tokei;

	public ChangeBackColor(ex01_03 ex) {
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

class ChangeFontColor implements ActionListener {

	private ex01_03 tokei;

	public ChangeFontColor(ex01_03 ex) {
		this.tokei = ex;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Red") {
			tokei.fontColor = Color.RED;
		} else if (e.getActionCommand() == "Green") {
			tokei.fontColor = Color.GREEN;
		} else if (e.getActionCommand() == "Pink") {
			tokei.fontColor = Color.PINK;
		} else if (e.getActionCommand() == "Yellow") {
			tokei.fontColor = Color.YELLOW;
		}
	}
}