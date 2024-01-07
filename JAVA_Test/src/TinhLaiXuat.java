import java.util.Scanner;

/**
 * TinhLaiXuat
 */
public class TinhLaiXuat {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Hay nhap so tien goc: ");
                int tienGoc = sc.nextInt();
                System.out.print("Nhap lai xuat moi nam: ");
                double laiXuat = sc.nextFloat();
                System.out.print("Nhap thoi gian (nam): ");
                int thoiGian = sc.nextInt();
                double ketQua = (tienGoc*laiXuat*thoiGian) / 100;
                System.out.println(ketQua);
        }
}