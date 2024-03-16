import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class DemSoLanXuatHienCuaPhanTu {

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
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer i : mang) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		Set<Integer> key = map.keySet();
		for (Integer integer : key) {
			System.out.println("Phần tử " + integer + " có " + map.get(integer) + " lần xuất hiện trong mảng!");
		}
	}
}
