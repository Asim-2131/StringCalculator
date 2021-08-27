package SC;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class StringCalc{


	// Main Add Function
	
	public static int Add(String s) {
		if(s.isEmpty()) return 0;
		else if(s.length() == 1) return sToInt(s);
		else{
			if(s.startsWith("//"))
				return customDelimiters(s);
			else
				return separateCaseForCommaAndNewLineCombine(s);
		}
	}

	
	// Function For custom Delimiters
	
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
	
	// extracting delimiters from string
	
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
	
	// Case for comma and new line
	
	private static int separateCaseForCommaAndNewLineCombine(String s) {
		String numbers [] = s.split(",|\n");
		return additionOfString(numbers);
	}

	// Function for splitting string after new line with following passed string in split function
	
	private static String[] splitByDelimiters(String s,ArrayList<String>delimiters) {
		return s.split(combinationOfSplitingDelimiters(delimiters));
	}
	
	
	// Make string of string  for fit into split function 
	
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
	
	// Make String from characters to separate delimiters
	
	private static String splitFormForParticularPattern(String s) {
		String ref = "";
		for(int i=0;i<s.length();i++) {
			ref += "\\" + s.charAt(i);
		}
		return ref;
	}
	
	// Addition of numbers extracted from string after processing string
	
	private static int additionOfString(String numbers[]) {
		int val = 0;
		ArrayList<Integer> negative = new ArrayList<>();
		for(int i=0;i<numbers.length;i++) {
			if(sToInt(numbers[i]) < 0) negative.add(sToInt(numbers[i]));
			val += (sToInt(numbers[i]) <= 1000 ? sToInt(numbers[i]) : 0);
		}
		if(negative.size() > 0) {
			throw new IllegalArgumentException("negative not allowed " + combineNgNumbers(negative));
		}
		return val;
	}
	
	// Combine negative numbers as a string for passing in Exception
	
	private static String combineNgNumbers(ArrayList<Integer> negative) {
		String ref = "";
		for(int i=0;i<negative.size();i++) {
			if(i == negative.size() -1) ref += negative.get(i);
			else ref += negative.get(i) + ", ";
		}
		return ref;
	}

	// String to integer Converter

	private static int sToInt(String s) {
		return Integer.parseInt(s);
	}
}
