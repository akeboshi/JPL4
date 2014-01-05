package JPL.ch07.ex07_02;

class ConfirmData{
	byte byteData;
	short shortData;
	int intData;
	long longData;
	float floatData;
	double doubleData;

	public static void main(String[] args) {
		ConfirmData Data = new ConfirmData();
		Data.byteData = Byte.MAX_VALUE;
		System.out.println("byte <= byte : " + Data.byteData);
		//Data.byteData = Short.MAX_VALUE;	error
		Data.shortData = Byte.MAX_VALUE;
		System.out.println("short <= byte: " + Data.shortData);
		Data.shortData = Short.MAX_VALUE;
		System.out.println("short <= short: " + Data.shortData);
		//Data.shortData = Integer.MAX_VALUE;	error
		Data.intData = Byte.MAX_VALUE;
		System.out.println("int: " + Data.intData);
		Data.intData = Short.MAX_VALUE;
		System.out.println("int: " + Data.intData);
		Data.intData = Integer.MAX_VALUE;
		System.out.println("int: " + Data.intData);
		//Data.intData = Long.MAX_VALUE;	error
		//Data.intData = Float.MAX_VALUE;	error
		Data.longData = Byte.MAX_VALUE;
		System.out.println("long: " + Data.longData);
		Data.longData = Short.MAX_VALUE;
		System.out.println("long: " + Data.longData);
		Data.longData = Integer.MAX_VALUE;
		System.out.println("long: " + Data.longData);
		Data.longData = Long.MAX_VALUE;
		System.out.println("long: " + Data.longData);
		//Data.longData = Float.MAX_VALUE;	error
		Data.floatData = Byte.MAX_VALUE;
		System.out.println("float: " + Data.floatData);
		Data.floatData = Short.MAX_VALUE;
		System.out.println("float: " + Data.floatData);
		Data.floatData = Integer.MAX_VALUE;
		System.out.println("float: " + Data.floatData);
		Data.floatData = Long.MAX_VALUE;
		System.out.println("float: " + Data.floatData);
		Data.floatData = Float.MAX_VALUE;
		System.out.println("float: " + Data.floatData);
		//Data.floatData = Double.MAX_VALUE;	error
		Data.doubleData = Byte.MAX_VALUE;
		System.out.println("double: " + Data.doubleData);
		Data.doubleData = Short.MAX_VALUE;
		System.out.println("double: " + Data.doubleData);
		Data.doubleData = Integer.MAX_VALUE;
		System.out.println("double: " + Data.doubleData);
		Data.doubleData = Long.MAX_VALUE;
		System.out.println("double: " + Data.doubleData);
		Data.doubleData = Float.MAX_VALUE;
		System.out.println("double: " + Data.doubleData);
		Data.doubleData = Double.MAX_VALUE;
		System.out.println("double: " + Data.doubleData);

	}

}