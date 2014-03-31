package Interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;

class ConstructorDialog extends MembersDialog {
	private static final long serialVersionUID = 1L;

	public ConstructorDialog(Interpret owner, String dialogName,
			CreatedMembers createdMembers) {
		super(owner, createdMembers, dialogName);
	}

	@Override
	void setParams() {
		for (Class<?> cls : createdMembers.getSelectedConstructors()
				.getParameterTypes()) {
			 paramTypes.add(cls);
		}
		paramSize = paramTypes.size();
	}

	public void createInstance() {
		try {
			Object newObject = createdMembers.getSelectedConstructors().newInstance();
			createdMembers.addClassMap(createdMembers.getClassMap().size() + ": " + newObject.toString(), newObject);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// try {
		// if(!array)
		// owner.addInstance(constructor.newInstance(params));
		// else
		// owner.addArrayInstance(constructor.newInstance(params));
		// } catch (InstantiationException | IllegalAccessException
		// | IllegalArgumentException | InvocationTargetException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	public void viewProperty() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jikkoButton){
			createInstance();
			System.out.println("a");
		}
	}

	@Override
	void doReflectMember() {
		// TODO 自動生成されたメソッド・スタブ

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