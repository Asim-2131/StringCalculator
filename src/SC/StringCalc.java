package SC;

import java.util.ArrayList;

public class StringCalc {
	public static int Add(String s) {
		if(s.isEmpty()) return 0;
		else if(s.length() == 1) return sToInt(s);
		else{
			
			if(s.startsWith("//")) {
				ArrayList<String>delimiters = new ArrayList<String>();
				String [] refString = s.split("\n");
				delimiters.add(refString[0].charAt(2)+"");
				String [] numbers = splitByDelimiters(refString[1],delimiters);
				for(int i=0;i<numbers.length;i++) System.out.println(numbers[i]);
				return additionOfString(numbers);
			}
			else {
				return separateCaseForCommaAndNewLineCombine(s);
			}
			
		}
	}

	private static int separateCaseForCommaAndNewLineCombine(String s) {
		String numbers [] = s.split(",|\n");
		return additionOfString(numbers);
	}

	public static String[] splitByDelimiters(String s,ArrayList<String>delimiters) {
		return s.split(combinationOfSplitingDelimiters(delimiters));
	}
	
	public static String combinationOfSplitingDelimiters(ArrayList<String>delimiters) {
		
		String ref="";
		for(int i=0;i<delimiters.size();i++) {
			if(i == delimiters.size() -1) {
				ref += splitFormForParticularPattern(delimiters.get(i));
			}
			else {
				ref += splitFormForParticularPattern(delimiters.get(i)) + "|";
			}
		}
		return ref;
	}
	public static String splitFormForParticularPattern(String s) {
		
		String ref = "";
		for(int i=0;i<s.length();i++) {
			ref += "\\" + s.charAt(i);
		}
		return ref;
		
	}
	public static int additionOfString(String numbers[]) {
		int val = 0;
		for(int i=0;i<numbers.length;i++) {
			val += (sToInt(numbers[i]));
		}
		return val;
	}
	
	public static int sToInt(String s) {
		return Integer.parseInt(s);
	}
}
