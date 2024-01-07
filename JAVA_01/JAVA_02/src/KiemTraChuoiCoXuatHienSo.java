import java.util.Scanner;

/**
 * KiemTraChuoiCoXuatHienSo
 */
public class KiemTraChuoiCoXuatHienSo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap 1 chuoi: ");
        String chuoi = scanner.nextLine();
        if (chuoi.matches(".*\\d.*"))
            System.out.println("Chuoi ban nhap vao co chua so !!!");
        else
            System.out.println("Chuoi ban nhap vao khong co chua so !!!");
    }
}