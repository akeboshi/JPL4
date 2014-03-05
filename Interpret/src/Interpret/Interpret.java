package Interpret;


import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Interpret extends Frame implements ActionListener, MouseListener,
		MouseMotionListener {
	private static final String ARRAY_NUM_BUTTON_NAME = "Set Array Num";
	private static final String OK_BUTTON_NAME = "Set Class";
	private static final String ARRAY_BUTTON_NAME = "Generate Array";
	private static final String OBJ_BUTTON_NAME = "Generate Object";
	private static final String SET_OBJ_NAME = "Set Object";
	private static final String CHANGE_FIELD_NAME = "Change Field";
	private static final String DO_METHOD_NAME = "Do Method";
	
	public static boolean INTERPRET = false;
	public static InterpretConsole console;
	public static PrintStream stream;
	private static final long serialVersionUID = 1L;

	private Point startDrag, startPos;

	private String inputedText = null;

	private Class<?> bufClass = null;
	private Integer classNum = 0;
	@SuppressWarnings("unused")
	private String setInstanceName;
	private Map<String, Object> classMap = new HashMap<String, Object>();

	private TextField inputTextField = new TextField("Interpret.Interpret");
	private TextField arrayNumField = new TextField("0");
	private Choice methodsChoice = new Choice();
	private Choice fieldChoice = new Choice();
	private Choice constructorChoice = new Choice();
	private Choice classChoice = new Choice();
	private Button setArrayNumButton = new Button(ARRAY_NUM_BUTTON_NAME);
	private Button generateArrayButton = new Button(ARRAY_BUTTON_NAME);
	private Button generateObjButton = new Button(OBJ_BUTTON_NAME);
	private Button setObjeButton = new Button(SET_OBJ_NAME);
	private Button changeFieldButton = new Button(CHANGE_FIELD_NAME);
	private Button doMethodButton = new Button(DO_METHOD_NAME);

	private Class<?> setClass;
	private Object setInstance;

	private ArrayList<Field> fields = new ArrayList<Field>();
	private Map<String, Method> methods = new HashMap<String, Method>();
	private ArrayList<Constructor<?>> constructors = new ArrayList<Constructor<?>>();

	@SuppressWarnings("unused")
	private Integer changeTest = 123;
	private String testString = "str";

	public static void main(String args[]) {
		new Interpret();
	}

	public Interpret() {
		super();
		if(!INTERPRET){
			JTextArea area = new JTextArea();
			area.setEditable(false);
				console = new InterpretConsole(area);
				JScrollPane scroll = new JScrollPane(area);
				scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

				JFrame frame = new JFrame("Console");
				frame.add(scroll);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setBounds(0, 380, 500, 300);
				frame.setVisible(true);
				
				stream = new PrintStream(console,true);
				INTERPRET = true;
			}
			System.setOut(stream);
			System.setErr(stream);

			
		
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
		Button okButton = new Button(OK_BUTTON_NAME);
		okButton.setPreferredSize(new Dimension(200, 20));
		okButton.addActionListener(this);
		add(okButton);

		// インスタンス生成用
		// constructor用
		constructorChoice.setEnabled(false);
		add(constructorChoice);

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

		// 配列操作用
		arrayNumField.setEnabled(false);
		add(arrayNumField);
		setArrayNumButton.setPreferredSize(new Dimension(200, 20));
		setArrayNumButton.addActionListener(this);
		setArrayNumButton.setEnabled(false);
		add(setArrayNumButton);

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
		if (e.getActionCommand() == OK_BUTTON_NAME) {
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
				constructors.clear();
				for (Constructor<?> con : bufClass.getDeclaredConstructors()) {
					constructors.add(con);
				}
				constructorChoice.removeAll();
				for (Constructor<?> con : constructors) {
					String conStr = con.getName() + "(";
					for (Class<?> paramCls : con.getParameterTypes()){
						conStr += paramCls.getCanonicalName();
					}	
					constructorChoice.add(conStr + ")");
				}
				constructorChoice.setEnabled(true);
			} else {
				generateArrayButton.setEnabled(false);
				generateObjButton.setEnabled(false);
				constructorChoice.setEnabled(false);
			}
		} else if (e.getActionCommand() == OBJ_BUTTON_NAME) {

			ConstructorDialog cond = new ConstructorDialog(this,
					constructorChoice.getSelectedItem(),
					constructors.get(constructorChoice.getSelectedIndex()),
					classMap);
			cond.viewProperty();
		} else if (e.getActionCommand() == ARRAY_BUTTON_NAME) {
			try {
				ArrayDialog ad = new ArrayDialog(this, inputedText,
						Class.forName(inputedText), classMap);
				ad.viewProperty();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}

		} else if (e.getActionCommand() == SET_OBJ_NAME) {
			setInstanceName = classChoice.getSelectedItem();
			setInstance = classMap.get(((Integer) classChoice
					.getSelectedIndex()).toString());
			setClass = setInstance.getClass();

			if (setInstance.getClass().isArray()) {
				setArrayNumButton.setEnabled(true);
				arrayNumField.setText("0");
				arrayNumField.setEnabled(true);
				fieldChoice.setEnabled(false);
				changeFieldButton.setEnabled(false);
				methodsChoice.setEnabled(false);
				doMethodButton.setEnabled(false);
			} else {
				setArrayNumButton.setEnabled(false);
				arrayNumField.setEnabled(false);
				fields.clear();
				for (Field f : setClass.getDeclaredFields()) {
					fields.add(f);
				}
				fieldChoice.removeAll();
				if (fields.size() != 0) {
					for (Field fld : fields) {
						fieldChoice.add(fld.getType().getCanonicalName() + " "
								+ fld.getName());
					}
					fieldChoice.setEnabled(true);
					changeFieldButton.setEnabled(true);
				} else {
					fieldChoice.setEnabled(false);
					changeFieldButton.setEnabled(false);
				}
				methods.clear();
				Class<?> mmmClass = setClass;
				methodsChoice.removeAll();
				TreeSet<String> methodSet = new TreeSet<String>();
				while (mmmClass != Object.class) {
					for (Method mtd : mmmClass.getDeclaredMethods()) {
						String methodName = "";
						methodName += mtd.getReturnType().getCanonicalName()
								+ " ";
						methodName += mtd.getName() + "(";
						for (Class<?> s : mtd.getParameterTypes())
							methodName += s.getCanonicalName() + " ";
						methodName += ")";
						methodSet.add(methodName);
						methods.put(methodName, mtd);
					}
					mmmClass = mmmClass.getSuperclass();
				}
				for (String mStr : methodSet) {
					methodsChoice.add(mStr);
				}
				if (methods.size() != 0) {
					methodsChoice.setEnabled(true);
					doMethodButton.setEnabled(true);
				} else {
					methodsChoice.setEnabled(false);
					doMethodButton.setEnabled(false);
				}
			}
		} else if (e.getActionCommand() == ARRAY_NUM_BUTTON_NAME) {
			setClass = setInstance.getClass();
			setInstance = Array.get(setInstance,
					Integer.valueOf(arrayNumField.getText()));
			if (setInstance != null) {
				fields.clear();
				for (Field f : setClass.getDeclaredFields()) {
					fields.add(f);
				}
				fieldChoice.removeAll();
				if (fields.size() != 0) {
					for (Field fld : fields) {
						fieldChoice.add(fld.getType().getCanonicalName() + " "
								+ fld.getName());
					}
					fieldChoice.setEnabled(true);
					changeFieldButton.setEnabled(true);
				} else {
					fieldChoice.setEnabled(false);
					changeFieldButton.setEnabled(false);
				}
				methods.clear();
				Class<?> mmmClass = setClass;
				methodsChoice.removeAll();
				TreeSet<String> methodSet = new TreeSet<String>();
				while (mmmClass != Object.class) {
					for (Method mtd : mmmClass.getDeclaredMethods()) {
						String methodName = "";
						methodName += mtd.getReturnType().getCanonicalName()
								+ " ";
						methodName += mtd.getName() + "(";
						for (Class<?> s : mtd.getParameterTypes())
							methodName += s.getCanonicalName() + " ";
						methodName += ")";
						methodSet.add(methodName);
						methods.put(methodName, mtd);
					}
					mmmClass = mmmClass.getSuperclass();
				}
				for (String mStr : methodSet) {
					methodsChoice.add(mStr);
				}
				if (methods.size() != 0) {
					methodsChoice.setEnabled(true);
					doMethodButton.setEnabled(true);
				} else {
					methodsChoice.setEnabled(false);
					doMethodButton.setEnabled(false);
				}
			}
		} else if (e.getActionCommand() == CHANGE_FIELD_NAME) {
			ChangeFieldDialog cfd = new ChangeFieldDialog(this,
					fieldChoice.getSelectedItem(), setInstance,
					fields.get(fieldChoice.getSelectedIndex()));
			cfd.viewProperty();
		} else if (e.getActionCommand() == DO_METHOD_NAME) {
			MethodDialog md = new MethodDialog(this,
					methodsChoice.getSelectedItem(), setInstance,
					methods.get(methodsChoice.getSelectedItem()), classMap);
			md.viewProperty();
		} else if (e.getActionCommand() == "閉じる") {
			System.exit(0);
		}
	}

	<T> void addInstance(T instance) {
		classChoice.setEnabled(true);
		setObjeButton.setEnabled(true);
		classChoice.add(classNum + " : " + instance.getClass());
		classMap.put(classNum.toString(), instance);
		classNum++;
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
