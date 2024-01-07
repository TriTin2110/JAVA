import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class XoaPhanTuTrungLap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			do {
				System.out.println("Hãy nhập số lượng phần tử có trong mảng: ");
				n = sc.nextInt();
			} while (n < 0);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Số lượng phần tử không hợp lệ!");
			sc.close();
			return;
		}
		int[] mang = new int[n];
		for (int i = 0; i < mang.length; i++) {
			try {
				System.out.println("Hãy nhập giá trị của phần tử thứ " + (i + 1) + ": ");
				mang[i] = sc.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Giá trị của phần tử không hợp lệ!");
				sc.close();
				return;
			}
		}
		outPut(mang);
		sc.close();
	}

	static void outPut(int[] mang) {
//Cách 1
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < mang.length; i++) {
			if (map.containsKey(mang[i])) {
				map.put(mang[i], map.get(mang[i]) + 1);
			} else {
				map.put(mang[i], 1);
			}
		}
		Set<Integer> key = map.keySet();
		for (Integer integer : key) {
			if (map.get(integer) > 0) {
				System.out.println(integer);
			}
		}

//Cách 2
//		out: for (int i = 0; i < mang.length; i++) {
//			for (int j = i - 1; j >= 0; j--) {
//				if (mang[j] == mang[i]) {
//					mang[j] = 0;
//					continue out;
//				}
//			}
//		}
//		for (int i : mang) {
//			if (i != 0) {
//				System.out.println(i);
//			}
//		}
	}
}
