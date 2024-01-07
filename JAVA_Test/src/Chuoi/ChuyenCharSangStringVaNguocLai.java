import java.util.Scanner;

/**
 * ChuyenCharSangStringVaNguocLai
 */
public class ChuyenCharSangStringVaNguocLai {

        public static void main(String[] args) {
                /* Chuyen Char sang String */
                Scanner sc = new Scanner(System.in);
                char a = 'h';
                System.out.println("Chuyen doi kieu Char sang String:");
                String chuoi = String.valueOf(a);
                System.out.println(chuoi);

                /*
                 * =============================================================================
                 */

                /* Chuyen String sang Char */
                System.out.print("Hay nhap 1 chuoi bat ky: ");
                String str = sc.nextLine();
                char[] kyTu = str.toCharArray();
                for (int i = 1; i <= str.length(); i++) {
                        System.out.println("Ky tu thu " + i + " la: " + kyTu[i]);
                }
        }
}