package QuanLyKhachSan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class QLKS {
        private LinkedList<KhachSan> khachSan;

        public QLKS() {
                this.khachSan = new LinkedList<>();
        }

        public LinkedList<KhachSan> getKhachSan() {
                return khachSan;
        }

        public void setKhachSan(LinkedList<KhachSan> khachSan) {
                this.khachSan = khachSan;
        }

        public void themKhach(KhachSan khachMoi) {
                this.khachSan.add(khachMoi);
                khachMoi.setNgayTraPhong();
                if (khachMoi.getLoaiPhong().equals("A"))
                        khachMoi.setGiaA();
                else if (khachMoi.getLoaiPhong().equals("B"))
                        khachMoi.setGiaB();
                else
                        khachMoi.setGiaC();
        }

        public void hienThiDanhSachKhachSan() {
                this.khachSan.forEach(ks -> System.out.println(ks.toString()));
        }

        public boolean xoaKhach(int khachXoa) {
                if (locCMND(khachXoa) != null) {
                        this.khachSan.remove(locCMND(khachXoa));
                        return true;
                }
                return false;
        }

        public void luuFile() {
                File file = new File(
                                "D:\\Code\\JAVA\\VSCode\\Luyen Tap\\BaiTapHuongDoiTuong\\QuanLyKhachSan\\test.txt");
                try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(khachSan);
                        oos.flush();
                        oos.close();
                } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                }
                System.out.println("Đã lưu thành công!");
        }

        public void docFile() {
                File file = new File(
                                "D:\\Code\\JAVA\\VSCode\\Luyen Tap\\BaiTapHuongDoiTuong\\QuanLyKhachSan\\test.txt");
                try {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                        while (true) {
                                this.khachSan = (LinkedList<KhachSan>) ois.readObject();
                                if (this.khachSan == null)
                                        break;
                        }
                        ois.close();
                } catch (Exception e) {
                        // TODO: handle exception
                }
                this.khachSan.forEach(ks -> ks.setThoiGianConLai());
        }

        public String locPhong(String loaiPhong) {
                // Lấy chữ cuối trong loại phòng;
                String lp = loaiPhong.substring(loaiPhong.lastIndexOf(" ") + 1, loaiPhong.length());
                lp = lp.toUpperCase();
                if (lp.equals("A") || lp.equals("B") || lp.equals("C")) {
                        return lp;
                } else
                        return null;
        }

        public KhachSan locCMND(int CMND) {
                for (KhachSan ks : this.khachSan) {
                        if (CMND == ks.getNguoi().getSoCMND())
                                return ks;
                }
                return null;
        }
}
