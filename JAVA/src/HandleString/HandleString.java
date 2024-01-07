package HandleString;

public class HandleString {
	// In hoa ký tự đầu tiên của mỗi từ
	public static String CapitalFirstLetter(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		/*
		 * Duyệt ký từng ký tự có trong chuỗi đã cho. Nếu vị trí của c[i] = ' ' =>
		 * c[i+1] = toUppercase(c[i+1]). Nếu vị trí của i = str.length() - 2 sẽ tiến
		 * hành nối ký tự phía sau nó tức ký tự cuối cùng trong chuỗi và kết thúc vòng
		 * lặp
		 */
		char[] c = str.toCharArray();
		c[0] = Character.toUpperCase(c[0]);
		for (int i = 0; i < c.length - 1; i++) {
			if (c[i] == ' ' && c[i + 1] != ' ') {
				c[i + 1] = Character.toUpperCase(c[i + 1]);
			}
			stringBuilder.append(c[i]);
			if (i == c.length - 2)
				stringBuilder.append(c[i + 1]);
		}
		return stringBuilder.toString();
	}
}
