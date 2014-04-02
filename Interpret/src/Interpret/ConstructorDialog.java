package Interpret;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

class ConstructorDialog extends MembersDialog {
	private static final long serialVersionUID = 1L;

	public ConstructorDialog(Interpret owner, String dialogName,
			CreatedMembers createdMembers) {
		super(owner, createdMembers, dialogName);
	}

	public void doReflectMember() {
		try {
			Object newObject = createdMembers.getSelectedConstructors()
					.newInstance(paramObjs);
			Object selectedClass = createdMembers.getSelectedClass();
			if (selectedClass != null && selectedClass.getClass().isArray()) {
				Array.set(selectedClass,
						createdMembers.getSelectedArrayNumber(), newObject);
				owner.updateMethodAndFieldPanel(true);
			} else {
				createdMembers.addClassMap(createdMembers.getClassMap().size()
						+ ": " + newObject.getClass().getCanonicalName(),
						newObject);
			}
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		owner.refreshInstanceList();
	}

	@Override
	protected void setParams() {
		for (Class<?> cls : createdMembers.getSelectedConstructors()
				.getParameterTypes()) {
			paramTypes.add(cls);
		}
		paramSize = paramTypes.size();

	}
}