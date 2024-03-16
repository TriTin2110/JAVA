import java.util.Scanner;

/**
 * TimChuCaiCoTrongChuoiVaChuaChuoiCon
 */
public class TimChuCaiCoTrongChuoiVaChuaChuoiCon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap 1 chuoi bat ky: ");
        String chuoi = scanner.nextLine();
        int demChuCai = 0;
        for (int i = 0; i < chuoi.length(); i++) {
            if (chuoi.charAt(i) >= 'a' && chuoi.charAt(i) <= 'z' || chuoi.charAt(i) >= 'A' && chuoi.charAt(i) <= 'Z')
                demChuCai++;
        }
        System.out.println("Tong so chu cai trong chuoi la: " + demChuCai);
        System.out.println("Hay nhap 1 chuoi bat ky: ");
        String chuoi1 = scanner.nextLine();
        if (chuoi.matches(chuoi1))
            System.out.println("Chuoi truoc chua chuoi sau !!!");
        else
            System.out.println("Chuoi truoc khong chua chuoi sau !!!");
        scanner.close();
    }
}