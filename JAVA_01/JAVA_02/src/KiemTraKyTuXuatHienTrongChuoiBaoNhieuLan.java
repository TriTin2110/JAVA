import java.util.Scanner;

public class KiemTraKyTuXuatHienTrongChuoiBaoNhieuLan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap vao 1 chuoi bat ky: ");
        String chuoi = scanner.nextLine();
        char mangkytu[] = chuoi.toCharArray();
        int kiemtra = 0;
        int dem = 0;
        for (int i = 0; i < chuoi.length(); i++) {
            if (mangkytu[i] == 'a') {
                kiemtra++;
                dem++;
            }
        }
        if (kiemtra > 0)
            System.out.printf("Ky tua a xuat hien %d lan", dem);
        else
            System.out.println("Chuoi khong chua ky tu a");
    }
}
