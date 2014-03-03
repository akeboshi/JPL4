package Interpret;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.Field;

class ChangeFieldDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private TextField inputTextField = new TextField();
	private String inputedText = null;
	private Object obj;
	private Field field;

	public ChangeFieldDialog(Frame owner, String dialogName, Object obj,
			Field field) {
		super(owner);
		this.obj = obj;
		this.field = field;

		setSize(400, 200);
		setResizable(false);
		setTitle(dialogName);
		setLayout(new GridLayout(5, 1));

		add(inputTextField);

		Button okButton = new Button("ok");
		okButton.setPreferredSize(new Dimension(200, 20));
		okButton.addActionListener(this);
		add(okButton);

		Button closeButton = new Button("閉じる");
		closeButton.setPreferredSize(new Dimension(200, 20));
		closeButton.addActionListener(this);
		add(closeButton);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				setVisible(false);
			}
		});
	}

	public static Object createObjFromString(String input,Class<?> type){
		// 基本データ型

				if (type.equals(Boolean.class) || type.equals(boolean.class)
						|| type.equals(Boolean[].class) || type.equals(boolean[].class)
						|| type.equals(Boolean[][].class)
						|| type.equals(boolean[][].class)) {
					return Boolean.valueOf(input);

				} else if (type.equals(Byte.class) || type.equals(byte.class)
						|| type.equals(Byte[].class) || type.equals(byte[].class)
						|| type.equals(Byte[][].class) || type.equals(byte[][].class)) {
					return Byte.valueOf(input);

				} else if (type.equals(Character.class) || type.equals(char.class)
						|| type.equals(Character[].class) || type.equals(char[].class)
						|| type.equals(Character[][].class)
						|| type.equals(char[][].class)) {
					/*
					 * char型未定義
					 */

				} else if (type.equals(Short.class) || type.equals(short.class)
						|| type.equals(Short[].class) || type.equals(short[].class)
						|| type.equals(Short[][].class) || type.equals(short[][].class)) {
					return Short.valueOf(input);

				} else if (type.equals(Integer.class) || type.equals(int.class)
						|| type.equals(Integer[].class) || type.equals(int[].class)
						|| type.equals(Integer[][].class) || type.equals(int[][].class)) {
					return Integer.valueOf(input);
				} else if (type.equals(Long.class) || type.equals(long.class)
						|| type.equals(Long[].class) || type.equals(long[].class)
						|| type.equals(Long[][].class) || type.equals(long[][].class)) {
					return Long.valueOf(input);

				} else if (type.equals(Double.class) || type.equals(double.class)
						|| type.equals(Double[].class) || type.equals(double[].class)
						|| type.equals(Double[][].class) || type.equals(double[].class)) {
					return Double.valueOf(input);

				} else if (type.equals(Float.class) || type.equals(float.class)
						|| type.equals(Float[].class) || type.equals(float[].class)
						|| type.equals(Float[][].class) || type.equals(float[][].class)) {
					return Float.valueOf(input);

				} else if (type.equals(String.class) || type.equals(String[].class)
						|| type.equals(String[][].class)) {
					return input;

				} else {
					/*
					 * 未定義
					 */
					return null;
				}
				return null;
	}
	
	public void editField() {
		boolean accessFlag = field.isAccessible();
		field.setAccessible(true);
		Class<?> type = field.getType();
		Object value = ChangeFieldDialog.createObjFromString(inputedText, type);
		

		try {
			field.set(obj, value);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(field.getName() + " set "
					+ field.get(obj).toString());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		field.setAccessible(accessFlag);
	}

	public void viewProperty() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ok") {
			inputedText = inputTextField.getText();
			editField();
		} else if (e.getActionCommand() == "閉じる") {
			setVisible(false);
		}

	}
}