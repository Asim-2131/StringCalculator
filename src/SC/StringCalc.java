package SC;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalc{


	public static int Add(String s) {
		if(s.isEmpty()) return 0;
		else if(s.length() == 1) return sToInt(s);
		else{
			if(s.startsWith("//"))
				return customDelimiters(s);
			return separateCaseForCommaAndNewLineCombine(s);
		}
	}


	private static int customDelimiters(String s) {
		ArrayList<String>delimiters = new ArrayList<String>();
		String [] refString = s.split("\n");
		if(refString[0].charAt(2) == '[') 
			delimiters = differentDelimiters(refString[0]);
		else 
			delimiters.add(refString[0].charAt(2)+"");
		
		String [] numbers = splitByDelimiters(refString[1],delimiters);
		return additionOfString(numbers);
	}
	
	
	private static ArrayList<String> differentDelimiters(String s){
		Pattern regex = Pattern.compile("\\[[*%$,@#^]*\\]");
		Matcher regexMatcher = regex.matcher(s);
		ArrayList<String> a = new ArrayList<String>();
		while(regexMatcher.find()){
			String ref = regexMatcher.group();
			ref = ref.substring(1,ref.length()-1);
			a.add(ref);
		}
		return a;
	}
	
	
	private static int separateCaseForCommaAndNewLineCombine(String s) {
		String numbers [] = s.split(",|\n");
		return additionOfString(numbers);
	}

	
	private static String[] splitByDelimiters(String s,ArrayList<String>delimiters) {
		return s.split(combinationOfSplitingDelimiters(delimiters));
	}
	
	
	private static String combinationOfSplitingDelimiters(ArrayList<String>delimiters) {
		String ref="";
		for(int i=0;i<delimiters.size();i++) {
			if(i == delimiters.size() -1) 
				ref += splitFormForParticularPattern(delimiters.get(i));
			else 
				ref += splitFormForParticularPattern(delimiters.get(i)) + "|";
		}
		return ref;
	}
	
	
	private static String splitFormForParticularPattern(String s) {
		String ref = "";
		for(int i=0;i<s.length();i++) {
			ref += "\\" + s.charAt(i);
		}
		return ref;
	}
	
	
	private static int additionOfString(String numbers[]) {
		int val = 0;
		for(int i=0;i<numbers.length;i++) {
			val += (sToInt(numbers[i]));
		}
		return val;
	}
	
	
	private static int sToInt(String s) {
		return Integer.parseInt(s);
	}
}
