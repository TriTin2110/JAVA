import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class LietKeCacSoNguyenToNhoHonN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int soNguyen = 0;
		boolean check = true;
		do {
			try {
				do {
					System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
					soNguyen = sc.nextInt();
					check = true;
				} while (soNguyen < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Số nguyên nhập vào không hợp lệ!");
				check = false;
			}
			sc.nextLine();
		} while (!check);
		outPut(soNguyen);
		sc.close();
	}

	static void outPut(int soNguyen) {
		ArrayList<Integer> ketQua = new ArrayList<Integer>();
		System.out.println("Các số nguyên tố từ 1 đến n là: ");
		out: for (int i = 2; i < soNguyen; i++) {
			for (int j = 1; j < i; j++) {
				if (i % j == 0 && j != 1) {
					continue out;
				}
			}
			ketQua.add(i);
		}
		System.out.println(Arrays.toString(ketQua.toArray()));
	}
}
