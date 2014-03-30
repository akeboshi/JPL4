package Interpret;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
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
import java.awt.ScrollPane;
import java.awt.TextArea;
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
	private Label searchListLabel = new Label("実行するインスタンスをリストから選択");
	private Label searchInstanceLabel = new Label("検索: ");
	private TextField searchInstanceTextField = new TextField();
	private List instanceList = new List();
	private Choice inputArrayNumberChoice = new Choice();
	private Label inputArrayNumberLabel = new Label("配列の番号を入力");

	private CreatedMembers createdMembers = new CreatedMembers();

	private SuggestPanel constructerPanel = new SuggesterConstrucotrPanel("コンストラクタ",
			createdMembers, this);
	private SuggestPanel methodPanel = new SuggestFieldPanel("メソッド",
			createdMembers, this);
	private SuggestPanel fieldPanel = new SuggestMethodPanel("フィールド",
			createdMembers, this);

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
			TextArea area = new TextArea();
			area.setEditable(false);
			area.setBackground(Color.white);
			console = new InterpretConsole(area);
			ScrollPane scroll = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
			scroll.add(area);

			Frame frame = new Frame("Console");
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
					System.exit(0);
				}
			});
			frame.add(scroll);
			frame.setBounds(0, 380, 500, 300);
			frame.setVisible(true);

			stream = new PrintStream(console, true);
			INTERPRET = true;
		}
		System.setOut(stream);
		System.setErr(stream);

		setSize(1000, 500);
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
		searchListLabel.setEnabled(false);
		addComponent(mainPanel, mainGBL, searchListLabel, 0, panel_y++, 2, 1);

		// 検索ラベル
		searchInstanceLabel.setEnabled(false);
		addComponent(mainPanel, mainGBL, searchInstanceLabel, 0, panel_y, 1, 1);

		// インスタンス検索用
		searchInstanceTextField.addKeyListener(this);
		searchInstanceTextField.setEnabled(false);
		addComponent(mainPanel, mainGBL, searchInstanceTextField, 1, panel_y++,
				1, 1);

		// インスタンスの表
		instanceList.addItemListener(this);
		instanceList.setEnabled(false);
		addComponent(mainPanel, mainGBL, instanceList, 0, panel_y++, 2, 1);

		// 配列の番号を入力を促すラベル
		inputArrayNumberLabel.setEnabled(false);
		addComponent(mainPanel, mainGBL, inputArrayNumberLabel, 0, panel_y, 1,
				1);

		// 配列の番号を選ぶChoice
		inputArrayNumberChoice.addItemListener(this);
		inputArrayNumberChoice.add("0");
		inputArrayNumberChoice.add("1");
		addComponent(mainPanel, mainGBL, inputArrayNumberChoice, 1, panel_y++,
				1, 1);

		setVisible(true);
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
		String instanceName = null;
		if (arrayCheckbox.getState()) {
			if (!arrayNumberTextField.getText().equals("")) {
				try {
					instanceName = new String(createdMembers.sizeClassMap()
							+ ": " + classString + " ["
							+ arrayNumberTextField.getText() + "]");
					createdMembers.addClassMap(instanceName, Array.newInstance(
							Class.forName(classString),
							Integer.valueOf(arrayNumberTextField.getText())));
					instanceList.add(instanceName);

					searchListLabel.setEnabled(true);
					searchInstanceLabel.setEnabled(true);
					searchInstanceTextField.setEnabled(true);
					instanceList.setEnabled(true);
				} catch (NumberFormatException | NegativeArraySizeException
						| ClassNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			} else {
				// TODO
				System.out.println("【Error】配列の数が指定されてません");
				return;
			}
		} else {
			try {
				// TODO コンストラクタを実行してくださいというDialog
				instanceName = new String(createdMembers.sizeClassMap() + ": "
						+ classString);
				constructerPanel.updateList(Class.forName(classString));
				constructerPanel.setEnabled(true);
				// createdMembers.addClassMap(instanceName,
				// Class.forName(classString));
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
		} else if (e.getComponent() == classNameTextField) {
			if (e.getKeyChar() == '\n')
				createInstance(classNameTextField.getText());
		} else if (e.getComponent() == arrayNumberTextField) {
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
			Object clsmem = createdMembers.getClassMap().get(
					instanceList.getSelectedItem());
			if (clsmem.getClass().isArray()) {
				inputArrayNumberChoice.removeAll();
				for (Integer i = 0; i < Array.getLength(clsmem); i++) {
					inputArrayNumberChoice.add(i.toString());
				}

				inputArrayNumberChoice.setEnabled(true);
				inputArrayNumberLabel.setEnabled(true);
			} else {
				inputArrayNumberChoice.setEnabled(false);
				inputArrayNumberLabel.setEnabled(false);
			}
		}

	}
}
