package Interpret;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

class CreatedMembers {
	private Map<String, Field> fields = new TreeMap<String, Field>();
	private Map<String, Method> methods = new TreeMap<String, Method>();
	private Map<String, Constructor<?>> constructors = new TreeMap<String, Constructor<?>>();
	private Map<String, Object> classMap = new TreeMap<String, Object>();

	private Field selectedField = null;
	private Method selectedMethods = null;
	private Constructor<?> selectedConstructors = null;
	private Object selectedClass = null;

	public int sizeClassMap() {
		return classMap.size();
	}

	public Map<String, Object> addClassMap(String key, Object value) {
		classMap.put(key, value);
		return classMap;
	}

	public Map<String, Field> addFields(String key, Field value) {
		fields.put(key, value);
		return fields;
	}

	public Map<String, Method> addMethods(String key, Method value) {
		methods.put(key, value);
		return methods;
	}

	public Map<String, Constructor<?>> addConstructors(String key,
			Constructor<?> value) {
		constructors.put(key, value);
		return constructors;
	}

	public Map<String, Field> getFields() {
		return fields;
	}

	public void setFields(Map<String, Field> fields) {
		this.fields = fields;
	}

	public Map<String, Method> getMethods() {
		return methods;
	}

	public void setMethods(Map<String, Method> methods) {
		this.methods = methods;
	}

	public Map<String, Constructor<?>> getConstructors() {
		return constructors;
	}

	public void setConstructors(Map<String, Constructor<?>> constructors) {
		this.constructors = constructors;
	}

	public Map<String, Object> getClassMap() {
		return classMap;
	}

	public void setClassMap(Map<String, Object> classMap) {
		this.classMap = classMap;
	}

	public Field getSelectedField() {
		return selectedField;
	}

	public void setSelectedField(Field selectedField) {
		this.selectedField = selectedField;
	}

	public Method getSelectedMethods() {
		return selectedMethods;
	}

	public void setSelectedMethods(Method selectedMethods) {
		this.selectedMethods = selectedMethods;
	}

	public Constructor<?> getSelectedConstructors() {
		return selectedConstructors;
	}

	public void setSelectedConstructors(Constructor<?> selectedConstructors) {
		this.selectedConstructors = selectedConstructors;
	}

	public Object getSelectedClass() {
		return selectedClass;
	}

	public void setSelectedClass(Object selectedClass) {
		this.selectedClass = selectedClass;
	}

}