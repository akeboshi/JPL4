package Interpret;

import java.awt.Button;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
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
import java.util.ArrayList;

abstract class MembersDialog extends Dialog implements KeyListener,
		ActionListener, ItemListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static int LIST_ROW = 5;

	protected Interpret owner;
	protected CreatedMembers createdMembers;
	protected Integer paramSize;
	protected ArrayList<Class<?>> paramTypes = new ArrayList<Class<?>>();
	protected Object[] paramObjs;

	protected ArrayList<Label> panelNameLabel = new ArrayList<Label>();
	protected static final String searchLabelText = "検索: ";
	protected ArrayList<Label> searchLabel = new ArrayList<Label>();
	protected ArrayList<TextField> searchTextField = new ArrayList<TextField>();
	protected static final String paramFromStringLabelText = "文字列から取得";
	protected ArrayList<Label> paramFromStringLabel = new ArrayList<Label>();
	protected ArrayList<TextField> paramFromStringTextField = new ArrayList<TextField>();
	protected ArrayList<List> componentList = new ArrayList<List>();
	protected Button jikkoButton = new Button("実行する");
	protected ArrayList<Label> setParamLabel = new ArrayList<Label>();
	protected ArrayList<Button> setFromTextButton = new ArrayList<Button>();
	protected ArrayList<Button> setFromObjectButton = new ArrayList<Button>();

	public MembersDialog(Interpret owner, CreatedMembers createdMembers,
			String dialogName) {
		super(owner, true);
		this.owner = owner;
		this.createdMembers = createdMembers;

		setParams();
		createPanel();

		paramObjs = new Object[paramSize];
		setSize(150 * (paramSize + 1), 300);
		setResizable(false);
		setTitle(dialogName);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				setVisible(false);
			}
		});
	}

	/**
	 * paramSizeとpramTypesの設定
	 */
	abstract protected void setParams();

	private void createPanel() {
		setLayout(new GridLayout(1, paramSize + 1));
		for (Integer i = 0; i < paramSize; i++) {
			Panel dialogPanel = new Panel();
			GridBagLayout gbl = new GridBagLayout();
			dialogPanel.setLayout(gbl);

			int panel_y = 0;

			// Panelの種類ラベル
			panelNameLabel.add(new Label(paramTypes.get(i).toString() + "を設定"));
			addComponent(dialogPanel, gbl, panelNameLabel.get(i), 0, panel_y++,
					2, 1);

			// 文字列から引数を取得するラベルとテキストフィールド
			paramFromStringLabel.add(new Label(paramFromStringLabelText));
			addComponent(dialogPanel, gbl, paramFromStringLabel.get(i), 0,
					panel_y++, 2, 1);
			paramFromStringTextField.add(new TextField());
			paramFromStringTextField.get(i).addKeyListener(this);
			addComponent(dialogPanel, gbl, paramFromStringTextField.get(i), 0,
					panel_y++, 2, 1);

			// 検索ラベル
			searchLabel.add(new Label(searchLabelText));
			addComponent(dialogPanel, gbl, new Label("インスタンスから取得"), 0,
					panel_y++, 2, 1);
			addComponent(dialogPanel, gbl, searchLabel.get(i), 0, panel_y, 1, 1);

			// 検索テキストフィールド
			searchTextField.add(new TextField());
			searchTextField.get(i).addKeyListener(this);
			addComponent(dialogPanel, gbl, searchTextField.get(i), 1,
					panel_y++, 1, 1);

			// 検索結果リスト
			componentList.add(new List(LIST_ROW));
			componentList.get(i).addItemListener(this);
			addComponent(dialogPanel, gbl, componentList.get(i), 0, panel_y++,
					2, 1);
			for(String objKey : createdMembers.getClassMap().keySet()){
				componentList.get(i).add(objKey);
			}

			// テキストから引数をゲットするためのボタン
			setFromTextButton.add(new Button("文字列から取得"));
			setFromTextButton.get(i).addActionListener(this);
			addComponent(dialogPanel, gbl, setFromTextButton.get(i), 0,
					panel_y++, 2, 1);

			// オブジェクトから引数をゲットするためのボタン
			setFromObjectButton.add(new Button("インスタンスから取得"));
			setFromObjectButton.get(i).addActionListener(this);
			addComponent(dialogPanel, gbl, setFromObjectButton.get(i), 0,
					panel_y++, 2, 1);
			add(dialogPanel);
		}

		// 実行用パネル
		// 設定されている引数を表示と、実行ボタンがある。
		Panel actionPanel = new Panel();
		GridBagLayout gbl = new GridBagLayout();
		actionPanel.setLayout(gbl);

		int panel_y = 0;

		for (Integer i = 0; i < paramSize; i++) {
			setParamLabel.add(new Label("null"));
			addComponent(actionPanel, gbl, setParamLabel.get(i), 0, panel_y++,
					1, 1);
		}

		jikkoButton.addActionListener(this);
		addComponent(actionPanel, gbl, jikkoButton, 0, panel_y++, 1, 1);

		add(actionPanel);
	}

	protected void addComponent(Panel panel, GridBagLayout gbl,
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

	abstract void doReflectMember();

	@Override
	public void actionPerformed(ActionEvent e) {
		for (Integer i = 0; i < paramSize; i++) {
			Object setObj;
			if (e.getSource() == setFromTextButton.get(i)) {
				// 文字列から取得ボタンを押された時に、文字列から取得の文字列を取得して、
				// そのフィールドのクラスに変換する
				// ただし、プリミティブ型ではないときはnullが返される
				setObj = createObjFromString(paramFromStringTextField
						.get(i).getText(), paramTypes.get(i));
				paramObjs[i] = setObj;
				setParamLabel.get(i).setText(setObj.toString());
			} else if (e.getSource() == setFromObjectButton.get(i)) {
				setObj = componentList.get(i).getSelectedItem();
				paramObjs[i] = createdMembers.getClassMap().get(setObj);
				setParamLabel.get(i).setText(setObj.toString());
			}
		}
		if(e.getSource() == jikkoButton){
			doReflectMember();
			setVisible(false);
		}
	}

	/**
	 * String inputからClass typeに対応する基本データ型を返す
	 *
	 * @param input
	 * @param type
	 * @return 基本データ型、typeが基本データ型以外の物はnull
	 */
	protected Object createObjFromString(String input, Class<?> type) {
		// 基本データ型

		if (type.equals(Boolean.class) || type.equals(boolean.class)
				|| type.equals(Boolean[].class) || type.equals(boolean[].class)
				|| type.equals(Boolean[][].class)
				|| type.equals(boolean[][].class)) {
			return Boolean.valueOf(input);

		} else if (type.equals(Byte.class) || type.equals(byte.class)
				|| type.equals(Byte[].class) || type.equals(byte[].class)
				|| type.equals(Byte[][].class) || type.equals(byte[][].class)) {
			return Byte.valueOf(input);

		} else if (type.equals(Character.class) || type.equals(char.class)
				|| type.equals(Character[].class) || type.equals(char[].class)
				|| type.equals(Character[][].class)
				|| type.equals(char[][].class)) {
			return input.toCharArray();
		} else if (type.equals(Short.class) || type.equals(short.class)
				|| type.equals(Short[].class) || type.equals(short[].class)
				|| type.equals(Short[][].class) || type.equals(short[][].class)) {
			return Short.valueOf(input);

		} else if (type.equals(Integer.class) || type.equals(int.class)
				|| type.equals(Integer[].class) || type.equals(int[].class)
				|| type.equals(Integer[][].class) || type.equals(int[][].class)) {
			return Integer.valueOf(input);
		} else if (type.equals(Long.class) || type.equals(long.class)
				|| type.equals(Long[].class) || type.equals(long[].class)
				|| type.equals(Long[][].class) || type.equals(long[][].class)) {
			return Long.valueOf(input);

		} else if (type.equals(Double.class) || type.equals(double.class)
				|| type.equals(Double[].class) || type.equals(double[].class)
				|| type.equals(Double[][].class) || type.equals(double[].class)) {
			return Double.valueOf(input);

		} else if (type.equals(Float.class) || type.equals(float.class)
				|| type.equals(Float[].class) || type.equals(float[].class)
				|| type.equals(Float[][].class) || type.equals(float[][].class)) {
			return Float.valueOf(input);

		} else if (type.equals(String.class) || type.equals(String[].class)
				|| type.equals(String[][].class)) {
			return input;

		} else {
			/*
			 * 未定義
			 */
			return null;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
}