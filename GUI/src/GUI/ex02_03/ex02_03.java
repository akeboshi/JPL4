package GUI.ex02_03;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
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
import javax.swing.JWindow;

public class ex02_03 extends JWindow implements ActionListener {
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

		ex02_03 app = new ex02_03("");

	}

	public ex02_03(String title) {
		PaintPanel frame = new PaintPanel(this);
		this.add(frame);
		frame.setVisible(true);
		
		propertyDialog = new PropetyDialog(this);
		addMouseListener(new MouseIventer(this));
		addMouseMotionListener(new MouseIventer(this));
		generateMenu();
		generatePopUp();
		this.setVisible(true);
		this.setSize(660, 360 + 50);

		startClock();
	}

	public void startClock() {
		while (true) {
			try {
				Thread.sleep(1);
				this.repaint();
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

		JMenuItem fontColor1 = new JMenuItem("<html><font color=red>■</font>Red</html>");
		JMenuItem fontColor2 = new JMenuItem("<html><font color=green>■</font>Green</html>");
		JMenuItem fontColor3 = new JMenuItem("<html><font color=pink>■</font>Pink</html>");
		JMenuItem fontColor4 = new JMenuItem("<html><font color=yellow>■</font>Yellow</html>");

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
		backColor1.setBackground(Color.WHITE);
		JMenuItem backColor2 = new JMenuItem("Blue");
		backColor2.setBackground(Color.BLUE);
		JMenuItem backColor3 = new JMenuItem("DarkGray");
		backColor3.setBackground(Color.DARK_GRAY);
		JMenuItem backColor4 = new JMenuItem("LightGray");
		backColor4.setBackground(Color.LIGHT_GRAY);
		
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
		private static final long serialVersionUID = 1L;
		ex02_03 ex02_02;

		public PaintPanel(ex02_03 ex02_02) {
			this.ex02_02 = ex02_02;
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			this.setSize((int) (660 / fontSize), (int) (360 / fontSize) + 50);

			Dimension size = getSize();
//			Image back = createImage(size.width, size.height);

			ex02_02.setSize(size);

//			Graphics buffer = back.getGraphics();
//
			g.setColor(backColor);
			g.fillRect(0, 0, size.width,size.height);
			WatchPainter watchPainter = WatchePainterFactory.factory(g,
					fontStyle, fontColor, backColor, fontSize);
			watchPainter.paintTime();
//			g.drawImage(back, 0, 0, this);
		}
	}

	public JPopupMenu getPopup() {
		return pop;
	}
}
