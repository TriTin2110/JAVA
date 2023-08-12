import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập số lượng hóa đơn: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Số lượng hóa đơn không hợp lệ!");
                        return;
                }
                sc.nextLine();
                String tenLoaiCaPhe = "";
                double gia, khoiLuong;
                HoaDon[] hd = new HoaDon[n];
                for (int i = 0; i < hd.length; i++) {
                        System.out.println("Hãy nhập tên loại cà phê của hóa đơn thứ " + (i + 1) + ": ");
                        tenLoaiCaPhe = sc.nextLine();

                        try {
                                do {
                                        System.out.println("Hãy nhập giá của loại cà phê " + tenLoaiCaPhe + "/kg: ");
                                        gia = sc.nextDouble();
                                } while (gia < 1);
                        } catch (Exception e) {
                                System.out.println("Giá của loại cà phê không hợp lệ!");
                                return;
                        }

                        try {
                                do {
                                        System.out.println("Hãy nhập khối lượng mua của hóa đơn thứ " + (i + 1) + ": ");
                                        khoiLuong = sc.nextDouble();
                                } while (khoiLuong < 1);
                        } catch (Exception e) {
                                System.out.println("Giá của loại cà phê không hợp lệ!");
                                return;
                        }
                        hd[i] = new HoaDon(tenLoaiCaPhe, gia, khoiLuong);
                        sc.nextLine();
                        System.out.println("\n----------------------------");
                }
                inThongTinCuaHoaDon(hd);
                sc.close();
        }

        /**
         * InnerMain
         */
        public static void inThongTinCuaHoaDon(HoaDon[] hd) {
                double khoiLuongTonKho = 5;
                double giamGia = 50000;
                double phanTram = 10;
                for (int i = 0; i < hd.length; i++) {
                        System.out.println("Thông tin của hóa đơn thứ " + (i + 1) + " là:");
                        System.out.println("Tên loại cà phê: " + hd[i].getTenLoaiCaPhe());
                        System.out.println("Giá của loại cà phê: " + hd[i].getGia() + "/kg");
                        System.out.println("Khối lương mua của hóa đơn: " + hd[i].getKhoiLuong());
                        System.out.println("Tổng tiền của hóa đơn là: " + hd[i].tinhTongTien());
                        System.out.println("Khối lượng mua của hóa đơn có lớn hơn khối lưng tồn kho không?: "
                                        + hd[i].kiemTraLuongTonKho(khoiLuongTonKho));
                        System.out.println("Hóa đơn có được giảm giá không?: "
                                        + hd[i].kiemTraHoaDonCoDuocGiamGia(giamGia));
                        System.out.println(
                                        "Số tiên được giảm giá của hóa đơn là: " + hd[i].tinhSoTienDuocGiam(phanTram));
                        System.out.println("Tổng tiền sau khi được giảm giá là: "
                                        + hd[i].tinhTongTienSauKhiDuocGiam());
                        System.out.println("\n------------------------\n");
                }

        }
}
