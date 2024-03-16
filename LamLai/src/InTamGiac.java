
class InTamGiac {
	public static void main(String[] args) {
		double n = 7;
		int h = 1;
		int m = 7;
		for (int i = 0; i < Math.ceil(n / 2); i++) {
			for (int j = 0; j < m; j++) {
				System.out.print("*");
			}
			System.out.println();
			for (int j = 0; j < h; j++) {
				System.out.print(" ");
			}
			h++;
			m -= 2;
		}
		System.out.println();
		m = 1;
		h = 1;
		for (int i = 0; i < Math.ceil(n / 2); i++) {
			for (int j = 0; j < Math.ceil(n / 2) - h; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < m; j++) {
				System.out.print("*");
			}
			System.out.println();
			m += 2;
			h++;
		}
	}
}
