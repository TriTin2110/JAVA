package MyClass;

public class StringController {
	public static String UppercaseFirstLetter(String str) {
		int x = 0;
		String result = "";
		if (str.charAt(x) == ' ') {
			while (str.charAt(x) == ' ') {
				++x;
				result = Character.toUpperCase(str.charAt(x)) + "";
			}
		} else {
			result = Character.toUpperCase(str.charAt(0)) + "";
		}
		for (int i = x + 1; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				result += str.charAt(i);
				i++;
				result += Character.toUpperCase(str.charAt(i));
			} else
				result += str.charAt(i);
		}
		return result;
	}
}
