package GUI.ex01_02;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

/*
 * http://www.javadrive.jp/tutorial/jcolorchooser/index3.html
 * http://www.javadrive.jp/tutorial/font/index5.html
 * http://terai.xrea.jp/Swing/AllFonts.html
 */



public class ex01_02 extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {

		ex01_02 app = new ex01_02("");

		app.setSize(660, 360);
		app.setVisible(true);
		app.startClock(app);
	}

	public ex01_02(String title) {
		super(title);
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
		g.setColor(Color.red);
		Calendar cal1 = Calendar.getInstance();
		int hour = cal1.get(Calendar.HOUR_OF_DAY);
		int minute = cal1.get(Calendar.MINUTE);
		int second = cal1.get(Calendar.SECOND);
		set_time(g, 0, hour / 10);
		set_time(g, 1, hour % 10);
		set_time(g, 2, minute / 10);
		set_time(g, 3, minute % 10);
		set_time(g, 4, second / 10);
		set_time(g, 5, second % 10);
	}

	void set_time(Graphics g, int area, int num) {
		int x = area * 100;
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

	}

	public void zero(Graphics g, int x) {
		g.fillRect(30 + x, 50, 20, 150);
		g.fillRect(30 + x, 50, 80, 20);
		g.fillRect(90 + x, 50, 20, 150);
		g.fillRect(30 + x, 180, 20, 150);
		g.fillRect(30 + x, 310, 80, 20);
		g.fillRect(90 + x, 180, 20, 150);
	}

	public void one(Graphics g, int x) {
		g.fillRect(90 + x, 50, 20, 150);
		g.fillRect(90 + x, 180, 20, 150);
	}

	public void two(Graphics g, int x) {
		g.fillRect(30 + x, 50, 80, 20);
		g.fillRect(90 + x, 50, 20, 150);
		g.fillRect(30 + x, 180, 80, 20);
		g.fillRect(30 + x, 180, 20, 150);
		g.fillRect(30 + x, 310, 80, 20);
	}

	public void three(Graphics g, int x) {
		g.fillRect(30 + x, 50, 80, 20);
		g.fillRect(90 + x, 50, 20, 150);
		g.fillRect(30 + x, 180, 80, 20);
		g.fillRect(30 + x, 310, 80, 20);
		g.fillRect(90 + x, 180, 20, 150);
	}

	public void four(Graphics g, int x) {
		g.fillRect(30 + x, 50, 20, 150);
		g.fillRect(90 + x, 50, 20, 150);
		g.fillRect(30 + x, 180, 80, 20);
		g.fillRect(90 + x, 180, 20, 150);
	}

	public void five(Graphics g, int x) {
		g.fillRect(30 + x, 50, 20, 150);
		g.fillRect(30 + x, 50, 80, 20);
		g.fillRect(30 + x, 180, 80, 20);
		g.fillRect(30 + x, 310, 80, 20);
		g.fillRect(90 + x, 180, 20, 150);
	}

	public void six(Graphics g, int x) {
		g.fillRect(30 + x, 50, 20, 150);
		g.fillRect(30 + x, 50, 80, 20);
		g.fillRect(30 + x, 180, 80, 20);
		g.fillRect(30 + x, 180, 20, 150);
		g.fillRect(30 + x, 310, 80, 20);
		g.fillRect(90 + x, 180, 20, 150);
	}

	public void seven(Graphics g, int x) {
		g.fillRect(30 + x, 50, 20, 150);
		g.fillRect(30 + x, 50, 80, 20);
		g.fillRect(90 + x, 50, 20, 150);
		g.fillRect(90 + x, 180, 20, 150);
	}

	public void eight(Graphics g, int x) {
		g.fillRect(30 + x, 50, 20, 150);
		g.fillRect(30 + x, 50, 80, 20);
		g.fillRect(90 + x, 50, 20, 150);
		g.fillRect(30 + x, 180, 80, 20);
		g.fillRect(30 + x, 180, 20, 150);
		g.fillRect(30 + x, 310, 80, 20);
		g.fillRect(90 + x, 180, 20, 150);
	}

	public void nine(Graphics g, int x) {
		g.fillRect(30 + x, 50, 20, 150);
		g.fillRect(30 + x, 50, 80, 20);
		g.fillRect(90 + x, 50, 20, 150);
		g.fillRect(30 + x, 180, 80, 20);
		g.fillRect(30 + x, 310, 80, 20);
		g.fillRect(90 + x, 180, 20, 150);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "プロパティ") {
			(new PropetyDialog()).start();
		} else if (e.getActionCommand() == "閉じる") {
			System.exit(0);
		}
	}
}

class PropetyDialog extends Frame{
	 public void start() {
		 Dialog dialog =new Dialog(new Frame());
		 dialog.setSize(300, 150);
		 dialog.setVisible(true);
		 Button b = new Button("ok");
		 dialog.setLayout(new FlowLayout());
		 b.setPreferredSize(new Dimension(200, 100));
		 dialog.add(b);
		 dialog.setLayout(new FlowLayout());
		 Label label = new Label("hello");
		 dialog.add(label);
		 //dialog.addWindowListener(this);
		 dialog.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent close) {
					System.exit(0);
				}
			});

	 }
}


