import java.util.Scanner;

class SoArmsStrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n;
		try {
			System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
			n = sc.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Giá trị của số nguyên không hợp lệ!");
			sc.close();
			return;
		}
		outPut(n);
		sc.close();
	}

	static void outPut(int n) {
		String chuoi = Integer.toString(n);
		int doDai = chuoi.length();
		int n2 = n;
		int tong = 0;
		int temp;
		while (n2 > 0) {
			temp = n2 % 10;
			tong += Math.pow(temp, doDai);
			n2 /= 10;
		}
		System.out.println(
				(tong == n) ? "Giá trị vừa nhập là số Armstrong!" : "Giá trị vừa nhập không phải là số ArmStrong!");
	}

}
