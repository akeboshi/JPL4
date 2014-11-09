package GUI.ex02_04;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

class MouseIventer implements MouseListener,
MouseMotionListener {
	private Point startDrag, startPos;
	private ex02_04 frame;

	public MouseIventer(ex02_04 ex02_02){
		this.frame = ex02_02;
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
			((ex02_04)frame).getPopup().show(frame, e.getX(), e.getY());
		}
	}

	Point getScreenLocation(MouseEvent e) {
		Point p1 = e.getPoint();
		Point p2 = frame.getLocationOnScreen();
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {
			startDrag =getScreenLocation(e);
			startPos = frame.getLocation();
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
			frame.setLocation(startPos.x + xdiff, startPos.y + ydiff);
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