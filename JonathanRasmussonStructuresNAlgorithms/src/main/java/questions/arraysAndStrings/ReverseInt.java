package questions.arraysAndStrings;

public class ReverseInt {

	public static int reverse(Integer num) {
		StringBuilder res = new StringBuilder();
		if (num >= 0) {
			res.append(num.toString());
			res.reverse();
		} else {
			res.append("-");
			StringBuilder help = new StringBuilder();
			num *= -1;
			help.append(num.toString());
			help.reverse();
			res.append(help);
		}		
		return Integer.valueOf(res.toString());
	}

	public static int reverseB(int x) {
		boolean isNegative = x < 0 ? true : false;
		if (isNegative) {
			x *= -1;
		}

		int reverse = 0;
		int lastDigit = 0;

		while (x >= 1) {
			lastDigit = x % 10;
			reverse = reverse * 10 + lastDigit;
			x /= 10;
		}
		return isNegative ? reverse * (-1) : reverse;
	}
}
