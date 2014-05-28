package GUI.ex02_02;

import java.awt.Color;

/**
 * 時計のデータを持つクラス
 * @author akari
 *
 */
public class WatchData{
	private int fontSize;
	private double dispSize;
	private Color fontColor;
	private Color backgroundColor;
	static private WatchData watchData = new WatchData();
	
	private WatchData(){		
	}
	
	static public WatchData getInstance(){
		return watchData;
	}
	
	public int getFontSize() {
		return fontSize;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	public double getDispSize() {
		return dispSize;
	}
	public void setDispSize(double dispSize) {
		this.dispSize = dispSize;
	}
	public Color getFontColor() {
		return fontColor;
	}
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}
	public Color getBackgroundColor() {
		return backgroundColor;
	}
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}