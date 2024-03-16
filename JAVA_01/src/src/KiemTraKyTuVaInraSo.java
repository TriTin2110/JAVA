import java.util.Scanner;

/**
 * KiemTraKyTuVaInraSo
 */
public class KiemTraKyTuVaInraSo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap vao 1 chuoi: ");
        String chuoi = scanner.nextLine();
        System.out.println("Hay nhap 1 ky tu bat ky: ");
        char kytu = scanner.next().charAt(0);
        int kiemtra = 0;
        for (int i = 0; i < chuoi.length(); i++) {
            if (kytu == chuoi.charAt(i)) {
                if (kiemtra == 0)
                    System.out.printf("Ky tu %c nam o vi tri thu %d", kytu, i);
                else
                    System.out.printf(", vi tri thu %d", i);
                kiemtra++;
            }
        }
        if (kiemtra == 0)
            System.out.println("Khong ton tai trong chuoi !!!");
    }
}