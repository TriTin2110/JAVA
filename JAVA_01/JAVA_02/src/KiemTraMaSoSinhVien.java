import java.util.Scanner;

public class KiemTraMaSoSinhVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap ma so sinh vien: B");
        String masosinhvien = scanner.nextLine();
        char kytu;
        int kiemtra = 0;
        for (int i = 0; i < masosinhvien.length(); i++) {
            kytu = masosinhvien.charAt(i);
            if (Character.isLetter(kytu))
                kiemtra++;
        }
        if (kiemtra != 0)
            System.out.println("Ma so sinh vien khong dung theo dinh dang !!!");
        else
            System.out.println("Ma so sinh vien da dung theo dinh dang !!!");
        scanner.close();
    }
}
