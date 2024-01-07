import java.util.Scanner;

/**
 * DanhSachSinhVien
 */
public class DanhSachSinhVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinhVien dssv[] = new SinhVien[100];
        System.out.print("Hay nhap so luong sinh vien co trong danh sach: ");
        int n = scanner.nextInt();
        int kiemtra = 0;
        for (int i = 0; i < n; i++) {
            dssv[i] = new SinhVien();
            scanner.nextLine();
            do {
                kiemtra = 0;
                System.out.print("\nHay nhap ho ten cua sinh vien thu " + (i + 1) + ": ");
                dssv[i].hoten = scanner.nextLine();
                if (dssv[i].hoten.matches(".*[0-9]"))
                    kiemtra++;
            } while (kiemtra > 0);
            do {
                kiemtra = 0;
                System.out.print("Hay nhap ma so cua sinh vien thu " + (i + 1) + ": ");
                dssv[i].masosinhvien = scanner.nextLine();
                if (dssv[i].masosinhvien.length() != 8)
                    kiemtra++;
            } while (kiemtra > 0);
            do {
                kiemtra = 0;
                System.out.print("Hay nhap diem thu nhat cua sinh vien " + (i + 1) + ": ");
                dssv[i].diem1 = scanner.nextFloat();
                if (dssv[i].diem1 > 10 || dssv[i].diem1 < 0)
                    kiemtra++;
            } while (kiemtra > 0);
            do {
                kiemtra = 0;
                System.out.print("Hay nhap diem thu hai cua sinh vien " + (i + 1) + ": ");
                dssv[i].diem2 = scanner.nextFloat();
                if (dssv[i].diem2 > 10 || dssv[i].diem2 < 0)
                    kiemtra++;
            } while (kiemtra > 0);
            do {
                kiemtra = 0;
                System.out.print("Hay nhap diem thu ba cua sinh vien " + (i + 1) + ": ");
                dssv[i].diem3 = scanner.nextFloat();
                if (dssv[i].diem3 > 10 || dssv[i].diem3 < 0)
                    kiemtra++;
            } while (kiemtra > 0);
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            dssv[i].tinhdiemtrungbinh(dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb);
            for (int j = i; j < n; j++) {
                dssv[j].tinhdiemtrungbinh(dssv[j].diem1, dssv[j].diem2, dssv[j].diem3,
                        dssv[j].diemtb);
                if (dssv[j].diemtb < dssv[i].diemtb) {
                    SinhVien temp = dssv[i];
                    dssv[i] = dssv[j];
                    dssv[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("\nThong tin cua sinh vien thu " + (i + 1) + " la:");
            dssv[i].xuat();
            dssv[i].XuatDiemTrungBinh(dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb);
            dssv[i].xeploai(dssv[i].diemtb);
        }
        System.out.println(
                ".______________________________________________________________________________________________________.");
        System.out.printf("|%5s  |%9s |%29s |%7s |%7s |%7s|%8s |%12s    |", "STT", "MSSV", "Ho va ten", "Diem 1",
                "Diem 2",
                "Diem 3", "Diem TB", "Xep loai");
        System.out.print(
                "\n|_______|__________|______________________________|________|________|_______|_________|________________|");
        for (int i = 0; i < n; i++) {
            System.out.printf("\n|%4d   |%10s|%30s|%6.2f  |%6.2f  |%6.2f |%6.2f   |%16s|", (i + 1),
                    dssv[i].masosinhvien,
                    dssv[i].hoten, dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb, dssv[i].XepLoai);
        }
        System.out.println(
                "\n'-------------------------------------------------------------------------------------------------------'");
    }
}