import java.util.Scanner;

/**
 * ChuongTrinhQuanLySinhVien
 */
public class ChuongTrinhQuanLySinhVien {
    public static void main(String[] args) {
        ThongTinSV sinhvien[] = new ThongTinSV[100];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap so luong sinh vien: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            sinhvien[i] = new ThongTinSV();
            scanner.nextLine();
            System.out.print("Hay nhap ten cua sinh vien thu " + (i + 1) + ": ");
            sinhvien[i].hoten = scanner.nextLine();
            System.out.print("Hay nhap tuoi cua sinh vien thu " + (i + 1) + ": ");
            sinhvien[i].tuoi = scanner.nextInt();
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println("Ho va ten cua sinh vien thu " + (i + 1) + " la: " + sinhvien[i].hoten);
            System.out.println("Tuoi cua sinh vien thu " + (i + 1) + " la: " + sinhvien[i].tuoi);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sinhvien[i].tuoi < sinhvien[j].tuoi) {
                    ThongTinSV temp = sinhvien[i];
                    sinhvien[i] = sinhvien[j];
                    sinhvien[j] = temp;
                }
            }
        }
        System.out.println("\nDanh sach sinh vien sau khi duoc sap xep:");
        for (int i = 0; i < n; i++) {
            System.out.println("Ho va ten cua sinh vien thu " + (i + 1) + " la: " + sinhvien[i].hoten);
            System.out.println("Tuoi cua sinh vien thu " + (i + 1) + " la: " + sinhvien[i].tuoi);
        }
    }
}