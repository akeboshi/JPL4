package GUI.ex02_02;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class ex02_02 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private PropetyDialog propertyDialog;
	private double resize = 1.0;
	private JPopupMenu pop = new JPopupMenu("popup");
	private Point startDrag, startPos;
	public String fontStyle = "Normal";
	public double fontSize = 1;
	public Color fontColor = new Color(0xff0000);
	public Color backColor = new Color(0xffffff);

	public static void main(String args[]) {

		ex02_02 app = new ex02_02("");

	}

	public ex02_02(String title) {
		PaintPanel frame = new PaintPanel(this);
		propertyDialog = new PropetyDialog(this);
		generateMenu();
		generatePopUp();
		addMouseListener(new MouseIventer(this));
		addMouseMotionListener(new MouseIventer(this));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		this.setSize(660, 360 + 50);
		this.setVisible(true);
		this.getContentPane().add(frame);
		startClock(frame);
	}

	public void startClock(PaintPanel frame) {
		while (true) {
			try {
				Thread.sleep(1);
				frame.repaint();
			} catch (InterruptedException e) {
				System.out.println("error" + e);
			}
		}
	}

	public void generatePopUp() {

		JMenuItem newm = new JMenuItem("プロパティ");
		JMenuItem closem = new JMenuItem("閉じる");
		JMenu fontStyleMenu = new JMenu("FontStyle");
		JMenu fontSizeMenu = new JMenu("FontSize");
		JMenu fontColorMenu = new JMenu("FontColor");
		JMenu backColorMenu = new JMenu("backColor");

		ChangeFontStyle changeFont = new ChangeFontStyle(this);

		JMenuItem binaryFont = new JMenuItem("Binary");
		binaryFont.addActionListener(changeFont);
		fontStyleMenu.add(binaryFont);

		JMenuItem normalFont = new JMenuItem("Normal");
		normalFont.addActionListener(changeFont);
		fontStyleMenu.add(normalFont);

		ChangeFontSize changeSize = new ChangeFontSize(this);

		JMenuItem fontSize1 = new JMenuItem("0.5");
		JMenuItem fontSize2 = new JMenuItem("1.0");
		JMenuItem fontSize3 = new JMenuItem("1.5");
		JMenuItem fontSize4 = new JMenuItem("2.0");

		fontSize1.addActionListener(changeSize);
		fontSize2.addActionListener(changeSize);
		fontSize3.addActionListener(changeSize);
		fontSize4.addActionListener(changeSize);

		fontSizeMenu.add(fontSize1);
		fontSizeMenu.add(fontSize2);
		fontSizeMenu.add(fontSize3);
		fontSizeMenu.add(fontSize4);

		ChangeFontColor changeFontColor = new ChangeFontColor(this);

		JMenuItem fontColor1 = new JMenuItem("Red");
		JMenuItem fontColor2 = new JMenuItem("Green");
		JMenuItem fontColor3 = new JMenuItem("Pink");
		JMenuItem fontColor4 = new JMenuItem("Yellow");

		fontColor1.addActionListener(changeFontColor);
		fontColor2.addActionListener(changeFontColor);
		fontColor3.addActionListener(changeFontColor);
		fontColor4.addActionListener(changeFontColor);

		fontColorMenu.add(fontColor1);
		fontColorMenu.add(fontColor2);
		fontColorMenu.add(fontColor3);
		fontColorMenu.add(fontColor4);

		ChangeBackColor changeBackColor = new ChangeBackColor(this);

		JMenuItem backColor1 = new JMenuItem("White");
		JMenuItem backColor2 = new JMenuItem("Blue");
		JMenuItem backColor3 = new JMenuItem("DarkGray");
		JMenuItem backColor4 = new JMenuItem("LightGray");

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
		getRootPane().add(pop);
	}

	public void generateMenu() {
		JMenuBar menubar = new JMenuBar();
		getRootPane().setJMenuBar(menubar);
		JMenu Menu1 = new JMenu("ファイル");
		menubar.add(Menu1);

		JMenuItem newm = new JMenuItem("プロパティ");
		JMenuItem closem = new JMenuItem("閉じる");

		// メニューアイテムの追加
		Menu1.add(newm);
		Menu1.add(closem);

		// イベントリスクの設定
		newm.addActionListener(this);
		closem.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "プロパティ") {
			propertyDialog.viewProperty();
		} else if (e.getActionCommand() == "閉じる") {
			System.exit(0);
		}
	}

	class PaintPanel extends JPanel {
		ex02_02 ex02_02;
		public PaintPanel(ex02_02 ex02_02) {
			this.ex02_02 = ex02_02;
		}

		public void paintComponent(Graphics g) {
			this.setSize((int) (660 / fontSize), (int) (360 / fontSize) + 50);

			Dimension size = getSize();
			Image back = createImage(size.width, size.height);

			ex02_02.setSize(size);

			Graphics buffer = back.getGraphics();

			buffer.setColor(backColor);
			buffer.fillRect(0, 0, (int) (660 / fontSize) + 1,
					(int) (360 / fontSize) + 1);
			WatchPainter watchPainter = WatchePainterFactory.factory(buffer,
					fontStyle, fontColor, backColor, fontSize);
			watchPainter.paintTime();
			g.drawImage(back, 0, 0, this);
		}
	}

	public JPopupMenu getPopup() {
		return pop;
	}
}
