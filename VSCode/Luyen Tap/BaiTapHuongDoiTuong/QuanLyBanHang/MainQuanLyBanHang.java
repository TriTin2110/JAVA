package QuanLyBanHang;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class MainQuanLyBanHang {
        static Scanner sc = new Scanner(System.in);
        static boolean check = true;

        public static void main(String[] args) {
                HoaDon.docFile();
                int choose = 0;
                HoaDon hoaDon = null;
                do {
                        try {
                                System.out.println("1. Thêm hóa đơn");
                                System.out.println("2. Xuất hóa đơn");
                                System.out.println("3. Xuất tổng tiền của các hóa đơn");
                                System.out.println("4. Lưu hóa đơn");
                                System.out.println("Hãy nhập lựa chọn của bạn: ");
                                System.out.print("==> ");
                                choose = sc.nextInt();
                                check = true;
                        } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("Lựa chọn của bạn không hợp lệ!");
                                check = false;
                        }
                        sc.nextLine();
                        if (check)
                                xuLyLuaChon(choose, hoaDon);
                } while (choose != 0 || !check);
        }

        public static void xuLyLuaChon(int choose, HoaDon hoaDon) {
                switch (choose) {
                        case 1:
                                themHoaDon(hoaDon);
                                break;

                        case 2:
                                HoaDon.xuatDanhSachHoaDon();
                                break;
                        case 3:
                                System.out.println("Tổng tiền của các hóa đơn là: "
                                                + NumberFormat.getInstance(new Locale("vi", "vn"))
                                                                .format(HoaDon.tongTienCuaCacHoaDon())
                                                + "đ");
                                break;
                        case 4:
                                HoaDon.luuDanhSachHoaDon();
                                break;
                }
        }

        public static void themHoaDon(HoaDon hoaDon) {
                String tenSanPham;
                double giaBan = 0, giaSanPham = 0;
                int soLuongBan = 0, namSanXuat = 0;
                System.out.println("Hãy nhập tên sản phẩm: ");
                tenSanPham = sc.nextLine();

                do {
                        try {
                                System.out.println("Hãy nhập giá của sản phẩm: ");
                                giaSanPham = sc.nextDouble();
                                check = true;
                        } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("Giá của sản phẩm không hợp lệ!");
                                check = false;
                        }
                        sc.nextLine();
                } while (!check);

                // NHẬP NĂM SẢN XUẤT CỦA SẢN PHẨM
                do {
                        try {
                                System.out.println("Hãy nhập năm sản xuất của sản phẩm: ");
                                namSanXuat = sc.nextInt();
                                check = true;
                        } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("Năm sản xuất của sản phẩm không hợp lệ!");
                                check = false;
                        }
                        sc.nextLine();
                } while (!check);

                // NHẬP GIÁ BÁN CỦA SẢN PHẨM
                do {
                        try {
                                System.out.println("Hãy nhập giá bán của sản phẩm: ");
                                giaBan = sc.nextDouble();
                                check = true;
                        } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("Giá bán của sản phẩm không hợp lệ!");
                                check = false;
                        }
                        sc.nextLine();
                } while (!check);

                // NHẬP SỐ LƯỢNG BÁN CỦA SẢN PHẨM
                do {
                        try {
                                System.out.println("Hãy nhập số lượng bán của sản phẩm: ");
                                soLuongBan = sc.nextInt();
                                check = true;
                        } catch (Exception e) {
                                // TODO: handle exception
                                System.out.println("Số lượng bán của sản phẩm không hợp lệ!");
                                check = false;
                        }
                        sc.nextLine();
                } while (!check);
                hoaDon = new HoaDon(tenSanPham, giaSanPham, namSanXuat, giaBan, soLuongBan);
                HoaDon.themHoaDon(hoaDon);
        }

}
