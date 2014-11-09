package GUI.ex01_03;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Calendar;

abstract class WatchPainter{
	protected int startPointX;
	protected int startPointY;
	protected double fontSize = 1;
	protected Color fontColor;
	protected Color backColor;
	protected Graphics g;
	public static final int POINTXSOFNUMBER[] = {0,100,200,300,400,500};
	
	WatchPainter (Graphics g, Color fontColor,Color backColor){
		this.g = g;
		this.fontColor = fontColor;
		this.backColor = backColor;
	}
	
	WatchPainter (Graphics g, Color fontColor,Color backColor,double fontSize){
		this(g, fontColor,backColor);
		this.fontSize = fontSize;
	}
	/**
	 * 時計の文字を描画する　例）１２１２３０
	 */
	public void paintTime(){
		paintTimeXY(0, 0);
	}
	
	/**
	 * 時計の文字を描画する　例）１２１２３０
	 * x,yで、描画位置を修正できる
	 */
	public void paintTimeXY(int x, int y){
		Calendar cal1 = Calendar.getInstance();
		int hour = cal1.get(Calendar.HOUR_OF_DAY);
		int minute = cal1.get(Calendar.MINUTE);
		int second = cal1.get(Calendar.SECOND);
		g.setColor(fontColor);
		callPaintNumber(POINTXSOFNUMBER[0] + x, y, hour / 10);
		callPaintNumber(POINTXSOFNUMBER[1] + x, y, hour % 10);
		callPaintNumber(POINTXSOFNUMBER[2] + x, y, minute / 10);
		callPaintNumber(POINTXSOFNUMBER[3] + x, y, minute % 10);
		callPaintNumber(POINTXSOFNUMBER[4] + x, y, second / 10);
		callPaintNumber(POINTXSOFNUMBER[5] + x, y, second % 10);	
	}
	
	protected void callPaintNumber(int moveX,int moveY,int num){
		switch (num) {
		case 0:
			zero(moveX, moveY);
			break;
		case 1:
			one(moveX, moveY);
			break;
		case 2:
			two(moveX, moveY);
			break;
		case 3:
			three(moveX, moveY);
			break;
		case 4:
			four(moveX, moveY);
			break;
		case 5:
			five(moveX, moveY);
			break;
		case 6:
			six(moveX, moveY);
			break;
		case 7:
			seven(moveX, moveY);
			break;
		case 8:
			eight(moveX, moveY);
			break;
		case 9:
			nine(moveX, moveY);
			break;
		default:
			break;
		}
	}
	
	protected abstract void one(int x,int y);
	protected abstract void two(int x,int y);
	protected abstract void three(int x,int y);
	protected abstract void four(int x,int y);
	protected abstract void five(int x,int y);
	protected abstract void six(int x,int y);
	protected abstract void seven(int x,int y);
	protected abstract void eight(int x,int y);
	protected abstract void nine(int x,int y);
	protected abstract void zero(int x,int y);
	
	public double getFontSize() {
		return fontSize;
	}
	
	public void setFontSize(double fontSize) {
		this.fontSize = fontSize;
	}

	public Color getFontColor() {
		return fontColor;
	}

	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}

	public Color getBackColor() {
		return backColor;
	}

	public void setBackColor(Color backColor) {
		this.backColor = backColor;
	}
}