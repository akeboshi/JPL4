package Interpret;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
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
import java.util.Arrays;

public class Interpret extends Frame implements ActionListener, KeyListener,
		ItemListener {
	private static final long serialVersionUID = 1L;
	private static final int ROW_SIZE = 12;
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
	private List instanceList = new List(ROW_SIZE);
	private Choice inputArrayNumberChoice = new Choice();
	private Label inputArrayNumberLabel = new Label("配列の番号を入力");

	private CreatedMembers createdMembers = new CreatedMembers();

	private SuggestPanel constructerPanel = new SuggesterConstrucotrPanel(
			"                                                          コンストラクタを実行する                                                          ",
			createdMembers, this);
	private SuggestPanel methodPanel = new SuggestMethodPanel(
			"                                                                メソッドを実行する                                                                ",
			createdMembers, this);
	private SuggestPanel fieldPanel = new SuggestFieldPanel(
			"                                                                フィールドを変更する                                                                ",
			createdMembers, this);

	private TextArea area = null;

	public static void main(String args[]) {
		new Interpret();
	}

	public Interpret() {
		super();

		if (!INTERPRET) {
			 area = new TextArea();
			area.setEditable(false);
			area.setBackground(Color.white);
			console = new InterpretConsole(area);
			stream = new PrintStream(console, true);
			INTERPRET = true;
		}
		System.setOut(stream);
		System.setErr(stream);

		setSize(1000, 750);
		createMenu();
		createComponent();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				System.exit(0);
			}
		});
	}

	private void addComponent(Container panel, GridBagLayout gbl,
			Component component, int x, int y, int w, int h) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		gbc.insets = new Insets(2, 2, 2, 2);
		gbl.setConstraints(component, gbc);
		panel.add(component);
	}

	private void createComponent() {
		GridBagLayout interpretGBL = new GridBagLayout();
		Panel mainPanel = new Panel();
		GridBagLayout mainPanelGBL = new GridBagLayout();
		mainPanel.setLayout(mainPanelGBL);
		setLayout(interpretGBL);

		int panel_y = 0;
		constructerPanel.setEnabled(false);
		methodPanel.setEnabled(false);
		fieldPanel.setEnabled(false);
		addComponent(this, interpretGBL, mainPanel, 0, panel_y, 1, 3);
		addComponent(this, interpretGBL, constructerPanel, 1, panel_y++, 3, 1);
		addComponent(this, interpretGBL, methodPanel, 1, panel_y++, 3, 1);
		addComponent(this, interpretGBL, fieldPanel, 1, panel_y++, 3, 1);
		addComponent(this, interpretGBL, new Label("----------------------------------------------------------------------------------------------------コンソール----------------------------------------------------------------------------------------------------"), 0, panel_y++, 4, 1);
		if (area != null)
			addComponent(this, interpretGBL, area, 0, panel_y++, 4, 1);
		panel_y = 0;

		// クラスネーム入力を促すラベル
		addComponent(mainPanel, mainPanelGBL, new Label("インスタンスを作成したいクラス名を入力"),
				0, panel_y++, 2, 1);

		// クラスネーム入力フィールド
		classNameTextField.addKeyListener(this);
		addComponent(mainPanel, mainPanelGBL, classNameTextField, 0, panel_y++,
				2, 1);

		// 配列用チェックボックス
		arrayCheckbox.addItemListener(this);
		addComponent(mainPanel, mainPanelGBL, arrayCheckbox, 0, panel_y++, 1, 1);

		// 配列の個数入力誘導パネル
		addComponent(mainPanel, mainPanelGBL, arrayNumberLabel, 0, panel_y, 1,
				1);

		// 配列数入力用フィールド
		arrayNumberTextField.addKeyListener(this);
		arrayNumberTextField.setEnabled(arrayCheckbox.getState());
		addComponent(mainPanel, mainPanelGBL, arrayNumberTextField, 1,
				panel_y++, 1, 1);

		// インスタンス作成ボタン
		instanceCreatingButton.addActionListener(this);
		addComponent(mainPanel, mainPanelGBL, instanceCreatingButton, 0,
				panel_y++, 2, 1);

		// インスタンス表のラベル
		searchListLabel.setEnabled(false);
		addComponent(mainPanel, mainPanelGBL, searchListLabel, 0, panel_y++, 2,
				1);

		// 検索ラベル
		searchInstanceLabel.setEnabled(false);
		addComponent(mainPanel, mainPanelGBL, searchInstanceLabel, 0, panel_y,
				1, 1);

		// インスタンス検索用
		searchInstanceTextField.addKeyListener(this);
		searchInstanceTextField.setEnabled(false);
		addComponent(mainPanel, mainPanelGBL, searchInstanceTextField, 1,
				panel_y++, 1, 1);

		// インスタンスの表
		instanceList.addItemListener(this);
		instanceList.setEnabled(false);
		addComponent(mainPanel, mainPanelGBL, instanceList, 0, panel_y++, 2, 1);

		// 配列の番号を入力を促すラベル
		inputArrayNumberLabel.setEnabled(false);
		addComponent(mainPanel, mainPanelGBL, inputArrayNumberLabel, 0,
				panel_y, 1, 1);

		// 配列の番号を選ぶChoice
		inputArrayNumberChoice.addItemListener(this);
		addComponent(mainPanel, mainPanelGBL, inputArrayNumberChoice, 1,
				panel_y++, 1, 1);

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
		closem.addActionListener(new ActionAdapter(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}

	 abstract class ActionAdapter implements ActionListener {
		    public abstract void actionPerformed(ActionEvent ev);
		  }

	/**
	 * インスタンスのリストをアップデート
	 */
	void refreshInstanceList() {
		instanceList.removeAll();
		for (String item : createdMembers.getClassMap().keySet()) {
			if (item.indexOf(searchInstanceTextField.getText()) != -1)
				instanceList.add(item);
		}
		searchListLabel.setEnabled(true);
		searchInstanceLabel.setEnabled(true);
		searchInstanceTextField.setEnabled(true);
		instanceList.setEnabled(true);
	}

	private void createInstance(String classString) {
		String instanceName = null;
		// 配列の時
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
			// 配列ではない時
			try {
				// TODO コンストラクタを実行してくださいというDialog
				createdMembers.setSelectedClass(null);
				constructerPanel.updateList(Class.forName(classString));
				constructerPanel.setEnabled(true);
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

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
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

	private void updateConstructorPanel() {
		Integer inputANC = inputArrayNumberChoice.getSelectedIndex();
		Object selectedObj = createdMembers.getSelectedClass();
		if (Array.get(selectedObj, inputANC) == null) {
			createdMembers.setSelectedArrayNumber(inputArrayNumberChoice
					.getSelectedIndex());
			System.out.println((createdMembers.getSelectedClass().getClass()));
			constructerPanel.updateList(createdMembers.getSelectedClass()
					.getClass().getComponentType());
			updateMethodAndFieldPanel(false);
			constructerPanel.setEnabled(true);
		} else {
			updateMethodAndFieldPanel(true);
			constructerPanel.setEnabled(false);
		}
	}

	void updateMethodAndFieldPanel(boolean b) {
		Class<?> cls = createdMembers.getSelectedClass().getClass();
		if (cls.isArray())
			cls = cls.getComponentType();
		// メソッドを使えるように更新する
		// フィールドを使えるように更新
		methodPanel.updateList(cls);
		fieldPanel.updateList(cls);
		methodPanel.setEnabled(b);
		fieldPanel.setEnabled(b);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getItemSelectable() == arrayCheckbox) {
			arrayNumberTextField.setEnabled(arrayCheckbox.getState());
			arrayNumberLabel.setEnabled(arrayCheckbox.getState());
		} else if (e.getItemSelectable() == instanceList) {
			Object selectedObj = createdMembers.getClassMap().get(
					instanceList.getSelectedItem());
			createdMembers.setSelectedClass(selectedObj);
			if (selectedObj.getClass().isArray()) {
				inputArrayNumberChoice.removeAll();
				for (Integer i = 0; i < Array.getLength(selectedObj); i++) {
					inputArrayNumberChoice.add(i.toString());
				}
				System.out.println(Arrays.deepToString((Object[]) selectedObj));

				updateConstructorPanel();

				inputArrayNumberChoice.setEnabled(true);
				inputArrayNumberLabel.setEnabled(true);
			} else {

				updateMethodAndFieldPanel(true);

				inputArrayNumberChoice.setEnabled(false);
				inputArrayNumberLabel.setEnabled(false);
			}
		} else if (e.getItemSelectable() == inputArrayNumberChoice) {
			updateConstructorPanel();
		}

	}
}
