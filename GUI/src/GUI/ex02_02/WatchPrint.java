package GUI.ex02_02;

import java.awt.Graphics;
import java.util.Calendar;

class WatchPrint{
	private WatchData data = WatchData.getInstance();

	public void print_time(Graphics g,int area){
		Calendar cal1 = Calendar.getInstance();
		int hour = cal1.get(Calendar.HOUR_OF_DAY);
		int minute = cal1.get(Calendar.MINUTE);
		int second = cal1.get(Calendar.SECOND);
		set_time(g, 0, hour / 10);
		set_time(g, 1, hour % 10);
		set_time(g, 2, minute / 10);
		set_time(g, 3, minute % 10);
		set_time(g, 4, second / 10);
		set_time(g, 5, second %10);
	}
	
	void set_time(Graphics g, int area, int num) {
		g.setColor(data.getFontColor());
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
}