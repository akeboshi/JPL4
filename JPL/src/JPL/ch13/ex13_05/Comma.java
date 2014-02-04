package JPL.ch13.ex13_05;

class Comma{
	 public String addComma(String target){
		String result = "";
		int size = 3;
		int keta = target.length();
		if(keta == 0)return "";

		int start = 0;
		int end = keta%size != 0 ? keta% size: size;

		while(end <=keta){
			result += target.substring(start,end) + ",";
			start = end ;
			end += size;
		}
		return result.substring(0,result.length()-1);
	}
}