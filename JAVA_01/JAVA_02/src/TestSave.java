import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * TestSave
 */
public class TestSave {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hay nhap mot chuoi bat ky: ");
        String chuoi = sc.nextLine();
        System.out.println("Hay nhap dia chi cua duong dan: ");
        String diachi = sc.nextLine();
        try {
            FileOutputStream file = new FileOutputStream(diachi);
            byte b[] = chuoi.getBytes();
            file.write(b);
            file.flush();
            file.close();
            System.out.println("Thanh cong !!!");
        } catch (Exception e) {
            System.out.println("Khong thanh cong !!!");
            e.printStackTrace();
        }
    }
}