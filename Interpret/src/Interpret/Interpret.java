package Interpret;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.FieldPosition;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Interpret extends Frame implements ActionListener, MouseListener,
		MouseMotionListener {
	private static final String ARRAY_BUTTON_NAME = "Generate Array";
	private static final String OBJ_BUTTON_NAME = "Generate Object";
	private static final String SET_OBJ_NAME = "Set Object";
	private static final String CHANGE_FIELD_NAME = "Change Field";
	private static final String DO_METHOD_NAME = "Do Method";

	private static final long serialVersionUID = 1L;

	private Point startDrag, startPos;

	private String inputedText = null;

	private Class<?> bufClass = null;
	private Integer classNum = 0;
	private LinkedList<Class<?>> clazz = new LinkedList<>();
	private Map<String, Object> classMap = new HashMap<String, Object>();

	private TextField inputTextField = new TextField("Interpret.Interpret");
	private Choice methodsChoice = new Choice();
	private Choice fieldChoice = new Choice();
	private Choice constructorChoice = new Choice();
	private Choice classChoice = new Choice();
	private Button generateArrayButton = new Button(ARRAY_BUTTON_NAME);
	private Button generateObjButton = new Button(OBJ_BUTTON_NAME);
	private Button setObjeButton = new Button(SET_OBJ_NAME);
	private Button changeFieldButton = new Button(CHANGE_FIELD_NAME);
	private Button doMethodButton = new Button(DO_METHOD_NAME);

	private Class<?> setClass;
	private Object setInstance;

	private Field[] fields;
	private Method[] methods;
	private Constructor<?>[] constructors;

	private Integer changeTest = 123;
	private String testString = "str";

	public static void main(String args[]) {
		new Interpret();
	}

	public Interpret() {
		super();
		setSize(660, 500);
		setVisible(true);
		generateMenu();
		generateTextField();
		addMouseListener(this);
		addMouseMotionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				System.exit(0);
			}
		});
	}

	private void generateTextField() {
		setLayout(new GridLayout(20, 1));

		// オブジェクト文字列入力フィールド
		add(inputTextField);

		// OKボタン
		Button okButton = new Button("ok");
		okButton.setPreferredSize(new Dimension(200, 20));
		okButton.addActionListener(this);
		add(okButton);

		// インスタンス生成用
		generateObjButton.setPreferredSize(new Dimension(200, 20));
		generateObjButton.addActionListener(this);
		generateObjButton.setEnabled(false);
		add(generateObjButton);

		// 配列生成用
		generateArrayButton.setPreferredSize(new Dimension(200, 20));
		generateArrayButton.addActionListener(this);
		generateArrayButton.setEnabled(false);
		add(generateArrayButton);

		// class用
		classChoice.setEnabled(false);
		add(classChoice);

		setObjeButton.setPreferredSize(new Dimension(200, 20));
		setObjeButton.addActionListener(this);
		setObjeButton.setEnabled(false);
		add(setObjeButton);

		// constructor用
		constructorChoice.setEnabled(false);
		add(constructorChoice);

		// method用
		methodsChoice.setEnabled(false);
		add(methodsChoice);
		doMethodButton.setPreferredSize(new Dimension(200, 20));
		doMethodButton.addActionListener(this);
		doMethodButton.setEnabled(false);
		add(doMethodButton);

		// field用
		fieldChoice.setEnabled(false);
		add(fieldChoice);
		changeFieldButton.setPreferredSize(new Dimension(200, 20));
		changeFieldButton.addActionListener(this);
		changeFieldButton.setEnabled(false);
		add(changeFieldButton);

		setVisible(true);
	}

	public void generateMenu() {
		MenuBar menubar = new MenuBar();
		setMenuBar(menubar);

		Menu Menu1 = new Menu("ファイル");
		menubar.add(Menu1);

		MenuItem closem = new MenuItem("閉じる");

		// メニューアイテムの追加
		Menu1.add(closem);

		// イベントリスクの設定
		closem.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ok") {
			bufClass = null;
			inputedText = inputTextField.getText();
			try {
				bufClass = Class.forName(inputedText);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			if (bufClass != null) {
				generateArrayButton.setEnabled(true);
				generateObjButton.setEnabled(true);
			} else {
				generateArrayButton.setEnabled(false);
				generateObjButton.setEnabled(false);
			}
		} else if (e.getActionCommand() == OBJ_BUTTON_NAME) {
			try {
				bufClass = Class.forName(inputedText);
				System.out.println("created" + bufClass.toString());
				clazz.add(bufClass);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			classChoice.setEnabled(true);
			setObjeButton.setEnabled(true);
			classChoice.add(classNum + " : " + bufClass.getName());
			try {
				classMap.put(classNum.toString(), bufClass.newInstance());
			} catch (InstantiationException | IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			classNum++;
		} else if (e.getActionCommand() == ARRAY_BUTTON_NAME) {

		} else if (e.getActionCommand() == SET_OBJ_NAME) {
			setClass = clazz.get(classChoice.getSelectedIndex());
			Integer test;
			test = ((Integer) classChoice.getSelectedIndex());
			setInstance = classMap.get(test.toString());

			fields = setClass.getDeclaredFields();
			fieldChoice.removeAll();
			if (fields.length != 0) {
				for (Field fld : fields) {
					fieldChoice.add(fld.getType().getName() + " "
							+ fld.getName());
				}
				fieldChoice.setEnabled(true);
				changeFieldButton.setEnabled(true);
			} else {
				fieldChoice.setEnabled(false);
				changeFieldButton.setEnabled(false);
			}

			methods = setClass.getDeclaredMethods();
			methodsChoice.removeAll();
			if (methods.length != 0) {
				for (Method mtd : methods) {
					methodsChoice.add(mtd.getName());
				}
				methodsChoice.setEnabled(true);
				doMethodButton.setEnabled(true);
			} else {
				methodsChoice.setEnabled(false);
				doMethodButton.setEnabled(false);
			}

			constructors = setClass.getDeclaredConstructors();
			constructorChoice.removeAll();
			for (Constructor<?> con : constructors) {
				constructorChoice.add(con.getName());
			}
			constructorChoice.setEnabled(true);

		} else if (e.getActionCommand() == CHANGE_FIELD_NAME) {
			ChangeFieldDialog cfd = new ChangeFieldDialog(this,
					fieldChoice.getSelectedItem(), setInstance,
					fields[fieldChoice.getSelectedIndex()]);
			cfd.viewProperty();
		} else if (e.getActionCommand() == DO_METHOD_NAME) {
			MethodDialog md = new MethodDialog(this,
					methodsChoice.getSelectedItem(), setInstance,
					methods[methodsChoice.getSelectedIndex()], classMap);
			md.viewProperty();
		} else if (e.getActionCommand() == "閉じる") {
			System.exit(0);
		}
	}

	public String getTestString() {
		System.out.println("getString");
		return testString;
	}

	public void setTestString(String testString) {
		System.out.println("setString");
		this.testString = testString;
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
		}
	}

	Point getScreenLocation(MouseEvent e) {
		Point p1 = e.getPoint();
		Point p2 = this.getLocationOnScreen();
		return new Point(p1.x + p2.x, p1.y + p2.y);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {
			startDrag = getScreenLocation(e);
			startPos = this.getLocation();
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
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {
			Point cursor = getScreenLocation(e);
			int xdiff = cursor.x - startDrag.x;
			int ydiff = cursor.y - startDrag.y;
			this.setLocation(startPos.x + xdiff, startPos.y + ydiff);
		}
		if ((e.getModifiers() & MouseEvent.BUTTON2_MASK) != 0) {
		}
		if ((e.getModifiers() & MouseEvent.BUTTON3_MASK) != 0) {
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
