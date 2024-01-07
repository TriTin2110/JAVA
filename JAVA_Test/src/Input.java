import java.util.Scanner;

public class Input {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Nhập họ tên
		System.out.print("Hãy nhập họ và tên của bạn: ");
		String hoVaTen = sc.nextLine();
		//Nhập tuổi
		System.out.print("Hãy nhập tuổi của bạn: ");
		int tuoi = sc.nextInt();
		//Nhập điểm
		System.out.print("Hãy nhập điểm của bạn: ");
		float diem = sc.nextFloat();
		//Xuất ra kết quả
		System.out.println("Họ và tên của bạn là: "+hoVaTen);
		System.out.println("Tuổi của bạn là: "+tuoi);
		System.out.println("Điểm của bạn là: "+diem);
		sc.close();
	}
}

