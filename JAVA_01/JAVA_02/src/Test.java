import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Test {
    /**
     * ThongTinSV
     */
    public class ThongTinSV {
        String hoten;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Path path = Path.of("ListSV.txt");
            List<String> listsinhvien = Files.readAllLines(path);
            while (true) {
                System.out.print("Hay nhap ten sinh vien: ");
                String search = scanner.nextLine();
                System.out.format("%-18s%-3s\n", "Ho ten", "Tuoi");
                for (String sinhviendata : listsinhvien) {
                    String[] data = sinhviendata.split(",");
                    ThongTinSinhVien sv = new ThongTinSinhVien();
                    sv.hoten = data[0];
                    sv.tuoi = Integer.valueOf(data[1]);
                    if (sv.hoten.contains(search)) {
                        System.out.format("%-18s%-3s\n", sv.hoten, sv.tuoi);
                    }
                }
                System.out.println("---------------------------------------------------\n");
            }
        } catch (Exception e) {
        }
    }
}
