import java.util.Scanner;

/**
 * TinhLaiXuatKep
 */
public class TinhLaiXuatKep {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Hay nhap so tien goc: ");
                int tienGoc = sc.nextInt();
                System.out.print("Nhap lai xuat hang nam: ");
                double laiXuat = sc.nextFloat();
                System.out.print("Thoi gian(Nam): ");
                int thoiGian = sc.nextInt();
                System.out.print("So lan lai: ");
                int lanLai = sc.nextInt();
                double laiKep = tienGoc * Math.pow(1 + (laiXuat / lanLai), (lanLai * thoiGian));
                double ketQua = laiKep - tienGoc;
                System.out.println(ketQua);
        }
}