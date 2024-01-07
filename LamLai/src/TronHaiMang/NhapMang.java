package TronHaiMang;

import java.util.Scanner;

class NhapMang {
	static Scanner sc = new Scanner(System.in);
	static boolean check = true;
	static int chieuDai1 = 0, chieuDai2 = 0;

	void nhapMang() {
//Chiều dài mảng 1
		do {
			try {
				do {
					System.out.println("Hãy nhập số lượng phần tử của mảng thứ 1: ");
					chieuDai1 = sc.nextInt();
					check = true;
				} while (chieuDai1 < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Số lượng phần tử của mảng 1 không hợp lệ!");
				check = false;
			}
		} while (!check);

//Chiều dài mảng 2
		do {
			try {
				do {
					System.out.println("Hãy nhập số lượng phần tử của mảng thứ 2: ");
					chieuDai2 = sc.nextInt();
					check = true;
				} while (chieuDai2 < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Số lượng phần tử của mảng 2 không hợp lệ!");
				check = false;
			}
		} while (!check);

		nhapPhanTu(chieuDai1, chieuDai2);
	}

	static void nhapPhanTu(int chieuDai1, int chieuDai2) {
		int[] mang1 = new int[chieuDai1];
		int[] mang2 = new int[chieuDai2];

// Nhập phần tử của mảng 1
		System.out.println("\n-------------- Mảng 1 --------------");
		for (int i = 0; i < chieuDai1; i++) {
			do {
				try {
					System.out.println("Hãy nhập giá trị của phần tử thứ " + (i + 1) + ": ");
					mang1[i] = sc.nextInt();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Giá trị của phần tử thứ " + (i + 1) + " không hợp lệ!");
					check = false;
				}
			} while (!check);
		}

// Nhập phần tử của mảng 2
		System.out.println("\n-------------- Mảng 2 --------------");
		for (int i = 0; i < chieuDai2; i++) {
			do {
				try {
					System.out.println("Hãy nhập giá trị của phần tử thứ " + (i + 1) + ": ");
					mang2[i] = sc.nextInt();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Giá trị của phần tử thứ " + (i + 1) + " không hợp lệ!");
					check = false;
				}
			} while (!check);
		}
		SapXepMang sx = new SapXepMang();
		System.out.print("\nMảng 1 \nTrước:\t");
		sx.sapXepBanDau(mang1);
		System.out.println();
		System.out.print("\nMảng 2 \nTrước:\t");
		sx.sapXepBanDau(mang2);
		sc.nextLine();
		System.out.println("\nBạn có muốn thêm phần tử tiếp theo không?(Y/N): ");
		char ans;
		do {
			System.out.print("==> ");
			ans = sc.nextLine().charAt(0);
			ans = Character.toUpperCase(ans);
		} while (ans != 'Y' && ans != 'N');
		if (ans == 'Y') {
			int phanTuDuocThem = 0;
			do {
				try {
					System.out.println("Hãy nhập giá trị của phần tử thêm vào: ");
					phanTuDuocThem = sc.nextInt();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Giá trị của phần tử được thêm vào không hợp lệ!");
					check = false;
				}
			} while (!check);
			System.out.print("\nMảng 3 \nTrước:\t");
			sx.sapXepBanDau(mang3(mang1, mang2, phanTuDuocThem));
		} else {
			String ketThuc = "Kết thúc chương trình!";
			for (int i = 0; i < ketThuc.length(); i++) {
				System.out.print(ketThuc.charAt(i));
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	static int[] mang3(int[] mang1, int[] mang2, int phanTuDuocThem) {
		int[] mang3 = new int[chieuDai1 + chieuDai2 + 1];
		int i = 0, j = 0;
		while (i < chieuDai1 + chieuDai2) {
			if (i > chieuDai1 - 1) {
				mang3[i] = mang2[j];
				j++;
			} else {
				mang3[i] = mang1[i];
			}
			i++;
		}
		mang3[chieuDai1 + chieuDai2] = phanTuDuocThem;
		return mang3;
	}
}
