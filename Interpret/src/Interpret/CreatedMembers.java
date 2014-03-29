package Interpret;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

class CreatedMembers{
	/* TODO
	 * selectedClassとかも？？
	 */
	private Map<String, Field> fields = new TreeMap<String, Field>();
	private Map<String, Method> methods = new TreeMap<String, Method>();
	private Map<String, Constructor<?>> constructors = new TreeMap<String, Constructor<?>>();
	private Map<String, Object> classMap = new TreeMap<String, Object>();

	public int sizeClassMap(){
		return classMap.size();
	}

	public Map<String, Object> addClassMap(String key, Object value){
		classMap.put(key, value);
		return classMap;
	}

	public Map<String, Field> addFields(String key,Field value){
		fields.put(key, value);
		return fields;
	}

	public Map<String, Method> addMethods(String key, Method value){
		methods.put(key, value);
		return methods;
	}

	public Map<String, Constructor<?>> addConstructors(String key, Constructor<?> value){
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

}