import java.util.Scanner;

class KiemTraSoChinhPhuong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
				n = sc.nextInt();
			} while (n < 1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của số nguyên không hợp lệ!");
			sc.close();
			return;
		}
		outPut(n);
		sc.close();
	}

	static void outPut(int n) {
//Cách 1
		boolean soChinhPhuong = false;
		for (int i = 0; i < n; i++) {
			if (Math.sqrt(n) == i) {
				soChinhPhuong = true;
			}
		}
		System.out.println((soChinhPhuong) ? "Giá trị vừa nhập là 1 số chính phương"
				: "Giá trị vừa nhập không phải là 1 số chính phương");

//Cách 2
		System.out.println((Math.sqrt(n) == (int) Math.sqrt(n)) ? "Giá trị vừa nhập là 1 số chính phương"
				: "Giá trị vừa nhập không phải là 1 số chính phương");
	}

}
