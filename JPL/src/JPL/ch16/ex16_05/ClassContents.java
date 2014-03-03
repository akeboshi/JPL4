package JPL.ch16.ex16_05;

import java.awt.print.Printable;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class ClassContents {
        public static void main(String[] args) {
                try {
                        Class<?> c = Class.forName(args[0]);
                        System.out.println(c);
                      printMembers(c.getDeclaredFields());
                       printMembers(c.getDeclaredConstructors());
                        printMembers(c.getDeclaredMethods());
                        printMembers(c.getMethods(), c);
                } catch (ClassNotFoundException e) {
                        System.out.println("unknown class: " + args[0]);
                }
        }
       
        private static void printMembers(Member[] mems) {
                printMembers(mems,null);
        }
       
        private static void printMembers(Member[] mems, Class<?> c) {
                for (Member m : mems) {
                        if(m.getDeclaringClass() == Object.class)
                                continue;
                        if(c != null && c.equals(m.getDeclaringClass()))
                                continue;

                        String decl = m.toString();
                        System.out.print(" ");
                        System.out.println(strip(decl, "java.lang."));
                        printAnnotation(m);
                }
        }
        
        public static void printAnnotation(Member c){
        	Annotation[] annotations;
        	if(c.getClass().isAssignableFrom(Method.class))
        		annotations = ((Method)c).getAnnotations();
        	else if (c.getClass().isAssignableFrom(Constructor.class))
        		annotations = ((Constructor<?>)c).getAnnotations();
        	else if (c.getClass().isAssignableFrom(Field.class))
        		annotations = ((Field)c).getAnnotations();
        	else
        		return;
    		for (Annotation annotation : annotations) {
    			System.out.printf(" annotation ");
    			System.out.println(strip(annotation.getClass().getCanonicalName(),"java.lang."));
    		}
    	}
        
        private static String strip(String str, String rem) {
        		return str.replaceAll(rem, "");
        }
}

