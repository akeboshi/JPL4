package Interpret;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintStream;
import java.lang.reflect.Array;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Interpret extends Frame implements ActionListener, KeyListener,
		ItemListener {
	private static final long serialVersionUID = 1L;
	private final static int MAX_PANEL_SIZE_X = 2;
	private final static int MAX_PANEL_SIZE_Y = 20;

	public static boolean INTERPRET = false;
	public static InterpretConsole console;
	public static PrintStream stream;

	// コンポーネント
	private TextField classNameTextField = new TextField("Interpret.Interpret");
	private Checkbox arrayCheckbox = new Checkbox("配列にする");
	private TextField arrayNumberTextField = new TextField();
	private Label arrayNumberLabel = new Label("配列の個数を入力");
	private Button instanceCreatingButton = new Button("インスタンスを作成する");
	private TextField searchInstanceTextField = new TextField();
	private List instanceList = new List();
	private Choice inputArrayNumberChoice = new Choice();
	private Button updateFieldButton = new Button("フィールド一覧を更新");
	private List fieldList = new List();

	private Panel constructerPanel = new SuggesterPanel("コンストラクタ");
	private Panel methodPanel = new SuggesterPanel("メソッド");
	private Panel fieldPanel = new SuggesterPanel("フィールド");

	private CreatedMembers createdMembers = new CreatedMembers();

	@SuppressWarnings("unused")
	private Integer changeTest = 123;
	@SuppressWarnings("unused")
	private String testString = "str";

	public static void main(String args[]) {
		new Interpret();
	}

	public Interpret() {
		super();
		if (!INTERPRET) {
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

			stream = new PrintStream(console, true);
			INTERPRET = true;
		}
		System.setOut(stream);
		System.setErr(stream);

		setSize(1000, 500);
		setVisible(true);
		createMenu();
		createComponent();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				System.exit(0);
			}
		});
	}

	private void addComponent(Panel panel, GridBagLayout gbl,
			Component component, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbl.setConstraints(component, gbc);
		panel.add(component);
	}

	private void createComponent() {
		Panel mainPanel = new Panel();
		GridBagLayout mainGBL = new GridBagLayout();
		mainPanel.setLayout(mainGBL);
		setLayout(new GridLayout(1, 4));
		add(mainPanel);
		add(constructerPanel);
		add(methodPanel);
		add(fieldPanel);
		constructerPanel.setEnabled(false);
		methodPanel.setEnabled(false);
		fieldPanel.setEnabled(false);
		int panel_y = 0;

		// クラスネーム入力を促すラベル
		addComponent(mainPanel, mainGBL, new Label("インスタンスを作成したいクラス名を入力"), 0,
				panel_y++, 2, 1);

		// クラスネーム入力フィールド
		classNameTextField.addKeyListener(this);
		addComponent(mainPanel, mainGBL, classNameTextField, 0, panel_y++, 2, 1);

		// 配列用チェックボックス
		arrayCheckbox.addItemListener(this);
		addComponent(mainPanel, mainGBL, arrayCheckbox, 0, panel_y++, 1, 1);

		// 配列の個数入力誘導パネル
		addComponent(mainPanel, mainGBL, arrayNumberLabel, 0, panel_y, 1, 1);

		// 配列数入力用フィールド
		arrayNumberTextField.addKeyListener(this);
		arrayNumberTextField.setEnabled(arrayCheckbox.getState());
		addComponent(mainPanel, mainGBL, arrayNumberTextField, 1, panel_y++, 1,
				1);

		// インスタンス作成ボタン
		instanceCreatingButton.addActionListener(this);
		addComponent(mainPanel, mainGBL, instanceCreatingButton, 0, panel_y++,
				2, 1);

		// インスタンス表のラベル
		addComponent(mainPanel, mainGBL, new Label("実行するインスタンスをリストから選択"), 0,
				panel_y++, 2, 1);

		// 検索ラベル
		addComponent(mainPanel, mainGBL, new Label("検索:"), 0, panel_y, 1, 1);

		// インスタンス検索用
		searchInstanceTextField.addKeyListener(this);
		addComponent(mainPanel, mainGBL, searchInstanceTextField, 1, panel_y++,
				1, 1);

		// インスタンスの表
		instanceList.addItemListener(this);
		addComponent(mainPanel, mainGBL, instanceList, 0, panel_y++, 2, 1);

		// 配列の番号を入力を促すラベル
		addComponent(mainPanel, mainGBL, new Label("配列の番号を入力"), 0, panel_y, 1,
				1);

		// 配列の番号を選ぶChoice
		inputArrayNumberChoice.addItemListener(this);
		inputArrayNumberChoice.add("0");
		inputArrayNumberChoice.add("1");
		addComponent(mainPanel, mainGBL, inputArrayNumberChoice, 1, panel_y++,
				1, 1);
	}

	private void addItemListener(Interpret interpret2) {
		// TODO 自動生成されたメソッド・スタブ

	}

	private void createMenu() {
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

	private void createInstance(String classString) {
		String instanceName;
		if (arrayCheckbox.getState()) {
			if (!arrayNumberTextField.getText().equals("")) {
				try {
					instanceName = new String(createdMembers.sizeClassMap() + ": "
							+ classString + " ["
							+ arrayNumberTextField.getText() + "]");
					createdMembers.addClassMap(instanceName, Array.newInstance(
							Class.forName(classString),
							Integer.valueOf(arrayNumberTextField.getText())));

					instanceList.add(instanceName);
				} catch (NumberFormatException | NegativeArraySizeException
						| ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			} else {
				// TODO
				System.out.println("【Error】配列の数が指定されてません");
			}
		} else {
			try {
				instanceName = new String(createdMembers.sizeClassMap() + ": "
						+ classString);
				createdMembers.addClassMap(instanceName,
						Class.forName(classString));
				instanceList.add(instanceName);
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == instanceCreatingButton) {
			createInstance(classNameTextField.getText());
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if (e.getComponent() == searchInstanceTextField) {
			instanceList.removeAll();
			for (String item : createdMembers.getClassMap().keySet()) {
				if (item.indexOf(searchInstanceTextField.getText()) != -1)
					instanceList.add(item);
			}
		} else if (e.getComponent() == classNameTextField){
			if (e.getKeyChar() == '\n')
				createInstance(classNameTextField.getText());
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getItemSelectable() == arrayCheckbox) {
			arrayNumberTextField.setEnabled(arrayCheckbox.getState());
			arrayNumberLabel.setEnabled(arrayCheckbox.getState());
		} else if (e.getItemSelectable() == instanceList) {
		}

	}
}
