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
import java.util.Map;

class ConstructorDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String SET_PARAM = "Set Param";
	private TextField inputTextField = new TextField();
	private Object[] params;
	private Constructor<?> constructor;
	private Choice constrParamChoice = new Choice();
	private java.lang.reflect.Type[] constrPramTypes;
	private java.lang.reflect.Type[] constrExcepTypes;
	private Map<String, Object> clazz;
	private Button okButton = new Button("ok");
	private Button setButton = new Button(SET_PARAM);
	private Interpret owner;

	public ConstructorDialog(Interpret owner, String dialogName,
			Constructor<?> constructor, Map clazz) {
		super(owner);
		this.owner = owner;
		this.constructor = constructor;
		constrPramTypes = constructor.getGenericParameterTypes();
		constrExcepTypes = constructor.getGenericExceptionTypes();
		params = new Object[constructor.getParameterAnnotations().length];
		this.clazz = clazz;

		for (int i = 0; i < constructor.getParameterTypes().length; i++) {
			constrParamChoice.add(constrPramTypes[i].toString());
		}

		setSize(400, 200);
		setResizable(false);
		setTitle(dialogName);
		setLayout(new GridLayout(5, 1));
		add(inputTextField);

		add(constrParamChoice);
		setButton.setPreferredSize(new Dimension(200, 20));
		setButton.addActionListener(this);
		add(setButton);

		okButton.setPreferredSize(new Dimension(200, 20));
		okButton.addActionListener(this);
		add(okButton);

		if (constrPramTypes.length == 0) {
			inputTextField.setEnabled(false);
			constrParamChoice.setEnabled(false);
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

	public void createInstance() {
		try {
			owner.addInstance(constructor.newInstance(params));
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("return void");
	}

	public void viewProperty() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ok") {
			createInstance();
			setVisible(false);
		} else if (e.getActionCommand() == SET_PARAM) {
			params[constrParamChoice.getSelectedIndex()] = ChangeFieldDialog
					.createObjFromString(inputTextField.getText(),
							(Class<?>) constrPramTypes[constrParamChoice
									.getSelectedIndex()]);
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