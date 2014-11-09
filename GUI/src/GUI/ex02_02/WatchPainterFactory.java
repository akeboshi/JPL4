package GUI.ex02_02;

import java.awt.Color;
import java.awt.Graphics;

class WatchePainterFactory {

	public static WatchPainter factory(Graphics g, String watchName,
			Color fontColor, Color backColor, double fontSize) {
		if (watchName.equals("Normal")) {
			return new NormalWatchPainter(g, fontColor, backColor, fontSize);
		} else if (watchName.equals("Binary")) {
			return new BinaryWatchPainter(g, fontColor, backColor, fontSize);
		}
		throw new AssertionError();
	}

	public static WatchPainter factory(Graphics g, String watchName,
			Color fontColor, Color backColor) {
		return factory(g, watchName, fontColor, backColor, 0);
	}
}