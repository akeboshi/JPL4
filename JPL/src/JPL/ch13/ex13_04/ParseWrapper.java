package JPL.ch13.ex13_04;

import java.util.ArrayList;
import java.util.List;

class ParseWrapper{
	public static void main(String[] args) {
		ArrayList<Object> obj = ParseWrapper.parseWrapper("Byte 3¥nShort 100¥nieondakj¥nInteger 100000¥nCharacter a");
		for (Object object : obj) {
			System.out.println(object);
		}
	}
	
	static public ArrayList<Object> parseWrapper(String target){
		String[] splitByLines = target.split("¥n");
		ArrayList<Object> saveWrappers = new ArrayList<Object>();
		for (String splitByLine : splitByLines) {
			String[] splitBySpace = splitByLine.split(" ");
			if(splitBySpace[0].equals("Byte")){
				saveWrappers.add(Byte.valueOf(splitBySpace[1]));
			}else if(splitBySpace[0].equals("Short")){
				saveWrappers.add(Short.valueOf(splitBySpace[1]));
			}else if(splitBySpace[0].equals("Integer")){
				saveWrappers.add(Integer.valueOf(splitBySpace[1]));
			}else if(splitBySpace[0].equals("Long")){
				saveWrappers.add(Long.valueOf(splitBySpace[1]));
			}else if(splitBySpace[0].equals("Float")){
				saveWrappers.add(Float.valueOf(splitBySpace[1]));
			}else if(splitBySpace[0].equals("Double")){
				saveWrappers.add(Double.valueOf(splitBySpace[1]));
			}else if(splitBySpace[0].equals("Boolean")){
				saveWrappers.add(Boolean.valueOf(splitBySpace[1]));
			}else if(splitBySpace[0].equals("Character")){
				saveWrappers.add(splitBySpace[1].charAt(0));
			}else{
				
			}
		}
		return saveWrappers;
	}
}