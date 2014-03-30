package Interpret;

import java.awt.Dialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

abstract class MembersDialog extends Dialog{
	protected CreatedMembers createdMembers;
	private String dialogName;

	public MembersDialog(Interpret owner, CreatedMembers createdMembers, String dialogName) {
		super(owner);
		this.dialogName = dialogName;
		this.createdMembers = createdMembers;
		setSize(400, 200);
		setResizable(false);
		setTitle(dialogName);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent close) {
				setVisible(false);
			}
		});
	}

	abstract void doReflectMember();

	/**
	 * String inputからClass typeに対応する基本データ型を返す
	 * @param input
	 * @param type
	 * @return 基本データ型、typeが基本データ型以外の物はnull
	 */
	protected Object createObjFromString(String input,Class<?> type){
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
					/* TODO
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
}