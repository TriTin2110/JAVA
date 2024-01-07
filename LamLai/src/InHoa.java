import java.util.Scanner;

class InHoa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập 1 chuỗi bất kỳ(không IN HOA): ");
		String chuoi = sc.nextLine();
		output(chuoi);
		sc.close();
	}

	static void output(String chuoi) {
		char[] kyTu = chuoi.toCharArray();
		kyTu[0] = Character.toUpperCase(kyTu[0]);
		for (int i = 0; i < chuoi.length(); i++) {
			if (kyTu[i] == ' ') {
				kyTu[i + 1] = Character.toUpperCase(kyTu[i + 1]);
			}
		}
		// Lấy tên và tên đệm
		chuoi = String.valueOf(kyTu);
		String ten = "";
		ten = chuoi.substring(chuoi.lastIndexOf(" ") + 1);
		System.out.println(chuoi);
		String tenDem = chuoi.substring(0, chuoi.lastIndexOf(" "));
		System.out.println(tenDem);
		System.out.println(ten);
	}
}
