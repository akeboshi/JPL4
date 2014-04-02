package Interpret;

import java.lang.reflect.Field;

class FieldDialog extends MembersDialog {

	public FieldDialog(Interpret owner, String dialogName,
			CreatedMembers createdMembers) {
		super(owner, createdMembers, dialogName);
	}

	@Override
	void doReflectMember() {
		Field field = createdMembers.getSelectedField();
		Object selectedObj = createdMembers.getSelectedClass();
		boolean accessFlag = field.isAccessible();

		field.setAccessible(true);
		try {
			field.set(selectedObj, paramObjs[0]);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(field.getName() + " set "
					+ field.get(selectedObj).toString());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		field.setAccessible(accessFlag);
	}

	@Override
	protected void setParams() {
		paramTypes.add(createdMembers.getSelectedField().getType());
		paramSize = 1;
	}

}