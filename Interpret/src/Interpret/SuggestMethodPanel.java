package Interpret;

import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

class SuggestMethodPanel extends SuggestPanel {

	SuggestMethodPanel(String panelName, CreatedMembers createdMembers,
			Interpret interpret) {
		super(panelName, createdMembers, interpret);
	}

	@Override
	void updateList(Class<?> methodClass) {
		Map<String, Method> methodMap = new TreeMap<String, Method>();
		Object selectedObj = createdMembers.getSelectedClass();
		methodClass = selectedObj.getClass();

		componentList.removeAll();
		if (methodClass.isArray()
				&& Array.get(selectedObj,
						createdMembers.getSelectedArrayNumber()) == null) {

		} else {
			if(methodClass.isArray()){
				methodClass = methodClass.getComponentType();
				selectedObj = Array.get(selectedObj, createdMembers.getSelectedArrayNumber());
			}
			while (methodClass != null) {
				for (Method method : methodClass.getDeclaredMethods()) {
					String methodName = "";
					methodName += method.getReturnType().getCanonicalName()
							+ " ";
					methodName += method.getName() + "(";
					for (Class<?> s : method.getParameterTypes())
						methodName += s.getCanonicalName() + " ";
					methodName += ")";
					methodMap.put(methodName, method);
				}
				methodClass = methodClass.getSuperclass();
			}
			createdMembers.setMethods(methodMap);

			componentList.removeAll();
			for (String name : createdMembers.getMethods().keySet()) {
				componentList.add(name);
			}
		}
	}

	@Override
	void setMembersDialog() {
		this.membersDialog = new MethodDialog(interpret,
				panelNameLabel.getText(), createdMembers);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getComponent() == searchTextField) {
			componentList.removeAll();
			for (String item : createdMembers.getMethods().keySet()) {
				if (item.indexOf(searchTextField.getText()) != -1)
					componentList.add(item);
			}
		}
	}

	@Override
	void setSelectedItem() {
		createdMembers.setSelectedMethods(createdMembers.getMethods().get(
				componentList.getSelectedItem()));

	}

}