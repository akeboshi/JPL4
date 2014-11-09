package JPL.ch01.ex01_15;

class SimpleLookup{
	private String[] names;
	private Object[] values;
	private final int size;
	private int num=0;	

	public static void main(String[] args){
		SimpleLookup foo = new SimpleLookup(100);
		
		foo.add("1", "a");
		foo.add("2", "b");
		foo.add("3", "c");

		System.out.println(foo.find("1"));
		
		foo.remove("2");
			
		if(foo.find("2")!=null){
			System.out.println(foo.find("2"));
		}
	}

	SimpleLookup(int size){
		this.names =new String[size];
		this.values = new Object[size];
		this.size = size;
		names[0] = null;
		values[0] = null;

	}
	
	public Object find (String name) {
		for ( int i = 0; i < names.length ; i++) {
			if ( names[i]!=null && names[i].equals(name))
				return values[i];
		}
		return null;
	}

	public void add (String name, Object value)  {
		for ( int i = 0 ; i < names.length ; i++){
			if( names[i] == null){
				names[i] = name;
				values[i] = value;
				return;
			}
		}
		System.out.println("これ以上登録できません");
	}

	public void remove (String name) {
		int flag = 0;
		for ( int i = 0; i < names.length; i++){
			if( names[i].equals(name)){
				names[i] = null;
				values[i] = null;
				return;
			}
		}
		System.out.println("" + name + "は存在しません");
			
	}

}
