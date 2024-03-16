import java.util.Scanner;

public class XuatGiaTriLonVaNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap so phan tu ma ban muon so sanh: ");
        int n = scanner.nextInt();
        int giatri[] = new int[n + 1];
        int min = 0;
        float giatritrungbinhcong = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Hay nhap phan tu thu " + i + ": ");
            giatri[i] = scanner.nextInt();
            min = giatri[1];
            giatritrungbinhcong += giatri[i];
        }
        System.out.println("Gia tri trung binh cong cua " + n + " so ban vua nhap la: " + giatritrungbinhcong / n);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (giatri[i] > max)
                max = giatri[i];
        }
        System.out.print("\nGia tri lon nhat co trong mang la: " + max);
        for (int i = 1; i <= n; i++) {
            if (giatri[i] < min)
                min = giatri[i];
        }
        System.out.print("\nGia tri nho nhat co trong mang la: " + min);

    }
}
