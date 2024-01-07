import java.util.Scanner;
public class Test2 {
    public static void main(String[] args) {
        Scanner sv = new Scanner(System.in);
        System.out.print("Hay nhap ten cua ban: ");
        String HoVaTen = sv.nextLine();
        System.out.print("Hay nhap tuoi cua ban: ");
        int tuoi = sv.nextInt();
        System.out.print("Hay nhap diem trung binh cua ban: ");
        float DiemTrungBinh = sv.nextFloat();
        System.out.println("\nHo va ten cua ban la: " +HoVaTen);
        System.out.println("Tuoi cua ban la: " +tuoi);
        System.out.println("Diem trung binh cua ban la: " +DiemTrungBinh);
        sv.close();
    }
}
