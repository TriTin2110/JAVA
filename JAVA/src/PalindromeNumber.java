import java.util.Scanner;
import java.util.Stack;

class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.println("Hãy nhập n: ");
		n = sc.nextInt();
		outPut(n);
		System.out.println((outPut(n)) ? "Đây là số Palindrome" : "Đây không phải là số Palindrome");
		sc.close();
	}

	static boolean outPut(int x) {
		String y = Integer.toString(x);
		String ketQua = "";
		Stack<Integer> kq = new Stack<Integer>();
		while (x > 0) {
			kq.add(x % 10);
			x /= 10;
		}
		for (Integer integer : kq) {
			ketQua += integer + "";
		}
		if (y.compareTo(ketQua) == 0) {
			return true;
		} else {
			return false;
		}
	}
}
