package QuanLyKhachSan;

import java.util.Scanner;

public class MainQLKS {
        static Scanner sc = new Scanner(System.in);
        static boolean check = true;
        private static QLKS qlks = new QLKS();

        public static void main(String[] args) {
                qlks.docFile();
                int luaChon = 0;
                do {
                        do {
                                System.out.println("1. Thêm khách");
                                System.out.println("2. Hiển thị danh sách khách hàng");
                                System.out.println("3. Xóa khách");
                                System.out.println("4. Lưu danh sách khách hàng");
                                System.out.println("0. Thoát");
                                try {
                                        System.out.print("==> ");
                                        luaChon = sc.nextInt();
                                        check = true;
                                } catch (Exception e) {
                                        // TODO: handle exception
                                        System.out.println("Lựa chọn không hợp lệ!");
                                        check = false;
                                }
                                sc.nextLine();
                        } while (!check);
                        xuLyLuaChon(luaChon);
                } while (luaChon != 0);
        }

        public static void xuLyLuaChon(int luaChon) {
                switch (luaChon) {
                        case 1:
                                themKhach();
                                break;
                        case 2:
                                qlks.hienThiDanhSachKhachSan();
                                break;
                        case 3:
                                xoaKhach();
                                break;
                        case 4:
                                qlks.luuFile();
                                break;
                }
        }

        public static void themKhach() {
                String hoTen, loaiPhong;
                KhachSan khachSan = null;
                int tuoi = 0, CMND = 0, soNgayThue = 0;
                System.out.println("Hãy nhập tên của khách hàng: ");
                hoTen = sc.nextLine();

                // NHẬP TUỔI
                do {
                        try {
                                System.out.println("Hãy nhập tuổi của khách hàng: ");
                                tuoi = sc.nextInt();
                                check = true;
                        } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("Tuổi của khách hàng không hợp lệ!");
                                check = false;
                        }
                        sc.nextLine();
                } while (!check || tuoi < 0 || tuoi > 100);

                do {
                        try {
                                System.out.println("Hãy nhập CMND của khách hàng: ");
                                CMND = sc.nextInt();
                                check = true;
                        } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("CMND của khách hàng không hợp lệ!");
                                check = false;
                        }
                        if (qlks.locCMND(CMND) != null) {
                                System.out.println("CMND đã có trong danh sách");
                                check = false;
                        }
                        sc.nextLine();
                } while (!check || CMND < 0);
                Nguoi ng = new Nguoi(hoTen, tuoi, CMND);

                do {
                        try {
                                System.out.println("Hãy nhập số ngày thuê: ");
                                soNgayThue = sc.nextInt();
                                check = true;
                        } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("Số ngày thuê của khách hàng không hợp lệ!");
                                check = false;
                        }
                        sc.nextLine();
                } while (!check || soNgayThue < 0);

                String lp = "";
                do {
                        System.out.println("Hãy nhập loại phòng: ");
                        loaiPhong = sc.nextLine();
                        lp = qlks.locPhong(loaiPhong);
                } while (lp == null);
                khachSan = new KhachSan(soNgayThue, lp, ng);
                qlks.themKhach(khachSan);
        }

        public static void xoaKhach() {
                int CMND = 0;
                do {
                        try {
                                System.out.println("Hãy nhập CMND của khách hàng cần xóa: ");
                                CMND = sc.nextInt();
                                check = true;
                        } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("CMND của khách hàng không hợp lệ!");
                                check = false;
                        }
                        sc.nextLine();
                } while (!check || CMND < 0);
                if (qlks.xoaKhach(CMND))
                        System.out.println("Đã xóa thành công!");
                else
                        System.out.println("Không tìm thấy khách hàng trong danh sách!");
        }
}
