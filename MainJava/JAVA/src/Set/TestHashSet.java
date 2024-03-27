package Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class TestHashSet {
	static Scanner sc = new Scanner(System.in);
	// HashSet = không sắp xếp
	Set<String> thungPhieu = new HashSet<String>();

	// TreeSet = sắp xếp
//	Set<String> thungPhieu = new HashSet<String>();
	public TestHashSet() {
	}

	// Thêm phiếu
	boolean themPhieu(String giaTri) {
		return this.thungPhieu.add(giaTri);
	}

	// Xóa phiếu
	boolean xoaPhieu(String giaTri) {
		return this.thungPhieu.remove(giaTri);
	}

	// Kiểm tra phiếu có tồn tại trong thùng
	boolean kiemTraPhieu(String giaTri) {
		return this.thungPhieu.contains(giaTri);
	}

	// Xóa toàn bộ phiếu trong thùng
	void xoaToanBoPhieu() {
		this.thungPhieu.clear();
	}

	// In ra số lượng phiếu có trong thùng
	int inSoLuongPhieu() {
		return thungPhieu.size();
	}

	// Rút 1 phiếu bất kỳ
	String rutTham() {
		Random r = new Random();
		return (String) this.thungPhieu.toArray()[r.nextInt(inSoLuongPhieu())];
	}

	// In toàn bộ phiếu
	void inToanBoPhieu() {
		System.out.println(Arrays.toString(thungPhieu.toArray()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choose = 0;
		boolean check = true;
		TestHashSet test = new TestHashSet();
		do {
			do {
				try {
					System.out.println("Hãy nhập lựa chọn của bạn:");
					System.out.println("1. Thêm phiếu");
					System.out.println("2. Xóa phiếu");
					System.out.println("3. Kiểm tra phiếu có tồn tại trong thùng");
					System.out.println("4. Xóa toàn bộ phiếu");
					System.out.println("5. In ra số lượng phiếu trong thùng");
					System.out.println("6. Rút thăm 1 phiếu bất kỳ");
					System.out.println("7. In toàn bộ phiếu có trong thùng");
					System.out.print("==> ");
					choose = sc.nextInt();
					check = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lựa chọn của bạn không hợp lệ!");
					check = false;
				}
				sc.nextLine();
				System.out.println("\n------------------------------");
			} while (!check);
			luaChon(choose, check, test);
		} while (choose != 0);
		sc.close();
	}

	static void luaChon(int choose, boolean check, TestHashSet test) {
		switch (choose) {
		case 1, 2, 3: {
			System.out.println("Hãy nhập giá trị của phiếu: ");
			String giaTriPhieu = sc.nextLine();

			switch (choose) {
			case 1: {
				test.themPhieu(giaTriPhieu);
				break;
			}

			case 2: {
				test.xoaPhieu(giaTriPhieu);
				break;
			}

			case 3: {
				System.out.println(test.kiemTraPhieu(giaTriPhieu));
				break;
			}
			}

			break;
		}

		case 4: {
			test.xoaToanBoPhieu();
			break;
		}

		case 5: {
			System.out.println(test.inSoLuongPhieu());
			break;
		}

		case 6: {
			System.out.println(test.rutTham());
			break;
		}

		case 7: {
			test.inToanBoPhieu();
			break;
		}
		}
	}
}
