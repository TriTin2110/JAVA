import java.util.Scanner;

class KiemTraChuoiCoChuaChuoiKhac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập họ tên của bạn: ");
		String hoTen = sc.nextLine();
		char[] ht = hoTen.toCharArray();
		ht[0] = Character.toUpperCase(ht[0]);
		for (int i = 1; i < ht.length; i++) {
			ht[i] = Character.toLowerCase(ht[i]);
		}
		hoTen = String.valueOf(ht);
		String ho = "Nguyễn";
		output(hoTen, ho);
		sc.close();
	}

	static void output(String hoTen, String ho) {

		if (hoTen.contains(ho)) {
			System.out.println("Họ của bạn là \"Nguyễn\"");
		} else {
			System.out.println("Họ của bạn không phải là \"Nguyễn\"");
		}
	}
}
