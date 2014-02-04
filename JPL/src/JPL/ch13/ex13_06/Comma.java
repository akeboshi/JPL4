package JPL.ch13.ex13_06;


class Comma{
	public String addComma(String target, int size){
		String result = "";
		int keta = target.length();
		if(keta == 0)return "";
		if(size <= 0)return target;
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