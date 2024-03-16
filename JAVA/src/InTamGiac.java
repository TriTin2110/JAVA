import java.util.Scanner;

public class InTamGiac {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int quyMoTamGiac;
		try {
			do {
				System.out.println("Hãy nhập quy mô của tam giác (số nguyên): ");
				quyMoTamGiac = sc.nextInt();
			} while (quyMoTamGiac < 1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của quy mô tam giác không hợp lệ!");
			sc.close();
			return;
		}

//tam giác hướng xuống
		int dem = (quyMoTamGiac * 2) - 1; /*
											 * dem là số sao sẽ xuất hiện ban đầu sẽ là (quyMoTamGiac*2)-1 VD: nếu hàng
											 * = 3 thì số sao xuất hiện dòng đầu tiên sẽ là 5
											 */
		for (int i = 0; i < quyMoTamGiac; i++) {
			for (int j = 0; j < dem; j++) {
				System.out.print("*");
			}
			dem -= 2; /* Các dòng tiếp theo lần lượt sẽ là 3 -> 1 */
			System.out.println();
			for (int j = 0; j < i + 1; j++) {
				System.out.print(" ");
			}
		}
//tam giác hướng lên
		System.out.println();
		dem = 1; /* Biến đếm này sẽ là hàng đầu tiên */
		for (int i = 0; i < quyMoTamGiac; i++) {
			for (int j = 0; j < quyMoTamGiac - (i + 1); j++) { /*
																 * quyMoTamGiac - (i+1) sẽ là khoảng cách lề VD: nếu
																 * hàng = 3 thì khoảng cách lề sẽ là 3 - (0+1) = 2
																 *
																 ***
																 *****
																 */
				System.out.print(" ");
			}
			for (int j = 0; j < dem; j++) {
				System.out.print("*");
			}
			dem += 2;
			System.out.println();
		}

		System.out.println();
		dem = quyMoTamGiac;
		for (int i = 0; i < quyMoTamGiac; i++) {
			for (int j = 0; j < dem; j++) {
				System.out.print("*");
			}
			dem--;
			System.out.println();
		}

		dem = quyMoTamGiac;
		for (int i = 0; i < quyMoTamGiac; i++) {
			for (int j = 0; j < dem; j++) {
				System.out.print("*");
			}
			System.out.println();
			for (int j = 0; j < i + 1; j++) {
				System.out.print(" ");
			}
			dem--;
		}
		sc.close();
	}
}
