package Interpret;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ConstructorDialog extends MembersDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	public ConstructorDialog(Interpret owner, String dialogName,
			CreatedMembers createdMembers) {
		super(owner, createdMembers, dialogName);
	}

	public void createInstance() {
//		try {
//			if(!array)
//			owner.addInstance(constructor.newInstance(params));
//			else
//			owner.addArrayInstance(constructor.newInstance(params));
//		} catch (InstantiationException | IllegalAccessException
//				| IllegalArgumentException | InvocationTargetException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void viewProperty() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	void doReflectMember() {
		// TODO 自動生成されたメソッド・スタブ

	}
}