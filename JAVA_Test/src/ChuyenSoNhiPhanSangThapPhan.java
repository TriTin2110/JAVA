import java.util.Scanner;

public class ChuyenSoNhiPhanSangThapPhan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long nhiPhan = 0; // Đặt kiểu long để có thể nhập được những số lớn
		try {
			System.out.println("Hãy nhập 1 số nhị phân: ");
			nhiPhan = sc.nextLong();
		} catch (Exception e) {
			System.out.println("Số nhị phân không hợp lệ!");
			return;
		}
		String np = Long.toString(nhiPhan);
		char[] c = np.toCharArray();
		for (int i = 0; i < np.length(); i++) {
			if (c[i] != '0' && c[i] != '1') { /*
												 * Nếu đặt || giả sử lấy nhị phân = 10 thì ký tự '1' sẽ khác '0' nhưng
												 * '1' sẽ không khác '1' từ đó chtr sẽ in ra dòng bên dưới (vì || chỉ
												 * cần 1 điều kiện đúng thì sẽ thực thi)
												 */
				System.out.println("Số nhị phân không hợp lệ!");
				return;
			}
		}
		xuLy(nhiPhan);
	}

	public static void xuLy(long nhiPhan) {
		long temp = 0;
		long thapPhan = 0;
		long soMu = 0;
		while (nhiPhan != 0) {
			temp = nhiPhan % 10;
			thapPhan += temp * Math.pow(2, soMu);
			nhiPhan /= 10;
			soMu++;
		}
		System.out.println(thapPhan);
	}
}
