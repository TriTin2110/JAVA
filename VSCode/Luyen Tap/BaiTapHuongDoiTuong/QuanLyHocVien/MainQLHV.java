package QuanLyHocVien;

import java.sql.Date;
import java.util.Random;
import java.util.Scanner;

public class MainQLHV {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                // System.out.println("Hãy nhập số lượng học viên: ");
                int n = 100;
                char c = 'A';
                String ten = "";
                Classroom classroom1 = new Classroom(1, 1, n - 1, 100000, new Date(System.currentTimeMillis()));
                out: for (int i = 0; i < n; i++) {
                        classroom1.themHocVien(new HocVien((i + 1), "Nguyễn Văn " + ten + c, "HCM",
                                        // Tạo random SĐT từ 9 đến (9999+9)
                                        new Random().nextLong(10000) + 9));
                        if (c == 'Z') {
                                c = 'a';
                                i++;
                                continue out;
                        }
                        c++;
                }

                // classroom1.sapXepDanhSachLopTheoTen();
                System.out.println(classroom1.soLuongHocVien());
                System.out.println(classroom1.tinhTongChiPhiLopHoc());
                classroom1.inDanhSachHocVien();
        }
}
