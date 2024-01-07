import java.util.Scanner;

public class XoaKhoangTrang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap 1 chuoi bat ky: ");
        String chuoi = scanner.nextLine();
        chuoi = chuoi.replaceAll(" ", "");
        System.out.println(chuoi);
    }
}
