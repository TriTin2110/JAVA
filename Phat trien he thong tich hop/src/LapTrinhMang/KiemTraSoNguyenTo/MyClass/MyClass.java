package LapTrinhMang.KiemTraSoNguyenTo.MyClass;

public class MyClass {
	public static int primeNumber(String[] str) {
		int num = 0;
		out: for (String string : str) {
			num = Integer.parseInt(string);
			if (num == 1 || num == 2) {
				return num;
			} else {
				for (int i = 2; i < num; i++) {
					if (num % i == 0)
						// Chuyển sang số tiếp theo trong chuỗi
						continue out;
				}
				return num;
			}
		}
		return 0;
	}
}
