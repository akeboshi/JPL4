package Interpret;

import java.lang.reflect.Array;
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
		Class<?> cls = selectedObj.getClass();
		boolean accessFlag = field.isAccessible();

		field.setAccessible(true);
		if (cls.isArray()
				&& Array.get(selectedObj,
						createdMembers.getSelectedArrayNumber()) != null) {
			selectedObj = Array.get(selectedObj,
					createdMembers.getSelectedArrayNumber());
		}
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
		} finally {
			field.setAccessible(accessFlag);
			owner.updateAllPanel();
		}
	}

	@Override
	protected void setParams() {
		paramTypes.add(createdMembers.getSelectedField().getType());
		paramSize = 1;
	}

}