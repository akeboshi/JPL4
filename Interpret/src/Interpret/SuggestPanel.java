package Interpret;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyListener;

abstract class SuggestPanel extends Panel implements KeyListener, ItemListener,
		ActionListener {
	private static int LIST_ROW = 15;

	protected CreatedMembers createdMembers;
	protected MembersDialog membersDialog;
	protected Interpret interpret;

	protected Label panelNameLabel = new Label();
	protected Label searchLabel = new Label("検索:");
	protected TextField searchTextField = new TextField();
	protected List componentList = new List(LIST_ROW);
	protected Button jikkoButton = new Button();

	/**
	 *
	 * @param panelName
	 *            どのようなパネルなのか(ex. フィールドを変更する)
	 * @param createdMembers
	 */
	SuggestPanel(String panelName, CreatedMembers createdMembers,
			Interpret interpret) {
		this.createdMembers = createdMembers;
		this.interpret = interpret;
		panelNameLabel.setText(panelName);
		jikkoButton.setLabel(panelName);
		setMembersDialog();
		createComponent();
	}

	abstract void setMembersDialog();

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
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		int panel_y = 0;

		// Panelの種類ラベル
		addComponent(this, gbl, panelNameLabel, 0, panel_y++, 2, 1);

		// 検索ラベル
		addComponent(this, gbl, searchLabel, 0, panel_y, 1, 1);

		// 検索テキストフィールド
		searchTextField.addKeyListener(this);
		addComponent(this, gbl, searchTextField, 1, panel_y++, 1, 1);

		// 検索結果リスト
		componentList.addItemListener(this);
		addComponent(this, gbl, componentList, 0, panel_y++, 2, 1);

		// 実行ボタン
		jikkoButton.addActionListener(this);
		addComponent(this, gbl, jikkoButton, 0, panel_y++, 2, 1);
	}

	abstract void updateList(Class<?> cls);

	@Override
	public void setEnabled(boolean b) {
		searchTextField.setEnabled(b);
		panelNameLabel.setEnabled(b);
		searchLabel.setEnabled(b);
		componentList.setEnabled(b);
		jikkoButton.setEnabled(b);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jikkoButton) {
			membersDialog.setVisible(true);
		}

	}

}