import java.util.Scanner;

class MangA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập số lượng phần tử có trong mảng (0 <= n <= 100): ");
				n = sc.nextInt();
			} while (n < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của phần tử không hợp lệ!");
			sc.close();
			return;
		}
		int[] mang = new int[n];
		for (int i = 0; i < mang.length; i++) {
			try {
				do {
					System.out.println("Hãy nhập giá trị của phần tử thứ " + (i + 1) + ": ");
					mang[i] = sc.nextInt();
				} while (mang[i] < 0 || mang[i] > 100);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị của phần tử không hợp lệ!");
				sc.close();
				return;
			}
		}
		ChucNangMangA cn = new ChucNangMangA(mang);
		cn.timPhanTuLonNhatVaLonThuHaiTrongMang();
		cn.SapXepMangTangDan();
		System.out.println();
		int soChen;
		try {
			do {
				System.out.println("Hãy nhập giá trị của số chèn thêm: ");
				soChen = sc.nextInt();
			} while (soChen < 0 || soChen > 100);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của số chèn không hợp lệ!");
			sc.close();
			return;
		}
		int[] mang2 = new int[mang.length + 1];
		System.arraycopy(mang, 0, mang2, 0, mang.length);
		mang2[mang2.length - 1] = soChen;
		cn = new ChucNangMangA(mang2);
		cn.SapXepMangTangDan();
		sc.close();
	}

}
