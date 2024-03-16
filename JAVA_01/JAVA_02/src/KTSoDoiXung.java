import java.util.Scanner;

public class KTSoDoiXung {
    public static void main(String[] args) {
        int ketqua = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap 1 so bat ky: ");
        int n = scanner.nextInt();
        int ketqua1 = n;
        while (n != 0) {
            int daonguoc = n % 10;
            ketqua = ketqua * 10 + daonguoc;
            n /= 10;
        }
        if (ketqua1 == ketqua)
            System.out.println("So ban vua nhap la so doi xung !!!");
        else
            System.out.println("So ban vua nhap khong doi xung !!!");
    }
}
