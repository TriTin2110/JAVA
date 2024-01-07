import java.util.Scanner;

/**
 * QuanLySinhVien
 */
public class QuanLySinhVien {
    public static void main(String[] args) {
        sinhvien dssv[] = new sinhvien[100];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap so luong sinh vien: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            dssv[i] = new sinhvien();
            scanner.nextLine();
            do {
                System.out.print("\nHay nhap ma so sinh vien cua sinh vien thu " + (i + 1) + ": ");
                dssv[i].masinhvien = scanner.nextInt();
            } while (Character.isDigit(dssv[i].masinhvien));
            scanner.nextLine();
            System.out.print("Hay nhap ten cua sinh vien thu " + (i + 1) + ": ");
            dssv[i].hoten = scanner.nextLine();
            System.out.print("Hay nhap diem trung binh cua sinh vien thu " + (i + 1) + ": ");
            dssv[i].diem = scanner.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dssv[i].diem < dssv[j].diem) {
                    sinhvien temp = dssv[i];
                    dssv[i] = dssv[j];
                    dssv[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dssv[i].diem >= 9)
                dssv[i].xeploai = "Xuat sac";
            else if (dssv[i].diem >= 8)
                dssv[i].xeploai = "Gioi";
            else if (dssv[i].diem >= 7)
                dssv[i].xeploai = "Kha";
            else if (dssv[i].diem >= 6)
                dssv[i].xeploai = "Trung binh kha";
            else if (dssv[i].diem >= 5)
                dssv[i].xeploai = "Trung binh";
            else
                dssv[i].xeploai = "Yeu";
        }
        System.out.println("\nDanh sach sinh vien sau khi duoc sap xep dua theo diem trung binh la:");
        for (int i = 0; i < n; i++) {
            dssv[i].xuat();
        }
    }
}