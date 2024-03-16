package QuanLyBanHang;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;

public class SanPham implements Serializable {
        private String tenSanPham;
        private double giaSanPham;
        private int namSanXuat;
        private LinkedList<SanPham> sanPham;
        private static final int serialVersionUID = 1;

        public SanPham(String tenSanPham, double giaSanPham, int namSanXuat) {
                this.tenSanPham = tenSanPham;
                this.giaSanPham = giaSanPham;
                this.namSanXuat = namSanXuat;
                sanPham = new LinkedList<>();
        }

        public String getTenSanPham() {
                return tenSanPham;
        }

        public void setTenSanPham(String tenSanPham) {
                this.tenSanPham = tenSanPham;
        }

        public double getGiaSanPham() {
                return giaSanPham;
        }

        public void setGiaSanPham(double giaSanPham) {
                this.giaSanPham = giaSanPham;
        }

        public int getNamSanXuat() {
                return namSanXuat;
        }

        public void setNamSanXuat(int namSanXuat) {
                this.namSanXuat = namSanXuat;
        }

        public void nhapThongTinSanPham(SanPham sanPhamMoi) {
                this.sanPham.add(sanPhamMoi);
        }

        public void xuatSanPham() {
                this.sanPham.forEach(sp -> System.out.println(sp.toString()));
        }

        public String dinhDang() {
                Locale locale = new Locale("vi", "vn");
                return "SanPham [tenSanPham=" + tenSanPham + ", giaSanPham="
                                + NumberFormat.getInstance(locale).format(giaSanPham) + "đ" + ", namSanXuat="
                                + namSanXuat
                                + "]";
        }

}
