import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DemChuCaiXuatHienTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        System.out.println("Hay nhap 1 chuoi bat ky: ");
        String chuoi = scanner.nextLine();
        for (int i = 0; i < chuoi.length(); i++) {
            if (map.containsKey(chuoi.charAt(i))) {
                int dem = map.get(chuoi.charAt(i));
                dem++;
                map.put(chuoi.charAt(i), dem);
            } else
                map.put(chuoi.charAt(i), 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
