package MyClass;

public class NumberController {
	public static int checkCharacterIntNumber(String str) {
		if (str.length() == 1) {
			if (str.charAt(0) == '0')
				return 1;
		}

		for (int i = 0; i < str.length(); i++) {
			// Nếu trong chuỗi có chứa chữ cái thì trả về 0
			if (Character.isAlphabetic(str.charAt(i)))
				return 0;
		}
		return 1;
	}

	public static float checkCharacterFloatNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			// Nếu trong chuỗi có chứa chữ cái thì trả về 0
			if (Character.isAlphabetic(str.charAt(i)))
				return 0;
		}
		return Float.parseFloat(str);
	}

	public static long checkCharacterLongNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			// Nếu trong chuỗi có chứa chữ cái thì trả về 0
			if (Character.isAlphabetic(str.charAt(i)))
				return 0;
		}
		return Long.parseLong(str);
	}
}
