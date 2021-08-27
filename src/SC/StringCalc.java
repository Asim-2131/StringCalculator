package SC;

public class StringCalc {
	public static int Add(String s) {
		if(s.isEmpty()) return 0;
		else if(s.length() == 1) return sToInt(s);
		else{
			String [] numbers = splitByComma(s);
			return additionOfString(numbers);
		}
	}
	
	public static String[] splitByComma(String s) {
		return s.split(",");
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
