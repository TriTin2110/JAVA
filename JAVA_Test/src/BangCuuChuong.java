public class BangCuuChuong {
	/*
	 * (Break là sẽ bỏ qua nhưng sẽ vẫn thực hiện những câu lệnh bên ngoài)
	 * (continue là sẽ skip qua đoạn đó) (return là bỏ qua đồng thời ngừng chạy luôn
	 * hàm main (nghĩa là không thực hiện những câu lệnh bên ngoài))
	 */
	public static void main(String[] args) {
		out: for (int i = 2; i < 10; i++) { /*
											 * out: là label (Trong trường hợp này label chính là tên của cái vòng lặp
											 * for bên ngoài nên đặt là out cho dễ nhận biết)
											 */
			in: for (int j = 1; j < 11; j++) {
				if (j > 5) {
					break out; // Trong trường hợp break vs j < 5 (tức số bị nhân > 5)thì sẽ BỎ
					// qua tất cả số
					// nhân (nói cách khác là nó sẽ thoát khỏi vòng lặp bên ngoài
					continue out; // Trong trường hợp continue vs j>5 (tức số bị nhân > 5) thì sẽ
					// SKIP qua các tích của số nhân khi nhân cho j >=6
					return; // khi j>5 (tức số bị nhân >5) thì sẽ thoát lun khỏi hàm main
				}
				System.out.println(i + " x " + j + " = " + (i * j));
			}
			System.out.println("------------------------------------");
		}
		System.out.println("Tri Tin");/*
										 * Khi "return" thì câu lệnh này sẽ không đc thực hiện Còn "break" thì câu lệnh
										 * này sẽ vẫn được thực thi
										 */
	}
}
