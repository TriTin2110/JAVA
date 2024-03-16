package LamLai.DanhSachSinhVien;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MainSinhVien {
        static Scanner sc = new Scanner(System.in);
        static boolean check = true;

        public static void main(String[] args) {
                int choose = 0;

                DanhSachSinhVien danhSachSinhVien = new DanhSachSinhVien();
                do {
                        do {
                                try {
                                        do {
                                                System.out.println("Hãy nhập lựa chọn của bạn:");
                                                System.out.println("1. Thêm sinh viên");
                                                System.out.println("2. In danh sách sinh viên");
                                                System.out.println("3. Kiểm tra danh sách sinh viên có rỗng không");
                                                System.out.println("4. Làm rỗng danh sách sinh viên");
                                                System.out.println("5. Xóa sinh viên theo mã số");
                                                System.out.println("6. Tìm kiếm sinh viên theo mã số");
                                                System.out.println("7. Sắp xếp sinh viên theo tên");
                                                System.out.println("8. Sắp xếp sinh viên theo điểm trung bình");
                                                System.out.print("==> ");
                                                choose = sc.nextInt();
                                                check = true;
                                        } while (choose < 0);
                                } catch (Exception e) {
                                        // TODO: handle exception
                                        System.out.println("Lựa chọn của bạn không hợp lệ!");
                                        check = false;
                                }
                                sc.nextLine();
                        } while (!check);
                        luaChon(choose, danhSachSinhVien);
                } while (choose != 0);
                sc.close();
        }

        static void luaChon(int choose, DanhSachSinhVien danhSachSinhVien) {
                File file = new File("D:/Code/JAVA/VSCode/Data/DanhSachSinhVien.txt");
                if (!file.exists()) {
                        try {
                                file.createNewFile();
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                }
                switch (choose) {
                        case 1: {
                                String tenSinhVien = "";
                                int namSinh = 0, maSoSinhVien = 0;
                                float diemTB = 0;
                                do {
                                        try {
                                                do {
                                                        System.out.println("Hãy nhập mã số sinh viên: ");
                                                        maSoSinhVien = sc.nextInt();
                                                        check = true;
                                                } while (maSoSinhVien < 0);
                                        } catch (Exception e) {
                                                // TODO: handle exception
                                                System.out.println("Mã số sinh viên không hợp lệ!");
                                                check = false;
                                        }
                                        sc.nextLine();
                                } while (!check || danhSachSinhVien.kiemTraMaSoSinhVien(maSoSinhVien));

                                System.out.println("Hãy nhập họ tên của sinh viên: ");
                                tenSinhVien = sc.nextLine();
                                do {
                                        try {
                                                do {
                                                        System.out.println("Hãy nhập năm sinh của sinh viên: ");
                                                        namSinh = sc.nextInt();
                                                        check = true;
                                                } while (namSinh < 0);
                                        } catch (Exception e) {
                                                // TODO: handle exception
                                                System.out.println("Năm sinh của sinh viên không hợp lệ!");
                                                check = false;
                                        }
                                        sc.nextLine();
                                } while (!check);

                                do {
                                        try {
                                                do {
                                                        System.out.println("Hãy nhập điểm của sinh viên: ");
                                                        diemTB = sc.nextFloat();
                                                        check = true;
                                                } while (diemTB < 0 || diemTB > 10);
                                        } catch (Exception e) {
                                                // TODO: handle exception
                                                System.out.println("Điểm của sinh viên không hợp lệ!");
                                                check = false;
                                        }
                                        sc.nextLine();
                                } while (!check);

                                SinhVien sinhVien = new SinhVien(tenSinhVien, maSoSinhVien, namSinh, diemTB);
                                danhSachSinhVien.themSinhVien(sinhVien);
                                break;
                        }

                        case 2:
                                danhSachSinhVien.inDanhSachSinhVien();
                                break;

                        case 3:
                                danhSachSinhVien.kiemTraDanhSachCoRongHayKhong();
                                break;
                        case 4:
                                danhSachSinhVien.lamRongDanhSachSinhVien();
                                break;
                        case 5: {
                                int maSoSinhVien = 0;
                                do {
                                        try {
                                                do {
                                                        System.out.println("Hãy nhập mã số sinh viên: ");
                                                        maSoSinhVien = sc.nextInt();
                                                        check = true;
                                                } while (maSoSinhVien < 0);
                                        } catch (Exception e) {
                                                // TODO: handle exception
                                                System.out.println("Mã số sinh viên không hợp lệ!");
                                                check = false;
                                        }
                                        sc.nextLine();
                                } while (!check);
                                SinhVien sinhVien = new SinhVien(maSoSinhVien);
                                danhSachSinhVien.xoaSinhVienTheoMa(sinhVien);
                                break;
                        }

                        case 6: {
                                int maSoSinhVien = 0;
                                do {
                                        try {
                                                do {
                                                        System.out.println("Hãy nhập mã số sinh viên: ");
                                                        maSoSinhVien = sc.nextInt();
                                                        check = true;
                                                } while (maSoSinhVien < 0);
                                        } catch (Exception e) {
                                                // TODO: handle exception
                                                System.out.println("Mã số sinh viên không hợp lệ!");
                                                check = false;
                                        }
                                        sc.nextLine();
                                } while (!check);
                                SinhVien sinhVien = new SinhVien(maSoSinhVien);
                                danhSachSinhVien.timKiemSinhVienTheoMaSinhVien(sinhVien);
                                break;
                        }

                        case 7:
                                danhSachSinhVien.sapXepSinhVienTheoTen();
                                break;
                        case 8:
                                danhSachSinhVien.sapXepSinhVienTheoDiem();
                                break;
                        case 9:
                                danhSachSinhVien.luuDanhSachSinhVien(file);
                                break;
                        case 10:
                                danhSachSinhVien.docDanhSachSinhVien(file);
                                break;
                }
        }
}
