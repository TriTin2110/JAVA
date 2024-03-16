import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * DocFile
 */
public class DocFile {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hay nhap dia chi cua file: ");
        String diachi = sc.nextLine();
        try {
            FileInputStream docfile = new FileInputStream(diachi);
            Scanner doc = new Scanner(docfile);
            while (doc.hasNextLine()) {
                String noidung = doc.nextLine();
                System.out.print(noidung);
            }
            docfile.close();
        } catch (Exception e) {
            System.out.println("Khong tim thay file !!!");
            e.printStackTrace();
        }
    }
}