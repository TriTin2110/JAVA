import java.util.Scanner;

public class SapXepTheoThuTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap so luong phan tu co trong mang: ");
        int n = scanner.nextInt();
        int giatri[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Hay nhap vao so thu " + (i + 1) + ": ");
            giatri[i] = scanner.nextInt();
        }
        System.out.println("Day so ma ban da nhap la:");
        for (int i = 0; i < n; i++) {
            System.out.print(giatri[i] + "\t");
        }
        System.out.println("\nDay so sau khi duoc sap xep theo thu tu tu lon -> be la:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (giatri[i] > giatri[j]) {
                    int temp = giatri[i];
                    giatri[i] = giatri[j];
                    giatri[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(giatri[i] + "\t");
        }
        System.out.println("\nDay so sau khi duoc sap xep theo thu tu tu be -> lon la:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (giatri[i] < giatri[j]) {
                    int temp = giatri[i];
                    giatri[i] = giatri[j];
                    giatri[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(giatri[i] + "\t");
        }
    }
}
