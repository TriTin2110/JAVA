import java.util.Scanner;

/**
 * SapXepGiamDan
 */
public class SapXepGiamDan {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap so luong phan tu co trong mang: ");
        int n = scanner.nextInt();
        int giatri[] = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            System.out.print("Hay nhap gia tri cua phan tu thu " + i + ": ");
            giatri[i] = scanner.nextInt();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                int temp;
                if (giatri[j] < giatri[j + 1]) {
                    temp = giatri[j];
                    giatri[j] = giatri[j + 1];
                    giatri[j + 1] = temp;
                }
            }
        }
        System.out.println("Gia tri cua mang sau khi duoc sap xep la");
        for (int i = 1; i <= n; i++) {
            System.out.print(giatri[i] + " ");
        }
    }
}
