import java.util.Scanner;

/**
 * XoaKhoangTrangTrongChuoi
 */
public class XoaKhoangTrangTrongChuoi {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Hay nhap 1 chuoi bat ky: ");
                String chuoi = sc.nextLine();
                chuoi = chuoi.replaceAll(" ", ""); /* replaceAll dùng để thay thế ký tự này bằng ký tự khác */
                System.out.println(chuoi);
        }
}