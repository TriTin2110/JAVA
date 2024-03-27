package Map;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class TuDien_TreeMap {
	// Map<String, String> giaTri = new HashMap<String, String>(); //Không sắp xếp
	Map<String, String> giaTri = new TreeMap<String, String>(); // Có sắp xếp

	// Thêm từ mới
	void themTu(String tuKhoa, String yNghia) {
		giaTri.put(tuKhoa, yNghia);
	}

	// Xóa từ
	void xoaTu(String tuKhoa) {
		giaTri.remove(tuKhoa);
	}

	// Tra từ
	String traTu(String tuKhoa) {
		return giaTri.get(tuKhoa);
	}

	// Xóa toàn bộ từ
	void xoaToanBo() {
		giaTri.clear();
	}

	// In toàn bộ từ
	void inToanBoTu() {
		Set<String> key = giaTri.keySet();
		System.out.println(Arrays.toString(key.toArray()));
	}

	// Trả về số lượng từ khóa
	int traVeSoLuongTuKhoa() {
		return giaTri.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TuDien_TreeMap tuDien = new TuDien_TreeMap();
		Scanner sc = new Scanner(System.in);
		int choose = 0;
		boolean check = true; // Kiểm tra lựa chọn nhập vào có hợp lệ hay không
		String tuKhoa = null, yNghia = null;

		do {
			do {
				try {
					do {
						System.out.println("Hãy nhập lựa chọn của bạn:");
						System.out.println("1. Thêm từ mới");
						System.out.println("2. Xóa từ");
						System.out.println("3. Tra từ");
						System.out.println("4. Xóa toàn bộ từ");
						System.out.println("5. In toàn bộ từ");
						System.out.println("6. In số lượng từ khóa");
						System.out.println("0. Thoát");
						System.out.print("==> ");
						choose = sc.nextInt();
						check = true;
					} while (choose < 0 || choose > 7);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lựa chọn của bạn không hợp lệ!");
					check = false;
				}
				sc.nextLine();
			} while (!check);

			if (choose == 1) {
				System.out.print("Hãy nhập từ khóa mới: ");
				tuKhoa = sc.nextLine();
				System.out.print("Hãy nhập ý nghĩa của từ khóa mới: ");
				yNghia = sc.nextLine();
			} else if (choose == 2 || choose == 3) {
				System.out.println("Hãy nhập từ khóa: ");
				tuKhoa = sc.nextLine();
			}

			switch (choose) {
			case 1: {
				tuDien.themTu(tuKhoa, yNghia);
				break;
			}
			case 2: {
				tuDien.xoaTu(tuKhoa);
				break;
			}
			case 3: {
				System.out.println(tuDien.traTu(tuKhoa));
				break;
			}
			case 4: {
				tuDien.xoaToanBo();
				break;
			}
			case 5: {
				tuDien.inToanBoTu();
				break;
			}
			case 6: {
				System.out.println(tuDien.traVeSoLuongTuKhoa());
				break;
			}
			}
		} while (choose != 0);
	}
}
