import java.util.Scanner;

class KiemTraChuoiChuaChuoiKhac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập họ và tên của bạn: ");
		String ten = sc.nextLine();
		String ho = "Nguyễn";
		System.out.println((ten.contains(ho)) ? "Tên của bạn có chứa \"Nguyễn\"" : "Tên của bạn không chứa \"Nguyễn\"");
		sc.close();
	}

}
