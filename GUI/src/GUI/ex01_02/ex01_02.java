package GUI.ex01_02;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

public class ex01_02 extends Frame {
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {

		ex01_02 app = new ex01_02("");
		app.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		app.setSize(660, 360);
		app.setVisible(true);
		while (true) {
			try {
				Thread.sleep(1000);
				app.repaint();
			} catch (InterruptedException e) {
				System.out.println("error" + e);
			}
		}
	}

	public ex01_02(String title) {
		super(title);
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
}
