import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * TimKiemThemVaXoaPhanTuTrongMang
 */
public class TimKiemThemVaXoaPhanTuTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap so luong sinh vien: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String sinhvien[] = new String[100];
        for (int i = 0; i < n; i++) {
            System.out.println("Hay nhap ho ten cua sinh vien thu " + (i + 1) + ": ");
            sinhvien[i] = scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            char array[] = sinhvien[i].toCharArray();
            for (int j = 0; j < sinhvien[i].length(); j++) {
                array[0] = Character.toUpperCase(array[0]);
                if (array[j] == ' ' && array[j + 1] != ' ')
                    array[j + 1] = Character.toUpperCase(array[j + 1]);
            }
            sinhvien[i] = String.valueOf(array);
        }
        System.out.println("._________________________.");
        System.out.println("|    Danh sach sinh vien  |");
        System.out.println("|-------------------------|");
        int STT = 1;
        for (int i = 0; i < n; i++) {
            System.out.printf("|  %d  | %17s |", STT, sinhvien[i]);
            STT++;
            System.out.println();
        }
        System.out.println("|_________________________|");
        System.out.println("Hay nhap ten sinh vien ma ban muon tim kiem: ");
        String ten = scanner.nextLine();
        int kiemtra = 0;
        for (int i = 0; i < n; i++) {
            if (sinhvien[i].matches(ten)) {
                System.out.println("Sinh vien " + ten + " ton tai trong danh sach");
                kiemtra++;
            }
        }
        if (kiemtra == 0)
            System.out.println("Sinh vien " + ten + " khong ton tai trong danh sach !!!");
        System.out.println("Nhap ten sinh vien ma ban muon them vao danh sach: ");
        sinhvien[n] = scanner.nextLine();
        STT = 1;
        for (int i = 0; i < n; i++) {
            char array[] = sinhvien[i].toCharArray();
            for (int j = 0; j < sinhvien[i].length(); j++) {
                array[0] = Character.toUpperCase(array[0]);
                if (array[j] == ' ' && array[j + 1] != ' ')
                    array[j + 1] = Character.toUpperCase(array[j + 1]);
            }
            sinhvien[i] = String.valueOf(array);
        }
        System.out.println("._________________________.");
        System.out.println("|    Danh sach sinh vien  |");
        System.out.println("|-------------------------|");
        for (int i = 0; i <= n; i++) {
            System.out.printf("|  %d  | %17s |", STT, sinhvien[i]);
            STT++;
            System.out.println();
        }
        System.out.println("|_________________________|");
        System.out.println("Hay nhap ten sinh vien ma ban muon xoa ra khoi danh sach: ");
        String tenmuonxoa = scanner.nextLine();
        for (int i = 0; i <= n; i++) {
            if (sinhvien[i].matches(tenmuonxoa)) {
                for (int j = i; j < n; j++) {
                    sinhvien[j] = sinhvien[j + 1];
                }
                n--;
            }
        }
        STT = 1;
        for (int i = 0; i < n; i++) {
            char array[] = sinhvien[i].toCharArray();
            for (int j = 0; j < sinhvien[i].length(); j++) {
                array[0] = Character.toUpperCase(array[0]);
                if (array[j] == ' ' && array[j + 1] != ' ')
                    array[j + 1] = Character.toUpperCase(array[j + 1]);
            }
            sinhvien[i] = String.valueOf(array);
        }
        System.out.println("._________________________.");
        System.out.println("|    Danh sach sinh vien  |");
        System.out.println("|-------------------------|");
        for (int i = 0; i <= n; i++) {
            System.out.printf("|  %d  | %17s |", STT, sinhvien[i]);
            STT++;
            System.out.println();
        }
        System.out.println("|_________________________|");
    }
}