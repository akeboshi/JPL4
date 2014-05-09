package JPL.ch22.ex22_15;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class ReversePorandCase{

	public static Double calc(String str){
		Stack<Double> sta = new Stack<>();
		List<String> list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(str);
		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		double a;
		double b;
		for(String s: list){
			if(s.equals("+"))	{a = sta.pop();b = sta.pop();sta.push(b + a);}
			else if(s.equals("-"))	{a = sta.pop();b = sta.pop();sta.push(b - a);}
			else if(s.equals("*"))	{a = sta.pop();b = sta.pop();sta.push(b * a);}
			else if(s.equals("/"))	{a = sta.pop();b = sta.pop();sta.push(b / a);}
			else if(s.equals("%"))	{a = sta.pop();b = sta.pop();sta.push(b % a);}
			else if(s.equals("sin"))	sta.push(StrictMath.sin(sta.pop()));
			else if(s.equals("cos"))	sta.push(StrictMath.cos(sta.pop()));
			else if(s.equals("tan"))	sta.push(StrictMath.tan(sta.pop()));
			else if(s.equals("asin"))	sta.push(StrictMath.asin(sta.pop()));
			else if(s.equals("acons"))	sta.push(StrictMath.acos(sta.pop()));
			else if(s.equals("atan"))	sta.push(StrictMath.atan(sta.pop()));
			else if(s.equals("atan2"))	{a = sta.pop();b = sta.pop();sta.push(StrictMath.atan2(b, a));}
			else if(s.equals("toRadians"))	sta.push(StrictMath.toRadians(sta.pop()));
			else if(s.equals("toDegrees"))	sta.push(StrictMath.toDegrees(sta.pop()));
			else if(s.equals("exp"))	sta.push(StrictMath.exp(sta.pop()));
			else if(s.equals("sinh"))	sta.push(StrictMath.sinh(sta.pop()));
			else if(s.equals("cosh"))	sta.push(StrictMath.cosh(sta.pop()));
			else if(s.equals("tanh"))	sta.push(StrictMath.tanh(sta.pop()));
			else if(s.equals("pow"))	{a = sta.pop();b = sta.pop();sta.push(StrictMath.pow(b, a));}
			else if(s.equals("log"))	sta.push(StrictMath.log(sta.pop()));
			else if(s.equals("log10"))	sta.push(StrictMath.log10(sta.pop()));
			else if(s.equals("sqrt"))	sta.push(StrictMath.sqrt(sta.pop()));
			else if(s.equals("cbrt"))	sta.push(StrictMath.cbrt(sta.pop()));
			else if(s.equals("signum"))	sta.push(StrictMath.signum(sta.pop()));
			else if(s.equals("ceil"))	sta.push(StrictMath.ceil(sta.pop()));
			else if(s.equals("floor"))	sta.push(StrictMath.floor(sta.pop()));
			else if(s.equals("rint"))	sta.push(StrictMath.rint(sta.pop()));
			else if(s.equals("round"))	sta.push((double) StrictMath.round(sta.pop()));
			else if(s.equals("abs"))	sta.push(StrictMath.abs(sta.pop()));
			else if(s.equals("max"))	{a = sta.pop();b = sta.pop();sta.push(StrictMath.max(b, a));}
			else if(s.equals("min"))	{a = sta.pop();b = sta.pop();sta.push(StrictMath.min(b, a));}
			else if(s.equals("hypot"))	{a = sta.pop();b = sta.pop();sta.push(StrictMath.hypot(b, a));}
			else sta.push(Double.parseDouble(s));
		}
		return (Double)sta.pop();
	}
}