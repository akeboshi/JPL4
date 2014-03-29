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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class SuggesterPanel extends Panel implements KeyListener, ItemListener, ActionListener{
	private static int LIST_ROW = 15;

	private Label panelNameTextField = new Label();
	private Label searchLabel = new Label("検索:");
	private TextField searchTextField = new TextField();
	private List componentList = new List(LIST_ROW);
	private Button jikkoButton = new Button();
	private String jikkoName = new String();

	SuggesterPanel(String panelName){
		panelNameTextField.setText(panelName);
		if(panelName.equals("フィールド")){
			jikkoName = panelName + "を変更する";
			jikkoButton.setLabel(jikkoName);
		}else{
			jikkoName = panelName + "を実行する";
			jikkoButton.setLabel(jikkoName);
		}
			createComponent();
	}

	private void addComponent(Panel panel, GridBagLayout gbl, Component component, int x,
			int y, int w, int h) {
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
		addComponent(this, gbl, panelNameTextField, 0, panel_y++, 2, 1);

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

	@Override
    public void setEnabled(boolean b) {
        searchTextField.setEnabled(b);
        panelNameTextField.setEnabled(b);
        searchLabel.setEnabled(b);
        componentList.setEnabled(b);
        jikkoButton.setEnabled(b);
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// 何もしない
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// 何もしない
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jikkoButton){
			System.out.println(jikkoName);
		}

	}


}