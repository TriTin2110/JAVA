import java.util.Scanner;

/**
 * Hay cho biet danh sach co phai la cap so cong hay khong
 */
public class cauF {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Hay nhap so luong phan tu co trong danh sach: ");
                int n = sc.nextInt();
                int soNguyen[] = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                        System.out.print("Hay nhap gia tri cua so nguyen thu " + i + ": ");
                        soNguyen[i] = sc.nextInt();
                }
                int ketQua = 0;
                int congSai = soNguyen[2] - soNguyen[1];
                for (int i = 1; i <= n; i++) {
                        if (soNguyen[i] != soNguyen[1] + (i - 1) * congSai)
                                ketQua++;
                }
                if (ketQua == 0)
                        System.out.println("Mang la cap so cong");
                else
                        System.out.println("Mang khong la cap so cong");
        }
}