import java.util.Scanner;

public class TimRaGiaTriNhoNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap so luong phan tu: ");
        int n = scanner.nextInt();
        int[] giatri = new int[6];
        for (int i = 1; i <= n; i++) {
            System.out.println("Hay nhap vao gia tri thu " + i + ": ");
            giatri[i] = scanner.nextInt();
        }
        int min = n;
        for (int i = 1; i <= n; i++) {
            if (giatri[i] < min)
                min = giatri[i];
        }
        System.out.println("Gia tri nho nhat cua mang ma ban da nhap la: " + min);
    }
}
