package JPL.ch16.ex16_04;

import java.lang.annotation.Annotation;


class PrintAnnotations{
	public static void main(String[] args) {
		PrintAnnotations PA = new PrintAnnotations();
		PA.print(Object.class);
	}
	
	public void print(Class<?> c){
		Annotation[] annotations = c.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation.getClass().getCanonicalName());
		}
	}
}