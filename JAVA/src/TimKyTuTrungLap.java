import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class TimKyTuTrungLap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập 1 chuỗi bất kỳ: ");
		String chuoi = sc.nextLine();
		xuLyChuoi(chuoi);
		sc.close();
	}

	public static void xuLyChuoi(String chuoi) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] kyTu = chuoi.toCharArray();
		for (Character c : kyTu) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		Set<Character> key = map.keySet();
		for (Character character : key) {
			if (map.get(character) > 1) {
				System.out.println("Ký tự " + character + " có " + map.get(character) + " lần xuất hiện");
			}
		}
	}
}
