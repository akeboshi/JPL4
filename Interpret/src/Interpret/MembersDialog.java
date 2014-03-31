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
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

abstract class MembersDialog extends Dialog implements KeyListener,
		ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int LIST_ROW = 5;

	protected CreatedMembers createdMembers;
	private String dialogName;
	protected Integer paramSize;
	protected String[] paramTypes;

	protected ArrayList<Label> panelNameLabel = new ArrayList<Label>();
	protected static final String searchLabelText = "検索: ";
	protected ArrayList<Label> searchLabel = new ArrayList<Label>();
	protected ArrayList<TextField> searchTextField = new ArrayList<TextField>();
	protected static final String paramFromStringLabelText = "文字列から入力を行う";
	protected ArrayList<Label> paramFromStringLabel = new ArrayList<Label>();
	protected ArrayList<TextField> paramFromStringTextField = new ArrayList<TextField>();
	protected ArrayList<List> componentList = new ArrayList<List>();
	protected ArrayList<Button> jikkoButton = new ArrayList<Button>();

	public MembersDialog(Interpret owner, CreatedMembers createdMembers,
			String dialogName) {
		super(owner);
		this.dialogName = dialogName;
		this.createdMembers = createdMembers;
		setSize(400, 200);
		setResizable(false);
		setTitle(dialogName);

		setParamSize();
		createPanel();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				setVisible(false);
			}
		});
	}

	private void setParamSize() {
		paramSize = 2;
		String[] buf = { "int", "int" };
		paramTypes = buf;
		for (int i =0 ; i < paramSize ;i++){
			panelNameLabel.add(new Label("int" + "を設定"));
		}
	}

	private void createPanel() {
		//Panel[] dialogPanel = new Panel[paramSize];
		setLayout(new GridLayout(1, 3));
		for (Integer i = 0 ; i< paramSize ; i++){
			Panel dialogPanel = new Panel();
			GridBagLayout gbl = new GridBagLayout();
			dialogPanel.setLayout(gbl);

			int panel_y = 0;

			// Panelの種類ラベル
			addComponent(dialogPanel, gbl, panelNameLabel.get(i), 0, panel_y++, 2,
					1);

			// 検索ラベル
			searchLabel.add(new Label(searchLabelText));
			addComponent(dialogPanel, gbl, searchLabel.get(i), 0, panel_y, 1, 1);

			// 検索テキストフィールド
			searchTextField.add(new TextField());
			searchTextField.get(i).addKeyListener(this);
			addComponent(dialogPanel, gbl, searchTextField.get(i), 1, panel_y++, 1,
					1);

			// 検索結果リスト
			componentList.add(new List());
			addComponent(dialogPanel, gbl, componentList.get(i), 0, panel_y++, 2, 1);
			
			add(dialogPanel);
		}
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
			/*
			 * TODO char型未定義
			 */

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
		return null;
	}
}