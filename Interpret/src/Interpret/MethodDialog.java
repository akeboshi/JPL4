package Interpret;

import java.awt.Button;
import java.awt.Choice;
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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class MethodDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String SET_PARAM_STR = "Set Param from text";
	private static final String SET_PARAM_CHOICE = "Set Param from choice";
	private TextField inputTextField = new TextField();
	private String inputedText = null;
	private Object obj;
	private Object[] params;
	private Method method;
	private Integer methodObjNum;

	private Choice methodParamChoice = new Choice();
	private Choice instanceChoice = new Choice();

	private java.lang.reflect.Type methodReturnType;
	private java.lang.reflect.Type[] methodPramTypes;
	private java.lang.reflect.Type[] methodExcepTypes;
	private Map<String, Object> classMap;
	private Map<String,Object> bufMap = new HashMap<String, Object>();
	private Button okButton = new Button("ok");
	private Button setButton = new Button(SET_PARAM_STR);
	private Button choiceSetButton = new Button(SET_PARAM_CHOICE);

	public MethodDialog(Interpret owner, String dialogName, Object obj,
			Method method, Map<String, Object> classMap) {
		super(owner);
		this.obj = obj;
		this.method = method;
		methodReturnType = method.getGenericReturnType();
		methodPramTypes = method.getGenericParameterTypes();
		methodExcepTypes = method.getGenericExceptionTypes();
		params = new Object[method.getParameterAnnotations().length];
		this.classMap = classMap;

		for (int i = 0; i < method.getParameterTypes().length; i++) {
			methodParamChoice.add(i + " : " + methodPramTypes[i].toString());
		}

		setSize(400, 200);
		setResizable(false);
		setTitle(dialogName);
		setLayout(new GridLayout(7, 1));
		add(inputTextField);
		
		int i = 0;
		for (String insStr : classMap.keySet()) {
			bufMap.put(i + " : " + classMap.get(insStr).getClass().getName(), classMap.get(insStr));
			instanceChoice.add(i + " : " + classMap.get(insStr).getClass().getName());
			i++;
		}
		
		add(instanceChoice);

		add(methodParamChoice);
		setButton.setPreferredSize(new Dimension(200, 20));
		setButton.addActionListener(this);
		add(setButton);

		choiceSetButton.setPreferredSize(new Dimension(200, 20));
		choiceSetButton.addActionListener(this);
		add(choiceSetButton);

		okButton.setPreferredSize(new Dimension(200, 20));
		okButton.addActionListener(this);
		add(okButton);

		if (methodPramTypes.length == 0) {
			inputTextField.setEnabled(false);
			methodParamChoice.setEnabled(false);
			setButton.setEnabled(false);
		} else {
			okButton.setEnabled(false);
		}

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

	public void doMethod() {
		Boolean flagAcc = method.isAccessible();
		method.setAccessible(true);
		System.out.println(methodReturnType.toString());
		if (methodReturnType == void.class) {
			try {
				method.invoke(obj, params);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
			System.out.println(method.getName() + " return void");
		} else {
			Object returnObj = null;
			try {
				returnObj = method.invoke(obj, params);
			} catch (IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
			System.out.println(method.getName() + " " + "return "
					+ returnObj.toString());
		}
		method.setAccessible(flagAcc);
	}

	public void viewProperty() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ok") {
			inputedText = inputTextField.getText();
			doMethod();
		} else if (e.getActionCommand() == SET_PARAM_STR) {
			params[methodParamChoice.getSelectedIndex()] = ChangeFieldDialog
					.createObjFromString(inputTextField.getText(),
							(Class<?>) methodPramTypes[methodParamChoice
									.getSelectedIndex()]);

			System.out.printf("(");
			for (Object obj : params) {
				if (obj == null)
					System.out.printf("null,");
				else
					System.out.printf(obj.toString() + ",");
			}
			System.out.println(")");

			Boolean okVisibleFlag = true;
			for (int i = 0; i < methodPramTypes.length; i++) {
				if (params[i] == null)
					okVisibleFlag = false;
			}
			okButton.setEnabled(okVisibleFlag);
		} else if (e.getActionCommand() == SET_PARAM_CHOICE) {
			System.out.println(instanceChoice.getSelectedItem());
			params[methodParamChoice.getSelectedIndex()] = bufMap.get(instanceChoice.getSelectedItem());

			System.out.printf("(");
			for (Object obj : params) {
				if (obj == null)
					System.out.printf("null,");
				else
					System.out.printf(obj.toString() + ",");
			}
			System.out.println(")");

			Boolean okVisibleFlag = true;
			for (int i = 0; i < methodPramTypes.length; i++) {
				if (params[i] == null)
					okVisibleFlag = false;
			}
			okButton.setEnabled(okVisibleFlag);
		} else if (e.getActionCommand() == "閉じる") {
			setVisible(false);
		}

	}
}