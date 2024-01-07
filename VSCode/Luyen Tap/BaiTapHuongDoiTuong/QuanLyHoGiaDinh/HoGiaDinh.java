package QuanLyHoGiaDinh;

import java.io.Serializable;
import java.util.LinkedList;

public class HoGiaDinh implements Serializable {
        private int soThanhVien, soNha;
        private LinkedList<Nguoi> nguoi;
        private static final long serialVersionUID = 2;

        public HoGiaDinh() {
        }

        public HoGiaDinh(int soThanhVien, int soNha) {
                this.soThanhVien = soThanhVien;
                this.soNha = soNha;
                this.nguoi = new LinkedList<>();
        }

        public int getSoThanhVien() {
                return soThanhVien;
        }

        public void setSoThanhVien(int soThanhVien) {
                this.soThanhVien = soThanhVien;
        }

        public int getSoNha() {
                return soNha;
        }

        public void setSoNha(int soNha) {
                this.soNha = soNha;
        }

        @Override
        public String toString() {
                return "HoGiaDinh [soThanhVien=" + soThanhVien + ", soNha=" + soNha + "]";
        }

        public LinkedList<Nguoi> getNguoi() {
                return nguoi;
        }

        public void setNguoi(LinkedList<Nguoi> nguoi) {
                this.nguoi = nguoi;
        }

        // Thêm người vào hộ gia đình
        public boolean themNguoi(Nguoi nguoi, KhuPho khuPho) {
                if (kiemTraCMND(nguoi, khuPho)) {
                        this.nguoi.add(nguoi);
                        return true;
                } else {
                        System.out.println("Không thể thêm người!");
                        return false;
                }
        }

        public boolean kiemTraCMND(Nguoi nguoi, KhuPho khuPho) {
                for (HoGiaDinh hgd : khuPho.getHoGiaDinh()) { // Duyệt từng hộ gia đình ĐÃ CÓ trong khu phố
                        for (Nguoi ng : hgd.getNguoi()) { // Duyệt từng thành viên trong gia đình
                                if (ng.getCMND() == nguoi.getCMND()) // Nếu trùng số CMND
                                        return false;
                        }
                }
                return true;
        }
}
