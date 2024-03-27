package MyClass;

public class StringController {
	public static String[] StringArraySort(String[] str) {
		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (str[j].compareTo(str[i]) == -1) {
					str[i] = changing(str[j], str[j] = str[i]);
				}
			}
		}
		return str;
	}

	private static String changing(String a, String b) {
		return a;
	}
}
