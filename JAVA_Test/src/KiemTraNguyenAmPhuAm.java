import java.util.Scanner;

/**
 * KiemTraNguyenAmPhuAm
 */
public class KiemTraNguyenAmPhuAm {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Hay nhap 1 ky tu bat ky: ");
                char kyTu = sc.nextLine().charAt(0);
                if (kyTu >= 'a' && kyTu <= 'z' || kyTu >= 'A' && kyTu <= 'Z') {
                        if (kyTu == 'u' || kyTu == 'e' || kyTu == 'o' || kyTu == 'a' || kyTu == 'i' || kyTu == 'A'
                                        || kyTu == 'E' || kyTu == 'O' || kyTu == 'I' || kyTu == 'U') {
                                System.out.println(kyTu + " la nguyen am");
                        } else {
                                System.out.println(kyTu + " la phu am");
                        }
                } else {
                        System.out.println("Ky tu khong phai la chu cai!!!");
                }

        }
}