import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class XoaPhanTuTrungLap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int chieuDaiMang = 0;
		boolean check = true;
		do {
			try {
				do {
					System.out.println("Hãy nhập số lượng phần tử có trong mảng: ");
					chieuDaiMang = sc.nextInt();
					check = true;
				} while (chieuDaiMang < 0);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Số lượng phần tử không hợp lệ!");
				check = false;
			}
		} while (!check);

		int[] mang = new int[chieuDaiMang];
		for (int i = 0; i < mang.length; i++) {
			do {
				try {
					System.out.println("Hãy nhập giá trị của phần tử thứ " + (i + 1) + ": ");
					mang[i] = sc.nextInt();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Giá trị của phần tử không hợp lệ!");
					check = false;
				}
			} while (!check);
		}
		output(mang);
		sc.close();
	}

	static void output(int[] mang) {
		int[] mang2 = new int[mang.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : mang) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		int h = 0;
		Set<Integer> key = map.keySet();
		for (int i : key) {
			if (map.get(i) == 1) {
				mang2[h] = i;
				h++;
			}
		}

		for (int i : mang2) {
			if (i != 0) {
				System.out.println(i);
			}
		}
	}
}
