package MyClass;

public class NumberController {
	public static int checkCharacterIntNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (Character.isAlphabetic(str.charAt(i)))
				return 0;
		}
		return Integer.parseInt(str);
	}

	public static float checkCharacterFloatNumber(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (Character.isAlphabetic(str.charAt(i)))
				return 0;
		}
		return Float.parseFloat(str);
	}
}
