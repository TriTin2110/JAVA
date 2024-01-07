package MyAPI;

public class StringController {
	public static String ucFirst(String str) {
		String result = "";
		char[] demo = str.toCharArray();
		result += Character.toUpperCase(demo[0]);
		for (int i = 1; i < demo.length - 1; i++) {

			if (demo[i] == ' ')
				demo[i + 1] = Character.toUpperCase(demo[i + 1]);
			result += demo[i];
			if (i == demo.length - 2) {
				result += demo[i + 1];
			}

		}
		return result;
	}
}
