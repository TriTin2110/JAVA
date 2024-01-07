import java.util.Scanner;

/**
 * LietKeCacPhanTuCoTrongMang
 */
public class LietKeCacPhanTuCoTrongMang {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap so luong sinh vien ma ban muon nhap vao: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String sinhvien[] = new String[100];
        for (int i = 0; i < n; i++) {
            System.out.print("Hay nhap ten cua sinh vien thu " + i + ": ");
            sinhvien[i] = scanner.nextLine();
        }
        System.out.println("\tDanh sach sinh vien:");
        for (int i = 0; i < n; i++) {
            System.out.print("Ten cua sinh vien thu " + i + ": " + sinhvien[i]);
        }
    }
}