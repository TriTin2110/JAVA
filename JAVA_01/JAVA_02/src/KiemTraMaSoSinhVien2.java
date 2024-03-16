import java.util.Scanner;

public class KiemTraMaSoSinhVien2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String MSSV[] = new String[6];
        for (int i = 1; i <= 5; i++) {
            System.out.print("Hay nhap ma so sinh vien cua sinh vien thu " + i + ": ");
            MSSV[i] = scanner.nextLine();
        }
        for (int i = 1; i <= 5; i++) {
            if (!MSSV[i].matches("00[2-5]L[0-9]{4}"))
                System.out.println("Ma so sinh vien thu " + i + " khong dung dinh dang !!!");
            else
                System.out.println("Ma so sinh vien thu " + i + " dung voi dinh dang !!!");
        }
        scanner.close();
    }
}
