package GUI.ex02_03;

import java.awt.Color;
import java.awt.Graphics;

class BinaryWatchPainter extends WatchPainter {

	BinaryWatchPainter(Graphics g, Color fontColor, Color backColor) {
		super(g, fontColor, backColor);
	}

	BinaryWatchPainter(Graphics g, Color fontColor, Color backColor,
			double fontSize) {
		super(g, fontColor, backColor, fontSize);
	}

	protected void zero(int x, int y) {
		drawNumber(x, y, 0, 0, 0, 0);
	}

	protected void one(int x, int y) {
		drawNumber(x, y, 1, 0, 0, 0);
	}

	protected void two(int x, int y) {
		drawNumber(x, y, 0, 1, 0, 0);
	}

	protected void three(int x, int y) {
		drawNumber(x, y, 1, 1, 0, 0);
	}

	protected void four(int x, int y) {
		drawNumber(x, y, 0, 0, 1, 0);
	}

	protected void five(int x, int y) {
		drawNumber(x, y, 1, 0, 1, 0);
	}

	protected void six(int x, int y) {
		drawNumber(x, y, 0, 1, 1, 0);
	}

	protected void seven(int x, int y) {
		drawNumber(x, y, 1, 1, 1, 0);
	}

	protected void eight(int x, int y) {
		drawNumber(x, y, 0, 0, 0, 1);
	}

	protected void nine(int x, int y) {
		drawNumber(x, y, 1, 0, 0, 1);
	}

	private void fillOval(int x, int y, int width, int height){
		g.fillOval(x, y, width, height);
	}

	private void drawNumber(int x, int y,int binary1, int binary2, int binary3, int binary4){
		if (binary1 > 0){
			fillOval((int) ((30 + x) / fontSize), (int) (50 / fontSize) ,
					(int) (80 / fontSize), (int) (80 / fontSize));
		} else {
		drawClockCircle((int) ((30 + x) / fontSize),
				(int) (50 / fontSize) , (int) (80 / fontSize),
				(int) (80 / fontSize));
		}
		if (binary2 > 0){
			fillOval((int) ((30 + x) / fontSize), (int) (120 / fontSize) ,
					(int) (80 / fontSize), (int) (80 / fontSize));
		} else {
		drawClockCircle((int) ((30 + x) / fontSize),
				(int) (120 / fontSize) , (int) (80 / fontSize),
				(int) (80 / fontSize));
		}
		if (binary3 > 0) {
			fillOval((int) ((30 + x) / fontSize), (int) (190 / fontSize) ,
					(int) (80 / fontSize), (int) (80 / fontSize));
		} else {
		drawClockCircle((int) ((30 + x) / fontSize),
				(int) (190 / fontSize) , (int) (80 / fontSize),
				(int) (80 / fontSize));
		}

		if (binary4 > 0) {
			fillOval((int) ((30 + x) / fontSize), (int) (260 / fontSize) ,
					(int) (80 / fontSize), (int) (80 / fontSize));
		} else {
			drawClockCircle((int) ((30 + x) / fontSize),
				(int) (260 / fontSize) , (int) (80 / fontSize),
				(int) (80 / fontSize));
		}
	}

	private void setColor(Color color){
		g.setColor(color);
	}

	private void drawClockCircle(int x, int y, int width, int height) {
		fillOval(x, y, width, height);
		setColor(backColor);
		fillOval(x + (int) (5 / fontSize), y + (int) (5 / fontSize), width
				- (int) (10 / fontSize), height - (int) (10 / fontSize));
		setColor(fontColor);
	}

}