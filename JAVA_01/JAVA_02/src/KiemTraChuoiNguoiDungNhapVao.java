import java.util.Scanner;

public class KiemTraChuoiNguoiDungNhapVao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap vao 1 chuoi: ");
        String chuoi = scanner.nextLine();
        char mangkytu[] = chuoi.toCharArray();
        int kiemtra = 0;
        if (chuoi.matches("^[A-Z]\\S{0,18}\\d$"))
            kiemtra++;
        if (kiemtra > 0)
            System.out.println("Chuoi ban nhap vao hop le !!!");
        else
            System.out.println("Chuoi ban nhap vao khong hop le !!!");
    }
}
