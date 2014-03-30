package Interpret;

import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.TreeMap;

class SuggesterConstrucotrPanel extends SuggestPanel{

	SuggesterConstrucotrPanel(String panelName, CreatedMembers createdMembers, Interpret interpret) {
		super(panelName + "を実行する", createdMembers, interpret);
		searchTextField.addKeyListener(this);
		componentList.addItemListener(this);
	}



	@Override
	void updateList(Class<?> cls) {
			Map<String, Constructor<?>> members = new TreeMap<String, Constructor<?>>();
			componentList.removeAll();
			for (Constructor<?> con : cls.getDeclaredConstructors()) {
				members.put(con.toGenericString(), con);
				componentList.add(con.toGenericString());
			}
			createdMembers.setConstructors(members);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// 何もしない

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// 何もしない

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}



	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getComponent() == searchTextField){
			componentList.removeAll();
			for (String item : createdMembers.getConstructors().keySet()) {
				System.out.println(item + " " + searchTextField.getText());
				if (item.indexOf(searchTextField.getText()) != -1)
					componentList.add(item);
			}
		}
	}

	@Override
	void setMembersDialog() {
		this.membersDialog = new ConstructorDialog(interpret, panelNameLabel.getText(), createdMembers);
	}
}