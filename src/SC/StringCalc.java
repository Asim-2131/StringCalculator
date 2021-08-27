package SC;

public class StringCalc {
	public static int Add(String s) {
		if(s.isEmpty()) return 0;
		else if(s.length() == 1) return sToInt(s);
		else{
			String [] numbers = s.split(",");
			return sToInt(numbers[0]) + sToInt(numbers[1]);
		}
	}
	public static int sToInt(String s) {
		return Integer.parseInt(s);
	}
}
