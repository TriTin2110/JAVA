import java.util.Scanner;

/**
 * QuanLySinhVien
 */
public class QuanLySinhVien {
    public static void main(String[] args) {
        ThongTinSinhVien dssv[] = new ThongTinSinhVien[100];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap so luong sinh vien co trong danh sach: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            dssv[i] = new ThongTinSinhVien();
            scanner.nextLine();
            System.out.print("Hay ten cua sinh vien thu " + (i + 1) + ": ");
            dssv[i].hoten = scanner.nextLine();
            System.out.print("Hay nhap ma so sinh vien cua sinh vien thu " + (i + 1) + ": ");
            dssv[i].masinhvien = scanner.nextInt();
            System.out.print("Hay nhap diem thu nhat cua sinh vien thu " + (i + 1) + ": ");
            dssv[i].diem1 = scanner.nextInt();
            System.out.print("Hay nhap diem thu hai cua sinh vien thu " + (i + 1) + ": ");
            dssv[i].diem2 = scanner.nextInt();
            System.out.print("Hay nhap diem thu ba cua sinh vien thu " + (i + 1) + ": ");
            dssv[i].diem3 = scanner.nextInt();
        }
        System.out.println("._________________________________________________________________________.");
        System.out.printf("|  %s  | %17s | %20s | %s |%14s |", "STT", "MA SINH VIEN", "HO TEN", "DIEM", "XEPLOAI");
        System.out.println("\n|_______|___________________|______________________|______|_______________|");
        for (int i = 0; i < n; i++) {
            dssv[i].tinhdiemtrungbinh();
            dssv[i].xeploai();
            System.out.printf("\n|   %d   |%19d|%22s|%6.1f|%15s|", (i + 1), dssv[i].masinhvien, dssv[i].hoten,
                    dssv[i].diemtrungbinh, dssv[i].xeploai);
        }
        System.out.println("\n|-------------------------------------------------------------------------|");
    }
}