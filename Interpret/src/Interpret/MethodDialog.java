package Interpret;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

class MethodDialog extends MembersDialog {

	public MethodDialog(Interpret owner, String dialogName,
			CreatedMembers createdMembers) {
		super(owner, createdMembers, dialogName);
	}

	@Override
	void doReflectMember() {
		Object selectedObj = createdMembers.getSelectedClass();
		Class<?> cls = selectedObj.getClass();
		Method method = createdMembers.getSelectedMethods();
		Boolean flagAcc = method.isAccessible();
		method.setAccessible(true);
		if (cls.isArray() && Array.get(selectedObj, createdMembers.getSelectedArrayNumber()) != null) {
			selectedObj =Array.get(selectedObj, createdMembers.getSelectedArrayNumber());
		}
		if (method.getReturnType() == void.class) {
			try {
				System.out.println("paramObj = " + (Arrays.deepToString(paramObjs)));
				System.out.println(selectedObj.getClass() + " " +selectedObj.toString());
				System.out.println("method = " + method.toString());
				method.invoke(selectedObj, paramObjs);
			} catch (InvocationTargetException e) {
				e.getCause().printStackTrace();
			} catch (IllegalAccessException | IllegalArgumentException e) {
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
		owner.updateAllPanel();
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