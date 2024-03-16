package QuanLyHoGiaDinh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class KhuPho {
        LinkedList<HoGiaDinh> hoGiaDinh;

        public KhuPho() {
                this.hoGiaDinh = new LinkedList<>();
        }

        public LinkedList<HoGiaDinh> getHoGiaDinh() {
                return hoGiaDinh;
        }

        public void setHoGiaDinh(LinkedList<HoGiaDinh> hoGiaDinh) {
                this.hoGiaDinh = hoGiaDinh;
        }

        // Thêm hộ gia đình vào khu phố
        public boolean themHoGiaDinh(HoGiaDinh hoGiaDinhMoi) {
                if (kiemTraSoNha(hoGiaDinhMoi)) {
                        this.hoGiaDinh.add(hoGiaDinhMoi);
                        return true;
                } else {
                        System.out.println("Không thể thêm hộ gia đình mới do trùng số nhà!");
                        return false;
                }
        }

        public void hienThiHoGiaDinh() {
                hoGiaDinh.forEach(giaDinh -> {
                        System.out.println(giaDinh.toString());
                        giaDinh.getNguoi().forEach(ng -> System.out.println(ng.toString()));
                        System.out.println("\n---------------------------------\n");
                });
        }

        public boolean kiemTraSoNha(HoGiaDinh hoGiaDinhMoi) {
                for (HoGiaDinh hgd : this.getHoGiaDinh()) {
                        if (hgd.getSoNha() == hoGiaDinhMoi.getSoNha())
                                return false;
                }
                return true;
        }

        public void luuKetQua() {
                File file = new File(
                                "D:\\Code\\JAVA\\VSCode\\Luyen Tap\\BaiTapHuongDoiTuong\\QuanLyHoGiaDinh\\dataHoGiaDinh.txt");
                try {
                        if (!file.exists())
                                file.createNewFile();
                } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                }
                try {
                        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(hoGiaDinh);
                        oos.flush();
                        oos.close();
                } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                }
        }

        public void docKetQua() {
                File file = new File(
                                "D:\\Code\\JAVA\\VSCode\\Luyen Tap\\BaiTapHuongDoiTuong\\QuanLyHoGiaDinh\\dataHoGiaDinh.txt");
                try {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                        while (true) {
                                hoGiaDinh = (LinkedList<HoGiaDinh>) ois.readObject(); // Ép kiểu cho hoGiaDinh là
                                                                                      // LinkedList
                                if (hoGiaDinh == null)
                                        break;
                        }
                        ois.close();
                } catch (Exception e) {
                        // TODO: handle exception
                }
        }
}
