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
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

class ArrayDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final String SET_PARAM = "Set Param";
	private TextField inputTextField = new TextField();
	private Object[] params;
	private Map<String, Object> clazz;
	private Button okButton = new Button("ok");
	private Button setButton = new Button(SET_PARAM);
	private Interpret owner;
	private Class<?> type;
	private Integer arrayLength = 0;

	public ArrayDialog(Interpret owner, String dialogName,
			Class<?> type, Map clazz) {
		super(owner);
		this.owner = owner;
		this.type = type;
		this.clazz = clazz;


		setSize(400, 200);
		setResizable(false);
		setTitle(dialogName);
		setLayout(new GridLayout(5, 1));
		add(inputTextField);

		setButton.setPreferredSize(new Dimension(200, 20));
		setButton.addActionListener(this);
		add(setButton);

		okButton.setPreferredSize(new Dimension(200, 20));
		okButton.addActionListener(this);
		add(okButton);

		if (arrayLength == 0) {
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

	public void createArray() {
		owner.addInstanceA(Array.newInstance(type, arrayLength), arrayLength);
	}

	public void viewProperty() {
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "ok") {
			createArray();
			setVisible(false);
		} else if (e.getActionCommand() == SET_PARAM) {
			arrayLength = Integer.valueOf(inputTextField.getText());
			if (arrayLength <= 0) {
				okButton.setEnabled(false);
			} else {
				okButton.setEnabled(true);
			}
		} else if (e.getActionCommand() == "閉じる") {
			setVisible(false);
		}

	}
}