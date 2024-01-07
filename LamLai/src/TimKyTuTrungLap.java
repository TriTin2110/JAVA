import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class TimKyTuTrungLap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập 1 chuỗi bất kỳ: ");
		String chuoi = sc.nextLine();
		outPut(chuoi);
		sc.close();
	}

	static void outPut(String chuoi) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] kyTu = chuoi.toCharArray();
		out: for (Character c : kyTu) {
			if (c == ' ') {
				continue out;
			} else {
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}

		}
		Set<Character> key = map.keySet();
		for (Character character : key) {
			if (map.get(character) > 1) {
				System.out
						.println("Ký tự trùng lặp là: " + character + " có " + map.get(character) + " lần xuất hiện!");
			}
		}
	}
}
