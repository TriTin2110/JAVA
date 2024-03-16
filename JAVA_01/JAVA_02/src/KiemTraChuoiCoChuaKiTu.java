import java.util.Scanner;

public class KiemTraChuoiCoChuaKiTu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hay nhap 1 chuoi: ");
        String chuoi = scanner.nextLine();
        System.out.print("Hay nhap 1 ky tu bat ky: ");
        char kytu = scanner.next().charAt(0);
        int kiemtra = 0;
        for (int i = 0; i < chuoi.length(); i++) {
            if (kytu == chuoi.charAt(i))
                kiemtra++;
        }
        if (kiemtra != 0)
            System.out.println("Chuoi co chua ky tu ma ban vua nhap vao !!!");
        else
            System.out.println("Chuoi khong co chua ky tu ma ban vua nhap vao !!!");
    }
}
