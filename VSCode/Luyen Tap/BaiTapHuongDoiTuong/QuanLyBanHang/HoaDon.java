package QuanLyBanHang;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.Locale;

public class HoaDon extends SanPham {
        private double giaBan;
        private int soLuongBan;
        static LinkedList<HoaDon> hoaDons = new LinkedList<>();

        private static final int serialVersionUID = 2;

        public HoaDon(String tenSanPham, double giaSanPham, int namSanXuat, double giaBan, int soLuongBan) {
                super(tenSanPham, giaSanPham, namSanXuat);
                this.giaBan = giaBan;
                this.soLuongBan = soLuongBan;
        }

        public double getGiaBan() {
                return giaBan;
        }

        public void setGiaBan(double giaBan) {
                this.giaBan = giaBan;
        }

        public int getSoLuongBan() {
                return soLuongBan;
        }

        public void setSoLuongBan(int soLuongBan) {
                this.soLuongBan = soLuongBan;
        }

        public static void themHoaDon(HoaDon hoaDonMoi) {
                hoaDons.add(hoaDonMoi);
                hoaDonMoi.tinhThanhTien();
                hoaDonMoi.tinhThue();
                hoaDonMoi.tinhLai();
        }

        public static void xuatDanhSachHoaDon() {
                System.out.println("------------------------------------------\n");
                for (int j = 0; j < hoaDons.size(); j++) {
                        System.out.println("Hóa đơn thứ " + (j + 1));
                        System.out.println(hoaDons.get(j).dinhDang() + "\n");
                }
        }

        public String dinhDang() {
                Locale locale = new Locale("vi", "vn");
                NumberFormat nf = NumberFormat.getInstance(locale);
                return "HoaDon [giaBan=" + nf.format(giaBan) + "đ" + ", soLuongBan=" + soLuongBan + ", tongTien="
                                + nf.format(tinhThanhTien()) + "đ"
                                + ", tinhLai=" + nf.format(tinhLai()) + "đ" + ", tinhThue=" + nf.format(tinhThue())
                                + "đ" + "]\n"
                                + super.dinhDang();
        }

        public double tinhThanhTien() {
                return this.getSoLuongBan() * this.getGiaBan();
        }

        public double tinhThue() {
                return this.tinhThanhTien() * 0.1;
        }

        public double tinhLai() {
                return (this.getGiaBan() - this.getGiaSanPham()) * this.getSoLuongBan();
        }

        public static double tongTienCuaCacHoaDon() {
                double tongTien = 0;
                for (HoaDon hoaDon : hoaDons) {
                        tongTien += hoaDon.tinhThanhTien();
                }
                return tongTien;
        }

        public static void luuDanhSachHoaDon() {
                File file = new File(System.getProperty("user.dir") + "\\BaiTapHuongDoiTuong\\QuanLyBanHang",
                                "test.txt");
                if (!file.exists()) {
                        try {
                                file.createNewFile();
                        } catch (Exception e) {
                                // TODO: handle exception
                                e.printStackTrace();
                        }
                }

                try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(hoaDons);
                        oos.flush();
                        oos.close();
                } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                }
        }

        public static void docFile() {
                File file = new File(System.getProperty("user.dir") + "\\BaiTapHuongDoiTuong\\QuanLyBanHang",
                                "test.txt");
                try {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                        while (true) {
                                hoaDons = (LinkedList<HoaDon>) ois.readObject();
                                if (hoaDons == null)
                                        break;
                        }
                        ois.close();
                } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("Đã đọc file thành công!");
                }
        }
}
