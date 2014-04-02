package Interpret;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

class SuggestFieldPanel extends SuggestPanel {

	SuggestFieldPanel(String panelName, CreatedMembers createdMembers,
			Interpret interpret) {
		super(panelName + "を変更する", createdMembers, interpret);
	}

	@Override
	void updateList(Class<?> cls) {
		Map<String, Field> fields = new TreeMap<String, Field>();
		for (Field f : cls.getDeclaredFields()) {
			String fieldName = f.toString();
			fields.put(fieldName, f);
		}
		createdMembers.setFields(fields);

		componentList.removeAll();
		for (String fieldKey : createdMembers.getFields().keySet()) {
			componentList.add(fieldKey);
		}

	}

	@Override
	void setMembersDialog() {
		this.membersDialog = new FieldDialog(interpret,
				panelNameLabel.getText(), createdMembers);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getComponent() == searchTextField) {
			componentList.removeAll();
			for (String item : createdMembers.getFields().keySet()) {
				if (item.indexOf(searchTextField.getText()) != -1)
					componentList.add(item);
			}
		}
	}

	@Override
	void setSelectedItem() {
		createdMembers.setSelectedField(createdMembers.getFields().get(
				componentList.getSelectedItem()));

	}

}