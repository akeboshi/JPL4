package GUI.ex02_04;

import java.awt.Color;
import java.awt.Graphics;

class NormalWatchPainter extends WatchPainter {

	NormalWatchPainter(Graphics g, Color fontColor, Color backColor) {
		super(g, fontColor, backColor);
	}

	NormalWatchPainter(Graphics g, Color fontColor, Color backColor,
			double fontSize) {
		super(g, fontColor, backColor, fontSize);
	}

	protected void zero(int x, int y) {
		drawNumber(x, y, 1, 1, 1, 0, 1, 1, 1);
	}

	protected void one(int x, int y) {
		drawNumber(x, y, 0, 0, 1, 0, 0, 0, 1);
	}

	protected void two(int x, int y) {
		drawNumber(x, y, 1, 0, 1, 1, 1, 1, 0);
	}

	protected void three(int x, int y) {
		drawNumber(x, y, 1, 0, 1, 1, 1, 0, 1);
	}

	protected void four(int x, int y) {
		drawNumber(x, y, 0, 1, 1, 1, 0, 0, 1);
	}

	protected void five(int x, int y) {
		drawNumber(x, y, 1, 1, 0, 1, 1, 0, 1);
	}

	protected void six(int x, int y) {
		drawNumber(x, y, 1, 1, 0, 1, 1, 1, 1);
	}

	protected void seven(int x, int y) {
		drawNumber(x, y, 1, 0, 1, 0, 0, 0, 1);
	}

	protected void eight(int x, int y) {
		drawNumber(x, y, 1, 1, 1, 1, 1, 1, 1);
	}

	protected void nine(int x, int y) {
		drawNumber(x, y, 1, 1, 1, 1, 1, 0, 1);
	}

	private void drawNumber(int x, int y, int topCenter, int topLeft,
			int topRight, int centerCenter, int bottomCenter, int bottomLeft,
			int bottomRight) {
		if (topLeft > 0)
			g.fillRect((int) ((30 + x) / getFontSize()),
					(int) (50 / getFontSize()) ,
					(int) (20 / getFontSize()), (int) (150 / getFontSize()));
		if (topCenter > 0)
			g.fillRect((int) ((30 + x) / getFontSize()),
					(int) (50 / getFontSize()) ,
					(int) (80 / getFontSize()), (int) (20 / getFontSize()));
		if (topRight > 0)
			g.fillRect((int) ((90 + x) / getFontSize()),
					(int) (50 / getFontSize()) ,
					(int) (20 / getFontSize()), (int) (150 / getFontSize()));
		if (centerCenter > 0)
			g.fillRect((int) ((30 + x) / getFontSize()),
					(int) (180 / getFontSize()) ,
					(int) (80 / getFontSize()), (int) (20 / getFontSize()));
		if (bottomLeft > 0)
			g.fillRect((int) ((30 + x) / getFontSize()),
					(int) (180 / getFontSize()) ,
					(int) (20 / getFontSize()), (int) (150 / getFontSize()));
		if (bottomCenter > 0)
			g.fillRect((int) ((30 + x) / getFontSize()),
					(int) (310 / getFontSize()) ,
					(int) (80 / getFontSize()), (int) (20 / getFontSize()));
		if (bottomRight > 0)
			g.fillRect((int) ((90 + x) / getFontSize()),
					(int) (180 / getFontSize()) ,
					(int) (20 / getFontSize()), (int) (150 / getFontSize()));
	}
}