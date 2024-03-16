package HoaDonCaPhe;

import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;

public class DanhSachHoaDon {
        LinkedList<HoaDon> dshd = new LinkedList<HoaDon>();

        /**
         * themHoaDon(HoaDon hd)
         */
        public void themHoaDon(HoaDon hd) {
                dshd.add(hd);
        }

        public void xuatHoaDon() {
                dshd.forEach(hd -> {
                        String kiemTraGiamGia = hd.kiemTraHoaDonCoDuocGiam(10);
                        System.out.println("Tên của loại cà phê là: " + hd.getTenLoaiCaPhe());
                        System.out.println("Giá của loại cà phê là: " + dinhDangSo(hd.getGiaCaPhe()));
                        System.out.println("Khối lượng mua của hóa đơn là: " + hd.getKhoiLuongMua());
                        System.out.println("Tổng tiền của hóa đơn là: " + dinhDangSo(hd.tinhTongTienHoaDon()));
                        System.out.println("Hóa đơn có được giảm giá không?: " + kiemTraGiamGia);
                        System.out.println("Số tiền hóa đơn sau khi giảm giá là: "
                                        + dinhDangSo(hd.tinhTongTienSauKhiGiamGia(kiemTraGiamGia)));
                        System.out.println();
                });
        }

        /**
         * dinhDangSo()
         */
        public String dinhDangSo(long soTien) {
                Locale locale = new Locale("vi", "Vn");
                NumberFormat numf = NumberFormat.getInstance(locale);
                String giaTienHoaDon = numf.format(soTien) + "đ";
                return giaTienHoaDon;
        }
}
