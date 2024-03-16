import java.util.Scanner;

public class InHinhVuong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int canh;
		try {
			do {
				System.out.println("Hãy nhập cạnh của hình vuông: ");
				canh = sc.nextInt();
			} while (canh < 2);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị cạnh của hình vuông không hợp lệ!");
			sc.close();
			return;
		}

		for (int i = 0; i < canh; i++) {
			for (int j = 0; j < canh; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		sc.close();
	}
}
