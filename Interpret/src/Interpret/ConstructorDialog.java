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
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class ConstructorDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String SET_PARAM_STR = "Set Param from text";
	private static final String SET_PARAM_CHOICE = "Set Param from choice";
	private TextField inputTextField = new TextField();
	private Object[] params;
	private boolean array;
	private Constructor<?> constructor;
	private Choice constrParamChoice = new Choice();
	private Choice instanceChoice = new Choice();
	private java.lang.reflect.Type[] constrPramTypes;
	private java.lang.reflect.Type[] constrExcepTypes;
	private Map<String, Object> clazz;
	private Button okButton = new Button("ok");
	private Button setButton = new Button(SET_PARAM_STR);
	private Button choiceSetButton = new Button(SET_PARAM_CHOICE);
	private Interpret owner;
	private Map<String, Object> classMap = new HashMap<String, Object>();


	public ConstructorDialog(Interpret owner, String dialogName,
			Constructor<?> constructor, Map<String, Object> classMap){
		this(owner, dialogName, constructor, classMap, false);
	}
	
	public ConstructorDialog(Interpret owner, String dialogName,
			Constructor<?> constructor, Map<String, Object> classMap, boolean array) {
		super(owner);
		this.array = array;
		this.owner = owner;
		this.constructor = constructor;
		constrPramTypes = constructor.getGenericParameterTypes();
		constrExcepTypes = constructor.getGenericExceptionTypes();
		params = new Object[constructor.getParameterAnnotations().length];

		for (int i = 0; i < constructor.getParameterTypes().length; i++) {
			constrParamChoice.add(i + " : " + constrPramTypes[i].toString());
		}

		setSize(400, 200);
		setResizable(false);
		setTitle(dialogName);
		setLayout(new GridLayout(7, 1));
		add(inputTextField);
		
		int i = 0;
		for (String insStr : classMap.keySet()) {
			this.classMap.put(i + " : " + classMap.get(insStr).getClass().getName(), classMap.get(insStr));
			instanceChoice.add(i + " : " + classMap.get(insStr).getClass().getName());
			i++;
		}

		add(instanceChoice);
		
		add(constrParamChoice);
		setButton.setPreferredSize(new Dimension(200, 20));
		setButton.addActionListener(this);
		add(setButton);
		
		choiceSetButton.setPreferredSize(new Dimension(200, 20));
		choiceSetButton.addActionListener(this);
		add(choiceSetButton);

		okButton.setPreferredSize(new Dimension(200, 20));
		okButton.addActionListener(this);
		add(okButton);

		if (constrPramTypes.length == 0) {
			inputTextField.setEnabled(false);
			constrParamChoice.setEnabled(false);
			setButton.setEnabled(false);
			choiceSetButton.setEnabled(false);
			instanceChoice.setEnabled(false);
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

	public void createInstance() {
		try {
			if(!array)
			owner.addInstance(constructor.newInstance(params));
			else
			owner.addArrayInstance(constructor.newInstance(params));
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewProperty() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ok") {
			createInstance();
			setVisible(false);
			System.out.println("instance is created");
		} else if (e.getActionCommand() == SET_PARAM_STR) {
			params[constrParamChoice.getSelectedIndex()] = ChangeFieldDialog
					.createObjFromString(inputTextField.getText(),
							(Class<?>) constrPramTypes[constrParamChoice
									.getSelectedIndex()]);
			
			System.out.printf("(");
			for (Object obj : params){
				if(obj == null) System.out.printf("null,");
				else System.out.printf(obj.toString() + ",");
			}
			System.out.println(")");
			
			Boolean okVisibleFlag = true;
			for (int i = 0; i < constrPramTypes.length; i++) {
				if (params[i] == null)
					okVisibleFlag = false;
			}
			okButton.setEnabled(okVisibleFlag);
		} else if (e.getActionCommand() == SET_PARAM_CHOICE) {
			System.out.println(instanceChoice.getSelectedItem());
			params[constrParamChoice.getSelectedIndex()] = classMap.get(instanceChoice.getSelectedItem());

			System.out.printf("(");
			for (Object obj : params) {
				if (obj == null)
					System.out.printf("null,");
				else
					System.out.printf(obj.toString() + ",");
			}
			System.out.println(")");

			Boolean okVisibleFlag = true;
			for (int i = 0; i < constrPramTypes.length; i++) {
				if (params[i] == null)
					okVisibleFlag = false;
			}
			okButton.setEnabled(okVisibleFlag);
		} else if (e.getActionCommand() == "閉じる") {
			setVisible(false);
		}

	}
}