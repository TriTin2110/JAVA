package LamLai.DanhSachSinhVien;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class DanhSachSinhVien {
        LinkedList<SinhVien> dssv = new LinkedList<SinhVien>();

        public DanhSachSinhVien() {
        }

        // Kiểm tra mã số sinh viên
        /**
         * kiemTraMaSoSinhVien(SinhVien sinhVien
         */
        public boolean kiemTraMaSoSinhVien(int sv) {
                boolean check = false;
                out: for (SinhVien sinhVien : dssv) {
                        if (sinhVien.getMaSinhVien() == sv) {
                                System.out.println("Mã số sinh viên đã có trong danh sách!");
                                check = true;
                                break out;
                        }
                }
                return check;
        }

        // Thêm sinh viên
        /**
         * themSinhVien(SinhVien sv)
         */
        public void themSinhVien(SinhVien sv) {
                this.dssv.add(sv);
        }

        // In danh sách sinh viên
        /**
         * inDanhSachSinhVien()
         */
        public void inDanhSachSinhVien() {
                for (SinhVien sinhVien : dssv) {
                        System.out.println(sinhVien);
                }

        }

        // Kiểm tra danh sách sinh viên có rỗng hay không
        /**
         * kiemTraDanhSachCoRongHayKhong
         */
        public boolean kiemTraDanhSachCoRongHayKhong() {
                return this.dssv.isEmpty();
        }

        // Làm rỗng danh sách sinh viên
        /**
         * lamRongDanhSachSinhVien()
         */
        public void lamRongDanhSachSinhVien() {
                this.dssv.clear();
        }

        // Xóa sinh viên theo mã sinh viên
        /**
         * xoaSinhVienTheoMa(SinhVien sinhVien)
         */
        public void xoaSinhVienTheoMa(SinhVien sinhVien) {
                this.dssv.remove(sinhVien);
        }

        // Tìm kiếm sinh viên theo mã sinh viên
        /**
         * timKiemSinhVienTheoMaSinhVien()
         */
        public void timKiemSinhVienTheoMaSinhVien(SinhVien sVien) {
                for (SinhVien sinhVien : dssv) {
                        if (sinhVien.equals(sVien)) {
                                System.out.println(sinhVien);
                        }
                }

        }

        // Sắp xếp sinh viên theo tên
        /**
         * sapXepSinhVienTheoTen()
         */
        public void sapXepSinhVienTheoTen() {
                Collections.sort(dssv, new Comparator<SinhVien>() {

                        @Override
                        public int compare(SinhVien o1, SinhVien o2) {
                                // TODO Auto-generated method stub
                                if (o1.layTenSinhVien().compareTo(o2.layTenSinhVien()) > 0) {
                                        return 1;
                                } else if (o1.layTenSinhVien().compareTo(o2.layTenSinhVien()) < 0) {
                                        return -1;
                                } else
                                        return 0;
                        }

                });
        }

        // Sắp xếp sinh viên theo điểm
        /**
         * sapXepSinhVienTheoMaSo()
         */
        public void sapXepSinhVienTheoDiem() {
                Collections.sort(dssv, new Comparator<SinhVien>() {

                        @Override
                        public int compare(SinhVien o1, SinhVien o2) {
                                // TODO Auto-generated method stub
                                if (o1.getDiemTB() > o2.getDiemTB()) {
                                        return 1;
                                } else if (o1.getDiemTB() < o2.getDiemTB()) {
                                        return -1;
                                } else
                                        return 0;
                        }

                });

        }

        // Lưu danh sách sinh viên
        /**
         * luuDanhSachSinhVien(File file)
         */
        public void luuDanhSachSinhVien(File file) {

                try {
                        OutputStream os = new FileOutputStream(file);
                        ObjectOutputStream oos = new ObjectOutputStream(os);
                        for (SinhVien sinhVien : dssv) {
                                oos.writeObject(sinhVien);
                        }
                        oos.flush();
                        oos.close();
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
        }

        /**
         * docDanhSachSinhVien(File file)
         */
        public void docDanhSachSinhVien(File file) {
                try {
                        InputStream is = new FileInputStream(file);
                        ObjectInputStream ois = new ObjectInputStream(is);
                        SinhVien sv = null;
                        while (true) {
                                Object obj = ois.readObject();
                                sv = (SinhVien) obj;
                                if (sv == null)
                                        break;
                                else
                                        dssv.add(sv);

                        }
                        ois.close();
                } catch (Exception e) {
                        // TODO: handle exception
                }
        }
}
