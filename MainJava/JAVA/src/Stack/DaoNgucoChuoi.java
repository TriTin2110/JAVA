package Stack;

import java.util.Scanner;
import java.util.Stack;

class DaoNgucoChuoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập chuỗi bất kỳ: ");
		String chuoi = sc.nextLine();
		System.out.println("Hãy nhập 1 số bất kỳ: ");
		int soNguyen = sc.nextInt();
		outPut(chuoi, soNguyen);
		sc.close();
	}

	static void outPut(String chuoi, int soNguyen) {
		Stack<Character> str = new Stack<Character>();
		for (int i = 0; i < chuoi.length(); i++) {
			// Đưa lần lượt từng chữ cái từ trên xuống dưới vào stack
			str.push(chuoi.charAt(i));
		}

		for (int i = 0; i < chuoi.length(); i++) {
			// Lấy từng chữ cái theo thứ tự từ trên xuống dưới
			System.out.print(str.pop());
		}
		System.out.println();
		Stack<String> n = new Stack<String>();
		while (soNguyen > 0) {
			n.push((soNguyen % 2) + "");
			soNguyen /= 2;
		}
		int dem = n.size();
		for (int i = 0; i < dem; i++) {
			System.out.print(n.pop());
		}
	}
}
