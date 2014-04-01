package Interpret;

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
			createdMembers
					.addClassMap(createdMembers.getClassMap().size() + ": "
							+ newObject.getClass().getCanonicalName(),
							newObject);
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