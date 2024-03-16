import java.util.Scanner;

public class InHoaKyTuDauTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hay nhap 1 chuoi bat ky: ");
        String chuoi = scanner.nextLine();
        char mangkytu[] = chuoi.toCharArray();
        for (int i = 0; i < chuoi.length(); i++) {
            if (mangkytu[0] >= 'a' && mangkytu[0] <= 'z')
                mangkytu[0] = Character.toUpperCase(mangkytu[0]);
            else if (mangkytu[i] == ' ' && mangkytu[i + 1] != ' ' && mangkytu[i + 1] >= 'a' && mangkytu[i + 1] <= 'z') {
                mangkytu[i + 1] = Character.toUpperCase(mangkytu[i + 1]);
            }
            System.out.print(mangkytu[i]);
        }
    }
}
