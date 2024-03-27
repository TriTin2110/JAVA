import java.util.Scanner;

public class InHoa {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập 1 chuỗi bất kỳ: ");
		String chuoi = sc.nextLine();
		xuLyChuoi(chuoi);
		sc.close();
	}

	public static void xuLyChuoi(String chuoi) {
		char[] kyTu = chuoi.toCharArray();
		for (int i = 0; i < chuoi.length(); i++) {
			if (i == 0) {
				kyTu[i] = Character.toUpperCase(kyTu[i]);
			} else if (Character.isWhitespace(kyTu[i])) {
				kyTu[i + 1] = Character.toUpperCase(kyTu[i + 1]);
			}
		}
		System.out.println(String.valueOf(kyTu).trim());
	}
}
