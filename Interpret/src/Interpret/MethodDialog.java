package Interpret;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class MethodDialog extends MembersDialog {

	public MethodDialog(Interpret owner, String dialogName,
			CreatedMembers createdMembers) {
		super(owner, createdMembers, dialogName);
	}

	@Override
	void doReflectMember() {
		Object selectedObj = createdMembers.getSelectedClass();
		Method method = createdMembers.getSelectedMethods();
		Boolean flagAcc = method.isAccessible();
		method.setAccessible(true);
		if (method.getReturnType() == void.class) {
			try {
				method.invoke(selectedObj, paramObjs);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
			System.out.println(method.getName() + " return void");
		} else {
			Object returnObj = null;
			try {
				returnObj = method.invoke(selectedObj, paramObjs);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
			System.out.println(method.getName() + " " + "return "
					+ returnObj.toString());
		}
		method.setAccessible(flagAcc);
	}

	@Override
	protected void setParams() {
		for (Class<?> cls : createdMembers.getSelectedMethods()
				.getParameterTypes()) {
			paramTypes.add(cls);
		}
		paramSize = paramTypes.size();
	}

}