package ArrowFunction;

import java.util.Scanner;

class ThapPhanSangNhiPhan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		int thapPhan = 0;
		do {
			try {
				System.out.println("Hãy nhập giá trị thập phân: ");
				thapPhan = sc.nextInt();
				check = true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị thập phân không hợp lệ!");
				check = false;
			}
			sc.nextLine();
			System.out.println();
		} while (!check);
		output(thapPhan);
		sc.close();
	}

	static void output(int thapPhan) {
		String nhiPhan = "";
		boolean kiemTraAm = false;
		if (thapPhan < 0) {
			thapPhan = Math.abs(thapPhan);
			kiemTraAm = true;
		}
		while (thapPhan > 0) {
			nhiPhan = (thapPhan % 2) + nhiPhan;
			thapPhan /= 2;
		}
		System.out.println((kiemTraAm) ? "-" + nhiPhan : nhiPhan);
	}
}
