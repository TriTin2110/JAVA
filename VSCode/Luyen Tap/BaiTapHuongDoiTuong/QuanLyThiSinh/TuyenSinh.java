package QuanLyThiSinh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class TuyenSinh {
        private LinkedList<ThiSinh> dsts;

        public TuyenSinh() {
                this.dsts = new LinkedList<>();
        }

        public LinkedList<ThiSinh> getDsts() {
                return dsts;
        }

        public void setDsts(LinkedList<ThiSinh> dsts) {
                this.dsts = dsts;
        }

        public void themThiSinh(ThiSinh thiSinhMoi) {
                if (kiemTraSoBaoDanh(thiSinhMoi) == null) {
                        this.dsts.add(thiSinhMoi);
                } else
                        System.out.println("Không thể thêm thí sinh!");
        }

        public void hienThiDanhSachThiSinh() {
                this.dsts.forEach(ds -> System.out.println(ds.toString()));
        }

        public ThiSinh timKiemTheoMa(ThiSinh thiSinh) {
                if (kiemTraSoBaoDanh(thiSinh) != null)
                        return kiemTraSoBaoDanh(thiSinh);
                else
                        return null;

        }

        public void luuDanhSachThiSinh() {
                File file = new File(
                                "D:\\Code\\JAVA\\VSCode\\Luyen Tap\\BaiTapHuongDoiTuong\\QuanLyThiSinh\\DanhSachThiSinh.txt");
                if (!file.exists()) {
                        try {
                                file.createNewFile();
                        } catch (Exception e) {
                                // TODO: handle exception
                                e.printStackTrace();
                        }
                } else {
                        try {
                                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                                this.dsts.forEach(ts -> {
                                        try {
                                                oos.writeObject(ts);
                                                oos.flush();
                                        } catch (IOException e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                        }
                                });
                                oos.close();
                        } catch (Exception e) {
                                // TODO: handle exception
                                e.printStackTrace();
                        }

                }
        }

        // Đọc danh sách thí sinh
        public void docDanhSachThiSinh() {
                File file = new File(
                                "D:\\Code\\JAVA\\VSCode\\Luyen Tap\\BaiTapHuongDoiTuong\\QuanLyThiSinh\\DanhSachThiSinh.txt");
                try {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                        ThiSinh thiSinh = null;
                        while (true) {
                                thiSinh = (ThiSinh) ois.readObject();
                                this.dsts.add(thiSinh);
                                if (thiSinh == null)
                                        break;
                        }
                        ois.close();
                } catch (Exception e) {
                        // TODO: handle exception
                }
        }

        public ThiSinh kiemTraSoBaoDanh(ThiSinh thiSinh) {
                for (ThiSinh ds : dsts) {
                        if (thiSinh.getSoBaoDanh() == ds.getSoBaoDanh()) {
                                return ds;
                        }
                }
                return null;
        }
}
