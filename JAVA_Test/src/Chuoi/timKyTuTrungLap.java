import java.security.Key;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * timKyTuTrungLap
 */
public class timKyTuTrungLap {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Hay nhap 1 chuoi bat ky: ");
                String chuoi = sc.nextLine();
                InnertimKyTuTrungLap(chuoi);
        }

        public static void InnertimKyTuTrungLap(String chuoi) {
                HashMap<Character, Integer> map = new HashMap<Character, Integer>(); /*
                                                                                      * Tạo 1 bộ nhớ map có dữ liệu đầu
                                                                                      * vào chứa 2 kiểu dữ liệu là (Char
                                                                                      * và Int)
                                                                                      */
                char[] kyTu = chuoi.toCharArray();
                for (Character ch : kyTu) /* Duyệt từng ký tự xuất hiện trong mảng */
                {
                        if (map.containsKey(ch)) /* Nếu ký tự trùng vs ký tự đã có trong map thì */
                        {
                                map.put(ch, map.get(ch) + 1); /*
                                                               * ký tự đó sẽ đc thêm vào map và đồng thời +1 cho số lần
                                                               * xuất hiện của nó
                                                               */
                        } else /*
                                * Nếu ký tự chưa có trong map thì ký tự đó sẽ đc thêm vào bộ nhớ map và số lần
                                * xuất hiện sẽ là 1
                                */
                                map.put(ch, 1);
                }
                Set<Character> key = map.keySet(); /* lấy ký tự trong map ra */
                for (Character ch : key) {
                        if (map.get(ch) > 1) {
                                System.out.println(ch + " co so lan xuat hien la: " + map.get(ch));
                        }
                }
        }
}