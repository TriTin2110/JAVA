package HoaDonCaPhe;

import java.util.Scanner;

public class MainHoaDon {
        static Scanner sc = new Scanner(System.in);
        static boolean kiemTraDuLieu = true;

        public static void main(String[] args) {
                DanhSachHoaDon dshd = new DanhSachHoaDon();
                int luaChon = 0;
                do {
                        System.out.println("1. Thêm hóa đơn mới");
                        System.out.println("2. In danh sách hóa đơn");
                        System.out.println("0. Thoát");
                        luaChon = luaChon(dshd);
                } while (luaChon != 0);

        }

        /**
         * luaChon(int luaChon)
         */
        public static int luaChon(DanhSachHoaDon dshd) {
                int luaChon = 0;
                do {
                        try {
                                System.out.println("Hãy nhập lựa chọn của bạn: ");
                                luaChon = sc.nextInt();
                                kiemTraDuLieu = true;
                        } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("Lựa chọn không hợp lệ!");
                                kiemTraDuLieu = false;
                        }
                        sc.nextLine();
                } while (!kiemTraDuLieu);

                // Xử lý lựa chọn
                switch (luaChon) {
                        case 1:
                                int soLuongHoaDon = nhapSoLuongHoaDon();
                                nhapHoaDon(dshd, soLuongHoaDon);
                                break;

                        case 2:
                                dshd.xuatHoaDon();
                                break;
                }
                return luaChon;
        }

        /**
         * nhapSoLuongHoaDon()
         */
        public static int nhapSoLuongHoaDon() {
                int soLuongHoaDon = 0;
                do {
                        try {
                                do {
                                        System.out.println("Hãy nhập số lượng hóa đơn cà phê: ");
                                        soLuongHoaDon = sc.nextInt();
                                } while (soLuongHoaDon < 1);
                                kiemTraDuLieu = true;
                        } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("Số lượng hóa đơn không hợp lệ!");
                                kiemTraDuLieu = false;
                        }
                        sc.nextLine();
                } while (!kiemTraDuLieu);
                return soLuongHoaDon;
        }

        /**
         * nhapHoaDon()
         */
        public static void nhapHoaDon(DanhSachHoaDon dshd, int soLuongHoaDon) {
                String tenLoaiCaPhe = "";
                double khoiLuongMua = 0;
                long giaCaPhe = 0;
                for (int i = 0; i < soLuongHoaDon; i++) {
                        System.out.print("Hãy nhập tên loại cà phê: ");
                        tenLoaiCaPhe = sc.nextLine();
                        do {
                                try {
                                        System.out.print("Hãy nhập giá của loại cà phê: ");
                                        giaCaPhe = sc.nextLong();
                                        kiemTraDuLieu = true;
                                } catch (Exception e) {
                                        // TODO: handle exception
                                        System.out.println("Giá của loại cà phê không hợp lệ!");
                                        kiemTraDuLieu = false;
                                }
                                sc.nextLine();
                        } while (!kiemTraDuLieu);
                        do {
                                try {
                                        System.out.print("Hãy nhập khối lượng mua của hóa đơn: ");
                                        khoiLuongMua = sc.nextDouble();
                                        kiemTraDuLieu = true;
                                } catch (Exception e) {
                                        // TODO: handle exception
                                        System.out.println("Khối lượng mua của hóa đơn không hợp lệ!");
                                        kiemTraDuLieu = false;
                                }
                                sc.nextLine();
                        } while (!kiemTraDuLieu);
                        HoaDon hd = new HoaDon(tenLoaiCaPhe, khoiLuongMua, giaCaPhe);
                        dshd.themHoaDon(hd);
                }

        }
}
