import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TimKyTuTrungLap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap 1 chuoi bat ky: ");
        String chuoi = scanner.nextLine();
        kiemtra(chuoi);
    }

    public static void kiemtra(String chuoi) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char mangkytu[] = chuoi.toCharArray();
        for (Character ch : mangkytu) {
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        Set<Character> keys = map.keySet();
        for (Character ch : keys) {
            if (map.get(ch) > 1)
                System.out.println(ch + " " + map.get(ch));
        }
    }
}